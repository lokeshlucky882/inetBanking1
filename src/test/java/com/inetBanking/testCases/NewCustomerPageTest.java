package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.ManagerHomePage;
import com.inetBanking.pageObjects.NewCustomerPage;

public class NewCustomerPageTest extends Base
{
	@Test
	public void addNewCustomer() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logg.info("Entered user name");
		lp.setPassword(password);
		logg.info("Entered password");
		lp.clickOnLoginBtn();
		logg.info("Clicked on Login button");
		
		ManagerHomePage mhp = new ManagerHomePage(driver);
		mhp.clickOnNewCustomer();
		Thread.sleep(3000);
		
		NewCustomerPage addcust = new NewCustomerPage(driver);
		addcust.custName("LokeshLoki");
		addcust.custgender("male");
		addcust.custdob("10","15","1995");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987870091");
		addcust.custemailid(randomString()+"@gmail.com");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		boolean alertTextCheck = alertText.contains("Customer added successfully");
		Assert.assertTrue(alertTextCheck);
		
	}

}
