package br.com.bureaucep.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureaucep.builder.CepResponseBuilder;
import br.com.bureaucep.model.Cep;
import br.com.bureaucep.repository.CepRepository;
import br.com.bureaucep.request.CepRequest;
import br.com.bureaucep.response.CepResponse;
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
}
