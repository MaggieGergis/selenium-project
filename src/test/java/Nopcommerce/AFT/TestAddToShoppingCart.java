package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestAddToShoppingCart extends TestBase
{
	HomePage HomeObject ;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	ShoppingCartPage shoppingCartObject;
	
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
	public void UserRemoveFromShoppingCart()
	{
		shoppingCartObject.UpdateCart();
		assertEquals(shoppingCartObject.RemoveProductFromCartConfirmationMessage.getText(), "Your Shopping Cart is empty!");
	}
}
