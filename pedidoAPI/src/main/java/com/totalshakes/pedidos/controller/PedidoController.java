package com.totalshakes.pedidos.controller;

import com.totalshakes.pedidos.dto.PedidoDTO;
import com.totalshakes.pedidos.exceptions.NaoExistemPedidosException;
import com.totalshakes.pedidos.exceptions.PedidoNaoEncontradoException;
import com.totalshakes.pedidos.model.Pedido;
import com.totalshakes.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<HttpStatus> savePedido() {
        pedidoService.savePedido();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PedidoDTO> findPedidoById(@Valid @RequestBody @PathVariable long id) throws PedidoNaoEncontradoException {
        PedidoDTO pedidoById = pedidoService.findPedidoById(id);
        return new ResponseEntity<>(pedidoById, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Pedido>> findAllPedidos() throws NaoExistemPedidosException {
        List<Pedido> allPedidos = pedidoService.findAllPedidos();
        return new ResponseEntity<>(allPedidos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<HttpStatus> updatePedido(@Valid @RequestBody PedidoDTO pedidoDTO, @PathVariable long id) throws PedidoNaoEncontradoException {
        pedidoService.updatePedido(id, pedidoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePedido(@Valid @RequestBody @PathVariable long id) throws PedidoNaoEncontradoException {
        pedidoService.deletePedidoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}