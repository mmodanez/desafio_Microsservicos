package com.totalshakes.pedidos.controller;

import com.totalshakes.pedidos.dto.PedidoDTO;
import com.totalshakes.pedidos.exceptions.NaoExistemPedidosException;
import com.totalshakes.pedidos.exceptions.PedidoJaCadastradoException;
import com.totalshakes.pedidos.exceptions.PedidoNaoEncontradoException;
import com.totalshakes.pedidos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//TODO - retorna o body
@RestController
@RequestMapping("/api/v1/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<HttpStatus> savePedido(@Valid @RequestBody PedidoDTO pedidoDTO) throws PedidoJaCadastradoException {
        pedidoService.savePedido(pedidoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> findPedidoById(@Valid @RequestBody @PathVariable long id) throws PedidoNaoEncontradoException {
        pedidoService.findPedidoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<HttpStatus> findAllPedidos() throws NaoExistemPedidosException {
        pedidoService.findAllPedidos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
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
