package comfssdomainpageobjects;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.BasePackage.TestActions;

public class SuperAdminCompanyCardObjects extends TestActions{
	 WebDriver driver;
		Logger log = Logger.getLogger(SuperAdminCompanyCardObjects.class);
				public  SuperAdminCompanyCardObjects(WebDriver driver) {
	    	super(driver);
	    	this.driver=driver;
			PageFactory.initElements(driver, this); 			
	}
			//superadmin sidebar
			@FindBy(xpath="//img[@alt='Super Admin']")
			public WebElement superadminsidebar;
			
			//superadmin sidebar method
			public void clickOnsuperadminsidebar() 
			{
			this.click(superadminsidebar);
			}
		    
			//superadmin company card
			@FindBy(xpath="//div[@id='root']//section/section/main/div[2]/div/div/div/div[2]/div[2]/div/div[1]/a/div/div/div")
			public WebElement CompanyCard;	
			
			//click on company card method
			public void clickOnCompanyCard() 
			{
			this.click(CompanyCard);
			}

			//create new company
			@FindBy(xpath="//div[@id='root']/section/section/main/div[2]/div/div/div/a/button")
			public WebElement create_new;
			
			public void clickOnCreateNew() {
				this.click(create_new);
			}
			
			//enter name
			@FindBy(xpath="//input[@id='name']")
			public WebElement company_name;
			
			
			//enter email
			
			@FindBy(xpath="//input[@id='email']")
			public WebElement company_email;
			
			//currency dropdown
			//div[@id="cce0ed95-1718-4269-e6e8-b67611389f53"]/ul/li[3]
			////ul//li[3]
			@FindBy(xpath="//div[@id='accountingCurrency']")
			public WebElement Select_Currency;
			
			//click on INR or USD
			@FindBy(xpath="//li[text()='INR']")
			public WebElement Currency_dropdown_INR;
			
			//Enter mobile number
			@FindBy(xpath = "//input[@id='mobileNumber']")
			public WebElement Mobile_Number;
			
			//Enter Pin Code
			@FindBy(xpath = "//input[@id='pinCode']")
			public WebElement Pin_Code;
			
			//Enter State
			@FindBy(xpath = "//input[@id='state']")
			public WebElement State_name;
			
			//Enter country
			@FindBy(xpath ="//input[@id='country']")
			public WebElement Country_name;
			
			//Enter Website name
			@FindBy(xpath="//input[@id='website']")
			public WebElement Website_Name;
			
			
			//Enter Location
		     @FindBy(xpath="//input[@id='location']")
			 public WebElement Company_Location;
			
				
			//Enter FAX_Number
			@FindBy(xpath = "//input[@id='fax']")
			public WebElement FAX_Number;
			
			//Enter FIATA Code
			@FindBy(xpath = "//input[@id='fiataCode']")
			public WebElement FIATA_Code;
			
			//Enter IATA_Code
			@FindBy(xpath = "//input[@id='iataCode']")
			public WebElement IATA_Code;
			
			//Enter VAT Number
			@FindBy(xpath = "//input[@id='vat']")
			public WebElement VAT_Number;
			
			//Enter Dimention unit
			@FindBy(xpath = "//div[@id='dimentionUnit']")
			public WebElement Dimention_unit;
			
			//select Dimention_unit
			@FindBy(xpath="//li[text()='MM']")
			public WebElement Dimention_unit_m;
			
			//Enter Volume Unit
			@FindBy(xpath = "//div[@id='volumeUnit']")
			public WebElement Volume_Unit;
			
			//select Volume Unit
			@FindBy(xpath="//li[text()='KM']")
			public WebElement Volume_Unit_cm;
					
			//Enter Weight Unit
			@FindBy(xpath = "//div[@id='weightUnit']")
			public WebElement Weight_Unit;
			
			//select weight unit
			@FindBy(xpath="//li[text()='K']")
			public WebElement Weight_Unit_k;
			
			//Enter GST Number
			@FindBy(xpath = "//input[@id='gst']")
			public WebElement GST_Number;
									
			//Enter Billing Date
			@FindBy(xpath = "//span[@id='monthlyBillingDate']")
			public WebElement Billing_Date;
			
			//Select billing date
			@FindBy(xpath="//td[@title='May 2, 2023']")
			public WebElement Select_Billing_Date;
			
			//Enter finance Start Date
			@FindBy(xpath = "//span[@id='financeStartDate']")
			public WebElement finance_Start_Date;
			
			//Select Select_finance_Start_Date
			@FindBy(xpath="//tr[@class='ant-calendar-current-week ant-calendar-active-week']//td[3]")
			public WebElement Select_finance_Start_Date;
			
			//click on ok
			@FindBy(xpath="//a[text()='Ok']")
			public WebElement click_on_ok;
			
			//Enter finance End Date
			@FindBy(xpath = "//span[@id='financeEndDate']//div//input")
			public WebElement finance_End_Date;
			
			//Select Select_finance_end_Date_year
			@FindBy(xpath="//a[@class='ant-calendar-next-year-btn']")
			public WebElement Select_finance_End_Date_Year;
					
			//Select Select_finance_End_Date
			@FindBy(xpath="//tbody[@class='ant-calendar-tbody']//tr[2]//td[2]")
			public WebElement Select_finance_End_Date;
			
			// Click_on_ok
			@FindBy(xpath="//span[@class='ant-calendar-footer-btn']//a[3]")
			public WebElement Click_on_ok;
			
			//Enter Status
			@FindBy(xpath = "//div[@id='active']//label[2]")
			public WebElement Status_Active;
			
			//Enter Description
			@FindBy(xpath="//span[@class='ant-form-item-children']//textarea")
			public WebElement  Enter_Description;
			
			//Enter Bank Account number
			@FindBy(xpath="//input[@id='bankAccountNumber']")
			public WebElement Bank_Account_Number;
			
			//select Bank Account
			@FindBy(xpath="//div[@id='bankAccount']//div//div")
			public WebElement Select_Bank_Account;
			
			//Select Saving Button
			@FindBy(xpath="//li[text()='Savings']")
			public WebElement Click_on_Saving_Button;
			
			//Enter Account Holder
			@FindBy(xpath="//input[@id='bankAccountHolderName']")
			public WebElement Enter_Account_Holder;
			
			//Bank deatils.
			@FindBy(xpath="//input[@id='bankName']")
			public WebElement Bank_Name;
			
			//Bank branch.
			@FindBy(xpath="//input[@id='bankBranch']")
			public WebElement Bank_Branch;
			
			// Beneficiary_Name
			@FindBy(xpath="//input[@id='beneficiaryName']")
			public WebElement Beneficiary_Name;
			
			//
			// IFS CODE
			@FindBy(xpath="//input[@id='ifscCode']")
			public WebElement IFS_CODE;
			
			//UPLODA FILE
			@FindBy(xpath="//button[@class='ant-btn']")
			public WebElement UPLODA_FILE;
			//public String file_name;
			
		
			
			//Enter save button
			@FindBy(xpath = "//button[@type='submit']")
			public WebElement  Save_button;


			public void enterCreatenewCompanyDetails(String CompanyName,String Email,String MobileNumber,String PinCode,String StateName,String Countryname,String WebsiteName,String Location,String FAXNumber,String IATACode,String  VATNumber,String FIATACode,String GSTNumber,String EnterDescription,String BankAccountNumber,String EnterAccountHolder,String BankName,String BankBranch,String  BeneficiaryName,String IFSCODE) throws InterruptedException {
				this.sendkeys(company_name, CompanyName);
				this.sendkeys(company_email, Email);
				this.click(Select_Currency);
				//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				//Thread.sleep(3000);//implici/explicit wait
				this.click(Currency_dropdown_INR);
				Thread.sleep(3000);
				this.sendkeys(Mobile_Number,MobileNumber);
				this.sendkeys(Pin_Code, PinCode);
				this.sendkeys(State_name,StateName);
				this.sendkeys(Country_name,Countryname);
				this.sendkeys(Website_Name, WebsiteName);
				this.sendkeys(Company_Location, Location);
				this.sendkeys(FAX_Number, FAXNumber);
				this.sendkeys(FIATA_Code, FIATACode);
				this.sendkeys(IATA_Code,IATACode);
				this.sendkeys(VAT_Number, VATNumber);
				this.click(Dimention_unit);
				this.click(Dimention_unit_m);
				this.click(Volume_Unit);
				this.click( Volume_Unit_cm);
				this.click(Weight_Unit);
				this.click(Weight_Unit_k);
				this.sendkeys(GST_Number,GSTNumber);
				this.click(Billing_Date);
				this.click(Select_Billing_Date);
				this.click(finance_Start_Date);
				this.click(Select_finance_Start_Date);
				this.click(click_on_ok);
			        this.click(Select_finance_End_Date_Year);
				this.click(Select_finance_End_Date);
				this.click(Click_on_ok);
				this.click(Status_Active);
				this.sendkeys( Enter_Description,  EnterDescription);
				this.sendkeys(Bank_Account_Number, BankAccountNumber);
				this.click(Select_Bank_Account);
				this.click(Click_on_Saving_Button);
				this.sendkeys(Enter_Account_Holder, EnterAccountHolder);
				this.sendkeys(Bank_Name, BankName);
				this.sendkeys(Bank_Branch,BankBranch);
				this.sendkeys( Beneficiary_Name,  BeneficiaryName);
				this.sendkeys(IFS_CODE, IFSCODE);
				this.click(UPLODA_FILE);
				this.click(Save_button);
}
}