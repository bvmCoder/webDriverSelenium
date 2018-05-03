package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Image_Test {

	public WebDriver driver;


	@Test
	public void Button_Methods() {
		
		WebElement imgMealBanner = driver.findElement(By.xpath("//img[contains(@src,'images/meal')]"));
		
		System.out.println(imgMealBanner.getAttribute("width"));
		System.out.println(imgMealBanner.getAttribute("height"));
		System.out.println(imgMealBanner.getAttribute("data-transition"));
		System.out.println(imgMealBanner.getAttribute("src"));
	}


	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //Maximize the browser window
		driver.get("http://www.spicejet.com/");

	}

	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}

}
