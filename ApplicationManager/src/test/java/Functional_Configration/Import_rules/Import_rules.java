package Functional_Configration.Import_rules;

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
import appMan_Pages.Home_index_Page;
import appMan_Pages.Import_rules_Page;
@Listeners(ScreenShotOnFailure.class)
public class Import_rules {
	 ReadXclData rddata=new ReadXclData();
	 WebDriverManager mgr= new WebDriverManager();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Import_Rules");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Import_rules_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  Reporter.log("<<======================{Import rules Tab}=======================>> ");
	  ir_page.Goto_import_rules_page();
	  System.out.println("Import rules Page is opened");
  }
  @Test(priority=2,description="APP-641:Create new rulebook")
  public void Create_new_rulebook() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Creat_New_icon();
	  Thread.sleep(500);
	  ir_page.Import_rulebook_name(arr.get(0));  
	  ir_page.Save_and_Close();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
  }
  @Test(priority=3,description="APP-642:Activate new rulebook")
  public void Activate_new_rulebook() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Creat_New_icon();
	  Thread.sleep(500);
	  ir_page.Import_rulebook_name(arr.get(0)+"1");  
	  ir_page.Activated(arr.get(1));
	  ir_page.Save();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Account_manager(arr.get(2));
	  ir_page.Credit_manager(arr.get(3));
	  ir_page.Dispute_manager(arr.get(4));
	  ir_page.Undersigned(arr.get(5));
	  ir_page.User_group(arr.get(6));
	  ir_page.Profile(arr.get(7));
	 // ir_page.Group_Profile((arr.get(8));
	  ir_page.Debtor_status(arr.get(9));
	  ir_page.Risk_Code(arr.get(10));
	  ir_page.Dunning_language(arr.get(11));
	  ir_page.Monitoring(arr.get(12));
	  ir_page.Collection_agency(arr.get(13));
	  ir_page.Entity_table(mgr.getparam("Comm_entity_tables",0));
	  ir_page.Interest_Scheme(mgr.getparam("FC_Interest_schemes",0));
	  ir_page.Cost_Scheme(mgr.getparam("FC_Cost_Scheme",0));
	  Thread.sleep(500);
	  ir_page.Save_and_Close();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=4,description="APP-648:linking of rulebook to an administration")
  public void Link_rulebook_to_Selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(14), "C_curr_admin_table");//Clicked on Administrations name
	  Thread.sleep(500);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");        //Clicked on rulebook table
	  Thread.sleep(1000);
	  ir_page.link();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  ir_page.Save_Changes();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
  }
  @Test(priority=5,description="APP-653:Create new customer rule by clicking on 'Create import rule' button")
  public void Create_new_customer_rule_by_clicking_on_Create_import_rule_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("7");    //Assign debtor risk code option value in DDlist
	  ir_page.Create_import_rule_button();
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("8", "24", "0", "20", "0");
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=6,description="APP-654:In customer rules tab ,Create action (Credit manager matching)")
  public void Create_Credit_manager_matching_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("2");          //Assign debtor account manager  option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("1", "25", "5", "20", "0");
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=7,description="APP-655:In customer rules tab ,Create action (Credit limit)")
  public void Create_Credit_limit_matching_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("18");  //Assign credit limit option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Credit_limit_Criteria_Import_rule_("100","2", "15", "6", "11", "0");
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	    }
  @Test(priority=8)
  public void Update_Criteria_for_Credit_limit_matching_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  ir_page.Credit_limit_Criteria_Import_rule_("111","4", "17", "7", "gmail", "0");
	  Thread.sleep(1000);
	  ir_page.Update_criteria_button();
	  Thread.sleep(2000);
	    }
  @Test(priority=9)
  public void Delete_Criteria_for_Credit_limit_matching_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  Thread.sleep(1000);
	  ir_page.Delete_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
  @Test(priority=10,description="APP-660:In design rule detail, check 'save and close' button when create customer rule")
  public void Verify_Save_and_Close_Button_when_Create_Customer_rule() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("18");  //Assign credit limit option value in DDlist
	  Thread.sleep(1000);
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Credit_limit_Criteria_Import_rule_("111","3", "15", "6", "001", "0");
	  Thread.sleep(1000);
	  ir_page.Create_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
 
  @Test(priority=11,description="APP-661:In design rule detail, check 'Reload' button when create customer rule")
  public void Verify_Reload_Button_when_Create_Customer_rule() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("18"); //Assign credit limit option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Credit_limit_Criteria_Import_rule_("222","2", "15", "6", "99", "0");
	  Thread.sleep(500);
	  ir_page.Reload_Criteria();
	  Thread.sleep(500);
	  ir_page.Create_criteria_button();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  
  @Test(priority=12)
  public void Create_Import_rule_for_Assign_Entity_table_in_Debtor_Rule() throws Exception {   //Added New
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("28");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("Comm_entity_tables",0)+" Save", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=13)
  public void Create_Criteria_for_Assign_Entity_table_In_customer_rules_tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("28");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("Comm_entity_tables",0)+" Save", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	    }
  @Test(priority=14)
  public void Update_Criteria_for_Assign_Entity_table_In_customer_rules_tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  ir_page.Assign_Entity_table_(mgr.getparam("Comm_entity_tables",0)+" Save", "14", "0", "India", "1"); 
	  Thread.sleep(1000);
	  ir_page.Update_criteria_button();
	  Thread.sleep(2000);
	    }
  @Test(priority=15)
  public void Delete_Created_Criteria_for_Assign_Entity_table_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  Thread.sleep(1000);
	  ir_page.Delete_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
  @Test(priority=16)
  public void Verify_Save_and_Close_Button_when_Create_Customer_rule_for_Assign_Entity_table() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("28");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("Comm_entity_tables",0)+" Save", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
 
  @Test(priority=17,description="APP-661:In design rule detail, check 'Reload' button when create customer rule")
  public void Verify_Reload_Button_when_Create_Customer_rule_for_Assign_Entity_table() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("28");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("Comm_entity_tables",0)+" Save", "1", "9", "S", "1"); 
	  Thread.sleep(500);
	  ir_page.Reload_Criteria();
	  Thread.sleep(500);
	  ir_page.Create_criteria_button();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  }
  
  @Test(priority=18)
  public void Create_Import_rule_for_Assign_interest_scheme_in_Debtor_Rule() throws Exception {   //Added New
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("29");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Interest_schemes",0)+"Save", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=19)
  public void Create_Criteria_for_Assign_Interest_Scheme_In_customer_rules_tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("29");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Interest_schemes",0)+"Save", "1", "9", "S", "1");  
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	    }
  @Test(priority=20)
  public void Update_Criteria_for_Assign_Interest_Scheme_In_customer_rules_tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Interest_schemes",0)+"Save", "14", "0", "India", "1"); 
	  Thread.sleep(1000);
	  ir_page.Update_criteria_button();
	  Thread.sleep(2000);
	    }
  @Test(priority=21)
  public void Delete_Created_Criteria_for_Assign_Interest_Scheme_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  Thread.sleep(1000);
	  ir_page.Delete_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
  @Test(priority=22)
  public void Verify_Save_and_Close_Button_when_Create_Customer_rule_for_Assign_Interest_Scheme() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("29");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Interest_schemes",0)+"Save", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
 
  @Test(priority=23,description="APP-661:In design rule detail, check 'Reload' button when create customer rule")
  public void Verify_Reload_Button_when_Create_Customer_rule_for_Assign_Interest_Scheme() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("29");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Interest_schemes",0)+"Save", "1", "9", "S", "1"); 
	  Thread.sleep(500);
	  ir_page.Reload_Criteria();
	  Thread.sleep(500);
	  ir_page.Create_criteria_button();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  
  
  @Test(priority=24)
  public void Create_Import_rule_for_Assign_Cost_scheme_in_Debtor_Rule() throws Exception {   //Added New
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("12");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Cost_Scheme",0)+"Save as New", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=25)
  public void Create_Criteria_for_Assign_Cost_Scheme_In_customer_rules_tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("12");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Cost_Scheme",0)+"Save as New", "1", "9", "S", "1");  
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	    }
  @Test(priority=26)
  public void Update_Criteria_for_Assign_Cost_Scheme_In_customer_rules_tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Cost_Scheme",0)+"Save as New", "14", "0", "India", "1"); 
	  Thread.sleep(1000);
	  ir_page.Update_criteria_button();
	  Thread.sleep(2000);
	    }
  @Test(priority=27)
  public void Delete_Created_Criteria_for_Assign_Cost_Scheme_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  Thread.sleep(1000);
	  ir_page.Delete_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
  @Test(priority=28)
  public void Verify_Save_and_Close_Button_when_Create_Customer_rule_for_Assign_Cost_Scheme() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("12");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Cost_Scheme",0)+"Save as New", "1", "9", "S", "1"); 
	  ir_page.Create_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
 
  @Test(priority=29,description="APP-661:In design rule detail, check 'Reload' button when create customer rule")
  public void Verify_Reload_Button_when_Create_Customer_rule_for_Assign_Cost_Scheme() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("12");          //Assign entity table option value in DDlist
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Assign_Entity_table_(mgr.getparam("FC_Cost_Scheme",0)+"Save as New", "1", "9", "S", "1"); 
	  Thread.sleep(500);
	  ir_page.Reload_Criteria();
	  Thread.sleep(500);
	  ir_page.Create_criteria_button();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  
 @Test(priority=30,description="APP-656:In customer rules tab ,Create action (customer monitoring)")
  public void Create_Customer_Monitoring_Action_matching_In_customer_rules_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action("3");                    //Debtor monitoring
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("0", "17", "7", "ttt", "");
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  
  @Test(priority=31,description="APP-663: In customer rules tab ,check 'Save and close' button")
  public void Verify_Save_and_Close_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Apply_rules("0");
	 // ir_page.Apply_rules_to("-1");
	  ir_page.Save_and_Close();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=32,description="APP-662: In customer rules tab ,check 'Save' and 'Cancel' button")
  public void Verify_Save_and_Cancel_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("7");   //Assign debtor risk code
	  ir_page.Import_rule_Table("IR_import_rules_table","NO");
	  Thread.sleep(1000);;
	  ir_page.Save();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  ir_page.Cancel();
	  Thread.sleep(1500);
	    }
  @Test(priority=33,description="APP-664: In customer rules tab ,check 'Reload' button")
  public void Verify_Reload_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("7");  //Assign debtor risk code
	  ir_page.Import_rule_Table("IR_import_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Reload();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel();
	  Thread.sleep(1500);
	    }
  
  @Test(priority=34,description="APP-666:In Invoice rule tab,Create invoice rules(Invoice monitoring)")
  public void Create_Invoice_Monitoring_rules_In_Invoice_rule_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action_Invoice_Rule("9"); //Invoice monitoring
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("-1", "5", "2", "100", "1");
	  Thread.sleep(1000);
	  ir_page.Create_criteria_button();
	  Thread.sleep(2000);
	    }
  
  @Test(priority=35)
  public void Update_Criteria_For_Invoice_Monitoring_rules_In_Invoice_rule_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("0", "5", "2", "45", "2");
	  Thread.sleep(1000);
	  ir_page.Update_criteria_button();
	  Thread.sleep(2000);
	    }
  @Test(priority=36)
  public void Delete_Criteria_for_Invoice_Monitoring_rules_In_Invoice_rule_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Select_First_Row_From_Criteria_Table("IR_criteria_table");
	  Thread.sleep(1000);
	  ir_page.Delete_criteria_button();
	  Thread.sleep(2000);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	}
  
  
  @Test(priority=37,description="APP-667:In Invoice rule tab,Create invoice rules(Invoice monitoring)(date field)")
  public void Check_Date_field_ofInvoice_Monitoring_rules_In_Invoice_rule_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action_Invoice_Rule("9"); //Invoice monitoring
	  Thread.sleep(1000);
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Date_Criteria_Import_rule("0", "2", "4", "12", "1");
	  Thread.sleep(1000);
	  ir_page.Create_criteria_button();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
 /* @Test(priority=37,description="APP-667:In Invoice rule tab,Create invoice rules(Invoice monitoring)(date field)")
  public void Verify_Date_field_ofInvoice_Monitoring_rules_In_Invoice_rule_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action_Invoice_Rule("9"); //Invoice monitoring
	  Thread.sleep(1000);
	  ir_page.Delete_Import_rule_Table("IR_Invoice_rules_table","Yes");
	  ir_page.Update_import_rule_button();
	  Thread.sleep(1000);
	  boolean t=ir_page.Verify_Criteria_in_table("IR_criteria_table","Invoice date <= ");
	  if(t){
		  System.out.println("Keyword matched the string");
		  ir_page.Cancel_Criteria();
	  }else{
		  ir_page.Cancel_Criteria();
		  throw new ElementNotVisibleException("Date Not Found");
	  }
	    }*/
 @Test(priority=38,description="APP-665:In Invoice rule tab,Create invoice rules(Include invoie in letter)")
  public void Create_Include_Invoice_in_letter_rules_In_Invoice_rule_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action_Invoice_Rule("20"); //Include invoice in letter
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("-1", "5", "3", "6222", "1");
	  Thread.sleep(500);
	  ir_page.Create_criteria_button();
	  Thread.sleep(500);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
 @Test(priority=39,description="APP-668:In design rule detail, check 'save and close' button when create invoice rule")
  public void Verify_Save_and_Close_button_When_Create_Invoice_rule() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action_Invoice_Rule("20"); //Include invoice in letter
	  Thread.sleep(1000);
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("-1", "5", "3", "9999", "1");
	  Thread.sleep(1000);
	  ir_page.Create_criteria_button();
	  Thread.sleep(500);
	  ir_page.Save_and_Close_Criteria();
	  Thread.sleep(2000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  @Test(priority=40,description="APP-669:In design rule detail, check 'Reload button when create invoice rule")
  public void Verify_Reload_buttonWhen_Create_Invoice_rule() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Assign_Property_Action_Invoice_Rule("20");
	  ir_page.Create_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Apply_rules_to("-1");
	  ir_page.Check_ALL_data_Checkbox("Yes");
	  ir_page.Criteria_Import_rule_("-1", "6", "3", "1000", "1");
	  Thread.sleep(500);
	  ir_page.Reload_Criteria();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
  @Test(priority=41,description="APP-673:Invoice rules tab check 'save and close' button")
  public void Verify_Save_and_Close_button_in_Invoice_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Apply_rules("0");
	 // ir_page.Apply_rules_to("-1");
	  ir_page.Save_and_Close();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	    }
  
  @Test(priority=42,description="APP-674:Invoice rules tab check 'Save' and 'Cancel' button")
  public void Verify_Save_and_Cancel_button_in_Invoice_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  ir_page.Assign_Property_Action_Invoice_Rule("9");  //Invoice monitoring
	  ir_page.Import_rule_Table("IR_Invoice_rules_table","NO");
	  Thread.sleep(1000);;
	  ir_page.Save();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel();
	  Thread.sleep(1500);
	  ir_page.Notifications();
	    }
  @Test(priority=43,description="APP-675:Invoice rules tab check 'Reload' button")
  public void Verify_Reload_button_in_Invoice_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action_Invoice_Rule("9"); //Invoice monitoring
	  ir_page.Import_rule_Table("IR_Invoice_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Reload();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	 // ir_page.Cancel();
	  //Thread.sleep(500);
	    }
  @Test(priority=44)
  public void Verify_Cancel_Invoice_Rulebook_Section() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  ir_page.Cancel();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	    }
  
  
  @Test(priority=45,description="APP-657:In design rule detail, check 'Add criteria' button when create Customer rule.")
  public void Verify_Add_Criteria_Button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0), "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action_Invoice_Rule("9");
	  ir_page.Create_import_rule_button();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(1000);
	  ir_page.Cancel();
	  Thread.sleep(1000);
	    }
  
  @Test(priority=46,description="APP-671:In design rule detail, check 'update criteria' button when create invoice rule")
  public void Verify_Update_Criteria_button_in_Invoice_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action_Invoice_Rule("9");
	  ir_page.Import_rule_Table("IR_Invoice_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Update_import_rule_button();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  ir_page.Cancel();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	    }
  @Test(priority=47,description="APP-672:In design rule detail, check 'Delete Import rule' button when create invoice rule")
  public void Verify_Delete_Criteria_button_in_Invoice_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action_Invoice_Rule("9");
	  ir_page.Import_rule_Table("IR_Invoice_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Delete_import_rule_button();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Cancel();
	  Thread.sleep(1000);
	    }
  
  
  @Test(priority=48,description="PP-670:In design rule detail, check 'Add criteria' button when create invoice rule.")
  public void Verify_Add_Criteria_Button_in_Invoice_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0), "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Invoice_rules_tab();
	  Thread.sleep(500);
	  ir_page.Assign_Property_Action_Invoice_Rule("9");
	  ir_page.Create_import_rule_button();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  ir_page.Cancel();
	  Thread.sleep(1000);
	    }
  
  @Test(priority=49,description="APP-658:In design rule detail, check 'Update criteria' button when create Customer rule")
  public void Verify_Update_Criteria_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("7");  //Assign debtor risk code
	  ir_page.Import_rule_Table("IR_import_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Update_import_rule_button();
	  Thread.sleep(500);
	  ir_page.Cancel_Criteria();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  ir_page.Cancel();
	  Thread.sleep(1000);
	    }
  @Test(priority=50,description="APP-659:In design rule detail, check 'Delete criteria' button when create Customer rule")
  public void Verify_Delete_Criteria_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("7");     //Assign debtor risk code
	  ir_page.Import_rule_Table("IR_import_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Delete_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Cancel();
	    }
  @Test(priority=51)
  public void Delete_Assign_Entity_table_Criteria_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("28");     //assign entity table
	  ir_page.Delete_Import_rule_Table("IR_import_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Delete_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Cancel();
	    }
  @Test(priority=52)
  public void Delete_Assign_Interest_Scheme_Criteria_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("29");     //assign Interest Scheme
	  ir_page.Delete_Import_rule_Table("IR_import_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Delete_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Cancel();
	    }
  @Test(priority=53)
  public void Delete_Assign_Cost_Scheme_Criteria_button_in_Customer_Rules_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  ir_page.Update_icon();
	  Thread.sleep(1000);
	  ir_page.Debtor_rules_tab();
	  Thread.sleep(1000);
	  ir_page.Assign_Property_Action("30");     //assign Cost Scheme
	  ir_page.Delete_Import_rule_Table("IR_import_rules_table","Yes");
	  Thread.sleep(500);
	  ir_page.Delete_import_rule_button();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Cancel();
	    }

  @Test(priority=54,description="Delete Linked Rulebook to Admin")
  public void Delete_Linked_rulebook() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");//Clicked on Rule book linked to the selected administrations  table
	  Thread.sleep(1000);
	  ir_page.Delete_icon();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
  }
  
 @Test(priority=55,description="APP-650:unlink import rulebook from inactive administration")
  public void UnLink_rulebook_from_Selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_unlink_table");//Clicked on rulebook linked to the selected administrations  table
	  Thread.sleep(1000);
	  ir_page.Unlink();
	  Thread.sleep(500);
	  ir_page.Save_Changes();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(1000);
  }
  @Test(priority=56,description="APP-646:Delete Rulebook")
  public void Delete_rulebook() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_rules_Page ir_page= new Import_rules_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"1", "IR_rulebook_table");//Clicked on Rule book 
	  Thread.sleep(1000);
	  ir_page.Delete_icon();
	  Thread.sleep(1000);
	  ir_page.Notifications();
	  Thread.sleep(500);
	  ir_page.Notifications();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+"1", "IR_rulebook_table");
	  Reporter.log("<<======================{End : Import rules Section}=======================>> ");
  }
  @Test(priority=57)
  public void Render_back_toHome_index_page() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	 Home_index_Page hi =new Home_index_Page(driver);
	 hi.Functional_Configration_Index();
	 Thread.sleep(500);
	 hi.Render_Notifications();
	  }
}
