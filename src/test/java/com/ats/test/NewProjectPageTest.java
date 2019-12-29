package com.ats.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ats.pages.BasePage;
import com.ats.pages.HomePage;
import com.ats.pages.LoginPage;
import com.ats.pages.NewProjectPage;
import com.ats.util.Constants;
import com.ats.util.TimeUtil;

public class NewProjectPageTest {
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage; 
	NewProjectPage newProjectPage;
	
	@BeforeMethod
	public void setup(){
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		TimeUtil.shortWait();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		TimeUtil.shortWait();
		newProjectPage = homePage.doNewProject();
		TimeUtil.shortWait();
	}
	
	@Test(priority=1, description="verifying login page title", enabled=false)
	public void verifyNewProjectTitleTest(){
		String title = newProjectPage.getLoginPageTitle();
		Assert.assertEquals(title, Constants.NEW_PROJECT_PAGE_TITLE);
	}
	
	@Test(priority=1, description="fill step 1")
	public void verifyprojectTitleDetail(){
		newProjectPage.projectDetails("H", "Canada", "Ontario", "Toronto", "130, Carabob crt", "2019-12-20", "10");
		//Assert.assertEquals(title, Constants.NEW_PROJECT_PAGE_TITLE);
		TimeUtil.mediumWait();
		newProjectPage.buildingClass();
	}
	
	
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
