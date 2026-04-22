package locatorPages;

import org.openqa.selenium.By;

public class LoginPageLocators {
	        // ---------------------Locators Login screens----------------------
	
			public static By buildVersion = By.xpath("//p[@class='outer-build-version ng-tns-c67-0']");
	        public static By userName = By.xpath("//input[@name='username']");
	        public static By Password = By.xpath("//input[@id='inputPassword']");
	        public static By language = By.xpath("//select[@name='selectedLanguage']");
	        public static By currency = By.xpath("//select[@name='selectedCurrency']");
	        public static By nextButton = By.xpath("//button[@type='submit']");
	        public static By userGroup = By.xpath("//select[@name='groupSelection']");
	        public static By admin = By.xpath("//select[@name='administration']");
	        public static By UserGroup_Next_Button = By.xpath("//button[@type='submit']");
	      //  public static By notificationPopup = By.xpath("//div[@class='ui-toast-message-content']");
	        public static By notificationPopupMessage = By.cssSelector("p[class='ng-tns-c67-0']");    
	        public static By notificationPopup_yes = By.xpath("//button[normalize-space()='Yes']");
	        public static By ProfileDDlist = By.xpath("//*[@id='profileDropdown']/span");
	        public static By LogoutButton = By.xpath("//a[normalize-space()='Log off']");
	        
	        public static By appmalogin =By.xpath("//input[@name='UserName']");
	        public static By appmanpassword = By.xpath("//input[@name='TxtPassword']");
	        public static By appmanselectLanguage = By.xpath("(//span[@class='ddTitleText' and text()='English'])[last()]");
	        public static By appmanNotification = By.xpath("//h4[@id='messageTitleToDisplay_popover']");
	        public static By appmanFinishLogin = By.xpath("(//*[@id=\"ChooseUserGroupForm\"]//following::a[1])[1]");
}
