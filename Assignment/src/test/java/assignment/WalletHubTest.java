package assignment;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.WalletCompany;
import pageObjects.WalletHubProfile;
import resources.Base;

public class WalletHubTest extends Base {

	public WebDriver driver;
	public static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());
		@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
	
		driver.get(getProperty("walleturl"));
		log.info("Wallet hub url loaded");
	}
	
	@Test
	public void WalletTest() throws IOException, InterruptedException
	{
		
		WalletHubProfile profile=new WalletHubProfile(driver);
		profile.getReviews().click();
		log.info("Clicked on reviews");
		WebElement star=profile.getReviewstar();
		Actions a=new Actions(driver);
		a.moveToElement(star).pause(Duration.ofSeconds(3)).click(star).build().perform();
	
		org.testng.Assert.assertEquals(profile.getReviewstar().getAttribute("aria-checked"),"true");
		
		
		WalletCompany comp=new WalletCompany(driver);
		
		comp.getDropdwon().click();
		
List<WebElement>	li=	comp.getDropdownList();
for(WebElement l:li)
{
	if(l.getText().contains("Health Insurance"))
	{	l.click();
	break;}
}

Thread.sleep(2000);
comp.getReview().sendKeys(getProperty("walletkeys"));

WebElement count=comp.getCount();

if(Integer.parseInt(count.getText())==200)
comp.getbuttonSub().click();
log.debug("form submitted successfully");
//unable to go to reviews page getting invalid address error

	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
