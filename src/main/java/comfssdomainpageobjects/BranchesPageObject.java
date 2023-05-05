package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;



public class BranchesPageObject extends TestActions {
	
	WebDriver driver;
	Logger log = Logger.getLogger(BranchesPageObject.class);

	public BranchesPageObject (WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//a[@href='/admin/branch/branch-table']")
	public WebElement branch_Card;
	
	@FindBy(xpath="//li[@class='nav__items ']")
	public WebElement master_Module;

	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary']")
	public WebElement createNew;
	
	@FindBy(xpath="//button[@class='ant-btn ant-dropdown-trigger']")
	public WebElement exportAs;
	
	@FindBy(xpath="//i[@class='anticon anticon-file-excel']")
	public WebElement excel;
	
	@FindBy(xpath="//i[@class='anticon anticon-file']")
	public WebElement csv;
	

	@FindBy(xpath="//span[text()='Created Successfully']")
	public WebElement CreatedSuccessfully_Message;
	
	@FindBy(xpath="//div[@class='ant-message-custom-content ant-message-info']")
	public WebElement excelgeneratedSuccessfully_Message;

	@FindBy(xpath="//div[@class='ant-message-custom-content ant-message-info']")
	public WebElement csvgeneratedSuccessfully_Message;
	
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
	
	public void clickOnCloseButton() {
		this.click(closeButton);
	}
	
	@FindBy(xpath="//div[text()='Admin Card']")
	public WebElement admin_cardText;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement update_button;
	
	@FindBy(xpath="//i[@class='anticon anticon-undo']")
	public WebElement reloadSymbol;
	
	@FindBy(xpath="(//span[text()='Master'])[2]")
	public WebElement masterLinkOnBreadcrumb;
	
	@FindBy(xpath="//span[text()='Branches']//parent::a")
	public WebElement branchesLinkOnBreadcrumb;
	//
	@FindBy(xpath="(//span[text()='Branches'])[2]")
	public WebElement branchesTitle_text;
	
	@FindBy(xpath="(//span[text()='Branches'])[2]")
	public WebElement branches_text  ;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement branch_name;
	
	@FindBy(xpath="//input[@id='location']")
	public WebElement branch_location;
	
	@FindBy(xpath="//input[@id='branchCode']")
	public WebElement branch_code;
	
	@FindBy(xpath="//input[@id='email']")
	public WebElement branch_email;
	
	@FindBy(xpath="//input[@id='gstNumber']")
	public WebElement gst_number;
	
	@FindBy(xpath="//div[@id='gstState']")
	public WebElement dropGSTState;
	
	@FindBy(xpath="(//span[text()='Branch Details'])[2]")
	public WebElement branchdetailstext;

	@FindBy(id="branchCode")
	public WebElement branch_Code;

	@FindBy(id="gstNumber")
	public WebElement branch_gstNo;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-dashed']")
	public WebElement addAddress_button;
	
	@FindBy(id="address[1][addressLine1]")
	public WebElement branch_address;
	
	@FindBy(id="address[1][phone]")
	public WebElement branch_phoneNo;
	
	@FindBy(id="address[1][city]")
	public WebElement branch_city;
	
	@FindBy(id="address[1][postalCode]")
	public WebElement branch_zipcode;
	
	@FindBy(xpath="//li[text()='Maharashtra']")
	public WebElement stateMaharashtra;

	@FindBy(xpath="(//div[@class='ant-select-selection__rendered'])[4]")
	public WebElement addressType_dropdown;
	
	@FindBy(xpath="//li[text()='Primary Address']")
	public WebElement primaryAddressType;
	
	@FindBy(xpath="(//div[@class='ant-select-selection__rendered'])[5]")
	public WebElement country_dropdown;

	@FindBy(xpath="//li[text()='INDIA']")
	public WebElement country_India;
	
	@FindBy(xpath="//span[text()='Name']")
	public WebElement name_text;
	
	@FindBy(xpath="//span[text()='Company']")
	public WebElement company_text;
	
	@FindBy(xpath="//span[text()='Location']")
	public WebElement location_text;
	
	@FindBy(xpath="//span[text()='Branch Code']")
	public WebElement branchCode_text;
	
	@FindBy(xpath="//span[text()='GST State']")
	public WebElement gstState_text;
	
	@FindBy(xpath="//span[text()='GST Number']")
	public WebElement gstNumber_text;
	
	@FindBy(xpath="//span[text()='Address']")
	public WebElement address_text;
	
	@FindBy(xpath="//label[text()='Email']")
	public WebElement email_text;
	
	@FindBy(xpath="//span[text()='Save']")
	public WebElement saveButton_text;
	
	@FindBy(xpath="//span[text()='Cancel']")
	public WebElement cancelButton_text;
	
	@FindBy(xpath="//span[text()='Edit']")
	public WebElement editButton;
	
	@FindBy(xpath="//button[@class='ant-btn close-btn ant-btn-primary']")
	public WebElement closeButton;
	
    
    @FindBy(xpath="//div[text()='Admin Card']")
	public WebElement adminCardtext;
    
    @FindBy(xpath="(//span[text()='Branch Update'])[2]")
   	public WebElement branchUpdatetext;
    
    @FindBy(xpath="(//span[text()='Branch Create'])[2]")
   	public WebElement branchCreatetext;
    
    @FindBy(xpath="//input[@id='name[name]']")
   	public WebElement branchNameOnFilterPage;
    
	public void clickOnMasterModule() {
		this.click(master_Module);
	}
	public void clickOnBranchCard() {
		this.click(branch_Card);
	}
	
	public void clickOnCreateNew() {
		this.click(createNew);
	}
	
	public void clickOnMasterLinkOnBreadcrumb() {
		this.click(masterLinkOnBreadcrumb);
	}
	
	public void downloadBranchesInEXCEL()  {
		this.click(exportAs);
		this.click(excel);
		this.click(excelgeneratedSuccessfully_Message);
	}
	
	public void downloadBranchesInCSV() throws InterruptedException {
		this.click(exportAs);
		this.click(csv);
		this.click(csvgeneratedSuccessfully_Message);
	}
	
	public void clickOnViewIcon(){
		this.click(viewIcon);
		this.click(acceptAlert);
	}
	
	
	public void clickOnEditIcon() {
		this.click(editIcon);
		this.click(acceptAlert);
    }
	public void viewBranch(){
		this.waitForEle(viewIcon);
		this.click(viewIcon);
		this.click(acceptAlert);	
	}
	public  void editBranch(String code){
		this.waitForEle(editIcon);
		this.click(editIcon);
		this.click(acceptAlert);
		branch_location.click();
		branch_location.clear();
	    this.sendkeys(branch_location,code);
		this.click(update_button);
}
	public void filterBranch(String name) {
		this.click(filter_button);
		this.sendkeys(branchNameOnFilterPage, name);
		this.click(okFilter);
		this.click(reloadSymbol);
	}
	
	public void clickOnSaveButton() {
		this.click(save_button);
	} 
	public void clickOnCancelButton() {
		this.click(cancel_button);
	}
	
	public void clickOnBranchesLinkOnBreadcrumb() {
		this.click(branchesLinkOnBreadcrumb);
	}
	
	public String isAdminCardTextDisplayed() {
		String adminCardText=adminCardtext.getText();
		return adminCardText;
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
		String CSVgeneratedSuccessfullyMessage=excelgeneratedSuccessfully_Message.getText();
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
	
	public boolean validateCreateNewButtonDisplay( ) {
	    return createNew.isDisplayed();
	}
    public boolean validateCreateNewButtonEnable( ) {
	    return createNew.isEnabled();
	}
    public boolean validateExportAsButtonDisplay( ) {
	    return exportAs.isDisplayed();
	}
    public boolean validateExportAsButtonEnable( ) {
	    return exportAs.isEnabled();
	}
    public boolean validateFilterButtonDisplay( ) {
	    return filter_button.isDisplayed();
	}
    public boolean validateFilterButtonEnable( ) {
	    return filter_button.isEnabled();
	}
	
	
	//-----Methods related to the Branches Create Page----//
	
		public String isBranchNameTextDisplayed() {
			String branchNameText=name_text.getText();
			return branchNameText;
		}
		
		public String isBranchCompanyTextDisplayed() {
			String branchCompanyText=company_text.getText();
			return branchCompanyText;
		}
		public String isBranchLocationTextDisplayed() {
			String branchLocationText=location_text.getText();
			return branchLocationText;
		}
		
		public String isBranchCodeTextDisplayed() {
			String branchCodeText=branchCode_text.getText();
			return branchCodeText;
		}
		
		public String isBranchGSTstateTextDisplayed() {
			String branchGSTstateText=gstState_text.getText();
			return branchGSTstateText;
		}
		
		public String isBranchGSTNumberTextDisplayed() {
			String branchGSTNumberText=gstNumber_text.getText();
			return branchGSTNumberText;
		}
		
		public String isBranchAddressTextDisplayed() {
			String branchAddressText=address_text.getText();
			return branchAddressText;
		}
		
		public String isBranchAddAddressButtonTextDisplayed() {
			String branchAddAddressButtonText=addAddress_button.getText();
			return branchAddAddressButtonText;
		}
		public String isBranchEmailTextDisplayed() {
			String branchEmailText=email_text.getText();
			return branchEmailText;
		}
		
		
	public void enterBranchDetails(String name, String location,String code,String email,String gstNo) {
		this.sendkeys(branch_name, name);
		this.sendkeys(branch_location, location);
		this.sendkeys(branch_Code, code);
		this.sendkeys(branch_email, email);
		this.sendkeys(branch_gstNo, gstNo);
		this.click(dropGSTState);
		this.click(stateMaharashtra);
	}
	
	public void enterBranchAddressDetails(String address, String phoneNo,String city, String zipcode) throws InterruptedException {
		this.click(addAddress_button);
		this.click(addressType_dropdown);
		this.click(primaryAddressType);
		this.click(country_dropdown);
		this.click(country_India);
		this.sendkeys(branch_address, address);
		this.sendkeys(branch_phoneNo, phoneNo);
		this.sendkeys(branch_city, city);
		this.sendkeys(branch_zipcode, zipcode);
	}
	
	
	//
	public String isBranchDetailsTextDisplayed() {
		String branchdetailsText=branchdetailstext.getText();
		return branchdetailsText;
	}
	
	public String isBranchesLinkTextDisplayed() {
		String BranchesLinkText=branchesLinkOnBreadcrumb.getText();
		return BranchesLinkText;
	}
	public String isBranchesTextDispleyed() {
		String airlinetext=branches_text.getText();
		return airlinetext;
	}
	
	public String isBranchUpdateTextDisplayed() {
		String 	branchUpdateText= branchUpdatetext.getText();
		return branchUpdateText;
	}
	public String isBranchCreateTextDispleyed() {
		String branchCreateText=branchCreatetext.getText();
		return branchCreateText;
	}
}
	
	
	//
	