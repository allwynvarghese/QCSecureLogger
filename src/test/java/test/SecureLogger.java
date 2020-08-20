package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageFactoryLogger.HomePageFactory;
import com.PageFactoryLogger.LoginPageFactory;

import FileReader.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.refreshPage;

public class SecureLogger {
	WebDriver driver;
  
	@Test(dataProvider="testdata")
	public void demoClass(String username, String password) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://secure.quikchex.in/users/sign_in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPageFactory loginPg = new LoginPageFactory(driver);
		
		//set username
		loginPg.setUsername(username);
		Thread.sleep(2000);
		
		//set password
		loginPg.setPassword(password);
		Thread.sleep(2000);
		
		//click on the login button
		loginPg.clickLogin();
		
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.getTitle().contains("My Dashboard"), "Invalid credentials");
		System.out.println("Login successful");
		
		//Click on the check-in button
		HomePageFactory hp = new HomePageFactory(driver);
		hp.checkInTime();
		
		Thread.sleep(1000);
		
		//refresh
		refreshPage refresh = new refreshPage(driver);
		refresh.refreshWebPage();
		
		Thread.sleep(5000);
		
		//Signout
		hp.signOut();
		
	}
	
	@AfterMethod
	void ProgramTermination() {
		driver.quit();
	} 

	@DataProvider(name="testdata")
	public Object[][] testDataExample(){
		ReadExcelFile configuration = new ReadExcelFile("C:\\Users\\Allwyn\\eclipse-workspace\\SeleniumWebDriver\\Data\\DataLogger.xlsx");
		int rows = configuration.getRowCount(0);
		Object[][]signin_credentials = new Object[rows][2];

		for(int i=0;i<rows;i++)
		{
			signin_credentials[i][0] = configuration.getData(0, i, 0);
			signin_credentials[i][1] = configuration.getData(0, i, 1);
		}
		return signin_credentials;
	}
}
