package Functional_Configration.Customer_scoring;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Customer_Scoring_Page;
import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Customer_scoring {
	Common c= new Common();
	String uname ="CallTest4";
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Customer_Scoring");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 

  @Test(priority=1)
  public void Goto_Customer_scoring_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  Reporter.log("<<======================{Customer scoring Tab}=======================>> ");
	  cs_page.Goto_Customer_Scoring_page();
	  Thread.sleep(500);
	  System.out.println("Customer scoring tab is Clicked.");
	  Reporter.log("Customer scoring tab is Clicked.");
  }
  
 @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  Thread.sleep(1000);
	 System.out.println("Create New panal is opened");
	 Reporter.log("Create Panal is opened");
  }
  @Test(priority=3)
  public void Select_Customer_scoring_Type() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Customer_scoring_Type(arr.get(2));
	  switch(arr.get(2)){
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_Click");
			Thread.sleep(500);
		    break;     
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_click");
			Thread.sleep(500);
		    break;
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_click");
			Thread.sleep(500);
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_click");
			Thread.sleep(500);
		    break;
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_click");
			Thread.sleep(500);
		    break;
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsclick");
		    Thread.sleep(500);
		    break;
		    
		}  
  }
  @Test(priority=4)
  public void Enter_Customer_scoring_Definition_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Customer_scoring_definition_name(arr.get(0));
	  System.out.println(" is Entered in Request Name Field");
	  
  }
  @Test(priority=5)
  public void Enter_Weighting() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Weighting(arr.get(1));
	  System.out.println(" is Entered in Weighting Name Field");
	  
  }
  @Test(priority=6)
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();

	  System.out.println(" is Entered in Weighting Name Field");
	  
  }
  @Test(priority=7)
  public void Enter_Weighting_Component_and_Sub_Component() throws IOException, InterruptedException {
	  Weighting_Component_and_Sub_Component(arr.get(2));
	 
  }
 
  @Test(priority=8)
  public void Save_and_Close_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Cancel();
	  cs_page.Notification();
	  Thread.sleep(500);
	  System.out.println(" is Entered in Weighting Name Field");
	  
  }
  
  @Test(priority=9,description="APP-606:Weighting component more than 100%")
  public void Verify_Weighting_component_more_than_100_percent() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "com_reminder_letters_table");
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Credit_Limit_Click("CS_Credit_Limit_click");
	  cs_page.Weighting("70");
	  Thread.sleep(500);
	  cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
	  cs_page.Credit_limit("CS_Credit_limit_item", "25");
	  cs_page.Weighting_change(arr.get(4), arr.get(3));
	  cs_page.Unweighted(arr.get(6));
	  Thread.sleep(500);
	  cs_page.Save();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Cancel();
	  cs_page.Notification();
	  Thread.sleep(500);
	  
  }
  @Test(priority=10,description="APP-612:Add ranges for Aging related")
  public void Verify_Add_ranges_for_Counts_balance() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  cs_page.Customer_scoring_Type(arr.get(2));
	  cs_page.Customer_scoring_definition_name(arr.get(0)+" New");
	  cs_page.Weighting(arr.get(1));
	  Thread.sleep(1000);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  switch(arr.get(2)){
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			Thread.sleep(500);
			cs_page.Add_range_Aging_Cust_Scoring("CS_Aging_items", "25",arr.get(7),arr.get(12), arr.get(13), arr.get(14), arr.get(15), arr.get(17), arr.get(16));
		    break; 
		    
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Counts_Balances_table("CS_Aging_items", "25",arr.get(12), arr.get(13), arr.get(14), arr.get(15));
		    break;
		    
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    Thread.sleep(500);
		    cs_page.Add_Range_Collection_Activity_table("CS_Collection_activity_item", "25", arr.get(12), arr.get(13), arr.get(14), arr.get(15));
			
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    Thread.sleep(500);
		    cs_page.Add_range_Debtor_props_table("CS_debt_probs_item", "25",arr.get(18),arr.get(19), arr.get(15));
		    break;
		    
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Credit_limit("CS_Credit_limit_item", "25",arr.get(12), arr.get(13), arr.get(15));
		    break;
		    
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    Thread.sleep(500);
		    cs_page.Add_range_User_fields_table("CS_user_fieds_item", "25", arr.get(19), arr.get(15));
		   
		    break;
		    
		} 	  
	  Thread.sleep(100);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  
  }
  
  @Test(priority=11)
  public void Update_Added_ranges_for_Counts_balance() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" New", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
	  cs_page.Update_range_Counts_Balances_table("CS_update_c_balance_tab", "Update", "1", "50", "105");
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Score_Points("45");
	  cs_page.Update_Range();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  
	  cs_page.Notification();
	  
  }
  @Test(priority=12)
  public void Verify_Delete_ranges_for_Counts_balance() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" New", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
	  cs_page.Update_range_Counts_Balances_table("CS_update_c_balance_tab", "Delete", "1", "50", "10");
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  
	  Thread.sleep(1500);
	  cs_page.Notification();
	  
  }
  @Test(priority=13)
  public void Create_Customer_scoring_for_Aging() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  cs_page.Customer_scoring_Type("1");
	  cs_page.Customer_scoring_definition_name(arr.get(0)+" Aging");
	  cs_page.Weighting(arr.get(1));
	  Thread.sleep(1000);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  switch("1"){  // For Aging 
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			Thread.sleep(500);
			cs_page.Add_range_Aging_Cust_Scoring("CS_Aging_items", "25",arr.get(7),arr.get(12), arr.get(13), arr.get(14), arr.get(15), arr.get(17), arr.get(16));
		    break; 
		    
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Counts_Balances_table("CS_Aging_items", "25",arr.get(12), arr.get(13), arr.get(14), arr.get(15));
		    break;
		    
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    Thread.sleep(500);
		    cs_page.Add_Range_Collection_Activity_table("CS_Collection_activity_item", "25", arr.get(12), arr.get(13), arr.get(14), arr.get(15));
			
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    Thread.sleep(500);
		    cs_page.Add_range_Debtor_props_table("CS_debt_probs_item", "25",arr.get(18),arr.get(19), arr.get(15));
		    break;
		    
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Credit_limit("CS_Credit_limit_item", "25",arr.get(12), arr.get(13), arr.get(15));
		    break;
		    
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    Thread.sleep(500);
		    cs_page.Add_range_User_fields_table("CS_user_fieds_item", "25", arr.get(19), arr.get(15));
		   
		    break;
		    
		} 	  
	  Thread.sleep(100);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(500);
	  cs_page.Notification();
  }
  @Test(priority=14,dependsOnMethods={"Create_Customer_scoring_for_Aging"})
  public void Update_Added_ranges_for_Aging() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Aging", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
	  cs_page.Update_range_Aging_table("CS_Aging_tab", "Update", "1", "50", "105","25");
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Score_Points("45");
	  cs_page.Update_Range();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(1500);
	  cs_page.Notification();
  }
  
  @Test(priority=15,dependsOnMethods={"Create_Customer_scoring_for_Aging"})
  public void Verify_Delete_ranges_for_Aging() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Aging", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
	  cs_page.Update_range_Aging_table("CS_Aging_tab", "Delete", "1", "50", "105","25");
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  
	  Thread.sleep(1500);
	  cs_page.Notification();
	  
  }
  
  @Test(priority=16)
  public void Create_Customer_scoring_for_Collection_Activities() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  Thread.sleep(1000);
	  cs_page.Customer_scoring_Type("3");
	  Thread.sleep(500);
	  cs_page.Customer_scoring_definition_name(arr.get(0)+" Coll Activity");
	  cs_page.Weighting(arr.get(1));
	  Thread.sleep(1000);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  switch("3"){  // For Collection Activity
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			Thread.sleep(500);
			cs_page.Add_range_Aging_Cust_Scoring("CS_Aging_items", "25",arr.get(7),arr.get(12), arr.get(13), arr.get(14), arr.get(15), arr.get(17), arr.get(16));
		    break; 
		    
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Counts_Balances_table("CS_Aging_items", "25",arr.get(12), arr.get(13), arr.get(14), arr.get(15));
		    break;
		    
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    Thread.sleep(500);
		    cs_page.Add_Range_Collection_Activity_table("CS_Collection_activity_item", "25", arr.get(12), arr.get(13), arr.get(14), arr.get(15));
			
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    Thread.sleep(500);
		    cs_page.Add_range_Debtor_props_table("CS_debt_probs_item", "25",arr.get(18),arr.get(19), arr.get(15));
		    break;
		    
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Credit_limit("CS_Credit_limit_item", "25",arr.get(12), arr.get(13), arr.get(15));
		    break;
		    
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    Thread.sleep(500);
		    cs_page.Add_range_User_fields_table("CS_user_fieds_item", "25", arr.get(19), arr.get(15));
		   
		    break;
		    
		} 	  
	  Thread.sleep(100);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(500);
	  cs_page.Notification();
  }
  
  @Test(priority=17,dependsOnMethods={"Create_Customer_scoring_for_Collection_Activities"})
  public void Update_Added_ranges_for_Collection_Activity() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Coll Activity", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
	  cs_page.Update_range_Aging_table("CS_Coll_Activity_tab", "Update", "1", "50", "105","25");
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Score_Points("45");
	  cs_page.Update_Range();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  cs_page.Notification();
  }
  
  @Test(priority=18,dependsOnMethods={"Create_Customer_scoring_for_Collection_Activities"})
  public void Verify_Delete_ranges_for_Collection_Activity() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Coll Activity", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
	  cs_page.Update_range_Aging_table("CS_Coll_Activity_tab", "Delete", "1", "50", "105","25");
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  
	  Thread.sleep(1500);
	  cs_page.Notification();
	  
  } 
  
  @Test(priority=19)
  public void Create_Customer_scoring_for_Debtor_Property() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  Thread.sleep(1000);
	  cs_page.Customer_scoring_Type("4");
	  Thread.sleep(500);
	  cs_page.Customer_scoring_definition_name(arr.get(0)+" deb Prop");
	  Thread.sleep(500);
	  cs_page.Weighting(arr.get(1));
	  Thread.sleep(1000);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  switch("4"){  // For Debtor Property
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			Thread.sleep(500);
			cs_page.Add_range_Aging_Cust_Scoring("CS_Aging_items", "25",arr.get(7),arr.get(12), arr.get(13), arr.get(14), arr.get(15), arr.get(17), arr.get(16));
		    break; 
		    
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Counts_Balances_table("CS_Aging_items", "25",arr.get(12), arr.get(13), arr.get(14), arr.get(15));
		    break;
		    
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    Thread.sleep(500);
		    cs_page.Add_Range_Collection_Activity_table("CS_Collection_activity_item", "25", arr.get(12), arr.get(13), arr.get(14), arr.get(15));
			
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    Thread.sleep(500);
		    cs_page.Add_range_Debtor_props_table("CS_debt_probs_item", "25",arr.get(18),arr.get(19), arr.get(15));
		    break;
		    
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Credit_limit("CS_Credit_limit_item", "25",arr.get(12), arr.get(13), arr.get(15));
		    break;
		    
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    Thread.sleep(500);
		    cs_page.Add_range_User_fields_table("CS_user_fieds_item", "25", arr.get(19), arr.get(15));
		   
		    break;
		    
		} 	  
	  Thread.sleep(100);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(500);
	  cs_page.Notification();
  }
  
  @Test(priority=20,dependsOnMethods={"Create_Customer_scoring_for_Debtor_Property"})
  public void Update_Added_ranges_for_Debtor_Property() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" deb Prop", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
	  cs_page.Update_range_Debtor_Prop_table("CS_Debt_prop_tab", "Update", "High AlrertsaveASnEW","105");
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Score_Points("45");
	  cs_page.Update_Range();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  cs_page.Notification();
	  Thread.sleep(500);
  }
  
  @Test(priority=21,dependsOnMethods={"Create_Customer_scoring_for_Debtor_Property"})
  public void Verify_Delete_ranges_for_Debtor_Property() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" deb Prop","com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
	  cs_page.Update_range_Debtor_Prop_table("CS_Debt_prop_tab", "Delete","Common TestprofileCollection","25");
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  
	  Thread.sleep(1500);
	  cs_page.Notification();
	  
  } 
  
  @Test(priority=22)
  public void Create_Customer_scoring_for_Credit_Limit() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  cs_page.Customer_scoring_Type("5");
	  Thread.sleep(500);
	  cs_page.Customer_scoring_definition_name(arr.get(0)+" Credit");
	  cs_page.Weighting(arr.get(1));
	  Thread.sleep(1000);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  switch("5"){  // For Credit Limit
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			Thread.sleep(500);
			cs_page.Add_range_Aging_Cust_Scoring("CS_Aging_items", "25",arr.get(7),arr.get(12), arr.get(13), arr.get(14), arr.get(15), arr.get(17), arr.get(16));
		    break; 
		    
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Counts_Balances_table("CS_Aging_items", "25",arr.get(12), arr.get(13), arr.get(14), arr.get(15));
		    break;
		    
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    Thread.sleep(500);
		    cs_page.Add_Range_Collection_Activity_table("CS_Collection_activity_item", "25", arr.get(12), arr.get(13), arr.get(14), arr.get(15));
			
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    Thread.sleep(500);
		    cs_page.Add_range_Debtor_props_table("CS_debt_probs_item", "25",arr.get(18),arr.get(19), arr.get(15));
		    break;
		    
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Credit_limit("CS_Credit_limit_item", "100",arr.get(12), arr.get(13), arr.get(15));
		    break;
		    
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    Thread.sleep(500);
		    cs_page.Add_range_User_fields_table("CS_user_fieds_item", "25", arr.get(19), arr.get(15));
		   
		    break;
		    
		} 	  
	  Thread.sleep(100);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(500);
	  cs_page.Notification();
  }
  @Test(priority=23,dependsOnMethods={"Create_Customer_scoring_for_Credit_Limit"})
  public void Update_Added_ranges_for_Credit_Limit() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Credit", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
	  Thread.sleep(500);
	  cs_page.Update_range_Counts_Balances_table("CS_Credit_limit_tab", "Update", "1", "50", "105");
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Score_Points("45");
	  cs_page.Update_Range();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(500);
	  cs_page.Notification();
  }
  
  @Test(priority=24,dependsOnMethods={"Create_Customer_scoring_for_Credit_Limit"})
  public void Verify_Delete_ranges_for_Credit_Limit() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Credit","com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
	  Thread.sleep(1000);
	  cs_page.Update_range_Counts_Balances_table("CS_Credit_limit_tab", "Delete", "1", "50", "105");
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  
	  Thread.sleep(1500);
	  cs_page.Notification();
	  
  } 
  
  @Test(priority=25)
  public void Create_Customer_scoring_for_User_Fields() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  cs_page.Creat_New_icon();
	  cs_page.Customer_scoring_Type("6");
	  Thread.sleep(500);
	  cs_page.Customer_scoring_definition_name(arr.get(0)+" UFields");
	  cs_page.Weighting(arr.get(1));
	  Thread.sleep(1000);
	  cs_page.Save();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);
	  switch("6"){  // For User Fields
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			Thread.sleep(500);
			cs_page.Add_range_Aging_Cust_Scoring("CS_Aging_items", "25",arr.get(7),arr.get(12), arr.get(13), arr.get(14), arr.get(15), arr.get(17), arr.get(16));
		    break; 
		    
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Counts_Balances_table("CS_Aging_items", "25",arr.get(12), arr.get(13), arr.get(14), arr.get(15));
		    break;
		    
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    Thread.sleep(500);
		    cs_page.Add_Range_Collection_Activity_table("CS_Collection_activity_item", "25", arr.get(12), arr.get(13), arr.get(14), arr.get(15));
			
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    Thread.sleep(500);
		    cs_page.Add_range_Debtor_props_table("CS_debt_probs_item", "25",arr.get(18),arr.get(19), arr.get(15));
		    break;
		    
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
		    Thread.sleep(500);
			cs_page.Add_range_Credit_limit("CS_Credit_limit_item", "25",arr.get(12), arr.get(13), arr.get(15));
		    break;
		    
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    Thread.sleep(1000);
		    cs_page.Add_range_User_fields_table("CS_user_fieds_item", "25", "Test Data", "55");
		   
		    break;
		    
		} 	  
	  Thread.sleep(100);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  Thread.sleep(500);
	  cs_page.Notification();   
  }
  @Test(priority=26,dependsOnMethods={"Create_Customer_scoring_for_User_Fields"})
  public void Update_Added_ranges_for_User_Fields() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" UFields", "com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.User_Fields_Click("CS_User_fieldsarrow");
	  cs_page.Update_range_User_Fields_table("CS_UDF_tab", "Update", "Hello", "105");
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Score_Points("45");
	  cs_page.Update_Range();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
		  throw new Exception("Changes Not Saved");
	  }
	  cs_page.Notification();
	  Thread.sleep(500);  
  }
  @Test(priority=27,dependsOnMethods={"Create_Customer_scoring_for_User_Fields"})
  public void Verify_Delete_ranges_for_User_Fields() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" UFields","com_reminder_letters_table");
	  Thread.sleep(1000);
	  cs_page.Update_icon();
	  Thread.sleep(1000);
	  cs_page.User_Fields_Click("CS_User_fieldsarrow");
	  cs_page.Update_range_User_Fields_table("CS_UDF_tab", "Delete", "Hello", "45");
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(1500);
	  cs_page.Notification();
	  if(driver.findElement(By.xpath(c.getElementName("CS_Cancel"))).isDisplayed()){
		  cs_page.Cancel_Customer_Scoring();
			throw new Exception("Changes Not Saved");
	  }
	  
	  Thread.sleep(1500);
	  cs_page.Notification();  
	  
  }
  
  @Test(priority=28)
  public void Link_Customer_soring_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(20), "fun_con_Admin_table");
	  eve.Table_event(arr.get(0), "com_reminder_letters_table");
	  cs_page.link();
	  Thread.sleep(500);
	  cs_page.Save_panal();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);    
  }
  @Test(priority=29)
  public void Delete_Customer_scoring_already_linked_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "com_reminder_letters_table");
	  cs_page.Delete_icon();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);   
	  }
  
  @Test(priority=30,description="APP-611:Unlink the score definition")
  public void UnLink_Customer_scoring () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "com_unlink_letter_tab");
	  cs_page.Unlink();
	  Thread.sleep(500);
	  cs_page.Save_panal();
	  Thread.sleep(1000);
	  cs_page.Notification();
	  Thread.sleep(500);   
	  }
 @Test(priority=31,description="APP-609:Delete Customer scoring definition")
  public void Delete_Customer_scoring_Functionality() throws IOException, InterruptedException {
	   WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "com_reminder_letters_table");
	  cs_page.Delete_icon();
	  Thread.sleep(500);
	  cs_page.Notification();
	  Thread.sleep(500);
	  cs_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "com_reminder_letters_table");   
	  }
 
 public void Weighting_Component_and_Sub_Component(String compo) throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
	  switch(compo){
		case("1"): 
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_arrow");
			cs_page.Aging_Cust_Scoring_table("CS_Aging_items", "25");
		    cs_page.Weighting_change(arr.get(4), arr.get(3));
		    cs_page.Unweighted(arr.get(6));
		    cs_page.Calculation_method(arr.get(7));
		    cs_page.Include_debit_invoices(arr.get(8), arr.get(9), arr.get(10), arr.get(11));
			Thread.sleep(500);
		    break;     
		case("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_arrow");
			cs_page.Counts_Balances_table("CS_Aging_items", "25");
			cs_page.Weighting_change(arr.get(4), arr.get(3));
		    cs_page.Unweighted(arr.get(6));
			Thread.sleep(500);
		    break;
		case("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_arrow");
		    cs_page.Collection_Activity_table("CS_Collection_activity_item", "25");
			cs_page.Weighting_change(arr.get(4), arr.get(3));
		    cs_page.Unweighted(arr.get(6));
			Thread.sleep(500);
		    break;
		case("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_arrow");
		    cs_page.Debtor_props_table("CS_debt_probs_item", "25");
		    cs_page.Weighting_change(arr.get(4), arr.get(3));
		    cs_page.Unweighted(arr.get(6));
			Thread.sleep(500);
		    break;
		case("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_arrow");
			cs_page.Credit_limit("CS_Credit_limit_item", "25");
			cs_page.Weighting_change(arr.get(4), arr.get(3));
		    cs_page.Unweighted(arr.get(6));
			Thread.sleep(500);
		    break;
		case("6"):
			cs_page.User_Fields_Click("CS_User_fieldsarrow");
		    cs_page.User_fields_table("CS_user_fieds_item", "25");
		    Thread.sleep(500);
		    break;		    
		} 
 }

}
