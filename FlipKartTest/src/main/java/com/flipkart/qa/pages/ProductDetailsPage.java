package com.flipkart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.qa.base.TestBase;

public class ProductDetailsPage extends TestBase{
	
	@FindBy(xpath="//div[@id='container']//div[@class='bhgxx2']//span//span")
	WebElement productName;
	
	@FindBy(xpath="//div[@class='_1qKb_B']//select[@class='fPjUPw']")
	WebElement minPriceDropDown;
	
	@FindBy(xpath="//div[@class='_1YoBfV']//select[@class='fPjUPw']")
	WebElement maxPriceDropDown;
	
	@FindBy(xpath="//section[@class='D_NGuZ _1KDdN8']//div[@class='_2kFyHg _1_fxb2']//div[@class='_1p7h2j']")
	WebElement FlipkartAssuredCheckbox;
	
	@FindBy(xpath="//div[@class='_2kFyHg _2mtkou']//label//div[contains(text(),'64 - 127.9 GB')]/preceding-sibling::input[@class='_3uUUD5']")
	WebElement innternalStorageCheckbox;
	
	@FindBy(xpath="//div[contains(text(),'Price -- Low to High')]")
	WebElement PriceFilter;
	
	@FindBy(xpath="//div[contains(text(),'Redmi Note 7 Pro (Neptune Blue, 128 GB)')]")
	WebElement mobileModelName;
	
//	@FindBy(xpath="//div[@class='_1YuAuf']//section[8]//*[local-name()='svg']//*[local-name()='path']")
//	WebElement internalStorage;
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void setFilters(){
		//Set Price
		Select sel1 = new Select(minPriceDropDown);
		sel1.selectByIndex(1);
		Select sel2 = new Select(maxPriceDropDown);
		sel2.selectByIndex(1);
		FlipkartAssuredCheckbox.click();
		
		 Actions a = new Actions(driver);
		 a.moveToElement(driver.findElement(By.xpath("//div[@class='_1YuAuf']//section[8]//*[local-name()='svg']//*[local-name()='path']"))).click().perform();
		
//		internalStorage.click();
//		innternalStorageCheckbox.click();
//		PriceFilter.click();
	}
	
	public void checkPrice(){
		mobileModelName.click();
	}
	
	
	

}
