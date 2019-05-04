package StepDefination;

import static org.testng.Assert.assertTrue;

import Nopcommerce.AFT.HomePage;
import Nopcommerce.AFT.SuccessRegisterPage;
import Nopcommerce.AFT.TestBase;
import Nopcommerce.AFT.UserLogInPage;
import Nopcommerce.AFT.UserRegisterationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegisterationWithTDDSteps extends TestBase{

	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;


	@Given("^User is on HomePage With TDD\\.$")
	public void user_is_on_HomePage()
	{
		HomeObject = new HomePage(Driver);
	}

	@When("^Click on Register Link With TDD\\.$")
	public void click_on_Register_Link()  
	{
		HomeObject.openRegisterPage();
		assertTrue(Driver.getCurrentUrl().contains("register"));
	}



	@When("^User enter Valid Data \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\"$")
	public void user_enter_Valid_Data(String FirstName, String LastName, String Email, String Company, String Password)
	{
	RegisterObject = new UserRegisterationPage(Driver);
	RegisterObject.registerUser(FirstName , LastName , Email, Company ,Password );

}

@Then("^User Registeration Page should be dispayed Successfully With TDD\\.$")
public void User_Registeration_Page_should_be_dispayed_successfully()
{
	assertTrue(HomeObject.LogOutLink.isDisplayed());
	HomeObject.userLogout();


}
}
