package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	WebDriver driver;
	
	public Waits(WebDriver driver) {
		this.driver = driver;
	}

	//1. Wait for an element present
	public WebElement waitforElementPresent(By locator, int timeout) {
		WebElement element = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}catch(Exception e) {
			System.out.println("Exception occured: "+ e);
		}
		
		return element;
	}
	
	//2. 
}
