package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogInPage extends PageBase
{

	public UserLogInPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy(id ="Email")
	WebElement EmailTxt;
	
	@FindBy(id ="Password")
	WebElement PasswordTxt;
	
	@FindBy(id ="RememberMe")
	WebElement RememberMe;
	
	@FindBy(css ="input.button-1.login-button")
	WebElement LoginBtn;

	public void UserLogin(String Email , String Password)
	{
		sendTxtKeys(EmailTxt, Email);
		sendTxtKeys(PasswordTxt, Password);
		clickBtn(RememberMe);
		clickBtn(LoginBtn);
	}
}
