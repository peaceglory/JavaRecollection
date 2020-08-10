package oop.design.patterns.codegeeks.structural.proxy.protectionproxy;

public interface Staff {

	public boolean isOwner();
	public void setReportGenerator(ReportGeneratorProxy reportGenerator);
}
