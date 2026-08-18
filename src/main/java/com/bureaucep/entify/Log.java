package com.bureaucep.entify;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	private LocalDateTime dtIncl;
}
