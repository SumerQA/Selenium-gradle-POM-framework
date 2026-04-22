package Configration_Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;


public class WebDriverManager {
	private static WebDriver d;
    
	public static WebDriver getDriverInstance() {
		return d;
	}

	
	public static WebDriver startDriver(String browser, String URL)
			throws InterruptedException, IOException {
		if (browser.equals("FIREFOX")) {
			File file=new File("drivers");
			String browerPath=file.getAbsolutePath()+"//wires.exe";
			System.setProperty("webdriver.gecko.driver", browerPath);			
			d = new FirefoxDriver();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		}
		if (browser.equals("CHROME")) {
			try {
				File file=new File("src");
		    	System.out.println(file.getAbsolutePath());
				String browerPath=file.getAbsolutePath()+"//test//resources//Drivers//chromedriver.exe";
				ChromeOptions options = new ChromeOptions();		
				options.addArguments("test-type");
				options.addArguments("disable-infobars");
				options.addArguments("--start-maximized");
				options.setAcceptInsecureCerts(true);
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				System.setProperty("webdriver.chrome.driver",browerPath);		
				d=new ChromeDriver(options);		
				getBrowserInfo(options);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getStackTrace());
			} 
		}
		if (browser.equals("IE")) {
			try {
				File file=new File("drivers");
				String browerPath=file.getAbsolutePath()+"//IEDriverServer";				
				System.setProperty("webdriver.ie.driver",browerPath);
				System.out.println(System.getProperty("webdriver.ie.driver"));
				d = new InternetExplorerDriver();
				// d = new RemoteWebDriver(new
				// URL("http://192.168.0.151:4444/wd/hub"), capabilitiesIE);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		d.get(URL);
		Thread.sleep(2000);
		if (browser.equals("IE")) {
			d.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		return d;
	}

	public static void stopDriver() {
		//d.manage().deleteAllCookies();
		d.quit();
	}
	
	public static void highlightElement(WebElement element) {
		for (int i = 0; i < 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 2px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
		}
	}
	private static void getBrowserInfo(ChromeOptions options) {
		Reporter.log("++++++++ BROWSER CONFIGURATION ++++++++");
		Reporter.log("---------------------------------------");
		Reporter.log("Browser used:- "+options.getBrowserName());
		Reporter.log("Browser version:- "+options.getBrowserVersion());
		Reporter.log("---------------------------------------");
	}
}
