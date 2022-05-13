package assignment;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.FacebookHome;
import pageObjects.FacebookLogin;
import resources.Base;

public class FacebookTest extends Base{

	
	public WebDriver driver;
	Properties prop;
	public static Logger log=org.apache.logging.log4j.LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void setUp() throws IOException
	{
		driver=initializeDriver();
		driver.get("https://www.facebook.com/");
		log.info("facebook URL loaded");
	}
	@Test
	public void faceBookTest() throws InterruptedException, IOException
	{
		String email=getProperty("fbemail");
		String password=getProperty("fbpass");
		String fbStatus=getProperty("fbstatus");
		FacebookLogin fl=new FacebookLogin(driver);
		fl.getEmailId().sendKeys(email);
		fl.getPassword().sendKeys(password);
		fl.getLoginButton().click();
		
		log.info("User successfully logged in facebook");
		
		FacebookHome fh=new FacebookHome(driver);
		WebElement statusBox=fh.getStatusBox();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.visibilityOf(statusBox));
	
		statusBox.click();
		log.debug("Clicked on send post ");
		
		fh.getPostDialogBox().sendKeys(fbStatus);
		fh.getPostButton().click();
		
		log.info("Status posted successfully");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
