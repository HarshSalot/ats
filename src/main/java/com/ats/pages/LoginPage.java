package com.ats.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ats.util.Constants;
import com.ats.util.DriverUtil;
import com.ats.util.ElementActions;
import com.ats.util.TimeUtil;

public class LoginPage extends BasePage {
	ElementActions elementActions;
	DriverUtil driverUtil;
	WebDriver driver;
	
	//By Locators
	By userName = By.name("username");
	By password = By.name("password");
	By loginButton =By.xpath("//span[contains(text(),'Login')]");
	By loginPageHeader = By.xpath("//h4[@class='MuiTypography-root-824 MuiTypography-h4-832']");
	By signUpLink = By.linkText("Sign up");
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementActions = new ElementActions(driver);
		driverUtil = new DriverUtil(driver);
	}
		
	//define page action/methods
			public String getLoginPageTitle(){
			return driverUtil.getPageTitle();
		}
		
			
			public String getLoginPageHeader() {
		        TimeUtil.mediumWait();
				WebElement headerTitle = driver.findElement(loginPageHeader);
				String title = headerTitle.getText();
				System.out.println(headerTitle.getText());
				return title;
			}
		
			public HomePage doLogin(String username, String pass){
			{
				//driver.findElement(emailID).sendKeys(username);
				elementActions.doSendkeys(userName, username);
				elementActions.doSendkeys(password, pass);
				elementActions.doClick((loginButton));
				return new HomePage(driver);
			}
			
		}	
		
}
