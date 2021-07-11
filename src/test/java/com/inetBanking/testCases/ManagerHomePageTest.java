package com.inetBanking.testCases;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.ManagerHomePage;

public class ManagerHomePageTest extends Base
{
	@Test
	public void clickOnNewCustomer() throws Exception
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
		
	}

}
