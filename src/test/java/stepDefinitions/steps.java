package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.*;
import pageObject.LoginPage;

public class steps {
	
	public WebDriver driver;
	public LoginPage lp;
	
	@Given("user launch the {string} browser")
	public void user_launch_the_browser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/hcl/Documents/Testspace/LearnCucumber/drivers/chromedriver");
			driver= new ChromeDriver();
			lp = new LoginPage(driver);
			System.out.println("browser created");
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/hcl/Documents/Testspace/LearnCucumber/drivers/geckodriver");
			driver= new FirefoxDriver();
			lp = new LoginPage(driver);
		}
	    
	}

	@When("user Launch the URL {string}")
	public void user_launch_the_url(String url) throws InterruptedException {
	    driver.get(url);
	    driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		lp.setUsername(username);
		lp.setPassword(password);
	    
	}

	@When("user click on Login Button")
	public void user_click_on_login_button() {
	    lp.login();
	    System.out.println(driver.getTitle());
	}

	@Then("user click on Logout Button")
	public void user_click_on_logout_button() throws InterruptedException {
		lp.hoverover();
	    lp.logout();
	    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	}
	
	@Then("verify page tile")
	public void verify_page_tile() {
	    String title = driver.getTitle();
	    System.out.println(title);
	}
	
	@Then("close the browser")
	public void close_the_browser() {
	    driver.close();
	}

}
