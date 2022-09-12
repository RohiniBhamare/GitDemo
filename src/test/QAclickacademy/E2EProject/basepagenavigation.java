package QAclickacademy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;

public class basepagenavigation extends base{
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void startBrowser() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver is Initialized");
		//driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void homepage(String username,String password) throws IOException, InterruptedException
	{
		
	
	//=InitializeDriver();
	driver.get("http://www.qaclickacademy.com/");
	log.info("Navigated to homepage");
	//Thread.sleep(2000);
	LandingPage obj=new LandingPage(driver);
	obj.switchtop(driver);
	obj.clickonpopup();
	Thread.sleep(2000);
	obj.signin().click();
	
	LoginPage LP=new LoginPage(driver);
			LP.mailid().sendKeys(username);
	LP.pwd().sendKeys(password);
	LP.login().click();

	}
	@DataProvider
public Object[][] getData()
{
		Object[][] data=new Object[2][2];
		data[0][0]="user1";
		data[0][1]="pwd1";
		data[1][0]="user2";
		data[1][1]="pwd2";
		return data;
}
	@AfterTest
	public void closedriver()
	{
		driver.close();
	}
}
