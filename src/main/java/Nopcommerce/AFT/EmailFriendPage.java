package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase
{

	public EmailFriendPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement FriendEmailTxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement PersonalMessageTxt;
	
	@FindBy(css = "input.button-1.send-email-a-friend-button")
	WebElement SendEmailBtn;
	
	@FindBy (css = "div.result")
	public WebElement EmailFriendConfirmationMessage;
	
	public void sendEmailToFriend(String FriendEmail , String PersonalMessage  )
	{
		sendTxtKeys(FriendEmailTxt, FriendEmail);
		sendTxtKeys(PersonalMessageTxt, PersonalMessage);
		clickBtn(SendEmailBtn);
	}

	
}

