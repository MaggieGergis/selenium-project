package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestUserRegisteration extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;
	
	String firstName = "Maggie";
	String lastName = "Gergis";
	String email = "Ma.er79@gmail.com";
	String company = "ITworx";
	String password = "Mo12348";

	@Test (priority = 0 , alwaysRun = true)
	public void Registeration() 
	{
		HomeObject = new HomePage(Driver);
		HomeObject.openRegisterPage();
		RegisterObject = new UserRegisterationPage(Driver);
		RegisterObject.registerUser(firstName , lastName , email, company ,password );
		SuccessRegObject = new SuccessRegisterPage(Driver);
		assertEquals(SuccessRegObject.SuccessRegMessage.getText(), "Your registration completed" );
	}
	
	@Test (dependsOnMethods = "Registeration")
	public void Logout()
	{
		HomeObject.userLogout();
	}
	
	@Test (dependsOnMethods = "Logout")
	public void Login()
	{
		UserLogInPage LoginObject = new UserLogInPage(Driver);
		HomeObject.userLogInPage();
		LoginObject.UserLogin(email, password);
		assertTrue(HomeObject.LogOutLink.isDisplayed());
	}
	@Test (dependsOnMethods = "Login")
	public void Logout2()
	{
		HomeObject.userLogout();
	}
}
