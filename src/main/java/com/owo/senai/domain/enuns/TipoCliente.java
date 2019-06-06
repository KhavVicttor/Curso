package com.owo.senai.domain.enuns;

public enum TipoCliente {
	// Será o estático
	PESSOAFÍSICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");
	// Atributos
	private int cod;
	private String descricao;

	// Construtor
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// Getters
	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values())
			if (cod.equals(x.getCod())) {
				return x;
			}
		throw new IllegalArgumentException("Id Inválido!" + cod);
	}
}
