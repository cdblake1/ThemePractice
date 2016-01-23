package com.example.listview;

public class ListModel {
	private String church;
	private String city;
	private String street;
	private String state;

	public ListModel(String church, String city, String street, String state) {
		super();
		this.setChurch(church);
		this.setCity(city);
		this.setStreet(street);
		this.setState(state);
	}

	public ListModel() {
		// TODO Auto-generated constructor stub
	}

	public String getChurch() {
		return church;
	}

	public void setChurch(String church) {
		this.church = church;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
