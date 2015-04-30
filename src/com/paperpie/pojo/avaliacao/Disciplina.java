package com.paperpie.pojo.avaliacao;

import java.io.Serializable;

public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3392875419462827266L;
	private int id;
	private String nome;
	
	public Disciplina(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
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

	
}

