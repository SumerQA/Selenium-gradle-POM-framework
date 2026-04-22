package Batch_rules;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import Onguard_Login_Functionality.Login;
import appMan_Pages.Email_Servers_page;
import appMan_Pages.Export_Settings_Page;
import appMan_Pages.Functional_Configration_Page;
import appMan_Pages.Home_index_Page;
import appMan_Pages.Printers_page;
import appMan_Pages.Technical_Configration_page;
import appMan_Pages.Batch_rules_page;
import appMan_Pages.queue_page;


@Listeners(ScreenShotOnFailure.class)
public class Batch_rules {
  @Test(priority=1)
  @Parameters({"Locale","Browser","URL", "ActiveUser", "ValidPassword", "NewPassword","UserGroup"})
  public void Open_Batch_Section(String Locale,String Browser,String URL, String ActiveUser, String ValidPassword, String NewPassword, String UserGroup) throws Exception {
		  
		  Login login = new Login();

		  try {
				WebDriverManager.startDriver(Browser, URL);  //https://192.168.0.179:4433/ApplicationManager
				WebDriver driver=WebDriverManager.getDriverInstance();
				queue_page qp = new queue_page(driver);
				login.Login_User(Locale, ActiveUser, ValidPassword, NewPassword,UserGroup);
				Thread.sleep(2000);
				qp.click_on_batch();
				Thread.sleep(5000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	
@Test(priority=2)
  public void Open_Batch_rules_page() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  Reporter.log("<<======================{batch Rules Tab}=======================>> ");
	  Reporter.log("===================>> Verify Batch rule Tab");
	  br_page.open_batch_rules_page();
	  Thread.sleep(1000);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Click_on_Create_New_Batch_rules_Icon() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  Reporter.log("===================>> Verify Create Icon");
	  br_page.Create_Icon();
	  Thread.sleep(500);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=4)
  public void Enter_Batch_rule_sets_Name() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  Reporter.log("===================>> Verify Create New batch rule sets.");
	  br_page.Enter_New_BatchRule("Weekly Email");
	  Thread.sleep(500);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5)
  public void Verify_Save_button() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  Reporter.log("===================>> Verify Save Icon.");
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=6)
  public void Update_Batch_rule() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  Reporter.log("===================>> Verify Update batch rule sets Functionality.");
	  br_page.update_batchRule("Weekly Email", "Weekly Email update");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(500);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7)
  public void Link_Batch_rule_to_MediaType_Print() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve =  new events(driver);
	  br_page.Create_Icon();
	  Thread.sleep(1000);
	  Reporter.log("===================>> Verify Create New batch rule sets.");
	  br_page.Enter_New_BatchRule("Batch Rule for Print");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  
	  eve.Click_event("App_Man");
	  Thread.sleep(500);
	  br_page.Render_Notifications();
	  Thread.sleep(1000);
	  
	  Home_index_Page HI_page = new Home_index_Page(driver);
	  HI_page.Select_Technical_Configration_Tab();
	  Thread.sleep(1000);
	  System.out.println("Technical Configration tab is clicked");
	  Technical_Configration_page TC_page = new Technical_Configration_page(driver);
	  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
	  TC_page.Printers_Tab();
	  Thread.sleep(1000);
	  HI_page.Render_Notifications();
	  System.out.println("Printers tab is clicked");
	  p_page.New_Printer_Settings_icon();
	  Thread.sleep(1000);
	  p_page.Printer_Name("Printer For Batch");
	  p_page.Description("Printer created for Batch rule");
	  p_page.Printer_Location("Foxit Reader PDF Printer");
	  p_page.Save_Printer_Settings_Changes();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(1000);
	  p_page.Notification();
	  queue_page qp = new queue_page(driver);
	  qp.click_on_batch();
	  Thread.sleep(1000);
	  
	  br_page.open_batch_rules_page();
	  Thread.sleep(1000);
	  
	  Reporter.log("===================>> Link Batch Rule to Media Type 'Print'.");
	  Thread.sleep(500);
	  eve.Table_event("Batch Rule for Print", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("0");
	  eve.Table_event("Printer For Batch", "output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(500);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=8)
  public void Link_Batch_rule_to_MediaType_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  br_page.Create_Icon();
	  Thread.sleep(1000);
	  br_page.Enter_New_BatchRule("Batch Rule for Email");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  eve.Click_event("App_Man");
	  Thread.sleep(500);
	  br_page.Render_Notifications();
	  Thread.sleep(1000);
	  
	  Home_index_Page HI_page = new Home_index_Page(driver);
	  HI_page.Select_Technical_Configration_Tab();
	  Thread.sleep(1000);
	  System.out.println("Technical Configration tab is clicked");
	  Technical_Configration_page TC_page = new Technical_Configration_page(driver);
	  TC_page.Email_Servers_Tab();
	  Thread.sleep(1000);
	  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
	  Thread.sleep(1000);
	  ES_page.New_Email_Server_icon();
	  Thread.sleep(1000);
	  ES_page.Purpose_Server_settings("Email server");
	  Thread.sleep(2000);
	  ES_page.Server_Name("Email Server for batch");
	  ES_page.Description("Email Server Created for batch Rule");
	  Reporter.log("Select Authentication Type ");
	  ES_page.AuthenticationType("0");
	  Thread.sleep(500);
	  ES_page.UserName("qa.email@sdnatech.com");
	  Thread.sleep(500);
	  ES_page.Password("sdna@1234");
	  ES_page.Check_Password("sdna@1234");
	  Thread.sleep(500);
	  ES_page.Email_Address("qa.email@sdnatech.com");
	  Thread.sleep(500);
	  ES_page.Use_Encryption("Yes");
	  Thread.sleep(500);
	  ES_page.Save_Email_Server_Changes();
	  Thread.sleep(3000);
	  ES_page.Notification();
	  Thread.sleep(1000);
	  ES_page.Notification();
	  
	  queue_page qp = new queue_page(driver);
	  qp.click_on_batch();
	  Thread.sleep(1000);
	  
	  br_page.open_batch_rules_page();
	  Thread.sleep(1000);
	  
	  Reporter.log("===================>> Link Batch Rule to Media Type 'Email'.");
	  eve.Table_event("Batch Rule for Email", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("1");
	  eve.Table_event("Email Server for batch", "output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=9)
  public void Link_Batch_rule_to_MediaType_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  br_page.Create_Icon();
	  Thread.sleep(1500);
	  br_page.Enter_New_BatchRule("Batch Rule for Export");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  
	  eve.Click_event("App_Man");
	  Thread.sleep(500);
	  br_page.Render_Notifications();
	  Thread.sleep(1000);
	  
	  Home_index_Page HI_page = new Home_index_Page(driver);
		HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(1000);
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Export_Settings_tab();
		Thread.sleep(1000);
		Export_Settings_Page x_page = new Export_Settings_Page(driver);
		Thread.sleep(500);
		HI_page.Render_Notifications();
		x_page.Creat_New_icon();
		Thread.sleep(500);
		x_page.Export_Name("ES_Exp_Name","Export for batch");
		Thread.sleep(500);
		x_page.Description("ES_Desc", "Export Created for batch rule");
		Thread.sleep(500);
		x_page.Export_type("ES_Exp_type", "1");//batch Export
		Thread.sleep(500);
		x_page.Export_Format("ES_Exp_Format", "4");//Letter to File
		Thread.sleep(500);
		x_page.Document_type("ES_Doc_type", "1");//PDF
		Thread.sleep(500);
		x_page.Unique_Identifier("ES_Unique_Identifier","4");//Invoice number_TemplateName
		Thread.sleep(500);
		x_page.Date("ES_Date", "2");//_ddmmyyyy suffix
		Thread.sleep(1000);
		x_page.Save_Changes();
		Thread.sleep(1000);
		x_page.Notification();
	    Thread.sleep(500);
		x_page.Notification();
		driver.navigate().refresh();
		Thread.sleep(500);
		
		queue_page qp = new queue_page(driver);
		qp.click_on_batch();
		Thread.sleep(1000);
	    br_page.open_batch_rules_page();
	    Thread.sleep(1000);
	  
	  Reporter.log("===================>> Link Batch Rule to Media Type 'Export'.");
	  eve.Table_event("Batch Rule for Export", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("3");
	  Thread.sleep(1000);
	  eve.Table_event("Export for batch", "output_mediaType_table");
	  Thread.sleep(1000);
	  eve.Table_event("Batch Rule for Export", "batchrule_sets_table");
	  Thread.sleep(1000);
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Export_path("br_xport_to_File_path", "C");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=10)
  public void Link_Batch_rule_to_MediaType_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  br_page.Create_Icon();
	  Thread.sleep(1000);
	  br_page.Enter_New_BatchRule("Batch Rule for SMS");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(500);
	  br_page.Notification();
	  Reporter.log("===================>> Link Batch Rule to Media Type 'SMS'.");
	  eve.Table_event("Batch Rule for SMS", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("4");
	  eve.Table_event("Email Server for batch", "output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=11)
  public void Link_Batch_rule_to_MediaType_Others() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  br_page.Create_Icon();
	  Thread.sleep(1000);
	  br_page.Enter_New_BatchRule("Batch Rule for Others");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("===================>> Link Batch Rule to Media Type 'Others'.");
	  eve.Table_event("Batch Rule for Others", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("5");
	  eve.Table_event("Delete", "output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=12)
  public void Sort_Linked_Output_Media_Type() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Reporter.log("===================>> Sort Linked Output_Media Type.");
	  Thread.sleep(500);
	  eve.Table_event("Batch Rule for Email", "batchrule_sets_table");
	  Thread.sleep(500);
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  eve.Sort_From_Table("batchrule_linkedGrid_table", "Delete", "1");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13)
  public void Unlink_Batch_rule() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(500);
	  Reporter.log("===================>> Unlink Batch Rule.");
	  eve.Table_event("Batch Rule for Others", "batchrule_sets_table");
	  Thread.sleep(1000);
	  eve.Table_event("Delete", "batchrule_linkedGrid_table");
	  Thread.sleep(500);
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Unlink_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=14)
  public void Link_Multiple_Batch_rules_to_MediaType_Print() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(500);
	  Reporter.log("===================>> Link Multiple Batch Rule to Media Type 'Print'.");
	  eve.Table_event("Batch Rule for Print", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("0");
	  eve.Drag_and_Drop("output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=15)
  public void Link_Multiple_Batch_rules_to_MediaType_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(500);
	  Reporter.log("===================>> Link Multiple Batch Rule to Media Type 'Email'.");
	  eve.Table_event("Batch Rule for Email", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("1");
	  Thread.sleep(1000);
	  eve.Drag_and_Drop("output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(1000);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=16)
  public void Link_Multiple_Batch_rules_to_MediaType_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(1000);
	  Reporter.log("===================>> Link Multiple Batch Rule to Media Type 'Export'.");
	  eve.Table_event("Batch Rule for Export", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("3");
	  Thread.sleep(1000);
	  eve.Drag_and_Drop("output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(1000);
	  Thread.sleep(500);
	  br_page.Export_path("br_xport_to_File_path", "D");
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=17)
  public void Link_Multiple_Batch_rules_to_MediaType_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Reporter.log("===================>> Link Multiple Batch Rule to Media Type 'SMS'.");
	  Thread.sleep(500);
	  eve.Table_event("Batch Rule for SMS", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("4");
	  Thread.sleep(1000);
	  eve.Drag_and_Drop("output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1000);
	  br_page.Link_Icon();
	  Thread.sleep(1000);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=18)
  public void Link_Multiple_Batch_rules_to_MediaType_Others() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Reporter.log("===================>> Link Multiple Batch Rule to Media Type 'Others'.");
	  Thread.sleep(1000);
	  eve.Table_event("Batch Rule for Others", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("5");
	  Thread.sleep(1000);
	  eve.Drag_and_Drop("output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1000);
	  br_page.Link_Icon();
	  Thread.sleep(1000);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=19)
  public void UnLink_Multiple_Batch_rules() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(500);
	  Reporter.log("===================>> Unlink Multiple Batch Rule.");
	  eve.Table_event("Batch Rule for Email", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("4");
	  Thread.sleep(1000);
	  eve.Drag_and_Drop("batchrule_linkedGrid_table");
	  br_page.Change_Icon();
	  Thread.sleep(1000);
	  br_page.Unlink_Icon();
	  Thread.sleep(1000);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=20)
  public void Link_Batch_rules_to_MediaType_Email_for_Export_Rule() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(500);
	  Reporter.log("===================>> Link Multiple Batch Rule to Media Type 'Email'.");
	  eve.Table_event("Batch Rule for Email", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("1");
	  Thread.sleep(1000);
	  eve.Drag_and_Drop("output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(1000);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=21)
  public void Delete_Batch_rule() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  Reporter.log("===================>> Delete Batch Rule.");
	  Thread.sleep(1500);
	  eve.Table_event("Weekly Email update", "batchrule_sets_table");
	  Thread.sleep(1000);
	  br_page.Delete_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  Thread.sleep(1000);
	  br_page.Notification();
	  br_page.Reload_Icon();
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=22)
  public void Create_BatchRule_for_NON_SSL_EmailServer() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  br_page.Create_Icon();
	  Thread.sleep(1000);
	  br_page.Enter_New_BatchRule("Batch Rule for Non SSL Email");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("===================>> Link Batch Rule to Media Type 'Email'.");
	  eve.Table_event("Batch Rule for Non SSL Email", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("1");
	  eve.Table_event("Non SSL Email server", "output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(1500);
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("----------------------------------------");
  }
}
