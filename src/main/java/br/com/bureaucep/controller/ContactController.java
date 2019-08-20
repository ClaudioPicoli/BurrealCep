package br.com.bureaucep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bureaucep.request.CepRequest;
import br.com.bureaucep.response.CepResponse;
import br.com.bureaucep.service.CepService;
import javassist.NotFoundException;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private CepService cepService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, path = "obterCEp")
	public ResponseEntity<CepResponse> obtemCep(final @RequestBody CepRequest cepRequest) throws NotFoundException {

		return new ResponseEntity<>(cepService.obtemCep(cepRequest), HttpStatus.OK);

	}

}
