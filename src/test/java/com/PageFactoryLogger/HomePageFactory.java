package com.PageFactoryLogger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	public WebDriver driver;
	
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*** -----------------------------------------Web Objects----------------------------------------------------- ***/
	
	@FindBy(xpath="//a[@id='checkin']")
	private WebElement checkinButton;
	
	@FindBy(xpath="//li[@class='dropdown profile_menu']/a[contains(@style, 'background-color: #eb7f37')]")
	private WebElement profileButton;
	
	@FindBy(xpath="//a[contains(text(), 'Sign Out')]")
	private WebElement signOutButton;
	
	/*** -----------------------------------------Methods-------------------------------------------------------- ***/
	
	public void checkInTime() {
		checkinButton.click();
	}
	
	public void signOut() throws InterruptedException {
		//click on the profile button.
		profileButton.click();
		Thread.sleep(1000);
		//Click on the signOut link
		signOutButton.click();
	}
	
}
