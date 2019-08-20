package com.bureaucep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaucep.builder.EnderecoResponseBuilder;
import com.bureaucep.client.viacep.ViaCepClient;
import com.bureaucep.entify.Endereco;
import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;

import javassist.NotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private ViaCepClient viaCepClient;

	@Autowired
	LogService logService;

	public EnderecoResponse obtemCep(EnderecoRequest cepRequest) throws NotFoundException {

		Endereco endereco = viaCepClient.buscaEnderecoPorCep(cepRequest.getCep());
		EnderecoResponse response = EnderecoResponseBuilder.buildResponse(endereco);

		logService.adicionaLog(cepRequest, response);

		return response;
	}
}
