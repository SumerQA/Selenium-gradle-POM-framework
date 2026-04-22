package User_Manager.UsersTab_Functionality;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Create_User;
import appMan_Pages.Security_Page;
import appMan_Pages.Users_Page;

@Listeners(ScreenShotOnFailure.class)
public class UserManager_Security {
	WebDriverManager mgr = new WebDriverManager();
	ReadXclData RD= new ReadXclData();
	 Common c = new Common();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("UM_Security");
			for(String[] rt : t){
				 for(String val : rt){
					 arr.add(val);
				    }
				 }
	}
	 
  @Test(priority = 1,description="APP-326:Tabs in the security screen")//tab_overview
 
  public void Goto_Security_tab() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
		  Reporter.log("<<======================{User Manager: Security Module}=======================>> ");
		  Reporter.log("********Testcase : APP-326:Tabs in the security screen");
		  /* Home_index_Page hp= new Home_index_Page(driver);
		  hp.Select_Manager_Users_Tab();
		  Thread.sleep(1500);*/
		  try {
			  sp_obj.Open_Security_Tab();
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		  Thread.sleep(1500);
		  Reporter.log("********End :TestCase- APP-326 ********");
		  Reporter.log("----------------------------------------");
		  }
  @Test(priority = 2,description="APP-328:Update button")//tab_overview
  public void Update_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  Reporter.log("********Testcase : APP-328:Update button********");
	  UG_obj.Click_On_Change_icon();
	  Thread.sleep(1000);
	  sp_obj.Enable_Password_checkbox(arr.get(0));
	  UG_obj.Save_All_icon();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  Thread.sleep(500);
	  sp_obj.Save_All_Changes_Notifications();
	  Reporter.log("********End :TestCase- APP-328 ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 3)
  public void lock_User() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  sp_obj.Lock_Unlock_table(arr.get(7), "overview_table","overview_table_id");
	  sp_obj.lock_User_Icon();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  }
  @Test(priority = 4)
  public void Unlock_User() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  sp_obj.Lock_Unlock_table(arr.get(7), "overview_table","overview_table_id");
	  Thread.sleep(500);
	  sp_obj.Unlock_User_Icon();
	  Thread.sleep(500);
	  sp_obj.overview_tab();
	  Thread.sleep(500);
	  }
  @Test(priority = 5)
  public void lock_Multiple_Users() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve =  new events(driver);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  eve.Drag_and_Drop("overview_table");
	  Thread.sleep(500);
	  sp_obj.lock_User_Icon();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  }
  @Test(priority = 6)
  public void Unlock__Multiple_Users() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve =  new events(driver);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  eve.Drag_and_Drop("overview_table");
	  Thread.sleep(500);
	  sp_obj.Unlock_User_Icon();
	  Thread.sleep(500);
	  sp_obj.overview_tab();
	  Thread.sleep(500);
	  }
  @Test(priority = 7,description="APP-352:Exception entry")
  public void Exception_tab_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  sp_obj.Exception_tab();
	  Thread.sleep(500);
	  sp_obj.sort_exceotion_table();
	  Thread.sleep(500);
	  }
@Test(priority = 8,description="APP-348:Validity of the password")
  public void Validity_of_password() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  Reporter.log("********Testcase : APP-348:Validity of the password********");
	 // sp_obj.Open_Security_Tab();
	  UG_obj.Click_On_Change_icon();
	  Thread.sleep(1000);
	  sp_obj.Enable_Password_checkbox(arr.get(0));
	  sp_obj.validity_password(arr.get(1));
	  sp_obj.last_n_password_cannot_be_used(arr.get(2));
	  UG_obj.Save_All_icon();
	  Thread.sleep(1000);
	  UG_obj.Notification();
	  Thread.sleep(1000);
	  UG_obj.Notification();
	  Reporter.log("********End :TestCase- APP-348 ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 9,description="APP-331:Last n passwords cannot be used")
  public void Last_n_PWD_CANT_be_Used() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  Reporter.log("********Testcase : APP-331:Last n passwords cannot be used********");
	  UG_obj.Click_On_Change_icon();
	  Thread.sleep(500);
	  sp_obj.Enable_Password_checkbox(arr.get(0));
	  sp_obj.last_n_password_cannot_be_used(arr.get(2));
	  UG_obj.Save_All_icon();
	  Thread.sleep(1000);
	  UG_obj.Notification();
	  Thread.sleep(1000);
	  UG_obj.Notification();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-331 ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 10,description="APP-332:User blocked after n attempts")
  public void UserBlocked_aftern_attampt() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  Reporter.log("********Testcase : APP-332:User blocked after n attempts********");
	  UG_obj.Click_On_Change_icon();
	  sp_obj.Enable_Password_checkbox(arr.get(0));
	  sp_obj.User_blocked_after_n_attempt(arr.get(3));
	  UG_obj.Save_All_icon();
	  Thread.sleep(2000);
	  sp_obj.Save_All_Changes_Notifications();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  Reporter.log("********End :TestCase- APP-332 ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 11,description="APP-349:Strong password")
  public void Strong_password() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  Reporter.log("********Testcase : APP-349:Strong password********");
	  UG_obj.Click_On_Change_icon();
	  Thread.sleep(800);
	  sp_obj.Enable_Password_checkbox(arr.get(0));
	  sp_obj.Strong_password(arr.get(4));
	  UG_obj.Save_All_icon();
	  Thread.sleep(2000);
	  sp_obj.Save_All_Changes_Notifications();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  Reporter.log("********End :TestCase- APP-349 ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 12,description="APP-329:Minimum length check")
  public void Min_length_Password() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  Reporter.log("********Testcase : APP-329:Minimum length check********");
	  UG_obj.Click_On_Change_icon();
	  Thread.sleep(1000);
	  sp_obj.Enable_Password_checkbox(arr.get(0));
	  Thread.sleep(500);
	  sp_obj.Strong_password("No");
	  Thread.sleep(1000);
	  sp_obj.Minimum_length_password(arr.get(5));
	  Thread.sleep(1000);
	  Reporter.log(arr.get(5)+"  : is Entered in Minimum length Password Field");
	  UG_obj.Save_All_icon();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  Thread.sleep(1000);
	  sp_obj.Save_All_Changes_Notifications();
	  System.out.println(arr.get(5));
	  String len = sp_obj.Mini_length_Password(arr.get(5));
	  Thread.sleep(1000);
	  sp_obj.Check_Password_Length(len); 
	  Thread.sleep(3000);
	  //Static Password length
	  Reporter.log("********End :TestCase- APP-329 ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 13,description="APP-330:Maximum length test")
  public void Max_length_Password() throws IOException, InterruptedException {
	  try {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Users_Page UG_obj= PageFactory.initElements(driver, Users_Page.class);
		  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
		  Reporter.log("********Testcase : APP-330:Maximum length test********");
		  try {
			  sp_obj.Open_Security_Tab();
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		  Thread.sleep(3000);
		  UG_obj.Click_On_Change_icon();
		  Thread.sleep(1500);
		  sp_obj.Enable_Password_checkbox(arr.get(0));
		  sp_obj.Maximum_length_password(arr.get(6));
		  Reporter.log(arr.get(6)+"  : is Entered in Maximum length Password Field");
		  UG_obj.Save_All_icon();
		  Thread.sleep(1000);
		  sp_obj.Save_All_Changes_Notifications();
		  Thread.sleep(1000);
		  sp_obj.Save_All_Changes_Notifications();
		  String len = sp_obj.Maxi_length_Password(arr.get(6));
		  sp_obj.Check_Password_Length(len);                                             //Static Password length
		  Thread.sleep(3000);
		  Reporter.log("********End :TestCase- APP-330 ********");
		  Reporter.log("----------------------------------------");  
	} catch (StaleElementReferenceException e) {
		System.out.println(e.getMessage());
	}
	  
	  }
  @Test(priority = 14,description="APP-361:Delete button")
	public void Delete_user_From_UserManager() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Reporter.log("********Testcase : APP-361:Delete button  ********");
		link_user.Clickon_Users_Tab();
		Thread.sleep(5000);
		link_user.Select_Usergroup_to_Link(mgr.getparam("UM_Users_page",0)+" "+mgr.getparam("UM_Users_page",1),"Users_table","sort_users_table");//will get and search username and inituals from UM_Users_page workbook
		Thread.sleep(1000);
		link_user.Delete_icon();
		 Thread.sleep(1000);
		OG_CU1.Notification();
		 Thread.sleep(1000);
		OG_CU1.Notification();
		Reporter.log("********End :TestCase- APP-361  ********");
		Reporter.log("----------------------------------------");
	}
  @Test(priority = 15)
  public void Navigate_to_index_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Security_Page sp_obj= PageFactory.initElements(driver, Security_Page.class);
	  sp_obj.Render_Usermanager_to_IndexPage();
	  sp_obj.Save_All_Changes_Notifications();
	  sp_obj.Cancel_Changes_Notifications();
	  }
  }
