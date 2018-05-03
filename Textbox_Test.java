package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Textbox_Test {

	public WebDriver driver;


	@Test
	public void Textbox_Methods() {
		
		WebElement txtSearch = driver.findElement(By.className("LM6RPg"));

		System.out.println("Title attribute value is : " + txtSearch.getAttribute("title"));
		System.out.println("Type attribute value is : " + txtSearch.getAttribute("type"));
		System.out.println("Name attribute value is : " + txtSearch.getAttribute("name"));
		System.out.println("Class attribute value is : " + txtSearch.getAttribute("class"));
		txtSearch.sendKeys("iphone");
		System.out.println("Value found in Search textbox is : " + txtSearch.getAttribute("value"));
		txtSearch.sendKeys(Keys.ENTER); //Simulate the Enter keystroke
		txtSearch.clear(); //Clear the text from the Search textbox
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
