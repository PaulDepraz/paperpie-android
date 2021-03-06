package com.paperpie.pojo.usuario;

import java.io.Serializable;
import java.util.Calendar;

public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2577211303740943148L;
	private int id;
	private String nome;
	private Calendar dataNascimento;

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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
}
