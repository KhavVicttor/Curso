package com.owo.senai.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.owo.senai.domain.Cliente;
import com.owo.senai.services.ClienteService;

@RestController // Para serem Serializados e transformados em Json ou Xml
@RequestMapping(value = "/clientes") // caminho que será encontrado
public class ClienteResource {
	// Buscando os métodos que estão em Cliente Service
	@Autowired // Faz a instanciação sem precisar do new
	private ClienteService service;

	// Neste Request pediremos o id do Cliente
	// Method requesitado é o get
	// Resposta da entidade será do Cliente em Domain
	// Find é encontrar
	// @PathVariable - O valor vira da URL
	// obj - service (ClienteService metodo buscar)
	// Retorna no corpo do objeto todas as informações
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> find(@PathVariable Integer id) {
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
	List<Cliente> list = service.findAll();
	return ResponseEntity.ok().body(list);

	public Cliente insert(Cliente obj) {
		obj.setIdCliente(null);
		obj = repo.save(obj);

		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdCliente()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
