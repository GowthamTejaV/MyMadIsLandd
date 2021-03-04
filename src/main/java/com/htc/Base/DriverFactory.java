package com.htc.Base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.htc.prop.Property;

public class DriverFactory {
	protected Properties prop;
	
	
	public DriverFactory() {
		Property pro = new Property();
		 prop=pro.getProp();
	}
	
	
	public WebDriver driver() {
		
		WebDriver driver=null;
		String browserName=prop.getProperty("browser");
		
		switch(browserName) {
		case "chrome":
		System.setProperty(prop.getProperty("dri"), prop.getProperty("path"));
		driver= new ChromeDriver();
		break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;
		
		
	}
	

}