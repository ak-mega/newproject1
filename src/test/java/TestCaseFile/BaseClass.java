package TestCaseFile;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadConfigClass;



public class BaseClass {
	public static Logger L1;
	public static WebDriver driver;
	ReadConfigClass rc=new ReadConfigClass();    //read class ke function ko use krna he
	String url=rc.getalok();
	String browser=rc.getsaurabh();
	@BeforeClass
	public void browserlaunch() //function
	{
		switch(browser.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "msedge":
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "internetexplorer":
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
			default:
				driver=null;
				break;
				
		}
		L1=LogManager.getLogger("rep");    //initialize l1 and methods
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public void ScreenShot() throws IOException 
	{

		File Source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:\\Users\\my\\eclipse-workspace\\datadrivenproject\\ScreenShot\\Report.png");
		FileUtils.copyFile(Source, Destination);
	}
	
	@AfterClass
	public void ClosedCode() //function
	{
		driver.close();
		driver.quit();
	}
	
	
	
}