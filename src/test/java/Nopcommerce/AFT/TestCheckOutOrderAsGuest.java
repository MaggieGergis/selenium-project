package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

public class TestCheckOutOrderAsGuest extends TestBase
{
	HomePage HomeObject ;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage CheckOutObject;
	OrderDetailsPage  OrderDetailsObject;
	
	String firstName = "Maggie";
	String lastName = "Gergis";
	String email = "Ma.er99@gmail.com";
	String company = "ITworx";
	String city = "florida";
	String address1 = "florida,St";
	String postalCode = "124578";
	String mobileNumber = "123469795111";
	String Product = "HP ";

	@Test(priority = 0)
	public void AutoSearch() throws InterruptedException
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.AutoCompleteUserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));	

	}

	@Test(dependsOnMethods = "AutoSearch" )
	public void UserAddToShoppingCart()
	{
		SearchResultObject.AddToCart();
		assertTrue(Driver.getCurrentUrl().contains("cart"));
		shoppingCartObject = new ShoppingCartPage(Driver);
		assertTrue(shoppingCartObject.ProductName.getText().contains(Product));
	}

	@Test (dependsOnMethods = "UserAddToShoppingCart")
	public void userCheckOutOrderAsGuest() throws InterruptedException
	{
		shoppingCartObject.CheckOutOrderAgreement();
		CheckOutObject = new CheckOutPage(Driver);
		CheckOutObject.CheckOutAs();
		CheckOutObject.CheckOutAsGuestBillingAddress(firstName,lastName, email, company ,city , address1 ,postalCode, mobileNumber );
		Thread.sleep(3000);
		assertEquals(CheckOutObject.OrderConfurmationMessage.getText(), "Your order has been successfully processed!");
	}
	
	@Test(dependsOnMethods = "userCheckOutOrderAsGuest")
	public void OpenOrderDetailsLink()
	{
		CheckOutObject.OrderDetails();
		OrderDetailsObject = new OrderDetailsPage(Driver);
		assertEquals(OrderDetailsObject.OrderInformationHeader.getText() , "Order information");
	}
	
	@Test(dependsOnMethods = "OpenOrderDetailsLink")
	public void DownLoadPDFInvoice() throws InterruptedException
	{
		OrderDetailsObject.PDFInvoice();
		Thread.sleep(3000);
	}
}
