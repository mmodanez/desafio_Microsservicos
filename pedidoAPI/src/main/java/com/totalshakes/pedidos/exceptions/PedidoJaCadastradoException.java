package com.totalshakes.pedidos.exceptions;

public class PedidoJaCadastradoException extends Exception {
    @Override
    public String getMessage() {
        return "Ja existe um pedido com este id.";
    }
}
