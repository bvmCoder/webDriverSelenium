package webdriver.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DragandDrop {

	WebDriver driver;
	
	@Test
	public void testDragAndDropExample() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/lib/chromedriver.exe");
		driver = new ChromeDriver(); //Launch Browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement Sourcelocator = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Destinationlocator = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions ac = new Actions(driver);
		ac.dragAndDrop(Sourcelocator,Destinationlocator).perform();
		String actualText=driver.findElement(By.cssSelector("#droppable>p")).getText();
		Assert.assertEquals(actualText, "Dropped!");
	}
}