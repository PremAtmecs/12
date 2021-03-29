import demo.ChromeDriver;
import demo.WebDriver;

public class Web {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\premkumar.sarathi\\Desktop\\chromedriver_win32.exe");
         WebDriver driver=new ChromeDriver();
         driver.get("www.google.com");
	}

}
