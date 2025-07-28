package ExcelFileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	//Getting data from single Row
	public String getDataFromExcel(String SheetName, int rowNum, int cellNum ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv.xlsx");  // //data from single row 
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	//Getting data from Multiple Rows 
	public int togetRowCount(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./TestData/MultiRows.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount =wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return rowcount;
		
	}
}
