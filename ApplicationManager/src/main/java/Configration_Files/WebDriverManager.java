package Configration_Files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverManager {
	private static WebDriver d;
	static Common c = new Common();
    
	public static WebDriver getDriverInstance() {
		return d;
	}

	
	public static WebDriver startDriver(String browser, String URL)
			throws InterruptedException, IOException {
		if (browser.equals("FF")) {
			File file=new File("drivers");
			String browerPath=file.getAbsolutePath()+"//wires.exe";
			System.setProperty("webdriver.gecko.driver", browerPath);			
			d = new FirefoxDriver();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		}
		if (browser.equals("CH")) {
			try {
				File file=new File("src");
		    	System.out.println(file.getAbsolutePath());
				String browerPath=file.getAbsolutePath()+"//test//resources//Drivers//chromedriver.exe";
				ChromeOptions options = new ChromeOptions();		
				options.setAcceptInsecureCerts(true);
				options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
				options.addArguments("--start-maximized");
				options.addArguments("test-type");
				System.setProperty("webdriver.chrome.driver",browerPath);		
				d=new ChromeDriver(options);		
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
		//JavascriptExecutor executor = (JavascriptExecutor) d;
		//executor.executeScript("window.resizeTo(1920, 1080);");
		d.get(URL);
		Thread.sleep(2000);
		//d.manage().window().maximize();
		if (browser.equals("IE")) {
			d.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
		return d;
	}

	public static void stopDriver() {
		//d.manage().deleteAllCookies();
		d.quit();
	}

	
	public static void waitForElement(String item) {
	    WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(c.getElementName(item))));
	}
	public static void highlightElement(WebElement element) {
		for (int i = 0; i < 10; i++) {
			JavascriptExecutor js = (JavascriptExecutor) d;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 2px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
		}
	}

	public String getparam(String sheetname, int indx) throws Exception {
		ReadXclData rddata = new ReadXclData();
		ArrayList<String> arr = new ArrayList<>();
		String[][] t = rddata.readdata(sheetname);
		for (String[] rt : t) {
			for (String val : rt) {
				arr.add(val);
			}
		}
		return arr.get(indx);
	}

}
