package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import TestData.JSONReader;

public class TestUserRegisterationwithJSONTDDFile extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;
	


	@Test (priority = 0 , alwaysRun = true)
	public void Registeration() throws FileNotFoundException, IOException, ParseException
	{
	
		HomeObject = new HomePage(Driver);
		HomeObject.openRegisterPage();
		RegisterObject = new UserRegisterationPage(Driver);
		JSONReader JReader = new JSONReader();
		JReader.JsonDataReader();
		RegisterObject.registerUser(JReader.FirstName , JReader.LastName , JReader.Email, JReader.Company ,JReader.Password );
		SuccessRegObject = new SuccessRegisterPage(Driver);
		assertEquals(SuccessRegObject.SuccessRegMessage.getText(), "Your registration completed" );
		HomeObject.userLogout();
		UserLogInPage LoginObject = new UserLogInPage(Driver);
		HomeObject.userLogInPage();
		LoginObject.UserLogin(JReader.Email, JReader.Password);
		assertTrue(HomeObject.LogOutLink.isDisplayed());
		HomeObject.userLogout();
	}


}
