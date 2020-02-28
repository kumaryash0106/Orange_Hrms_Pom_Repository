package com.hrms.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.qa.base.Base;

public class AddEmp extends Base {

	@FindBy(xpath="//input[@id='txtEmpLastName']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@name='txtEmpFirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='btnEdit']")
	WebElement Submit;
	
	public AddEmp() {
		PageFactory.initElements(driver, this);
	}
	
	public void AddNewEmp(String ftname, String sname) throws InterruptedException  {
		
		/*driver.findElement(By.xpath("//input[@value='Add']")).click();
		//Thread.sleep(5000L);
		
		
		String empid=driver.findElement(By.xpath("//input[@id='txtEmployeeId']")).getAttribute("value");
		System.out.println(empid);
		driver.findElement(By.xpath("//input[@id='txtEmpLastName']")).sendKeys(fn);
		Thread.sleep(2000L);
		driver.findElement(By.xpath("//*[@name='txtEmpFirstName']")).sendKeys(sn);
		//driver.findElement(By.xpath("//input[@id='txtEmpFirstName'")).sendKeys("Singh");
		driver.findElement(By.xpath("//input[@id='btnEdit']")).click();
		Thread.sleep(5000L);
		System.out.println("New employee Added");
		//driver.switchTo().defaultContent();
		//driver.findElement(By.xpath("//*[@id='option-menu']/li[3]/a")).click();
		
		*/
		
		
		Thread.sleep(2000);
		String empid=driver.findElement(By.xpath("//input[@id='txtEmployeeId']")).getAttribute("value");
		System.out.println(empid);
		firstname.sendKeys(ftname);
		lastname.sendKeys(sname);
		Submit.click();
	}
	
	
	
}
