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

		// Chama o m�todo de autentica��o
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

	// Vai para pr�xima p�gina
	private void gotoMenu() {
		// Cria o Intent
		Intent i = new Intent(this, MenuActivity.class);
		// Inicia a Activity enviando o meuIntent
		startActivity(i);
	}

	// M�todo de autentica��o no servidor
	private class Authenticate extends
			AsyncTask<Void, Void, Message> {

		@Override
		protected void onPreExecute() { // M�todo executado antes da autentica��o
			showLoadingProgressDialog();

			// Pega dados inseridos nos campos
			EditText editText = (EditText) findViewById(R.id.username);
			Static.username = editText.getText().toString();

			editText = (EditText) findViewById(R.id.password);
			Static.password = editText.getText().toString();
		}

		@Override
		protected Message doInBackground(Void... params) { 	// M�todo que toda em background e
															//efetivamente faz a autentica��o
			
			// Cria string padr�o para consultas utilizando parametros
			String targetUrl= UriComponentsBuilder.fromUriString(getString(R.string.base_uri))
				    .path("/login")
				    .queryParam("user", Static.username)
				    .build()
				    .toUriString();

			try {
				Log.d(TAG, targetUrl);
				Message m = new Message();					// Mensagem de boas vindas ou de erro
				
				ResponseEntity<Aluno> response = 			// M�todo que tr�s o objeto JSon via Restful
						Static.getRestTemplate().exchange(
								targetUrl,					// Url do servi�o
								HttpMethod.GET,				// M�todo do servi�o
								Static.getHttpEntity(),		// Pega Objeto Http com usu�rio e senha
								Aluno.class);				// Tipo do objeto retornado

				Static.alunoSessao = response.getBody();	// Guarda objeto em vari�vel est�tica para consulta posterior

				m.setText("Bem vindo(a), "+Static.alunoSessao.getNome());
				
				auth = true;		// Sinaliza que a autentica��o ocorreu com sucesso e permite
									//passagem para pr�xima Activity

				return m;

			} catch (HttpClientErrorException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Message(0, 
							"Autentica��o",
							"Usu�rio e/ou senha inv�lidos");
			} catch (ResourceAccessException e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Message(0, 
							"Acesso",
							"Falha na conex�o com o servidor");
			} catch (Exception e) {
				Log.e(TAG, e.getLocalizedMessage(), e);
				return new Message(0, 
							e.getClass().getSimpleName(),
							"Erro Por favor contacte o suporte");
			}
		}

		@Override
		protected void onPostExecute(Message result) { // M�todo executado ap�s da autentica��o
			
			dismissProgressDialog();	// Fecha o di�logo "Carregando"
			displayResponse(result);	// Mostra o Toast
			
			if (auth) {			// Vai para o menu caso a autentica��o ocorra com sucesso
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
