package Configration_Files;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser extends Browser {
	WebDriver d; 
	ChromeBrowser() {
        super("CHROME");
        constructBrowser();
    }
  
	@Override
    protected void constructBrowser() {
    	File file=new File("src");
		String browerPath=file.getAbsolutePath()+"//test//resources//Drivers//chromedriver.exe";
		ChromeOptions options = new ChromeOptions();		
		options.addArguments("test-type");
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver",browerPath);		
		d=new ChromeDriver(options);
    }

	@Override
	public void get(String url) {
		d.get(url);
		
	}

	@Override
	public String getCurrentUrl() {
		// TODO Auto-generated method stub
		return d.getCurrentUrl();
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return d.getTitle();
	}

	@Override
	public List<WebElement> findElements(By by) {
		// TODO Auto-generated method stub
		return d.findElements(by);
	}

	@Override
	public WebElement findElement(By by) {
		// TODO Auto-generated method stub
		return d.findElement(by);
	}

	@Override
	public String getPageSource() {
		// TODO Auto-generated method stub
		return d.getPageSource();
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		d.close();
		
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		d.quit();
		
	}

	@Override
	public Set<String> getWindowHandles() {
		// TODO Auto-generated method stub
		return d.getWindowHandles();
	}

	@Override
	public String getWindowHandle() {
		// TODO Auto-generated method stub
		return d.getWindowHandle();
	}

	@Override
	public TargetLocator switchTo() {
		// TODO Auto-generated method stub
		return d.switchTo();
	}

	@Override
	public Navigation navigate() {
		// TODO Auto-generated method stub
		return d.navigate();
	}

	@Override
	public Options manage() {
		// TODO Auto-generated method stub
		return d.manage();
	}
	
}