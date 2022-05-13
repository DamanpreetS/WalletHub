package assignment;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporter;

public class Listeners extends Base implements ITestListener {

	
	ExtentReports extentrep=ExtentReporter.getReport();
	ExtentTest extenttest;
	ThreadLocal<ExtentTest> threadL=new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		extenttest=extentrep.createTest(result.getMethod().getMethodName());
		threadL.set(extenttest);
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		threadL.get().log(Status.PASS, result.getMethod().getMethodName() );
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String path=null;
		threadL.get().fail(result.getThrowable());
		try {
			WebDriver driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			 path=getScreenshot(driver, result.getMethod().getMethodName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		threadL.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extentrep.flush();
	}


	

	

}
