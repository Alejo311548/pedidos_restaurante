package com.restaurante.pedidos_api.repository;

import com.restaurante.pedidos_api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
