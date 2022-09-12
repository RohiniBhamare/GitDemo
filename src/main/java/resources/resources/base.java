package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException
	{
		
	 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Rohini\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\ndata.properties");
		prop.load(fis);
		String Browsername=prop.getProperty("browser");
		if(Browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Rohini\\eclipse-workspace\\Seleniumfirstday\\chromedriver.exe");
	 driver =new ChromeDriver();
		}
		if(Browsername.equals("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
	          driver=new FirefoxDriver();
		}
		if(Browsername.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Selenium\\edgedriver_win64\\msedgedriver.exe");
	         driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public void getScreenshot(String testcasename,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String Destination=System.getProperty("User.dir")+"//Reports"+testcasename+".png";
		FileUtils.copyFile(source,new File(Destination));
	}
}
