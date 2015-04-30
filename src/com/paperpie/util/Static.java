package com.paperpie.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.paperpie.pojo.agenda.Agendamento;
import com.paperpie.pojo.avaliacao.Avaliacao;
import com.paperpie.pojo.avaliacao.Disciplina;
import com.paperpie.pojo.avaliacao.Questao;
import com.paperpie.pojo.avaliacao.Resposta;
import com.paperpie.pojo.avaliacao.TipoAvaliacao;
import com.paperpie.pojo.usuario.Aluno;
import com.paperpie.pojo.usuario.Turma;

public class Static {
	
	public static Aluno alunoSessao;
	public static List<Agendamento> agendamentosAluno;
	public static String username;
	public static String password;

	@SuppressWarnings("rawtypes")
	public static HttpEntity getHttpEntity(){
		// Populate the HTTP Basic Authentitcation header with the
		// username
		// and password
		HttpAuthentication authHeader = new HttpBasicAuthentication(
				username, password);
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAuthorization(authHeader);
		requestHeaders.setAccept(Collections
				.singletonList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(requestHeaders);
		
		return httpEntity;
	}
	
	public static RestTemplate getRestTemplate(){
		// Create a new RestTemplate instance
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(
				new MappingJacksonHttpMessageConverter());
		
		return restTemplate;
	}
	
	public static String getUriAgenda(String baseUri){
		
		String targetUrl= UriComponentsBuilder
				.fromUriString(baseUri)
			    .path("/agendamento/byturma")
			    .build()
			    .toUriString();
		
		for (Turma t : Static.alunoSessao.getTurmas()) {
			targetUrl= UriComponentsBuilder
					.fromUriString(targetUrl).queryParam("idturma", t
					.getId())
					.build()
					.toUriString();
		}
		
		return targetUrl;
		
	}
	
	public static Avaliacao getAvaliacao(){
		
		Avaliacao aval = 
				new Avaliacao(
						1,
						new TipoAvaliacao(1, "Alternativa"),
						new Disciplina(1, "Matemática"),
						Calendar.getInstance(),
						"NAC de Matemática",
						"Equações do 1o grau",
						 new ArrayList<Questao>());
		
		aval.getQuestoes().add(
				new Questao(1,"Encontre o valor de x em 59=x/2.",new ArrayList<Resposta>()));
		aval.getQuestoes().get(0).getRespostas().add(new Resposta(1, "118", true));
		aval.getQuestoes().get(0).getRespostas().add(new Resposta(2, "29,5", false));
		aval.getQuestoes().get(0).getRespostas().add(new Resposta(3, "60", false));
		aval.getQuestoes().get(0).getRespostas().add(new Resposta(4, "99", false));
		aval.getQuestoes().get(0).getRespostas().add(new Resposta(5, "120", false));
		
		aval.getQuestoes().add(
				new Questao(2,"Encontre o valor de x em 5=x/2.",new ArrayList<Resposta>()));
		aval.getQuestoes().get(1).getRespostas().add(new Resposta(6, "1/2", false));
		aval.getQuestoes().get(1).getRespostas().add(new Resposta(7, "7", false));
		aval.getQuestoes().get(1).getRespostas().add(new Resposta(8, "4", false));
		aval.getQuestoes().get(1).getRespostas().add(new Resposta(9, "10", true));
		aval.getQuestoes().get(1).getRespostas().add(new Resposta(10, "12", false));
		
		aval.getQuestoes().add(
				new Questao(3,"Encontre o valor de x em 59=x*2.",new ArrayList<Resposta>()));
		aval.getQuestoes().get(2).getRespostas().add(new Resposta(11, "118", false));
		aval.getQuestoes().get(2).getRespostas().add(new Resposta(12, "29,5", true));
		aval.getQuestoes().get(2).getRespostas().add(new Resposta(13, "60", false));
		aval.getQuestoes().get(2).getRespostas().add(new Resposta(14, "99", false));
		aval.getQuestoes().get(2).getRespostas().add(new Resposta(15, "120", false));
		
		aval.getQuestoes().add(
				new Questao(4,"Encontre o valor de x em 59=x+2.",new ArrayList<Resposta>()));
		aval.getQuestoes().get(3).getRespostas().add(new Resposta(16, "57", false));
		aval.getQuestoes().get(3).getRespostas().add(new Resposta(17, "59", false));
		aval.getQuestoes().get(3).getRespostas().add(new Resposta(18, "60", false));
		aval.getQuestoes().get(3).getRespostas().add(new Resposta(19, "2", false));
		aval.getQuestoes().get(3).getRespostas().add(new Resposta(20, "61", true));
		
		aval.getQuestoes().add(
				new Questao(5,"Encontre o valor de x em 2=x/59.",new ArrayList<Resposta>()));
		aval.getQuestoes().get(4).getRespostas().add(new Resposta(21, "118", true));
		aval.getQuestoes().get(4).getRespostas().add(new Resposta(22, "29,5", false));
		aval.getQuestoes().get(4).getRespostas().add(new Resposta(23, "60", false));
		aval.getQuestoes().get(4).getRespostas().add(new Resposta(24, "99", false));
		aval.getQuestoes().get(4).getRespostas().add(new Resposta(25, "120", false));
		
		return aval;
	}

}
