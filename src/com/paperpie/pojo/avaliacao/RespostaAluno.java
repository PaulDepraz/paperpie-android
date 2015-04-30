package com.paperpie.pojo.avaliacao;

import java.io.Serializable;

import com.paperpie.pojo.usuario.Aluno;


public class RespostaAluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2929945110519195208L;
	private int id;
	private Aluno aluno;
	private String resposta;
	private String comentario;
	
	public RespostaAluno(int id, Aluno aluno, String resposta, String comentario) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.resposta = resposta;
		this.comentario = comentario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

	
}