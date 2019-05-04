package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProductReviewPage extends PageBase
{

	public AddProductReviewPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement ReviewTitleTxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement ReviewDetailsTxt;
	
	@FindBy(id = "addproductrating_5")
	WebElement Rating;
	
	@FindBy(name = "add-review")
	WebElement SubmitReviewBtn;
	
	@FindBy(css = "div.result")
	public WebElement AddReviewConfirmationMessage;
	
	public void AddProductReview(String ReviewTitle , String ReviewDetails)
	{
		sendTxtKeys(ReviewTitleTxt, ReviewTitle);
		sendTxtKeys(ReviewDetailsTxt, ReviewDetails);
		clickBtn(Rating);
		clickBtn(SubmitReviewBtn);
	}

}
