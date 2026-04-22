package Functional_Configration.Requests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Request_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Requests {
	String uname ="CallTest4";
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Request");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Requests_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  Reporter.log("<<======================{Requests Tab}=======================>> ");
	  rp_page.Goto_Requests_page();
	  Thread.sleep(500);
	  System.out.println("Requests Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Creat_New_icon();
	  Thread.sleep(1500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Requests_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Request_Name("RE_req_name",arr.get(0));
	  System.out.println(arr.get(0)+ " is Entered in Request Name Field");
  }
  @Test(priority=4)
  public void Select_Requests_type() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Request_type("RE_req_type", arr.get(1),"RE_standard_act_taker", arr.get(6));
  }
 
  @Test(priority=5)
  public void Enter_Description() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Description("RE_description",arr.get(2));
	  System.out.println(arr.get(2)+ "is Entered in Description Field");
  }
  @Test(priority=6)
  public void Check_monitoring_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Monitoring(arr.get(3));
  }
  @Test(priority=7)
  public void Enter_Period() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Period("RE_period",arr.get(4));
	  System.out.println(arr.get(4)+ ": is Entered in the Period input field");
  }
  @Test(priority=8)
  public void Select_Template() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Template("RE_Templete", arr.get(5));
	  System.out.println("value is Selected from templete field");
  }
  @Test(priority=9,description="APP-343:save and close")
  public void Save_andClose_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Save_and_Close();
	  Thread.sleep(1000);
	  rp_page.Notification();
	  Thread.sleep(1000);
	  rp_page.Notification();
  }
  
  @Test(priority=10,description="APP-345:Duplicate request.")
  public void Verify_Duplicate_Requests() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Creat_New_icon();
	  Thread.sleep(1000);
	  rp_page.Request_Name("RE_req_name",arr.get(0));
	  rp_page.Request_type("RE_req_type", arr.get(1),"RE_standard_act_taker", arr.get(6));
	  rp_page.Description("RE_description",arr.get(2));
	  rp_page.Period("RE_period",arr.get(4));
	  rp_page.Template("RE_Templete", arr.get(5));
	  Thread.sleep(500);
	  rp_page.Save_and_Close();
	  Thread.sleep(500);
	  rp_page.Notification();
	  Thread.sleep(500);
	  rp_page.Notification();
	  rp_page.Close();
	  Thread.sleep(500);
	  rp_page.Notification();
  }
  
  @Test(priority=11,description="APP-344:save as new.")
  public void Verify_Save_as_New_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "RE_Request_table");
	  rp_page.Update_icon();
	  Thread.sleep(1000);
	  rp_page.Request_Name("RE_req_name",arr.get(0)+"New");
	  rp_page.Period("RE_period","10");
	  Thread.sleep(500);
	  rp_page.Save_as_New();
	  Thread.sleep(500);
	  rp_page.Notification();
	  Thread.sleep(500);
	  rp_page.Notification();
	  rp_page.Close();
	  Thread.sleep(500);
	  rp_page.Notification();
  }
  
  
  @Test(priority=12,description="APP-336:Check mandatory fields when create new request.")
  public void Verify_mandatory_fields_when_create_new_Request() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  rp_page.Creat_New_icon();
	  Thread.sleep(500);
	  rp_page.Request_Name_Clear("RE_req_name");
	  rp_page.Request_type("RE_req_type", arr.get(1),"RE_standard_act_taker", arr.get(6));
	  rp_page.Description("RE_description",arr.get(2));
	  rp_page.Period("RE_period",arr.get(4));
	  rp_page.Template("RE_Templete", arr.get(5));
	  rp_page.Save();
	  Thread.sleep(1000);
	  rp_page.Notification();
	  rp_page.Request_Name("RE_req_name",arr.get(0));
	  rp_page.Request_type("RE_req_type", arr.get(1),"RE_standard_act_taker", arr.get(6));
	  rp_page.Description("RE_description",arr.get(2));
	  rp_page.Period_Clear("RE_period");
	  rp_page.Template("RE_Templete", arr.get(5));
	  rp_page.Save();
	  Thread.sleep(1000);
	  rp_page.Notification();
	  rp_page.Close();
	  Thread.sleep(500);
	  rp_page.Notification();
  }
  
  @Test(priority=13,description="APP-337:Update button.")
  public void Verify_Update_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "RE_Request_table");
	  rp_page.Update_icon();
	  Thread.sleep(1000);
	  rp_page.Request_Name("RE_req_name",arr.get(0)+"Update");
	  rp_page.Request_type("RE_req_type", arr.get(1),"RE_standard_act_taker", arr.get(6));
	  rp_page.Description("RE_description",arr.get(2));
	  rp_page.Period("RE_period",arr.get(4));
	  rp_page.Template("RE_Templete", arr.get(5));
	  rp_page.Save_and_Close();
	  Thread.sleep(500);
	  rp_page.Notification();
	  Thread.sleep(500);
	  rp_page.Notification();
  }
  
  
  @Test(priority=14,description="APP-346:Link requests to administrations")
  public void Link_Requests_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(7), "C_curr_admin_table");
	  eve.Table_event(arr.get(0)+"Update", "RE_Request_table");
	  rp_page.link();
	  Thread.sleep(500);
	  rp_page.Save_panal();
	  Thread.sleep(500);
	  rp_page.Notification();
  }
  @Test(priority=15,description="APP-338:Delete request already linked to an administration")
  public void Delete_Requests_already_linked_to_administration() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Update", "RE_Request_table");
	  rp_page.Delete_icon();
	  Thread.sleep(500);
	  rp_page.Notification();
	  Thread.sleep(500);
	  rp_page.Notification();
	  }
  
  @Test(priority=16,description="APP-347:Unlink requests to administrations")
  public void UnLink_Requests_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Update", "RE_Request_Linked_table");
	  rp_page.Unlink();
	  Thread.sleep(500);
	  rp_page.Save_panal();
	  Thread.sleep(1000);
	  rp_page.Notification();
	  }
 @Test(priority=17,description="APP-339:Delete request not linked to an administration")
  public void Delete_Requests() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Request_Page rp_page = new Request_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Update", "RE_Request_table");
	  rp_page.Delete_icon();
	  Thread.sleep(1000);
	  rp_page.Notification();
	  Thread.sleep(1000);
	  rp_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+"Update", "RE_Request_table");
	  }
 
}
