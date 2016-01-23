package com.example.listview;

import java.util.ArrayList;

import com.example.themepractice.R;
import com.example.themepractice.R.id;
import com.example.themepractice.R.layout;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter implements OnClickListener {
	private Activity activity;
	private ArrayList data;
	private static LayoutInflater inflater = null;
	public Resources res;
	ListModel tempValues = null;

	public CustomAdapter(Activity a, ArrayList d, Resources resLocal) {
		activity = a;
		data = d;
		res = resLocal;

		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	/* What is the size of Passed Array List */
	public int getCount(){
		if(data.size()<=0){
			return 1;
		}
		return data.size();
	}
	
	public Object getItem(int position) {
		return position;
	}
	
	public long getItemId(int position){
		return position;
	}
	
	/* Create a holder Class to contain inflated xml file elements */
	
	public static class ViewHolder{
		
		public TextView church;
		public TextView city;
		public TextView street;
		public TextView state;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View vi = convertView;
		ViewHolder holder;
		
		if(convertView == null){
			/* Infalte activity_main.xml file for each row (defined below) */
			vi = inflater.inflate(R.layout.activity_list_view, null);
			
			/* View Holder Object to contain activity_main.xml file elements */
			
			holder = new ViewHolder();
			holder.church = (TextView) vi.findViewById(R.id.church);
			holder.city = (TextView) vi.findViewById(R.id.city);
			holder.street = (TextView) vi.findViewById(R.id.street);
			holder.state = (TextView) vi.findViewById(R.id.state);
			
			/* Set holder with LayoutInflater */
			vi.setTag(holder);	
		}
		else{
			holder=(ViewHolder)vi.getTag();
		}
		
		if(data.size()<=0){
			holder.church.setText("No Data");
		}
		else{
			/* Get each MOdel object from Arraylist */
			tempValues = null;
			tempValues = (ListModel)data.get(position);
			
			/* Set Model values in Holder elements */
			
			holder.church.setText(tempValues.getChurch());
			holder.city.setText(tempValues.getCity());
			holder.street.setText(tempValues.getStreet());
			holder.state.setText(tempValues.getState());
			
			/* Set Item Click Listener for LayoutInflater for each row */
			vi.setOnClickListener(new OnItemClickListener(position));
		}
		return vi;
	}
	@Override
	public void onClick(View v) {
		Log.v("CustomAdapter", "====Row button clicked====");
	}
	
	/* Called when Item click in ListView */
	private class OnItemClickListener implements OnClickListener{
		private int mPosition;
		
		OnItemClickListener(int position){
			mPosition = position;
		}

		@Override
		public void onClick(View v) {
			
			ListViewActivity sct =(ListViewActivity) activity;
			
			/* Call onItemClick Method inside MainActivity */
			
			sct.onItemClick(mPosition);
		}
	}
}
