package com.mercado_solidario.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mercado_solidario.api.entity.FormasDePagamento;
import com.mercado_solidario.api.execption.EntidadeEmUsoExeption;
import com.mercado_solidario.api.execption.EntidadeNaoEncontradaExeption;
import com.mercado_solidario.api.repository.FormasDePagamentoRepository;

@Service
public class FormasDePagamentoServices {

	@Autowired 
	private FormasDePagamentoRepository formasDePagamentoRepository;
	
	public FormasDePagamento salvar(FormasDePagamento formasDePagamento) {
		return formasDePagamentoRepository.save(formasDePagamento);
	}
	
	public void excluir(Long Id){ 
		try {
			formasDePagamentoRepository.deleteById(Id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaExeption(
					String.format("Não existe cadastro das formas de pagamento de código %d", Id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExeption(
					String.format("Forma de pagamento de código %d não pode ser removida por estar em uso", Id));
		}
	}

}