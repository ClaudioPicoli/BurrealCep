package br.com.bureaucep.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CEP")
@Data
@EqualsAndHashCode(of = "cep")
public class Cep implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "C_CD_LOG")
	private String cep;

	@Column(name = "C_LOGRADOURO")
	private String logradouro;

	@Column(name = "C_COMPLEMENTO")
	private String complemento;

	@Column(name = "C_BAIRRO")
	private String bairro;

	@Column(name = "C_LOCALIDADE")
	private String localidade;

	@Column(name = "C_UF")
	private String uf;

	@Column(name = "C_UNIDADE")
	private String unidade;

	@Column(name = "C_IBGE")
	private String ibge;

	@Column(name = "C_GIA")
	private String gia;

	@Column(name = "C_DATE_INICIAL")
	private LocalDate dataIncl;

}
