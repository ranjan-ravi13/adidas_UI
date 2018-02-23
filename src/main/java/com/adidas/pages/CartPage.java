package com.adidas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adidas.base.TestBase;

public class CartPage extends TestBase {

	@FindBy(xpath = "//h1[@class='checkout-title']")
	WebElement CartHeaderText; //Your Bag is Empty
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getCartPageHeader() {
		return CartHeaderText.getText();
	}
}
