package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookHome {
	WebDriver driver;
	
	
	public FacebookHome(WebDriver driver2) {
		this.driver=driver2;
	}
	By statusBox=By.xpath("//span[contains(text(),\"What's on your mind\")]");
	By postDialogBox=By.xpath("//div[contains(@aria-label,\"What's on your mind\")]");
	By postButton=By.xpath("//span[text()=\"Post\"]");
	
	public WebElement getStatusBox() {
		return driver.findElement(statusBox);
	}
	public WebElement getPostDialogBox() {
		return driver.findElement(postDialogBox);
	}
	public WebElement getPostButton() {
		return driver.findElement(postButton);
	}
}
