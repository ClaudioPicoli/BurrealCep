package br.com.bureaucep.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CepRequest {

	@JsonProperty("CEP")
	private String cep;
}
