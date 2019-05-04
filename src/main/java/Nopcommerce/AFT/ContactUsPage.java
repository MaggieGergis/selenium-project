package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{

	public ContactUsPage(WebDriver Driver) {
		super(Driver);
	}

	@FindBy (id= "FullName")
	WebElement NameTxt;
	
	@FindBy (id= "Email")
	WebElement EmailTxt;
	
	@FindBy (id= "Enquiry")
	WebElement EnquiryTxt;
	
	@FindBy (name = "send-email")
	WebElement SubmitBtn;
	
	@FindBy(css = "div.result")
	public WebElement ContactUsConfirmationMessage;
	
	public void UserContactUs(String Name , String Email, String Enquiry)
	{
		sendTxtKeys(NameTxt, Name);
		sendTxtKeys(EmailTxt, Email);
		sendTxtKeys(EnquiryTxt, Enquiry);
		clickBtn(SubmitBtn);
	}
	
}
