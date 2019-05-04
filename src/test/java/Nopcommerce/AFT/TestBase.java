package Nopcommerce.AFT;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import cucumber.api.testng.AbstractTestNGCucumberTests;


public class TestBase extends AbstractTestNGCucumberTests
{
	protected  static WebDriver Driver;
	protected static String DownLoadPath = System.getProperty("user.dir")+"\\Downloads";

	@BeforeSuite
	@Parameters ({"Browser"})
	public void openURL(@Optional ("chrome") String BrowserName)
	{
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
			String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			Driver = new ChromeDriver(chromeoptions());
			
		}
		else if(BrowserName.equalsIgnoreCase("firefox") )
		{
			String FirefoxPath = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", FirefoxPath);
			Driver = new FirefoxDriver(firefoxOptions());
		}
		else if(BrowserName.equalsIgnoreCase("IE") )
		{
			String IEPath = System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", IEPath);
			Driver = new InternetExplorerDriver();
		}
		Driver.manage().window().maximize();
		Driver.navigate().to("http://demo.nopcommerce.com/electronics");

	}
	
	protected static ChromeOptions chromeoptions()
	{
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> Chromeprefs = new HashMap<String, Object>();
		Chromeprefs.put("profile.default_content_settings.popups", 0);
		Chromeprefs.put("download.default_directory", DownLoadPath);
		options.setExperimentalOption("prefs", Chromeprefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;

	}
	
	public static FirefoxOptions firefoxOptions ()
	{
		FirefoxOptions options = new FirefoxOptions();
		options.addPreference("browser.download.folderList", 2);
		options.addPreference("browser.download.dir", DownLoadPath);
		options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");	
		options.addPreference("browser.download.manager.showWhenStarting", false);
		return options;
	}

	@AfterMethod
	public void takeScreenShot(ITestResult Result) throws IOException
	{
		if (ITestResult.FAILURE == Result.getStatus())
		{
		TakesScreenshot ScShot = (TakesScreenshot) Driver;
		File Source = ScShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File (".\\ScreenShots\\"+Result.getName()+".png"));
		}	
	}

	@AfterSuite
	public void closeURL()
	{
		Driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		Driver.quit();
	}

	
}
