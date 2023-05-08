package com.master_module;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasePackage.TestBase;
import com.UtilitiesClasses.Constants;

import comfssdomainpageobjects.SidebarObjects;
import comfssdomainpageobjects.SuperAdminCompanyCardObjects;
import comfssdomainpageobjects.SuperAdminSignInpageObjects;

public class SuperadminModuleTestScripts extends TestBase{
	public SuperAdminSignInpageObjects superadminsigninpage ;
	public SuperAdminCompanyCardObjects superadmincompany;
	
	Logger log = Logger.getLogger(SuperadminModuleTestScripts.class);
	
	    //superadmin login method
	    public void SuperadminLogin() {
	    	superadminsigninpage= new SuperAdminSignInpageObjects(driver);
	    	superadminsigninpage.navigateUrl(Constants.URL) ; 
	    	superadminsigninpage.enterSuperAdminUserId(Constants.superadminUsername); 
	    	superadminsigninpage.enterSuperAdminuserPassword(Constants.superadminPassword); 
	    	superadminsigninpage.clickOnSuperAdminLoginButton(); 	 
	}
	    @Test(priority=0,description="This testcase verifies super admin login functionality",enabled=true)
		public void verifySuperAdminLoginFunctionality() throws InterruptedException {
			SuperadminLogin();
			//Assert.assertEquals(superadminsigninpage.isSuperAdminProfileNameDisplayed(),Constants.ExpectedProfilEText); 
			Assert.assertEquals(superadminsigninpage.isUserNameDisplayed(),Constants.ExpectedUsernameText);	 	
	    }
	    
		@Test(priority=1,description="This testcase verifies user able to create company",enabled=true)
		public void verifycreatenewcompany() throws InterruptedException{
			SuperadminLogin();
			SidebarObjects superadmin_sidebar = new SidebarObjects(driver);
			superadmin_sidebar.clickOnsuperadminsidebar();
			superadmincompany =new SuperAdminCompanyCardObjects(driver);
			superadmincompany.clickOnCompanyCard();
			superadmincompany.clickOnCreateNew();
			superadmincompany.enterCreatenewCompanyDetails(Constants.CompanyName, Constants.Email,Constants.MobileNumber,Constants.PinCode,Constants.StateName,Constants.Countryname,Constants.WebsiteName,Constants.Location,Constants.FAXNumber,Constants.FIATACode,Constants.IATACode,Constants.VATNumber,Constants.GSTNumber,Constants.EnterDescription,Constants.BankAccountNumber,Constants.EnterAccountHolder,Constants.BankName,Constants.BankBranch,Constants.BeneficiaryName,Constants.IFSCODE);	
			}
}
