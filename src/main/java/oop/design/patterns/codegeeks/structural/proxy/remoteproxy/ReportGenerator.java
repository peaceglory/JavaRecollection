package oop.design.patterns.codegeeks.structural.proxy.remoteproxy;

import java.rmi.RemoteException;

public interface ReportGenerator {
	
	public String generateDailyReport() throws RemoteException;

}
