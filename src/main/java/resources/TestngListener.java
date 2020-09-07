package resources;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestngListener implements ITestListener {
	WebDriver driver;
	String testCaseName;
	ExtentTest test;
	ExtentReports report = ExtentReportUtility.report();
	//Basically it is an another way to achieve thread safety apart from writing immutable classes.
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
	test = report.createTest(result.getName());
	tl.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		String method = "onTestSuccess";
		tl.get().pass(result.getName());
		testCaseName = result.getName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Base base = new Base(driver);
		base.TakeScreenshot(method,testCaseName);
		tl.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\onTestSuccess\\" +testCaseName+ ".jpeg");
	}

	public void onTestFailure(ITestResult result) {
		String method = "onTestFailure";
		tl.get().fail(result.getThrowable());
		testCaseName = result.getName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Base base = new Base(driver);
		base.TakeScreenshot(method,testCaseName);
		tl.get().addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\onTestFailure\\" +testCaseName+ ".jpeg");
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}
