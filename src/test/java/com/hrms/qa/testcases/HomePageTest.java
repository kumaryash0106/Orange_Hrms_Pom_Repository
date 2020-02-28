package com.hrms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.qa.base.Base;
import com.hrms.qa.pages.HomePage;
import com.hrms.qa.pages.LoginPage;

public class HomePageTest extends Base  {

	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		
		loginPage= new LoginPage();
		homePage=loginPage.Login(prop.getProperty("un"), prop.getProperty("pwd"));
	}

	

	@Test(priority=1)
	public void HomePageTitleTest() {
		String hometitle=homePage.VerifyHomePageTitle();
		Assert.assertEquals(hometitle,"OrangeHRM","HomepageTitle not match");
	}
	
	@Test(priority=2)
	public void VerifyWelcomeNote() {
		Assert.assertTrue(homePage.correctUsername());
	}
	
	@Test (priority=3)
	public void VerifyReportlink() {
		homePage.Clickonreport();
	}
	
	
	
	
	@AfterMethod                      //Test cases to be independenent with each other                        
	public void tearDown() {          //before each test case---launch the browser and login 
		driver.quit();                 //after each test case---- close the browser
	}
	
}
