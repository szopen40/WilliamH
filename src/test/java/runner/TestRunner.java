package runner;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepdefs.StepDefinition;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature", 
		glue = { "stepdefs" }, 
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json"}
		)
public class TestRunner {
	public static void main(String[] args) {									
	      Result result = JUnitCore.runClasses(StepDefinition.class);					
				for (Failure failure : result.getFailures()) {							
	         System.out.println(failure.toString());					
	      }		
	      System.out.println("Result=="+result.wasSuccessful());							
	   }		

}
