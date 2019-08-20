package com.bureaucep.entify;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LOG")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Log implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "L_CD_LOG")
	private Long id;

	@Column(length = 2000, name = "L_REQUEST")
	@NotBlank(message = "Request não pode ser nula ou vazia")
	private String request;

	@Column(length = 2000, name = "L_RESPONSE")
	@NotBlank(message = "Response não pode ser nula ou vazia")
	private String response;

	@Column(name = "L_DATA_INICIAL")
	@NotNull
	private LocalDate dtIncl;
}
