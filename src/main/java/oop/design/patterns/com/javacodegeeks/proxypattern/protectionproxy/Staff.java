package oop.design.patterns.com.javacodegeeks.proxypattern.protectionproxy;

public interface Staff {

	public boolean isOwner();
	public void setReportGenerator(ReportGeneratorProxy reportGenerator);
}
