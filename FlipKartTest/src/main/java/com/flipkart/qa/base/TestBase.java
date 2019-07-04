package com.flipkart.qa.base;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.flipkart.qa.util.TestUtil;
import com.flipkart.qa.util.WebEventListener;

//-----------RULE FOR GOOD PROGRAMMING-------------------
//TestCases should be independent or separate with each other
//before  each test case launch the browser
//execute your test case
//After each test case close the  browser
//methods should be generic

public class TestBase {
	public static WebDriver driver ;
    public static Properties prop;
    public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
     //define default constructor
	public TestBase(){
		 try{
			FileInputStream ip = new FileInputStream("C:\\Users\\Dell\\Desktop\\Nikita_workspace2\\New folder\\FlipKartTest\\src\\main\\java\\com\\flipkart\\qa\\config\\config.properties");
			prop = new Properties();
			prop.load(ip);
			}
		    catch (Exception e) {
			e.printStackTrace();
            } 
         }
		
	
   public static void initialization(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("firefox")){
		driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
}