package com.totalshakes.pagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

//TODO - @Validation


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long id;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "nome")
    private String nome;

    @Column(name = "numero")
    private String numero;

    @Column(name = "expiracao")
    private String expiracao;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "status_pedido")
    private Status status;

    @Column(name = "id_pedido")
    private Long pedidoId;

    @Column(name = "forma_de_pagamento")
    private FormaDePagamento formaDePagamento;
}
