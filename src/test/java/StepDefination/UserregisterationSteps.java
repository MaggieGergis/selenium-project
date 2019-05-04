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

public class UserregisterationSteps extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;

	String firstName = "Marseil";
	String lastName = "Sweras";
	String email = "Ma.Sw9@gmail.com";
	String company = "ITworx";
	String password = "Mo12348";

	@Given("^User is on HomePage\\.$")
	public void user_is_on_HomePage() 
	{
		HomeObject = new HomePage(Driver);
	}

	@When("^Click on Register Link\\.$")
	public void clickon_Register_Link()  
	{
		HomeObject.openRegisterPage();
		assertTrue(Driver.getCurrentUrl().contains("register"));
	}

	@When("^User enter Valid Data\\.$")
	public void user_enter_valid_user_Data()
	{
		RegisterObject = new UserRegisterationPage(Driver);
		RegisterObject.registerUser(firstName , lastName , email, company ,password );

	}

	@Then("^User Registeration Page should be dispayed Successfully$")
	public void User_Registeration_Page_should_be_dispayed_successfully()
	{
		assertTrue(HomeObject.LogOutLink.isDisplayed());
		HomeObject.userLogout();
	}

}
