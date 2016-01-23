package com.example.themepractice;

import com.example.listview.ListViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class RegistrationActivity extends Activity {
	private TextView uGive;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registration);
		
		uGive = (TextView)findViewById(R.id.u_give);
		Typeface molot = Typeface.createFromAsset(getAssets(), "fonts/molot.otf");
		uGive.setTypeface(molot);
		
		final CheckedTextView ctv = (CheckedTextView) findViewById(R.id.terms);
		   ctv.setOnClickListener(new View.OnClickListener() {
		    	@Override
		    	public void onClick(View v) {
		    		if (ctv.isChecked())
		    			ctv.setChecked(false);
		    		else
		    			ctv.setChecked(true);
		 
		    	}
		    });
	}
	public void startSearch(View view){
		Intent intent = new Intent(this, ListViewActivity.class);
		startActivity(intent);
	}

}
