package com.adidas.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adidas.base.TestBase;
import com.adidas.pages.HomePage;
import com.adidas.pages.LandingPage;
import com.adidas.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.navigateToLoginScreen();
	}

	@Test
	public void loginTest() throws InterruptedException, IOException {

		homePage = loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));

		System.out.println("Entered username and password and click on login button");

		Assert.assertTrue(homePage.validateHomePage(), " Unable to log in ");
		System.out.println("Successfully logged in: ");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
