package Functional_Configration.Payment_schemes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Payment_Scheme_Page;
@Listeners(ScreenShotOnFailure.class)
public class Payment_schemes {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Payment_schemes");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Payment_schemes_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page ps_page = new Payment_Scheme_Page(driver);
	  Reporter.log("<<======================{Payment schemes Tab}=======================>> ");
	  ps_page.Goto_Payment_Scheme_page();
	  Thread.sleep(500);
	  System.out.println("Payment schemes Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Payment_scheme_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Payment_scheme_Name("PS_name",arr.get(0));
	  System.out.println(arr.get(0) + "is Entered in Payment Scheme name Field");
  }
  @Test(priority=4)
  public void Enter_No_of_Expected_payments() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Number_ofExpected_payments("PS_No_of_Expe_payments", arr.get(1));
	  System.out.println(arr.get(1) + "  :is Entered in the Number of ExpectedPayments Field");
  }
  @Test(priority=5)
  public void Enter_Payment_Every_Weekormonth() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Payment_Every("PS_Payment_Every_input",arr.get(2),arr.get(3));
	  Thread.sleep(700);
  }
  @Test(priority=6)
  public void Select_round_Payment_to() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Round_payment_to("PS_round_payment_to",arr.get(4));
	  System.out.println("Item is selected from round payment to DDlist");
	  Thread.sleep(700);
  }
  @Test(priority=7)
  public void Enter_Control_Days() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Control_days("PS_control_days", arr.get(5));
	  System.out.println("value is inserted in control days Field");
	  Thread.sleep(700);
  }
  @Test(priority=8)
  public void Delete_All_Active_Actions_Checkbox() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Delete_All_Active_Actions("PS_Delete_all_active_action",arr.get(6));
	  System.out.println("Delete All Active action check box is selected");
	  Thread.sleep(700);
  }
  @Test(priority=9)
  public void Check_Block_Invoice_Checkbox() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Block_Invoices("PS_Block_Invoice",arr.get(7));
	  System.out.println("Block Invoice Check box is selected");
	  Thread.sleep(700);
  }
  @Test(priority=10)
  public void Select_Send_letter_On_Registration() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Checkbox_DDlist_dependencies(arr.get(8),arr.get(9),"PS_send_letter_checkbox","PS_send_letter_ddlist");
	  Thread.sleep(700);
  }
  @Test(priority=11)
  public void Select_Send_Letter_On_Update_Checkbox() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Checkbox_DDlist_dependencies(arr.get(8),arr.get(9), "PS_send_letter_on_update", "PS_send_letter_on_update_ddlist");
	  System.out.println("On Update- Send Letter checkbox is Checked");
	  Thread.sleep(700);
  }
    
  @Test(priority=12)
  public void Check_generate_telephone_action_OnOverdue() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Generate_Telephone_Action_onOverdue(arr.get(10));
	  System.out.println("On overdue- Generate telephone action checkbox is checked");
	  Thread.sleep(700);
  }
  @Test(priority=13)
  public void Select_Send_letter_On_Overdue() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Checkbox_DDlist_dependencies(arr.get(11),arr.get(12),"PS_send_letters_onOverdue", "PS_send_letters_onOverdue_ddlist");
	  Thread.sleep(700);
  }
  @Test(priority=14)
  public void Check_generate_telephone_action_On_Completion() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Generate_Telephone_Action_onCompletion("OnCompletionTelephoneAction",arr.get(13));
	 
	  Thread.sleep(700);
  }
  @Test(priority=15)
  public void Select_Send_letter_On_Completion() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Checkbox_DDlist_dependencies(arr.get(14),arr.get(15),"PS_send_letters_oncomp", "PS_send_letters_onComp_ddlist");
	  Thread.sleep(700);
  }
 
  @Test(priority=16)
  public void Save_andClose_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Save_and_Close();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  
  }
  @Test(priority=17,description="APP-529:Check mandatory fields")
  public void Verify_mandatory_fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.Save_and_Close();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  c_page.Close();
  }
  
  @Test(priority=18,description="APP-528:unique payment scheme name")
  public void Verify_unique_Payment_schemes_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1500);
	  c_page.Payment_scheme_Name("PS_name",arr.get(0));
	  c_page.Number_ofExpected_payments("PS_No_of_Expe_payments", arr.get(1));
	  c_page.Payment_Every("PS_Payment_Every_input",arr.get(2),arr.get(3));
	  c_page.Round_payment_to("PS_round_payment_to",arr.get(4));
	  c_page.Control_days("PS_control_days", arr.get(5));
	  c_page.Save_and_Close();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Close();
  }
  
  @Test(priority=19,description="APP-520:Payment schemes>>For Reload, Save and cancel button")
  public void Verify_Save_cancel_button_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1500);
	  c_page.Payment_scheme_Name("PS_name",arr.get(0)+"Test");
	  c_page.Number_ofExpected_payments("PS_No_of_Expe_payments", "10");
	  c_page.Payment_Every("PS_Payment_Every_input",arr.get(2),"10");
	  c_page.Round_payment_to("PS_round_payment_to","10");
	  c_page.Control_days("PS_control_days", "10");
	  c_page.Save();
	  Thread.sleep(1500);
	  c_page.Notification();
	  c_page.Close();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(2000);
  }
  @Test(priority=20,description="APP-520:Payment schemes>>For Reload, Save and cancel button")
  public void Verify_Reload_button_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1500);
	  c_page.Payment_scheme_Name("PS_name",arr.get(0)+" Reload");
	  c_page.Number_ofExpected_payments("PS_No_of_Expe_payments", "10");
	  c_page.Payment_Every("PS_Payment_Every_input",arr.get(2),"10");
	  c_page.Round_payment_to("PS_round_payment_to","10");
	  c_page.Control_days("PS_control_days", "10");
	  c_page.Refresh();
	  Thread.sleep(1000);
	  c_page.Close();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
  }
 
 @Test(priority=21,description="APP-521:Payment schemes>>'Save as New' and 'Save and Close' button")
  public void Verify_Save_as_New_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1500);
	  c_page.Payment_scheme_Name("PS_name",arr.get(0)+"Test");
	  c_page.Number_ofExpected_payments("PS_No_of_Expe_payments", "10");
	  c_page.Payment_Every("PS_Payment_Every_input",arr.get(2),"10");
	  c_page.Round_payment_to("PS_round_payment_to","10");
	  c_page.Control_days("PS_control_days", "10");
	  c_page.Save_as_new();
	  Thread.sleep(1500);
	  c_page.Notification();
	  c_page.Close();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=22,description="APP-522:Linking>>Payment schemes")
  public void Link_payment_schemes_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(16), "C_curr_admin_table");
	  eve.Table_event(arr.get(0), "PS_payment_Scheme_table");
	  Thread.sleep(1000);
	  c_page.link();
	  Thread.sleep(1000);
	  c_page.Save_Changes();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(300);
	  c_page.Refresh_panal();
	  Thread.sleep(1500);
	  c_page.Notification();
  }
 
  @Test(priority=23,description="APP-527:Deleting a payment schemes")
  public void Delete_Linked_Payment_scheme() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "PS_payment_Scheme_table");
	  c_page.Delete_icon();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(1500);
	  c_page.Notification();
	  }
  
 @Test(priority=24,description="APP-523:Unlinking>>Payment scheme")
  public void UnLink_Payment_scheme_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "PS_payment_scheme_linked");
	  c_page.Unlink();
	  Thread.sleep(1500);
	  c_page.Save_Changes();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(300);
	  c_page.Refresh_panal();
	  Thread.sleep(1500);
	  c_page.Notification();
	  
	  }
  @Test(priority=25,description="APP-527:Deleting a payment schemes")
  public void Delete_Payment_scheme() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_Scheme_Page c_page = new Payment_Scheme_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "PS_payment_Scheme_table");
	  c_page.Delete_icon();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(1500);
	  c_page.Notification();
	  c_page.Save_Changes();
	  Thread.sleep(1500);
	  c_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "PS_payment_Scheme_table");
	  Reporter.log("<------------------------{End of Payment schemes Tabe}------------------------>");
	  }
}
