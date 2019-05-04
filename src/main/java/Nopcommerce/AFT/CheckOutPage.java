package Nopcommerce.AFT;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase
{

	public CheckOutPage(WebDriver Driver) {
		super(Driver);
		Js = (JavascriptExecutor) Driver ;
	}

	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement CheckOutAsGuestBtn;

	@FindBy(id ="BillingNewAddress_FirstName")
	WebElement FirstNameTxt;

	@FindBy(id ="BillingNewAddress_LastName")
	WebElement LastNameTxt;

	@FindBy(id ="BillingNewAddress_Email")
	WebElement EmailTxt;

	@FindBy(id ="BillingNewAddress_Company")
	WebElement CompanyTxt;

	@FindBy(id ="BillingNewAddress_CountryId")
	WebElement CountryIdList;

	@FindBy(id ="BillingNewAddress_StateProvinceId")
	WebElement StateList;

	@FindBy(id ="BillingNewAddress_City")
	WebElement CityTxt;

	@FindBy(id ="BillingNewAddress_Address1")
	WebElement AddressTxt;

	@FindBy(id ="BillingNewAddress_ZipPostalCode")
	WebElement ZipPostalCodeTxt;

	@FindBy(id ="BillingNewAddress_PhoneNumber")
	WebElement PhoneNumberTxt;

	@FindBy (css = "input.button-1.new-address-next-step-button")
	WebElement BillingAddressContinueBtn;

	@FindBy(id = "shippingoption_1") 
	WebElement ShippingoptionRadioBtn;

	@FindBy (css = "input.button-1.shipping-method-next-step-button")
	WebElement ShippingAdressContinueBtn;

	@FindBy(id = "paymentmethod_1")
	WebElement paymentmethodRadioBtn;

	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement PaymentMethosContinueBtn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement paymentmethodCheckBtn;

	@FindBy (css = "input.button-1.payment-method-next-step-button")
	WebElement PaymentInformationContinueBtn;
	
	@FindBy (css = "input.button-1.payment-info-next-step-button")
	WebElement PaymentInfoContinueBtn;

	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement ConfirmBtn;

	@FindBy(tagName =  "strong")
	public WebElement OrderConfurmationMessage;
	
	@FindBy(linkText =  "Click here for order details.")
	 WebElement OrderDetailsLink;
	
	public void CheckOutAs()
	{
		clickBtn(CheckOutAsGuestBtn);
	}

	public void CheckOutAsGuestBillingAddress(String FirstName, String LastName , String Email , String Company, String City, String Address1 , String PostalCode , String PhoneNumber ) throws InterruptedException
	{
		sendTxtKeys(FirstNameTxt, FirstName);
		sendTxtKeys(LastNameTxt, LastName);
		sendTxtKeys(EmailTxt, Email);
		sendTxtKeys(CompanyTxt, Company);
		Select(CountryIdList, "United States");
		Thread.sleep(1000);
		Select(StateList, "Florida");
		sendTxtKeys(CityTxt, City);
		sendTxtKeys(AddressTxt, Address1);
		sendTxtKeys(ZipPostalCodeTxt, PostalCode);
		sendTxtKeys(PhoneNumberTxt, PhoneNumber);
		clickBtn(BillingAddressContinueBtn);
		Thread.sleep(1000);
		clickBtn(ShippingoptionRadioBtn);
		clickBtn(ShippingAdressContinueBtn);
		Thread.sleep(1000);
		clickBtn(paymentmethodCheckBtn);
		Thread.sleep(1000);
		clickBtn(PaymentInformationContinueBtn);
		Thread.sleep(1000);
		clickBtn(PaymentInfoContinueBtn);
		Thread.sleep(2000);
		clickBtn(ConfirmBtn);
	}
	public void CheckOutAsRegisteredUserBillingAddress(String FirstName, String LastName , String Company, String City, String Address1 , String PostalCode , String PhoneNumber ) throws InterruptedException
	{
		sendTxtKeys(FirstNameTxt, FirstName);
		sendTxtKeys(LastNameTxt, LastName);
		sendTxtKeys(CompanyTxt, Company);
		Select(CountryIdList, "United States");
		Thread.sleep(1000);
		Select(StateList, "Florida");
		sendTxtKeys(CityTxt, City);
		sendTxtKeys(AddressTxt, Address1);
		sendTxtKeys(ZipPostalCodeTxt, PostalCode);
		sendTxtKeys(PhoneNumberTxt, PhoneNumber);
		clickBtn(BillingAddressContinueBtn);
		Thread.sleep(2000);
		clickBtn(ShippingoptionRadioBtn);
		clickBtn(ShippingAdressContinueBtn);
		Thread.sleep(1000);
		clickBtn(paymentmethodCheckBtn);
		Thread.sleep(1000);
		clickBtn(PaymentInformationContinueBtn);
		Thread.sleep(1000);
		clickBtn(PaymentInfoContinueBtn);
		Thread.sleep(3000);
		clickBtn(ConfirmBtn);
	}
	public void OrderDetails()
	{
		clickBtn(OrderDetailsLink);
	}

}
