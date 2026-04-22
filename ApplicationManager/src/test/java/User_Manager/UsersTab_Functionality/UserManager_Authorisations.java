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
import appMan_Pages.Authorisations_Page;

@Listeners(ScreenShotOnFailure.class)
public class UserManager_Authorisations {
	WebDriverManager mgr = new WebDriverManager();
	ReadXclData RD= new ReadXclData();
	 Common c = new Common();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("UM_Authorisations");
			for(String[] rt : t){
				 for(String val : rt){
					 arr.add(val);
				    }
				 }
	}
	 
  @Test(priority = 1,description="Open Authorisations panal")//tab_overview
 
  public void Goto_Authorisations_panal() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
		  Reporter.log("<<======================{User Manager: Security Module}=======================>> ");
		  Reporter.log("Open Authorisations panal");
			/*
			 * Home_index_Page hp= new Home_index_Page(driver);
			 * hp.Select_Manager_Users_Tab(); Thread.sleep(1500);
			 */
		  
		  try {
			  Thread.sleep(1000);
			  auth_obj.Open_Authorisations_Tab();
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		  Thread.sleep(1500);
		  Reporter.log("********Authorisations panal is opened ********");
		  Reporter.log("----------------------------------------");
		  }
  @Test(priority = 2,description="Create New Role")//tab_overview
  public void Check_Default_Role_for_Newly_Created_User_Under_Onguard_CreditNext_Viewer_Role() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Default role for Newly Created User");	 
	  auth_obj.Users_Table(arr.get(0),"R_user_table","Users_Table_Common_id");
	  auth_obj.Roles_Table("OnGuard CreditNext Viewer", "R_roles_table");
	  auth_obj.Users_Linked_to_Role_Table(arr.get(0), "R_roleslinked_Table","R_roleslinked_Table_id");
	  Reporter.log("********Verify Default role for Newly Created User********");
	  Reporter.log("----------------------------------------");
	  }
 
@Test(priority = 3)
  public void Create_New_ChieldRole_for_Onguard_CreditNext_Account_Manager() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Create New Role for OnGuard CreditNext Account Manager");
	  auth_obj.Create_New_AuthRole_panal();
	  Thread.sleep(1500);
	  auth_obj.Role_Name("R_name", arr.get(1));
	  auth_obj.Description("R_desc", "Created for Account manager");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Account Manager");	 	
	  auth_obj.Role_Save_and_Close_Icon();
	  Thread.sleep(2000);
	  auth_obj.Notification();
	  Thread.sleep(2000);
	  Reporter.log("********New Role Created for OnGuard CreditNext Account Manager ********");
	  Reporter.log("----------------------------------------");
	  }
 
  @Test(priority = 4)
  public void Create_New_ChieldRole_for_Onguard_CreditNext_Credit_manager() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Create New Role for OnGuard CreditNext Credit Manager");
	  auth_obj.Create_New_AuthRole_panal();
	  Thread.sleep(1000);
	  auth_obj.Role_Name("R_name", arr.get(2));
	  auth_obj.Description("R_desc", "Created for Credit Manager");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Credit Manager");
	  auth_obj.Role_Save_and_Close_Icon();
	  Thread.sleep(3000);
	  auth_obj.Notification();
	  
	  Reporter.log("********New Role Created for OnGuard Credit manager ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority = 5)
  public void Link_New_User_to_Onguard_CreditNext_Account_Manager_ChieldRole() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Link New User to OnGuard CreditNext Account Manager Role");
	  auth_obj.Open_Authorisations_Tab();
	  auth_obj.Users_Table(arr.get(0),"R_user_table","Users_Table_Common_id");
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1),"No");
	  Thread.sleep(1000);
	  auth_obj.Link_button();
	  auth_obj.Notification();
	  auth_obj.Save_After_linking_Icon();
	  auth_obj.Notification();
	  auth_obj.Expand_and_Collepse_Table("OnGuard CreditNext Account Manager", "R_roles_table");
	  Thread.sleep(2000);
	  }
  @Test(priority = 6)
  public void Check_New_User_for_Default_Role() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Default role after assigning another role");	 
	 // auth_obj.Users_Table(arr.get(0),"R_user_table");
	  auth_obj.Roles_Table("OnGuard CreditNext Viewer", "R_roles_table");
	  auth_obj.Users_Linked_to_Role_Table(arr.get(0), "R_roleslinked_Table","R_roleslinked_Table_id");
	  Thread.sleep(2000);
	  Reporter.log("********Default role verified after assigning another role********");
	  Reporter.log("----------------------------------------");
	 
	  } 
  @Test(priority = 7)
  public void Check_New_User_is_Linked_to_Onguard_CreditNext_Account_Manager_ChieldRole() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify that New User is linked to OnGuard CreditNext Account Manager Role");	  
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1),"Yes");
	  Thread.sleep(1000);
	  } 
  @Test(priority = 8)
  public void Delete_ChieldRole_with_Linked_User() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Delete Child role created for OnGuard CreditNext Account Manager Role");	 
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1),"No");
	  auth_obj.Delete_New_AuthRol_button();
	  auth_obj.Notification();
	  Thread.sleep(1000);
	  auth_obj.Notification();
	  Thread.sleep(500);
	  auth_obj.Expand_and_Collepse_Table("OnGuard CreditNext Account Manager", "R_roles_table");
	  
	  }
  @Test(priority = 9)
  public void Unlink_New_User_from_Onguard_CreditNext_Account_Manager_ChieldRole() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Unlink New User to OnGuard CreditNext Account Manager Role");
	 // auth_obj.Users_Table(arr.get(0),"R_user_table");
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1),"No");
	  auth_obj.Users_Linked_to_Role_Table(arr.get(0), "R_roleslinked_Table","R_roleslinked_Table_id");
	  auth_obj.Unlink_button();
	  auth_obj.Notification();
	  auth_obj.Save_After_linking_Icon();
	  auth_obj.Notification();
	  auth_obj.Expand_and_Collepse_Table("OnGuard CreditNext Account Manager", "R_roles_table");
	  }
  @Test(priority = 10)
  public void Delete_ChieldRole_After_Unlinking_New_User() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Delete Child role after unlinking from OnGuard CreditNext Account Manager Role ");	 
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1),"No");
	  auth_obj.Delete_New_AuthRol_button();
	  Thread.sleep(1000);
	  auth_obj.Notification();
	  auth_obj.Notification();
	  //auth_obj.Expand_and_Collepse_Table("OnGuard CreditNext Application Manager", "R_roles_table");
	  }
  
  @Test(priority = 11)
  public void Link_User_to_Onguard_CreditNext_Credit_manager_Parent_Role() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Link New User to OnGuard CreditNext Credit Manager Role");
	  Thread.sleep(10000);
	  auth_obj.Users_Table(arr.get(0),"R_user_table","Users_Table_Common_id");
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Credit Manager", "R_roles_table",arr.get(2),"No");
	  Thread.sleep(500);
	  auth_obj.Link_button();
	  auth_obj.Notification();
	  auth_obj.Save_After_linking_Icon();
	  Thread.sleep(1000);
	  auth_obj.Notification();
	  auth_obj.Expand_and_Collepse_Table("OnGuard CreditNext Credit Manager", "R_roles_table");
	  }
  @Test(priority = 12)
  public void Update_Onguard_CreditNext_Credit_manager_Chield_Role() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Credit Manager", "R_roles_table",arr.get(2),"No");
	  auth_obj.Update_New_AuthRol_button();
	  auth_obj.Role_Name("R_name", arr.get(2)+" update");
	  auth_obj.Role_Save_and_Close_Icon();
	  Thread.sleep(1000);
	  auth_obj.Notification();
	  auth_obj.Expand_and_Collepse_Table("OnGuard CreditNext Credit Manager", "R_roles_table");
	  }
  @Test(priority = 13)
  public void Verify_Updated_Onguard_CreditNext_Credit_manager_Chield_Role() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Credit Manager", "R_roles_table",arr.get(2)+" update","Yes");
	  }
  @Test(priority = 14)
  public void Verify_deletion_of_parent_Role() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  auth_obj.Roles_Table("OnGuard CreditNext Viewer", "R_roles_table");
	  auth_obj.Delete_New_AuthRol_button();
	  auth_obj.Notification();
	  auth_obj.Notification();
	  }
  @Test(priority = 15)
  public void Verify_mandatory_fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Mandatory Fields");	 
	  auth_obj.Create_New_AuthRole_panal();
	  Thread.sleep(1000);
	  auth_obj.Role_Name("R_name", "");
	  auth_obj.Description("R_desc", "checking mandatory fields");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Account Manager");	 	
	  auth_obj.Role_Save_and_Close_Icon();
	  auth_obj.Notification();
	  auth_obj.Notification();
	  auth_obj.Role_Cancel_Icon();
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Mandatory Fields Verified********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 16)
  public void Verify_Save_button_Functionality_in_Create_Role_Panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Save button Functionality in Create Role panal");	 
	  auth_obj.Create_New_AuthRole_panal();
	  Thread.sleep(1000);
	  auth_obj.Role_Name("R_name", arr.get(1)+" Save");
	  auth_obj.Description("R_desc", "checking mandatory fields");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Account Manager");	 	
	  auth_obj.Role_Save_Icon();
	  auth_obj.Notification();
	  auth_obj.Notification();	 
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Save button Functionality Verified********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 17)
  public void Verify_Reload_button_Functionality_in_Create_Role_Panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Save button Functionality in Create Role panal");	 
	  auth_obj.Role_Name("R_name", arr.get(1)+" Reload");
	  auth_obj.Description("R_desc", "checking mandatory fields");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Account Manager");	 	
	  auth_obj.Role_Reload_Icon();
	  auth_obj.Notification();
	  auth_obj.Notification();
	  auth_obj.Role_Save_and_Close_Icon();
	  auth_obj.Notification();	
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Save button Functionality Verified********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 18)
  public void Verify_Saved_Chield_Role_using_Save_Icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Saved Chield role under parent Role");	 
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1)+" Save","Yes");	
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Chield Role verified under Parent role using SAVE icon********");
	  Reporter.log("----------------------------------------");
	  }
  
  @Test(priority = 19)
  public void Verify_Save_As_New_button_Functionality_in_Create_Role_Panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Save As New button Functionality in Create Role panal");
	  auth_obj.Create_New_AuthRole_panal();
	  auth_obj.Role_Name("R_name", arr.get(1)+" SAN");
	  auth_obj.Description("R_desc", "checking Save as New icon");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Account Manager");	 	
	  auth_obj.Role_Save_AS_New_Icon();
	  auth_obj.Notification();
	  auth_obj.Notification();	
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Save button Functionality Verified********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 20)
  public void Verify_Cancel_button_Functionality_in_Create_Role_Panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Save As New button Functionality in Create Role panal");
	  auth_obj.Role_Cancel_Icon();
	  auth_obj.Notification();	
	  auth_obj.Notification();	
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Save button Functionality Verified********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 21)
  public void Verify_Saved_Chield_Role_using_Save_As_New_Icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify Saved Chield role under parent Role");	 
	  auth_obj.Chield_Role_Table("OnGuard CreditNext Account Manager", "R_roles_table",arr.get(1)+" SAN","No");	
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Chield Role verified under Parent role using SAVE icon********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority = 22)
  public void Verify_redundancy_for_Chield_Rol() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Authorisations_Page auth_obj= PageFactory.initElements(driver, Authorisations_Page.class);
	  Reporter.log("Verify the Redundancy for Chield Role ");
	  auth_obj.Create_New_AuthRole_panal();
	  auth_obj.Role_Name("R_name", arr.get(1)+" SAN");
	  auth_obj.Description("R_desc", "checking redundancy");
	  auth_obj.Copy_Of("R_copy_of", "OnGuard CreditNext Account Manager");	 	
	  auth_obj.Role_Save_and_Close_Icon();
	  auth_obj.Notification();
	  auth_obj.Notification();
	  auth_obj.Role_Cancel_Icon();
	  auth_obj.Notification();
	  Thread.sleep(2000);	
	  Reporter.log("----------------------------------------");
	  Reporter.log("********Redundancy for Chield Role verified********");
	  Reporter.log("----------------------------------------");
	  }
  }
