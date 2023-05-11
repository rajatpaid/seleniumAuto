package com.master_module;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.BasePackage.TestActions;
import com.BasePackage.TestBase;
import com.UtilitiesClasses.Constants;
import com.UtilitiesClasses.ExpectedValue;

import comfssdomainpageobjects.AdminSignInPageObjects;
import comfssdomainpageobjects.AirLinePageObject;
import comfssdomainpageobjects.BranchesPageObject;
import comfssdomainpageobjects.CustomerPageObject;
import comfssdomainpageobjects.ServiceTypeObjects;

@Listeners({com.master_module.Itestlistners.class})
public class MasterModuleTestScripts extends TestBase{
	
	public AdminSignInPageObjects signinpage;
	public  AirLinePageObject airline;
	public BranchesPageObject branch;
	public CustomerPageObject customer ;
	public ServiceTypeObjects serviceType;
	
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
		Assert.assertEquals(ExpectedValue.companyName,signinpage.isCompanyNameDisplayed());
	}
	
	@Test(priority=1,description="This testcase verifies Admin is able to Create,View,ExportAs,Edit,Filter the Airlines.",enabled=true)
	public void verifyAirlineCreateViewExportAsEditFilter() throws InterruptedException  {
		signinpage= new AdminSignInPageObjects(driver);
    	signinpage.adminLogin();
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
		airline.createAirline(Constants.airlineName, Constants.airlineIATA, Constants.airlineICAO,Constants.airlineCallsign, Constants.airlineAlias);
	
		//CreatedSuccessfully 
//		Assert.assertEquals(ExpectedValue.expectedCreatedSuccessfullMessage,airline.isCreatedSuccessfullyMessageDisplayed());  
//		Assert.assertEquals(ExpectedValue.airlineDetailsText,airline.isAirlinesDetailsTextDisplayed());  
//		Assert.assertEquals(ExpectedValue.editButtonText,airline.isEditButtonTextDisplayed());
//		Assert.assertEquals(ExpectedValue.cancelButtonText,airline.isCancelButtonTextDisplayed());
		airline.clickOnCancelButton();
		
		airline.viewAirline();
		Assert.assertEquals(ExpectedValue.airlineDetailsText,airline.isAirlinesDetailsTextDisplayed());  
		Assert.assertEquals(ExpectedValue.editButtonText,airline.isEditButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.cancelButtonText,airline.isCancelButtonTextDisplayed());
		airline.clickOnCancelButton();
		airline.editAirline(Constants.newairlineIATA);
		Assert.assertEquals(ExpectedValue.expectedUpdateSuccessfullMessage,airline.isUpdatedSuccessfullyMessageDisplayed());
		airline.clickOnCancelButton();
		airline.downloadAirlineInEXCEL();
		Assert.assertEquals(ExpectedValue.expectedEXCELDownloadSuccessfullMessage,airline.isEXCELgeneratedSuccessfullyMessageDisplayed());
		airline.filterAirline(Constants.airlineName);	
	}
	/*
	
    @Test(priority=2,description="This testcase verifies Admin is able to Navigate to the  Admin"
    		+ " Card Page & Airline Page from Airline Create, Airline Details and Airline Update Pages.",enabled=true)
	
	public void verifyNavigateFunctionalityInAirlines() throws InterruptedException{
    	signinpage= new AdminSignInPageObjects(driver);
    	signinpage.adminLogin();
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
		airline.clickOnViewIcon();
		Assert.assertEquals(ExpectedValue.airlineDetailsText,airline.isAirlinesDetailsTextDisplayed()); 
		airline.clickOnMasterLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		
		airline.clickOnEditIcon();
		Assert.assertEquals(ExpectedValue.airlineUpadteText,airline.isAirLineUpdateTextDisplayed());
		airline.clickOnMasterLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.adminCardText,airline.isAdminCardTextDisplayed());
		airline.clickOnAirlineCard();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
		airline.clickOnCreateNew();
		Assert.assertEquals(ExpectedValue.airlineCreateText,airline.isAirlineCreateTextDispleyed());
		airline.clickOnAirlinesLinkOnBreadcrumb();
		airline.clickOnEditIcon();
		Assert.assertEquals(ExpectedValue.airlineUpadteText,airline.isAirLineUpdateTextDisplayed());
		airline.clickOnAirlinesLinkOnBreadcrumb();
		Assert.assertEquals(ExpectedValue.airlinesText,airline.isAirlinesTextDispleyed());
	}
	
    @Test
    public void navigateFunctionalityInAirlines() throws InterruptedException{
    	signinpage= new AdminSignInPageObjects(driver);
    	signinpage.adminLogin();
		airline = new AirLinePageObject(driver);
		airline.navigate();
    }
    
    @Test(priority=3,description="This testcase verifies Admin is able to Create,View,ExportAs,Edit,Filter the Branches.",enabled=true)
	  public void verifyBranchesCreateViewExportAsEditFilter() throws InterruptedException {
      signinpage= new AdminSignInPageObjects(driver);
      signinpage.adminLogin();
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
	//  Assert.assertEquals(ExpectedValue.expectedCreatedSuccessfullMessage,airline.isCreatedSuccessfullyMessageDisplayed());  
//		Assert.assertEquals(ExpectedValue.branchDetailsText,branch.isBranchDetailsTextDisplayed());  
//		Assert.assertEquals(ExpectedValue.editButtonText,branch.isEditButtonTextDisplayed());
//		Assert.assertEquals(ExpectedValue.cancelButtonText,branch.isCancelButtonTextDisplayed());
	    branch.clickOnCancelButton();
		branch.viewBranch();
		Assert.assertEquals(ExpectedValue.branchDetailsText,branch.isBranchDetailsTextDisplayed());  
		Assert.assertEquals(ExpectedValue.editButtonText,branch.isEditButtonTextDisplayed());
		Assert.assertEquals(ExpectedValue.closeButtonText, branch.isCloseButtonTextDisplayed()); 
		branch.clickOnCloseButton();
		branch.editBranch(Constants.branchloaction);
		Assert.assertEquals(ExpectedValue.expectedUpdateSuccessfullMessage,branch.isUpdatedSuccessfullyMessageDisplayed());
		branch.clickOnCloseButton();
		branch.downloadBranchesInEXCEL();
		Assert.assertEquals(ExpectedValue.expectedEXCELDownloadSuccessfullMessage,branch.isEXCELgeneratedSuccessfullyMessageDisplayed());
		branch.filterBranch(Constants.branchName);	
    }
    
    @Test(priority=4,description="This testcase verifies Admin is able to Navigate to the  Admin Card Page & Branch Page from Branch Create, Branch Details and Branch Update Pages.",enabled=true)
   	public void verifyNavigateFunctionalityInBranches() throws InterruptedException{
    	signinpage= new AdminSignInPageObjects(driver);
    	signinpage.adminLogin();
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
   		branch.clickOnViewIcon();
   		Assert.assertEquals(ExpectedValue.branchDetailsText,branch.isBranchDetailsTextDisplayed()); 
   		branch.clickOnMasterLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		branch.clickOnEditIcon();
   		Assert.assertEquals(ExpectedValue.branchUpdatetext,branch.isBranchUpdateTextDisplayed());
   		branch.clickOnMasterLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.adminCardText,branch.isAdminCardTextDisplayed());
   		branch.clickOnBranchCard();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   		branch.clickOnCreateNew();
   		Assert.assertEquals(ExpectedValue.branchCreateText,branch.isBranchCreateTextDispleyed());
   		branch.clickOnBranchesLinkOnBreadcrumb();
   		branch.clickOnEditIcon();
   		Assert.assertEquals(ExpectedValue.branchUpdatetext,branch.isBranchUpdateTextDisplayed());
   		branch.clickOnBranchesLinkOnBreadcrumb();
   		Assert.assertEquals(ExpectedValue.branchesText,branch.isBranchesTextDispleyed());
   	}
       
   
   
   @Test(priority=6,description="This testcase verifies Admin is able to Create,View,ExportAs,Edit,Filter the Customer.",enabled=true)
	  public void verifyCustomerCreateViewExportAsEditFilter() throws InterruptedException {
	   signinpage= new AdminSignInPageObjects(driver);
  	   signinpage.adminLogin();
	  customer = new CustomerPageObject(driver);
	  customer.clickOnMasterModule(); 
	  customer.clickOnCustomerCard(); 
	  
	  Assert.assertEquals(ExpectedValue.createNewButtonText,customer.isCreateNewButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.exportAsButtonText,customer.isExportAsButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.filterButtonText,customer.isFilterButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.masterlinkText,customer.isMasterLinkTextDisplayed());
	  Assert.assertEquals(ExpectedValue.customerLinkText,customer.isCustomerLinkTextDisplayed());
	  Assert.assertEquals(ExpectedValue.customerText,customer.isCustomerTextDispleyed());
	  customer.clickOnCreateNew();
	  Assert.assertEquals(ExpectedValue.customerCreateText,customer.isCustomerCreateTextDispleyed());
	  Assert.assertEquals(ExpectedValue.saveButtonText,customer.isSaveButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.cancelButtonText,customer.isCancelButtonTextDisplayed());
	  customer.enterClientdetails(Constants.clientName, Constants.natureOfBussiness, Constants.commodity, Constants.creditedLimit , 
			  Constants.paymentTerm,Constants.email, Constants.faxNo, Constants.website, Constants.vatNo, Constants.mobileNo, 
			  Constants.gstNo, Constants.remark, Constants.iecCODE);
	  customer.enterClientAddressdetails(Constants.adressLine1, Constants.city, Constants.phoneNo, Constants.zipCODE);
	  customer.enterClientContactdetails(Constants.firstNAME, Constants.lastNAME,Constants.contactEmail, Constants.designation, Constants.phone);
	  customer.clickOnSaveButton();
	  
//	  Assert.assertEquals(ExpectedValue.expectedCreatedSuccessfullMessage,customer.isCreatedSuccessfullyMessageDisplayed());  
//	  Assert.assertEquals(ExpectedValue.customerDetailsText,customer.isCustomerDetailsTextDisplayed());  
//	  Assert.assertEquals(ExpectedValue.editButtonText,customer.isEditButtonTextDisplayed());
//	  Ass.assertEquals(ExpectedValue.cancelButtonText,customer.isCancelButtonTextDisplayed());
	  customer.clickOnCancelButton();
	//  customer.uploadKYCDocument(Constants.kycdocumentName,Constants.kycdocumentPath);
	  customer.viewCustomer();
	 Assert.assertEquals(ExpectedValue.customerDetailsText,customer.isCustomerDetailsTextDisplayed());  
	  Assert.assertEquals(ExpectedValue.editButtonText,customer.isEditButtonTextDisplayed());
	  Assert.assertEquals(ExpectedValue.closeButtonText, customer.isCloseButtonTextDisplayed()); 
	  customer.clickOnCloseButton();
	  customer.editCustomer(Constants.mobileNo);
	  Assert.assertEquals(ExpectedValue.expectedUpdateSuccessfullMessage,customer.isUpdatedSuccessfullyMessageDisplayed());
	  customer.clickOnCloseButton();
	  customer.downloadCustomerInEXCEL();
	  Assert.assertEquals(ExpectedValue.expectedEXCELDownloadSuccessfullMessage,customer.isEXCELgeneratedSuccessfullyMessageDisplayed());
	  customer.filterCustomer(Constants.clientName);
	  
	
   }
   
   @Test(priority=7,description="This testcase verifies Admin is able to Navigate to the  Admin Card Page & Customer Page from Customer Create, Customer Details and Customer Update Pages.",enabled=true)
  	public void verifyNavigateFunctionalityInCustomer() throws InterruptedException{
	    signinpage= new AdminSignInPageObjects(driver);
  	    signinpage.adminLogin();
  		customer = new CustomerPageObject(driver);
  		customer.clickOnMasterModule(); 
  		Assert.assertEquals(ExpectedValue.adminCardText,customer.isAdminCardTextDisplayed());
  		customer.clickOnCustomerCard();
  		Assert.assertEquals(ExpectedValue.customerText,customer.isCustomerTextDispleyed());
  		customer.clickOnMasterLinkOnBreadcrumb();
  		Assert.assertEquals(ExpectedValue.adminCardText,customer.isAdminCardTextDisplayed());
  		customer.clickOnCustomerCard();
  		Assert.assertEquals(ExpectedValue.customerText,customer.isCustomerTextDispleyed());
  		customer.clickOnCreateNew();
  		Assert.assertEquals(ExpectedValue.customerCreateText,customer.isCustomerCreateTextDispleyed());
  		customer.clickOnMasterLinkOnBreadcrumb();
  		Assert.assertEquals(ExpectedValue.adminCardText,customer.isAdminCardTextDisplayed());
  		customer.clickOnCustomerCard();
  		Assert.assertEquals(ExpectedValue.customerText,customer.isCustomerTextDispleyed());
  		customer.clickOnViewIcon();
  		Assert.assertEquals(ExpectedValue.customerDetailsText,customer.isCustomerDetailsTextDisplayed()); 
  		customer.clickOnMasterLinkOnBreadcrumb();
  		Assert.assertEquals(ExpectedValue.adminCardText,customer.isAdminCardTextDisplayed());
  		customer.clickOnCustomerCard();
  		Assert.assertEquals(ExpectedValue.customerText,customer.isCustomerTextDispleyed());
  		customer.clickOnEditIcon();
  		Assert.assertEquals(ExpectedValue.customerUpadteText,customer.isCustomerUpdateTextDisplayed());
  		customer.clickOnMasterLinkOnBreadcrumb();
  		Assert.assertEquals(ExpectedValue.adminCardText,customer.isAdminCardTextDisplayed());
  		customer.clickOnCustomerCard();
  		customer.clickOnCreateNew();
  		Assert.assertEquals(ExpectedValue.customerCreateText,customer.isCustomerCreateTextDispleyed());
  		customer.clickOnCustomerLinkOnBreadcrumb();
  		customer.clickOnEditIcon();
  		Assert.assertEquals(ExpectedValue.customerUpadteText,customer.isCustomerUpdateTextDisplayed());
  		customer.clickOnCustomerLinkOnBreadcrumb();
  		Assert.assertEquals(ExpectedValue.customerText,customer.isCustomerTextDispleyed());
  	}
   
   @Test(priority=8,description="This testcase verifies Admin is able to Create,View,ExportAs,Edit,Filter the Customer.",enabled=true)
   public void verifyServiceTypeCreateViewExportAsEditFilter() throws InterruptedException {
	   signinpage= new AdminSignInPageObjects(driver);
	   signinpage.adminLogin();
	   serviceType = new ServiceTypeObjects(driver);
	   serviceType.clickOnMasterModule(); 
	   serviceType.clickOnServiceTypeCard(); 
	   Assert.assertEquals(ExpectedValue.createNewButtonText,serviceType.isCreateNewButtonTextDisplayed());
	   Assert.assertEquals(ExpectedValue.exportAsButtonText,serviceType.isExportAsButtonTextDisplayed());
	   Assert.assertEquals(ExpectedValue.filterButtonText,serviceType.isFilterButtonTextDisplayed());
	   Assert.assertEquals(ExpectedValue.masterlinkText,serviceType.isMasterLinkTextDisplayed());
	   Assert.assertEquals(ExpectedValue.serviceTypeLinkText,serviceType.isServiceTypeLinkTextDisplayed());
	   Assert.assertEquals(ExpectedValue.serviceTypeText,serviceType.isServiceTypeTextDispleyed());
	   serviceType.clickOnCreateNew();
	   Assert.assertEquals(ExpectedValue.serviceTypeCreateText,serviceType.isServiceTypeCreateTextDispleyed());
	   Assert.assertEquals(ExpectedValue.saveButtonText,serviceType.isSaveButtonTextDisplayed());
	   Assert.assertEquals(ExpectedValue.cancelButtonText,serviceType.isCancelButtonTextDisplayed());
	   serviceType.createServiceType(Constants.serviceTypeName,Constants.serviceTypeCode);

//	   Assert.assertEquals(ExpectedValue.expectedCreatedSuccessfullMessage,serviceType.isCreatedSuccessfullyMessageDisplayed());  
//	   Assert.assertEquals(ExpectedValue.serviceTypeDetailsText,serviceType.isServiceTypeDetailsTextDisplayed());  
//	   Assert.assertEquals(ExpectedValue.editButtonText,serviceType.isEditButtonTextDisplayed());
//	   Assert.assertEquals(ExpectedValue.cancelButtonText,serviceType.isCancelButtonTextDisplayed());
	   serviceType.clickOnCancelButton();
	   serviceType.viewServiceType();
	   Assert.assertEquals(ExpectedValue.serviceTypeDetailsText,serviceType.isServiceTypeDetailsTextDisplayed());  
	   Assert.assertEquals(ExpectedValue.editButtonText,serviceType.isEditButtonTextDisplayed());
	   Assert.assertEquals(ExpectedValue.closeButtonText, serviceType.isCloseButtonTextDisplayed()); 
	   serviceType.clickOnCloseButton();
	   serviceType.editServiceType(Constants.serviceTypeCode);
	   Assert.assertEquals(ExpectedValue.expectedUpdateSuccessfullMessage,serviceType.isUpdatedSuccessfullyMessageDisplayed());
	   serviceType.clickOnCloseButton();
	   serviceType.downloadServiceTypeInEXCEL();
	   Assert.assertEquals(ExpectedValue.expectedEXCELDownloadSuccessfullMessage,serviceType.isEXCELgeneratedSuccessfullyMessageDisplayed());
	   serviceType.filterServiceType(Constants.serviceTypeName);
}

   */
   
   
   
   
}