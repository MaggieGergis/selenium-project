package Nopcommerce.AFT;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestUserSearch extends TestBase
{
	String Product = "Mac";
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	
	@Test
	public void Search()
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.UserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		SearchResultObject.selectProductItem();
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));		
	}
	
}
