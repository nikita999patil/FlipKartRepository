package com.flipkart.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.ProductDetailsPage;

public class ProductDetailsPageTest extends TestBase {
	public LoginPage loginPage;
	public HomePage homePage;
	public ProductDetailsPage productDetailsPage;
	
	public ProductDetailsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();  // Calling TestBase method
		loginPage = new LoginPage();//create object of loginPage class in this class so that we can use methods present inside loginPage	
		homePage = loginPage.login(prop.getProperty("userName"),prop.getProperty("passWord"));	
		productDetailsPage = homePage.verifyselectSearchItem(prop.getProperty("searchProduct"));	
	}
	
	@Test(priority = 0)
	public void setFiltersTest(){
		productDetailsPage.setFilters();
	}
	
//	@Test(priority = 1)
//	public void checkPriceTest(){
//		productDetailsPage.checkPrice();
//	}
	
	
	

}
