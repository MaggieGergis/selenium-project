package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestUserRegisterationwithDataProviderTDD extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;
	

	@DataProvider (name= "UserData")
	public static Object [][] UserData()
	{
		return new Object [][]
				{{"Ma", "Er", "Ma.er@gmail.com", "ITworx", "Mo12348"},
				{"Re", "Er", "Re.er@gmail.com", "ITworx", "Re12348"}};
		
	}
	@Test (priority = 0 , alwaysRun = true , dataProvider= "UserData")
	public void Registeration(String firstName ,String lastName ,String email ,String company , String password  ) 
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
