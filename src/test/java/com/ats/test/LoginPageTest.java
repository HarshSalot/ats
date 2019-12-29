package com.ats.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ats.pages.BasePage;
import com.ats.pages.HomePage;
import com.ats.pages.LoginPage;
import com.ats.util.Constants;
import com.ats.util.TimeUtil;

public class LoginPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage; 
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		TimeUtil.mediumWait();
	}
	
	@Test(priority=1, description="verifying login page title", enabled=true)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.getLoginPageTitle();
		System.out.println(""+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2, description="verifying login page header", enabled=false)
	public void verifyHomePageHeader(){
		String header = loginPage.getLoginPageHeader();
		System.out.println("home page header is: "+ header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}

	
	
	@Test(priority=3, description="Check Login by entering valid username & valid password", enabled=true)
	public void ATSLoginTest_1(){
		homePage = loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.HOME_PAGE_TITLE);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
