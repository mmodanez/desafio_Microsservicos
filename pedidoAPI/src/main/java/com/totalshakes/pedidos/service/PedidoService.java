package com.totalshakes.pedidos.service;

import com.totalshakes.pedidos.dto.PedidoDTO;
import com.totalshakes.pedidos.exceptions.NaoExistemPedidosException;
import com.totalshakes.pedidos.exceptions.PedidoNaoEncontradoException;
import com.totalshakes.pedidos.model.Pedido;

import java.util.List;

public interface PedidoService {
    void savePedido();

    PedidoDTO findPedidoById(long id) throws PedidoNaoEncontradoException;

    List<Pedido> findAllPedidos() throws NaoExistemPedidosException;

    void updatePedido(long id, PedidoDTO pedidoDTO) throws PedidoNaoEncontradoException;

    void deletePedidoById(long id) throws PedidoNaoEncontradoException;
}
