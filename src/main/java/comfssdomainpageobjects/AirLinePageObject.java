package comfssdomainpageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BasePackage.TestActions;



public class AirLinePageObject extends TestActions {
	WebDriver driver;
	Logger log = Logger.getLogger(AirLinePageObject.class);
	public AirLinePageObject(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@class='nav__items ']")
	public WebElement master_Module;

	@FindBy(xpath="//*[text()='Airline']")
	public WebElement airline_Card;

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
	
  
    
	//
	@FindBy(xpath="(//span[text()='Airlines'])[1]")
	public WebElement airlinesLinkOnBreadcrumb;
	
	@FindBy(xpath="//span[text()='Airline Details']//parent::div")
	public WebElement airlinedetails_text;

	@FindBy(xpath="//span[text()='Airline Create']//parent::div")
	public WebElement airlinesCreate_text;
	
	@FindBy(xpath="//span[text()='Airlines']//parent::div")
	public WebElement airlines_text;
	
	@FindBy(xpath="//span[text()='Airline Update']//parent::a")
	public WebElement airline_update_text;
	//
	@FindBy(xpath="//input[@id='airlineName']")
	public WebElement airline_name;

	@FindBy(xpath="//input[@id='iata']")
	public WebElement airline_iata;

	@FindBy(xpath="//input[@id='icao']")
	public WebElement airline_icao;
	
	@FindBy(xpath="(//div[@class='ant-select-selection__rendered'])[2]")
	public WebElement country_dropdown;

	@FindBy(xpath="//li[text()='INDIA']")
	public WebElement country_India;
	
	@FindBy(id="callsign")
	public WebElement airline_Callsign;
	
	@FindBy(id="alias")
	public WebElement airline_Alias;

	@FindBy(xpath="//span[text()='Name']")
	public WebElement name_text;

	@FindBy(xpath="//span[text()='IATA']")
	public WebElement iata_text;

	@FindBy(xpath="//span[text()='ICAO']")
	public WebElement icao_text;
	
	@FindBy(xpath="//span[text()='Alias']")
	public WebElement alias_text;
	
	@FindBy(xpath="//span[text()='Callsign']")
	public WebElement callsign_text;

	@FindBy(xpath="//span[text()='Country']")
	public WebElement country_text;

	
	@FindBy(id="airlineName[airlineName]")
	public WebElement airlineNameOnFilter;

	
	public void clickOnAirlineCard() {
		this.click(airline_Card);
	}
	
	public void clickOnMasterModule() {
		this.click(master_Module);
	}

	public void clickOnCreateNew() {
		this.click(createNew);
	}
	
	public void clickOnMasterLinkOnBreadcrumb() {
		this.click(masterLinkOnBreadcrumb);
	}
	
	public void selectEXCELOptionFromDropdown()  {
		this.click(exportAs);
		this.click(excel);
		this.click(excelgeneratedSuccessfully_Message);
	}
	
	public void selectCSVOptionFromDropdown() throws InterruptedException {
		this.click(exportAs);
		this.click(csv);
		this.click(csvgeneratedSuccessfully_Message);
	}
	
	public void clickOnViewIcon(){
		this.waitForEle(viewIcon);
		this.click(viewIcon);
		this.click(acceptAlert);	
	}
	public void clickOnEditIcon(){
		this.waitForEle(editIcon);
		this.click(editIcon);
		this.click(acceptAlert);
}
	
	public void clickOnFilterButton() {
		this.click(filter_button);
}
	
	public void clickOnUpdateButton() {
		this.click(update_button);
}
	public void clickOnReloadSymbol() {
		this.click(reloadSymbol);
	}
	
	public void clickOnSaveButton() {
		this.click(save_button);
	} 
	public void clickOnCancelButton() {
		this.click(cancel_button);
	}
	public void clickOnCloseButton() {
		this.click(closeButton);
	}
	
	public void updateAirlineDetails(){	
		this.click(editIcon);
		this.click(acceptAlert);
		this.sendkeys(airline_icao, "ERD");	
	}

	public void enterAirlineNameOnFilterAndClickOnOK(String filtername) {
		this.sendkeys(airlineNameOnFilter, filtername);
		this.click(okFilter);
	}
	
	public String isAdminCardTextDisplayed() {
		String admincardText=admin_cardText.getText();
		return admincardText;
	}
	
	public void clickOnAirlinesLinkOnBreadcrumb() {
		this.click(airlinesLinkOnBreadcrumb);
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
	//Airline Create Page Elements Texts
	public String isNameTextDisplayed() {
		String NameText=name_text.getText();
		return NameText;
	}
	public String isIATATextDisplayed() {
		String IATAText=iata_text.getText();
		return IATAText;
	}
	public String isICAOTextDisplayed() {
		String ICAOText=icao_text.getText();
		return ICAOText;
	}
	
	public String isAliasTextDisplayed() {
		String AliasText=alias_text.getText();
		return AliasText;
	}
	
	public String isCallsignTextDisplayed() {
		String CallsignText=callsign_text.getText();
		return CallsignText;
	}
	
	//
	
	public String isAirlineLinkTextDisplayed() {
		String AirlineLinkText=airlinesLinkOnBreadcrumb.getText();
		return AirlineLinkText;
	}

	public String isAirlinesDetailsTextDisplayed() {
		String AirlinesDetailsText=airlinedetails_text.getText();
		return AirlinesDetailsText;
	}

	public String isAirlinesTextDispleyed() {
		String airlinetext=airlines_text.getText();
		return airlinetext;
	}
	public String isAirlineCreateTextDispleyed() {
		String airlineCreateText=airlinesCreate_text.getText();
		return airlineCreateText;
	}
	public String isAirLineUpdateTextDisplayed() {
		this.waitForEle(airline_update_text);
		String 	airlinedupadatetext= airline_update_text.getText();
		return airlinedupadatetext;
	}
	
	public void enterAirlineDetails(String name, String iatacode, String icaocode,String callsign, String alias) {
		this.sendkeys(airline_name, name);
		this.sendkeys(airline_iata, iatacode);
		this.sendkeys(airline_icao, icaocode);
		this.sendkeys(airline_Alias, callsign);
		this.sendkeys(airline_Callsign, alias);
		this.click(country_dropdown);
		this.click(country_India);
	}

	
		
}






