package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestUserEmailFriend extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	EmailFriendPage EmailFriendObject;
	
	String firstName = "Maggie";
	String lastName = "Gergis";
	String email = "Ma.er96@gmail.com";
	String company = "ITworx";
	String password = "Mo12348";
	String Product = "Mac";
	String friendEmail = "Re.er11@gmail.com";
	String personalMessage = "find the attached product, it is very good" ;

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
	public void AutoSearch() throws InterruptedException
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.AutoCompleteUserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));
	}
	
	@Test (dependsOnMethods = "AutoSearch")
	public void EmailFriend()
	{
		SearchResultObject.OpenEmailFriend();
		EmailFriendObject = new EmailFriendPage(Driver);
		EmailFriendObject.sendEmailToFriend(friendEmail, personalMessage);
		assertEquals(EmailFriendObject.EmailFriendConfirmationMessage.getText(), "Your message has been sent.");
	}
	
	@Test (dependsOnMethods = "EmailFriend")
	public void Logout()
	{
		HomeObject.userLogout();
	}
	
}

