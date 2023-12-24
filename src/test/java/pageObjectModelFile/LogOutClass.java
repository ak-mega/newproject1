package pageObjectModelFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutClass {
	
		WebDriver Currentdriver;          //object of webdriver
		public LogOutClass(WebDriver RemoteDriver) //constructor
		{
			Currentdriver=RemoteDriver;
		PageFactory.initElements(RemoteDriver, this);	//class and method and 2 agument
		}
		@FindBy(xpath="//a[text()='Log out']") WebElement Logout;   //find and store kr liya
	
		
		public void user_logout()  //function
		{
			Logout.click();
		}

	}

