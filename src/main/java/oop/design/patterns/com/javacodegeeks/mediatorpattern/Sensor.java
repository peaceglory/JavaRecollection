package oop.design.patterns.com.javacodegeeks.mediatorpattern;

public class Sensor {
	
	public boolean checkTemperature(int temp){
		System.out.println("Temperature reached "+temp+" *C");
		return true;
	}

}
