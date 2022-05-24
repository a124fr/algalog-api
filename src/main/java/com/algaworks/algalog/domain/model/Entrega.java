package com.algaworks.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;	
	
	@ManyToOne
//	@JoinColumn(name = "id_cliente") // caso queira especificar o nome da cluna no lado do modelo relacional da tabela é criado a coluna cliente_id
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;

	public Ocorrencia addcionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDescricao(descricao);
		ocorrencia.setDataRegistro(OffsetDateTime.now());
		ocorrencia.setEntrega(this);
		
		this.getOcorrencias().add(ocorrencia);
		return ocorrencia;
	}	
}
