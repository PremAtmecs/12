import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\premkumar.sarathi\\Desktop\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		
		driver.manage().window().maximize();
		FileInputStream file=null;
		try {
			 file=new FileInputStream("C:\\Users\\premkumar.sarathi\\Desktop\\Book1.xlsx");
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
		WebElement firstname=driver.findElement(By.id("firstName"));
		WebElement lastname=driver.findElement(By.id("lastName"));
		WebElement email=driver.findElement(By.id("userEmail"));
		WebElement gender=driver.findElement(By.id("gender-radio-1")); 	
		WebElement mobile=driver.findElement(By.id("userNumber"));
		WebElement address=driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
		WebElement subject=driver.findElement(By.id("subjectsInput"));
		WebElement hobbies=driver.findElement(By.id("hobbies-checkbox-1"));
		WebElement image=driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		image.sendKeys("C:\\Users\\premkumar.sarathi\\Desktop\\sag.jpg");
		 for(int i=1;i<=rowCount;i++) {
			 firstname.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			 lastname.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			 email.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
			 mobile.sendKeys(" " + sheet.getRow(i).getCell(4).getStringCellValue());
			 address.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			 JavascriptExecutor js = (JavascriptExecutor) driver;
	            js.executeScript("arguments[0].click();",gender);
	            js.executeScript("arguments[0].click();",hobbies);
	         subject.sendKeys(sheet.getRow(i).getCell(5).getStringCellValue());
	         Robot rbt=null;
	         try {
				 rbt=new Robot();
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	         rbt.keyPress(KeyEvent.VK_DOWN);
	 		rbt.keyRelease(KeyEvent.VK_DOWN);
	 		rbt.keyPress(KeyEvent.VK_ENTER);
	 		rbt.keyRelease(KeyEvent.VK_ENTER);
		 }
		 
		
		
		

	}

}
