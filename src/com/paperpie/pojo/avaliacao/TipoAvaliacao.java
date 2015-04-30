package com.paperpie.pojo.avaliacao;

import java.io.Serializable;

/**
 * @author LordVader
 *
 */
public class TipoAvaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 785880391477362609L;
	private int id;
	private String nome;
	
	public TipoAvaliacao(int id, String nome) {
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
