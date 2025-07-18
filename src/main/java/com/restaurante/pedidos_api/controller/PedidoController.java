package com.restaurante.pedidos_api.controller;

import com.restaurante.pedidos_api.model.Pedido;
import com.restaurante.pedidos_api.repository.PedidoRepository;
import com.restaurante.pedidos_api.repository.ClienteRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/pedidos", produces = "application/vnd.pedidos.v1+json")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoController(PedidoRepository pedidoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    public EntityModel<Pedido> getPedido(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado"));

        return EntityModel.of(pedido,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PedidoController.class).getPedido(id)).withSelfRel()
        );
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> crearPedido(@RequestBody Pedido pedido) {
        if (pedido.getCliente() == null || pedido.getCliente().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente debe estar definido");
        }

        clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no existe"));

        Pedido saved = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

