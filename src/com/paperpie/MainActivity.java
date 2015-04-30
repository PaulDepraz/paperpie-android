package com.paperpie;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.util.UriComponentsBuilder;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paperpie.pojo.usuario.Aluno;
import com.paperpie.util.AbstractAsyncActivity;
import com.paperpie.util.Message;
import com.paperpie.util.Static;

public class MainActivity extends AbstractAsyncActivity {

	protected static final String TAG = MainActivity.class.getSimpleName();

	private boolean auth = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Chama o método de autenticação
		final Button submitButton = (Button) findViewById(R.id.submit1);
		submitButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new Authenticate().execute();
			}
		});
	}

	// Chama o Toast
	private void displayResponse(Message response) {
		Toast.makeText(this, response.getText(), Toast.LENGTH_LONG).show();
	}

	// Vai para próxima página
	private void gotoMenu() {
		// Cria o Intent
		Intent i = new Intent(this, MenuActivity.class);
		// Inicia a Activity enviando o meuIntent
		startActivity(i);
	}

	// Método de autenticação no servidor
	private class Authenticate extends
			AsyncTask<Void, Void, Message> {

		@Override
		protected void onPreExecute() { // Método executado antes da autenticação
			showLoadingProgressDialog();

			// Pega dados inseridos nos campos
			EditText editText = (EditText) findViewById(R.id.username);
			Static.username = editText.getText().toString();

			editText = (EditText) findViewById(R.id.password);
			Static.password = editText.getText().toString();
		}

		@Override
		protected Message doInBackground(Void... params) { 	// Método que toda em background e
															//efetivamente faz a autenticação
			
			// Cria string padrão para consultas utilizando parametros
			String targetUrl= UriComponentsBuilder.fromUriString(getString(R.string.base_uri))
				    .path("/login")
				    .queryParam("user", Static.username)
				    .build()
				    .toUriString();

			try {
				Log.d(TAG, targetUrl);
				Message m = new Message();					// Mensagem de boas vindas ou de erro
				
				ResponseEntity<Aluno> response = 			// Método que trás o objeto JSon via Restful
						Static.getRestTemplate().exchange(
								targetUrl,					// Url do serviço
								HttpMethod.GET,				// Método do serviço
								Static.getHttpEntity(),		// Pega Objeto Http com usuário e senha
								Aluno.class);				// Tipo do objeto retornado

				Static.alunoSessao = response.getBody();	// Guarda objeto em variável estática para consulta posterior

				m.setText("Bem vindo(a), "+Static.alunoSessao.getNome());
				
				auth = true;		// Sinaliza que a autenticação ocorreu com sucesso e permite
									//passagem para próxima Activity

				return m;

			} catch (HttpClientErrorException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Message(0, 
							"Autenticação",
							"Usuário e/ou senha inválidos");
			} catch (ResourceAccessException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Message(0, 
							"Acesso",
							"Falha na conexão com o servidor");
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Message(0, 
							e.getClass().getSimpleName(),
							"Erro Por favor contacte o suporte");
			}
		}

		@Override
		protected void onPostExecute(Message result) { // Método executado após da autenticação
			
			dismissProgressDialog();	// Fecha o diálogo "Carregando"
			displayResponse(result);	// Mostra o Toast
			
			if (auth) {			// Vai para o menu caso a autenticação ocorra com sucesso
				gotoMenu();
			}
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
