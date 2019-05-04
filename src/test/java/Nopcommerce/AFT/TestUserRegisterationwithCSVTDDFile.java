package Nopcommerce.AFT;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;


public class TestUserRegisterationwithCSVTDDFile extends TestBase
{
	HomePage HomeObject ;
	UserRegisterationPage RegisterObject;
	SuccessRegisterPage SuccessRegObject;
	UserLogInPage LoginObject;
	CSVReader Reader ;
	String CSVFileSrc= System.getProperty("user.dir")+"\\src\\test\\java\\TestData\\TestData1.csv";


	@Test (priority = 0 , alwaysRun = true)
	public void Registeration() throws IOException
	{
		
		Reader = new CSVReader(new FileReader(CSVFileSrc));
		String [] CSVCell;
		while ((CSVCell  = Reader.readNext())!=null)
		{
			String firstName = CSVCell[0];
			String lastName = CSVCell[1];
			String email = CSVCell[2];
			String company = CSVCell[3];
			String password = CSVCell[4];
			
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(email);
			System.out.println(company);
			System.out.println(password);

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
	
	}
