package com.UtilitiesClasses;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.BasePackage.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentListener extends TestBase implements ITestListener{
	public ExtentSparkReporter htmlReporter;
	public ExtentReports reports;
	public ExtentTest logger;

	
	
	public void configReport() {
		htmlReporter =new ExtentSparkReporter("Extent-Report.html");
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		reports.setSystemInfo("Enviornment","QA");
		reports.setSystemInfo("User", "Kaveri");
		
		htmlReporter.config().setReportName("FSS Automation Report");
		htmlReporter.config().setDocumentTitle("FSS Project");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	@Override
	public void onFinish(ITestContext Result) {
		System.out.println("On Finish method invoked...");
		reports.flush();
	}

	@Override
	public void onStart(ITestContext Result) {
		configReport();
		System.out.println("On Start method invoked...");
		
	}


	@Override
	public void onTestFailure(ITestResult Result) {
		logger=reports.createTest(Result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(Result.getName(), ExtentColor.RED));
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+Result.getName()+".png";
		File f=new File(screenshotPath);
		if(f.exists()) {
			try {
		logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath))	;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}
			}

	@Override
	public void onTestSkipped(ITestResult Result) {
		logger=reports.createTest(Result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(Result.getName(), ExtentColor.ORANGE));
	}
		
	

	@Override
	public void onTestStart(ITestResult Result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		logger=reports.createTest(Result.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(Result.getName(), ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) {
		
		
	}

}
