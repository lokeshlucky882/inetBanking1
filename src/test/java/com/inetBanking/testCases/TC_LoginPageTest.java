package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginPageTest extends Base
{
	@Test
	public void doLogin()
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		logg.info("Entered user name");
		lp.setPassword(password);
		logg.info("Entered password");
		lp.clickOnLoginBtn();
		logg.info("Clicked on Login button");
		String exp = "Guru99 Bank Manager HomePage";
		String act = driver.getTitle();
		if(act.equals(exp))
		{
			Assert.assertTrue(true);
		}
		else
		{
			try 
			{
				captureScreen(driver, "doLogin");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			Assert.assertTrue(false);
		}

	}
	
	
	
	
}
