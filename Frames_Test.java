package webdriver.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames_Test {
	public static WebDriver driver;

	@BeforeClass
	public void AccessSite()
	{
		System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com");
		System.out.println("Successfully accessed the site");
	}
	
	@Test
	public void verifyFrame()
	{
		driver.findElement(By.linkText("Autocomplete")).click();
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/resources/demos/autocomplete/default.html']")));
		//driver.findElement(By.xpath("//inframe[@class='demo-frame']"));
		//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.switchTo().frame(0); //Switch to frame based on frame index
		driver.findElement(By.id("tags")).sendKeys("selenium"); //Frame
		//Switch back WebDriver focus from a frame
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("jQuery UI")).click();
		System.out.println("Successfully entered the value in textbox of a frame");
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		//driver.quit();
		//System.out.println("Successfully closed the browser");
	}

}
