package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Button_Test {

	public WebDriver driver;


	@Test
	public void Button_Methods() {
		
		WebElement btnSearch = driver.findElement(By.className("LM6RPg"));

		System.out.println("Class attribute value is : " + btnSearch.getAttribute("class"));
		System.out.println("Type attribute value is : " + btnSearch.getAttribute("type"));
		System.out.println("Data react id attribute value is : " + btnSearch.getAttribute("data-reactid"));
		driver.findElement(By.name("q")).sendKeys("watches");
		btnSearch.click();
	}


	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); //Maximize the browser window
		driver.get("https://www.flipkart.com/");

	}

	@AfterClass
	public void CloseBrowser() {
		//driver.quit();
	}

}
