package com.adidas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adidas.base.TestBase;
import com.adidas.util.TestUtil;


public class LoginPage extends TestBase {

	// pageFactory - OR
	@FindBy(id = "dwfrm_login_username")
	WebElement username;

	@FindBy(id = "dwfrm_login_password")
	WebElement password;

	@FindBy(xpath = "//div[@class='logincustomers block']/h2")
	WebElement loginHeader;

	@FindBy(xpath = "//button[@value='Log in']")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLoginHeaderVisibility() {
		return loginHeader.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		System.out.println("Entered Username is : " + un);
		TestUtil.waitForVisibilityOf(username, 5);
		username.sendKeys(un);
		TestUtil.waitForVisibilityOf(password, 5);
		password.sendKeys(pwd);
		Thread.sleep(10000);
		loginBtn.click();
		return new HomePage();
	}
}
