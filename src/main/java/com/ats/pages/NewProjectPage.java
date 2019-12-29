package com.ats.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ats.util.DriverUtil;
import com.ats.util.ElementActions;
import com.ats.util.TimeUtil;

public class NewProjectPage extends BasePage {
	
	DriverUtil driverUtil;
	ElementActions elementActions;
	
	//By Locators
		By projectName = By.name("name");
		By countryName = By.name("location.country.id");
		By provinceName = By.name("location.province.id");
		By cityName = By.name("location.city.id");
		By address = By.name("address");
		By bidDate = By.name("bidDate");
		By area = By.name("area");
		By selectBuildingclass = By.xpath("//p[contains(text(),'Office Buildings')]");
		By nxtBtn = By.xpath("//span[contains(text(),'Next')]");
		By finishBtn = By.xpath("//span[contains(text(),'Finish')]");
		
		
	//input[@name='name']

	public NewProjectPage (WebDriver driver) {
		this.driver = driver;
		driverUtil = new DriverUtil(driver);
		elementActions = new ElementActions(driver);
	}
	
	public String getLoginPageTitle(){
		return driverUtil.getPageTitle();
	}
	
	public void projectDetails(String projtName, String country, String province, String city, String addr, String bidDte, String ara){
		{
			//driver.findElement(emailID).sendKeys(username);
			elementActions.doSendkeys(projectName, projtName);
			//elementActions.doSelect(countryName, country);
			elementActions.doSendkeys(countryName, country);
			TimeUtil.shortWait();
			elementActions.doSendkeys(provinceName, province);
			TimeUtil.shortWait();
			elementActions.doSendkeys(cityName, city);
			TimeUtil.shortWait();
			elementActions.doSendkeys(address, addr);
			TimeUtil.shortWait();
			elementActions.doSendkeys(bidDate, bidDte);
			elementActions.doSendkeys(area, ara);
			elementActions.doClick((nxtBtn));
			TimeUtil.longWait();
			//return new HomePage(driver);
		}
	}	
		
	public void buildingClass(){
		
		elementActions.doClick((selectBuildingclass));
		TimeUtil.shortWait();
		elementActions.doClick((nxtBtn));
		TimeUtil.shortWait();
		elementActions.doClick((finishBtn));
	}


}

