package com.NinzaHRMProject.generic.listenerutility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NinzaHRMProject.generic.webdriverutility.UtilityClassObject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ISuiteListener,ITestListener {

	ExtentReports report;
	ExtentTest test;
	String testName;
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("===onStart(Listener) Execution Started===");
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/NinzaHrmReport.html");
		spark.config().setDocumentTitle("NinzaHrm suite result");
		spark.config().setReportName("NinzaHrm Report");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Browser", "Chrome");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===onTestStart(Listener) Execution Started===");
		
		testName=result.getMethod().getMethodName();
		test=report.createTest(testName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, "Test Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===onTestSucces(Listener) Execution Started===");
		
		test.log(Status.PASS, "Test Execution Completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("===onTestFailure (Listener) Execution Started===");
		
		test.log(Status.FAIL, "Test Execution Failed");
		TakesScreenshot ts=(TakesScreenshot)UtilityClassObject.getDriver();
		String filePath=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filePath);
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("===onTestSkipped (Listener) Execution Started===");
		
		test.log(Status.SKIP, "Test Execution Skipped");
	}

	
	@Override
	public void onFinish(ISuite suite) {
		System.out.println("===onFinish(Listener) Execution Started===");
		
		report.flush();
	}

	
}
