package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestData.ExcelSheetReader;

public class TestUserRegisterationwithExcelReaderTDD extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;


	@DataProvider (name= "ExcelData")
	public static Object[][]userRegisterationData() throws IOException
	{
		ExcelSheetReader Er = new ExcelSheetReader();
		return Er.readExcelSheet();

	}
	@Test (priority = 0 , alwaysRun = true , dataProvider= "ExcelData")
	public void Registeration(String firstName ,String lastName ,String email ,String company , String password  ) 
	{
		HomeObject = new HomePage(Driver);
		HomeObject.openRegisterPage();
		RegisterObject = new UserRegisterationPage(Driver);
		RegisterObject.registerUser(firstName , lastName , email, company ,password );
		SuccessRegObject = new SuccessRegisterPage(Driver);
		assertEquals(SuccessRegObject.SuccessRegMessage.getText(), "Your registration completed" );
		HomeObject.userLogout();
		UserLogInPage LoginObject = new UserLogInPage(Driver);
		HomeObject.userLogInPage();
		LoginObject.UserLogin(email, password);
		assertTrue(HomeObject.LogOutLink.isDisplayed());
		HomeObject.userLogout();
	}


}
