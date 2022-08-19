package com.totalshakes.pedidos.dto;


import com.totalshakes.pedidos.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private LocalDateTime dataHora;

    private Status status;

}
