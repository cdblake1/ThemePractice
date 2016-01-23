package com.example.nonprofitpmt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.Spinner;

public class PaymentInformation extends ActionBarActivity {
	private Spinner cardTypes;
	private CheckedTextView savePayment; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment_information);
		populateSpinner();
		toggleCheckBox();
	}

	public void populateSpinner() {
		cardTypes = (Spinner) findViewById(R.id.card_type_spin);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.card_types,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cardTypes.setAdapter(adapter);
	}
	public void initStartSearchActivity(View view){
		Intent intent = new Intent(this, StartSearch.class);
		startActivity(intent);
	}
	public void toggleCheckBox(){
		savePayment = (CheckedTextView)findViewById(R.id.save_payment_checkbox);
		savePayment.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				savePayment.toggle();
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.payment_information, menu);
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
