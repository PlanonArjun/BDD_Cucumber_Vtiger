package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;


public class LoginPage {

	@FindBy(name = "user_name")
	private WebElement userNameEdt;

	@FindBy(name = "user_password")
	private WebElement passwordEdt;

	@FindAll({ @FindBy(id = "submitButton"), @FindBy(xpath = "//input[@type='submit']") })
	private WebElement loginBtn;

	@FindBy(xpath = "//span[@class='userName']")
	private WebElement loginUserName;

	// Business Libraries - project specific generic utilities
	public void loginToApp(String username, String password) {
		userNameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);

	}

	public void clickOnLoginButn(){
		loginBtn.click();
	}



	public void loginUserValidation(){
		String userName = loginUserName.getText();
		String actualName = "Administrator";
		Assert.assertTrue(userName.contains(actualName));
		System.out.println("User login as Admin: " + userName);
	}

	/*String userName = loginUserName.getText();
	String actualName = "Administrator";
		Assert.assertTrue(userName.contains(actualName));
		System.out.println("User login as Admin: " + userName);*/
}
