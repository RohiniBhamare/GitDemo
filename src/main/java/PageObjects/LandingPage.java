package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	@FindBy(css="a[href*='sign_in']")private WebElement login;
	@FindBy(xpath="//button[text()=\"NO THANKS\"]")private WebElement nothanks;
	@FindBy(xpath="//div[@class=\"listbuilder-popup-scale\"]")private WebElement popup;
	@FindBy(xpath="//div[@class=\"text-center\"]/h2")private WebElement Title;
	@FindBy(xpath="//ul[@class=\"nav navbar-nav navbar-right\"]")private WebElement navbar;
	
public LandingPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


public WebElement signin()
{
	return login;
}
public void switchtop(WebDriver driver)
{
	Actions act=new Actions(driver);
			act.moveToElement(popup);
}
public void clickonpopup()
{
	 nothanks.click();
}

public WebElement getTitle()
{
	return Title;
}

public WebElement checknavbar()
{
	return navbar;
}
}
