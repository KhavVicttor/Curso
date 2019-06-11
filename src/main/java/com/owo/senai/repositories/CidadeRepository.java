package com.owo.senai.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.owo.senai.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	//Jpa fará todo o serviço de insert, delete, update, etc.
	//Veja que toda busca de Cliente e o Integer e que tipo do nosso id e Integer
	//Veja que é uma interface que extende os recursos do JPA.

}
