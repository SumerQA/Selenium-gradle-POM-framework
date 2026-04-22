package Configration_Files;

public class BrowserFactory {
    public static Browser buildBrowser(String browserName) throws Exception {
        Browser browser = null;
        switch (browserName.toString()) {
        case "CHROME":
            browser = new ChromeBrowser();
            break;
 
        case "FIREFOX":
        	 browser = new FirefoxBrowser();
            break;
 
        case "IE":
        	browser = new IEBrowser();
            break;
 
        default:
            // throw some exception
        	throw new Exception("Browser not available");
        }
        return browser;
    }
}
