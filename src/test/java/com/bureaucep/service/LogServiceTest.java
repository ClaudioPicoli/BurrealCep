package com.bureaucep.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.bureaucep.AbstractRestTest;
import com.bureaucep.entify.Log;
import com.bureaucep.request.CepRequest;
import com.bureaucep.response.CepResponse;

import mockit.Mock;
import mockit.MockUp;

public class LogServiceTest extends AbstractRestTest {

	private static final String CEP = "29148351";

	@Autowired
	private LogService logService;

	@Before
	public void setUp() throws Exception {
		new MockUp<LocalDate>() {
			@Mock
			public LocalDate now() {
				return LocalDate.of(2019, 07, 16);
			}
		};
	}

	@Test
	@Rollback
	public void adicionarLogTest() {

		CepRequest cepRequest = CepRequest.builder().cep(CEP).build();
		CepResponse cepResponse = new CepResponse();
		cepResponse.setCep(CEP);

		Log logRetorno = logService.adicionaLog(cepRequest, cepResponse);

		assertThat(logRetorno).isNotNull();

		assertEquals(cepRequest.getCep(), logRetorno.getRequest());
		assertEquals(cepResponse.toString(), logRetorno.getResponse());
		assertEquals(LocalDate.of(2019, 07, 16), logRetorno.getDtIncl());
	}
}
