package com.totalshakes.pagamentos.controller;

import com.totalshakes.pagamentos.dto.PagamentoDTO;
import com.totalshakes.pagamentos.model.Pagamento;
import com.totalshakes.pagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<HttpStatus> savePagamento(@Valid @RequestBody PagamentoDTO pagamentoDTO) {
        pagamentoService.savePagamento(pagamentoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PagamentoDTO> findPagamentoById(@RequestBody @PathVariable long id) {
        PagamentoDTO pagamentoById = pagamentoService.findPagamentoById(id);
        return new ResponseEntity<>(pagamentoById, HttpStatus.OK);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Pagamento>> findAllPagamentos() {
        List<Pagamento> allPagamentos = pagamentoService.findAllPagamentos();
        return new ResponseEntity<>(allPagamentos, HttpStatus.OK);
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
