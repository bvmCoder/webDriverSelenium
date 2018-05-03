package webdriver.scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class WebDriverMethods_Test {
  
 public WebDriver driver;

	
  @Test
  public void WebDriver_Methods() throws InterruptedException {
	  
	  driver.get("http://newtours.demoaut.com"); //Access URL
	  driver.navigate().to("http://newtours.demoaut.com/mercuryregister.php"); //Navigate to URL
	  driver.manage().window().maximize(); //Maximize the browser window
	  String URL = driver.getCurrentUrl();
	  System.out.println("Page current URL is :" + URL);  //Print URL
	  System.out.println(driver.getTitle()); //Print page title
	  System.out.println("Window ID is :" + driver.getWindowHandle());
	  driver.navigate().refresh(); //Refresh the browser
	  driver.navigate().back(); //Navigate back in browser
	  Thread.sleep(2000); //Wait for 2 Secs
	  driver.navigate().forward(); //Navigate forward in browser
	  System.out.println("Page source is : " + driver.getPageSource());
  }
  
  @BeforeClass
  public void LaunchBrowser() {
	  //System.setProperty("webdriver.ie.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\IEDriverServer.exe");
	  System.setProperty("webdriver.chrome.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\chromedriver.exe");
	  //System.setProperty("webdriver.gecko.driver", "G:\\Selenium_Java\\Java_Basics_Training\\lib\\geckodriver.exe");
	  //driver = new InternetExplorerDriver();
	 //driver = new FirefoxDriver();
	  driver = new ChromeDriver();
  }

  @AfterClass
  public void CloseBrowser() {
	  driver.close(); //Close the browser window in which focus is set
	  driver.quit(); //Calls the driver.dispose method which in turn closes all the browser windows
  }

}
