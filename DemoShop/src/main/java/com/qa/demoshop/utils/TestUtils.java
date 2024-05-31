package com.qa.demoshop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.demoshop.base.Base;

public class TestUtils extends Base{
	
	LocalDateTime dt = LocalDateTime.now();
	String date = dt.toString().replace(":", "-");
	
	
	/*
	 * To read data from excel
	 */
	public String[][] getdata() {
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			fis = new FileInputStream("E:\\Users\\bhara\\Prathima\\FreeCRMTest\\src\\"
					+ "main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int noOfRows = wb.getSheet("Contacts").getPhysicalNumberOfRows();
		int noOfCol = wb.getSheet("COntacts").getRow(0).getPhysicalNumberOfCells();
		String[][] data = new String[noOfRows - 1][noOfCol];
		int k=0;
		for(int i=0;i< noOfRows;i++) {
			for(int j=0;j<noOfCol;j++) {
				data[k][j] = wb.getSheet("Sheet1").getRow(i).getCell(j).toString();
			}
			k++;
			
		}
		return data;
	}
	
	/*
	 * Drop Down
	 */
	public  WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public  void doSelectByValue(By locator,String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByValue(value);
		
	}
	
	public  void doSelectByVisibleText(By locator,String value) {
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(value);
		
	}
	
	public  void doSelectByIndex(By locator,int index) {
		Select sel= new Select(getElement(locator));
		sel.selectByIndex(index);
		
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
		element.click();
	}
	
	//taking screenshot for failed test case
	public void failed(String testMethod) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyDirectory(src, new File("C:\\Users\\Bharath\\git\\repository\\DemoShop\\"
					+ "Screenshot\\"+date+"_"+testMethod+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
