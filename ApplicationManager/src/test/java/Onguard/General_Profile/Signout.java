package Onguard.General_Profile;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import appMan_Pages.General_Profile_Page;
@Listeners(ScreenShotOnFailure.class)
public class Signout {
	Common c= new Common();
	String ActionType = "Always generate actions";
  @Test(priority=1)
  public void logout_User() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Reporter.log("Verify Logout Functionality--------------->");
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(1000);
	  gp_page.General_profile_items("logout_item");
	  Thread.sleep(1000);
	  Reporter.log("Clicked on logout button.");
  }
}
