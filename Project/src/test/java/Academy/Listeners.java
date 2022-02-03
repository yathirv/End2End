package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtendReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener
{


	ExtentReports extent = ExtendReporterNG.getReportObject();
	ExtentTest test;
	ThreadLocal<ExtentTest> xtentTest = new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		xtentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		xtentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {

		//test.fail(result.getThrowable());
		xtentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testcaseName = result.getMethod().getMethodName();

		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch(Exception e) {
		}
		try {
			xtentTest.get().addScreenCaptureFromPath(getScreenShotPath(testcaseName,driver),result.getMethod().getMethodName()); // path // title



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
