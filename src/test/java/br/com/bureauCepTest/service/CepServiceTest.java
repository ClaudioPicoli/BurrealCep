package br.com.bureauCepTest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import br.com.bureauCepTest.AbstractRestTest;
import br.com.bureaucep.model.Cep;
import br.com.bureaucep.repository.CepRepository;
import br.com.bureaucep.request.CepRequest;
import br.com.bureaucep.response.CepResponse;
import br.com.bureaucep.service.CepService;
import br.com.bureaucep.service.LogService;
import javassist.NotFoundException;
import mockit.Mock;
import mockit.MockUp;

public class CepServiceTest extends AbstractRestTest {

	private static final String CEP = "29148351";

	@Autowired
	private CepService cepService;

	@MockBean
	private CepRepository cepRepository;

	@MockBean
	private LogService logService;

	@Before
	public void setUp() throws Exception {

		when(cepRepository.findById(Mockito.anyString())).thenReturn(buildOptCepTest());

		new MockUp<LocalDate>() {
			@Mock
			public LocalDate now() {
				return LocalDate.of(2019, 07, 16);
			}
		};
	}

	@Test
	@Rollback
	public void obterCepTest() throws NotFoundException {

		CepRequest cepRequest = CepRequest.builder().cep(CEP).build();

		CepResponse retorno = cepService.obtemCep(cepRequest);

		assertThat(retorno).isNotNull();

		Mockito.verify(cepRepository).findById(cepRequest.getCep());
		Mockito.verify(logService).adicionaLog(cepRequest, retorno);
	}

	private Optional<Cep> buildOptCepTest() {
		return Optional.of(buildCepTest());
	}

	private Cep buildCepTest() {
		Cep cep = new Cep();
		cep.setCep(CEP);
		cep.setBairro("PIRANEMA");
		cep.setUf("ES");
		return cep;
	}
}
