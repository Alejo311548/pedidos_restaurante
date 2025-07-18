package com.restaurante.pedidos_api.controller;

import com.restaurante.pedidos_api.model.Cliente;
import com.restaurante.pedidos_api.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clientes", produces = "application/vnd.pedidos.v1+json")
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente creado = clienteRepository.save(cliente);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }
}
