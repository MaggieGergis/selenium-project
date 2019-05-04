package Nopcommerce.AFT;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PageBase 
{
	protected static WebDriver Driver;
	protected  static JavascriptExecutor Js;
	protected static Actions Action;
	
	public PageBase(WebDriver Driver)
	{
		PageFactory.initElements(Driver, this);
	}
	
	protected static void clickBtn(WebElement Botton)
	{
		Botton.click();
	}
	
	protected static void sendTxtKeys(WebElement Element , String value )
	{
		Element.sendKeys(value);
	}
	
	protected static void Select(WebElement selectElement , String Value)
	{
		Select Drop = new Select(selectElement);
		Drop.selectByVisibleText(Value);
	}
	
	protected static void scroll()
	{
		Js.executeScript("scrollBy (0 , 5000)");
	}
	
	protected static void HoverAction(WebElement Element1 , WebElement Element2)
	{
		Action.moveToElement(Element1).moveToElement(Element2).click().perform();

	}
	
}
