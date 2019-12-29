package com.ats.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ats.pages.BasePage;


public class ElementActions  extends BasePage{
	WebDriver driver;
	
	public ElementActions(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement getElement(By selector){
		waitForElement(selector);
		WebElement element = driver.findElement(selector);
		return element;
	}
	
	public void waitForElement(By selector){
		WebDriverWait wait= new WebDriverWait(driver, Constants.DEFAULT_EXPLICIT_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(selector));
	}
	
	public void doClick(By selector){
		try{
			getElement(selector).click();
		}catch (Exception e){
			System.out.println("Exception occured with locator: "+selector);
		}
		
	}
	
	public void doSendkeys(By selector, String value){
		try{
			//driver.findElement(emailID).sendKeys(username);
			getElement(selector).sendKeys(value);	
		} catch(Exception e){
			System.out.println("Exception occured with locator: "+selector);
		}
	}
	
	public void doSelect(By selector, String value){
		
			Select WebElement = new Select(driver.findElement(selector));
			WebElement.selectByVisibleText(value);
		
	}
	
	public Boolean elementIsDisplayed(By selector){
		return getElement(selector).isDisplayed();
	}

}
