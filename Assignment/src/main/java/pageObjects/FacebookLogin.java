package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class FacebookLogin {
	WebDriver driver;
	
	public FacebookLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By emailId=By.id("email");
	By password=By.id("pass");
	By loginButton=By.name("login");
	
	public WebElement getEmailId() {
		return driver.findElement(emailId);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}
	
	
}
