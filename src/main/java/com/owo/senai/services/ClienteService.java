package com.owo.senai.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owo.senai.domain.Cliente;
import com.owo.senai.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	//Veja que está instanciado de Repositore que tem DML
	//Repo - abaixo - é o objeto criado
	@Autowired //Faz a instância para mim sem o new.
	private ClienteRepository repo;
	
	//Metodo que faz a busca de cliente
	public Cliente buscar(Integer idCliente) {
		Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElse(null);
		
	}

}
