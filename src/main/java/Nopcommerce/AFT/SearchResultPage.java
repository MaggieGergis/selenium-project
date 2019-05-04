package Nopcommerce.AFT;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase
{

	public SearchResultPage(WebDriver Driver) {
		super(Driver);
		Js = (JavascriptExecutor) Driver;
	}
	
	@FindBy(partialLinkText = "MacBook")
	WebElement ProductElment;
	
	@FindBy(tagName = "h1")
	WebElement ProductItem;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement EmailFriendBtn;
	
	@FindBy(css = "span.price-value-4")
	public WebElement ItemPrice;
	
	@FindBy(linkText ="Add your review")
	WebElement AddReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-7")
	WebElement WishListBtn;
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement AddToCompareBtn;
	
	@FindBy (css = "p.content")
	WebElement AddToCompareLabel;
	
	@FindBy(linkText = "product comparison")
	WebElement ProductComparisonLink;
	
	@FindBy(id = "add-to-cart-button-7")
	WebElement AddToCartBtn;
	
	@FindBy(css = "span.cart-label")
	WebElement ShoppingCartLink;
	
	public void selectProductItem()
	{
		clickBtn(ProductElment);
	}
	
	public void OpenEmailFriend()
	{
		clickBtn(EmailFriendBtn);
	}
	
	public void OpenAddReview()
	{
		clickBtn(AddReviewLink);
	}
	
	public void AddtToWishList()
	{
		clickBtn(WishListBtn);
	}
	
	public void AddToCompareList() throws InterruptedException
	{
		clickBtn(AddToCompareBtn);
		Thread.sleep(5000);
		Js.executeScript("document.getElementsByTagName('a')[0].click();");
	}
	
	public void AddToCart()
	{
		clickBtn(AddToCartBtn);
		clickBtn(ShoppingCartLink);
	}
}
