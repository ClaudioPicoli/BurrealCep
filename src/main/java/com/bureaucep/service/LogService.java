package com.bureaucep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bureaucep.builder.LogBuilder;
import com.bureaucep.repository.LogRepository;
import com.bureaucep.request.CepRequest;
import com.bureaucep.response.CepResponse;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepository;

	public void adicionaLog(CepRequest request, CepResponse response) {

		logRepository.save(LogBuilder.buildLog(request.getCep(), response.toString()));
	}
}
