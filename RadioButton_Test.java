package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class RadioButton_Test {

	public WebDriver driver;


	@Test
	public void Button_Methods() {
		
		WebElement OneWay = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		
		System.out.println(OneWay.getAttribute("id"));
		System.out.println(OneWay.getAttribute("type"));
		System.out.println(OneWay.getAttribute("value"));
		System.out.println(OneWay.getAttribute("name"));

		System.out.println("Object/WebElement display status is : " + OneWay.isDisplayed());
		System.out.println("Object/WebElement enable status is : " + OneWay.isEnabled());
		System.out.println("Radio button before selection status is : " + OneWay.isSelected());
		OneWay.click(); //Select the radiobutton
		System.out.println("Radio button after selection status is : " + OneWay.isSelected());
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
		//driver.quit();
	}

}
