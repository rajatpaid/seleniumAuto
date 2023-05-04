package comfssdomainpageobjects;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;

public class DashboardPage extends TestActions{
	public WebDriver driver;

	public DashboardPage(WebDriver driver){
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);


	}
	@FindBy(xpath="//body[@class='full-layout']")  
	@CacheLookup
	WebElement dashboard;

	@FindBy(xpath="//*[text()='Shiv Logistics & Transport Company']")  
	@CacheLookup
	WebElement txtcompanyName;


	@FindBy(xpath="//i[@aria-label='icon: down']")  
	@CacheLookup
	WebElement dropActiveBranch;


	@FindBy(xpath="(//div[@title='Pune'])[1]")  
	@CacheLookup
	WebElement puneBranch;


	@FindBy(xpath="")
	@CacheLookup
	WebElement droplanguage;


	@FindBy(xpath="//nav[@class='nav__cont']")
	@CacheLookup
	WebElement sideMenuBar;

	@FindBy(xpath="//img[@alt='no image']")
	@CacheLookup
	WebElement icon;

	@FindBy(xpath="//div[@class=\"ant-select-sm ant-select ant-select-enabled\"]")
	@CacheLookup
	WebElement a;

	@FindBy(xpath="//span[@class='ant-calendar-picker']")
	@CacheLookup
	WebElement calender;

	@FindBy(xpath="//td[@title='Jan']")
	@CacheLookup
	WebElement fromJan;

	@FindBy(xpath="(//td[@title='Mar'])[2]")
	@CacheLookup
	WebElement toMarch;

	@FindBy(xpath="(//*[text()='Inquiries'])[2]")
	@CacheLookup
	WebElement inquriesStatus;

	@FindBy(xpath="(//*[text()='Quotations'])[2]")
	@CacheLookup
	WebElement quoteStatus;

	@FindBy(xpath="(//*[text()='Shipments'])[2]")
	@CacheLookup
	WebElement shipmentStatus;

	@FindBy(xpath="(//div[@class=' ant-tabs-tab'])[3]")
	@CacheLookup
	WebElement ageingwiseQuote_0To2Days ;

	@FindBy(xpath="(//div[@class=' ant-tabs-tab'])[4]")
	@CacheLookup
	WebElement ageingwiseQuote_3To4Days;

	@FindBy(xpath="(//div[@class=' ant-tabs-tab'])[5]")
	@CacheLookup
	WebElement ageingwiseQuote_5To6Days;

	@FindBy(xpath="")
	@CacheLookup
	WebElement ageingwiseQuote_morethan6Days;


	

	public void selectApplicationLanguge( ) {


	}
	public void selectActiveBranch( ) throws InterruptedException {
		dropActiveBranch.click();
		Thread.sleep(2000);
		puneBranch.click();
		/*Select dropdown=new Select(droplanguage);
    	List<WebElement> allOptions=dropdown.getOptions();
    	for(WebElement options :allOptions ) {
    		if(options.getText().equals("Pune")) {
    			options.click();
    			break;
    		}

    	} */

	}
	public String isSideMenuBarDisplayed() {
		

		String airlinedetailstext = sideMenuBar.getText();

		return airlinedetailstext;

	}
	
	 public boolean  validateDashboardPageDisplay( ) {
		  
	    return dashboard.isDisplayed();
		

	}
	public void calenderPicker( ) {
this.click(calender);
this.click(fromJan);
this.click(toMarch);
		
	}

	public void clickOnStatusgraphs( ) {
		this.click(inquriesStatus);
		this.click(quoteStatus);
		this.click(shipmentStatus);
		

	}

	public void clickOnAgeingwiseQuote( ) {
		this.click(ageingwiseQuote_0To2Days);
		this.click(ageingwiseQuote_3To4Days);
		this.click(ageingwiseQuote_5To6Days);
		
		
	}
	public String isCompanyNameDisplayed() {
		
		String companyName= txtcompanyName.getText();
		return companyName;	
	}

}
