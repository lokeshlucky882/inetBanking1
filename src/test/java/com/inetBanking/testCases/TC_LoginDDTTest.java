package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilitis.XLUtility;

public class TC_LoginDDTTest extends Base
{
	
	@Test(dataProvider="getData")
	public void loginTestDDT(String uname, String pass)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		lp.setPassword(pass);
		lp.clickOnLoginBtn();
		
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	}
	
	@DataProvider
	public String[][] getData() throws Exception
	{
		String path = ".\\src\\test\\java\\com\\inetBanking\\testData\\LoginData.xlsx";
		int rowCount = XLUtility.getRowCount(path, "Sheet1");
		int colmnCount = XLUtility.getCellCount(path, "Sheet1", 1);
		String loginData[][] = new String[rowCount][colmnCount];
		for(int r=1 ; r<=rowCount ; r++)
		{
			for(int c=0 ; c<colmnCount ; c++)
			{
				loginData[r-1][c] = XLUtility.getCellData(path, "Sheet1", r, c);
			}
		}
		return loginData;
	}

}
