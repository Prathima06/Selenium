package com.qa.demoshop.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.helpers.Reporter;

public class Base {
	public static WebDriver driver;
	public static Properties prop = null;
	
	public Base() {
		FileInputStream fis = null;
		
		try {
			prop = new Properties();
			fis = new FileInputStream("E:\\Users\\bhara\\Prathima\\DemoShop\\src\\main\\java\\com\\qa\\demoshop\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void intialization() {
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();	
		}
//		else if(browserName.equals("firfox")) {
//			driver = new FirefoxDriver();
//		}
//	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
		
	}

}
