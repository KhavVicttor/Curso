package com.owo.senai;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.owo.senai.domain.Cidade;
import com.owo.senai.domain.Cliente;
import com.owo.senai.domain.Endereco;
import com.owo.senai.domain.Estado;
import com.owo.senai.domain.enuns.TipoCliente;
import com.owo.senai.repositories.CidadeRepository;
import com.owo.senai.repositories.ClienteRepository;
import com.owo.senai.repositories.EnderecoRepository;
import com.owo.senai.repositories.EstadoRepository;

@SpringBootApplication
public class CursoSenaiApplication implements CommandLineRunner {
	// Uma dependência para instanciar todo o objeto.
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursoSenaiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Instancio estado e preencho
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		// Foi chamado acima e aqui salva.
		estadoRepository.saveAll(Arrays.asList(est1, est2));

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		cidadeRepository.saveAll(Arrays.asList(c1, c2));

		Cliente cli1 = new Cliente(null, "Crispim Luiz", "124354363", "owo@gmail.com", TipoCliente.PESSOAFÍSICA);
		Cliente cli2 = new Cliente(null, "Ricardão", "74574567", "UwU@gmail.com", TipoCliente.PESSOAFÍSICA);
		cli1.getTelefones().addAll(Arrays.asList("34101010101", "99191919191"));
		cli1.getTelefones().addAll(Arrays.asList("34555555555", "90404040404"));
		cli2.getTelefones().addAll(Arrays.asList("34574574576", "92323235325"));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));
		Endereco e1 = new Endereco(null, "Rua das Emboabas", "55b", "Ap 310", "Jardim", "23232323", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Alameda Nasciute", "234", null, "Centro", "12312412", cli2, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli1.getEnderecos().addAll(Arrays.asList(e2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

	}

}
