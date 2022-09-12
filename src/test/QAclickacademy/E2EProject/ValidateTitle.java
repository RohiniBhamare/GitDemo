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

public class ValidateTitle extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void startBrowser() throws IOException
	{
		driver=InitializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basepagevalidation() throws IOException
	{
		//driver=InitializeDriver();
		//driver.get("http://www.qaclickacademy.com/");
		LandingPage l=new LandingPage(driver);
		String actual=l.getTitle().getText();
		String expected="FEATURED COURSES";
		log.info("text verified");
		//Assert.assertEquals(actual, expected);
		
		Assert.assertTrue(actual.equalsIgnoreCase(expected));
	
}
	
	@AfterTest
	public void shutdriver()
	{
		driver.close();
	}

}