package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Link_Test {

	public WebDriver driver;


	@Test
	public void Button_Methods() {
		
		WebElement lnkTrackOrder = driver.findElement(By.linkText("Track Order"));
		
		System.out.println(lnkTrackOrder.getAttribute("class"));
		System.out.println(lnkTrackOrder.getAttribute("data-reactid"));
		System.out.println(lnkTrackOrder.getAttribute("href"));

		lnkTrackOrder.click(); //Click in TrackOrder link
		
		driver.findElement(By.partialLinkText("Sell")).click(); //Partial link text
	}


	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //Maximize the browser window
		driver.get("https://www.flipkart.com/");

	}

	@AfterClass
	public void CloseBrowser() {
		//driver.quit();
	}

}
