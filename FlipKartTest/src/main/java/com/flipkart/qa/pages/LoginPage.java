package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page-Factory (Object Repository)
	@FindBy(xpath="//div[@class='Km0IJL col col-3-5']//input[@type='text']")
	//@CacheLookup  ---- it is used after findBy annotation.it will store particular webelement into cache memory to improve performance.  
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='_1avdGP']//button[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//img[@title='Flipkart']")
	WebElement FlipkartLogo;
	
	//Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);	
	}
	
	//Actions
	public String validateTitleOfLoginPage(){
		return driver.getTitle();
	}
	
	public boolean validateFlipkartLogo(){
		return FlipkartLogo.isDisplayed();
	}
	
	/// this method is returning homepage object becoz after loginpage we will get homepage
	public HomePage login(String usrnm, String pwd){
		username.sendKeys(usrnm);
		password.sendKeys(pwd);
		LoginBtn.click();
		
		return new HomePage();
		}
	

	
	
	
	
	

}
