package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class MultiRowsReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// Testdata Folder: excel file name : MultiRows 
		

		FileInputStream fis=new FileInputStream("./TestData/MultiRows.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		System.out.println(rowcount);
		
		for(int row=1;row<=rowcount; row++)
		{
			String productCategory = sh.getRow(row).getCell(0).getStringCellValue();
			String productName = sh.getRow(row).getCell(1).getStringCellValue();
			
			System.out.println(productCategory +" :"+productName);
		}

	}

}
