package CN_Login_Functionality;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Configration_Files.WebDriverManager;

public class Logout {
	static WebDriver driver=null;
  @Test
  public void logoutFromApp() {
	  Reporter.log("Verify Logout Functionality--------------->");
	  driver=WebDriverManager.getDriverInstance();
	  CN_Login_Page login= new CN_Login_Page(driver);
	  
	try {
		login.LogoutApplication();
		Thread.sleep(1000);
		 String buildVersion;
		 buildVersion = login.getBuildVersion();
		 Reporter.log("*********************Automation execution completed on Build :- "+buildVersion+" ********************");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		Reporter.log(e.getMessage());
	}
	  
	  
  }
  
	 @AfterClass	  
	 @Test(priority=3) 
	  public void CloseBrowser() {
		 WebDriverManager.stopDriver();
	 }
	 
}
