package com.flipkart.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.CartPage;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.pages.ProductDetailsPage;
import com.flipkart.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public ProductDetailsPage productDetailsPage;
	String sheetName = "HomePage";
	
	public HomePageTest(){
		super();     //it will call TestBase constructor where we initialize property file
	}
	
@BeforeMethod
public void setUp(){
	initialization();  // Calling TestBase method
	loginPage = new LoginPage();//create object of loginPage class in this class so that we can use methods present inside loginPage	
	cartPage = new CartPage(); 
	homePage = loginPage.login(prop.getProperty("userName"),prop.getProperty("passWord"));	
}

@Test(priority=0)
public void verifyHomePageTitleTest(){
    String title =homePage.verifyHomePageTitle();
    Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!", "Home PAge Title is not matched");
//in this assert we added third parameter it is behaving like a message where expected value and actual value will not match then we will get that message inn our report
}

@DataProvider
public Object[][] getHomePageData(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
}

@Test(priority=1,dataProvider="getHomePageData")
public void selectSearchItem(String SearchItem){
	productDetailsPage = homePage.verifyselectSearchItem(SearchItem);
	
}


@Test(priority=2)
public void verifyUserNameLogoTest(){
Assert.assertTrue(homePage.verifyUserNameLogo());
}

@Test(priority=3)
public void verifyClickOnMoreTest(){
	homePage.clickOnMore();
}

@Test(priority=4)
public void clickOnCartTest(){
	cartPage = homePage.clickOnCart();
	
}


@AfterMethod
public void tearDown(){
	driver.quit();
}

	

}
