package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestUserAddProductReview extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	SearchPage SearchObject;
	SearchResultPage SearchResultObject;
	AddProductReviewPage AddProductReviewObject;
	
	String firstName = "Maggie";
	String lastName = "Gergis";
	String email = "Ma.er98@gmail.com";
	String company = "ITworx";
	String password = "Mo12348";
	String Product = "Mac";
	String reviewTitle = "Good product";
	String reviewDetails = "I am so Happy To get this product";


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
	public void Search()
	{
		SearchObject = new SearchPage(Driver);
		SearchObject.UserSearch(Product);
		SearchResultObject = new SearchResultPage(Driver);
		SearchResultObject.selectProductItem();
		assertTrue(SearchResultObject.ProductItem.getText().contains(Product));		
	}
	
	@Test(dependsOnMethods = "Search")
	public void UserAddReview()
	{
		SearchResultObject.OpenAddReview();
		AddProductReviewObject = new AddProductReviewPage(Driver);
		AddProductReviewObject.AddProductReview(reviewTitle, reviewDetails);
		assertEquals(AddProductReviewObject.AddReviewConfirmationMessage.getText(), "Product review is successfully added.");
	}
	
	@Test (dependsOnMethods = "UserAddReview")
	public void Logout()
	{
		HomeObject.userLogout();
	}
}
