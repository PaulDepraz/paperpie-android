package com.paperpie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.paperpie.dao.AgendaController;
import com.paperpie.util.AbstractAsyncActivity;

public class MenuActivity extends AbstractAsyncActivity {

	AbstractAsyncActivity context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		// Chama o método de consumir serviço REST
		final Button botaoAgenda = (Button) findViewById(R.id.btn_agenda);
		botaoAgenda.setOnClickListener(new View.OnClickListener() {
			@SuppressLint("ShowToast")
			public void onClick(View v) {
				
				Toast t = Toast.makeText(context, "", Toast.LENGTH_LONG);
				Intent i = new Intent(context, AgendaActivity.class);
				String uri = getString(R.string.base_uri);
				new AgendaController(t,i,uri,context).execute();
			}
		});
		
		// Chama o método de consumir serviço REST
		final Button botaoAtividade = (Button) findViewById(R.id.btn_aval);
		botaoAtividade.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				gotoAtividade();
			}
		});
	}
	
	// Vai para próxima página
	private void gotoAtividade() {
		Intent i = new Intent(this, AvaliacaoActivity.class);
		//i.putExtra("agendamentos", agendamentos);
		startActivity(i);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

}
