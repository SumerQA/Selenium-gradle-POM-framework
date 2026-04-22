package Functional_Configration.Collection_interfaces;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Collection_interface_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Collection_interfaces {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Collection_interface");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Collection_interfaces_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("<<======================{Collection interfaces Tab}=======================>> ");
	  ci_page.Goto_Collection_interface_page();
	  Thread.sleep(3000);
	  System.out.println("Collection inerfaces Page is opened");
  }
  @Test(priority=2,description="APP-549:New button")
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  ci_page.Creat_New_icon();
	  Thread.sleep(1000);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Enter value in Name filed---------->>");
	  ci_page.Name("CI_name", arr.get(0));
	  System.out.println(arr.get(0)+ "  is Entered in Collection interfaces Name Field");
  }
  @Test(priority=4)
  public void Select_Export_File() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Select export file DDlist---------->>");
	  ci_page.Select_Export_File("CI_select_Export_File", arr.get(1));
	  System.out.println(arr.get(1)+" is selected from DDlist");
  }
 
  @Test(priority=5)
  public void Select_Default_letter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Select Default letter DDlist---------->>");
	  ci_page.Select_Default_letter("CI_select_Default_letter", arr.get(2));
	  System.out.println(arr.get(2)+ " is selectetd from DDlist");
  }
  @Test(priority=6)
  public void Select_Print_Or_SendByEmail_Radiobutton() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Print and Sent by E-Mail Radio Button functionality.---------->>");
	  String option =arr.get(3);
	 switch(option){
	  	case "1": 
	  		ci_page.Print();
	  		 break;
	  	default: 
	  		ci_page.Email();
	  		ci_page.Email_Settings("CI_Email_settings_tab", "CI_To", "CI_CC", "CI_BCC", "CI_subject", arr.get(13), arr.get(14), arr.get(15), arr.get(16));
	  		ci_page.Collection_Interface_tab("CI__Create_collection_Interface");
	  		break;
	  		}
  }
  @Test(priority=7)
  public void Check_Export_to() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Export to Checkbox functionality---------->>");
	  ci_page.Export_to(arr.get(4),"CI_Export_to_inputField", arr.get(5));
  }
  @Test(priority=8)
  public void Check_include_debtor_notes() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify include debtor notes Checkbox---------->>");
	  ci_page.Include_Customer_Notes(arr.get(6));
  }
  @Test(priority=9)
  public void Check_include_Invoice_notes() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify include Invoice notes Checkbox---------->>");
	  ci_page.Include_Invoice_Notes(arr.get(7));
  }
  @Test(priority=10)
  public void Check_include_Dunning_letter_sent() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify include Dunning letter sent Checkbox---------->>");
	  ci_page.Include_Dunning_letters_sent(arr.get(9));
  }
  @Test(priority=11)
  public void Check_include_Email_sent() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify include Email sent Checkbox---------->>");
	  ci_page.Include_Email_sent(arr.get(10));
  }
  @Test(priority=12)
  public void Check_include_SMS_sent() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify include SMS sent Checkbox---------->>");
	  ci_page.Include_SMS_sent(arr.get(11));
  }
  @Test(priority=13)
  public void Enter_start_date() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Start date input field.---------->>");
	  ci_page.Start_date("SinceDate", arr.get(12));
  }
  @Test(priority=14)
  public void Save_andClose_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Save and Close button.---------->>");
	  ci_page.Save_and_Close();
	  Thread.sleep(2000);
	  ci_page.Notification();
	  Thread.sleep(800);
	  ci_page.Notification();
  }
  
  @Test(priority=15)
  public void Verify_Update_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Update button Functionality.---------->>");
	  eve.Table_event(arr.get(0),"CI_collection_Interface_Table");
	  Thread.sleep(800);
	  ci_page.Update_icon();
	  Thread.sleep(11000);
	  ci_page.Name("CI_name", arr.get(0)+" Update");
	  ci_page.Include_Customer_Notes("No");
	  ci_page.Include_Invoice_Notes("No");
	  ci_page.Include_Dunning_letters_sent("No");
	  ci_page.Start_date("SinceDate", "12");
	  ci_page.Save_as_New();
	  Thread.sleep(000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Close();
	  Thread.sleep(2000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  
  }
  
  
  @Test(priority=16,description="APP-553:verify save and reload button and link collection interface")
  public void Link_Collection_interfaces_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify save and reload button and link collection interfaces.---------->>");
	  eve.Table_event(arr.get(17), "C_curr_admin_table");
	  Thread.sleep(1000);
	  eve.Table_event(arr.get(0),"CI_collection_Interface_Table");
	  Thread.sleep(1000);
	  ci_page.link();
	  Thread.sleep(1000);
	  ci_page.Save_Panal();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Reload();
	  Thread.sleep(1000);
	  ci_page.Notification();
  }
  
  @Test(priority=17,description="APP-551: Delete Linked Collection 9interfaces")
  public void Delete_Linked_Collection_interfaces() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Delete button with yes notification button.---------->>");
	  eve.Table_event(arr.get(0),"CI_collection_Interface_Table");
	  Thread.sleep(500);
	  ci_page.Delete_icon();
	  Thread.sleep(1500);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=18,description="APP-554:Unlink collection interface")
  public void UnLink_Collection_interfaces_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Unlink collection interfaces.---------->>");
	  eve.Table_event(arr.get(0), "CI_Collection_Interface_linked_table");
	  Thread.sleep(1000);
	  ci_page.Unlink();
	  Thread.sleep(1000);
	  ci_page.Save_Panal();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  ci_page.Reload();
	  Thread.sleep(1000);
	  }
  @Test(priority=19,description="APP-552:Delete button with No")
  public void Delete_Collection_interfaces_With_No_confirmation_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Reporter.log("Verify Delete button with No Notification button.---------->>");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "CI_collection_Interface_Table");
	  ci_page.Delete_icon();
	  Thread.sleep(1000);
	  ci_page.NO_Notification_button();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  }
  @Test(priority=20,description="APP-551: Delete button with yes")
  public void Delete_Collection_interfaces_With_Yes_confirmation_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Delete button with yes notification button.---------->>");
	  ci_page.Delete_icon();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "CI_collection_Interface_Table");
	  }
 
}
