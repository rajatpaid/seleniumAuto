package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;


public class ChargeTypeObjects extends TestActions {
	WebDriver  driver;
	Logger log = Logger.getLogger(ChargeTypeObjects.class);
	public ChargeTypeObjects (WebDriver  driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Charge Type']//parent::div")
	public WebElement chargetype;

	@FindBy(xpath="//button[@type='button' and @class='ant-btn ant-btn-primary']")
	public WebElement create_new;

	@FindBy(xpath="//input[@id='name']")
	public WebElement charge_typename;

	@FindBy(xpath="//input[@id='code']")
	public WebElement charge_typecode;

	@FindBy(xpath="//*[@id=\"root\"]/section/section/main/div[2]/div/div/div/form/div[2]/div/div/span/button")
	public WebElement save_button;

	@FindBy(xpath="//span[text()='Charge Type Details']//parent::div")
	public WebElement chargetype_details;

	@FindBy(xpath="//strong[text()='krishna Tranport and Logistics company']//parent::h3")
	public WebElement comany_name;

	@FindBy(xpath="//div[text()='CHARGE']")
	public WebElement chargecodename;

	@FindBy(xpath="//div[text()='Transaction tax']")
	public WebElement chargetypename;

	public void clickOnChargeTypeFolder() {
		this.click(chargetype);
	}
	public void clickOnCreateNewOption() {
		this.click(create_new);
	}
	public void enterChargeTypeDetails(String chargetypename,String chargetypecode) throws InterruptedException {
		this.sendkeys(charge_typename,chargetypename);
		this.sendkeys(charge_typecode, chargetypecode);
		Thread.sleep(1000);
		this.click(save_button);
	}
	public String isChargeTypeDetailsPgageDisplayed() {
		this.waitForEle(chargetype_details);
		String text1= chargetype_details.getText();
		return text1;

	}
	public String isCompanyNameDisplayed() {
		this.waitForEle(chargetype_details);
		String companyName= comany_name.getText();
		return companyName;	
	}

	public String isChargeCodeDisplayed() {

		String chargecode=chargecodename.getText();
		return chargecode;
	}
	public String isChargetypediplayed() {
	String chargetypeName=	chargetypename.getText();
	return chargetypeName;
		
	}

}
