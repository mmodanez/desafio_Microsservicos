package com.totalshakes.pagamentos.service;

import com.totalshakes.pagamentos.model.Pagamento;
import com.totalshakes.pagamentos.dto.PagamentoDTO;

import java.util.List;

//TODO - erros/exceptions
public interface PagamentoService {

    void savePagamento(PagamentoDTO pagamentoDTO);

    PagamentoDTO findPagamentoById(long id);

    List<Pagamento> findAllPagamentos();

    void updatePagamento(long id, PagamentoDTO pagamentoDTO);

    void deletePagamentoById(long id);

}
