package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class Actions_Test {

	public WebDriver driver;
	
	
/*	@Test
	public void ClickAndHold_Demo()
	{
		Actions menu = new Actions(driver);
		WebElement lnkContactUs = driver.findElement(By.linkText("Contact Us"));
		menu.clickAndHold(lnkContactUs).perform();
	}*/
	
	@Test
	public void DoubleClick_Demo()
	{
		Actions menu = new Actions(driver);
		WebElement chkIndianArmedForces = driver.findElement(By.id("ctl00_mainContent_chk_IndArm"));
		menu.doubleClick(chkIndianArmedForces).perform();
	}
	
	
	
	/*@Test(priority=1)
	public void MouseHover_Demo() throws InterruptedException 
	{
		WebElement lnkInvestors = driver.findElement(By.linkText("Investors"));
		Actions menu = new Actions(driver);
		menu.moveToElement(lnkInvestors).perform();
		Thread.sleep(1000);
		WebElement lnkCorporateGovernance = driver.findElement(By.xpath("//a[contains(.,'Corporate Governance  ')]"));
		menu.moveToElement(lnkCorporateGovernance).perform();
		Thread.sleep(1000);
		WebElement lnkCorporate = driver.findElement(By.linkText("Corporate Governance"));
		lnkCorporate.click();
		System.out.println(driver.getTitle());
		//Checkpoint
		// Assert.assertEquals(driver.getTitle(), "Code of Conduct | SpiceJet Airlines123");
	}*/

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
