package com.hrms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.qa.base.Base;

public class HomePage  extends Base {

	
	@FindBy(xpath="//li[contains(text(),'Welcome admin')]")
	WebElement welcomeLebel;
	
	@FindBy(xpath="//span[@class='drop'][contains(text(),'Leave')]")
	WebElement leave;
	
	
	@FindBy(xpath="//span[@class='current']")
	WebElement Time;
	
	@FindBy(xpath="//span[contains(text(),'Performance')]")
	WebElement performance;
	
	@FindBy(xpath="//span[@class='drop current']")
	WebElement report;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement Add;
	
	//initializing the page object
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public boolean correctUsername() {
		return welcomeLebel.isDisplayed();
	}
	
	
	public LeavePage clickonleave() {
		leave.click();
		return new LeavePage();

	}
	
	
	public ReportPage Clickonreport() {
		report.click();
		return new ReportPage();
		
	}
	public AddEmp ClickonAddEmp() {
		driver.switchTo().frame("rightMenu");
		Add.click();
		return new AddEmp();
	}
	
	
}
