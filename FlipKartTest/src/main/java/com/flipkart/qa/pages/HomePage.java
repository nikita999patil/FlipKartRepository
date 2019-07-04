package com.flipkart.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[contains(text(),'Nikita')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@id='container']//div[@class='_2aUbKa' and text()='More']")
	WebElement moreLabel;
	
	@FindBy(xpath="//div[@id='container']//div[@class='_1jA3uo']//div[@class='_2dcihZ']")
	WebElement CartLabel;
	
	@FindBy(xpath="//input[@name='q']")
	WebElement SearchBox;

public HomePage(){
	PageFactory.initElements(driver, this);
}

public String verifyHomePageTitle(){
	return driver.getTitle();
}

public boolean verifyUserNameLogo(){
 	return userNameLabel.isDisplayed();
}

public ProductDetailsPage verifyselectSearchItem(String ItemName){
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
SearchBox.sendKeys(ItemName);

//---------------get all elements from dropdown
//List<WebElement> lst = driver.findElements(By.xpath("/div[@id='container']//div[@class='Y5-ZPI']//li"));
//int size = lst.size();
//int i;
//for( i=0;i<=size;i++)
//{	
//    String elementPresent = lst.get(i).getText();	
//    System.out.println(elementPresent);
//}	

Actions act = new Actions(driver);
act.sendKeys(Keys.ENTER).perform();
return new ProductDetailsPage() ;
}

public void clickOnMore(){
	moreLabel.click();
}

public CartPage clickOnCart(){
	CartLabel.click();
	return new CartPage();
}

}