package com.bureaucep.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Service;

import com.bureaucep.builder.LogBuilder;
import com.bureaucep.entify.Log;
import com.bureaucep.repository.LogRepository;
import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;

@Service
public class LogService {

    private static final int MAX_CONCURRENT_CALLS = 10;

    private final LogRepository logRepository;
    private final ExecutorService virtualExecutor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory());
    private final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_CALLS);

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public Log adicionaLog(EnderecoRequest request, EnderecoResponse response) {
        try {
            semaphore.acquire();
            Future<Log> future = virtualExecutor.submit(() -> logRepository.save(LogBuilder.build(request.getCep(), response.toString())));
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Execução interrompida ao persistir o log.", e);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof RuntimeException runtimeException) {
                throw runtimeException;
            }
            throw new IllegalStateException("Erro ao persistir o log.", cause);
        } finally {
            semaphore.release();
        }
    }
}
