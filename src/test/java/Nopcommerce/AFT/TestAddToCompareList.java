package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestAddToCompareList extends TestBase
{
	HomePage HomeObject ;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	AddToCompareListPage AddCompareListObject;


	String Product = "HP ";

	@Test(priority = 0)
	public void AutoSearch() throws InterruptedException
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.AutoCompleteUserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));	
	}

	@Test (dependsOnMethods ="AutoSearch" )
	public void UserAddToCompareList() throws InterruptedException 
	{
		SearchResultObject.AddToCompareList();
		assertTrue(Driver.getCurrentUrl().contains("compareproducts"));
		AddCompareListObject = new AddToCompareListPage(Driver);
		AddCompareListObject.ClearCompareList();
		assertEquals(AddCompareListObject.ClearCompareProductListConfirmationMessage.getText(), "You have no items to compare.");
	}
}


