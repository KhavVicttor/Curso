package com.owo.senai.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owo.senai.domain.Cliente;
import com.owo.senai.exceptions.ObjectNotFoundException;
import com.owo.senai.repositories.ClienteRepository;

@Service
public class ClienteService {

	// Veja que está instanciado de Repositore que tem DML
	// Repo - abaixo - é o objeto criado
	@Autowired // Faz a instância para mim sem o new.
	private ClienteRepository repo;

	// Metodo que faz a busca de cliente por id
	public Cliente buscar(Integer idCliente) {
		/*
		 * Optional é para se vier sozinho não der erro NullPointException - Mas me
		 * traga uma mensagem de erro
		 */
		Optional<Cliente> obj = repo.findById(idCliente);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Número de id não encontrado. Id: " + idCliente + ", tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repo.findAll();

	}

	public @Valid Cliente insert(@Valid Cliente obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
