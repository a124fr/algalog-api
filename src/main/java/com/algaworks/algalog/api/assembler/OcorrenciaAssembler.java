package com.algaworks.algalog.api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.algaworks.algalog.api.model.OcorrenciaDto;
import com.algaworks.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {
	
	private ModelMapper modelMapper;
	
	public OcorrenciaDto toModel(Ocorrencia ocorrencia) {
		return modelMapper.map(ocorrencia, OcorrenciaDto.class);
	}
	
	public List<OcorrenciaDto> toCollectionModel(List<Ocorrencia> ocorrencias) {
		return ocorrencias.stream()
				.map(this::toModel)
				.toList();
	}
}
