package com.totalshakes.pedidos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDTO {

    private Long id;

    private Integer quantidade;

    private String descricao;

    private PedidoDTO pedidoDTO;
}
