package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="uid")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	public void setUserName(String uname)
	{
		userName.clear();
		userName.sendKeys(uname);
	}
	
	public void setPassword(String password)
	{
		passWord.clear();
		passWord.sendKeys(password);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}

}
