package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseNewLook {
	
	public static WebDriver driver;
	public static Properties prop;
	 static  {
			try {
				FileInputStream file=new FileInputStream("PropertyFiles/NewLookData.properties");
			    prop=new Properties();
				prop.load(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
		}
	 public void setup() {
		String Browsername=prop.getProperty("Browser");
		if(Browsername.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incogneto");
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);
		}else if(Browsername.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions option=new EdgeOptions();
	    	 option.addArguments("--remote-allow-origins=*");
	 		option.addArguments("--incognito");
	 		driver=new EdgeDriver(option);
	     }else if(Browsername.equals("firefox")) {
	    	 WebDriverManager.firefoxdriver().setup();
	    	 FirefoxOptions option=new FirefoxOptions();
	    	 option.addArguments("--remote-allow-origins=*");
	 		option.addArguments("--incognito");
	 		driver=new FirefoxDriver(option);
	 		}else if(Browsername.equals("IE")) {
	 	    	 WebDriverManager.iedriver().setup();
	 	    	// InternetExplorerOptions option=new InternetExplorerOptions() ;
	 	 		//option.addCommandSwitches("--incognito");
	 	 		driver=new InternetExplorerDriver();
	 		}
			driver.get(prop.getProperty("Url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			
		}
	 public void selectDroopDown(WebElement ele, String value) {
		 Select se=new Select(ele);
		 se.selectByValue(value);
	 }
	 public void getScreenShot1() {
			TakesScreenshot srcshot=(TakesScreenshot)driver;
			File srcfile=srcshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcfile, new File("Screenshot/" + System.currentTimeMillis() + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 public void GetFailedStepScreenshot(Scenario s) {
		 if(s.isFailed()) {
		getScreenShot1();	 
		 }
		 driver.quit();
	 }

	 }


