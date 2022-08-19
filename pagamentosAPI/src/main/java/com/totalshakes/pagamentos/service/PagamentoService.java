package com.totalshakes.pagamentos.service;

import com.totalshakes.pagamentos.exceptions.NaoHaPagamentosException;
import com.totalshakes.pagamentos.exceptions.PagamentoNaoEncontradoException;
import com.totalshakes.pagamentos.model.Pagamento;
import com.totalshakes.pagamentos.dto.PagamentoDTO;

import java.util.List;

public interface PagamentoService {

    void savePagamento(PagamentoDTO pagamentoDTO);

    PagamentoDTO findPagamentoById(long id) throws PagamentoNaoEncontradoException;

    List<Pagamento> findAllPagamentos() throws NaoHaPagamentosException;

    void updatePagamento(long id, PagamentoDTO pagamentoDTO);

    void deletePagamentoById(long id) throws PagamentoNaoEncontradoException;

}
