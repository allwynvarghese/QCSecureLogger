package com.PageFactoryLogger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	
	public WebDriver driver;
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*** ---------------------------------------Web Objects-------------------------------------------  ***/
	
	@FindBy(xpath="//*[@id='user_email']")
	public WebElement username;
	
	@FindBy(xpath="//*[@id='user_password']")
	public WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Log Me In')]")
	public WebElement login;
	
	public void setUsername(String user) {
		username.click();
		username.sendKeys(user);
	}
	
	public void setPassword(String passkey) {
		password.click();
		password.sendKeys(passkey);
	}
	
	public void clickLogin() {
		login.click();
	}

}
