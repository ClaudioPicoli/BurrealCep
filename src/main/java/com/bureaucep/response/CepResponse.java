package com.bureaucep.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CepResponse {

	@JsonProperty("CEP")
	private String cep;

	@JsonProperty("LOGRADOURO")
	private String logradouro;

	@JsonProperty("COMPLEMENTO")
	private String complemento;

	@JsonProperty("BAIRRO")
	private String bairro;

	@JsonProperty("LOCALIDADE")
	private String localidade;

	@JsonProperty("UF")
	private String uf;

	@JsonProperty("UNIDADE")
	private String unidade;

	@JsonProperty("IBGE")
	private String ibge;

	@JsonProperty("GIA")
	private String gia;

	@JsonProperty("DATA_INICIAL")
	private LocalDate dataIncl;

}
