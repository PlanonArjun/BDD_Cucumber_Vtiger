package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.WebDriverUtility;


public class OrganizationPage {

	@FindBy(xpath = "//*[contains(@alt,'Create Organization...')]") // img[@alt='Create Organization...']
	private WebElement createOrgLookUpImg;

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(xpath = "//*[contains(@name, 'industry')]")
	private WebElement industryDropDwn;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// @FindBy(xpath = "//*[contains(@class,'dvHeaderText')]")
	@FindBy(css = "[class='dvHeaderText']")
	private WebElement orgFromHeaderText;

	@FindBy(xpath = "//img[@src='themes/softed/images/tbarExport.gif']")
	private WebElement exportOrgExcel;

	@FindBy(xpath = "//input[@name='Export']")
	private WebElement exportOrgExcelBtn;

	// Business Library
	public void clickOnLeadLookUpImage() {
		createOrgLookUpImg.click();
	}

	public WebElement getCreatedOrgHeaderText() {
		return orgFromHeaderText;
	}

	public void createOrganization(WebDriver driver, String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
		WebDriverUtility.fluentWait(driver, orgFromHeaderText);

	}

	public void createOrganizationWithIndustry(WebDriver driver, String orgname, String industryType) {
		createOrgLookUpImg.click();
		orgNameEdt.sendKeys(orgname);
		WebDriverUtility.handleDropDown(industryDropDwn, industryType);
		saveBtn.click();
		WebDriverUtility.fluentWait(driver, orgFromHeaderText);

	}

	public String getHeader() {
		return getCreatedOrgHeaderText().getText();
	}

}
