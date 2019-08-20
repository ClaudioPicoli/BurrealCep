package com.bureaucep.builder;

import com.bureaucep.entify.Endereco;
import com.bureaucep.response.EnderecoResponse;
import com.bureaucep.utils.DateUtils;

public class EnderecoResponseBuilder {

	public static EnderecoResponse buildResponse(Endereco endereco) {

		return EnderecoResponse.builder()
				.cep(endereco.getCep())
				.logradouro(endereco.getLogradouro())
				.complemento(endereco.getComplemento())
				.bairro(endereco.getBairro())
				.localidade(endereco.getLocalidade())
				.uf(endereco.getUf())
				.unidade(endereco.getUnidade())
				.ibge(endereco.getIbge())
				.gia(endereco.getGia())
				.dataIncl(DateUtils.DataAtualFormata())
				.build();
	}
}
