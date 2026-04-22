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
public class Profiles_Old {
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
  public void Goto_Profile_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Goto_Profile_page();
	  System.out.println("Profile Page is opened");
  }
  @Test(priority=2,description="APP-52:Create a customer profile")
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Profile_Name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Profile_Name("P_prof_name", arr.get(0));
	  Thread.sleep(2000);
	  System.out.println("Entered the Profile Name");
  }
  @Test(priority=4,description="'APP-55:Create a group profile' ,'APP-56:Create a collection profile','APP-63:Show rest period checked and unchecked','APP-64:Apply correction checked and unchecked' and 'APP-65:Variations in rest period days'")
  public void Select_Profile_Type() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  String PType = arr.get(1);
	  if(PType.equals("1") || PType.equals("2")){
		  p_page.profile_Type("P_Prof_type", PType);
          Thread.sleep(1000);
		  p_page.Rest_Period("P_rest_period", arr.get(2));
		  p_page.Show_rest_Period_Checkbox("ShowRestPeriod",arr.get(3));
		  if(driver.findElement(By.xpath("//*[@id='divMain']/div[2]/div[1]/div/form/div[4]/div/label")).isEnabled()){
			  p_page.End_of_monthCreation_checkbox("P_end_of_month_correction",arr.get(4));
			  p_page.Emd_of_month("P_EOM",arr.get(5));
			  p_page.Emd_of_month_Plus_XDays("P_EOD_Xday", arr.get(6));
		  }
	  }else{
		  System.out.println(PType+ "is selected");
	  }
  }
  @Test(priority=5)
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Save_and_Close();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Notification();
	  System.out.println("saved finly......");
  }
  @Test(priority=6,description="APP-57:When profile name is already in use")
  public void Verify_When_profile_name_is_already_in_use() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Creat_New_icon();
	  Thread.sleep(500);
	  p_page.Profile_Name("P_prof_name", arr.get(0));
	  Select_Profile_Type();
	  Thread.sleep(500);
	  p_page.Save_and_Close();
	  Thread.sleep(1000);
	  p_page.Notification();
	  Thread.sleep(500);
	  p_page.Cancel();
	  Thread.sleep(500);
	  p_page.Notification();
	 
  }
  
  @Test(priority=7,description="APP-53:Update a profile")
  public void Open_Edit_Newly_Created_Profile_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0), "P_Profile_table");
	  p_page.Update_icon();
	  Thread.sleep(500);
	  p_page.Creat_New_icon();
	  Thread.sleep(500);
  }
  @Test(priority=8)
  public void Select_Action_type() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Action_Type("p_action_type", arr.get(7));                           //Action type
	  Thread.sleep(500);
  }
  
  @Test(priority=9)
  public void Select_Action_and_Corresponding_fields() throws IOException, InterruptedException { 
	  String Action =arr.get(8);
	  String  path = "p_action", Output_chennal_text = arr.get(15),Invoices_text =arr.get(18),Credit_notes_text = arr.get(19) ;
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  events eve= new events(driver);
	  switch(Action){
  	case "1": 
  		 p_page.Dunning_letter_Action(path, Action,"p_a_output_channal", Output_chennal_text,"p_a_Recipent",arr.get(16), "p_a_letter", arr.get(17), Invoices_text, Credit_notes_text);
  		 break;
  	case "5":                
  		p_page.E_mail_action(path,Action,arr.get(20));
  		break;
  	case "9":
  		 p_page.Block_monitoring_Action(path,Action,arr.get(21),arr.get(22));
  		break;
  	case "13":
  		 p_page.Assign_Customer_Status_Action(path,Action,"p_a_cust_status", arr.get(23));
  		break;
  	case "18":
  		 p_page.Assign_Risk_Code_Action(path,Action,"p_a_risk_code", arr.get(24));
  		break;
  	case "19":
  		 p_page.Assign_User_Group_Action(path,Action,"p_a_User_group", arr.get(25)); 
  		break;
  	case "20":
 		 p_page.Assign_Profile_Action(path,Action,"p_a_profile", arr.get(26));
 		break;
  	case "24":
		 p_page.Remove_User_Group_Action(path,Action,"p_a_remove_usergroup", arr.get(27));
		break;
  	case "47":
		 p_page.Request_Action(path,Action,"p_a_Pre_onguard_req", arr.get(28));
		break;		
  	default:
  		 eve.DropDown_list_event(path, Action);	
  		break;
  	}
  }
  
  
  @Test(priority=10)
  public void Check_Perform_During_import_Checkbox() throws IOException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Perform_During_import("p_perform_during_import", arr.get(9));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
  }
  @Test(priority=11)
  public void Enter_valueIn_FromDays_Field() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.From_Days("p_from_days", arr.get(10));
	  Thread.sleep(500);
  }
  @Test(priority=12)
  public void Check_generate_action_radioButton() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Generate_action(arr.get(11));
	  Thread.sleep(500);
  }
  @Test(priority=13)
  public void Enter_Comments() throws IOException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Comments("p_cmt",arr.get(12));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
  }
  @Test(priority=14)
  public void Check_Recurs_radioButton() throws IOException, InterruptedException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Recurs(arr.get(13));
	  Thread.sleep(2000);
  }
 /* @Test(priority=8)
  public void Criteria_to_Generate_the_Action() throws IOException {  
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page p_page = new Profiles_Page(driver);
	  p_page.Criteria_to_generate_the_Action("p_a_criteria_to_gen_action_tab");
	  p_page.Criteria("p_a_criteria","Customer Score");
	  p_page.Conditional_Operator("Customer Score","=", "Balance", "123", "Date");
	  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
  }*/
  @Test(priority=15)
  public void Save_generated_action() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);
	  c_page.Save_and_Close_Generated_Action();
	  Thread.sleep(2000);
	  c_page.Notification();
	  System.out.println("Action Saved Successfully");
  }
  @Test(priority=16)
  public void Verify_Generated_ActionType() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  switch(arr.get(7)){
	  	case "1": 
	  		 c_page.Oldest_invoice_action_table("p_oldest_invoice_actions_table");
	  		 break;
	  	case "2":
	  		c_page.Recuring_Actions_Items("P_Always_generate_action");
	  		break;
	  	case "3":                
	  		c_page.Recuring_Actions_Items("P_recuring_action");
	  		break;
	  	
  }/*
	  c_page.Cancel();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();*/
	  }
  
  
  @Test(priority=17)
  public void Verify_Update_and_Delete_Generated_ActionType() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	    
	  switch(arr.get(7)){
	  	case "1": 
	  		 c_page.Update_Oldest_invoice_action_table("p_oldest_invoice_actions_table",arr.get(7));
	  		 break;
	  	case "2":
	  		c_page.Update_Recuring_Actions_Items("P_Always_generate_action");
	  		break;
	  	case "3":                
	  		c_page.Update_Recuring_Actions_Items("P_recuring_action");
	  		break;
          }
	  Thread.sleep(1000);
	  c_page.Update_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Delete_actionto_generate();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Cancel();
	  Thread.sleep(500);
	  c_page.Notification();
	  }
  @Test(priority=18,description="APP-66:Linking profiles")
  public void Link_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(29), "fun_con_Admin_table");
	  Thread.sleep(500);
	  eve.Table_event(arr.get(0), "P_Profile_table");
	  c_page.link();
	  Thread.sleep(500);
	  c_page.Save_panal();
	  Thread.sleep(800);
	  c_page.Reload();
	  Thread.sleep(500);
	  }
  @Test(priority=19,description="APP-68:Unlinking a profile")
  public void Unlink_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "P_link_to_Admin_table");
	  c_page.Unlink();
	  Thread.sleep(500);
	  c_page.Save_panal();
	  Thread.sleep(800);
	  c_page.Reload();
	  Thread.sleep(500);
	  }
  
  @Test(priority=20,description="APP-54:Delete profile")
  public void Delete_Profile() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Profiles_Page c_page = new Profiles_Page(driver);	
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "P_Profile_table");
	  Thread.sleep(500);
	  c_page.Delete_icon();
	  Thread.sleep(1000);
	  c_page.Notification();
	  c_page.Notification();
	  Thread.sleep(500);
	  }
  
  
  
}
