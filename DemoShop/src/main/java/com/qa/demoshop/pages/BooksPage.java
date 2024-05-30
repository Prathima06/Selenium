package com.qa.demoshop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.demoshop.base.Base;

public class BooksPage extends Base{
	
	@FindBy(partialLinkText = "Books")
	WebElement books;
	
	@FindBy(id="products-orderby")
	WebElement sortByDropDown;
	
	public BooksPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnBooksLink() {
		books.click();
	}
	
	public void clickOnSortDropDown() {
		
	}
}
