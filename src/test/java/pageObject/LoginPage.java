package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="Username")
	WebElement Username;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[text()=\"Log out\"]")
	WebElement LogoutButton;
	
	@FindBy(xpath="//span[@class=\"ico-user sprite-image\"]")
	WebElement userwrapper;
	
	public void setUsername(String username)
	{
		Username.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public void login()
	{
		LoginButton.click();
	}
	
	public void logout()
	{
		LogoutButton.click();
	}
	
	public LoginPage(WebDriver webdriver)
	{
		driver=webdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void hoverover()
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(userwrapper).build().perform();
		}

}
