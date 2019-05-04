package Nopcommerce.AFT;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase
{

	public UserRegisterationPage(WebDriver Driver) {
		super(Driver);
	}

	@FindBy(id = "gender-female")
	WebElement GenderRadioBtn ;

	@FindBy(id = "FirstName")
	WebElement FNameTXTBox ;

	@FindBy(id = "LastName")
	WebElement LNameTXTBox ;

	@FindBy(name = "DateOfBirthDay")
	WebElement Day ;

	@FindBy(name = "DateOfBirthMonth")
	WebElement Month ;

	@FindBy(name = "DateOfBirthYear")
	WebElement Year ;

	@FindBy(id = "Email")
	WebElement EmailTxtBox ;

	@FindBy(id = "Company")
	WebElement CompanyTxtBox ;

	@FindBy(id = "Newsletter")
	WebElement NewsletterChkBox ;

	@FindBy(id = "Password")
	WebElement PasswordTxtBox ;

	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordTxtBox ;

	@FindBy(id = "register-button")
	WebElement RegisterBtn;
	
	@FindBy (css ="div.result") 
	public WebElement SuccessRegMessage;


	public void registerUser(String FirstName , String LastName , String Email, String Company ,String Password )
	{
		clickBtn(GenderRadioBtn);
		sendTxtKeys(FNameTXTBox , FirstName);
		sendTxtKeys(LNameTXTBox,LastName);
		Select(Day , "7");
		Select(Month , "April"); 
		Select(Year, "1990");
		sendTxtKeys(EmailTxtBox, Email);
		sendTxtKeys(CompanyTxtBox, Company);
		clickBtn(NewsletterChkBox);
		sendTxtKeys(PasswordTxtBox, Password);
		sendTxtKeys( ConfirmPasswordTxtBox, Password);
		clickBtn(RegisterBtn);
	}


}


