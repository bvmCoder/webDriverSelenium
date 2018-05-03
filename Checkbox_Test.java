package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Checkbox_Test {

	public WebDriver driver;


	@Test
	public void Button_Methods() {
		
		WebElement chkIndianArmed = driver.findElement(By.id("ctl00_mainContent_chk_IndArm"));
		
		System.out.println(chkIndianArmed.getAttribute("id"));
		System.out.println(chkIndianArmed.getAttribute("type"));
		System.out.println(chkIndianArmed.getAttribute("name"));

		System.out.println("Object/WebElement display status is : " + chkIndianArmed.isDisplayed());
		System.out.println("Object/WebElement enable status is : " + chkIndianArmed.isEnabled());
		System.out.println("Checkbox before selection status is : " + chkIndianArmed.isSelected());
		chkIndianArmed.click(); //Select the checkbox
		System.out.println("Checkbox after selection status is : " + chkIndianArmed.isSelected());
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
