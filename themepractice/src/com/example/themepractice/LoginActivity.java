package com.example.themepractice;

import com.example.listview.ListViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private TextView uGive;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		uGive = (TextView)findViewById(R.id.u_give);
		Typeface molot = Typeface.createFromAsset(getAssets(), "fonts/molot.otf");
		uGive.setTypeface(molot);
	}
	
	public void startSearch(View view){
		Intent intent = new Intent(this, ListViewActivity.class);
		startActivity(intent);
	}
}
