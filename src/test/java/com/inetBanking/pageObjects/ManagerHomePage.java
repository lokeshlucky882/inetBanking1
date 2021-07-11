package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage 
{
	WebDriver driver;
	
	public ManagerHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul[@class='menusubnav']//li[2]/a")
	WebElement newCustomer;
	
	
	public void clickOnNewCustomer()
	{
		newCustomer.click();
	}

}
