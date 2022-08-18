package com.totalshakes.pedidos.exceptions;

public class PedidoNaoEncontradoException extends Exception{
    @Override
    public String getMessage() {
        return "Pedido nao encontrado.";
    }
}
