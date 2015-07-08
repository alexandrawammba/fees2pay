package com.example.easymoneytransfer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Principale extends ActionBarActivity {

	private EditText editTextMontant;
	private Spinner spinnerLocalisation;
	private Spinner spinnerDestination;
	private Button boutonValider;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		spinnerDestination = (Spinner) findViewById(R.id.destinationValue);
		ArrayAdapter<CharSequence> adapterDestination = ArrayAdapter.createFromResource(this,
		        R.array.destinationValue, android.R.layout.simple_spinner_item);
		adapterDestination.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
		spinnerDestination.setAdapter(adapterDestination);
		        
		editTextMontant = (EditText) findViewById(R.id.montantValue);

		
		spinnerLocalisation = (Spinner) findViewById(R.id.localisationValue);
		ArrayAdapter<CharSequence> adapterLocalisation = ArrayAdapter.createFromResource(this,
		        R.array.localisationValue, android.R.layout.simple_spinner_item);
		adapterLocalisation.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
		spinnerLocalisation.setAdapter(adapterLocalisation);
		
		
		boutonValider = (Button) findViewById(R.id.valider);
		boutonValider.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				if(editTextMontant.getText().toString().equals("")){

					String text = "Vous devez entrez un montant";
					Toast toast = Toast.makeText(Principale.this, text , Toast.LENGTH_LONG);
					toast.show();
				}else{
					System.out.println("Montant_Principale" + editTextMontant.getText());
					String[] values = new String[]{editTextMontant.getText().toString(),spinnerLocalisation.getSelectedItem().toString(), 
							spinnerDestination.getSelectedItem().toString()};
					Intent intent = new Intent(Principale.this,Agences.class);
					intent.putExtra("details", values);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principale, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
