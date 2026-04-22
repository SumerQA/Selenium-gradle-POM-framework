package Functional_Configration.Disputes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Status_Maintenance_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Status_maintenance {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("D_Status_maintenance");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Status_maintenance_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("<<======================{Status maintenance Tab}=======================>> ");
	  Sm_page.Goto_Status_Maintenance_page();
	  Thread.sleep(500);
	  System.out.println("Status maintenance Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  Sm_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Dispute_Status_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Dispute status name input field. ---------->>");
	  Sm_page.Dispute_Status_Name("SM_dispute_status_name",arr.get(0));                    //status Name
	  System.out.println(arr.get(0)+ "  is Entered in Dispute Status Name Field");
  }
  @Test(priority=4)
  public void Seelect_Debtor_letter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Debtor letter DDlist. ---------->>");
	  Sm_page.Customer_letter("SM_Cus_letter", arr.get(1));
	  System.out.println(arr.get(1)+ " is selected from Debtor letter DDlist");
  }
  @Test(priority=5)
  public void Block_or_UnBlock_debtor() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Block Unblock Debtor. ---------->>");
	  Sm_page.Block_Unblock_Customer(arr.get(2));
  }
  @Test(priority=6)
  public void Block_or_UnBlock_Invoices() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Block Unblock Invoices. ---------->>");
	  Sm_page.Block_Unblock_Invoices(arr.get(3));
  }
  @Test(priority=7)
  public void Select_letter_Email() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify letter Email DDlist. ---------->>");
	  Sm_page.Email_letter("SM_letter",arr.get(4));
  }
  @Test(priority=8)
  public void Check_Action_taker() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Action taker checkbox. ---------->>");
	  Sm_page.Action_taker(arr.get(5));
  }
  @Test(priority=9)
  public void Check_Credit_manager() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Credit manager checkbox. ---------->>");
	  Sm_page.Credit_Manager(arr.get(6));
  }
  @Test(priority=10)
  public void Check_Dispute_manager() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Dispute manager checkbox. ---------->>");
	  Sm_page.Dispute_Manager(arr.get(7));
	  
  }
  @Test(priority=11)
  public void Check_Account_manager() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Account manager checkbox. ---------->>");
	  Sm_page.Account_Manager(arr.get(8));
  }
  @Test(priority=12)
  public void Check_SendTo() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Send to checkbox functionality. ---------->>");
	  Sm_page.Send_to(arr.get(9),arr.get(10));
  }
  @Test(priority=13,description="APP-503:Save and close button")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Save and close button. ---------->>");
	  Sm_page.Save_and_Close();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
  }
  
  @Test(priority=14,description="APP-498:Add new maintenance and check manadatory fields.")
  public void Verify_manadatory_fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Add new maintenance and check manadatory fields. ---------->>");
	  Sm_page.Creat_New_icon();
	  Thread.sleep(500);
	  Sm_page.Customer_letter("SM_Cus_letter", arr.get(1));
	  Sm_page.Block_Unblock_Customer(arr.get(2));
	  Sm_page.Block_Unblock_Invoices(arr.get(3));
	  Sm_page.Email_letter("SM_letter",arr.get(4));
	  Sm_page.Action_taker(arr.get(5));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Dispute_Manager(arr.get(7));
	  Sm_page.Account_Manager(arr.get(8));
	  Sm_page.Send_to(arr.get(9),arr.get(10));
	  Sm_page.Save_and_Close();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Cancel();
	  Thread.sleep(500);
	  Sm_page.Notification();
  }
  
  @Test(priority=15,description="APP-499:update status.")
  public void Verify_Update_status() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify update status functionality. ---------->>");
	  ev.Table_event(arr.get(0),"SM_Statuses_table"); 
	  Thread.sleep(500);
	  Sm_page.Update_icon();
	  Thread.sleep(500);
	  Sm_page.Dispute_Status_Name("SM_dispute_status_name",arr.get(0)+" Update"); 
	  Sm_page.Customer_letter("SM_Cus_letter", arr.get(1));
	  Sm_page.Block_Unblock_Customer(arr.get(2));
	  Sm_page.Block_Unblock_Invoices(arr.get(3));
	  Sm_page.Email_letter("SM_letter",arr.get(4));
	  Sm_page.Action_taker(arr.get(5));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Dispute_Manager(arr.get(7));
	  Sm_page.Account_Manager(arr.get(8));
	  Sm_page.Send_to(arr.get(9),arr.get(10));
	  Thread.sleep(1000);
	  Sm_page.Save_and_Close();
	  Thread.sleep(1000);
	  Sm_page.Notification();
	  Thread.sleep(1000);
	  Sm_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=16,description="APP-502: 'Save' and 'Cancel' button.")
  public void Verify_Save_and_cancel_buttons() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify 'Save' and 'Cancel' button. ---------->>");
	  Sm_page.Creat_New_icon();
	  Thread.sleep(500);
	  Sm_page.Dispute_Status_Name("SM_dispute_status_name",arr.get(0)); 
	  Sm_page.Customer_letter("SM_Cus_letter", arr.get(1));
	  Sm_page.Block_Unblock_Customer(arr.get(2));
	  Sm_page.Block_Unblock_Invoices(arr.get(3));
	  Sm_page.Email_letter("SM_letter",arr.get(4));
	  Sm_page.Action_taker(arr.get(5));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Dispute_Manager(arr.get(7));
	  Sm_page.Account_Manager(arr.get(8));
	  Sm_page.Send_to(arr.get(9),arr.get(10));
	  Sm_page.Save();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Sm_page.Cancel();
	  Thread.sleep(500);
	  Sm_page.Notification();
  }
  @Test(priority=17,description="APP-504:Save as New button.")
  public void Verify_as_new_buttons() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  Reporter.log("Verify Save as New button. ---------->>");
	  Sm_page.Creat_New_icon();
	  Thread.sleep(500);
	  Sm_page.Dispute_Status_Name("SM_dispute_status_name",arr.get(0)+" New"); 
	  Sm_page.Customer_letter("SM_Cus_letter", arr.get(1));
	  Sm_page.Block_Unblock_Customer(arr.get(2));
	  Sm_page.Block_Unblock_Invoices(arr.get(3));
	  Sm_page.Email_letter("SM_letter",arr.get(4));
	  Sm_page.Action_taker(arr.get(5));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Credit_Manager(arr.get(6));
	  Sm_page.Dispute_Manager(arr.get(7));
	  Sm_page.Account_Manager(arr.get(8));
	  Sm_page.Send_to(arr.get(9),arr.get(10));
	  Sm_page.Save_as_new();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Cancel();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  
  }
  
  @Test(priority=18,description="APP-505:linking status")
  public void Link_Statuses_to_Usergroups() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify linking status. ---------->>");
	  ev.Table_event(arr.get(11),"C_curr_admin_table");//Clicked on User Groups
	  ev.Table_event(arr.get(0),"SM_Statuses_table");        //Clicked Statuses table
	  Sm_page.link();
	  Thread.sleep(500);
	  Sm_page.SaveAll_Changes();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.reload();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  System.out.println("Newly Created Status is  linked Successfully");
  }
  @Test(priority=19,description="APP-506:Unlinking status")
  public void UnLink_Statuses_from_selected_Usergroups() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Unlinking status. ---------->>");
	  ev.Table_event(arr.get(0),"SM_Unlinked_statuses_table");//Clicked on Linked table
	  Sm_page.Unlink();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);	  
	  Sm_page.SaveAll_Changes();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.reload();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  System.out.println("Newly Created Status is  Unlinked Successfully");
  }
  @Test(priority=20,description="APP-500:Delete status")
  public void Delete_Newly_created_statues() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Status_Maintenance_Page Sm_page = new Status_Maintenance_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Delete status. ---------->>");
	  ev.Table_event(arr.get(0),"SM_Statuses_table");
	  Sm_page.Delete_icon();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  Thread.sleep(500);
	  Sm_page.Notification();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0),"SM_Statuses_table");
	  System.out.println("Newly Created Status is Deleted Successfully");
	  Reporter.log("<<======================{End: Status maintenance Section}=======================>> ");
  }
   
}
