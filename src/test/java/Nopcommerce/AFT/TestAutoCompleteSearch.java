package Nopcommerce.AFT;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestAutoCompleteSearch extends TestBase
{
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	String Product = "Mac";
	
	@Test
	public void AutoSearch() throws InterruptedException
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.AutoCompleteUserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));		

	}
}
