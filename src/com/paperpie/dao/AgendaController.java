package com.paperpie.dao;

import java.util.Arrays;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.paperpie.pojo.agenda.Agendamento;
import com.paperpie.util.AbstractAsyncActivity;
import com.paperpie.util.Static;


public class AgendaController extends AsyncTask<Integer, Integer, Void> {
	
	protected static final String TAG = AgendaController.class.getSimpleName();
	
	private Agendamento[] agenda;
	private boolean fetchOK=false;
	
	private Toast toast;
	private Intent intent;
	private String baseUri;
	private AbstractAsyncActivity context;
	
	public AgendaController(Toast toast, Intent intent, String baseUri, AbstractAsyncActivity context) {
		this.toast = toast;
		this.intent = intent;
		this.baseUri = baseUri;
		this.context = context;
	}

	@Override
	protected void onPreExecute() { // M�todo executado antes da autentica��o
		publishProgress(0);
	}
	@Override
	protected Void doInBackground(Integer... params) { 	// M�todo que roda em background (thread)
		try {
			
			String uri = Static.getUriAgenda(baseUri);
			
			Log.d(TAG, uri);
			
			ResponseEntity<Agendamento[]> response = 		// M�todo que tr�s o objeto // JSon via Restful
			Static.getRestTemplate().exchange(
					uri, 									// Url do servi�o
					HttpMethod.GET, 						// M�todo do servi�o
					Static.getHttpEntity(), 				// Pega Objeto Http com usu�rio e senha
					Agendamento[].class); 					// Tipo do objeto retornado

			agenda = response.getBody();
			fetchOK=true;
			
		} catch (HttpClientErrorException e) {
			Log.e(TAG, e.getLocalizedMessage(), e);
			toast.setText("Usu�rio e/ou senha inv�lidos");
			publishProgress(1);
		} catch (ResourceAccessException e) {
			Log.e(TAG, e.getLocalizedMessage(), e);
			toast.setText("Falha na conex�o com o servidor");
			publishProgress(1);
		} catch (Exception e) {
			Log.e(TAG, e.getLocalizedMessage(), e);
			toast.setText("Erro Por favor contacte o suporte");
			publishProgress(1);
		}
		return null;
	}
	@Override
	protected void onPostExecute(Void result) { // M�todo executado ap�s da autentica��o
		
		if( fetchOK && agenda == null){
			toast.setText("N�o h� agendamentos no momento");
			publishProgress(1);
		} else if ( fetchOK ){
			Static.agendamentosAluno = Arrays.asList(agenda);
			publishProgress(2);
			context.startActivity(intent);
		}
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		
		switch ((Integer)values[0]) {
		case 0:
			context.showProgressDialog("Buscando Agendamentos...");
			break;
		case 1:
			context.dismissProgressDialog();
			toast.show();
			break;
		
		case 2:
			context.dismissProgressDialog();
			break;

		default:
			break;
		}
	}
}