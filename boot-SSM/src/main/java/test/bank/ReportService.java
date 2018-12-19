package test.bank;

public class ReportService {
	
	private ReportGenerator reportGenerator;
	
	public void setReportGenerator(ReportGenerator reportGenerator){
		this.reportGenerator = reportGenerator;
	}

	public void generateMonthlyReport(int year, int month) {
		
		String[][] statistics = null ;
		reportGenerator.generate(statistics);
		
	}
}
