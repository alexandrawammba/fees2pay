/**
 * Classe qui affiche les différentes agences de la BD
 * */

package com.example.easymoneytransfer;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Agences extends ListActivity{

	private String[] information;
	private TextView textViewInformation;
	private ListView listView;
	private BaseDeDonnees mdb;
	private ArrayList<String> arrayList;
	private ArrayList<String> arrayListFinal;
	private ArrayList<Integer> images;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.agence);

		mdb = new BaseDeDonnees(this);
		
		textViewInformation = (TextView) findViewById(R.id.information);
		
		Bundle infos = this.getIntent().getExtras();
		information = infos.getStringArray("details");System.out.println(information);
		String texte = "Transfert de "+ information[0] + " FCFA\n  " + information[1] +"-"+ information[2];
		textViewInformation.setText(texte);
		
		//Contient toutes les agences récupérées dans le BD
		arrayList = mdb.getTauxAgences(Integer.parseInt(information[0]),information[1],information[2]);
		
		/**
		 * On teste si la récupération des agences à échouées
		 * */
		if(arrayList != null){

			arrayListFinal = new ArrayList<String>();
			images = new ArrayList<Integer>();
			
			if(arrayList.isEmpty()){
				
				Toast toast = Toast.makeText(Agences.this, "Aucune agence n'a été trouvée" , Toast.LENGTH_LONG);
				toast.show();
				arrayListFinal.add("Aucune agence trouvée");
				
			}else{
				
				int montant = 0;
				for(int i=0;i<arrayList.size(); i+=3){
					
					montant = Integer.parseInt(arrayList.get(i+1))+ Integer.parseInt(information[0]);
					String chaine = arrayList.get(i)+"\n  Frais d'envoie = "+ arrayList.get(i+1)+ "\n  Coût total = "+ montant;
					arrayListFinal.add(chaine);
					switchTest(arrayList, i+2, images);
				}			
			}
			
			MonAdaptateur arrayAdapter = new MonAdaptateur(this, arrayListFinal, images);
			setListAdapter(arrayAdapter);
		}else{
			Toast toast = Toast.makeText(Agences.this, "Echec de la Récupération" , Toast.LENGTH_LONG);
			toast.show();
		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(Agences.this, SousAgences.class);
		intent.putExtra("nomAgence", arrayList.get(position));
		startActivity(intent);
	}
	
	protected void switchTest(ArrayList<String> arraylist, int i, ArrayList<Integer> images){
		
		switch(arraylist.get(i)){
		
		case "express_union":
			images.add(R.drawable.express_union);
			break;
		case "express_exchange":
			images.add(R.drawable.express_exchange);
			break;
		case "orange_money":
			images.add(R.drawable.orange_money);
			break;
		case "mtn_money":
			images.add(R.drawable.mtn_money);
			break;
		default:
			images.add(R.drawable.agence);
			break;
		}
	}

}












