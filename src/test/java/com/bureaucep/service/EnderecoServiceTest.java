package com.bureaucep.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.bureaucep.AbstractRestTest;
import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;

public class EnderecoServiceTest extends AbstractRestTest {

    private static final String CEP = "29148351";

    @Autowired
    private EnderecoService enderecoService;

    @MockBean
    private LogService logService;

    private final EnderecoRequest request = EnderecoRequest.builder().cep(CEP).build();

    @Test
    @Rollback
    public void obterCepTest() {
        EnderecoResponse retorno = enderecoService.obtemCep(request);

        assertThat(retorno).isNotNull();
        verify(logService).adicionaLog(request, retorno);
    }
}
