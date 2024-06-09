package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {".\\src\\test\\java\\features\\"},
		glue = {"stepDefinitions"},// if Hook class is in separate package then we have use that package name also in glue
		                           // or the Hook class can be maintained in stepDefinitions package only
		dryRun = false,//if true - doesn't execute in the browser
		               // if false execute in the browser
		plugin = {"pretty","html:TestReports/Report.html"},
		// print the log status/scenario steps in console helpful in debugging
		// Used in report generation
		monochrome = true, //print log in readable format by eliminating special characters inn console
		tags = "" // Handles group execution where tags with @ are specified in feature file for scenario
		                // @Smoke and @Regression -> and operator when both tags are given for 1 scenario
		                // @Smoke or @Regression -> or operator when either of one tag is given for a scenarios
		                // "not @Smoke" -> will exclude smoke tag and run all other tags
		)

public class RunnerIO extends AbstractTestNGCucumberTests{
	

}
