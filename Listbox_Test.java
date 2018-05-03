package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class Listbox_Test {

	public WebDriver driver;


	@Test
	public void Button_Methods() throws InterruptedException {
		
		WebElement lstAdult = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		
		System.out.println(lstAdult.getAttribute("id"));
		System.out.println(lstAdult.getAttribute("class"));
		System.out.println(lstAdult.getAttribute("name"));

		System.out.println("Object/WebElement display status is : " + lstAdult.isDisplayed());
		System.out.println("Object/WebElement enable status is : " + lstAdult.isEnabled());
		System.out.println("Listbox selection status is : " + lstAdult.isSelected());
		
		//Select an item from dropdown list
		Select list = new Select(lstAdult);
		Thread.sleep(2000);
		list.selectByValue("5"); //Select list item by value
		Thread.sleep(2000);
		list.selectByIndex(0); //Select an item from listbox based on its index (Index always starts from 0)
		Thread.sleep(2000);
		list.selectByVisibleText("3 Adults");
		
		List<WebElement> nAdults = lstAdult.findElements(By.tagName("option"));
		
		System.out.println("No of items found in dropdown list is : " +  nAdults.size());
		
		
		for (int i = 0; i < nAdults.size(); i++) 
		{
			String strValue = nAdults.get(i).getText();
			System.out.println("Value found in Adults dropdown is : " + strValue);
			
			if (strValue.equalsIgnoreCase("3 Adults")) 
			{
				break;
			}
		}
		
		
		
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
