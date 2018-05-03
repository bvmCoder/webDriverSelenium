package webdriver.scripts;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Javascript_Methods {
	public WebDriver driver;
	String strRootpath = System.getProperty("user.dir");
	
  @Test
  public void Javascriptexecutor_Methods_Demo() {
	  driver.manage().window().maximize();
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  //Using Javascriptexecutor to enter data in a textbox
 	  WebElement txtUsername = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.getElementsByName('userName')[0];");
 	  //Highlight username textbox
 	  js.executeScript("arguments[0].style.border='2px groove green'", driver.findElement(By.name("userName")));
 	  
 	  
 	  txtUsername.sendKeys("naresh");
	  WebElement txtPassword = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.getElementsByName('password')[0];");
	  js.executeScript("arguments[0].style.border='2px groove green'", driver.findElement(By.name("password")));
 	  
	  txtPassword.sendKeys("secure*12");
	  //Using Javascriptexecutor to click on a button
	  WebElement btnLogin = (WebElement) ((JavascriptExecutor) driver).executeScript("return document.getElementsByName('login')[0];");
	  btnLogin.click();
  
	  //Click on a button using JavascriptExecutor
 	  //driver.findElement(By.name("userName")).sendKeys("ajit"); //Using WebDriver to enter data in a textbox
	  //driver.findElement(By.name("login")).click(); //Using WebDriver to click on a button
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.ie.driver", strRootpath + "/lib/IEDriverServer.exe");
	  driver = new InternetExplorerDriver(); //Launch Browser
	  driver.get("http://newtours.demoaut.com/");
  }

  @AfterClass
  public void afterClass() {
  }

}
