package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class TestUserRegisterationwithJavaFakerTDD extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;
	Faker FakeData = new Faker();
	String firstName = FakeData.name().firstName();
	String lastName = FakeData.name().lastName();
	String email = FakeData.internet().emailAddress();
	String company = FakeData.company().name();
	String password = FakeData.number().digits(8);


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
