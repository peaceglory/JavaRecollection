package oop.design.patterns.com.javacodegeeks.mediatorpattern;

public interface MachineMediator {
	
	public void start();
	public void wash();
	public void open();
	public void close();
	public void on();
	public void off();
	public boolean checkTemperature(int temp);

}
