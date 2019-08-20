package com.bureaucep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bureaucep.controller.ContactController;
import com.bureaucep.response.EnderecoResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(assignableTypes = ContactController.class)
public class CepExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<EnderecoResponse> defaultExceptionHandle(Exception ex) {

		log.error(ex.getMessage());

		return new ResponseEntity<>(new EnderecoResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
