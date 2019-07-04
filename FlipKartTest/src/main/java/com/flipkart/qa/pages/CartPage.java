package com.flipkart.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.flipkart.qa.base.TestBase;

public class CartPage extends TestBase{
	
	@FindBy(xpath="//div[@class='_3YIJgh']//span")
	WebElement myCartLogo;
	
	@FindBy(xpath="//button[@class='_2AkmmA _14O7kc _7UHT_c']//span")
	WebElement BtnPlaceOrder;
	
	public CartPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyMyCartLogo(){
	    return myCartLogo.isDisplayed();
	
	}
	
	public CustomerDetailsPage clickOnPlaceOrder(){
		BtnPlaceOrder.click();
		return new CustomerDetailsPage();
	}
	
	
	

}
