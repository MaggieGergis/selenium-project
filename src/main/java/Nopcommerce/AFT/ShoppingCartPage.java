package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase
{

	public ShoppingCartPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy(css = "a.product-name")
	WebElement ProductName;
	
	@FindBy( name = "removefromcart")
	WebElement RemoveFromCartChekBox;
	
	@FindBy(name = "updatecart")
	WebElement UpdateCartBtn;
	
	@FindBy(css = "div.no-data")
	WebElement RemoveProductFromCartConfirmationMessage;
	
	@FindBy(id ="termsofservice")
	WebElement TermsOfServiceCheKBox;
	
	@FindBy(id ="checkout")
	WebElement checkoutBtn;
	
	
	
	public void UpdateCart()
	{
		clickBtn(RemoveFromCartChekBox);
		clickBtn(UpdateCartBtn);
	}
	
public void CheckOutOrderAgreement()
{
	clickBtn(TermsOfServiceCheKBox);
	clickBtn(checkoutBtn);
}

	
}
