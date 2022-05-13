package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base {

	
	public WebDriver driver;
	public Properties prop;
	public static void main(String[] args) throws IOException
	{
		Base b=new Base();
		b.initializeDriver();
		
	}
	public WebDriver initializeDriver() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", getProperty("browserpath"));
		ChromeOptions options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
		
	}
	public String getProperty(String check) throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String found=prop.getProperty(check);
		return found;
		
	}
	public String getScreenshot(WebDriver driver, String methodName) throws IOException
	{
	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		org.apache.commons.io.FileUtils.copyFile(src, new File(path));
		return path;
	}
}
