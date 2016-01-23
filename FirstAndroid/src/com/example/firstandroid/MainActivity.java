package com.example.firstandroid;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private Button subtractBtn;
	private Button addBtn;
	private TextView counterTv;
	private Button resetBtn;
	private int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		subtractBtn = (Button) findViewById(R.id.subtract_btn);
		addBtn = (Button) findViewById(R.id.add_btn);
		counterTv = (TextView) findViewById(R.id.counter_tv);
		resetBtn = (Button) findViewById(R.id.reset_btn);
		counterTv.setTextColor(Color.YELLOW);
		subtractBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter--;
				counterTv.setText(counter + "");
				changeTextColor();
			}
		});
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				counter++;
				counterTv.setText(counter + "");
				changeTextColor();
			}
		});
		resetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				counter = 0;
				counterTv.setText(counter + "");
				changeTextColor();
			}
		});
		
	}
	
	public void changeTextColor() {
		if(Integer.parseInt(counterTv.getText().toString()) == 0){
			counterTv.setTextColor(Color.YELLOW);
		}
		else if(Integer.parseInt(counterTv.getText().toString()) < 0){
			counterTv.setTextColor(Color.RED);
		}
		else{
			counterTv.setTextColor(Color.GREEN);
		}
		
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
