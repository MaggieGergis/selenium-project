package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessRegisterPage extends PageBase
{

	public SuccessRegisterPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy (css ="div.result") 
	public WebElement SuccessRegMessage;

}
