package Runner;


import Nopcommerce.AFT.TestBase;
import cucumber.api.CucumberOptions;

@CucumberOptions (features = "src\\test\\java\\Features",
glue = {"StepDefination"} ,plugin = {"pretty", "html:target/Cucumber-html-Report"})
		
public class TestRunner extends TestBase
{ 
	

}
