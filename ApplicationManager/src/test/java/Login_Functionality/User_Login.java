package Login_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.devtools.v113.database.Database;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import appMan_Pages.General_Profile_Page;
@Listeners(ScreenShotOnFailure.class)
public class User_Login extends TestListenerAdapter {	
	ReadXclData RD= new ReadXclData();
	//VideoReord vr= new VideoReord();
	 Common c = new Common();
	
	@BeforeClass
	@Parameters({"Browser","URL"})
	public void setUp(String Browser,String URL) throws Exception {
		WebDriverManager.startDriver(Browser,URL);	
	}	
	
	@Test(priority=1,description="TestCase- APP-36 :Check for valid username and password ")
	@Parameters({"Locale", "ActiveUser","ValidPassword"})
	public void Check_for_Valid_Username_Password(String Locale, String ActiveUser, String ValidPassword) throws Exception{
		Reporter.log("<<======================{Application Manager login Module}=======================>> ");
		WebDriver driver=WebDriverManager.getDriverInstance();
		Test_Application_Manager_Login OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class);
		System.out.println("********TestCase- APP-01 :Check for valid username and password ********");
		Reporter.log("********TestCase- APP-01 :Check for valid username and password ********");
	//	vr.startRecording(Thread.currentThread().getStackTrace()[1].getMethodName());
		 OG_Login1.Enter_User_Name(ActiveUser);	//edwin
		 Thread.sleep(500);
		 switch(Locale){
		 case("EN") :  OG_Login1.Choose_Language("English");
		 break;
		 case("NL") :  OG_Login1.Choose_Language("Dutch");
		 break;
		 case("FR") :  OG_Login1.Choose_Language("French");
		 break;
		 case("DE") :  OG_Login1.Choose_Language("German");
		 break;
		 case("ES") :  OG_Login1.Choose_Language("Spanish");
		 break;
		 case("PT") :  OG_Login1.Choose_Language("Portuguese");
		 break;
		 case("IT") :  OG_Login1.Choose_Language("Italian");
		 break;
		 case("PO") :  OG_Login1.Choose_Language("Polish");
		 break;
		 case("RUS") :  OG_Login1.Choose_Language("Russian");
		 break;
		 case("TUR") :  OG_Login1.Choose_Language("Turkish");
		 break;
		 }
		 OG_Login1.Enter_Password(ValidPassword);
		 Thread.sleep(2000);
		 OG_Login1.ClickOn_next_Button();
		 Thread.sleep(500);
		 OG_Login1.isNotificationPresent();
		 System.out.println("********End :TestCase- APP-36  ********");
		 Reporter.log("********End :TestCase- APP-36  ********");
		 System.out.println(" ");
		 Reporter.log("---------------------------------------");
		// vr.stopRecording();
	}
	@Test(priority=2,description="TestCase- APP-38:Check usergroups in usergroup combo box")
	public void Check_Usergroups_in_Usergroup_combo_box() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		//vr.startRecording(Thread.currentThread().getStackTrace()[1].getMethodName());
		Test_Application_Manager_Login_UserGroup OG_Login2= PageFactory.initElements(driver, Test_Application_Manager_Login_UserGroup.class);
		System.out.println("********TestCase- APP-38:Check usergroups in usergroup combo box ********");
		Reporter.log("********TestCase- APP-38:Check usergroups in usergroup combo box ********"); 
		OG_Login2.Select_UserGroup_from_DDList(2);
		Thread.sleep(500);
		 System.out.println("********End :TestCase- APP-38  ********");
		 Reporter.log("********End :TestCase- APP-38  ********");
		 System.out.println(" ");
		 Reporter.log("---------------------------------------");
	}
	@Test(priority=3,description="TestCase- APP-39: Check Previous button in second stage of login screen")
	public void Check_Previous_Button_Functionality() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Test_Application_Manager_Login_UserGroup OG_Login2= PageFactory.initElements(driver, Test_Application_Manager_Login_UserGroup.class);
		Test_Application_Manager_Login OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class); 
		System.out.println("********TestCase- APP-39: Check Previous button in second stage of login screen ********");
		Reporter.log("********TestCase- APP-39: Check Previous button in second stage of login screen ********");
		OG_Login2.Previous_button();
		Thread.sleep(500);
		OG_Login1.isNotificationPresent();
		Thread.sleep(500);
		System.out.println("********End :TestCase- APP-39  ********");
		Reporter.log("********End :TestCase- APP-39  ********");
		Reporter.log(" ");
		Reporter.log("---------------------------------------");
		//vr.stopRecording();
	}
	@Test(priority=4,description="TestCase- APP-41:Check Next button in second stage of login screen")
	@Parameters({"ActiveUser","ValidPassword"})
	public void Check_Next_Button_Functionality(String ActiveUser, String ValidPassword) throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		//vr.startRecording(Thread.currentThread().getStackTrace()[1].getMethodName());
		Test_Application_Manager_Login_UserGroup OG_Login2= PageFactory.initElements(driver, Test_Application_Manager_Login_UserGroup.class);
		Test_Application_Manager_Login OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class);
		System.out.println("********TestCase- APP-41:Check Next button in second stage of login screen ********");
		Reporter.log("********TestCase- APP-41:Check Next button in second stage of login screen ********>");
		OG_Login1.Enter_User_Name(ActiveUser);	
		OG_Login1.Enter_Password(ValidPassword);
		Thread.sleep(500);
		OG_Login1.ClickOn_next_Button();
		Thread.sleep(1000);
		OG_Login1.isNotificationPresent();
		Thread.sleep(500);
		OG_Login2.Click_on_Next_button();
		Thread.sleep(500);
		General_Profile_Page gp_page = new General_Profile_Page(driver);
		gp_page.Goto_General_profile_DDlist();
		gp_page.General_profile_items("logout_item");
		System.out.println("********End :TestCase- APP-41  ********");
		Reporter.log("********End :TestCase- APP-41  ******** ");
		System.out.println(" ");
		Reporter.log("---------------------------------------");
	//	vr.stopRecording();
	}
  
	@Test(priority=5)
	@Parameters({"Locale", "inactiveUser", "ValidPassword"})
	public void Check_Inactive_Users_functionality(String Locale, String inactiveUser, String ValidPassword) throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		//vr.startRecording(Thread.currentThread().getStackTrace()[1].getMethodName());
		Test_Application_Manager_Login OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class);
		System.out.println("********TestCase- APP-41:Check Next button in second stage of login screen ********");
		Reporter.log("********TestCase- APP-41:Check Next button in second stage of login screen ********>");
		Thread.sleep(1500);
		OG_Login1.Enter_User_Name(inactiveUser);	
		Thread.sleep(500);
		switch(Locale){
		 case("EN") :  OG_Login1.Choose_Language("English");
		 break;
		 case("NL") :  OG_Login1.Choose_Language("Dutch");
		 break;
		 case("FR") :  OG_Login1.Choose_Language("French");
		 break;
		 case("DE") :  OG_Login1.Choose_Language("German");
		 break;
		 case("ES") :  OG_Login1.Choose_Language("Spanish");
		 break;
		 case("PT") :  OG_Login1.Choose_Language("Portuguese");
		 break;
		 case("IT") :  OG_Login1.Choose_Language("Italian");
		 break;
		 case("PO") :  OG_Login1.Choose_Language("Polish");
		 break;
		 case("RUS") :  OG_Login1.Choose_Language("Russian");
		 break;
		 case("TUR") :  OG_Login1.Choose_Language("Turkish");
		 break;
		 }
		Thread.sleep(1500);
		OG_Login1.Enter_Password(ValidPassword);
		Thread.sleep(2000);
		OG_Login1.ClickOn_next_Button();
		Thread.sleep(1000);
		OG_Login1.isNotificationPresent();
		Thread.sleep(1500);
		Reporter.log("********End ******** ");
		System.out.println(" ");
		Reporter.log("---------------------------------------");
		//vr.stopRecording();
   }
  //  @Test(priority=6)
	@Parameters({"ExpireUser", "ValidPassword", "NewPassword"})
	public void Check_Expired_Users_functionality(String ExpireUser, String ValidPassword, String NewPassword) throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		//vr.startRecording(Thread.currentThread().getStackTrace()[1].getMethodName());
		Test_Application_Manager_Login OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class);
		Test_Application_Manager_Login_UserGroup OG_Login2= PageFactory.initElements(driver, Test_Application_Manager_Login_UserGroup.class);
		System.out.println("********TestCase- APP-41:Check Next button in second stage of login screen ********");
		Reporter.log("********TestCase- APP-41:Check Next button in second stage of login screen ********>");
		OG_Login1.Enter_User_Name(ExpireUser);	
		OG_Login1.Enter_Password(ValidPassword);
		Thread.sleep(500);
		OG_Login1.ClickOn_next_Button();
		Thread.sleep(1000);
		OG_Login1.isNotificationPresent();
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath(c.getElementName("Confirm_Password"))).isDisplayed()){
				OG_Login1.ClickOn_next_Button();
				OG_Login1.isNotificationPresent();
				Thread.sleep(500);
				OG_Login1.Old_password(ValidPassword);
				Thread.sleep(500);
				OG_Login1.New_password(" ");
				Thread.sleep(500);
				OG_Login1.Confirm_password(" ");
				Thread.sleep(500);
				OG_Login1.ClickOn_next_Button();
				OG_Login1.isNotificationPresent();
				Thread.sleep(500);
				OG_Login1.Old_password(NewPassword);
				Thread.sleep(500);
				OG_Login1.New_password(NewPassword);
				Thread.sleep(500);
				OG_Login1.Confirm_password(NewPassword);
				Thread.sleep(500);
				OG_Login1.ClickOn_next_Button(); 
				OG_Login1.isNotificationPresent();
				Thread.sleep(500);
				OG_Login1.Old_password(ValidPassword);
				Thread.sleep(500);
				OG_Login1.New_password(NewPassword);
				Thread.sleep(500);
				OG_Login1.Confirm_password(NewPassword+"2");
				Thread.sleep(500);
				OG_Login1.ClickOn_next_Button();
				OG_Login1.isNotificationPresent();
				OG_Login1.Old_password(ValidPassword);
				Thread.sleep(500);
				OG_Login1.New_password(NewPassword);
				Thread.sleep(500);
				OG_Login1.Confirm_password(NewPassword);
				Thread.sleep(500);
				OG_Login1.ClickOn_next_Button();
				OG_Login1.isNotificationPresent();
				
			}else{
				System.out.println("Confirm Password Section Not Found");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Confirm Password Section Not Found");
			OG_Login2.Previous_button();
			Thread.sleep(800);
			OG_Login1.isNotificationPresent();
		}
		
		Reporter.log("********End ******** ");
		Reporter.log("---------------------------------------");
		//vr.stopRecording();
   }
	@Parameters({"Locale"})
	@Test(priority=7,description="TestCase- APP-37 :Check for valid and Invalid username and password with Paramerization")
	public void Check_Users_login_Functionality(String locale) throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		//vr.startRecording(Thread.currentThread().getStackTrace()[1].getMethodName());
		Test_Application_Manager_Login OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class);
		Test_Application_Manager_Login_UserGroup OG_Login2= PageFactory.initElements(driver, Test_Application_Manager_Login_UserGroup.class);
		System.out.println("********TestCase- APP-37 :Check for valid and Invalid username and password with Paramerization ********");
		Reporter.log("*******TestCase- APP-37 :Check for valid and Invalid username and password with Paramerization ********");
		OG_Login1.FormSubmission(locale);
		OG_Login2.Click_on_Next_button();
		Thread.sleep(400);
		System.out.println("********End :TestCase- APP-37  ********");
		Reporter.log("********End :TestCase- APP-37  ********");
		Reporter.log("---------------------------------------");
		System.out.println(" ");
		Reporter.log("<------------------------{End of Application Manager Login module}------------------------>");
	//	vr.stopRecording();
	}
}
