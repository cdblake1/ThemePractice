package com.example.main;

import com.example.vehicles.Airplane;
import com.example.vehicles.Wing;

public class Main {

	public static void main(String[] args) {
		Airplane plane = new Airplane( new Wing("left wing"),new Wing("right wing"), 2, 10);		
		plane.print();
			
		}
}
