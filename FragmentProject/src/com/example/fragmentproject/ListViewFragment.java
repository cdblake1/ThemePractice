package com.example.fragmentproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListViewFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.fragment_layout, container, false);
		return view;
	}
	
	public Fragment createFragment(){
		// get fragment manager
		FragmentManager fm = getFragmentManager();
		Fragment fragment = new Fragment();
		//replace
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.detailscontainer, fragment);
		ft.commit();
		
		return fragment;
		
	}

}


