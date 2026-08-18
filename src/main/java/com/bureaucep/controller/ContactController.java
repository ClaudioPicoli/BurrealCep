package com.bureaucep.controller;

import java.time.Duration;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bureaucep.request.EnderecoRequest;
import com.bureaucep.response.EnderecoResponse;
import com.bureaucep.service.EnderecoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contact")
@Tag(name = "Obtenção Cep")
public class ContactController {

    private static final Duration COOLDOWN = Duration.ofSeconds(10);

    private final EnderecoService enderecoService;
    private final StringRedisTemplate redisTemplate;

    public ContactController(EnderecoService enderecoService, StringRedisTemplate redisTemplate) {
        this.enderecoService = enderecoService;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping(path = "/obterCep")
    @Operation(summary = "Obtenção Cep", description = "Salva log de requisição")
    public ResponseEntity<EnderecoResponse> obtemCep(@RequestBody EnderecoRequest request) {
        String key = "cep:cooldown:" + request.getCep();
        Boolean acquired = redisTemplate.opsForValue().setIfAbsent(key, "1", COOLDOWN);

        if (Boolean.FALSE.equals(acquired)) {
            throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS,
                    "Solicitação repetida em menos de 10 segundos para o CEP informado.");
        }

        return ResponseEntity.ok(enderecoService.obtemCep(request));
    }
}
