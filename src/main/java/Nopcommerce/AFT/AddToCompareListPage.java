package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCompareListPage extends PageBase
{

	public AddToCompareListPage(WebDriver Driver) {
		super(Driver);
	}

	@FindBy(css = "a.clear-list")
	WebElement ClearListBtn;
	
	@FindBy(css = "div.no-data")
	WebElement ClearCompareProductListConfirmationMessage;
	public void ClearCompareList()
	{
		clickBtn(ClearListBtn);
	}
}
