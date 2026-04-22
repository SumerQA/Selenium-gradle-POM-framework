package CN_Login_Functionality;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import Utility.events;
import locatorPages.LoginPageLocators;

public class CN_Login_Page extends events {
	final WebDriver driver;

	public CN_Login_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getBuildVersion() throws InterruptedException {
		Thread.sleep(1000);
		return GetText(LoginPageLocators.buildVersion);
	}

	private void EnterUserName(String uName) throws InterruptedException {
		SendKey(LoginPageLocators.userName, uName);
		Thread.sleep(500);
	}

	private void EnterPassword(String uPassword) throws InterruptedException {
		SendKey(LoginPageLocators.Password, uPassword);
		Thread.sleep(500);
	}

	private void ChooseLanguage(String loginLanguage) throws InterruptedException {
		SendKey(LoginPageLocators.language, loginLanguage);
		Thread.sleep(500);
	}

	private void ChooseCurrency(String loginCurrency) throws InterruptedException {
		// DDlistOptionsByText(ControlProperties.currency, loginCurrency);
		SendKey(LoginPageLocators.currency, loginCurrency);
		Thread.sleep(500);
	}

	private void ClickonNextButton() {
		Click(LoginPageLocators.nextButton);
		isNotificationPresent(LoginPageLocators.notificationPopupMessage, LoginPageLocators.notificationPopup_yes,
				Duration.ofSeconds(10));
	}

	private void SelectUserGroup(String ug) throws InterruptedException {
		DDlistSelectByText(LoginPageLocators.userGroup, ug);
		Thread.sleep(500);
	}

	private void SelectAdmin(String loginAdmin) throws InterruptedException {
		DDlistSelectByText(LoginPageLocators.admin, loginAdmin);
		Thread.sleep(500);

	}

	private void ClickonNextBurron_LoginPage2() throws InterruptedException {

		Click(LoginPageLocators.UserGroup_Next_Button);

	}

	public void LogoutApplication() throws InterruptedException {
		Thread.sleep(3000);
		Click(LoginPageLocators.ProfileDDlist);
		Click(LoginPageLocators.LogoutButton);
	}

	public void VerifyHomePage() throws InterruptedException {
		Thread.sleep(10000);
		String actual = GetText1(LoginPageLocators.ProfileDDlist,Duration.ofSeconds(10));
		Assert.assertEquals(actual, "vinod");
	}

	public void UserLogin() throws InterruptedException {

		try {
			waitForElementFluent(100, 5);
			String buildVersion = getBuildVersion();
			Reporter.log(
					"*********************Automation running on Build:- " + buildVersion + "  ********************");
			EnterUserName("vinod"); //vinod EnterUserName("saim");
			EnterPassword("Hello@123");   
			ChooseLanguage("English"); // English ChooseLanguage("Engels");
			ChooseCurrency("USD");   // USD ChooseCurrency("EUR");
			ClickonNextButton();
			SelectUserGroup("Onguard"); // Onguard SelectUserGroup("Tester");
			SelectAdmin("U.S.G. People Belgium");   //SelectAdmin("U.S.G. People Belgium")    //SelectAdmin("SDNA");
			ClickonNextBurron_LoginPage2();
			VerifyHomePage();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}
