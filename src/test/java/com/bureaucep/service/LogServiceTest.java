package com.bureaucep.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bureaucep.AbstractRestTest;
import com.bureaucep.builder.EnderecoResponseBuilder;
import com.bureaucep.entify.Endereco;
import com.bureaucep.entify.Log;
import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;

public class LogServiceTest extends AbstractRestTest {

	private static final String CEP = "29148351";

	@Autowired
	private LogService logService;

	@Test
	@Rollback
	public void adicionarLogTest() {

		EnderecoRequest request = EnderecoRequest.builder().cep(CEP).build();
		EnderecoResponse response = EnderecoResponseBuilder.buildResponse(Endereco.builder().cep(CEP).build());

		Log logRetorno = logService.adicionaLog(request, response);

		assertThat(logRetorno).isNotNull();

		assertEquals(request.getCep(), logRetorno.getRequest());
		assertEquals(response.toString(), logRetorno.getResponse());
	}

	@Test(expected = ConstraintViolationException.class)
	@Rollback
	public void adicionarLogValoresNullTest() {

		logService.adicionaLog(new EnderecoRequest(), new EnderecoResponse());
	}
}
