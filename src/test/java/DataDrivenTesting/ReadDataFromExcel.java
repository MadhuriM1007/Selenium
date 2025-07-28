package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// need to use same path in excel utilty /
		
		FileInputStream fis= new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
		 Workbook wb= WorkbookFactory.create(fis);
		 Sheet sh =wb.getSheet("Campaign");
		 Row row=sh.getRow(1);
		 String Campname = row.getCell(2).getStringCellValue();
		 String size = row.getCell(3).getStringCellValue();
		
		
		
		
		
		
		
		
		
		
//		// Reading data from excel for Insta we are not cusing currenly as it was just for practice purpose
//		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Desktop\\Selenium_notes\\insta.xlsx");
//		 Workbook wb= WorkbookFactory.create(fis);
//		 Sheet sh =wb.getSheet("Sheet1");
//		 Row row=sh.getRow(1);
//		 String UN = row.getCell(0).getStringCellValue();
//		 String PW = row.getCell(1).getStringCellValue();
//		 
//		 WebDriver driver= new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		 driver.get("https://www.instagram.com/");
//		 driver.findElement(By.name("username")).sendKeys(UN);
//		 driver.findElement(By.name("password")).sendKeys(PW);
//		 driver.findElement(By.xpath("//button[text()='Show']")).click();
//		 
		 
		 
		
	}

}
