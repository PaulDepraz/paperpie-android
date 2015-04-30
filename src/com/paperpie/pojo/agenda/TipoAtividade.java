package com.paperpie.pojo.agenda;

import java.io.Serializable;

public class TipoAtividade implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5468442880580367913L;
	private int id;
	private String nome;
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
