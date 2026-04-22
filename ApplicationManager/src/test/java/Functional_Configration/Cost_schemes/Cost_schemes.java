package Functional_Configration.Cost_schemes;

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
import appMan_Pages.Cost_Schemes_Page;
import appMan_Pages.Documents_and_templetes_Page;
import appMan_Pages.Functional_Configration_Page;
@Listeners(ScreenShotOnFailure.class)
public class Cost_schemes {
	ReadXclData rddata=new ReadXclData();
	Common c= new Common();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Cost_Scheme");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Cost_schemes_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  Reporter.log("<<======================{Cost schemes Tab}=======================>> ");
	  CS_page.Goto_Cost_Scheme_page();
	  Thread.sleep(1500);
	  System.out.println("Cost schemes Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Creat_New_icon();
	  Thread.sleep(500);
	  System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Cost_schemes_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0));
	  System.out.println(arr.get(0) + "is Entered in Cost Scheme name Field");
  }
  @Test(priority=4)
  public void Enter_Description() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Description("Cos_des", arr.get(1));
	  System.out.println(arr.get(1) + "  :is Entered in the Description Input Field");
  }
 
  @Test(priority=5)
  public void Select_Currency_from_DDlist() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Currency("Cos_curr",arr.get(2));
  }
  
  @Test(priority=6)
  public void Select_Rounding_from_DDlist() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Rounding("Cos_rounding",arr.get(3));
  }
  @Test(priority=7)
  public void Apply_Administration_costs() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), arr.get(5));
  }
  @Test(priority=8)
  public void Apply_Collection_costs() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), arr.get(7));
  }
  
  @Test(priority=9)
  public void variable_Collection_Cost() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Variable_Collection_Costs("VariableCollCost","Yes", "1", "1", "100");
	  //cb_on(1)=Percentage of the balance    Invoice amount=1 tb_of
  }
  
  @Test(priority=10)
  public void Save_andClose_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  String tt=null;
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
		   tt=eve.GetText("Save_changes_notification_Message");
		}
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("PS_Cancel"))).isDisplayed()){
			Reporter.log("Notification : ---------------------------------------");
			Reporter.log("------------------------------------------------------");
			CS_page.Close();
			throw new ElementNotInteractableException(tt);
		}
	  
  }
  @Test(priority=11)
  public void Verify_With_Empty_input_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Creat_New_icon();
	  Thread.sleep(1000);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  CS_page.Close();
	  Thread.sleep(1000);
  }
  
  @Test(priority=12)
  public void Verify_unique_Cost_schemes_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0));
	  CS_page.Description("Cos_des", arr.get(1));
	  CS_page.Currency("Cos_curr",arr.get(2));
	  CS_page.Rounding("Cos_rounding",arr.get(3));
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), arr.get(5));
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), arr.get(7));
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Close();
	  Thread.sleep(1000);
  }
  @Test(priority=13)
  public void Verify_mandatory_Fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  //CS_page.Cost_scheme_Name("Cos_csname",arr.get(0));
	  CS_page.Description("Cos_des", arr.get(1));
	  CS_page.Currency("Cos_curr",arr.get(2));
	  CS_page.Rounding("Cos_rounding",arr.get(3));
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), arr.get(5));
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), arr.get(7));
	  Thread.sleep(500);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0));
	  CS_page.Description("Cos_des", arr.get(1));
	  CS_page.Currency("Cos_curr",arr.get(2));
	  CS_page.Rounding("Cos_rounding",arr.get(3));
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), "");
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), arr.get(7));
	  Thread.sleep(500);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0));
	  CS_page.Description("Cos_des", arr.get(1));
	  CS_page.Currency("Cos_curr",arr.get(2));
	  CS_page.Rounding("Cos_rounding",arr.get(3));
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), arr.get(5));
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), "");
	  Thread.sleep(500);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Close();
	  Thread.sleep(1000);
  }
  
  @Test(priority=14)
  public void Verify_Save_cancel_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0)+"Save");
	  CS_page.Description("Cos_des", arr.get(1)+" save");
	  CS_page.Currency("Cos_curr",arr.get(2));
	  CS_page.Rounding("Cos_rounding",arr.get(3));
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), arr.get(5));
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), arr.get(7));
	  Thread.sleep(500);
	  CS_page.Save();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  CS_page.Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(2000);
  }
 
  @Test(priority=15)
  public void Verify_Save_as_New_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  CS_page.Creat_New_icon();
	  Thread.sleep(1500);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0)+"Save as New");
	  CS_page.Description("Cos_des", arr.get(1));
	  CS_page.Currency("Cos_curr",arr.get(2));
	  CS_page.Rounding("Cos_rounding",arr.get(3));
	  CS_page.Apply_Admin_Costs("cos_FixedAdminCost", "chkApplyAdminCosts", arr.get(4), arr.get(5));
	  CS_page.Apply_Collection_Costs("Cos_FixedCollCost", "chkApplyCollCosts", arr.get(6), arr.get(7));
	  Thread.sleep(500);
	  CS_page.Save_as_new();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  CS_page.Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  
  }
  
  @Test(priority=16)
  public void Verify_Cost_schemes_in_Dunning_letters() throws IOException, InterruptedException {
 	 WebDriver driver=WebDriverManager.getDriverInstance();
 	 Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
 	 Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
 	 c_page.Goto_communication_page();
 	 Thread.sleep(2000);
 	 c_page.Click_on_Documents_and_templetes_tab();
 	 Thread.sleep(3000);
 	 c_page.Creat_New_icon();
 	 Thread.sleep(1500);
 	 c_page.Cost_Scheme("com_cost_scheme", arr.get(0));
 	 Thread.sleep(1000);
 	 c_page.Cancel();
 	 Thread.sleep(1500);
 	 c_page.Notification();
 	 Thread.sleep(1000);
 	 c_page.Notification();
 	 FC_page.Click_Cost_Scheme_tab();
 	 Thread.sleep(1500);
 	 c_page.Notification_No();
 	 Thread.sleep(1500);
   }
  @Test(priority=17)
  public void Add_Collection_Cost_Scheme() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Save", "Cos_CS_table");
	  Thread.sleep(1000);
	  CS_page.Update_icon();
	  Thread.sleep(2000);
	  CS_page.Variable_Collection_Costs("VariableCollCost", "Yes", "2", "2", "101");
	  Thread.sleep(1500);	
	  CS_page.Collection_Cost_Scheme_ICon();
	  Thread.sleep(1500);	
	  CS_page.Add_ICON_Collection_Cost_Scheme_range("Cos_AddRange");
	  Thread.sleep(500);
	  CS_page.Add_Collection_Cost_Scheme_range("Cos_csc_range_table", "12", "12", "12");
	  Thread.sleep(500);
	  CS_page.Add_ICON_Collection_Cost_Scheme_range("Cos_AddRange");
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(500);
	  CS_page.Add_Collection_Cost_Scheme_range("Cos_csc_range_table", "100", "200", "1000");
	  Thread.sleep(500);
	  CS_page.Add_ICON_Collection_Cost_Scheme_range("Cos_save_col_cost_sch_popover");
	  Thread.sleep(800);
	  Thread.sleep(1000);
	  CS_page.Cancel_Collection_Cost_range_window_icon("Cos_save_and_Close_col_cost_sch_popover");//Save and Close
	  Thread.sleep(1500);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
  }
  
  @Test(priority=18)
  public void Update_Collection_Cost_Scheme() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Save", "Cos_CS_table");
	  Thread.sleep(1000);
	  CS_page.Update_icon();
	  Thread.sleep(2000);
	  CS_page.Cost_scheme_Name("Cos_csname",arr.get(0)+"Update");
	  CS_page.Variable_Collection_Costs("VariableCollCost", "Yes", "3", "1", "102");
	  Thread.sleep(1000);
	  CS_page.Collection_Cost_Scheme_ICon();
	  Thread.sleep(1500);	
	  CS_page.Update_Collection_Cost_Scheme_range("Cos_csc_range_table","Cos_UpdateRange","1");
	  Thread.sleep(1000);
	  CS_page.Notification();
	  CS_page.Cancel_Collection_Cost_range_window_icon("Cos_save_col_cost_sch_popover");//Save
	  Thread.sleep(500);
	  CS_page.Cancel_Collection_Cost_range_window_icon("Cos_Cancel_col_cost_sch_popover");//Cancel or Close Icon
	  Thread.sleep(1500);
	  CS_page.Notification();
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
  }
  
  @Test(priority=19)
  public void Delete_Collection_Cost_Scheme() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Update", "Cos_CS_table");
	  Thread.sleep(1000);
	  CS_page.Update_icon();
	  Thread.sleep(2000);
	  CS_page.Variable_Collection_Costs("VariableCollCost", "Yes", "4", "1", "103");
	  Thread.sleep(1500);
	  CS_page.Collection_Cost_Scheme_ICon();
	  Thread.sleep(1500);	
	  CS_page.Select_Collection_Cost_Scheme_range("Cos_csc_range_table");
	  Thread.sleep(500);
	  CS_page.Delete_ICON_Collection_Cost_Scheme_range("Cos_DeleteRange");
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(800);
	  CS_page.Notification();
	  CS_page.Cancel_Collection_Cost_range_window_icon("Cos_save_and_Close_col_cost_sch_popover");//Save and Close
	  Thread.sleep(1500);
	  CS_page.Save_and_Close();
	  Thread.sleep(1000);
	  CS_page.Notification();
	  Thread.sleep(1000);
	  CS_page.Notification();
  }
  
 @Test(priority=20)
 public void Link_Cost_schemes_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event("Riwal LIVE", "is_Admin_table");//arr.get(9)
	  eve.Table_event(arr.get(0), "Cos_CS_table");
	  Thread.sleep(1000);
	  CS_page.link();
	  Thread.sleep(1000);
	  CS_page.Save_Panel_Changes();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  Thread.sleep(300);
	  CS_page.Refresh_panal();
	  Thread.sleep(1500);
	  CS_page.Notification();
  }
 @Test(priority=21)
 public void Delete_Linked_Cost_schemes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "Cos_CS_table");
	  CS_page.Delete_icon();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  }

  @Test(priority=22)
  public void UnLink_Cost_schemes_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "Cos_CS_unlink_table");
	  CS_page.Unlink();
	  Thread.sleep(1500);
	  CS_page.Save_Panel_Changes();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  Thread.sleep(300);
	  CS_page.Refresh_panal();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  
	  }
  @Test(priority=23)
  public void Delete_Cost_schemes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Cost_Schemes_Page CS_page = new Cost_Schemes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Update", "Cos_CS_table");
	  CS_page.Delete_icon();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  CS_page.Save_Panel_Changes();
	  Thread.sleep(1500);
	  CS_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+"Update", "Cos_CS_table");
	  Reporter.log("<------------------------{End of Cost schemes Tab Section.}------------------------>");
	  }
}
