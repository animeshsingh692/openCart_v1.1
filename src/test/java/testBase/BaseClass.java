package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	public Logger logger;
	public Properties p;
	FileReader file;
	TakesScreenshot ts;
	public SoftAssert as;
	
	@Parameters({"browser", "os"})
	@BeforeClass(groups= {"Master", "Sanity"})
	public void setup(String browser, String os) throws IOException {
		logger = LogManager.getLogger(this.getClass());
		p = new Properties();
		file = new FileReader("./src//test//resources//config.properties");
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) capabilities.setPlatform(Platform.WIN11);
			else if(os.equalsIgnoreCase("mac")) capabilities.setPlatform(Platform.MAC);
			else if(os.equalsIgnoreCase("linux")) capabilities.setPlatform(Platform.LINUX);
			else return;
			
			switch(browser.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capabilities.setBrowserName("firefox"); break;
			default: return;
			}
			driver = new RemoteWebDriver(new URL("http://192.168.1.7:4444/wd/hub"), capabilities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(browser) {
				case "chrome": 
					driver = new ChromeDriver();
					break;
				case "edge":
					driver = new EdgeDriver();
					break;
				default: 
					logger.error("Invalid Browser");
					return;
			}
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL2"));
	}
	
	@AfterClass(groups= {"Master", "Sanity"})
	public void teardown() {
		driver.quit();
	}
	
	@SuppressWarnings("deprecation")
	public String randomString(int l, int u) {
		return RandomStringUtils.randomAlphabetic(l, u);
	}
	
	@SuppressWarnings("deprecation")
	public String randomNumeric(int n) {
		return RandomStringUtils.randomNumeric(n);
	}
	
	public String randomAlphaNumeric() {
		return randomString(8,9)+randomNumeric(4);
	}
	
	public String captureScreenshot(String test_name) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" +test_name+ "_" +timeStamp+ ".png";
		File targetFile = new File(targetFilePath);
		srcFile.renameTo(targetFile);
		return targetFilePath;
	}
}
