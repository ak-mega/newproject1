package Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCaseFile.TestCase;

public class ExtentReportWithListeners extends TestCase implements ITestListener {
	ExtentSparkReporter createReport;
	ExtentReports createtest;
	ExtentTest createlog;

	void setup() // function
	{	ReadConfigClass rc=new ReadConfigClass();
		createReport = new ExtentSparkReporter("Report1.html"); // class for file create
		createtest = new ExtentReports(); // create report
		createtest.attachReporter(createReport);

		createtest.setSystemInfo("os", "windows"); // methods of extent reports class
		createtest.setSystemInfo("Browser",rc.getsaurabh());
		createtest.setSystemInfo("user", "Alok");

		createReport.config().setDocumentTitle("MyExtentReport"); // methods of extent
		createReport.config().setReportName("ExtentReportToday");
		createReport.config().setTheme(Theme.DARK);

	}

	public void onStart(ITestContext Result) { // 1st report bnke ready
		setup();
		System.out.println("onStart");
	}

	public void onFinish(ITestContext Result) { 
		createtest.flush();         // report show ke lie
		System.out.println("onFinish call");
	}

	public void onTestStart(ITestResult Result) { // 2nd
		System.out.println("on test start");
	}

	public void onTestSuccess(ITestResult Result) {
		createlog = createtest.createTest(Result.getName());
		createlog.log(Status.PASS, MarkupHelper.createLabel("Test case Pass", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult Result) {
		try {
			ScreenShot();
		} catch (IOException e) {

			e.printStackTrace();
		}
		String path = "C:\\Users\\my\\eclipse-workspace\\datadrivenproject\\ScreenShot\\Report.png";
		createlog = createtest.createTest(Result.getName());
		createlog.log(Status.FAIL, MarkupHelper.createLabel("Test case Fail", ExtentColor.RED));
		createlog.fail("myscreenshot" + createlog.addScreenCaptureFromPath(path));

	}

	public void onTestSkipped(ITestResult Result) {
		createlog = createtest.createTest(Result.getName());
		createlog.log(Status.SKIP, MarkupHelper.createLabel("Test case skip", ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {

	}

}
