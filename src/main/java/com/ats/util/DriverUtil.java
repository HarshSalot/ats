package com.ats.util;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ats.pages.BasePage;

public class DriverUtil extends BasePage {
	WebDriver driver;
	List<WebElement> linkList;

	public DriverUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String getPageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("Exception occured with title");
		}
		return title;
	}
}
