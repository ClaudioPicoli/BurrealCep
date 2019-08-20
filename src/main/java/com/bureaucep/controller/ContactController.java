package com.bureaucep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;
import com.bureaucep.service.EnderecoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

@RestController
@RequestMapping("/contact")
@Api(tags = "Obtenção Cep")
public class ContactController {

	@Autowired
	private EnderecoService enderecoService;

	@PostMapping(path = "/obterCep")
	@ApiOperation(value = "Obtenção Cep", notes = "Salva log de requisição")
	public ResponseEntity<EnderecoResponse> obtemCep(final @RequestBody EnderecoRequest request)
			throws NotFoundException {

		return new ResponseEntity<>(enderecoService.obtemCep(request), HttpStatus.OK);
	}
}
