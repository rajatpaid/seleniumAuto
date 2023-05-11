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
	@FindBy(xpath="//li[@class='nav__items ']")
	public WebElement master_Module;
 
	@FindBy(xpath="//span[text()='Service Type']//parent::div")
	public WebElement serviceType_Card;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
	public WebElement createNew;
	
	@FindBy(xpath="//button[@class='ant-btn ant-dropdown-trigger']")
	public WebElement exportAs;
	
	@FindBy(xpath="//i[@class='anticon anticon-file-excel']")
	public WebElement excel;
	
	@FindBy(xpath="//i[@class='anticon anticon-file']")
	public WebElement csv;
	
	@FindBy(xpath="//div[@class='ant-message-custom-content ant-message-info']")
	public WebElement excelgeneratedSuccessfully_Message;

	@FindBy(xpath="//div[@class='ant-message-custom-content ant-message-info']")
	public WebElement csvgeneratedSuccessfully_Message;
	
	@FindBy(xpath="//span[text()='Created Successfully']")
	public WebElement CreatedSuccessfully_Message;
	
	@FindBy(xpath="(//i[@aria-label='icon: edit'])[1]")
	public WebElement editIcon;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ant-btn-sm']")
	public WebElement acceptAlert;
	
	@FindBy(xpath="//div[@class='ant-message-custom-content ant-message-success']")
	public WebElement updatedSuccessfully_Message;
	
	@FindBy(xpath="//i[@class='anticon anticon-eye']")
	public WebElement viewIcon;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary ant-btn-round']")
	public WebElement filter_button;

	@FindBy(xpath="(//button[@class='ant-btn ant-btn-primary'])[2]")
    public WebElement okFilter;
	

	@FindBy(xpath="(//button[@class='ant-btn ant-btn-primary'])[1]")
	public WebElement save_button;

	@FindBy(xpath="(//button[@class='ant-btn ant-btn-primary'])[2]")
	public WebElement cancel_button;
	
	@FindBy(xpath="//div[text()='Admin Card']")
	public WebElement admin_cardText;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement update_button;
	
	@FindBy(xpath="//span[text()='Edit']")
	public WebElement editButton;
	
	@FindBy(xpath="//span[text()='Close']")
	public WebElement closeButton;
	
	@FindBy(xpath="(//span[text()='Master'])[2]")
	public WebElement masterLinkOnBreadcrumb;
	
	@FindBy(xpath="//i[@class='anticon anticon-undo']")
	public WebElement reloadSymbol;
	
	@FindBy(xpath="(//span[text()='Service Type'])[1]")
	public WebElement serviceTypeLinkOnBreadcrumb;
	
	@FindBy(xpath="//span[text()='Service Type Details']//parent::div")
	public WebElement serviceTypedetails_text;

	@FindBy(xpath="//span[text()='Service Type Create']//parent::div")
	public WebElement serviceTypeCreate_text;
	
	@FindBy(xpath="//span[text()='Service Type']//parent::div")
	public WebElement serviceType_text;
	
	@FindBy(xpath="(//span[text()='Service Type Update'])[2]")
	public WebElement serviceType_update_text;
	
	//
	@FindBy(xpath="//input[@id='name']")
	public WebElement serviceType_name;

	@FindBy(xpath="//input[@id='code']")
	public WebElement serviceType_code;

	@FindBy(id="name[name]")
	public WebElement serviceTypeNameOnFilter;

	public void clickOnMasterModule() {
		this.click(master_Module);
	}
	public void clickOnServiceTypeCard() {
		this.click(serviceType_Card);
	}
	public void openServiceTypeCard() {
		this.click(master_Module);
		this.click(serviceType_Card);
	}
	
	public void clickOnCreateNew() {
		this.click(createNew);
	}
	
	public void clickOnMasterLinkOnBreadcrumb() {
		this.click(masterLinkOnBreadcrumb);
	}
	
	public void downloadServiceTypeInEXCEL()  {
		this.click(exportAs);
		this.click(excel);
		this.click(excelgeneratedSuccessfully_Message);
	}
	
	public void downloadServiceTypeInCSV() throws InterruptedException {
		this.click(exportAs);
		this.click(csv);
		this.click(csvgeneratedSuccessfully_Message);
	}
	public void clickOnViewIcon() throws InterruptedException{
		Thread.sleep(2000);
		//this.waitForEle(viewIcon);
		this.click(viewIcon);
		this.click(acceptAlert);	
	}
	public void clickOnEditIcon() throws InterruptedException{
		Thread.sleep(2000);
		this.click(editIcon);
		this.click(acceptAlert);
}
	
	public void viewServiceType() throws InterruptedException{
		Thread.sleep(2000);
		//this.waitForEle(viewIcon);
		this.click(viewIcon);
		this.click(acceptAlert);	
	}
	public  void editServiceType(String iata) throws InterruptedException{
		Thread.sleep(2000);
		//this.waitForEle(editIcon);
		this.click(editIcon);
		this.click(acceptAlert);
		serviceType_name.click();
		serviceType_name.clear();
	    this.sendkeys(serviceType_name,iata);
		this.click(update_button);
		
}
	public void filterServiceType(String name) {
		this.click(filter_button);
		this.sendkeys(serviceTypeNameOnFilter, name);
		this.click(okFilter);
		this.click(reloadSymbol);
	}
	
	
	
	public void clickOnCancelButton() {
		this.click(cancel_button);
	}
	public void clickOnCloseButton() {
		this.click(closeButton);
	}
	
	public String isAdminCardTextDisplayed() {
		String admincardText=admin_cardText.getText();
		return admincardText;
	}
	
	public void clickOnAirlinesLinkOnBreadcrumb() {
		this.click(serviceTypeLinkOnBreadcrumb);
	}
	
	public String isCreateNewButtonTextDisplayed() {
		String CreateNewButtonText=createNew.getText();
		return CreateNewButtonText;
	}
	public String isExportAsButtonTextDisplayed() {
		String ExportAsButtonText=exportAs.getText();
		return ExportAsButtonText;
	}
	public String isFilterButtonTextDisplayed() {
		String FilterButtonText=filter_button.getText();
		return FilterButtonText;
	}
	public String isMasterLinkTextDisplayed() {
		String MasterLinkText=masterLinkOnBreadcrumb.getText();
		return MasterLinkText;
	}
	public String isCreatedSuccessfullyMessageDisplayed() {
		String CreatedSuccessfullyMessage=CreatedSuccessfully_Message.getText();
		return CreatedSuccessfullyMessage;
	}
	public String isEXCELgeneratedSuccessfullyMessageDisplayed() {
		String EXCELgeneratedSuccessfullyMessage=excelgeneratedSuccessfully_Message.getText();
		return EXCELgeneratedSuccessfullyMessage;
	}
	public String isCSVgeneratedSuccessfullyMessageDisplayed() {
		String CSVgeneratedSuccessfullyMessage=csvgeneratedSuccessfully_Message.getText();
		return CSVgeneratedSuccessfullyMessage;
	}

	public String isUpdatedSuccessfullyMessageDisplayed() {
		String UpdatedSuccessfullyMessage=updatedSuccessfully_Message.getText();
		return UpdatedSuccessfullyMessage;
	}
	
	public String isEditButtonTextDisplayed() {
		String EditButtonText=editButton.getText();
		return EditButtonText;
	}
	
	public String isCloseButtonTextDisplayed() {
		String CloseButtonText=closeButton.getText();
		return CloseButtonText;
	}
	
	public String isSaveButtonTextDisplayed() {
		String SaveButtonText=save_button.getText();
		return SaveButtonText;
	}

	public String isCancelButtonTextDisplayed() {
		String CancelButtonText=cancel_button.getText();
		return CancelButtonText;
	}

	public String isUpadateButtonDisplayed() {
		String 	updatebutton= update_button.getText();
		return updatebutton;
	}
	
	public void createServiceType(String servicetypename,String servicetypecode) throws InterruptedException {
		this.sendkeys(serviceType_name, servicetypename);
		this.sendkeys(serviceType_code, servicetypecode);
		this.click(save_button);
	}

	public String isServiceTypeDetailsTextDisplayed() {
		String serviceTypeDetails=serviceTypedetails_text.getText();
		return serviceTypeDetails;
	}

	public String isServiceTypeLinkTextDisplayed() {
		String serviceTypeLink=serviceTypeLinkOnBreadcrumb.getText();
		return serviceTypeLink;
	}
	public String isServiceTypeTextDispleyed() {
		String serviceTypeText=serviceType_text.getText();
		return serviceTypeText;
	}

	public String isServiceTypeUpdateTextDisplayed() {
		String 	serviceTypeUpdateText= serviceType_update_text.getText();
		return serviceTypeUpdateText;
	}
	public String isServiceTypeCreateTextDispleyed() {
		String serviceTypeCreateText=serviceTypeCreate_text.getText();
		return serviceTypeCreateText;
	}
			
	
}













