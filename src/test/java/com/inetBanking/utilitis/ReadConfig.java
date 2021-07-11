package com.inetBanking.utilitis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig 
{
	Properties prop;
	public ReadConfig()
	{
		try {
			String path = ".\\Congurations\\config.properties";
			FileInputStream fis = new FileInputStream(path);
			prop = new Properties();
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			System.out.println("Unable to load config.properties file. Error is : "+e.getMessage());
		}
	}
	
	public String getPageUrl()
	{
		String url = prop.getProperty("baseUrl");
		return url;
	}
	public String getUserName()
	{
		String uName = prop.getProperty("username");
		return uName;
	}
	public String getPassword()
	{
		String pass = prop.getProperty("password");
		return pass;
	}
	public String chromePath()
	{
		String chromepath = prop.getProperty("chromePath");
		return chromepath;
	}
	public String firefoxPath()
	{
		String firefoxpath = prop.getProperty("firefoxPath");
		return firefoxpath; 
	}
	

}
