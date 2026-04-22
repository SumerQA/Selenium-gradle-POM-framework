package Test.General_Profile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Create_User;
import appMan_Pages.General_Profile_Page;
import appMan_Pages.Home_index_Page;
import appMan_Pages.Users_Page;
@Listeners(ScreenShotOnFailure.class)
public class general_Profile {
	private File file= new File("src");
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("General_Profile");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Help_and_Documentation() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  events eve= new events(driver);
	  Thread.sleep(1500);
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(1500);
	  eve.handle_browser_tab("help_and_documentation","tripane");
  }
  @Test(priority=2)
  public void Test_Customer_portal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  events eve= new events(driver);
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(1500);
	  eve.handle_browser_tab("Test_customer_portal","user_email");
  }
  @Test(priority=3)
  public void Test_Service_Centre_Cancel_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  Reporter.log("<<======================{General Profile Section}=======================>> ");
	  Reporter.log("Verify cancel button Functionality----------->");
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(500);
	  gp_page.General_profile_items("Test_Service_centre");
	  Thread.sleep(500);
	  gp_page.to(arr.get(0));
	  gp_page.CC(arr.get(1));
	  gp_page.BCC(arr.get(2));
	  gp_page.Subject(arr.get(3));
	  gp_page.Body(arr.get(4));
	  gp_page.Add_Attachment(file.getAbsolutePath()+"/test/resources/Datafiles/Autoit_Script/upload.exe", "file:///"+file.getAbsolutePath()+"/test/resources/Datafiles/Testfile.txt");
	  Thread.sleep(500);
	  gp_page.Attachments();
	  Thread.sleep(500);
	  gp_page.Cancel();
	  Thread.sleep(500);
  }
  @Test(priority=4)
  public void Test_Service_Centre_Send_Functionality_with_Invalid_Configration() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  Reporter.log("Verify Send button Functionality with Invalid Configration----------->");
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(800);
	  gp_page.General_profile_items("Test_Service_centre");
	  Thread.sleep(500);
	  gp_page.to(arr.get(0));
	  gp_page.CC(arr.get(1));
	  gp_page.BCC(arr.get(2));
	  gp_page.Subject(arr.get(3));
	  gp_page.Body(arr.get(4));
	  gp_page.Add_Attachment(file.getAbsolutePath()+"/test/resources/Datafiles/Autoit_Script/upload.exe", "file:///"+file.getAbsolutePath()+"/test/resources/Datafiles/Testfile.txt");
	  Thread.sleep(1500);
	  gp_page.Send();
	  Thread.sleep(1000);
	  gp_page.Notification();
	  Thread.sleep(500);
	  gp_page.Notification();
	  Thread.sleep(500);
  }
  @Test(priority=5)
  public void Test_Service_Centre_Send_Functionality_with_Valid_Configration() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	 General_Profile_Page gp_page = new General_Profile_Page(driver);
	 Reporter.log("Verify Send button Functionality with Valid Configration----------->");
	 Configure_Valid_user_settings_for_Email();
	 gp_page.Goto_General_profile_DDlist();
	 Thread.sleep(800);
	 gp_page.General_profile_items("Test_Service_centre");
	 Thread.sleep(500);
	 gp_page.to(arr.get(0));
	 gp_page.CC(arr.get(1));
	 gp_page.BCC(arr.get(2));
	 gp_page.Subject(arr.get(3));
	 gp_page.Body(arr.get(4));
	 gp_page.Add_Attachment(file.getAbsolutePath()+"/test/resources/Datafiles/Autoit_Script/upload.exe", "file:///"+file.getAbsolutePath()+"/test/resources/Datafiles/Testfile.txt");
	 Thread.sleep(1500);
	 gp_page.Send();
	 Thread.sleep(1000);
	 gp_page.Notification();
	 Thread.sleep(500);
	 gp_page.Notification();
	 Thread.sleep(500);
			}
  
   @Test(priority=6)
  public void Show_Error_Log() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  Reporter.log("Verify Show Error Log Functionality----------->");
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(500);
	  gp_page.General_profile_items("Test_Show_Error_log");
	  Thread.sleep(500);
	  gp_page.Read_Error_Log();
	  Thread.sleep(500);
  }
  @Test(priority=7)
  public void About() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  General_Profile_Page gp_page = new General_Profile_Page(driver);
	  Reporter.log("Verify About Functionality----------->");
	  gp_page.Goto_General_profile_DDlist();
	  Thread.sleep(500);
	  gp_page.General_profile_items("About");
	  Thread.sleep(500);
	  gp_page.About();
	  Thread.sleep(500);
	  Reporter.log("<<======================{End :General Profile Section}=======================>> ");
  }
  public void Configure_Valid_user_settings_for_Email() throws InterruptedException, IOException{
	  WebDriver driver=WebDriverManager.getDriverInstance();
		Home_index_Page OG_NU= PageFactory.initElements(driver, Home_index_Page.class);
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Users_Page U_edit= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Verify email server in User settings tab  ********");
		if(driver.findElement(By.xpath("//*[@id='div_API']/h2/span")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id='div_API']/h2")).click();
			Thread.sleep(1500);
			OG_CU1.Notification();
		}
		OG_NU.Select_Manager_Users_Tab();
		Thread.sleep(1500);
		U_edit.Clickon_Users_Tab();
		Thread.sleep(2000);
		U_edit.Select_Usergroup_to_Link("Albert Craig A","Users_table","sort_users_table");
		Thread.sleep(1500);
		U_edit.Click_On_Change_icon();
		Thread.sleep(2000);
		OG_CU1.Enter_Initials("Mr");
		Thread.sleep(500);
		OG_CU1.Enter_Email("qa.email@sdnatech.com");
		OG_CU1.Settings_tab();
		Thread.sleep(1000);
		OG_CU1.Select_requist_recipent("Email");
		OG_CU1.Check_SendEmailBYme("UseSystemReplyAddress", "Yes", "test.email@sdnatech.com","EmailServer","Basic Authentication  ","test.email@sdnatech.com","sdna@1234");
		Thread.sleep(1000);
		OG_CU1.Select_Save_n_Close();
		Thread.sleep(1000);
		OG_CU1.Notification();
		if(driver.findElement(By.xpath("//*[@id='div_usermanager']/h2/span")).isDisplayed()){
			driver.findElement(By.xpath("//*[@id='div_usermanager']/h2")).click();
			Thread.sleep(2000);
			OG_CU1.Notification();
		}
		OG_NU.Select_Technical_Configration_Tab();
		Thread.sleep(2000);
  }
}
