package com.master_module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasePackage.TestBase;
import com.UtilitiesClasses.Constants;
import com.UtilitiesClasses.ExpectedValue;

import comfssdomainpageobjects.AdminSignInPageObjects;
import comfssdomainpageobjects.AirLinePageObject;
import comfssdomainpageobjects.BranchesPageObject;




public class MasterModuleTestScripts extends TestBase{
	
	public AdminSignInPageObjects signinpage;
	public  AirLinePageObject airline;
	public BranchesPageObject branch;

	
	
	@Test(priority=0,description="This testcase verifies login functionality",enabled=true)
	public void verifyAdminLoginPage() {
		signinpage= new AdminSignInPageObjects(driver);
		signinpage.navigateUrl(Constants.URL) ; 
		Assert.assertTrue(signinpage.isUsernameTextboxDisplayed(),"The Username Textbox is not Displayed on Signin Page.");
		Assert.assertTrue(signinpage.isPasswordTextboxDisplayed(),"The Password Textbox is not Displayed on Signin Page.");
		Assert.assertTrue(signinpage.isforgotPasswordLinkEnabled(),"The Forgot Password Link is not Enabled on Signin Page.");
		Assert.assertTrue(signinpage.isforgotPasswordLinkDisplayed(),"The Forgot Password Link is not Displayed on Signin Page.");
		Assert.assertTrue(signinpage.isRememberMeCheackboxSelected(),"The Remember Me Cheackbox is not Selected on Signin Page.");
		Assert.assertTrue(signinpage.isLOGINButtonEnabled(),"The LOGIN Button is not Enabled on Signin Page.");
		Assert.assertEquals(ExpectedValue.loginButtonText,signinpage.isLOGINButtonTextDisplayed());
		signinpage.enterAdminUsername(Constants.adminUsername); 
		signinpage.enterAdminPassword(Constants.adminPassword); 
		signinpage.clickOnLoginButton();
		signinpage.isCompanyNameDisplayed();
		
		
	}
	@Test(priority=1,description="This testcase verifies Admin is able to Create,View,ExportAs,Edit,Filter the Airlines.",enabled=true)
	public void verifyAirline_Create_View_ExportAs_Edit_Filter() throws InterruptedException  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		adminLogin();
		airline = new AirLinePageObject(driver);
		airline.clickOnMasterModule();
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.createNewButtonText,airline.isCreateNewButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.exportAsButtonText,airline.isExportAsButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.filterButtonText,airline.isFilterButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.masterlinkText,airline.isMasterLinkTextDisplayed());
		Assert.assertEquals(ExpectedValue.airlineLinkText,airline.isAirlineLinkTextDisplayed());
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		airline.clickOnCreateNew();
		Assert.assertEquals(ExpectedValue.airlineCreateText,airline.isAirlineCreateTextDispleyed());
		Assert.assertEquals(ExpectedValue.airlineNameText,airline.isNameTextDisplayed());
		Assert.assertEquals(ExpectedValue.airlineiataText,airline.isIATATextDisplayed());
		Assert.assertEquals(ExpectedValue.airlineiacoText,airline.isICAOTextDisplayed());
		Assert.assertEquals(ExpectedValue.airlineAliasText,airline.isAliasTextDisplayed());
		Assert.assertEquals(ExpectedValue.airlineCallsignText,airline.isCallsignTextDisplayed());
		Assert.assertEquals(ExpectedValue.saveButtonText,airline.isSaveButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.cancelButtonText,airline.isCancelButtonTextDisplayed());
		airline.enterAirlineDetails(Constants.airlineName, Constants.airlineIATA, Constants.airlineICAO,Constants.airlineCallsign, Constants.airlineAlias);
		airline.clickOnSaveButton();
		//CreatedSuccessfully 
//		Assert.assertEquals(ExpectedValue.expectedCreatedSuccessfullMessage,airline.isCreatedSuccessfullyMessageDisplayed());  
//		Assert.assertEquals(ExpectedValue.airlineDetailsText,airline.isAirlinesDetailsTextDisplayed());  
//		Assert.assertEquals(ExpectedValue.editButtonText,airline.isEditButtonTextDisplayed());
//		Assert.assertEquals(ExpectedValue.cancelButtonText,airline.isCancelButtonTextDisplayed());
		airline.clickOnCancelButton();
		
		Thread.sleep(2000);
		airline.clickOnViewIcon();
		Assert.assertEquals(ExpectedValue.airlineDetailsText,airline.isAirlinesDetailsTextDisplayed());  
		Assert.assertEquals(ExpectedValue.editButtonText,airline.isEditButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.cancelButtonText,airline.isCancelButtonTextDisplayed());
		airline.clickOnCancelButton();
		Thread.sleep(2000);
		airline.clickOnEditIcon();
		airline.clickOnUpdateButton();
		Thread.sleep(2000);
		Assert.assertEquals(ExpectedValue.expectedUpdateSuccessfullMessage,airline.isUpdatedSuccessfullyMessageDisplayed());
		airline.clickOnCancelButton();
		airline.selectEXCELOptionFromDropdown();
		Assert.assertEquals(ExpectedValue.expectedEXCELDownloadSuccessfullMessage,airline.isEXCELgeneratedSuccessfullyMessageDisplayed());
		airline.clickOnFilterButton();
		airline.enterAirlineNameOnFilterAndClickOnOK(Constants.airlineName);
		airline.clickOnReloadSymbol();
		
	}
	
    @Test(priority=2,description="This testcase verifies Admin is able to Navigate to the  Admin Card Page & Airline Page from Airline Create, Airline Details and Airline Update Pages.",enabled=true)
	
	public void verifyNavigateFunctionalityInAirlines() throws InterruptedException{
		adminLogin();
		airline = new AirLinePageObject(driver);
		airline.clickOnMasterModule();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		airline.clickOnMasterLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		airline.clickOnCreateNew();
		Assert.assertEquals(ExpectedValue.airlineCreateText,airline.isAirlineCreateTextDispleyed());
		airline.clickOnMasterLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		//Thread.sleep(2000);
		airline.clickOnViewIcon();
		Assert.assertEquals(ExpectedValue.airlineDetailsText,airline.isAirlinesDetailsTextDisplayed()); 
		airline.clickOnMasterLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		Thread.sleep(2000);
		airline.clickOnEditIcon();
		Assert.assertEquals(ExpectedValue.airlineUpadteText,airline.isAirLineUpdateTextDisplayed());
		airline.clickOnMasterLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		airline.clickOnCreateNew();
		Assert.assertEquals(ExpectedValue.airlineCreateText,airline.isAirlineCreateTextDispleyed());
		airline.clickOnAirlinesLinkOnBreadcrumb();
		Thread.sleep(2000);
		airline.clickOnEditIcon();
		Assert.assertEquals(ExpectedValue.airlineUpadteText,airline.isAirLineUpdateTextDisplayed());
		airline.clickOnAirlinesLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
	}
	
    @Test(priority=3,description="This testcase verifies Admin is able to Create,View,ExportAs,Edit,Filter the Branches.",enabled=true)
	  public void verifyBranches_Create_View_ExportAs_Edit_Filter() throws InterruptedException {
	  adminLogin();
	  branch = new BranchesPageObject(driver);
	  branch.clickOnMasterModule(); 
	  branch.clickOnBranchCard(); 
	  
	  Assert.assertEquals(ExpectedValue.createNewButtonText,branch.isCreateNewButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.exportAsButtonText,branch.isExportAsButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.filterButtonText,branch.isFilterButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.masterlinkText,branch.isMasterLinkTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchesLinkText,branch.isBranchesLinkTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
	  branch.clickOnCreateNew();
	  Assert.assertEquals(ExpectedValue.branchNameText,branch.isBranchNameTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchCompanyText,branch.isBranchCompanyTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchLocationText,branch.isBranchLocationTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchCodeText,branch.isBranchCodeTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchEmailText,branch.isBranchEmailTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchGSTNoText,branch.isBranchGSTNumberTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchStateText,branch.isBranchGSTstateTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchAddressText,branch.isBranchAddressTextDisplayed());
	  Assert.assertEquals(ExpectedValue.branchAddAddressButtonText,branch.isBranchAddAddressButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.saveButtonText,branch.isSaveButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.cancelButtonText,branch.isCancelButtonTextDisplayed());
	  branch.enterBranchDetails(Constants.branchName,Constants.branchloaction,Constants.branchCode,Constants.branchEmail,Constants.branchGSTNo);
	  branch.enterBranchAddressDetails(Constants.branchAddress,Constants.branchPhoneNo,Constants.branchCity,Constants.branchZipCode);
	  branch.clickOnSaveButton();
	  Assert.assertEquals(ExpectedValue.expectedCreatedSuccessfullMessage,airline.isCreatedSuccessfullyMessageDisplayed());  
//		Assert.assertEquals(ExpectedValue.branchDetailsText,branch.isBranchDetailsTextDisplayed());  
//		Assert.assertEquals(ExpectedValue.editButtonText,branch.isEditButtonTextDisplayed());
//		Assert.assertEquals(ExpectedValue.cancelButtonText,branch.isCancelButtonTextDisplayed());
	    branch.clickOnCancelButton();
		Thread.sleep(2000);
		branch.clickOnViewIcon();
		Assert.assertEquals(ExpectedValue.branchDetailsText,branch.isBranchDetailsTextDisplayed());  
		Assert.assertEquals(ExpectedValue.editButtonText,branch.isEditButtonTextDisplayed());
		 Assert.assertEquals(ExpectedValue.closeButtonText, branch.isCloseButtonTextDisplayed()); 
		branch.clickOnCloseButton();
		Thread.sleep(2000);
		branch.clickOnEditIcon();
		branch.clickOnUpdateButton();
		Thread.sleep(2000);
		Assert.assertEquals(ExpectedValue.expectedUpdateSuccessfullMessage,branch.isUpdatedSuccessfullyMessageDisplayed());
		branch.clickOnCloseButton();
		branch.selectEXCELOptionFromDropdown();
		Assert.assertEquals(ExpectedValue.expectedEXCELDownloadSuccessfullMessage,branch.isEXCELgeneratedSuccessfullyMessageDisplayed());
		branch.clickOnFilterButton();
		branch.enterBranchNameOnFilterPageAndClickOnOK(Constants.branchName);
		branch.clickOnReloadSymbol();
		
    }
    @Test(priority=4,description="This testcase verifies Admin is able to Navigate to the  Admin Card Page & Branch Page from Branch Create, Branch Details and Branch Update Pages.",enabled=true)
	
   	public void verifyNavigateFunctionalityInBranches() throws InterruptedException{
   		adminLogin();
   		 branch = new BranchesPageObject(driver);
   		  branch.clickOnMasterModule(); 
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		branch.clickOnMasterLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		branch.clickOnCreateNew();
   		Assert.assertEquals(ExpectedValue.branchCreateText,branch.isBranchCreateTextDispleyed());
   		branch.clickOnMasterLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		Thread.sleep(2000);
   		branch.clickOnViewIcon();
   		Assert.assertEquals(ExpectedValue.branchDetailsText,branch.isBranchDetailsTextDisplayed()); 
   		branch.clickOnMasterLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		Thread.sleep(2000);
   		branch.clickOnEditIcon();
   		Assert.assertEquals(ExpectedValue.branchUpdatetext,branch.isBranchUpdateTextDisplayed());
   		branch.clickOnMasterLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		branch.clickOnCreateNew();
   		Assert.assertEquals(ExpectedValue.branchCreateText,branch.isBranchCreateTextDispleyed());
   		branch.clickOnBranchesLinkOnBreadcrumb();
   		Thread.sleep(2000);
   		branch.clickOnEditIcon();
   		Assert.assertEquals(ExpectedValue.branchUpdatetext,branch.isBranchUpdateTextDisplayed());
   		branch.clickOnBranchesLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   	}
       
    
    
	public void adminLogin() {
		signinpage= new AdminSignInPageObjects(driver);
		signinpage.navigateUrl(Constants.URL) ; 
		signinpage.enterAdminUsername(Constants.adminUsername); 
		signinpage.enterAdminPassword(Constants.adminPassword); 
		signinpage.clickOnLoginButton(); 	 
	}
}
