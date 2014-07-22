package com.jikexueyuan.game2048;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;




public class MainActivity extends Activity {
	
	GameView view;
	Button button;
	
	public MainActivity() {
		mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tvScore = (TextView) findViewById(R.id.tvScore);
		
		button = (Button) findViewById(R.id.button1);
        
        // Defining click event listener for the button btn_chart
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				Intent report = new Intent(MainActivity.this,Report.class);
				startActivity(report);
				
			}
			 
			
			
 
		});
		
		//to call connection service
		startService(new Intent(this,ConnectionService.class));
		
		
		Intent game = new Intent(this,Game.class);
		startActivity(game);
		
		
		
		
		
	}
	
	
	


	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void clearScore(){
		score = 0;
		showScore();
	}
	
	public void showScore(){
		tvScore.setText(score+"");
	}
	
	public void addScore(int s){
		score+=s;
		showScore();
	}

	private int score = 0;
	private TextView tvScore;
	
	private static MainActivity mainActivity = null;
	
	public static MainActivity getMainActivity() {
		return mainActivity;
	}

}
