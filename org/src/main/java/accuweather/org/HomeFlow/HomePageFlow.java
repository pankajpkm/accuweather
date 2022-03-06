package accuweather.org.HomeFlow;

/**
 * @author Pankajpkm
 * 
 */

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import accuweather.org.HomePage.HomePage;
import accuweather.org.Listner.BaseListner;
import accuweather.org.util.Helpers;

public class HomePageFlow {
	HomePage homePage;
	
	public HomePageFlow() {
		homePage = new HomePage();
	}
	
	public void searchWeatherFor(String city) {
		Helpers.waitForElement(homePage.getQueryInput());
		if(Helpers.isAlertPresent())
			Helpers.handleAlert("Block");
		homePage.getQueryInput().sendKeys(city);
		Actions builder = new Actions(BaseListner.getDriver());
		builder.sendKeys(Keys.ENTER).build().perform();		
	}

	public String getCurrentWeather() {
		Helpers.waitForElement(homePage.getCurrentTemp());
		String cWeather=homePage.getCurrentTemp().getText();
		return cWeather.trim();
	}
}
