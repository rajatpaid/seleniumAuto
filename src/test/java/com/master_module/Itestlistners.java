package com.master_module;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Itestlistners extends MasterModuleTestScripts implements ITestListener {
	ExtentSparkReporter htmlReporter; 
	ExtentReports extent;
	ExtentTest test;

	@Override 
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentSparkReporter("extentReport.html");
		extent = new ExtentReports(); 
		extent.attachReporter(htmlReporter);
		System.out.println("onStart"   +context.getName().toString());

	}

	@Override 
	public void onFinish(ITestContext context) { 
		System.out.println("onFinish"  +context.getName().toString());
		test =  extent.createTest(context.getName());
		extent.flush();

	}

	@Override 
	public void onTestStart(ITestResult context) {	
		test =  extent.createTest(context.getName());
		System.out.println("Test method strted"  +context.getName().toString());
		
	}


	@Override 
	public void onTestSuccess(ITestResult context) {
		test =  extent.createTest(context.getName());
		System.out.println("Test method sucess" +context.getMethod().toString());

	}

	@Override 
	public void onTestFailure(ITestResult context)  {
		try {
			failed();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test =  extent.createTest(context.getName());
		System.out.println("Test method failure"+context.getMethod().toString());

	}
	@Override 
	public void onTestSkipped(ITestResult context) { // TODO
		test =  extent.createTest(context.getName());
		System.out.println("Test method skkiped"+context.getMethod().toString());
	}

	/*

	  private void 
	  captureScreenshot(String methodName) throws IOException { //


	  System.out.println("screenshot taking sucessfully"); }

	  @Override 
	  public void onTestSkipped(ITestResult result) { // TODO
	   System.out.println("Test method skkiped");

	  }

	  @Override 
	  public void onTestFailedButWithinSuccessPercentage(ITestResult
	  result) {

	  try { captureScreenshot(result.getTestName()+".jpg"); } catch (IOException e)
	  { // TODO Auto-generated catch block e.printStackTrace(); }

	  System.out.println("onTestFailedButWithinSuccessPercentage"); }

}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 */
}
