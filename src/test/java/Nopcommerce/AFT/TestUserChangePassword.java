package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestUserChangePassword extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	MyAccountPage MyAccountObject;
	
	String firstName = "Maggie";
	String lastName = "Gergis";
	String email = "Ma.er89@gmail.com";
	String company = "ITworx";
	String password = "Mo12349";
	String newPassword = "Mo14785";

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
	public void ChangePassword()
	{
		HomeObject.openMyAccountPage();
		MyAccountObject = new MyAccountPage(Driver);
		MyAccountObject.openChangePasswordPage();
		MyAccountObject.UserChangePassword(password, newPassword);
		assertEquals(MyAccountObject.SuccessChangePasswordMessage.getText(), "Password was changed" );
	}
	
	@Test (dependsOnMethods = "ChangePassword")
	public void Logout()
	{
		HomeObject.userLogout();
	}
	
	@Test (dependsOnMethods = "Logout")
	public void Login()
	{
		UserLogInPage LoginObject = new UserLogInPage(Driver);
		HomeObject.userLogInPage();
		LoginObject.UserLogin(email, newPassword);
		assertTrue(HomeObject.LogOutLink.isDisplayed());
		
	}
}
