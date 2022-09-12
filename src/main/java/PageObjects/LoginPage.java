package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id=("user_email"))private WebElement email;
	@FindBy(id=("user_password"))private WebElement password;
	@FindBy(xpath=("//input[@name=\"commit\"]"))private WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement mailid()
	{
		return email;
	}

	public WebElement pwd()
	{
		return password;
	}
	public WebElement login()
	{
		return login;
	}
}
