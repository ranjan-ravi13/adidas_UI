package com.adidas.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adidas.base.TestBase;
import com.adidas.pages.HomePage;
import com.adidas.pages.LandingPage;
import com.adidas.pages.LoginPage;


public class HomePageTest extends TestBase {
	
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.navigateToLoginScreen();
		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		}
	
	@Test
	public void homePageHeaderTest() {
		String expectedHeader = "HELLO, RAVI";
		String actualText = homePage.getHomePageHeader();
		Assert.assertEquals(actualText, expectedHeader,"Actual and expected header did not match!!");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}

