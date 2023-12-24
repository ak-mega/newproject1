package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigClass {

	Properties pro;
	String path = "C:\\Users\\my\\eclipse-workspace\\datadrivenproject\\ConfigurationFile\\Config.properties";

	public ReadConfigClass()

	{
		pro = new Properties();

		FileInputStream fn = null;

		try {
			fn = new FileInputStream(path);
		} catch (FileNotFoundException e) {

		}
		try {
			pro.load(fn);   //fn me load load ho  gya
		} catch (IOException e) {

			e.printStackTrace();
		}

	}  //function create for read data

	public String getalok()  //function create
	{
		String s1=pro.getProperty("monkey");    //site url ke pass jaega and data layega
		if(s1!=null)
		{
			return s1;
		}
		else
		{
			throw new RuntimeException("url not found");
		}

	}

	public String getsaurabh() {
		String s1 = pro.getProperty("bear");
		if (s1 != null) {
			return s1;
		} else {
			throw new RuntimeException("browser not found");
		}
	}
}
