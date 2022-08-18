package com.totalshakes.pedidos.exceptions;

public class NaoExistemPedidosException extends Exception{
    @Override
    public String getMessage() {
        return "Nao existem pedidos cadastrados";
    }
}
