package sources.oop.design.com.javacodegeeks.patterns.proxypattern.remoteproxy;

import java.rmi.RemoteException;

public interface ReportGenerator {
	
	public String generateDailyReport() throws RemoteException;

}
