package com.algaworks.algalog.api.controler;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNome("João");		
		cliente1.setEmail("joaodascouves@algworks.com");
		cliente1.setTelefone("34 99999-1111");
		
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNome("Maria");
		cliente2.setEmail("mariadasilva@algworks.com");
		cliente2.setTelefone("11 97777-2222");
		
		return Arrays.asList(cliente1, cliente2);
	}
	
}
