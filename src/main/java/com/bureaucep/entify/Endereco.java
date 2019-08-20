package com.bureaucep.entify;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "cep")
@Builder
public class Endereco {

	private String cep;

	private String logradouro;

	private String complemento;

	private String bairro;

	private String localidade;

	private String uf;

	private String unidade;

	private String ibge;

	private String gia;
}