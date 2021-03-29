import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApachePOI {

	public static void main(String[] args)  throws IOException {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\premkumar.sarathi\\Desktop\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver=new ChromeDriver();
//		driver.get("https://demoqa.com/browser-windows");
//		driver.manage().window().maximize();
//		driver.get("https://demoqa.com/automation-practice-form");
		File file =    new File("C:\\Users\\premkumar.sarathi\\Desktop\\Book1.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		for(int i=0;i<=rowCount+1;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++) {
				Cell cell=row.getCell(j);
				
				switch (cell.getCellType()) {
				case STRING:
					System.out.println(row.getCell(j).getStringCellValue() + " ");
					break;
				case NUMERIC:
					System.out.println(row.getCell(j).getNumericCellValue() + " ");
					break;
				
				}
			}
			System.out.println();


			
		}
		System.out.println();

	}

}
