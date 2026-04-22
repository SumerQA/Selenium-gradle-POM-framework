package Import_Manager.Import_sources_Tab_Functionality;

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
import appMan_Pages.Home_index_Page;
import appMan_Pages.Import_Sources_Page;
@Listeners(ScreenShotOnFailure.class)
public class Import_sources {
	WebDriverManager mgr = new  WebDriverManager();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("IM_Import_Sources");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
			//System.out.println(arr.size());
	}
  @Test(priority=1)
  public void Open_Import_sources_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Home_index_Page HI_page= PageFactory.initElements(driver, Home_index_Page.class);
	  Import_Sources_Page ImpS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  Reporter.log("<<======================{Import manager -Import Sources}=======================>> ");
	  Thread.sleep(1500);
	  HI_page.Select_Import_Manager_Tab();
	  Thread.sleep(1500);
	  ImpS_page.Clickon_import_sources_Tab();
	  Thread.sleep(1000);
  }
  
  @Test(priority=2,description="APP-579:Create import source button")
  public void Create_Import_sources_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  Reporter.log("********APP-579:Create import source button ********");
	  IS_page.Clickon_Create_New_Icon();
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-579  ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority=3)
  public void Enter_Required_Fields_in_General_Settings_section() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Enter_Import_Sources_name(arr.get(0));
	  Thread.sleep(500);
	  IS_page.Check_Financial_Interface_checkbox(arr.get(1));
	  Thread.sleep(500);
	  IS_page.link_to_Administration(arr.get(2));
	  Thread.sleep(500);
	  IS_page.Customer_XML_Path(arr.get(3));
	  Thread.sleep(300);
	  IS_page.Invoice_XML_Path(arr.get(4));
	  Thread.sleep(300);
	  IS_page.import_LogFile_Path(arr.get(5));
	  Thread.sleep(300);
	  }
  @Test(priority=4)
  public void Enter_Required_Fields_in_Advance_Settings_section() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Advanced_Settings_Tab();
	  if(driver.findElement(By.xpath("//*[@id='ImportDayChangeTime']")).isDisplayed()){
		  IS_page.Auto_act_of_new_customers_at_import(arr.get(6));
		  IS_page.Aut_act_of_cust_scoring_for_new_customers(arr.get(7));
		  IS_page.Imp_after_this_hour_seenas_next_day_DDList(arr.get(8));
		  IS_page.Invoice_due_date_checkbox(arr.get(9),arr.get(10),arr.get(11));                                          
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
		  IS_page.Skip_when_invoice_row_invalid_Checkbox(arr.get(14),arr.get(15));
	  }else{
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
	  }
	  }
  @Test(priority=5)
  public void Enter_Required_Fields_in_Schedule_Settings_section() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Scheduled_Settings_Tab();
	  Thread.sleep(500);
	  IS_page.Run_customer_import_fileson(arr.get(16));
	  IS_page.Run_invoice_import_fileson(arr.get(17));
  }
 
  @Test(priority=6)
  public void Save_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.clickon_Save_IM_Change_icon();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  driver.navigate().refresh();
	  Thread.sleep(500);
  }
  @Test(priority=7)
  public void Create_sources_to_link_with_ImportSource() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Clickon_Create_New_Icon();
	  Thread.sleep(1000);
	  IS_page.Enter_Import_Sources_name("New IMPSRC");
	  Thread.sleep(500);
	  IS_page.Check_Financial_Interface_checkbox("No");
	  Thread.sleep(500);
	  IS_page.link_to_Administration(arr.get(2));
	  Thread.sleep(500);
	  IS_page.Customer_XML_Path(arr.get(3));
	  Thread.sleep(300);
	  IS_page.Invoice_XML_Path(arr.get(4));
	  Thread.sleep(300);
	  IS_page.import_LogFile_Path(arr.get(5));
	  Thread.sleep(300);
	  IS_page.Advanced_Settings_Tab();
	  if(driver.findElement(By.xpath("//*[@id='ImportDayChangeTime']")).isDisplayed()){
		  IS_page.Auto_act_of_new_customers_at_import(arr.get(6));
		  IS_page.Aut_act_of_cust_scoring_for_new_customers(arr.get(7));
		  IS_page.Imp_after_this_hour_seenas_next_day_DDList(arr.get(8));
		  IS_page.Invoice_due_date_checkbox(arr.get(9),arr.get(10),arr.get(11));                                          
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
		  IS_page.Skip_when_invoice_row_invalid_Checkbox(arr.get(14),arr.get(15));
	  }else{
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
	  }
	  Enter_Required_Fields_in_Schedule_Settings_section();
	  IS_page.clickon_Save_IM_Change_icon();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=8)
  public void Create_sources_to_link_with_ImportSource_For_Google() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Clickon_Create_New_Icon();
	  Thread.sleep(1000);
	  IS_page.Enter_Import_Sources_name("ISource with Google email settings");
	  Thread.sleep(500);
	  IS_page.Check_Financial_Interface_checkbox("No");
	  Thread.sleep(500);
	  IS_page.link_to_Administration(arr.get(2));
	  Thread.sleep(500);
	  IS_page.Customer_XML_Path(arr.get(3));
	  Thread.sleep(300);
	  IS_page.Invoice_XML_Path(arr.get(4));
	  Thread.sleep(300);
	  IS_page.import_LogFile_Path(arr.get(5));
	  Thread.sleep(300);
	  IS_page.Advanced_Settings_Tab();
	  if(driver.findElement(By.xpath("//*[@id='ImportDayChangeTime']")).isDisplayed()){
		  IS_page.Auto_act_of_new_customers_at_import(arr.get(6));
		  IS_page.Aut_act_of_cust_scoring_for_new_customers(arr.get(7));
		  IS_page.Imp_after_this_hour_seenas_next_day_DDList(arr.get(8));
		  IS_page.Invoice_due_date_checkbox(arr.get(9),arr.get(10),arr.get(11));                                          
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
		  IS_page.Skip_when_invoice_row_invalid_Checkbox(arr.get(14),arr.get(15));
	  }else{
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
	  }
	  Enter_Required_Fields_in_Schedule_Settings_section();
	  IS_page.SMTP_Settings_Tab();
	  Thread.sleep(800);
	  IS_page.clickon_Save_IM_Change_icon();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=9)
  public void Create_sources_to_link_with_ImportSource_with_Microsoft_OauthSettings() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Clickon_Create_New_Icon();
	  Thread.sleep(1000);
	  IS_page.Enter_Import_Sources_name("ISource with Microsoft email settings");
	  Thread.sleep(500);
	  IS_page.Check_Financial_Interface_checkbox("No");
	  Thread.sleep(500);
	  IS_page.link_to_Administration(arr.get(2));
	  Thread.sleep(500);
	  IS_page.Customer_XML_Path(arr.get(3));
	  Thread.sleep(300);
	  IS_page.Invoice_XML_Path(arr.get(4));
	  Thread.sleep(300);
	  IS_page.import_LogFile_Path(arr.get(5));
	  Thread.sleep(300);
	  IS_page.Advanced_Settings_Tab();
	  if(driver.findElement(By.xpath("//*[@id='ImportDayChangeTime']")).isDisplayed()){
		  IS_page.Auto_act_of_new_customers_at_import(arr.get(6));
		  IS_page.Aut_act_of_cust_scoring_for_new_customers(arr.get(7));
		  IS_page.Imp_after_this_hour_seenas_next_day_DDList(arr.get(8));
		  IS_page.Invoice_due_date_checkbox(arr.get(9),arr.get(10),arr.get(11));                                          
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
		  IS_page.Skip_when_invoice_row_invalid_Checkbox(arr.get(14),arr.get(15));
	  }else{
		  IS_page.Unique_invoice_Key_Checkbox(arr.get(12),arr.get(13));
	  }
	  Enter_Required_Fields_in_Schedule_Settings_section();
	  IS_page.SMTP_Settings_Tab();
	  Thread.sleep(800);
	  IS_page.clickon_Save_IM_Change_icon();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(800);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=10,description="APP-582:Unique import source name")
  public void Check_Unique_Import_sources_Name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  Reporter.log("********APP-582:Unique import source name********");
	  IS_page.Clickon_Create_New_Icon();
	  Thread.sleep(500);
	  IS_page.Enter_Import_Sources_name(arr.get(0));
	  Thread.sleep(500);
	  IS_page.clickon_Save_IM_Change_icon();
	  Thread.sleep(2000);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(2000);
	  IS_page.Save_changes_Notification();
	  Reporter.log("********End :TestCase- APP-582  ********");
	  Reporter.log("----------------------------------------");
	  }
  
  @Test(priority=11,description="APP-580: Update import source button")
  public void Update_Import_sources_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  events eve = new events(driver);
	  Reporter.log("********APP-580: Update import source button********");
	  eve.Table_event(arr.get(0), "Import_sources_table");
	  IS_page.Cancel_changes_Notification();
	  Thread.sleep(500);
	  IS_page.ImportSources_Edit_icon();
	  Thread.sleep(500);
	  IS_page.Check_Editable_Field();
	  IS_page.Reload();
	  Thread.sleep(500);
	  IS_page.clickon_Save_IM_Change_icon();
	  Thread.sleep(1000);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(1000);
	  IS_page.Save_changes_Notification();
	  Reporter.log("********End :TestCase- APP-580  ********");
	  Reporter.log("----------------------------------------");
  }
 
  @Test(priority=12)
  public void Delete_source_Linked_to_Import_sources() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Reporter.log("********APP-581:Delete import source button********");
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  eve.Table_event(arr.get(0), "Import_sources_table");
	  Thread.sleep(500);
	  IS_page.Delete_icon();
	  Thread.sleep(500);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(500);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(500);
	  eve.Click_event("sort_Import_sources_table");
	  Thread.sleep(500);
	  eve.Table_event("New IMPSRC", "Import_sources_table");
	  Thread.sleep(500);
	  IS_page.Delete_icon();
	  Thread.sleep(500);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(500);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(100);
	  Reporter.log("********End :TestCase- APP-581  ********");
	  Reporter.log("----------------------------------------");
  }
} 
