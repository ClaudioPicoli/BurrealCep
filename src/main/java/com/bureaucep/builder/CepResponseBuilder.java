package com.bureaucep.builder;

import com.bureaucep.entify.Cep;
import com.bureaucep.response.CepResponse;

public class CepResponseBuilder {

	public static CepResponse buildCepResponse(Cep cep) {

		return CepResponse.builder()
				.cep(cep.getCep())
				.logradouro(cep.getLogradouro())
				.complemento(cep.getComplemento())
				.bairro(cep.getBairro())
				.localidade(cep.getLocalidade())
				.uf(cep.getUf())
				.unidade(cep.getUnidade())
				.ibge(cep.getIbge())
				.gia(cep.getGia())
				.dataIncl(cep.getDataIncl()).build();
	}
}
