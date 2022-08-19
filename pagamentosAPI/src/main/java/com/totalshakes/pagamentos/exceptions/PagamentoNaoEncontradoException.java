package com.totalshakes.pagamentos.exceptions;

public class PagamentoNaoEncontradoException extends Exception{
    @Override
    public String getMessage() {
        return "Pagamento não encontrado";
    }
}
