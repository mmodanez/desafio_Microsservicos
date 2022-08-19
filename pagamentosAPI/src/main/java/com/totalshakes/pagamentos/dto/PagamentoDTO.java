package com.totalshakes.pagamentos.dto;

import com.totalshakes.pagamentos.model.FormaDePagamento;
import com.totalshakes.pagamentos.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private String codigo;

    private Status status;

    private Long pedidoId;

    private FormaDePagamento formaDePagamento;
}
