package pageObjectModelFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWebElement {
	WebDriver Currentdriver;          //object of webdriver
	public LoginWebElement(WebDriver RemoteDriver) //constructor
	{
		Currentdriver=RemoteDriver;
	PageFactory.initElements(RemoteDriver, this);	//class and method and 2 agument
	}
	@FindBy(id="username") WebElement Uname;   //find and store kr liya
	@FindBy(id="password") WebElement Pname;
	@FindBy(id="submit") WebElement Submit;
	public void user_name(String user)             //function creat &yha value ayegi
	{
		Uname.sendKeys(user);
	}
	public void user_pass(String pass)
	{
		Pname.sendKeys(pass);
	}
	public void user_sub()
	{
		Submit.click();
	}

}
