package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;



public class ServiceTypeObjects extends TestActions {
	WebDriver driver;
	Logger log = Logger.getLogger(ServiceTypeObjects.class);
	public ServiceTypeObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//span[text()='Service Type']//parent::div")
	public WebElement Service_Type;

	@FindBy(xpath="//button[@type='submit']")
	public WebElement create_new;

	@FindBy(xpath="//input[@id='name']")
	public WebElement servicetype_name;

	@FindBy(xpath="//input[@id='code']")
	public WebElement servicetype_code;

	@FindBy(xpath="//*[@id=\"root\"]/section/section/main/div[2]/div/div/div/form/div[3]/button")
	public WebElement save_button;

	@FindBy(xpath="//strong[text()='krishna Tranport and Logistics company']//parent::h3")
	public WebElement comany_name;

	@FindBy(xpath="//span[text()='Service Type Details']//parent::div")
	public WebElement service_type_detailstext;

	@FindBy(xpath="//div[text()='PORT TO PORT']")
	public WebElement servicetyeptext;


	public void clickOnServiceTypeFolder() {
		this.click(Service_Type);
	}

	public void clickOnCreateNewOption() {
		this.click(create_new);
	}
	public void enterServiceTypeDetails(String servicetypename,String servicetypecode) throws InterruptedException {
		this.sendkeys(servicetype_name, servicetypename);
		this.sendkeys(servicetype_code, servicetypecode);
		Thread.sleep(3000);
		this.click(save_button);
	}

	public String isCompanyNameDisplayed() {
		this.waitForEle(comany_name);
		String companyName= comany_name.getText();
		return companyName;	
	}

	public String isServiceTypeDetailsTextDisplayed() {
		this.waitForEle(service_type_detailstext);
		String companyName=service_type_detailstext  .getText();
		return companyName;	
	}
	public String isServiceTypeTextDisplayed() {
		this.waitForEle(servicetyeptext);
		String companyName=servicetyeptext.getText();
		return companyName;	
	}
}













