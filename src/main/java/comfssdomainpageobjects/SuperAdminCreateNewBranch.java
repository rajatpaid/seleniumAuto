package comfssdomainpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.BasePackage.TestActions;

public class SuperAdminCreateNewBranch extends TestActions{
	WebDriver driver;
	Logger log = Logger.getLogger(SuperAdminCreateNewBranch .class);
		public  SuperAdminCreateNewBranch (WebDriver driver) {
    	super(driver);
    	this.driver=driver;
		PageFactory.initElements(driver, this);
			}
		//Superadmin Active company
		@FindBy(xpath="//i[@class='anticon anticon-apple']")
		public WebElement ActiveCompany;
		
		//select company
		@FindBy(xpath="//tbody[@class='ant-table-tbody']")
		public WebElement Company;
		
		@FindBy(xpath="//td[@class='ant-table-row-cell-break-word']//span//i[4]")
		public WebElement SettingCompany;
		
		//
		@FindBy(xpath="//div[@class='ant-popover-inner']//button[2]")
		public WebElement SettingCompanyOkButton;
		
		//click on branch 
		@FindBy(xpath="//div[@class='ant-col ant-col-6']//a//div[1]//i")
		public WebElement BranchCard;
		
		//click on Create New branch 
		@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
	    public WebElement CreateNewBranch;
		
		//Enter_BranchName 
		@FindBy(xpath="//input[@id='name']")
	    public WebElement Enter_BranchName ;
		
		//Enter Location 
		@FindBy(xpath="//input[@id='location']")
	    public WebElement Enter_Location ;
		
		//Enter Enter_branchCode
		@FindBy(xpath="//input[@id='branchCode']")
	    public WebElement Enter_branchCode ;
		

		//Enter Enter_email
		@FindBy(xpath="//input[@id='email']")
	    public WebElement Enter_email ;
		
		//Enter Enter_gstNumber
		@FindBy(xpath="//input[@id='gstNumber']")
	    public WebElement Enter_gstNumber ;
		
		//Enter Enter_gstState
		@FindBy(xpath="//div[@class='ant-select-sm ant-select ant-select-enabled ant-select-allow-clear']")
	    public WebElement Enter_gstState ;
		
		
		//Enter Select_gstNumber
		@FindBy(xpath="//li[text()='Maharashtra']")
	    public WebElement Select_gstNumber ;
				
		
		
		//click Addressbutton
		@FindBy(xpath="//button[@class='ant-btn ant-btn-dashed']")
		public WebElement Addressbutton ;
		
		
		
		//@FindBy(xpath="//div[@id='address[1][addressType']")
		@FindBy(xpath="//div[@id='address[1][addressType]']//span//i")
		public WebElement AddressType ;
		
		
		//@FindBy(xpath="//li[text()='Primary Address']")
		@FindBy(xpath="//li[text()='Primary Address']")
		public WebElement Select_AddressType ;
		
		
		@FindBy(xpath="//textarea[@id='address[1][addressLine1]']")
		public WebElement Enter_Address1 ;
		
		
		@FindBy(xpath="//textarea[@id='address[1][addressLine2]']")
		public WebElement Enter_Address2 ;
		
		
		@FindBy(xpath="//input[@id='address[1][phone]']")
		public WebElement Enter_PhoneNo;
		
		
		@FindBy(xpath="//input[@id='address[1][city]']")
		public WebElement Enter_city;
		
		
		@FindBy(xpath="//input[@id='address[1][district]']")
		public WebElement Enter_district;
		
		//div[@class='ant-select-selection__rendered']//div[2]//div//input
		//div[@id='address[1][country]']
		@FindBy(xpath="//div[@id='address[1][country]']")
		public WebElement select_country;
		
		@FindBy(xpath="//li[text()='INDIA']")
		public WebElement select_India;
		
		
		@FindBy(xpath="(//div[@class='ant-select-selection__rendered'])[5]")
		public WebElement select_state;
		
		
		
		@FindBy(id="address[1][postalCode]")
		public WebElement Enter_zipcode;
		
		@FindBy(xpath="//button[@type='submit']")
		public WebElement SubmitButton;
		
		
				
		public void clickonActiveCompany()
		{
			this.click(ActiveCompany);
		}
		
		public void clickonCompany()
		{
			this.click( Company);
		}
		
		public void clickonSettingCompany()
		{
			this.click( SettingCompany);
		}
		
		public void clickonSettingCompanyOkButton()
		{
			this.click( SettingCompanyOkButton);
		}
		
		public void clickonBranchCard()
		{
			this.click( BranchCard);
		}
		public void CreateNewBranch()
		{
			this.click( CreateNewBranch);
		}
		
		public void enterCreatenewBranchDetails(String EnterBranchName,String EnterLocation,String EnterbranchCode,String Enteremail,String EntergstNumber) {
			this.sendkeys(Enter_BranchName, EnterBranchName);
			this.sendkeys(Enter_Location, EnterLocation);
			this.sendkeys(Enter_branchCode, EnterbranchCode);
			this.sendkeys(Enter_email, Enteremail);
			this.sendkeys(Enter_gstNumber ,EntergstNumber );
			this.click(Enter_gstState);
			this.click(Select_gstNumber);
			 
			
		}
		public void enterBranchAddressDetails(String EnterAddress1,String EnterAddress2,String EnterPhoneNo,String  Entercity,String Enterdistrict,String Enterzipcode) throws InterruptedException {
			this.click(Addressbutton);
			this.click(AddressType);
			this.click(Select_AddressType);
			this.sendkeys(Enter_Address1, EnterAddress1);
			this.sendkeys(Enter_Address2 , EnterAddress2);
			this.sendkeys(Enter_PhoneNo, EnterPhoneNo);
			this.sendkeys(Enter_city, Entercity);
			this.sendkeys(Enter_district, Enterdistrict);
			this.click(select_country);
			this.click(select_India);
		    this.click(select_state);
			this.sendkeys(Enter_zipcode, Enterzipcode);
			this.click(SubmitButton);
			
			
		}
		
}
