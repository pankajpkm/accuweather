package accuweather.org;

/**
 * @author Pankajpkm
 * 
 */

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import accuweather.org.HomeFlow.HomePageFlow;
import accuweather.org.Listner.BaseListner;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccuweatherTest extends BaseListner {
	WebDriver driver;
	HomePageFlow homePageFlow;
	private final String API_KEY="7fe67bf08c80ded756e598d6f8fedaea'";
	
	@BeforeClass
	public void init() {
		driver= getDriver();
		homePageFlow = new HomePageFlow();
	}
	
	@Test
	public void compareAccuweatherTest() throws InterruptedException {
		driver.get(getUrl());
		String city = "Bengaluru, Karnataka, IN";
		homePageFlow.searchWeatherFor(city);
		String webTemp=homePageFlow.getCurrentWeather();
		System.out.println("Web : "+webTemp);
		
		
		RestAssured.baseURI="https://api.openweathermap.org";
		//RestAssured.baseURI="https://openweathermap.org/current";
		RequestSpecification reqs = RestAssured.given();		
		reqs.queryParam("q", city);
		reqs.queryParam("appid", API_KEY);
		Response resp = reqs.request(Method.GET, "/data/2.5/weather");
		resp.prettyPrint();
		String apiTemp=resp.andReturn().then().statusCode(200).extract().body().jsonPath().get("x.main.temp");
		System.out.println("API : "+apiTemp);
	}
}
