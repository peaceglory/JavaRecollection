package oop.design.patterns.com.javacodegeeks.proxypattern.remoteproxy;

import java.rmi.RemoteException;

public interface ReportGenerator {
	
	public String generateDailyReport() throws RemoteException;

}
