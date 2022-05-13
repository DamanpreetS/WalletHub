package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReporter {
	static ExtentReports reports=null;
	public static ExtentReports getReport()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Final Report");
		reporter.config().setReportName("Final Report");

		 reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Damanpreet", "Tester");
		return reports;
	}
}
