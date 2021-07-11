package com.inetBanking.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.inetBanking.utilitis.ReadConfig;

import net.bytebuddy.utility.RandomString;

public class Base 
{
	public WebDriver driver;
	public Logger logg;
	public ReadConfig config = new ReadConfig();
	public String baseURL = config.getPageUrl();
	public String userName = config.getUserName();
	public String password = config.getPassword();
	public String chromepath = config.chromePath();
	public String firefoxpath = config.firefoxPath();
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser)
	{
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = new ChromeDriver();
		}
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", firefoxpath);
			driver = new FirefoxDriver();
		}
	
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		logg = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j2.properties");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws Exception 
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "//Screenshots//" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString()
	{
		String random = RandomString.make(10);
		return random;
	}

}
