package com.totalshakes.pedidos;

import com.totalshakes.pedidos.controller.PedidoController;
import com.totalshakes.pedidos.dto.ItemPedidoDTO;
import com.totalshakes.pedidos.dto.PedidoDTO;
import com.totalshakes.pedidos.exceptions.PedidoJaCadastradoException;
import com.totalshakes.pedidos.model.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TotalShakeMicroservicesApplicationPedidosAPITests {

    @Autowired
    PedidoController pedidoController;

    @Test
    void contextLoads() {
    }

    @Test
    void testSavePedidoProperly() throws PedidoJaCadastradoException {
        PedidoDTO pedidoDTO = new PedidoDTO();
        List<ItemPedidoDTO> itens = new ArrayList<>();
        ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();

        itemPedidoDTO.setId(1L);
        itemPedidoDTO.setDescricao("Shake 1");
        itemPedidoDTO.setQuantidade(2);


        itens.add(itemPedidoDTO);

        pedidoDTO.setId(1L);
        pedidoDTO.setItensDTO(itens);
        pedidoDTO.setStatus(Status.REALIZADO);

        ResponseEntity pedidoSalvo = pedidoController.savePedido(pedidoDTO);

        assertEquals(HttpStatus.CREATED, pedidoSalvo.getStatusCode());
    }

}
