package com.totalshakes.pagamentos.exceptions;

public class NaoHaPagamentosException extends Exception{
    @Override
    public String getMessage() {
        return "Não há pagamentos registrados";
    }
}
