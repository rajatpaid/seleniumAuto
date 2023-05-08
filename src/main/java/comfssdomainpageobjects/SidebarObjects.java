package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;

public class SidebarObjects extends TestActions{
	WebDriver driver;
    Logger log = Logger.getLogger(SidebarObjects.class);
    public SidebarObjects(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    } 
    
    @FindBy(xpath="//img[@alt='Super Admin']")
    public WebElement superadminsidebar;
    
    public void clickOnsuperadminsidebar() {
        this.click(superadminsidebar);
    }
}
