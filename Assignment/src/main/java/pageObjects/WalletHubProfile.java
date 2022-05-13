package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import resources.Base;

public class WalletHubProfile extends Base{
	public WebDriver driver;
	public WalletHubProfile(WebDriver driver)
	{
		this.driver=driver;
	}

	By reviews=By.xpath("//a[contains(@href,\"eviews\")]/span[@class=\"nav-txt\"]");
	By reviewstar=By.xpath("(//review-star[@class=\"rvs-svg\"] //*[name()=\"svg\" and @class=\"rvs-star-svg\"])[4]");
	public WebElement getReviews() {
		return driver.findElement(reviews);
	}
	public WebElement getReviewstar() {
		return driver.findElement(reviewstar);
	}
	
}
