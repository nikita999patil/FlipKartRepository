package com.flipkart.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.flipkart.qa.base.TestBase;
import com.flipkart.qa.pages.HomePage;
import com.flipkart.qa.pages.LoginPage;
import com.flipkart.qa.util.TestUtil;


public class LoginPageTest extends TestBase{
	public LoginPage loginPage;
	public HomePage homePage;
	String sheetName = "LoginDetails";
	public LoginPageTest(){
		super();     //it will call TestBase constructor where we initialize property file
	}
	
@BeforeMethod
 public void setUp(){
	initialization();  // Calling TestBase method
	 loginPage = new LoginPage();  //create object of loginPage class in this class so that we can use methods present inside loginPage	
	}

@Test(priority=1)
public void loginPageTitleTest(){
	String title = loginPage.validateTitleOfLoginPage();
	Assert.assertEquals(title,"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
}

@Test(priority=2)
public void verifyLogoTest(){
	boolean logo = loginPage.validateFlipkartLogo();
	Assert.assertTrue(logo);
}

@DataProvider
public Object[][] getFlipKartTestData(){
	Object data[][] = TestUtil.getTestData(sheetName);
	return data;
		
}


// here we are using Data Driven approach
@Test(priority=3,dataProvider="getFlipKartTestData")
 public void loginTest(String UserName, String Password){
	//homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("passWord"));  // because it is returning homepage, so we created object of homepage here
      homePage = loginPage.login(UserName, Password);
}


	
@AfterMethod
 public void tearDown(){
	 driver.quit();
 }
	

}
