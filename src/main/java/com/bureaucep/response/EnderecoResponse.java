package com.bureaucep.response;

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
public class EnderecoResponse {

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
	private String dataIncl;
	
    @Override
    public String toString() {
        return "Endereco{" +
                "cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", unidade='" + unidade + '\'' +
                ", ibge='" + ibge + '\'' +
                ", gia='" + gia + '\'' +
                ", dataIncl='" + dataIncl + '\'' +
                '}';
    }

}
