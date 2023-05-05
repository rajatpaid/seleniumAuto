package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.BasePackage.TestActions;
import com.UtilitiesClasses.Constants;





public class AdminSignInPageObjects extends TestActions {
	WebDriver driver;
	AdminSignInPageObjects signinpage;
	Logger log = Logger.getLogger(AdminSignInPageObjects.class);

	public AdminSignInPageObjects(WebDriver driver) {
		super(driver);
		this.driver=driver;

		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//input[@id='userName']")
	public WebElement adminUserId;	

	@FindBy(xpath="//input[@id='password']")
	public WebElement adminPassword;

	@FindBy(xpath="//button[@type='submit']")
	public WebElement adminLoginButton;

	@FindBy(xpath="//*[text()='Adming@gmail.com']")
	public WebElement admin_email_text;

	@FindBy(xpath="//span[@class='ant-typography']//parent::code")
	public WebElement admin_role;

	@FindBy(xpath="//strong[ text()='Adming Jadhav']")
	public WebElement user_name_text;
	
	@FindBy(id="remember")
	WebElement rememberMeCheackbox;
	
	@FindBy(xpath="//a[text()='Forgot password ?']")
	WebElement forgotPassword_Link;


	@FindBy(xpath = "//li[@class='gx-user-nav']")
	public WebElement admin_profile;
	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement btnlogout;
	

	@FindBy(xpath="//strong[text()='krishna Tranport and Logistics company']//parent::h3")
	public WebElement comany_name;

	
	/*
	 * verify admin enter user id.
	 * @Parameters:adiminuserid
	 * @return: No 
	 */

	public void enterAdminUsername(String adiminuserid) {
		this.sendkeys(adminUserId,adiminuserid);	
	}

	/*
	 * verify admin enter user password.
	 * @Parameters:adminpassword
	 * @return:No
	 */
	public void enterAdminPassword(String adminpassword) {
		this.sendkeys(adminPassword,adminpassword);
	}

	/*
	 * verify admin click on login button.
	 * @Parameters:No
	 * @return: No
	 */
	public void clickOnAdminProfile() {
		this.click(admin_profile);
	}
	public void clickOnLoginButton() {
		this.click(adminLoginButton);
	}
	
	public boolean isUsernameTextboxDisplayed( ) {
		 return adminUserId.isDisplayed();
	}
	public boolean isPasswordTextboxDisplayed( ) {
	    return adminPassword.isDisplayed();
	}
	
	public String isLOGINButtonTextDisplayed( ) {
		String LOGINButtonText=adminLoginButton.getText();
	    return LOGINButtonText;
	}
    public boolean isLOGINButtonEnabled( ) {
	    return adminLoginButton.isEnabled();
	}
    public boolean isRememberMeCheackboxSelected( ) {
    	rememberMeCheackbox.click();
	    return rememberMeCheackbox.isSelected();

    }
    public boolean isforgotPasswordLinkDisplayed( ) {
    	return forgotPassword_Link.isDisplayed();
	}
    public boolean isforgotPasswordLinkEnabled( ) {
	    return forgotPassword_Link.isEnabled();
	}
    public boolean isAdminProfileIconDisplayed( ) {
    	return admin_profile.isDisplayed();
	}
	/*
	 * verify profile name is displayed.
	 * @Parameters:
	 * @return: string 
	 */
    public String isEmailDisplayed() {
    	String ActualdProfileText= admin_email_text.getText();
    	return ActualdProfileText;
    }
    
    
	public String isAdminProfileNameDisplayed() {
		String ActualdProfileText = null;
		log.info("Click on admin profile");
		try {
			this.click(admin_profile);
			ActualdProfileText= admin_email_text.getText();
		} catch (Exception e) {
			log.info("Failure to click on  admin profile");	
		}
		return ActualdProfileText;
	}
	/*
	 * verify admin text  is displayed.
	 * @Parameters:
	 * @return: string 
	 */
	public String isAdminRoleDisplayed() {
		String ActualText=null;
		try {
			ActualText= admin_role.getText();
		} catch (Exception e) {
			log.info("admin text is displayed");	
		}
		return ActualText;
	}
	public String isUserNameDisplayed() {
		
		String username=null;
		log.info("Click on admin profile");
		try {

			username= user_name_text.getText();
		} catch (Exception e) {
			log.info("Failure to click on  admin profile");	
		}
		return username;
				
	}
	
	public String isCompanyNameDisplayed() {
		this.waitForEle(comany_name);
		String companyName= comany_name.getText();
		return companyName;	
	}
	
	
	public void adminLogin() {
		navigateUrl(Constants.URL) ; 
		enterAdminUsername(Constants.adminUsername); 
		enterAdminPassword(Constants.adminPassword); 
		clickOnLoginButton(); 	 
	}
}

















