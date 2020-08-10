package oop.design.patterns.codegeeks.behavioral.mediator;

public interface MachineMediator {
	
	public void start();
	public void wash();
	public void open();
	public void close();
	public void on();
	public void off();
	public boolean checkTemperature(int temp);

}
