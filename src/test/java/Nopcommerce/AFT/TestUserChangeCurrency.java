package Nopcommerce.AFT;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestUserChangeCurrency extends TestBase
{
	String Product = "Mac";
	HomePage HomeObject;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	
	@Test (priority = 0 )
	public void ChangeCurrency()
	{
		HomeObject = new HomePage(Driver);
		HomeObject.ChangeCurrency("Euro");
	}
	
	@Test(dependsOnMethods = "ChangeCurrency")
	public void userCheckCurrency()
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.UserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		SearchResultObject.selectProductItem();
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));
		assertTrue(SearchResultObject.ItemPrice.getText().contains("Ђ"));
	}
}
