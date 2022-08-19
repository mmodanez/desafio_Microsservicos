package com.totalshakes.pagamentos.service;

import com.totalshakes.pagamentos.common.CommonExtensions;
import com.totalshakes.pagamentos.dto.PagamentoDTO;
import com.totalshakes.pagamentos.exceptions.NaoHaPagamentosException;
import com.totalshakes.pagamentos.exceptions.PagamentoNaoEncontradoException;
import com.totalshakes.pagamentos.model.Pagamento;
import com.totalshakes.pagamentos.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoServiceImplementation extends CommonExtensions implements PagamentoService {
    private PagamentoRepository pagamentoRepository;

    public PagamentoServiceImplementation(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Override
    public void savePagamento(PagamentoDTO pagamentoDTO) {

        Pagamento pagamento = super.convertToModel(pagamentoDTO, Pagamento.class);
        pagamentoRepository.save(pagamento);
    }

    @Override
    public PagamentoDTO findPagamentoById(long id) throws PagamentoNaoEncontradoException {
        if (!pagamentoRepository.findById(id).isPresent())
            throw new PagamentoNaoEncontradoException();

        return super.convertToDTO(pagamentoRepository.findById(id).get(),
                PagamentoDTO.class);
    }

    @Override
    public List<Pagamento> findAllPagamentos() throws NaoHaPagamentosException {
        if (pagamentoRepository.findAll().isEmpty())
            throw new NaoHaPagamentosException();

        List<Pagamento> listaPagamentos = pagamentoRepository.findAll();
        listaPagamentos.stream().map(pagamento -> (super.convertToDTO(pagamento, PagamentoDTO.class)));

        return listaPagamentos;
    }

    @Override
    public void updatePagamento(long id, PagamentoDTO pagamentoDTO) {

        Pagamento pagamento = super.convertToModel(pagamentoDTO, Pagamento.class);
        pagamentoRepository.save(pagamento);
    }

    @Override
    public void deletePagamentoById(long id) throws PagamentoNaoEncontradoException {
        if (!pagamentoRepository.findById(id).isPresent())
            throw new PagamentoNaoEncontradoException();
        pagamentoRepository.deleteById(id);
    }
}
