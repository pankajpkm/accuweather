package accuweather.org.Listner;

/**
 * @author Pankajpkm
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseListner implements ISuiteListener {
	private static WebDriver driver;
	private static String browser;
	private static String url;
	private static String apiKey;
	
	@Override
	public void onStart(ISuite suite) {
		browser = suite.getParameter("Browser");
		url = suite.getParameter("url");
		apiKey = suite.getParameter("apiKey");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		switch(browser.toUpperCase()) {
		case "CHROME" :
			driver = new ChromeDriver(options);
			break;
		default:
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
	}

	@Override
	public void onFinish(ISuite suite) {
		//getDriver().quit();		
	}

	
	public static WebDriver getDriver() {
		return driver;
	}

	public static String getBrowser() {
		return browser;
	}

	public static String getUrl() {
		return url;
	}

	public static String getApiKey() {
		return apiKey;
	}


}
