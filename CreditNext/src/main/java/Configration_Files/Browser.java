package Configration_Files;

import org.openqa.selenium.WebDriver;
public abstract class Browser implements WebDriver{
	 
    public Browser(String string) {
        this.browser = string;
    }
   

	// Do subclass level processing in this method
    protected abstract void constructBrowser();
 
    private String browser = null;
 
    public String getBrowser() {
        return browser;
    }
 
    public void setBrowser(String browser) {
        this.browser = browser;
    }	
}