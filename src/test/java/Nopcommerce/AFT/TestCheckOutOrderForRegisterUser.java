package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestCheckOutOrderForRegisterUser extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	ShoppingCartPage shoppingCartObject;
	CheckOutPage CheckOutObject;
	OrderDetailsPage  OrderDetailsObject;
	
	String firstName = "Maggie";
	String lastName = "Gergis";
	String password = "Mo1234568";
	String email = "Ma.99@gmail.com";
	String company = "ITworx";
	String city = "florida";
	String address1 = "florida,St";
	String postalCode = "124578";
	String mobileNumber = "123469795111";
	String Product = "HP ";

	@Test (priority = 0 , alwaysRun = true)
	public void Registeration() 
	{
		HomeObject = new HomePage(Driver);
		HomeObject.openRegisterPage();
		RegisterObject = new UserRegisterationPage(Driver);
		RegisterObject.registerUser(firstName , lastName , email, company ,password );
		SuccessRegObject = new SuccessRegisterPage(Driver);
		assertEquals(SuccessRegObject.SuccessRegMessage.getText(), "Your registration completed" );
	}
	@Test(dependsOnMethods = "Registeration")
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
		//CheckOutObject.CheckOutAs();
		CheckOutObject.CheckOutAsRegisteredUserBillingAddress(firstName,lastName, company ,city , address1 ,postalCode, mobileNumber );
		Thread.sleep(2000);
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
	
	@Test (dependsOnMethods = "DownLoadPDFInvoice")
	public void Logout()
	{
		HomeObject.userLogout();
	}
}
