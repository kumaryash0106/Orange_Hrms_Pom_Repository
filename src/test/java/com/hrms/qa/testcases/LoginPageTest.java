package com.hrms.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.qa.base.Base;
import com.hrms.qa.pages.HomePage;
import com.hrms.qa.pages.LoginPage;

public class LoginPageTest extends Base {
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		
		loginPage= new LoginPage();
	}

	@Test(priority=1)
	public void LoginPageTitleTest() {
		String title=loginPage.validateLoginpageTitle();
		Assert.assertEquals(title,"OrangeHRM - New Level of HR Management");
	}
	
	@Test(priority=2)
	public void logoimagetest() {
		boolean flag= loginPage.ValidateLogo();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest() {
	homePage=loginPage.Login(prop.getProperty("un"), prop.getProperty("pwd"));
		
	}


	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
