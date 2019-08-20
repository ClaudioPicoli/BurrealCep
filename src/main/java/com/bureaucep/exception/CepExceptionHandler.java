package com.bureaucep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bureaucep.controller.ContactController;
import com.bureaucep.response.CepResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(assignableTypes = ContactController.class)
public class CepExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CepResponse> defaultExceptionHandle(Exception ex) {

		log.error(ex.getMessage());

		// Forma de retorno do erro deveria ser confirmada
		return new ResponseEntity<>(new CepResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
