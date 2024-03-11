package testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Config;

public class BaseClass {
	
	Config read=new Config();//this will invoke the constructor and automatically load the file
	
	public String url=read.getApplication();//called the methods from readconfig file
	public String username=read.getusername();
	public String password=read.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	

	public static ExtentReports extent;
	public static ExtentTest test;
	
	
	@BeforeClass
	@Parameters("browser")//the parameter passed in xml file
	public void setup(String browser) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReportResults.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
		
		PropertyConfigurator.configure("/resources/log4j.properties");
       // PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("src/maim/resources/log4j.properties"));
        
        if(browser.equals("chrome")) {
        	WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
        	WebDriverManager.firefoxdriver().setup();
    		driver=new FirefoxDriver();
    		
        }
        
        }
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
	
}
