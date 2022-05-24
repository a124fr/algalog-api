package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long entregaId) {
		try {
			return entregaRepository.findById(entregaId).get();			
		} catch(Exception e) {
			throw new EntidadeNaoEncontradaException("Entrega não encontrada");
		}
	}
}
