package accuweather.org.HomePage;

/**
 * @author Pankajpkm
 * <p> Home Page Elements, Page Factory Method</p>
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import accuweather.org.Listner.BaseListner;

public class HomePage {
	
	@FindBy(xpath="//input[@name='query']")
	WebElement queryInput;
	
	@FindBy(className="temp")
	WebElement currentTemp;
	
	//Bengaluru, Karnataka, IN
	
	
	public HomePage() {
		PageFactory.initElements(BaseListner.getDriver(), this);
	}

	public WebElement getQueryInput() {
		return queryInput;
	}

	public WebElement getCurrentTemp() {
		return currentTemp;
	}
	
	
}
