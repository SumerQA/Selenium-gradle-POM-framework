package Functional_Configration.Interest_schemes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Documents_and_templetes_Page;
import appMan_Pages.Functional_Configration_Page;
import appMan_Pages.Interest_Schemes_Page;
@Listeners(ScreenShotOnFailure.class)
public class Interest_schemes {
	ReadXclData rddata=new ReadXclData();
	Common c= new Common();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Interest_schemes");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Interest_schemes_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  Reporter.log("<<======================{Interest schemes Tab}=======================>> ");
	  IS_page.Goto_Interest_Scheme_page();
	  Thread.sleep(1500);
	  System.out.println("Interest schemes Page is opened");
  }
 @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Interest_schemes_Name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0));
	  System.out.println(arr.get(0) + "is Entered in Interest Scheme name Field");
	  Thread.sleep(700);
  }
  @Test(priority=4)
  public void Enter_Description() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Description("is_Desc_Input_field", arr.get(1));
	  System.out.println(arr.get(1) + "  :is Entered in the Description Input Field");
	  Thread.sleep(700);
  }
  @Test(priority=5)
  public void Select_items_from_Calculate_from_DDlist() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input",arr.get(2),arr.get(3));
	  Thread.sleep(700);
  }
  @Test(priority=6)
  public void Select_Currency_from_DDlist() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Currency("is_currency_ddlist",arr.get(4));
	  Thread.sleep(700);
  }
  @Test(priority=7)
  public void Enter_Threshold_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	  Thread.sleep(700);
  }
  @Test(priority=8)
  public void Select_Include_paid_invoices() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	  Thread.sleep(700);
  }
  
  @Test(priority=9)
  public void Save_andClose_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve= new events(driver);
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Save_and_Close();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  if(driver.findElement(By.xpath(c.getElementName("is_Cancel_icon"))).isDisplayed()){
		   String tt=eve.GetText("Save_changes_notification_Message");
			IS_page.Close();
			Thread.sleep(1000);
			throw new ElementNotInteractableException(tt);
			
		 }
  }
  @Test(priority=10)
  public void Verify_Save_cancel_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0)+ "Save");
	  IS_page.Description("is_Desc_Input_field", arr.get(1));
	  IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input",arr.get(2),arr.get(3));
	  IS_page.Currency("is_currency_ddlist",arr.get(4));
	  IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	  IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	  Thread.sleep(1000);
	  IS_page.Save();
	  Thread.sleep(500);
	  IS_page.Notification();
	  IS_page.Close();
	  Thread.sleep(2000); 
	
	  
  }
  @Test(priority=11)
  public void Verify_mandatory_fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Creat_New_icon();
	  Thread.sleep(1000);
	  IS_page.Save_and_Close();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  IS_page.Close();
	  Thread.sleep(2000);
  }
  
  @Test(priority=12)
  public void Verify_unique_Interest_schemes_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0));
	  IS_page.Description("is_Desc_Input_field", arr.get(1));
	  IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input",arr.get(2),arr.get(3));
	  IS_page.Currency("is_currency_ddlist",arr.get(4));
	  IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	  IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	  IS_page.Save_and_Close();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Close();
	  Thread.sleep(2000);
  }
  @Test(priority=13)
  public void Verify_mandatory_Fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Creat_New_icon();
	  Thread.sleep(1500);
	 // IS_page.Interest_scheme_Name("PS_name",arr.get(0));
	  IS_page.Description("is_Desc_Input_field", arr.get(1));
	  IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input",arr.get(2),arr.get(3));
	  IS_page.Currency("is_currency_ddlist",arr.get(4));
	  IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	  IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	  IS_page.Save_and_Close();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0));
	  IS_page.Description("is_Desc_Input_field", arr.get(1));
	  IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input",arr.get(2),arr.get(3));
	  IS_page.Currency("is_currency_ddlist",arr.get(4));
	  IS_page.Clear_Threshold_value("is_ThresholdValue");
	  IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	  Thread.sleep(1000);
	  IS_page.Save_and_Close();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Notification();
	  Thread.sleep(1000);
	  IS_page.Close();
	  Thread.sleep(2000);
  }
  
  
 
 @Test(priority=14)
  public void Verify_Save_as_New_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  IS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0)+" Save as New");
	  IS_page.Description("is_Desc_Input_field", arr.get(1));
	  IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input",arr.get(2),arr.get(3));
	  IS_page.Currency("is_currency_ddlist",arr.get(4));
	  IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	  IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	  Thread.sleep(1000);
	  IS_page.Save_as_new();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  IS_page.Close();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  Thread.sleep(1500);
	  
  }
   @Test(priority=15)
 public void Verify_Calculate_From_Due_Date() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	 Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
     IS_page.Creat_New_icon();
	 Thread.sleep(1500);
	 IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0)+" Due Date");
	 IS_page.Description("is_Desc_Input_field", arr.get(1));
	 IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input","1",arr.get(3));//1 is For Due date option DDlist value
	 IS_page.Currency("is_currency_ddlist",arr.get(4));
	 IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	 IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	 Thread.sleep(1000);
	 IS_page.Save();
	 Thread.sleep(1500);
	 IS_page.Notification();
	 IS_page.Close();
	 Thread.sleep(1500);
	 IS_page.Notification();
	 Thread.sleep(1500);
	 
	  
  }
 @Test(priority=16)
 public void Verify_Calculate_From_Test_Date() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	 Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
     IS_page.Creat_New_icon();
	 Thread.sleep(1500);
	 IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0)+" Test Date");
	 IS_page.Description("is_Desc_Input_field", arr.get(1));
	 IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input","2",arr.get(3));//2 is For Test date option DDlist value
	 IS_page.Currency("is_currency_ddlist",arr.get(4));
	 IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	 IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	 Thread.sleep(1000);
	 IS_page.Save();
	 Thread.sleep(1500);
	 IS_page.Notification();
	 IS_page.Close();
	 Thread.sleep(1500);
	 IS_page.Notification();
	 Thread.sleep(1500);
	 
	  
  }
 @Test(priority=17)
 public void Verify_Calculate_From_Due_and_X_days() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	 Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
     IS_page.Creat_New_icon();
	 Thread.sleep(1500);
	 IS_page.Interest_scheme_Name("is_is_name_input_field",arr.get(0)+" Due& X days");
	 IS_page.Description("is_Desc_Input_field", arr.get(1));
	 IS_page.Calculate_From("is_Cal_from_Ddlist","is_Cal_from_input","3",arr.get(3)); //3 is For Due+ X-days option DDlist value
	 IS_page.Currency("is_currency_ddlist",arr.get(4));
	 IS_page.Threshold_value("is_ThresholdValue", arr.get(5));
	 IS_page.Include_paid_invoice("is_include_paid_invoices",arr.get(6));
	 Thread.sleep(1500);
	 IS_page.Save();
	 Thread.sleep(1500);
	 IS_page.Notification();
	 IS_page.Close();
	 Thread.sleep(1500);
	 IS_page.Notification();
	 Thread.sleep(1500); 
  }
 
@Test(priority=18)
 public void Verify_Interest_schemes_in_Dunning_letters() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	 Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	 Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
	 Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	 c_page.Goto_communication_page();
	 Thread.sleep(2000);
	 c_page.Click_on_Documents_and_templetes_tab();
	 Thread.sleep(1500);
	 IS_page.Notification_No();
	 Thread.sleep(3000);
	 c_page.Creat_New_icon();
	 Thread.sleep(1500);
	 c_page.Interest_Scheme("com_int_scheme", arr.get(0)+" Due& X days");
	 Thread.sleep(1000);
	 c_page.Cancel();
	 Thread.sleep(1500);
	 c_page.Notification();
	 Thread.sleep(1000);
	 c_page.Notification();
	 FC_page.Click_interest_Scheme_tab();
	 Thread.sleep(1500);
	 IS_page.Notification_No();	
  }
 @Test(priority=19)
 public void Add_Interest_persantage() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+ "Save", "is_Interest_Schemes_table");
	  Thread.sleep(1000);
	  IS_page.Update_icon();
	  Thread.sleep(2000);
	  IS_page.Add_Interest("is_int_persnt_table","12");
	  Thread.sleep(1000);
	  IS_page.Save();
	  Thread.sleep(1500);
      IS_page.Notification();
      Thread.sleep(1500);
      IS_page.Notification();
	  IS_page.Close();
      Thread.sleep(1500);
	  IS_page.Notification();
      Thread.sleep(1500); 
 }
 @Test(priority=20)
 public void Update_Interest_persantage() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+ "Save", "is_Interest_Schemes_table");
	  Thread.sleep(1000);
	  IS_page.Update_icon();
	  Thread.sleep(2000);
	  IS_page.Update_Interest("is_int_persnt_table","12","1.25");
	  Thread.sleep(1000);
	  IS_page.Save();
	  Thread.sleep(1500);
      IS_page.Notification();
      Thread.sleep(1500);
      IS_page.Notification();
	  IS_page.Close();
      Thread.sleep(1500);
	  IS_page.Notification();
     
 }
 @Test(priority=21)
 public void Update_Interest_persantage_Date() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+ "Save", "is_Interest_Schemes_table");
	  Thread.sleep(1000);
	  IS_page.Update_icon();
	  Thread.sleep(2000);
	  IS_page.Update_Interest_date("is_int_persnt_table","1.25","11");
	  Thread.sleep(1000);
	  IS_page.Save();
	  Thread.sleep(1500);
      IS_page.Notification();
      Thread.sleep(1500);
      IS_page.Notification();
	  IS_page.Close();
      Thread.sleep(1500);
	  IS_page.Notification();
     
 }
 @Test(priority=22)
 public void Link_Interest_schemes_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(8), "is_Admin_table");
	  eve.Table_event(arr.get(0), "is_Interest_Schemes_table");
	  Thread.sleep(1000);
	  IS_page.link();
	  Thread.sleep(1000);
	  IS_page.Save_Panel_Changes();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  Thread.sleep(300);
	  IS_page.Refresh_panal();
	  Thread.sleep(1500);
	  IS_page.Notification();
  }
 @Test(priority=23)
 public void Delete_Linked_Interest_schemes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "is_Interest_Schemes_table");
	  IS_page.Delete_icon();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  }
 
 @Test(priority=24)
 public void UnLink_Interest_schemes_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "is_linked_int_schemes_tables");
	  IS_page.Unlink();
	  Thread.sleep(1500);
	  IS_page.Save_Panel_Changes();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  Thread.sleep(300);
	  IS_page.Refresh_panal();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  }
 @Test(priority=25)
 public void Delete_Interest_schemes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Interest_Schemes_Page IS_page = new Interest_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "is_Interest_Schemes_table");
	  IS_page.Delete_icon();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  IS_page.Save_Panel_Changes();
	  Thread.sleep(1500);
	  IS_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "is_Interest_Schemes_table");
	  Reporter.log("<------------------------{End of Interest schemes Tab}------------------------>");
	 } 
 
}
