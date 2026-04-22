package User_Manager.UsersTab_Functionality;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Create_User;
import appMan_Pages.Home_index_Page;
import appMan_Pages.Users_Page;
import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;

@Listeners(ScreenShotOnFailure.class)
public class UserManager_Users extends TestListenerAdapter {	
	 Common c = new Common();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("UM_Users_page");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				   
				    }
				 }
			//System.out.println(arr.size());
			
	}
	@Test(priority = 1)
	public void Clickon_Users_Tab() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Home_index_Page OG_NU= PageFactory.initElements(driver, Home_index_Page.class);
		Users_Page usr= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("<<======================{User Manager: Users Module}=======================>> ");
		OG_NU.Select_Manager_Users_Tab();
		Thread.sleep(1500);
		usr.Clickon_Users_Tab();
		Thread.sleep(1500);
		Reporter.log("Users Tab is clicked Successfully");
	}
	@Test(priority = 2,description="APP-359:New button")
	public void Click_on_New_button() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page CN_users= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase :APP-359:New button ********");
		CN_users.Open_Create_NewUser_panal();	
		Thread.sleep(1000);
		Reporter.log("********End :TestCase- APP-359  ********");
		Reporter.log("----------------------------------------");
		Thread.sleep(1000);
	}
	@Test(priority = 3,description="APP-358:Check all mandatory fields")
	public void Check_all_mandatory_fields() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User CN_users1= PageFactory.initElements(driver, Create_User.class);
		Reporter.log("********Testcase : APP-358:Check all mandatory fields  ********");
		for(int i=0;i<=arr.size()-1;i++){
					switch(i){
						case 0:
							CN_users1.Enter_Name(arr.get(i));
							Thread.sleep(1000);
							 break;
						case 1:
							CN_users1. Enter_Initials(arr.get(i));
							Thread.sleep(1000);
							break;
						case 2:
							CN_users1. Select_Gender(arr.get(i));
							Thread.sleep(1000);
							break;
						case 3:
							CN_users1. Enter_Email(arr.get(i));
							Thread.sleep(1000);
							break;
						case 4:
							CN_users1. Enter_LoginName(arr.get(i));
							Thread.sleep(1000);
							break;
						case 5:
							CN_users1.  Enter_LoginPassword(arr.get(i));
							Thread.sleep(1000);
							break;
						case 6:
							CN_users1.  Enter_Confirm_Password(arr.get(i));
							Thread.sleep(1000);
							break;
						case 7:
							CN_users1. Select_Active_Checkbox(arr.get(i));
							Thread.sleep(1000);
							break;
						case 8:
							CN_users1. Select_ActionTaker(arr.get(i));
							Thread.sleep(1000);
							break;
						case 9:
							CN_users1. Select_ReportUser(arr.get(i));
							Thread.sleep(1000);
							break;
					}
					 
			}
		Reporter.log("********End :TestCase- APP-358  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority= 4,description="APP-367: 'Save and close' button")
	public void Save_and_close_Users_changes() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User CN_users1= PageFactory.initElements(driver, Create_User.class);
		Reporter.log("********Testcase : APP-367: 'Save and close' button  ********");
		CN_users1.Select_Save_n_Close();
		Thread.sleep(1000);
		CN_users1.Notification(); 
		Thread.sleep(1000);
		Reporter.log("********End :TestCase- APP-367  ********");
		Reporter.log("----------------------------------------");
		Thread.sleep(2000);
	}
	@Test(priority = 5)
	public void Check_Save_as_New_button() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Users_Page U_edit= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : Check Save as New button  ********");
		U_edit.Select_Usergroup_to_Link(arr.get(0)+" "+arr.get(1),"Users_table","sort_users_table");
		U_edit.Click_On_Change_icon();
		Thread.sleep(2000);
		OG_CU1.Enter_Name("Aarav");
		OG_CU1.Enter_Initials(arr.get(1));
		OG_CU1.Select_Gender(arr.get(2));
		OG_CU1.Enter_Email("NewUser@yopmail.com");
		OG_CU1.Enter_LoginName("Aarav");
		OG_CU1.Enter_LoginPassword(arr.get(5));
		OG_CU1.Enter_Confirm_Password(arr.get(6));
		OG_CU1.Select_Active_Checkbox("Yes");
		OG_CU1.Select_ActionTaker("Yes");
		OG_CU1.Details_tab();
		Thread.sleep(1000);
		OG_CU1.Enter_TelephoneNo("1234567889");
		OG_CU1.Enter_TelephoneExt("333");
		OG_CU1.Enter_MobileNo("9696969696");
		OG_CU1.Enter_MobileNo2("6969696969");
		OG_CU1.Enter_FaxNo("878787");
		OG_CU1.Enter_URL("www.mytest.com");
		OG_CU1.Select_manager("Test O");
		OG_CU1.Enter_Dept1("Account");
		OG_CU1.Enter_Dept2("operation");
		OG_CU1.Enter_Job_Desc("Tech manager");
		OG_CU1.Enter_Sign_As("My Name");
		//Below 160 line number code commented due to chagne functionlity of signature and note field
		//OG_CU1.Enter_Signature("Thanks and Regards,");
		OG_CU1.Enter_Note("No Comments please");
		/*OG_CU1.Settings_tab();
		Thread.sleep(1000);
		OG_CU1.Select_requist_recipent("Client");
		OG_CU1.Check_SendEmailBYme("UseSystemReplyAddress", "Yes", "Sumer", "password","");//Email server field added
		Thread.sleep(1000);*/
		Thread.sleep(1000);
		OG_CU1.Save_as_New();
		Thread.sleep(1000);
		OG_CU1.Notification();
		OG_CU1.Close();
		OG_CU1.Notification();
		Thread.sleep(2000);
		Reporter.log("********End  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 6)
	public void Check_Save_and_Close_button() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Users_Page U_edit= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : Check Save and_ lose button  ********");
		U_edit.Select_Usergroup_to_Link("Aarav"+" "+arr.get(1),"Users_table","sort_users_table");
		Thread.sleep(1000);
		U_edit.Click_On_Change_icon();
		Thread.sleep(2000);
		OG_CU1.Enter_Name("Aarav1");
		OG_CU1.Enter_Initials(arr.get(1));
		OG_CU1.Select_Gender(arr.get(2));
		OG_CU1.Enter_Email("NewUser@yopmail.com");
		OG_CU1.Enter_LoginName("Aarav");
		//OG_CU1.Enter_LoginPassword(arr.get(5));
		OG_CU1.Save();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Thread.sleep(1000);
		OG_CU1.Notification();
		OG_CU1.Enter_LoginPassword(arr.get(5));
		OG_CU1.Enter_Confirm_Password(arr.get(6));
		OG_CU1.Select_Active_Checkbox("No");
		Thread.sleep(1000);
		OG_CU1.Save();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Thread.sleep(1000);
		OG_CU1.Notification();
		OG_CU1.Close();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Reporter.log("********End  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 7)
	public void Check_Reload_button() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Users_Page U_edit= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : Check Reload button  ********");
		U_edit.Select_Usergroup_to_Link(arr.get(0)+" "+arr.get(1),"Users_table","sort_users_table");
		Thread.sleep(1000);
		U_edit.Click_On_Change_icon();
		Thread.sleep(1000);
		OG_CU1.Enter_Name("Aarav Test");
		OG_CU1.Enter_Initials(arr.get(1));
		OG_CU1.Select_Gender(arr.get(2));
		OG_CU1.Enter_Email("NewUserTest@yopmail.com");
		OG_CU1.Enter_LoginName("Aarav Test");
		OG_CU1.Enter_LoginPassword(arr.get(5));
		OG_CU1.Enter_Confirm_Password(arr.get(6));
		OG_CU1.Reload();
		Thread.sleep(1000);
		OG_CU1.Notification();
		OG_CU1.Close();
		OG_CU1.Notification();
		Reporter.log("********End  ********");
		Reporter.log("----------------------------------------");
	}
	
	
	@Test(priority = 8,description="APP-369:Login name must be unique")
	public void Check_Login_name_is_unique() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Users_Page CN_users= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : APP-369:Login name must be unique  ********");
		CN_users.Open_Create_NewUser_panal();	
		Thread.sleep(2000);
		OG_CU1.Enter_Name(arr.get(0));
		OG_CU1.Enter_Initials(arr.get(1));
		OG_CU1.Select_Gender(arr.get(2));
		OG_CU1.Enter_Email(arr.get(3));
		OG_CU1.Enter_LoginName(arr.get(4));
		OG_CU1.Enter_LoginPassword(arr.get(5));
		OG_CU1.Enter_Confirm_Password(arr.get(6));
		OG_CU1.Save();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Thread.sleep(1000);
		OG_CU1.Notification();
		OG_CU1.Close();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Reporter.log("********End :TestCase- APP-369  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 9)
	public void Show_Inactive_Users() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		events eve = new events(driver);
		OG_CU1.show_User_status();
		Thread.sleep(2000);
		eve.Table_GetData_event("Users_table");
 		Reporter.log("----------------------------------------");
	}
	@Test(priority = 10)
	public void Link_Inactive_User_to_Usergroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);
		events eve = new events(driver);
	    eve.Table_event(arr.get(10),"User_Group_Name");     //Select from User groups
		eve.Table_event_With_Pagination("Aarav1"+" "+arr.get(1),"Users_table","Users_table_id");  //Select inactive users from table
		Thread.sleep(1000);
		link_user.link_User_icon();
		Thread.sleep(1000);
		link_user.Save_All_icon();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 11)
	public void UnLink_Inactive_User_from_UserGroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve= new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		eve.Table_event_With_Pagination("Aarav1"+" "+arr.get(1),"LinkedWith_User_group_table","UserGroupLinked_Table_id");
		Thread.sleep(1000);
		link_user.Unlink_User_icon();
		link_user.Save_All_icon();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		Reporter.log("********End********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 12)
	public void Delete_Inactive_User() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve= new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		eve.Table_event_With_Pagination("Aarav1"+" "+arr.get(1),"Users_table","Users_table_id");
		Thread.sleep(1000);
		link_user.Delete_icon();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		eve.CheckItem_AfterDeleting_In_Table_event("Aarav1"+" "+arr.get(1),"Users_table");
		Thread.sleep(1000);
		link_user.Notification();
		Reporter.log("********End ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 13)
	public void Show_Active_Users() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		OG_CU1.show_User_status();
		Thread.sleep(2000);
    	Reporter.log("----------------------------------------");
	}
	@Test(priority = 14,description="APP-364:Link users to usergroups")
	public void Link_Users_to_UserGroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve = new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);
		Reporter.log("********Testcase : APP-364:Link users to usergroups  ********");
		link_user.Select_Usergroup_to_Link(arr.get(10),"User_Group_Name","sort_usergroup_table");
		Thread.sleep(2000);
		eve.Table_event_With_Pagination(arr.get(0)+" "+arr.get(1),"Users_table","Users_table_id");// Select Second table i.e existing user selection 
		Thread.sleep(1000);
		link_user.link_User_icon();
		Thread.sleep(1000);
		Reporter.log("********End :TestCase- APP-364  ********");
		Reporter.log("----------------------------------------");
		
	}
	@Test(priority = 15,description="APP-365: Unlink users to usergroups")
	public void UnLink_From_UserGroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve = new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		Reporter.log("********Testcase : APP-365: Unlink users to usergroups  ********");
		eve.Table_event_With_Pagination(arr.get(0)+" "+arr.get(1),"LinkedWith_User_group_table","UserGroupLinked_Table_id");
		Thread.sleep(1000);
		link_user.Unlink_User_icon();
		link_user.Save_All_icon();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		Reporter.log("********End :TestCase- APP-365  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 16)
	public void Link_Multiple_users_to_UserGroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve = new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		Reporter.log("********Testcase : APP-365: Unlink users to usergroups  ********");
		Thread.sleep(1000);
		link_user.Select_Usergroup_to_Link(arr.get(10),"User_Group_Name","sort_usergroup_table");
		eve.Click_event("sort_users_table");
		Thread.sleep(1000);
		eve.Drag_and_Drop("Users_table");
		link_user.link_User_icon();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		Reporter.log("********End  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 17)
	public void UnLink_Multiple_users_from_Selected_UserGroup() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		events eve = new events(driver);
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		Reporter.log("********Testcase : APP-365: Unlink users to usergroups  ********");
		Thread.sleep(1000);
		eve.Drag_and_Drop("LinkedWith_User_group_table");
		link_user.Unlink_User_icon();
		Thread.sleep(1000);
		link_user.Notification();
		Thread.sleep(1000);
		link_user.Notification();
		eve.Table_event("Edwin de Graaf", "Users_table");
		Thread.sleep(1000);
		link_user.link_User_icon();
		Thread.sleep(1000);
		Thread.sleep(1000);
		link_user.Notification();
		Reporter.log("********End  ********");
		Reporter.log("----------------------------------------");
	}
	@Test(priority = 18,description="APP-362:Save button")
	public void Save_AllChanges() throws Exception{
		WebDriver driver=WebDriverManager.getDriverInstance();
		Users_Page link_user= PageFactory.initElements(driver, Users_Page.class);	
		Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		Reporter.log("********Testcase : APP-362:Save button  ********");
		link_user.Save_All_icon();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Thread.sleep(1000);
		OG_CU1.Notification();
		Reporter.log("********End :TestCase- APP-362  ********");
		Reporter.log("----------------------------------------");
	}
	
}
