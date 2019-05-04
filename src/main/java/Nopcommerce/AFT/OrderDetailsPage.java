package Nopcommerce.AFT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver Driver) {
		super(Driver);
	}

	@FindBy(tagName = "h1")
	WebElement OrderInformationHeader ;
	
	
	@FindBy(linkText = "Print")
	WebElement PrintBtn;
	
	@FindBy(linkText = "PDF Invoice")
	WebElement PDFInvoiceBtn;
	
	public void PrintInvoice()
	{
		clickBtn(PrintBtn);
	}
	
	public void PDFInvoice()
	{
		clickBtn(PDFInvoiceBtn);
	}
	
}
