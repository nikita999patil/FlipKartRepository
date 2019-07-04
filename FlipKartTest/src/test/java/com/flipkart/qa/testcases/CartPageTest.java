package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.CartPage;
import com.flipkart.qa.pages.CustomerDetailsPage;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;



public class CartPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CartPage cartPage;
	CustomerDetailsPage customerDetailsPage;
	
	public CartPageTest(){
		super();
	}
	
	
@BeforeTest	
	public void setUp(){
		initialization();  // Calling TestBase method
		loginPage = new LoginPage();//create object of loginPage class in this class so that we can use methods present inside loginPage	
		cartPage = new CartPage();
		customerDetailsPage = new CustomerDetailsPage();
		homePage = loginPage.login(prop.getProperty("userName"),prop.getProperty("passWord"));
		cartPage = homePage.clickOnCart();
	}

@Test
public void verifyMyCartLogoTest(){
	Assert.assertTrue(cartPage.verifyMyCartLogo());
}

@Test
public void clickOnPlaceOrderTest(){
	customerDetailsPage = cartPage.clickOnPlaceOrder();
}

	
@AfterTest
	public void tearDown(){
	 driver.quit();
	}
}
