package com.bureaucep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaucep.request.CepRequest;
import com.bureaucep.response.CepResponse;
import com.bureaucep.service.CepService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/contact")
@Api(tags = "Obtenção Cep")
public class ContactController {

	@Autowired
	private CepService cepService;

	@PostMapping(path = "/obterCep")
	@ApiOperation(value = "Obtenção Cep", notes = "Salva log de requisição")
	public ResponseEntity<CepResponse> obtemCep(final @RequestBody CepRequest cepRequest) throws NotFoundException {

		return new ResponseEntity<>(cepService.obtemCep(cepRequest), HttpStatus.OK);
	}
	
	//Metodo de teste, retirar no futuro.
	@PostMapping(path = "/inserirCep")
	@ApiOperation(value = "Insere cep para teste")
	public ResponseEntity<CepResponse> insereTeste(final @RequestBody CepRequest cepRequest) {

		return new ResponseEntity<>(cepService.insere(cepRequest), HttpStatus.OK);
	}

}
