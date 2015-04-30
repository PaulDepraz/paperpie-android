package com.paperpie.pojo.agenda;


import java.io.Serializable;
import java.util.Calendar;


public class Agendamento implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3020646597688376958L;
	private int id;
	private TipoAtividade tipoAtividade;
	private Calendar data;
	private String nome;
	private String descricao;
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoAtividade getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(TipoAtividade tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}


}
