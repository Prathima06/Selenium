package com.qa.demoshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoshop.base.Base;

public class LoginPage extends Base{
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@value=\"Log in\"]")
	WebElement loginBtn;
	
	@FindBy(linkText = "Forgot password?")
	WebElement fPwd;
	
	@FindBy(xpath = "//input[@data-val-email=\"Wrong email\" and @id=\"Email\"]")
	WebElement recoveryEmail;
	
	@FindBy(xpath = "//input[@value=\"Recover\"]")
	WebElement recoverBtn;
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickOnLoginLink() {
		loginLink.click();
		return new HomePage();
	}
	
	public void login(String userName,String Password) {
		email.sendKeys(userName);
		pwd.sendKeys(Password);
		loginBtn.click();
//		return new HomePage();
	}
	
	

}
