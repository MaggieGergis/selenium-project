package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import TestData.LoadProperities;

public class TestUserRegisterationwithProperitiesTDDFile extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;
	String firstName = LoadProperities.userdata.getProperty("FName");
	String lastName = LoadProperities.userdata.getProperty("LName");
	String email = LoadProperities.userdata.getProperty("Email");
	String company = LoadProperities.userdata.getProperty("Company");
	String password = LoadProperities.userdata.getProperty("Password");


	@Test (priority = 0 , alwaysRun = true)
	public void Registeration()
	{
		HomeObject = new HomePage(Driver);
		HomeObject.openRegisterPage();
		RegisterObject = new UserRegisterationPage(Driver);
		RegisterObject.registerUser(firstName , lastName , email, company ,password );
		SuccessRegObject = new SuccessRegisterPage(Driver);
		assertEquals(SuccessRegObject.SuccessRegMessage.getText(), "Your registration completed" );
		HomeObject.userLogout();
		UserLogInPage LoginObject = new UserLogInPage(Driver);
		HomeObject.userLogInPage();
		LoginObject.UserLogin(email, password);
		assertTrue(HomeObject.LogOutLink.isDisplayed());
		HomeObject.userLogout();
	}
	

}
