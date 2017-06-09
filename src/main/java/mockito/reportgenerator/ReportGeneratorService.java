package mockito.reportgenerator;

import java.util.Date;

/**
 * Created by developer on 6/9/17.
 */
public class ReportGeneratorService {
    private IReportGenerator reportGenerator;

    public void generateReport(Date startDate, Date endDate, byte[] content) {
        ReportEntity report = new ReportEntity();
        report.setContent(content);
        report.setStartDate(startDate);
        report.setEndDate(endDate);
        reportGenerator.generateReport(report);
    }
}
