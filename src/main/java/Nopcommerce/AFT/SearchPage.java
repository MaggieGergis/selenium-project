package Nopcommerce.AFT;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase
{

	public SearchPage(WebDriver Driver) {
		super(Driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement SearchBox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement SearchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> AutoSearchList;
	
	public void UserSearch(String ProductItem)
	{
		sendTxtKeys(SearchBox, ProductItem);
		clickBtn(SearchBtn);
	}
	
	public void AutoCompleteUserSearch(String ProductItem) throws InterruptedException
	{
		sendTxtKeys(SearchBox, ProductItem);
		Thread.sleep(5000);
		AutoSearchList.get(0).click();
	}
}
