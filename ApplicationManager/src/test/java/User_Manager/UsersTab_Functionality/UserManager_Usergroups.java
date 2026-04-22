package User_Manager.UsersTab_Functionality;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.UserGroups_Page;
import appMan_Pages.Users_Page;
import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;

@Listeners(ScreenShotOnFailure.class)
public class UserManager_Usergroups {
	Common c = new Common();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	@BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("UM_Usergroups_Page");
			for(String[] rt : t){
				 for(String val : rt){
					 arr.add(val);
				    }
				 }
			//System.out.println(arr.size());
	}
  @Test(priority = 1)
  public void Open_Usergroups_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  UserGroups_Page UG_obj= PageFactory.initElements(driver, UserGroups_Page.class);
	  Reporter.log("<<======================{User Manager: UserGroup Module}=======================>> ");
	  Thread.sleep(1500);
	  UG_obj.Clickon_UserGroups_Tab();	
	  Thread.sleep(1000);
  }
  @Test(priority = 2,description="APP-415:New button")
  public void Clickon_Create_new_UserGroup_Icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  UserGroups_Page UGP_obj= PageFactory.initElements(driver, UserGroups_Page.class);
	  Reporter.log("********Testcase :APP-415:New button. ********");
	  UGP_obj.Create_New_UserGroups_panal();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-415  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority = 3,description="APP-414: Check all mandatory field.")
  public void CreateNew_UserGroup() throws IOException, InterruptedException {
	  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page UP_obj= PageFactory.initElements(driver, Users_Page.class);
	  Reporter.log("********Testcase :APP-414: Check all mandatory field. ********");
	  UP_obj.Enter_UserGroups_Name(arr.get(0));
	  Thread.sleep(1000);
	  UP_obj.DisputeManager_Checkbox(arr.get(3));
	  UP_obj.Save_and_Close_icon();
	  Thread.sleep(1000);
	  UP_obj.Notification();
	  Thread.sleep(1000);
	  UP_obj.Notification();
	  Reporter.log("********End :TestCase- APP-414  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority = 4,description="APP-424:'Reload' and 'Cancel' button")
  public void Check_reload_and_Cancel_icon() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page CGP_obj= PageFactory.initElements(driver, Users_Page.class);
	  UserGroups_Page UGP_obj= PageFactory.initElements(driver, UserGroups_Page.class);
	  Reporter.log("********Testcase :APP-424:'Reload' and 'Cancel' button. ********");
	  UGP_obj.Create_New_UserGroups_panal();
	  Thread.sleep(1000);
	  CGP_obj.Enter_UserGroups_Name(arr.get(0));
	  Thread.sleep(500);
	  CGP_obj.Reload_icon();
	  Thread.sleep(1000);
	  CGP_obj.Close();
	  Thread.sleep(2000);
	  CGP_obj.Notification();
	  Thread.sleep(1000);
	  CGP_obj.Notification();
	  Reporter.log("********End :TestCase- APP-424  ********");
	  Reporter.log("----------------------------------------");
 } 
  @Test(priority = 5,description="APP-423:'Save and close' button")
  public void Check_Save_and_close_icon_functionality() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page CGP_obj= PageFactory.initElements(driver, Users_Page.class);
	  UserGroups_Page UGP_obj= PageFactory.initElements(driver, UserGroups_Page.class);
	  Reporter.log("********Testcase :APP-423:'Save and close' button. ********");
	  UGP_obj.Create_New_UserGroups_panal();
	  Thread.sleep(1500);
	  CGP_obj.Enter_UserGroups_Name(arr.get(0));
	  CGP_obj.Save_icon();
	  Thread.sleep(2000);
	  CGP_obj.Notification();
	  Thread.sleep(1000);
	  CGP_obj.Notification();
	  CGP_obj.Close();
	  Thread.sleep(2000);
	  CGP_obj.Notification();
	  Thread.sleep(1000);
	  CGP_obj.Notification();
	  Reporter.log("********End :TestCase- APP-423  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority = 6)
  public void Check_Save_As_New_icon_functionality() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page CGP_obj= PageFactory.initElements(driver, Users_Page.class);
	  UserGroups_Page UGP_obj= PageFactory.initElements(driver, UserGroups_Page.class);
	  UGP_obj.Create_New_UserGroups_panal();
	  Thread.sleep(1500);
	  String newobje= arr.get(0);
	  CGP_obj.Enter_UserGroups_Name(newobje+"1");
	  Thread.sleep(400);
	  CGP_obj.Save_and_New_icon();
	  Thread.sleep(1500);
	  CGP_obj.Notification();
	  CGP_obj.Close();
	  Thread.sleep(2000);
	  CGP_obj.Notification();
	  Thread.sleep(1000);
	  CGP_obj.Notification();
  }
  @Test(priority = 7,description="APP-425:Save multiple user groups of same name")
  public void Check_multiple_user_groups_of_same_name() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Users_Page CGP_obj= PageFactory.initElements(driver, Users_Page.class);
	  UserGroups_Page UGP_obj= PageFactory.initElements(driver, UserGroups_Page.class);
	  Reporter.log("********Testcase : APP-425:Save multiple user groups of same name. ********");
	  UGP_obj.Create_New_UserGroups_panal();
	  Thread.sleep(1500);
	  CGP_obj.Enter_UserGroups_Name(arr.get(0));
	  Thread.sleep(500);
	  CGP_obj.Save_icon();
	  Thread.sleep(1500);
	  CGP_obj.Notification();
	  Thread.sleep(1000);
	  CGP_obj.Notification();
	  CGP_obj.Close();
	  Thread.sleep(2000);
	  CGP_obj.Notification();
	  Reporter.log("********End :TestCase- APP-425  ********");
	  Reporter.log("----------------------------------------");
  }
  
	@Test(priority = 8,description="APP-416:Update button")
	public void Update_button_Functionality() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page UP_obj= PageFactory.initElements(driver, Users_Page.class);
		events eve = new events(driver);
		Reporter.log("********Testcase :APP-416:Update button. ********");
		eve.Table_event(arr.get(0),"User_Group_Name");
		Thread.sleep(400);
		UP_obj.Click_On_Change_icon();
		Thread.sleep(1500);
		UP_obj.Enter_UserGroups_Name(arr.get(0));
		Thread.sleep(400);
		UP_obj.Save_and_Close_icon();
		Thread.sleep(2000);
		UP_obj.Notification();
		Thread.sleep(1000);
		UP_obj.Notification();
		Reporter.log("********End :TestCase- APP-416  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 9,description="APP-420:Link usergroups to administrations")
	public void Link_UserGroupto_Adim() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		Reporter.log("********Testcase : APP-420:Link usergroups to administrations. ********");
		link_user.Select_Usergroup_to_Link(arr.get(4),"fun_con_Admin_table","sort_fun_con_Admin_table");
		Thread.sleep(1000);
		link_user.Select_Usergroup_to_Link(arr.get(0),"User_Group_Name","sort_User_Group_Name");// Select Second table i.e existing user selection 
		Thread.sleep(1000);
		link_user.link_User_icon();
		Thread.sleep(500);
		link_user.Save_All_icon();
		Thread.sleep(2000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		Reporter.log("********End :TestCase- APP-420  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 10,description="APP-421:Unlink usergroups to administartions.")
	public void UnLink_UserGroupFrom_Adim() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : APP-421:Unlink usergroups to administartions. ********");
		link_user.Select_Usergroup_to_Link(arr.get(0),"unlinked_ug","sort_unlinked_ug");
		Thread.sleep(400);
		link_user.Unlink_User_icon();
		Thread.sleep(1000);
		link_user.Save_All_icon();
		Thread.sleep(15000);
		link_user.Notification();
		Thread.sleep(500);
		link_user.Notification();
		Thread.sleep(500);
		Reporter.log("********End :TestCase- APP-421  ********");
		Reporter.log("----------------------------------------");
		}
	
	@Test(priority = 11,description="APP-417:Delete button")
	public void Delete_UserGroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);
		events eve = new events(driver);
		Reporter.log("********Testcase : APP-417:Delete button. ********");
		link_user.Select_Usergroup_to_Link(arr.get(0),"User_Group_Name","sort_User_Group_Name");
		Thread.sleep(1000);
		link_user.Delete_icon();
		Thread.sleep(1500);
		link_user.Notification();
		Thread.sleep(1500);
		link_user.Notification();
		eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0),"User_Group_Name");
		Reporter.log("********End :TestCase- APP-417  ********");
		Reporter.log("----------------------------------------");
		}
	@Test(priority = 12)
	public void Link_Multiple_UserGroup_to_Administrator() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve = new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		Reporter.log("********Testcase : Link Multiple UserGroup to Administrato. ********");
		link_user.Select_Usergroup_to_Link(arr.get(4),"fun_con_Admin_table","sort_fun_con_Admin_table");
		Thread.sleep(500);
		eve.Drag_and_Drop("User_Group_Name");
		Thread.sleep(500);
		link_user.link_User_icon();
		Thread.sleep(1000);
		link_user.Save_All_icon();
		Thread.sleep(1500);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		Reporter.log("********End ********");
		Reporter.log("----------------------------------------");
		}
	@Test(priority = 13)
	public void UnLink_multiple_UserGroupFrom_from_Adim() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve = new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : Link Multiple UserGroup from Administrato ********");
		eve.Drag_and_Drop("unlinked_ug");
		Thread.sleep(400);
		link_user.Unlink_User_icon();
		Thread.sleep(1000);
		link_user.Save_All_icon();
		Thread.sleep(1500);
		link_user.Notification();
		Thread.sleep(500);
		link_user.Notification();
		Thread.sleep(500);
		Reporter.log("********End ********");
		Reporter.log("----------------------------------------");
		}
}
