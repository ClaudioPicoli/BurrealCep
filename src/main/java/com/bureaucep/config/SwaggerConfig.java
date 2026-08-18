package com.bureaucep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
       return new OpenAPI()
               .info(new Info()
                       .title("Cep Service")
                       .description("Obtenção de CEP com logs e integrações externas")
                       .version("1.0.0")
                       .contact(new Contact()
                               .name("ClaudioPicoli")
                               .url("https://github.com")
                               .email("")));
    }
}
