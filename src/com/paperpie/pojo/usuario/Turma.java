package com.paperpie.pojo.usuario;


import java.io.Serializable;

public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029578671690644513L;
	private int id;
	private String nome;
	private double ano;
	private int anoLetivo;

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

	public double getAno() {
		return ano;
	}

	public void setAno(double ano) {
		this.ano = ano;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}


}
