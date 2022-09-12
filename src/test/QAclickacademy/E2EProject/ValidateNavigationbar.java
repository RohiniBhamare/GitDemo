package QAclickacademy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.base;

public class ValidateNavigationbar extends base {
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void startBrowser() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void validatenavbar() throws IOException, InterruptedException
	{
		
	//	driver=InitializeDriver();
		//driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		//Thread.sleep(2000);
		l.switchtop(driver);
		l.clickonpopup();
		Thread.sleep(5000);
		Assert.assertTrue(l.checknavbar().isDisplayed());
	}
	
	@AfterTest
	public void shutdriver()
	{
		driver.close();
	}

}
