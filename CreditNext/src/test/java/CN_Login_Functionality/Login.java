package CN_Login_Functionality;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class Login extends TestListenerAdapter {	
	WebDriver driver=null;	
	CN_Login_Page login= null;
	@Parameters({"Browser","CreditNextURL"})
	@BeforeClass
	public void launchBrowser(String Browser,String URL) throws Exception {
		System.out.println("Browser- "+Browser +"  URL  - "+URL);
		WebDriverManager.startDriver(Browser,URL);	
	}
	@Test(description="Login into CreditNext Application")
	@Parameters({"Locale"})
	public void login_User() throws Exception{
		 driver= WebDriverManager.getDriverInstance();
		 login= new CN_Login_Page(driver);
		 login.UserLogin();
		 //login.LogoutApplication();
	}
}