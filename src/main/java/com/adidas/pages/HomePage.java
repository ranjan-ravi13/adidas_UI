package com.adidas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adidas.base.TestBase;
import com.adidas.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath="//div[@class='accountwelcome']/h1")
	WebElement AccountWelcomeMsg;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateHomePage(){
		return AccountWelcomeMsg.isDisplayed();
	}
	
	public String getHomePageHeader() {
		TestUtil.waitForVisibilityOf(AccountWelcomeMsg, 5);
		return AccountWelcomeMsg.getText();
	}
	
}
