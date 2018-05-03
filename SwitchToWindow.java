package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class SwitchToWindow {
  public WebDriver driver;
	
  @Test
  public void SwitchToWIndow_Test()
  {
  	  driver.findElement(By.xpath("//img[@src='/assets/images/Slug_banner_home_loan_new.gif']")).click();
	  //Get the current window ID
	  String wndhandle = driver.getWindowHandle();
	  System.out.println("Window ID is:"+wndhandle);
	  driver.switchTo().window(wndhandle);
	  //Get Window Handles
	  Set<String> windows = driver.getWindowHandles();
	  windows.remove(wndhandle);
	  driver.switchTo().window(windows.iterator().next());
	  driver.findElement(By.id("eForm_form_details_applicant_currentContactDetail_primaryMobile_contact")).sendKeys("2352246346246");
	  driver.switchTo().window(wndhandle);
	  CloseChildWindows(wndhandle); //method class
	  driver.switchTo().window(wndhandle);
	  driver.findElement(By.className("searchbox")).sendKeys("Personal Loan");
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.hdfcbank.com/");
	  driver.findElement(By.xpath("//img[@src='/assets/images/close.png']")).click();

  }
  @AfterClass
  public void CloseChildWindows(String wndhandle) {
	  
	  Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(wndhandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}
//	  driver.quit();
  }

}
