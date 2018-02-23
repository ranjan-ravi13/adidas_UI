package com.adidas.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.LandingPage;

public class CartPageTest extends TestBase {
	
	LandingPage landingPage;
	CartPage cartPage;
	
	public CartPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		landingPage = new LandingPage();
		cartPage = landingPage.navigateToCartScreen();
		}
	
	@Test
	public void emptyCartPageHeaderTest() {
		String expectedHeader = "YOUR BAG IS EMPTY";
		String actualText = cartPage.getCartPageHeader();
		Assert.assertEquals(actualText, expectedHeader,"Actual and expected header did not match!!");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

