package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;



public class MasterModuleObject extends TestActions{
    WebDriver driver;
	Logger log = Logger.getLogger(MasterModuleObject.class);
    public MasterModuleObject(WebDriver driver) {
    	super(driver);
    	this.driver=driver;
		PageFactory.initElements(driver, this);
    } 
    
    @FindBy(xpath="//li[@class='nav__items ']")
	public WebElement master;
    
    public void clickOnMaterModule() {
		this.click(master);
	}
}
