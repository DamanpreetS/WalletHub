package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WalletCompany {
	public WebDriver driver;
	
	public  WalletCompany(WebDriver driver) {
		this.driver=driver;
	}
	By dropdwon=By.xpath("//ng-dropdown[@class=\"wrev-drp\"]");
	By dropdownList=By.xpath("//ng-dropdown[@class=\"wrev-drp\"]/div/ul/li");
	By review=By.xpath("//textarea[@placeholder=\"Write your review...\"]");
	By count=By.cssSelector(".wrev-user-input-count span");
	By buttonSub=By.xpath("//div[@role=\"button\" and text()=\" Submit \"]");
	
	public WebElement getDropdwon() {
		return driver.findElement(dropdwon);
	}
	public List<WebElement> getDropdownList() {
		return driver.findElements(dropdownList);
	}
	public WebElement getReview() {
		return driver.findElement(review);
	}
	public WebElement  getCount() {
		return driver.findElement(count);
	}
	public WebElement  getbuttonSub() {
		return driver.findElement(buttonSub);
	}
}

