package com.BasePackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import comfssdomainpageobjects.AdminSignInPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static  WebDriver driver;


	@BeforeMethod
	public void initializeChrome() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions ();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option );
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		/*
		 * WebDriverManager.edgedriver().setup(); WebDriver driver = new EdgeDriver();
		 * driver.get(Constants.URL);
		 * driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 */
	}
//	@Test
//	public void test()  {
//		driver.get("http://20.219.229.2:3000/");
//		driver.findElement(By.xpath("//button[@class='dropdown-toggle btn btn-secondary']")).click();
//	}
	public void failed() throws IOException {

		File scrfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File("C:\\Users\\naras\\eclipse-workspace\\Product_Frieght_Adda\\test-output\\screnshots\\screenshot1.jpg"));
	}
	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}