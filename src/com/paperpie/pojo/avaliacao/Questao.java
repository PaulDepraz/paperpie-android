package com.paperpie.pojo.avaliacao;

import java.io.Serializable;
import java.util.List;

public class Questao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 762936194352515101L;
	/**
	 * 
	 */
	private int id;
	private String textoQuestao;
	private List<Resposta> respostas;

	public Questao(int id, String textoQuestao, List<Resposta> respostas) {
		super();
		this.id = id;
		this.textoQuestao = textoQuestao;
		this.respostas = respostas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTextoQuestao() {
		return textoQuestao;
	}
	public void setTextoQuestao(String textoQuestao) {
		this.textoQuestao = textoQuestao;
	}
	public List<Resposta> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}


}
