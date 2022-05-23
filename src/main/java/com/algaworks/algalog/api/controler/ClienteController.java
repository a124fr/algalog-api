package com.algaworks.algalog.api.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor // anotação vai gerar um construtor com todas as proprieddes que temos na nossa classe
@RestController
public class ClienteController {
	
	private ClienteRepository clienteRepository;
			
	@GetMapping("/clientes")
	public List<Cliente> listar() {			
		return clienteRepository.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable("id") Long clienteId) {		
//		Optional<Cliente> cliente =  clienteRepository.findById(clienteId);		
//		if (cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}		
//		return ResponseEntity.notFound().build();
//		return clienteRepository.findById(clienteId)
//				.map(cliente -> ResponseEntity.ok(cliente))
//				.orElse(ResponseEntity.notFound().build());
		return clienteRepository.findById(clienteId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
}
