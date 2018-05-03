package webdriver.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript_Test {
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Selenium_Automation\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("http://www.spicejet.com/");
		driver.get("https://www.flipkart.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//js.executeScript("alert('hello world this is Java Script');");

		//Refresh browser window
		//js.executeScript("history.go(0)");
		//js.executeScript("arguments[0].click();", driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")));
		//js.executeScript("arguments[0].value ='mobile phone';", driver.findElement(By.name("q")));
		
		
	}

}	
