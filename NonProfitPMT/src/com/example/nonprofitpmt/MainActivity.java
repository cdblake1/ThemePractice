package com.example.nonprofitpmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	
	private ImageView appLogo;	
	private TextView loginTextField;
	private TextView passwordTextField;
	private Button loginButton;
	private Button registerButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initButtons();
	}
	
	public void initButtons(){
		ImageView appLogo = (ImageView) findViewById(R.id.app_logo);
		TextView loginTextField = (TextView) findViewById(R.id.login_textfield);
		TextView passwordTextField = (TextView) findViewById(R.id.pass_textfield);
		Button loginButton = (Button) findViewById(R.id.login_button);
		Button registerButton = (Button) findViewById(R.id.register_button);
		
	}
	
	public void startRegistration(View view){
		Intent intent = new Intent(this, UserInformation.class);
		startActivity(intent);
	}
	
	public void startPayment(View view){
		Intent intent = new Intent(this, PaymentInformation.class);
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
