package com.ats.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ats.util.Constants;
import com.ats.util.DriverUtil;
import com.ats.util.ElementActions;


public class HomePage extends BasePage {

	WebDriver driver;
	DriverUtil driverUtil;
	ElementActions elementActions;

	// By Locators
	By homePageHeader = By.xpath("//h6[@class='MuiTypography-root-1510 MuiTypography-h6-1520 MuiTypography-noWrap-1529']");
	By newProject = By.xpath("//span[contains(text(),'New Project')]");
	By accountName = By.xpath("//span[@class='account-name ']");
	By ContactsHoverMenu = By.id("nav-primary-contacts-branch");
	By ContactsPage = By.id("nav-secondary-contacts");
	////span[contains(text(),'New Project')]

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		driverUtil = new DriverUtil(driver);
		elementActions = new ElementActions(driver);
	}

	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));
		return driver.getTitle();
	}

	public String getHomePageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_HEADER));
		return driver.findElement(homePageHeader).getText();
	}
	
	public NewProjectPage doNewProject(){
		elementActions.doClick(newProject);
		return new NewProjectPage(driver);
	}

}
