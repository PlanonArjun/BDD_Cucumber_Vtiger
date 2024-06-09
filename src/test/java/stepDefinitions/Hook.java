package stepDefinitions;


import drivers.Driver;
import enums.ConfigProperties;
import factories.DriverFactory;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utility.*;

public class Hook {

	//Dependency injection utilized to pass the driver reference from base
	protected WebDriver driver = null;

	public WebDriver getDriver() {
		return driver;
	}


	//order execution will be descending order for @After -ve 0 +ve
	@Before//(order = 1)(value = "@Smoke")
	public void beforeScenario() throws Exception {

		String browser = PropertyFileUtility.get(ConfigProperties.BROWSER);
		driver = Driver.initDriver(browser, DriverFactory.browserVersion);
		Pages.loadPages(driver);
	}

	
	//order execution will be descending order for @After +ve 0 -ve
	@After//(order = 1)
	public void afterScenario(Scenario scenario) throws Throwable {
		if(scenario.isFailed())
		{
			/*To attach screenshot to report we have to capture it in byte format only refer below code for that*/

			byte[] screenshot = ScreenShortUtils.getBase64ImageBytes();
			scenario.attach(screenshot, "image/png", scenario.getName());

		}
		driver.close();
		//System.out.println("inside first @After ");
	}
	

}
