package utilities;

import org.openqa.selenium.WebDriver;

public class refreshPage {
	
	public WebDriver driver;
	
	public refreshPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void refreshWebPage() {
		driver.navigate().refresh();
	}

}
