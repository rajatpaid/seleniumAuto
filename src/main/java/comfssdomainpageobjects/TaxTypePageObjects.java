package comfssdomainpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.BasePackage.TestActions;



public class TaxTypePageObjects extends TestActions {
	WebDriver driver;
	public TaxTypePageObjects(WebDriver driver) {
		super(driver);
		this.driver=driver; 
	} 

	@FindBy(xpath="//button[@type='submit']")
	public WebElement Create_New;

	@FindBy(xpath="//input[@id='code']")
	public WebElement tat_typename;
	
	@FindBy(xpath="//input[@id='description']")
	public WebElement description;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement save_button;
	
	@FindBy(xpath="//span[text()='Tax Type']//parent::div")
	public WebElement taxtype_folder;
	
	@FindBy(xpath="//strong[text()='krishna Tranport and Logistics company']//parent::h3")
	public WebElement comany_name;
	
	@FindBy(xpath="//span[text()='Tax Type Details']//parent::div")
	public WebElement tax_type_detailstext;

	
	public void clickOnTaxTypeFolder() {
		this.click(taxtype_folder);
	}
	
	public void clickOnCreateNewOption() {
		this.click(Create_New);
	}
	
	public void enterTaxTypeDetails(String taxtypename,String Description ) {
		this.sendkeys(tat_typename, taxtypename);
		this.sendkeys(description,Description);
	}
	
	public String isCompanyNameDisplayed() {
		this.waitForEle(comany_name);
		String companyName= comany_name.getText();
		return companyName;	
	}
	public String isTaxTypeDetailsTextDisplayed() {
		this.waitForEle(tax_type_detailstext);
		String TaxTypeDetailsTex=tax_type_detailstext.getText();
		return TaxTypeDetailsTex;	
	}
	public String isCretaeNewOptionDislpayed() {
		
	String cretaenewtext=Create_New.getText();
	
	return cretaenewtext;
		
	}

}
 