package com.BasePackage;

import java.time.Duration;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;




public class TestActions {
	WebDriver driver;

	public TestActions(WebDriver driver) {
		this.driver=driver;
	}
	Logger log = Logger.getLogger(TestActions.class);

	public void navigateUrl(String url) {
		try {
			log.info("navigates to url"+url);
			driver.get(url);
		} catch (Exception e) {
			log.info("Failure to navigate to URL"+ url+e.getMessage().toString());
		}		
	}

	public void click(WebElement element) {
		try {
			log.info("successfully click on the element"+element);
			waitForEle(element).click();
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Failure to click element"+e.getMessage().toString());
			System.out.println();
		}		
	}

	public void sendkeys(WebElement element,String input) {
		try {
			log.info("successfully enter sendkeys"+input);
			waitForEle(element).sendKeys(input); 
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Failure to enter sendkeys"+input);
		}		
	}

	public void verifyElementDispaly(WebElement element) {
		try {
			if(waitForEle(element).isDisplayed()) {
				System.out.println("Emailid displayed successfully ");
			}else {
				System.out.println("Email is not displayed ");
			}
		} catch (Exception e) {
			// TODO: handle exception
		//	Assert.fail("Failure to display emailid ");
		}		
	}

	public WebElement waitForEle(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}		
	}
	public void dropdownhandle(WebElement elementdrop,int num) {
		try {
			//elementdrop.isSelected();
			Select drop= new Select(elementdrop);
			drop.selectByIndex(num);	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	public int getRandomInt( ) {
		Random randomGenerator = new Random(); 
		int randomInt = randomGenerator.nextInt(1000);
		return randomInt;
	}




}
