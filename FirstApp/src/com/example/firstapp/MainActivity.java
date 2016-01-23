package com.example.firstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {
	
	private Button buttonSc2;
	private Button buttonAbout;
	private Button buttonSettings;
	private Button buttonTerran;
	private Button buttonZerg;
	private Button buttonProtoss;
	private Intent intentSc2;
	private Intent intentTerran;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initButtons();
		
		}
	
	public void initButtons(){
		buttonSc2 = (Button) findViewById(R.id.button_sc2);
		buttonAbout = (Button) findViewById(R.id.button_about);
		buttonSettings = (Button) findViewById(R.id.button_settings);
		buttonTerran = (Button) findViewById(R.id.button_terran);
		buttonZerg = (Button) findViewById(R.id.button_zerg);
		buttonProtoss = (Button) findViewById(R.id.button_protoss);
	}
	public void startSc2Activity(View view){
		Intent intent = new Intent(this, Sc2Activity.class);
		startActivity(intent);
	}
	
	public void startTerranActivity(View view){
		Intent intent = new Intent(this, TerranActivity.class);
		startActivity(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
