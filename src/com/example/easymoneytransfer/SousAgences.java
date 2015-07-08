package com.example.easymoneytransfer;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SousAgences extends ListActivity{

	private String agence;
	private TextView textViewInformation;
	private BaseDeDonnees mdb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sousagence);
		
		mdb = new BaseDeDonnees(this);
		
		textViewInformation = (TextView) findViewById(R.id.nomAgence);
		
		Bundle infos = this.getIntent().getExtras();
		agence = infos.getString("nomAgence");
		textViewInformation.setText(agence);
		
			ArrayList<ArrayList<String>> arrayList = mdb.getAllSousAgencces();
			if(arrayList != null){
				if(arrayList.isEmpty()){
					Toast toast = Toast.makeText(SousAgences.this, "Récupération interrompue" , Toast.LENGTH_LONG);
					toast.show();
				}
				ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
				setListAdapter(arrayAdapter);
			}else{
				Toast toast = Toast.makeText(SousAgences.this, "Echec de la Récupération" , Toast.LENGTH_LONG);
				toast.show();
			}
	}

}
