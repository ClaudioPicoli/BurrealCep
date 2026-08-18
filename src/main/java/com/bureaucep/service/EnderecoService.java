package com.bureaucep.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Service;

import com.bureaucep.builder.EnderecoResponseBuilder;
import com.bureaucep.client.viacep.ViaCepClient;
import com.bureaucep.entify.Endereco;
import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;

import feign.FeignException;

@Service
public class EnderecoService {

    private static final int MAX_CONCURRENT_CALLS = 10;

    private final ViaCepClient viaCepClient;
    private final LogService logService;
    private final ExecutorService virtualExecutor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory());
    private final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_CALLS);

    public EnderecoService(ViaCepClient viaCepClient, LogService logService) {
        this.viaCepClient = viaCepClient;
        this.logService = logService;
    }

    public EnderecoResponse obtemCep(EnderecoRequest cepRequest) {
        try {
            semaphore.acquire();
            Future<EnderecoResponse> future = virtualExecutor.submit(() -> {
                try {
                    Endereco endereco = viaCepClient.buscaEnderecoPorCep(cepRequest.getCep());
                    EnderecoResponse response = EnderecoResponseBuilder.buildResponse(endereco);
                    logService.adicionaLog(cepRequest, response);
                    return response;
                } catch (FeignException e) {
                    if (e.status() == 404) {
                        throw new IllegalArgumentException("CEP não encontrado: " + cepRequest.getCep(), e);
                    }
                    throw e;
                }
            });
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Execução interrompida ao consultar o CEP.", e);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException runtimeException) {
                throw runtimeException;
            }
            throw new IllegalStateException("Erro ao consultar o CEP.", cause);
        } finally {
            semaphore.release();
        }
    }
}
