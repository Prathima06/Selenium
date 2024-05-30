package com.qa.demoshop.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demoshop.base.Base;
import com.qa.demoshop.pages.HomePage;
import com.qa.demoshop.pages.LoginPage;

public class LoginPageTest extends Base{
	
	LoginPage loginPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		loginPage = new LoginPage();
	}
	
	
	@Test(priority = 1)
	public void loginToTheDemoShop()  {
		loginPage.clickOnLoginLink();
	loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		
		
	}

}
