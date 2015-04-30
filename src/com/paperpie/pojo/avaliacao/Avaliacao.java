package com.paperpie.pojo.avaliacao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class Avaliacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 530353629392520306L;
	private int id;
	private TipoAvaliacao tipoAvaliacao;
	private Disciplina disciplina;
	private Calendar data;
	private String nome;
	private String descricao;
	private List<Questao> questoes;
	
	public Avaliacao(int id, TipoAvaliacao tipoAvaliacao,
			Disciplina disciplina, Calendar data, String nome,
			String descricao, List<Questao> questoes) {
		super();
		this.id = id;
		this.tipoAvaliacao = tipoAvaliacao;
		this.disciplina = disciplina;
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.questoes = questoes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoAvaliacao getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
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
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	
	


}
