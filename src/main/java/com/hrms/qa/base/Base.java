package com.hrms.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.hrms.qa.util.Testutil;
import com.hrms.qa.util.WebEventListener;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener ;
	
	public Base() {
	
	try {
		prop =new Properties();
		FileInputStream ip=new FileInputStream ("D:\\Eclipse3\\OrangeHRMS\\src\\main\\java\\com\\hrms\\qa\\config\\config.properties");
	
	prop.load(ip);
	
	}catch(FileNotFoundException e) {
		e.printStackTrace();
	}catch(IOException e) {
		
	}
	
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\testing\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if (browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "D://testing//Selenium//geckodriver-v0.26.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		WebEventListener eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(Testutil.Page_load_timeout, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(Testutil.Implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
