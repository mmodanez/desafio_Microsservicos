package com.totalshakes.pagamentos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @NotNull(message = "Valor não pode ser nulo")
    @PositiveOrZero
    @Column(name = "valor")
    private BigDecimal valor;

    @NotNull(message = "Nome não pode ser nulo")
    @NotEmpty
    @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
    @Column(name = "nome")
    private String nome;

    @NotEmpty
    @Size(max = 100, message = "Numero deve ter no máximo 100 caracteres")
    @Column(name = "numero")
    private String numero;

    @Column(name = "expiracao")
    private String expiracao;

    @NotEmpty
    @Size(min = 3, max = 3, message = "Código deve ter exatamente 3 caracteres")
    @Column(name = "codigo")
    private String codigo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status_pedido")
    private Status status;

    @Column(name = "id_pedido")
    private Long pedidoId;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_de_pagamento")
    private FormaDePagamento formaDePagamento;
}
