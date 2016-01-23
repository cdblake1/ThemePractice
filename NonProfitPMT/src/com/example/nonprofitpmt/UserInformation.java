package com.example.nonprofitpmt;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UserInformation extends ActionBarActivity {
	private TextView email;
	private EditText emailInput;
	private TextView confirmEmail;
	private EditText confirmEmailInput;
	private TextView password;
	private EditText passwordInput;
	private TextView confirmPassword;
	private EditText confirmPasswordInput;
	private Spinner securityQuestionSpin;
	private TextView securityQuestion;
	private TextView securityAnswer;
	private EditText securityAnswerInput;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_information);
		initLayoutInputs();
		populateSpinner();

	}

	private void initLayoutInputs() {
		TextView email = (TextView) findViewById(R.id.email_text);
		EditText emailInput = (EditText) findViewById(R.id.email_input);
		TextView confirmEmail = (TextView) findViewById(R.id.confirm_email_text);
		EditText confirmEmailInput = (EditText) findViewById(R.id.confirm_email_input);
		TextView password = (TextView) findViewById(R.id.password_text);
		EditText passwordInput = (EditText) findViewById(R.id.password_input);
		TextView confirmPassword = (TextView) findViewById(R.id.confirm_password_text);
		EditText confirmPasswordInput = (EditText) findViewById(R.id.confirm_password_input);
		TextView securityQuestion = (TextView) findViewById(R.id.security_question_text);
		TextView securityAnswer = (TextView) findViewById(R.id.security_answer_text);
		EditText securityAnswerInput = (EditText) findViewById(R.id.security_answer_input);

	}

	private void populateSpinner() {
		securityQuestionSpin = (Spinner) findViewById(R.id.security_question_spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.security_questions,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		securityQuestionSpin.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_information, menu);
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
