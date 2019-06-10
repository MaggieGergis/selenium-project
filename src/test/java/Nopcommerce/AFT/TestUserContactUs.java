package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class TestUserContactUs extends TestBase
{
	HomePage HomeObject;
	ContactUsPage ContactUsObject;
	String Name = "Remon";
	String Email = "Re.1@yahoo.com";
	String Enquiry = "Having Technical Issue";
	
	@Test
	public void ContactUs() 
	{
		HomeObject = new HomePage(Driver);
		HomeObject.OpenContactUsPage();
		ContactUsObject = new ContactUsPage(Driver);
		ContactUsObject.UserContactUs(Name, Email, Enquiry);
		assertEquals(ContactUsObject.ContactUsConfirmationMessage.getText(), "Your enquiry has been successfully sent to the store owner.");
	}
}
