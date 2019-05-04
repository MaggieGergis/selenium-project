package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddWishListPage extends PageBase 
{

	public AddWishListPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy(css = "a.product-name")
	public WebElement ProductName;
	
	@FindBy(name = "addtocart")
	WebElement AddToCartChekBox;
	
	@FindBy(name = "removefromcart")
	WebElement RemovefromWishListChekBtn;
	
	@FindBy(name = "addtocartbutton")
	WebElement AddToCartButton;
	
	@FindBy(name = "updatecart")
	WebElement UpdateWishListBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement EmptyWishListMessage;
	
	public void AddToCart()
	{
		clickBtn(AddToCartChekBox);
		clickBtn(AddToCartButton);
	}
	
	public void RemoveFromWishList()
	{
		clickBtn(RemovefromWishListChekBtn);
		clickBtn(UpdateWishListBtn);
	}
 

}
