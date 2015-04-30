package com.paperpie.pojo.usuario;

import java.util.List;

public class Aluno extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7968129447113158595L;
	private String matricula;
	private String cpf;
	private String rg;
	private List<Turma> turmas;

	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	
}