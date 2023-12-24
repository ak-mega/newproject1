package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTesting {
	public static XSSFWorkbook WB;   //class and object
	public static XSSFSheet WS;       //class and object
	public static XSSFRow RW;
	public static XSSFCell CL;
	public static FileInputStream fn;   //globally
	
	//function to get data
	public static String getcellvalue(String filename,String sheetname, int row, int coll) throws 
IOException
	{
		fn=new FileInputStream(filename);  //file read ke lie
		WB=new XSSFWorkbook(fn);   //wb initialize and argument
		WS=WB.getSheet(sheetname);   //ws ke pass sheet rkhi he
		CL=WB.getSheet(sheetname).getRow(row).getCell(coll);   //student,password  and cl string so return
		WB.close();
		return CL.getStringCellValue();  //cl ko retun ke lie method
				
		
		
	}
	//function for count raw
	public static int getRowCount(String filename, String sheetname) throws Exception
	{
		fn=new FileInputStream(filename);  //file read ke lie
		WB=new XSSFWorkbook(fn);   //wb initialize and argument
		WS=WB.getSheet(sheetname);
		int toRow=WS.getLastRowNum()+1;
		WB.close();
		return toRow;
	}
	//function for count coll
	public static int getCellCount(String filename, String sheetname) throws Exception
	{
		fn=new FileInputStream(filename);  //file read ke lie
		WB=new XSSFWorkbook(fn);   //wb initialize and argument
		WS=WB.getSheet(sheetname);
		int toCell=WS.getRow(0).getLastCellNum();
		WB.close();
		return toCell;
	}

}
