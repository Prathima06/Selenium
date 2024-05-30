package com.qa.demoshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.demoshop.base.Base;

public class HomePage extends Base{
	
	@FindBy(xpath = "//input[@value=\"Log in\"]")
	WebElement loginBtn;
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	@FindBy(linkText = "Shopping cart")
	WebElement cart;
	
	@FindBy(linkText = "Wishlist")
	WebElement wishList;
	
	@FindBy(xpath = "//img[@alt=\"Tricentis Demo Web Shop\"]")
	WebElement logo;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHomePageLogo() {
		return logo.isDisplayed();
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public LoginPage clickOnLoginLink() {
		loginBtn.click();
		return new LoginPage();
	}
	
	
}
