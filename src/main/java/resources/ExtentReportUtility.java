package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static ExtentReports report() {
		String file = System.getProperty("user.dir") + "\\Reports\\Index.html";
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(file);
		htmlReport.config().setReportName("Sample Report");
		htmlReport.config().setDocumentTitle("ExtentReportSample");
		ExtentReports extn = new ExtentReports();
		extn.setSystemInfo("Tester", "Harinath");
		extn.attachReporter(htmlReport);
		return extn;
	}

}
