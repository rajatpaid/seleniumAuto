package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;


public class ChargeUnitObjects extends TestActions {
	Logger log = Logger.getLogger(ChargeUnitObjects.class);

	WebDriver driver;
	public ChargeUnitObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	} 

	@FindBy(xpath="//span[text()='Charge Unit']//parent::div")
	public WebElement charge_unit;

	@FindBy(xpath="//button[@type='button']//parent::a")
	public WebElement create_new;

	@FindBy(xpath="//input[@id='name']")
	public WebElement chargeunit_name;

	@FindBy(xpath="//input[@id='code']")
	public WebElement chargeunit_code;

	@FindBy(xpath="//*[@id=\"root\"]/section/section/main/div[2]/div/div/div/form/div[2]/div/div/span/button")
	public WebElement save_button;

	@FindBy(xpath="//span[text()='Charge Unit Details']//parent::div")
	public WebElement charge_unit_detials;

	@FindBy(xpath="//div[text()='charge']")
	public WebElement charge_text;

	@FindBy(xpath="//div[text()='Transaction tax']")
	public WebElement chargetypename;

	public void clickOnChargeUnitFolder() {
		this.click(charge_unit);	
	}
	public void clickOnCreateNew() {
		this.click(create_new);
	}
	/*
	 * verify admin enter charge unit details
	 * @Parameters:chrageunitname,chargeunitcode
	 * @return: No 
	 */
	public void enterChargeUnitDetails(String chrageunitname, String chargeunitcode) throws InterruptedException {
		this.sendkeys(chargeunit_name,chrageunitname);
		this.sendkeys(chargeunit_code,chargeunitcode);
		Thread.sleep(4000);
		this.click(save_button);
	}
	public String isChargeUnitDetailsTextDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		String chargeunit=charge_unit_detials.getText();
		return chargeunit;

	}
	public String isChargeUnitNameDisplayed() throws InterruptedException {
		Thread.sleep(3000);
		this.waitForEle(chargetypename);
		String ChargeUnitName= charge_text.getText();
		return ChargeUnitName;

	}
	public String isCompanyNameDisplayed() {
		this.waitForEle(chargetypename);
		String companyName= chargetypename.getText();
		return companyName;	
	}

}













