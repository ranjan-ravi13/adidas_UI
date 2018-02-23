package com.adidas.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adidas.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

/*	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		System.out.println("************  Taking screenshot *************");
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "\\Screenshots\\"+screenshotName+dateName+".png";
		System.out.println("output path : "+destination);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File finalDestination = new File(destination);
		FileUtils.copyFile(scrFile, finalDestination);
		return destination;
	}*/
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	// this methods implements wait for an element to be visible
		public static void waitForVisibilityOf(WebElement el, Integer... timeOutInSeconds) {
			int attempts = 0;
			//System.out.println("The element trying to find is : " + el.getText());
			while (attempts < 2) {
				try {
					waitFor(ExpectedConditions.visibilityOf(el),(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
					break;
				} catch (Exception e) {
					System.out.println("Element not found on screen ");
					}
				attempts++;
			}
			
		}
		public static void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
			timeOutInSeconds = timeOutInSeconds!= null ? timeOutInSeconds : 20;
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(condition);
		}
}
