package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.DataDrivenTesting;
import pageObjectModelFile.LogOutClass;
import pageObjectModelFile.LoginWebElement;

public class TestCase extends BaseClass { // function use ke liye extend kia
	@Test(dataProvider =   "Datapro")
	public void openurl(String user, String pass) 
	
	{
		
//		browserlaunch();
		driver.get(url);
		L1.info("url open");
		LoginWebElement cs = new LoginWebElement(driver); //obj bnaya
		cs.user_name(user);     //mthods ko callkia
		L1.info("enter the username");
		cs.user_pass(pass);
		L1.info("enter the password");
		cs.user_sub();
		L1.info("click submit button");

	}
	@DataProvider(name="Datapro")
	public String [][] searchData() throws Throwable    //2 d array function bnaya excel sheet se data ayega data provider ke pass
	{
		String filename="C:\\Users\\my\\Desktop\\newproject.xlsx";
		int r=DataDrivenTesting.getRowCount(filename, "Sheet1");
		int c=DataDrivenTesting.getCellCount(filename, "Sheet1");
		String s1 [][] =new String[r-1][c];    //2,2
		for(int i=1;i<r; i++)
		{
			for(int j=0;j<c;j++)
			{
				s1[i-1][j]= DataDrivenTesting.getcellvalue(filename,"Sheet1", i,j );   //method call kia
			}
		}
		return s1;
	}
	@Test
	void Logoutpage()    //function bnaya log out 
	{
		LogOutClass lg=new LogOutClass(driver);   //object banya
		lg.user_logout();
	}
}
