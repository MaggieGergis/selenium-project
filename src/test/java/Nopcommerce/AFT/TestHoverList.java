package Nopcommerce.AFT;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestHoverList extends TestBase
{
	
	HomePage HomeObject ;
	
	@Test
	public void HoverList()
	{
		HomeObject = new HomePage(Driver);
		HomeObject.selectElementfromHoverList();
		assertTrue(Driver.getCurrentUrl().contains("notebooks"));
	}
}

