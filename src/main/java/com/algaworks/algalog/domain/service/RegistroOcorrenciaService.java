package com.algaworks.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {
	
	private BuscaEntregaService buscaEntregaService;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
//		Entrega entrega = entregaRepository.findById(entregaId)
//				.orElseThrow(() -> new NegocioException("Entrega não encontrada"));		
		Entrega entrega = buscaEntregaService.buscar(entregaId);
		return entrega.addcionarOcorrencia(descricao);		
	}
	
}
