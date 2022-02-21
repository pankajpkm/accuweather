package accuweather.org;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import accuweather.org.Listner.BaseListner;

public class AccuweatherTest extends BaseListner {
	WebDriver driver;
	@BeforeClass
	public void init() {
		driver= getDriver();
	}
	
	@Test
	public void compareAccuweatherTest() {
		driver.get(getUrl());
	}
}
