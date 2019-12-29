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

public class HomePageTest{
	
WebDriver driver;
BasePage basePage;
Properties prop;
LoginPage loginPage;
HomePage homePage;
NewProjectPage newProjectPage;

@BeforeMethod
public void setUp(){
	basePage = new BasePage();
	prop = basePage.init_prop();
	driver = basePage.init_driver(prop);
	driver.get(prop.getProperty("url"));
	loginPage = new LoginPage(driver);
	TimeUtil.shortWait();
	homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	TimeUtil.shortWait();
}

@Test(priority=1)
public void verifyHomePageTitle(){
	String title = homePage.getHomePageTitle();
	System.out.println("home page title is: "+ title);
	Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
}

@Test(priority=1, enabled=true)
public void verifyHomePageHeader(){
	String title = homePage.getHomePageHeader();
	System.out.println("home page header is: "+ title);
	Assert.assertEquals(title, Constants.HOME_PAGE_HEADER);
}

@Test(priority=1)
public void newProject(){
	newProjectPage = homePage.doNewProject();
}

@AfterMethod
public void tearDown(){
	driver.quit();
}

}
