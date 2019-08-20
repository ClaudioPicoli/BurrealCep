package com.bureaucep.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaucep.builder.CepResponseBuilder;
import com.bureaucep.entify.Cep;
import com.bureaucep.repository.CepRepository;
import com.bureaucep.request.CepRequest;
import com.bureaucep.response.CepResponse;

import javassist.NotFoundException;

@Service
public class CepService {

	@Autowired
	private CepRepository cepRepository;

	@Autowired
	LogService logService;

	public Cep findById(String cep) throws NotFoundException {

		Optional<Cep> optional = cepRepository.findById(cep);

		return optional.orElseThrow(() -> new NotFoundException("Cep não encontrado!"));

	}

	public CepResponse obtemCep(CepRequest cepRequest) throws NotFoundException {

		CepResponse cepResponse = CepResponseBuilder.buildCepResponse(findById(cepRequest.getCep()));

		logService.adicionaLog(cepRequest, cepResponse);

		return cepResponse;
	}

	// Metodo criado apenas para facilitar teste do sistema.
	public CepResponse insere(CepRequest cepRequest) {

		Cep cep = new Cep();
		cep.setCep(cepRequest.getCep());

		cep = cepRepository.save(cep);

		return CepResponseBuilder.buildCepResponse(cep);
	}
}
