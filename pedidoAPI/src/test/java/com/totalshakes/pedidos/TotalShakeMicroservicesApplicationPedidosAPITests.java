package com.totalshakes.pedidos;

import com.totalshakes.pedidos.controller.PedidoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TotalShakeMicroservicesApplicationPedidosAPITests {

    @Autowired
    PedidoController pedidoController;

    @Test
    void contextLoads() {
    }

}
