import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\premkumar.sarathi\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		FileInputStream input=null;
		try {
			 input=new FileInputStream("C:\\Users\\premkumar.sarathi\\Desktop\\Book1.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wbk=null;
		try {
			 wbk=new XSSFWorkbook(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet=wbk.getSheetAt(0);
		XSSFRow row1=sheet.getRow(1);
		XSSFCell cell1=sheet.getRow(1).getCell(2);
	    
		String cell=cell1.getStringCellValue();
	    System.out.println(""+cell);
	    WebElement name=driver.findElement(By.xpath("//input[@id='firstName']"));
	    name.click();
	    name.sendKeys(cell);

	}

}
