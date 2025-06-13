package com.br.blueticket.domain.model;

public enum StatusSessao {

	ATIVO("ativo"),
	EXPIRADO("expirado");
	
	private String description;
	
	private StatusSessao(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
