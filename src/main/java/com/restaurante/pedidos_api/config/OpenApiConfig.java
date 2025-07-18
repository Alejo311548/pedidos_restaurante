package com.restaurante.pedidos_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI pedidosOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pedidos API")
                        .version("1.0.0")
                        .description("API REST para la gestión de pedidos de restaurante a domicilio.")
                        .contact(new Contact()
                                .name("Alejandro Vargas Ocampo")
                                .email("alejandro.vargaso@udea.edu.co")
                        )
                );
    }
}
