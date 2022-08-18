package com.totalshakes.pagamentos.controller;

import com.totalshakes.pagamentos.service.PagamentoService;
import com.totalshakes.pagamentos.dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<HttpStatus> savePagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        pagamentoService.savePagamento(pagamentoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HttpStatus> findPagamentoById(@RequestBody @PathVariable long id) {
        pagamentoService.findPagamentoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<HttpStatus> findAllPagamentos() {
        pagamentoService.findAllPagamentos();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updatePagamento(@RequestBody PagamentoDTO pagamentoDTO, @PathVariable long id) {
        pagamentoService.updatePagamento(id, pagamentoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePagamentoById(@RequestBody @PathVariable long id) {
        pagamentoService.deletePagamentoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
