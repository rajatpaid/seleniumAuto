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
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement servicetype_name;

	@FindBy(xpath="//input[@id='code']")
	public WebElement servicetype_code;

	

	
	public void enterServiceTypeDetails(String servicetypename,String servicetypecode) throws InterruptedException {
		this.sendkeys(servicetype_name, servicetypename);
		this.sendkeys(servicetype_code, servicetypecode);
		Thread.sleep(3000);
		//this.click(save_button);
	}

	
}













