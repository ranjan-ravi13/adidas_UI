package com.adidas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adidas.base.TestBase;
import com.adidas.util.TestUtil;

public class LandingPage extends TestBase {
	
	// pageFactory - OR
		@FindBy(xpath = "//a[@data-auto-id='logo']")
		WebElement adidasLogo;
		
		@FindBy(xpath = "//a[@manual_cm_sp='customer_info-_-Sign in']")
		WebElement signInLink;
		
		@FindBy(xpath = "//input[@name='q']")
		WebElement search;
		
		@FindBy(xpath = "//a[@title='Checkout']")
		WebElement checkout;
		
		@FindBy(xpath = "//span[@class='flag-large-fi_FI']")
		WebElement Adidas_FI;

		
		public LandingPage() {
			PageFactory.initElements(driver, this);
			Adidas_FI.click();
		}

		public String getLandingPageTitle() {
			System.out.println("************  Before test: ");
			TestUtil.waitForVisibilityOf(adidasLogo, 5);
			return driver.getTitle();
		}

		public boolean validateLandingPageLogoVisibility() {
			TestUtil.waitForVisibilityOf(adidasLogo, 5);
			return adidasLogo.isDisplayed();
		}
		
		public CartPage navigateToCartScreen() {
			TestUtil.waitForVisibilityOf(adidasLogo, 5);
			checkout.click();
			return new CartPage();
		}
		
		public LoginPage navigateToLoginScreen() {
			TestUtil.waitForVisibilityOf(adidasLogo, 5);
			signInLink.click();
			return new LoginPage();
		}
}
