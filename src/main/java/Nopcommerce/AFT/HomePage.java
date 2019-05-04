package Nopcommerce.AFT;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase
{

	public HomePage(WebDriver Driver) 
	{
		super(Driver);
		Js = (JavascriptExecutor) Driver;
		Action = new Actions(Driver);
	}
	
	@FindBy(linkText= "Register")
	WebElement RegisterBtn;
	
	@FindBy(linkText= "Log out")
	public WebElement LogOutLink;
	
	@FindBy(linkText= "Log in")
	public WebElement LogInLink;
	
	@FindBy(linkText = "My account")
	WebElement MyAccountLink;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactUSLink;
	
	@FindBy(id = "customerCurrency")
	public WebElement CurencyList;
	
	@FindBy (linkText = "Computers")
	WebElement	ComputersList;
	
	@FindBy(linkText = "Notebooks")
	WebElement NoteBooksList;
	
	@FindBy (css = " a.ico-wishlist")
	WebElement WishListLink;
	
	public void openRegisterPage()
	{
		clickBtn(RegisterBtn);
	}
	
	public void userLogout()
	{
		clickBtn(LogOutLink);
	}
	
	public void userLogInPage()
	{
		clickBtn(LogInLink);
	}
	
	public void openMyAccountPage()
	{
		clickBtn(MyAccountLink);
	}

	public void OpenContactUsPage()
	{
		scroll();
		clickBtn(ContactUSLink);
	}
	
	public void ChangeCurrency(String Currency)
	{
		Select(CurencyList, Currency);
	}

	public void selectElementfromHoverList ()
	{
		HoverAction(ComputersList, NoteBooksList);
	}
	
	public void OpenWishList()
	{
		clickBtn(WishListLink);
	}
}
