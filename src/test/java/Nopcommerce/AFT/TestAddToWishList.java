package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestAddToWishList extends TestBase 
{
	HomePage HomeObject ;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	AddWishListPage AddProductWishListObject;
	
	String Product = "HP ";
	
	@Test(priority = 0)
	public void AutoSearch() throws InterruptedException
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.AutoCompleteUserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));	

	}
	
	@Test(dependsOnMethods = "AutoSearch")
	public void UserAddToWishList()
	{
		SearchResultObject.AddtToWishList();
		HomeObject= new HomePage(Driver);
		HomeObject.OpenWishList();
		AddProductWishListObject = new AddWishListPage(Driver);
		assertTrue( AddProductWishListObject.ProductName.getText().contains(Product));
	}
	
	@Test(dependsOnMethods = "UserAddToWishList")
	public void UserAddToCart()
	{
		AddProductWishListObject.AddToCart();
		assertTrue(Driver.getCurrentUrl().contains("cart"));
	}
	
	@Test(dependsOnMethods = "UserAddToWishList")
	public void UserRemoveFromeWishList()
	{
		AddProductWishListObject.RemoveFromWishList();
		assertEquals(AddProductWishListObject.EmptyWishListMessage.getText(),"The wishlist is empty!");
	}
	
	
}
