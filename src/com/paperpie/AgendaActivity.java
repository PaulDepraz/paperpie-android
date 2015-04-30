package com.paperpie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.paperpie.pojo.agenda.Agendamento;
import com.paperpie.util.Static;

@SuppressLint("SimpleDateFormat")
public class AgendaActivity extends Activity {
	
	protected static final String TAG = AgendaActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);

		
		try{
			//Intent i = getIntent();
			//Agendamento[] agenda = (Agendamento[]) i.getSerializableExtra("agendamentos");
			
			Log.i(TAG,Static.agendamentosAluno.get(0).getDescricao());
			
			List<String> agendamentos = new ArrayList<String>();
			DateFormat df = new SimpleDateFormat("dd/MMM");
			
			for (Agendamento agendamento : Static.agendamentosAluno) {
				
				agendamentos.add(	df.format(agendamento.getData().getTime()) + " - " +
									agendamento.getTipoAtividade().getNome() + ": " +
									agendamento.getNome()
								);
			}
			// Pega ListView
			final ListView lv = (ListView) findViewById(R.id.listViewToDo);
			// Adapta
			ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, agendamentos);
			// Guarda na ListView
			lv.setAdapter(aa);
			// Click Listener
			lv.setOnItemClickListener(new OnItemClickListener() {
			      public void onItemClick(AdapterView<?> myAdapter, View myView, int myItemInt, long mylng) {
			       showDialog(Static.agendamentosAluno.get(myItemInt));

			      }
			      
			});
			
		} catch(Exception e){
			Log.e(TAG, e.getLocalizedMessage());
		}
	}
	
	public void showDialog(Agendamento ag){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setTitle(ag.getTipoAtividade().getNome());
		b.setMessage(	ag.getNome()+"\n"+
						df.format(ag.getData().getTime())+"\n"+
						ag.getDescricao()+"\n");
		b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		b.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agenda, menu);
		return true;
	}

}
