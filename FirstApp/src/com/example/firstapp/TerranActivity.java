package com.example.firstapp;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TerranActivity extends ListActivity implements OnItemClickListener {

	public static final String[] titles = new String[] { "Marine", "Marauder",
			"Viking", "Thor", "Battlecruiser" };

	public static final String[] descriptions = new String[] {
			"The basic combat unit with high dps",
			"A beefy ground unit who cannt attack air",
			"Anti-air unit who can transform into a defensive ground unit",
			"A mechanical juggernaut with combined tankiness and high dps",
			"The Terran's ultimate unit, who commands the sky and ground alike" };

	public static final Integer[] images = { R.drawable.marine,
			R.drawable.marauder, R.drawable.viking, R.drawable.thor,
			R.drawable.battlecruiser };

	ListView listView;
	List<RowItem> rowItems;

	/** Called when the activity is first created. **/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_terran);

		rowItems = new ArrayList<RowItem>();
		for (int i = 0; i < titles.length; i++) {
			RowItem item = new RowItem(images[i], descriptions[i], titles[i]);
			rowItems.add(item);
		}

		listView = (ListView) findViewById(android.R.id.list);
		CustomListViewAdapter adapter = new CustomListViewAdapter(this,
				R.layout.listadapter, rowItems);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Toast toast = Toast.makeText(getApplicationContext(), "Item "
				+ (position + 1) + ": " + rowItems.get(position),
				Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, 0);
		toast.show();
	}
}