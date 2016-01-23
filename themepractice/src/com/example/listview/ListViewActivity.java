package com.example.listview;

import java.util.ArrayList;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.payment.PmtInfoActivity;
import com.example.themepractice.R;

public class ListViewActivity extends AppCompatActivity {

	ListView list;
	CustomAdapter adapter;
	public ListViewActivity CustomListView = null;
	public ArrayList<ListModel> CustomListViewValueArr = new ArrayList<ListModel>();
	private TextView tBarUGive;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listcontainter);

		CustomListView = this;
		
		Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
	    setSupportActionBar(myToolbar);
	    myToolbar.setTitle("U-GIVE");
	    setSupportActionBar(myToolbar);
	    getSupportActionBar().setDisplayShowTitleEnabled(false);
	    
	    tBarUGive = (TextView)findViewById(R.id.toolbar_title);
		Typeface molot = Typeface.createFromAsset(getAssets(), "fonts/molot.otf");
		tBarUGive.setTypeface(molot);

		/* Take some data in ArrayList */
		setListData();

		Resources res = getResources();
		list = (ListView) findViewById(R.id.list);

		/* Create Custom Adapter */
		adapter = new CustomAdapter(CustomListView, CustomListViewValueArr, res);
		list.setAdapter(adapter);
	}

	public void setListData() {
		for (int i = 0; i < 11; i++) {

			final ListModel sched = new ListModel();

			/* Firstly take data in model object */
			sched.setChurch("Church " + i);
			sched.setCity("City " + i);
			sched.setStreet("Street " + i);
			sched.setState("State " + i);

			/* Take Model Object in ArrayList */
			CustomListViewValueArr.add(sched);
		}
		final ListModel churchEx = new ListModel();
		
		churchEx.setChurch("First Baptist Church at the Mall");
		churchEx.setCity("Lakeland");
		churchEx.setState("FL");
		churchEx.setStreet("1010 East Memorial Blvd");
		
		CustomListViewValueArr.add(churchEx);
	}

	/* This function used by adapter */
	public void onItemClick(int mPosition) {
		ListModel tempValues = (ListModel) CustomListViewValueArr
				.get(mPosition);
		
		Intent intent = new Intent(this, PmtInfoActivity.class);
		startActivity(intent);

		// SHOW ALERT

		Toast.makeText(
				CustomListView,
				"" + tempValues.getChurch() + "" + tempValues.getCity() + ""
						+ tempValues.getStreet() + "" + tempValues.getState(),
				Toast.LENGTH_LONG).show();
	}
}
