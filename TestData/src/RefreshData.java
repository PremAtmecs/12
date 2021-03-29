import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\premkumar.sarathi\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\premkumar.sarathi\\Desktop\\book2.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wbk=null;
		try {
			 wbk=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet=wbk.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		 for(int i=1;i<=rowCount;i++) {
			 	WebElement firstname=driver.findElement(By.id("userName"));
				WebElement email=driver.findElement(By.id("userEmail"));
				WebElement address=driver.findElement(By.id("currentAddress"));
				WebElement permanent=driver.findElement(By.id("permanentAddress"));
				
				
				firstname.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
				email.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
				address.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
				permanent.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.id("submit")).click();
				 driver.navigate().refresh();

				
			 
		 }
		driver.quit();
	}

}
