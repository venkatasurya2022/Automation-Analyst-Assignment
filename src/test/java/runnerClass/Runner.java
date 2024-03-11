package runnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\user\\eclipse-workspace\\Skopic-Alpha\\Flipkart_Assignment\\src\\test\\java\\features\\SearchProductAndAddToKart.feature", glue = {
		"C:\\Users\\user\\eclipse-workspace\\Skopic-Alpha\\Flipkart_Assignment\\src\\main\\java\\stepdefinitions" }, plugin = {
				"pretty", "html:target/cucumber-reports" }, monochrome = true, dryRun = false)
public class Runner {

}
