package Functional_Configration.Disputes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Standard_Disputes_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Standard_disputes {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("D_standard_dispute");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Standard_disputes_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("<<======================{Standard disputes Tab}=======================>> ");
	  SD_page.Goto_Standard_Dispute_page();
	  System.out.println("Standard disputes Page is opened");
  }
  @Test(priority=2,description="")
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  SD_page.Creat_New_icon();
	  Thread.sleep(1000);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Description() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Description Input field. ---------->>");
	  SD_page.Description("SD_desc", arr.get(0));                      //Bad Delivery service
	  System.out.println(arr.get(0)+" is Entered in description Field");
  }
  @Test(priority=4)
  public void Enter_Code() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Code Input field. ---------->>");
	  SD_page.code("SD_code", arr.get(1));
	  System.out.println(arr.get(1) +" is entered in Code Field");
  }
  @Test(priority=5)
  public void Enter_Action_Period() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Action Period Input field. ---------->>");
	  SD_page.Action_Period("SD_act_period", arr.get(2));
	  System.out.println( arr.get(2)+ " is Entered in Action Period Filed");
  }
  @Test(priority=6)
  public void Check_Monitoring_on_dispute_end_date_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Monitoring on dispute end date checkbox. ---------->>");
	  SD_page.Monitoring_on_dispute_end_date(arr.get(3));
  }
  @Test(priority=7)
  public void Check_Make_dispute_available_for_SSE_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Make dispute available for SSE checkbox. ---------->>");
	  SD_page.Make_dispute_available_for_SSE(arr.get(4));
  }
 /* @Test(priority=8)
  public void Check_Complete_Disputes_Automatically_Checkbox_is_Enabled() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  if((boolean) ((JavascriptExecutor) driver).executeScript("document.getElementById('CompleteDispute').checked;")){
		  System.out.println("Complete disputes automatically Checkbox is Disabled");
	  }
  }*/
  @Test(priority=9)
  public void Check_Dispute_Manager_Selection_RadioButton() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Dispute Manager radio button functionality. ---------->>");
	  String text = arr.get(9);
	  switch(text){
	  case("3"): 
		  SD_page.Dispute_Manager_Selection("SD_DM_selection_rButton");
	      SD_page.Dispute_Manager_Selection_DDList("SD_DM_acc_mgmt",arr.get(10));
	      break;
	  case("2") : 
		  SD_page.Dispute_Manager_Administration("SD_DM_admin");
	       break;
	  case("1"): 
		  SD_page.debtor("SD_DM_cus");
	      break;
	      }
  }
  @Test(priority=10)
  public void Check_Dispute_manager_Editable() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Dispute manager editable Checkbox. ---------->>");
	  SD_page.Dispute_Manager_Editable(arr.get(11));
  }
  @Test(priority=11)
  public void Check_change_TestDays() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Change Test days Checkbox. ---------->>");
	  SD_page.Change_Test_days(arr.get(12));
	  System.out.println("Change Test days checkbox is Checked");
  }
  @Test(priority=12)
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Save and Close button. ---------->>");
	  SD_page.Save_and_Close();
	  Thread.sleep(500);
	  SD_page.Notification();
	  Thread.sleep(500);
	  SD_page.Notification();
	  Thread.sleep(500);
  }
  @Test(priority=13,description="APP-466:Save multiple disputes of same name")
  public void Verify_multiple_disputes_of_same_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Save multiple disputes of same name. ---------->>");
	  SD_page.Creat_New_icon();
	  Thread.sleep(500);
	  SD_page.Description("SD_desc", arr.get(0));
	  SD_page.code("SD_code", arr.get(1));
	  SD_page.Action_Period("SD_act_period", arr.get(2));
	  SD_page.Save_and_Close();
	  Thread.sleep(1500);
	  SD_page.Notification();
	  Thread.sleep(1000);
	  SD_page.Cancel();
	  SD_page.Notification();
	  Thread.sleep(500);
  }
  @Test(priority=14,description="APP-464:Save and close button")
  public void Verify_Save_and_close_buttons () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Save and close buttons. ---------->>");
	  SD_page.Creat_New_icon();
	  Thread.sleep(500);
	  SD_page.Description("SD_desc", arr.get(0)+" Save");
	  SD_page.code("SD_code", arr.get(1)+" Save");
	  SD_page.Action_Period("SD_act_period", arr.get(2)+" 0");
	  SD_page.Save();
	  Thread.sleep(1000);
	  SD_page.Notification();
	  Thread.sleep(1000);
	  SD_page.Notification();
	  Thread.sleep(500);
	  SD_page.Cancel();
	  SD_page.Notification();
	  Thread.sleep(500);
  }
  @Test(priority=15,description="APP-465:Save as new")
  public void Verify_Save_as_New_button () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  Reporter.log("Verify Save as new buttons. ---------->>");
	  SD_page.Creat_New_icon();
	  Thread.sleep(500);
	  SD_page.Description("SD_desc", arr.get(0)+ "New");
	  SD_page.code("SD_code", arr.get(1)+ "New");
	  SD_page.Action_Period("SD_act_period", arr.get(2));
	  SD_page.Save_as_New();
	  Thread.sleep(1000);
	  SD_page.Notification();
	  Thread.sleep(500);
	  SD_page.Cancel();
	  SD_page.Notification();
	  Thread.sleep(500);
  }
  @Test(priority=16,description="APP-467:Linking standard disputes")
  public void Link_Standard_disputes_to_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Linking standard disputes functionality. ---------->>");
	  ev.Table_event(arr.get(13), "C_curr_admin_table");//Clicked on Administrations name
	  ev.Table_event(arr.get(0), "SD_Standard_dispute_table");        //Clicked on Standard Dispute table
	  SD_page.link();
	  Thread.sleep(500);
	  SD_page.Save_ALL_Changes();
	  Thread.sleep(1000);
	  SD_page.Notification();
	  Thread.sleep(500);
	  System.out.println("Newly Created Standard dispute is  linked Successfully");
  }
  @Test(priority=17,description="APP-461:Delete button when Linked to Admin")
  public void Delete_Linked_Standard_disputes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0), "SD_Standard_dispute_table"); 
	  Thread.sleep(500);
	  SD_page.Delete_Dispute_icon();
	  Thread.sleep(1000);
	  SD_page.Notification();
	  Thread.sleep(1000);
	  SD_page.Notification();
  }   
 @Test(priority=18,description="APP-468:Unlink standard dispute")
  public void UnLink_Standard_disputes_from_seletced_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Unlink standard dispute functionality. ---------->>");
	  ev.Table_event(arr.get(0), "SD_Unlink_Sdispute");
	  Thread.sleep(500);
	  SD_page.Unlink();
	  Thread.sleep(500);
	  SD_page.Save_ALL_Changes();
	  Thread.sleep(1000);
	  SD_page.Notification();
	  Thread.sleep(500);
	  System.out.println("Newly Created Standard dispute is  Unlinked Successfully");
  }
/* @Test(priority=18,description="APP-461:Delete button")
  public void Delete_Standard_disputes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Disputes_Page SD_page = new Standard_Disputes_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Delete button functionality. ---------->>");
	  ev.Table_event(arr.get(0), "SD_Standard_dispute_table"); 
	  SD_page.Delete_Dispute_icon();
	  SD_page.Notification();
	  SD_page.Notification();
	  System.out.println("Newly Created Standard Dispute is  Deleted Successfully");
	  Reporter.log("<<======================{End : Standard disputes Section}=======================>> ");
  }   */
}
