package com.adidas.tests;

import java.io.UnsupportedEncodingException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adidas.base.TestBase;
import com.adidas.pages.CartPage;
import com.adidas.pages.LandingPage;
import com.adidas.pages.LoginPage;


public class LandingPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	CartPage cartPage;
	
	public LandingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
	}
	
	@Test
	public void landingPageTitleTest() throws UnsupportedEncodingException {
		
		String expectedTitle = "adidas virallinen verkkosivusto | adidas Suomi";
		String s = landingPage.getLandingPageTitle();
	//	String actualTitle = s.replaceAll("u00a0", " ");
	// removed html "&nbsp;" to compare with java string
		 StringBuffer b = new StringBuffer();
		 char[] chArray = s.toCharArray();
		 int length = chArray.length;
		 System.out.println("Length: " + length);
		 for ( int i = 0 ; i < length ; i++ ){
			 if(chArray[i] == '\u00a0' ){
				 b.append(' '); 
				 }else {
		   b.append(chArray[i]);
			 }
		 }
		 String actualTitle = b.toString();
		 Assert.assertEquals(actualTitle, expectedTitle,"Actual and expected title did not match !!");
	}
	
	@Test
	public void adidasLogoTest() {
		boolean flag = landingPage.validateLandingPageLogoVisibility();
		Assert.assertTrue(flag,"Logo is not Displayed");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
