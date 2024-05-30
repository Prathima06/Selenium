package com.qa.demoshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.demoshop.base.Base;
import com.qa.demoshop.pages.HomePage;
import com.qa.demoshop.pages.LoginPage;

public class HomePageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;

	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {

		intialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
//		loginPage= homePage.clickOnLoginLink();
//		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyLogo() {
		boolean logo = homePage.verifyHomePageLogo();
		Assert.assertTrue(logo, "Home page logo is not displayed");
	}
	
	@Test(priority = 2)
	public void verifyTitle() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Demo Web Shop","Home page title is not matched");
		
	}
}
