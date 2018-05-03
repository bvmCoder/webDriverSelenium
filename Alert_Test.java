package webdriver.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert_Test {
	public WebDriver driver; 
	
	public void Alert_Demo()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		
		alert.accept();
		//alert.dismiss();
	}
	
	
	public static void main(String[] args) {
		Alert_Test at = new Alert_Test();
		at.Alert_Demo();

	}

}
