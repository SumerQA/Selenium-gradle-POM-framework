package Onguard.General_Profile;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class Close_browser {
	Common c= new Common();
  @Test(priority=1)
  public void Close_Browser() throws IOException {
	  WebDriverManager.stopDriver();
	  System.out.println("browser closed Successfully");
	  Reporter.log("browser closed Successfully");
  }
}
