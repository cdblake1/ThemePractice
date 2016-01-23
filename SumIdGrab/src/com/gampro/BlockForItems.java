package com.gampro;

import java.util.ArrayList;

public class BlockForItems {

	ArrayList<Integer> items = new ArrayList<Integer>();
	
	public BlockForItems(ArrayList<Integer> items) {
		super();
		this.items = items;
	}
	public ArrayList<Integer> getItems() {
		return items;
	}

	public void setItems(ArrayList<Integer> items) {
		this.items = items;
	}
}
