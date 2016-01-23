package com.example.vehicles;

public class Airplane extends Vehicles {
	private Wing wingLeft;
	private Wing wingRight;
	
	public Airplane(Wing wingLeft, Wing wingRight, int wheels, int windows){
		super(wheels, windows);
		this.wingLeft = wingLeft;
		this.wingRight = wingRight;
		
	}
	public void print(){
		super.print();
		System.out.println("This plane has a " + wingLeft.getWing() + " and a " + wingRight.getWing());
	}
}
