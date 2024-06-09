package stepDefinitions;

import enums.ConfigProperties;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Pages;
import utility.PropertyFileUtility;

import static drivers.DriverManager.getDriver;


public class LoginStepsDefinition   {


    @Given("Enter the URL")
    public void enter_the_url() {
        getDriver().get(PropertyFileUtility.get(ConfigProperties.URL));
    }

    @When("User on Login Page.Enter username and password")
    public void userOnLoginPageEnterUsernameAndPassword() {
        String username = PropertyFileUtility.get(ConfigProperties.USERNAME);
        String password = PropertyFileUtility.get(ConfigProperties.PASSWORD);

        Pages.loginpage.loginToApp(username,password);
    }

    @And("Click on Login Button")
    public void click_on_login_button() {
        Pages.loginpage.clickOnLoginButn();
    }

    @Then("Validate whether home page is displayed or not")
    public void validate_whether_home_page_is_displayed_or_not() {
       Pages.loginpage.loginUserValidation();
    }



}
