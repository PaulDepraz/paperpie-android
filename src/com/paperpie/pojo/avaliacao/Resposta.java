package com.paperpie.pojo.avaliacao;

import java.io.Serializable;

public class Resposta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2053461983506393885L;
	private int id;
	private String descricao;
	private boolean correta;
	
	public Resposta(int id, String descricao, boolean correta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.correta = correta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isCorreta() {
		return correta;
	}
	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	
}
