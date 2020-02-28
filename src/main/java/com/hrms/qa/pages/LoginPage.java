package com.hrms.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.qa.base.Base;

public class LoginPage extends Base {
	
	//pagefactory 0r Object repository
	
	@FindBy(name="txtUserName")
    WebElement username;
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement submit;
	
	@FindBy(xpath="//body/table[@id='Table_01']/tbody/tr/td/img[1]")
	WebElement logo;
	
	
	//initilise the pageobject;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions:
	public String validateLoginpageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage Login(String un,String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
	}
	
}
