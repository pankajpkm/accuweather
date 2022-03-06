package accuweather.org.util;

/**
 * @author Pankajpkm
 * 
 */

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import accuweather.org.Listner.BaseListner;

public class Helpers {
	
	public static final int timeOutInSeconds = 10;
	/**
	 * @param element
	 * 
	 * Wait for Element to be Clickable
	 */
	public static void waitForElement(WebElement element) {
		WebDriver driver = BaseListner.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * @return true if alert present else false
	 */
	public static boolean isAlertPresent() {
		WebDriver driver = BaseListner.getDriver();
		try {
			driver.switchTo().alert();
			return true;
		}catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	/**
	 *  @param action
	 *  Alert/handleJsPopup according to action provided
	 */
	public static void handleAlert(String action) {
		WebDriver driver = BaseListner.getDriver();
		Alert popup = driver.switchTo().alert();
		if(action.toUpperCase().equals("ACCEPT")||action.toUpperCase().equals("OK"))
			popup.accept();
		else
			popup.dismiss();
		
	}
}
