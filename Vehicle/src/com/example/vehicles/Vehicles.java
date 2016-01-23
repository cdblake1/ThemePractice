package com.example.vehicles;

public abstract class Vehicles {
	
	private int wheels;
	private int windows;
	
	public Vehicles(int wheels, int windows){
		this.wheels = wheels;
		this.windows = windows;
		
	}
	public void print(){
		System.out.println("This vehicle has " + wheels + " wheels.");
		System.out.println("This vehicle has " + windows + " windows.");
	}

}
