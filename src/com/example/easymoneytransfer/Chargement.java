package com.example.easymoneytransfer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

public class Chargement extends Activity{

	private ProgressBar bar;
	private boolean isRunning = false;
	private int i;
	
	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			bar.incrementProgressBy(7);
			
			if(i == 14){
				Intent intent = new Intent(Chargement.this, Principale.class);
				startActivity(intent);
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chargement);
		
		bar = (ProgressBar)findViewById(R.id.progress);

	}

	public void onStart(){
		super.onStart();
		bar.setProgress(0);
		
		Thread progression = new Thread(new Runnable(){
			public void run(){
				try {
					for(i=0; i<20 && isRunning; i++){
							Thread.sleep(500);
							handler.sendMessage(handler.obtainMessage());
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		isRunning = true;
		progression.start();

	}
	
	public void onStop(){
		super.onStop();
		isRunning = false;
	}
}















