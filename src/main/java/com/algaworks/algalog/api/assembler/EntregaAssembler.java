package com.algaworks.algalog.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.EntregaDto;
import com.algaworks.algalog.api.model.input.EntregaInput;
import com.algaworks.algalog.domain.model.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaAssembler {
		
	private ModelMapper modelmapper;
	
	public EntregaDto toModel(Entrega entrega) {
		return modelmapper.map(entrega, EntregaDto.class);
	}
	
	public List<EntregaDto> toCollectionModel(List<Entrega> entregas) {
		return entregas.stream()
				.map(this::toModel)
				.toList();				
	}
	
	public Entrega toEntity(EntregaInput entregaInput) {
		return modelmapper.map(entregaInput, Entrega.class);
	}
}
