package br.com.bureaucep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bureaucep.builder.LogBuilder;
import br.com.bureaucep.repository.LogRepository;
import br.com.bureaucep.request.CepRequest;
import br.com.bureaucep.response.CepResponse;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;

	public void adicionaLog(CepRequest request, CepResponse response) {

		logRepository.save(LogBuilder.buildLog(request.getCep(), response.toString()));
	}
}
