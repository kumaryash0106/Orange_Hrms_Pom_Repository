package com.hrms.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hrms.qa.base.Base;
import com.hrms.qa.pages.AddEmp;
import com.hrms.qa.pages.HomePage;
import com.hrms.qa.pages.LoginPage;
import com.hrms.qa.util.Testutil;

public class AddEmpTest extends Base {

	
	LoginPage loginPage;
	HomePage homePage;
	AddEmp Addemp;
	public AddEmpTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		Addemp=new AddEmp();
		loginPage= new LoginPage();
		homePage=loginPage.Login(prop.getProperty("un"), prop.getProperty("pwd"));
		Addemp=homePage.ClickonAddEmp();
		
		
	}
	
	@DataProvider
	public Object[][] AddEmpTestData() {
		Object data[][]=Testutil.getTestData("sheet1");
		return data;
		
	}
	
	
	
	@Test(dataProvider="AddEmpTestData")
	public void AddnewEmp(String FirstName, String SecondName) throws InterruptedException {
			Thread.sleep(5000);
		Addemp.AddNewEmp(FirstName, SecondName);
	
	}


	@AfterMethod                      //Test cases to be independenent with each other                        
	public void tearDown() {          //before each test case---launch the browser and login 
		driver.quit();                 //after each test case---- close the browser
	}
	
	
	
}
