package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase
{

	public MyAccountPage(WebDriver Driver) 
	{
		super(Driver);
	}
	
	@FindBy(linkText = "Change password")
	WebElement ChangePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement OldPasswordTxt;
	
	@FindBy(id = "NewPassword")
	WebElement NewPasswordTxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxt;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement ChangePasswordBtn;
	
	@FindBy(css= "div.result")
	WebElement SuccessChangePasswordMessage;
	
	public void openChangePasswordPage()
	{
		clickBtn(ChangePasswordLink);
	}
	
	public void UserChangePassword(String OldPassword , String NewPassword)
	{
		sendTxtKeys(OldPasswordTxt, OldPassword);
		sendTxtKeys(NewPasswordTxt, NewPassword);
		sendTxtKeys(ConfirmNewPasswordTxt, NewPassword);
		clickBtn(ChangePasswordBtn);
		
	}
}
