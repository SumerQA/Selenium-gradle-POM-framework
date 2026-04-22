package Functional_Configration.Profiles;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Profiles_Page;
@Listeners(ScreenShotOnFailure.class)
public class Profiles {
	
	String type ;
	
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Profiles");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Profiles_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Goto_Profile_page();
	  System.out.println("Profiles Page is opened");
  }
  @Test(priority=2,description="APP-52:Create a customer profile")
  public void Create_a_customer_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  p_page.Profile_Name("P_prof_name", arr.get(0)+"Customer");
	  Thread.sleep(500);
	  System.out.println("Entered the Profile Name");
	  Thread.sleep(500);
		  p_page.profile_Type("P_Prof_type", "1");
          Thread.sleep(1000);
		  p_page.Rest_Period("P_rest_period", arr.get(2));
		  p_page.Show_rest_Period_Checkbox("ShowRestPeriod",arr.get(3));
		  if(driver.findElement(By.xpath("//*[@id='divMain']/div[2]/div[1]/div/form/div[4]/div/label")).isEnabled()){
			  p_page.End_of_monthCreation_checkbox("P_end_of_month_correction",arr.get(4));
			  p_page.Emd_of_month("P_EOM",arr.get(5));
			  p_page.Emd_of_month_Plus_XDays("P_EOD_Xday", arr.get(6));
		  }
	  p_page.Save_and_Close();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  Thread.sleep(500);
	  System.out.println("saved finally.......");
  }
  @Test(priority=3,description="APP-55:Create a group profile")
  public void Create_a_Group_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(2000);
	  p_page.Profile_Name("P_prof_name", arr.get(0)+"Group");
	  Thread.sleep(500);
	  System.out.println("Entered the Profile Name");
	  Thread.sleep(500);
	 	  p_page.profile_Type("P_Prof_type", "2");
          Thread.sleep(1000);
		  p_page.Rest_Period("P_rest_period", arr.get(2));
		  p_page.Show_rest_Period_Checkbox("ShowRestPeriod",arr.get(3));
		  if(driver.findElement(By.xpath("//*[@id='divMain']/div[2]/div[1]/div/form/div[4]/div/label")).isEnabled()){
			  p_page.End_of_monthCreation_checkbox("P_end_of_month_correction",arr.get(4));
			  p_page.Emd_of_month("P_EOM",arr.get(5));
			  p_page.Emd_of_month_Plus_XDays("P_EOD_Xday", arr.get(6));
		  }
	  p_page.Save_and_Close();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  Thread.sleep(500);
	  System.out.println("saved finally.......");
  }
  @Test(priority=4,description="APP-56:Create a collection profile")
  public void Create_a_Collection_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  p_page.Profile_Name("P_prof_name", arr.get(0)+"Collection");
	  Thread.sleep(2000);
	  System.out.println("Entered the Profile Name");
	  Thread.sleep(500);
	  p_page.profile_Type("P_Prof_type", "3");     //collection
      Thread.sleep(1000);
	  p_page.Save_and_Close();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  System.out.println("saved finally.......");
  }
  @Test(priority=5,description="APP-57:When profile name is already in use")
  public void Verify_When_Profile_name_is_already_in_use() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  Thread.sleep(500);
	  p_page.Profile_Name("P_prof_name", arr.get(0)+"Customer");
	  Thread.sleep(500);
	  p_page.profile_Type("P_Prof_type", "1");
      Thread.sleep(1000);
	  p_page.Rest_Period("P_rest_period", arr.get(2));
	  Thread.sleep(500);
	  p_page.Show_rest_Period_Checkbox("ShowRestPeriod",arr.get(3));
	  Thread.sleep(500);
	  p_page.Save();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  p_page.Profile_Name("P_prof_name", arr.get(0)+"Group");
	  Thread.sleep(500);
	  p_page.profile_Type("P_Prof_type", "2");
      Thread.sleep(1000);
	  p_page.Rest_Period("P_rest_period", arr.get(2));
	  Thread.sleep(500);
	  p_page.Show_rest_Period_Checkbox("ShowRestPeriod",arr.get(3));
	  Thread.sleep(500);
	  p_page.Save();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  p_page.Profile_Name("P_prof_name", arr.get(0)+"Collection");
	  Thread.sleep(500);
	  p_page.profile_Type("P_Prof_type", "3");
      Thread.sleep(1000);
	  p_page.Save();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  p_page.Cancel();
	  Thread.sleep(500);
	  p_page.Notification();
	 
  }
  
  @Test(priority=6,description="APP-53:Update a profile")
  public void Update_Debtor_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0)+"Customer", "P_Profile_table");
	  p_page.Update_icon();
	  Thread.sleep(1000);
	  p_page.Creat_New_icon();
	  Thread.sleep(1500);
  }
  
  @Test(priority=7)
  public void Create_Oldest_invoice_actions_with_Dunning_Letter_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException { 
	  String Action ="1";
	  String  path = "p_action", Output_chennal_text = arr.get(15),Invoices_text =arr.get(18),Credit_notes_text = arr.get(19) ;
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Action_Type("p_action_type", "1");                           //Action type
	  Thread.sleep(500);
  	  p_page.Dunning_letter_Action(path, Action,"p_a_output_channal", Output_chennal_text,"p_a_Recipent",arr.get(16), "p_a_letter", arr.get(17), Invoices_text, Credit_notes_text);
  	  events eve = new events(driver);
  	  type =eve.GetText_By_Attribute(path, "1");
  	  Thread.sleep(800);
      p_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  Thread.sleep(500);
	  p_page.From_Days("p_from_days", arr.get(10));
	  Thread.sleep(500);
	  p_page.Generate_action(arr.get(11));
	  Thread.sleep(500);
	  p_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(500);
	  p_page.Recurs(arr.get(13));
	  Thread.sleep(2000);
  }

  @Test(priority=8)
  public void Create_Criteria_to_Generate_the_Action() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events eve = new events(driver);
	  p_page.Criteria_to_generate_the_Action("p_a_criteria_to_gen_action_tab");
	  Thread.sleep(1000);
	  eve.Click_event("P_balance_Criteria");// Click on Criteria -Balance Credit invoices
	  Thread.sleep(1000);
	  p_page.Balance_Criteria_to_Generate_the_Action("=", "Balance", "100", "Yes", "Yes");
	  Thread.sleep(1000);
	  p_page.Create_Criteria();
	  Thread.sleep(1000);
  }
  @Test(priority=9)
  public void Update_Criteria_to_Generate_the_Action() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events eve = new events(driver);
	  String te =eve.GetText("P_balance_Criteria");
	  p_page.Table_event(te, "P_Criteria_Def_Table");
	  Thread.sleep(1000);
	  p_page.Balance_Criteria_to_Generate_the_Action(">", "Balance", "20", "No", "Yes");
	  p_page.Change_Criteria();
	  Thread.sleep(1000);
  }
  
  @Test(priority=10)
  public void Delete_Criteria_to_Generate_the_Action() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events eve = new events(driver);
	  String te =eve.GetText("P_balance_Criteria");
	  p_page.Table_event(te, "P_Criteria_Def_Table");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  p_page.Delete_Criteria();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
  }
  @Test(priority=11)
  public void Save_Created_Criteria_to_Generate_the_Action() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events eve = new events(driver);
	  eve.Click_event("p_a_which_act_to_generate_tab");
	  Thread.sleep(2000);
	  p_page.Save_and_Close_Generated_Action();
	  Thread.sleep(2000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  System.out.println("Action Saved Successfully");
  }
  
  @Test(priority=12)
  public void  Update_Oldest_invoice_actions_with_Phone_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	  
	  events eve = new events(driver);
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.phone_Action("p_action", "0");
	  type = eve.GetText_By_Attribute("p_action", "0");
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Criteria_to_generate_the_Action("p_a_criteria_to_gen_action_tab");  // Criteria to generate the action
	  Thread.sleep(1000);
	  eve.Click_event("P_balance_Criteria");// Click on Criteria -Balance Credit invoices
	  Thread.sleep(1000);
	  c_page.Balance_Criteria_to_Generate_the_Action(">=", "Balance", "50", "Yes", "Yes");
	  Thread.sleep(1000);
	  c_page.Create_Criteria();
	  Thread.sleep(1000);
	  eve.Click_event("p_a_which_act_to_generate_tab");
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=13)
  public void  Update_Oldest_invoice_actions_with_RiskCode_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);
	  events eve = new events(driver);
	 // c_page.Oldest_invoice_action_table("p_oldest_invoice_actions_table");
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Risk_Code_Action("p_action","18","p_a_risk_code", arr.get(24));
	  type = eve.GetText_By_Attribute("p_action", "18");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  
	  c_page.Criteria_to_generate_the_Action("p_a_criteria_to_gen_action_tab");  // Criteria to generate the action
	  Thread.sleep(1000);
	  eve.Click_event("P_Number_Criteria");// Click on Criteria -Number of Invoices 
	  Thread.sleep(1000);
	  c_page.Number_Criteria_to_Generate_the_Action("<=","150","Yes", "Yes");
	  Thread.sleep(1000);
	  c_page.Create_Criteria();
	  Thread.sleep(1000);
	  eve.Click_event("p_a_which_act_to_generate_tab");
	  Thread.sleep(1000);
	  
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=14)
  public void  Update_Oldest_invoice_actions_with_Email_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.E_mail_action("p_action", "5", "5");
	  type = eve.GetText_By_Attribute("p_action", "5");
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  
	  c_page.Criteria_to_generate_the_Action("p_a_criteria_to_gen_action_tab");  // Criteria to generate the action
	  Thread.sleep(1000);
	  eve.Click_event("P_UDF_Criteria");// UDF type- Customer Score 
	  Thread.sleep(1000);
	  c_page.UDF_Criteria_to_Generate_the_Action("P_a_cus_scoring_input","=", "99");
	  Thread.sleep(1000);
	  c_page.Create_Criteria();
	  Thread.sleep(1000);
	  eve.Click_event("p_a_which_act_to_generate_tab");
	  Thread.sleep(1500);
	  
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=15)
  public void  Update_Oldest_invoice_actions_with_Block_monitoring_action_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	 
	  events eve = new events(driver);
	 // c_page.Oldest_invoice_action_table("p_oldest_invoice_actions_table");
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Block_monitoring_Action("p_action", "9", "Yes", "Yes");
	  type = eve.GetText_By_Attribute("p_action", "9");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=16)
  public void  Update_Oldest_invoice_actions_with_Assign_debtor_status_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	  
	  events eve = new events(driver);
	 // c_page.Oldest_invoice_action_table("p_oldest_invoice_actions_table");
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Customer_Status_Action("p_action", "13", "p_a_cust_status", arr.get(23));
	  type = eve.GetText_By_Attribute("p_action", "13");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=17)
  public void  Update_Oldest_invoice_actions_with_Assign_UserGroup_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);
	  events eve = new events(driver);
	 // c_page.Oldest_invoice_action_table("p_oldest_invoice_actions_table");
	  Thread.sleep(1000);
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_User_Group_Action("p_action","19","p_a_User_group", arr.get(25));
	  type = eve.GetText_By_Attribute("p_action", "19");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_and_Close_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=18)
  public void  Update_Oldest_invoice_actions_with_Assign_Profile_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	 
	  events eve = new events(driver);
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Profile_Action("p_action","20","p_a_profile", arr.get(26));
	  type = eve.GetText_By_Attribute("p_action", "20");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_and_Close_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=19)
  public void  Update_Oldest_invoice_actions_with_Remove_user_group_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	  
	  events eve = new events(driver);
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Remove_User_Group_Action("p_action","24","p_a_remove_usergroup", arr.get(27));
	  type = eve.GetText_By_Attribute("p_action", "24");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=20)
  public void  Update_Oldest_invoice_actions_with_Request_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	 
	  events eve = new events(driver);
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Request_Action("p_action","47","p_a_Pre_Test_req", arr.get(28));
	  type = eve.GetText_By_Attribute("p_action", "47");
	  c_page.From_Days("p_from_days", arr.get(10));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=21)
  public void Delete_Oldest_invoice_actions() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",type);
	  Thread.sleep(1000);
	  try {
		  c_page.Delete_actionto_generate();
	} catch (Exception e) {
		// TODO: handle exception
	}
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  
  @Test(priority=22)
  public void Create_Always_generate_actions_with_Dunning_Letter_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException { 
	  String Action ="1";
	  String  path = "p_action", Output_chennal_text = "1",Invoices_text =arr.get(18),Credit_notes_text = arr.get(19) ;
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  WebDriverManager.waitForElement("p_action_type");
	  p_page.Action_Type("p_action_type", "2");                           //Action type
	  Thread.sleep(500);
  	  p_page.Dunning_letter_Action(path, Action,"p_a_output_channal", Output_chennal_text,"p_a_Recipent",arr.get(16), "p_a_letter", arr.get(17), Invoices_text, Credit_notes_text);
  	  Thread.sleep(800);
      p_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  Thread.sleep(500);
	  p_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(500);
	  p_page.Save_and_Close_Generated_Action();
	  Thread.sleep(2000);
	  p_page.Notification();
	  Thread.sleep(1000);
	  p_page.Notification();
	  System.out.println("Action Saved Successfully");
  }

 
  
  @Test(priority=23)
  public void  Update_Always_generate_actions_with_Phone_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(3000);
	  c_page.phone_Action("p_action", "0");
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=24)
  public void  Update_Always_generate_actions_with_RiskCode_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Risk_Code_Action("p_action","18","p_a_risk_code", arr.get(24));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=25)
  public void  Update_Always_generate_actions_with_Email_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.E_mail_action("p_action", "5", "5");
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=26)
  public void  Update_Always_generate_actions_with_Block_monitoring_action_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Block_monitoring_Action("p_action", "9", "Yes", "Yes");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=27)
  public void  Update_Always_generate_actions_with_Assign_debtor_status_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Customer_Status_Action("p_action", "13", "p_a_cust_status", arr.get(23));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=28)
  public void  Update_Always_generate_actions_with_Assign_UserGroup_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1500);
	  c_page.Assign_User_Group_Action("p_action","19","p_a_User_group", arr.get(25));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(2000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=29)
  public void  Update_Always_generate_actions_with_Assign_Profile_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Profile_Action("p_action","20","p_a_profile", arr.get(26));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=30)
  public void  Update_Always_generate_actions_with_Remove_user_group_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Remove_User_Group_Action("p_action","24","p_a_remove_usergroup", arr.get(27));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=31)
  public void  Update_Always_generate_actions_with_Request_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Request_Action("p_action","47","p_a_Pre_Test_req", arr.get(28));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=32)
  public void Delete_Always_Generate_actions() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  Thread.sleep(3000);
	  c_page.Delete_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  
  @Test(priority=33)
  public void Create_Recurring_actions_with_Dunning_Letter_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException { 
	  String Action ="1";
	  String  path = "p_action", Output_chennal_text = "1",Invoices_text =arr.get(18),Credit_notes_text = arr.get(19) ;
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  WebDriverManager.waitForElement("p_action_type");
	  p_page.Action_Type("p_action_type", "3");                           //Action type
	  Thread.sleep(500);
  	  p_page.Dunning_letter_Action(path, Action,"p_a_output_channal", Output_chennal_text,"p_a_Recipent",arr.get(16), "p_a_letter", arr.get(17), Invoices_text, Credit_notes_text);
  	  Thread.sleep(800);
      p_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	  Thread.sleep(500);
	  p_page.Comments("p_cmt",arr.get(12));
	  Thread.sleep(500);
	  p_page.Recurs(arr.get(13));
	  Thread.sleep(500);
	  p_page.Save_and_Close_Generated_Action();
	  Thread.sleep(2000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  System.out.println("Action Saved Successfully");
  }
  
  @Test(priority=34)
  public void  Update_Recurring_actions_with_Phone_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.phone_Action("p_action", "0");
	  Thread.sleep(1000);
	  c_page.Comments("p_cmt","Phone action is generated");
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(500);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=35)
  public void  Update_Recurring_actions_with_RiskCode_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Risk_Code_Action("p_action","18","p_a_risk_code", arr.get(24));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=36)
  public void  Update_Recurring_actions_with_Email_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.E_mail_action("p_action", "5", "5");
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=37)
  public void  Update_Recurring_actions_with_Block_monitoring_action_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Block_monitoring_Action("p_action", "9", "Yes", "Yes");
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=38)
  public void  Update_Recurring_actions_with_Assign_debtor_status_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Customer_Status_Action("p_action", "13", "p_a_cust_status", arr.get(23));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=39)
  public void  Update_Recurring_actions_with_Assign_UserGroup_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1500);
	  c_page.Assign_User_Group_Action("p_action","19","p_a_User_group", arr.get(25));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(2000);
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  @Test(priority=40)
  public void  Update_Recurring_actions_with_Assign_Profile_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Assign_Profile_Action("p_action","20","p_a_profile", arr.get(26));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  }
  @Test(priority=41)
  public void  Update_Recurring_actions_with_Remove_user_group_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Remove_User_Group_Action("p_action","24","p_a_remove_usergroup", arr.get(27));
	  c_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  }
  @Test(priority=42)
  public void  Update_Recurring_actions_with_Request_Action_and_Corresponding_fields_for_DEBTOR() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  WebDriverManager.waitForElement("p_action");
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Request_Action("p_action","47","p_a_Pre_Test_req", arr.get(28));
	  c_page.Comments("p_cmt",arr.get(12));
	  c_page.Recurs(arr.get(13));
	  Thread.sleep(1000);
	  c_page.Save_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel_Generated_Action();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=43)
  public void Delete_Recurring_actions() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  Thread.sleep(3000);
	  c_page.Delete_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Cancel();
	  Thread.sleep(2000);
	  c_page.Notification();
	  }
  @Test(priority=44,description="APP-66:Linking profiles")
  public void Link_Profile_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(29), "fun_con_Admin_table");
	  Thread.sleep(500);
	  eve.Table_event(arr.get(0)+"Customer", "P_Profile_table");
	  c_page.link();
	  Thread.sleep(500);
	  c_page.Save_panal();
	  Thread.sleep(4000);
	  c_page.Notification();
	  Thread.sleep(800);
	  c_page.Reload();
	  Thread.sleep(500);
	}
  
  @Test(priority=45,description="Delete Linked profile")
  public void Delete_Linked_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Customer", "P_Profile_table");
	  Thread.sleep(500);
	  c_page.Delete_icon();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=46,description="APP-68:Unlinking a profile")
  public void Unlink_Profile_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Customer", "P_link_to_Admin_table");
	  c_page.Unlink();
	  Thread.sleep(500);
	  c_page.Save_panal();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(800);
	  c_page.Reload();
	  Thread.sleep(500);
	  }
  
  @Test(priority=47,description="APP-54:Delete profile")
  public void Delete_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+"Customer", "P_Profile_table");
	  Thread.sleep(500);
	  c_page.Delete_icon();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+"Customer", "P_Profile_table");
	  }
  @Test(priority=48,description="Linking Collection profiles")
  public void Link_Collection_Profile_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(29), "fun_con_Admin_table");
	  Thread.sleep(500);
	  eve.Table_event(arr.get(0)+"Collection", "P_Profile_table");
	  c_page.link();
	  Thread.sleep(500);
	  c_page.Save_panal();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(1000);
	}
}
