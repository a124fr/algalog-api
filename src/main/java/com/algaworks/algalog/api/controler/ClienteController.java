package com.algaworks.algalog.api.controler;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
