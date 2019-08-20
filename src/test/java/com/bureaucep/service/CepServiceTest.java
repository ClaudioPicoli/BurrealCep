package com.bureaucep.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.bureaucep.AbstractRestTest;
import com.bureaucep.request.CepRequest;
import com.bureaucep.response.CepResponse;

import javassist.NotFoundException;

public class CepServiceTest extends AbstractRestTest {

	private static final String CEP = "29148351";

	@Autowired
	private CepService cepService;

	@MockBean
	private LogService logService;

	private CepRequest cepRequest = CepRequest.builder().cep(CEP).build();

	@Test
	@Rollback
	public void obterCepTest() throws NotFoundException {

		cepService.insere(cepRequest);

		CepResponse retorno = cepService.obtemCep(cepRequest);

		assertThat(retorno).isNotNull();

		Mockito.verify(logService).adicionaLog(cepRequest, retorno);
	}

	@Test(expected = NotFoundException.class)
	@Rollback
	public void obterCepInexistenetTest() throws NotFoundException {

		cepService.obtemCep(cepRequest);
	}
}
