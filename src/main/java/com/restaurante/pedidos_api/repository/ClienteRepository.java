package com.restaurante.pedidos_api.repository;

import com.restaurante.pedidos_api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

