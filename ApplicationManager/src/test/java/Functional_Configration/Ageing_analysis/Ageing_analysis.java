package Functional_Configration.Ageing_analysis;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Aging_Analysis_Page;
@Listeners(ScreenShotOnFailure.class)
public class Ageing_analysis {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Aging_Analysis");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Ageing_analysis_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Goto_Aging_Analysis_page();
	  Reporter.log("<<======================{Ageing analysis Functionality}=======================>> ");
	  Thread.sleep(500);
	  System.out.println("Ageing Analysis Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Ageing_analysis_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Aging_Analysis_name("AA_name",arr.get(0));
	 System.out.println(arr.get(0) + " : is Entered in Ageing analysis Name Field.");
  }
  @Test(priority=4)
  public void Check_Include_Credit_notes_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Include_Credit_nots("AA_Include_Credit_Notes",arr.get(1));
	  System.out.println("Include Credit Notes Checkbox is Checked");
  }
  @Test(priority=5)
  public void Check_Include_Blocked_Invoices_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Include_blocked_invoices("AA_Include_blocked_inv",arr.get(2));
	  System.out.println("Include Blocked Invoiced Checkbox is Checked");
  }
  @Test(priority=6)
  public void Select_Date_from_CalculateFrom_DDlist() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Calculate_from("AA_Calcute_from", arr.get(3));
	  System.out.println("Item Selected from Dropdown List");
  }
  @Test(priority=7)
  public void Select_Ageing_analysis_type() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  String item = arr.get(4);
	  if(item.equals("1")){
		  AA_page.Columns("AA_column_range",  arr.get(5));
		  AA_page.Start_At("AA_start_at",  arr.get(6));
		  AA_page.Interval("AA_interval",  arr.get(7));
	  }else{
		  AA_page.Columns("AA_column_range", arr.get(5));
		  AA_page.Start_At("AA_start_at", arr.get(6));
	  }
	  System.out.println("Ageing analysis ranges is Set for type  :" + arr.get(4) );
  }
  @Test(priority=8)
  public void Clickon_generate_range_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Generate_range_Button("AA_generate_range_button");
	  System.out.println("Generate range Icon is Clicked");
	  Thread.sleep(800);
  }
   @Test(priority=9,description="APP-317:Add range to the grid - new button")
  public void Add_rangein_table() throws IOException, InterruptedException {
	   WebDriver driver=WebDriverManager.getDriverInstance();
		  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
		  AA_page.Add_range_icon("AA_Add_range");
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(500);
		  AA_page.Add_range_Table("AA_Add_range_table",arr.get(7),arr.get(8));
		  Thread.sleep(1000);
		  AA_page.Save();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  AA_page.Notification();
		  Thread.sleep(1000);
		  AA_page.Notification();
		  isNotificationPresent();
		  System.out.println("Custom Range Added is table");
	  
  }
  @Test(priority=10,description="APP-323:Delete range")
  public void Delete_rangeFrom_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  events evn = new events(driver);
	  evn.Table_event(arr.get(7),"AA_Add_range_table");
	  Thread.sleep(1000);
	  isNotificationPresent();
	  AA_page.Delete_range_icon("AA_Delete_range_icon");
	  Thread.sleep(500);
	  isNotificationPresent();
	  Thread.sleep(500);
	  isNotificationPresent();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  System.out.println("Data deleted from range table Sucessfully");
	  
  }
  @Test(priority=11)
  public void Save_Complete_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Save();
	  Thread.sleep(1000);
	  isNotificationPresent();
	  Thread.sleep(500);
	  isNotificationPresent();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  System.out.println("Saved ");
  }
  @Test(priority=12,description="APP-456:Ageing analysis name is unique")
  public void Verify_Ageing_analysis_name_is_unique() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  AA_page.Creat_New_icon();
	  Thread.sleep(500);
	  AA_page.Aging_Analysis_name("AA_name",arr.get(0));
	  AA_page.Include_Credit_nots("AA_Include_Credit_Notes",arr.get(1));
	  AA_page.Include_blocked_invoices("AA_Include_blocked_inv",arr.get(2));
	  AA_page.Calculate_from("AA_Calcute_from", arr.get(3));
	  AA_page.Save();
	  Thread.sleep(1000);
	  isNotificationPresent();
	  Thread.sleep(500);
	  isNotificationPresent();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  Thread.sleep(1000);
	  AA_page.Notification();
  }
  @Test(priority=13,description="APP-311:Reload button")
  public void Verify_Reload_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "AA_Aging_Analysis_table");
	  Thread.sleep(500);
	  AA_page.Cancel_Notification();
	  AA_page.Update_Aging_Analysis_icon();
	  Thread.sleep(500);
	  AA_page.Aging_Analysis_name("AA_name",arr.get(0)+" Reload");
	  AA_page.Include_Credit_nots("AA_Include_Credit_Notes","NO");
	  AA_page.Include_blocked_invoices("AA_Include_blocked_inv","NO");
	  AA_page.Calculate_from("AA_Calcute_from", arr.get(3));
	  AA_page.Columns("AA_column_range", "5");
	  AA_page.Refresh();
	  Thread.sleep(1000);
	  AA_page.Save();
	  Thread.sleep(1000);
	  isNotificationPresent();
	  Thread.sleep(500);
	  isNotificationPresent();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  Thread.sleep(1000);
	  AA_page.Notification();
  }
  
  @Test(priority=14,description="APP-314:Update Ageing analysis")
  public void Verify_Update_Ageing_analysis() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0), "AA_Aging_Analysis_table");
	  Thread.sleep(500);
	  AA_page.Cancel_Notification();
	  AA_page.Update_Aging_Analysis_icon();
	  Thread.sleep(500);
	  AA_page.Aging_Analysis_name("AA_name",arr.get(0)+" Test");
	  AA_page.Include_Credit_nots("AA_Include_Credit_Notes","NO");
	  AA_page.Include_blocked_invoices("AA_Include_blocked_inv","NO");
	  AA_page.Calculate_from("AA_Calcute_from", arr.get(3));
	  AA_page.Columns("AA_column_range", "5");
	  AA_page.Start_At("AA_start_at",  "6");
	  AA_page.Interval("AA_interval", "7");
	  Thread.sleep(1000);
	  AA_page.Generate_range_Button("AA_generate_range_button");
	  AA_page.Notification();
	  Thread.sleep(2000);
	  AA_page.Save();
	  Thread.sleep(1000);
	  isNotificationPresent();
	  Thread.sleep(500);
	  isNotificationPresent();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  Thread.sleep(1000);
	  AA_page.Notification();
  }
  @Test(priority=15,description="APP-315:Delete one Ageing analysis definiton")
  public void Delete_Ageing_analysis_Form_Table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Aging_Analysis_Page AA_page = new Aging_Analysis_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Test", "AA_Aging_Analysis_table");
	  AA_page.Cancel_Notification();
	  Thread.sleep(500);
	  AA_page.Delete_icon();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  Thread.sleep(1000);
	  AA_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+" Test", "AA_Aging_Analysis_table");
	  Reporter.log("<<======================{End : Ageing analysis Section}=======================>> ");
  }
  private boolean isNotificationPresent() {
		 
		 try 
		    { 
			 WebDriver driver=WebDriverManager.getDriverInstance();
			 Alert alert = driver.switchTo().alert(); 
			 System.out.println("==============     "+alert.getText()+"====================");
			 Reporter.log("Alreat Found:=");
			 Reporter.log("==============  "+alert.getText()+"====================");
			 alert.dismiss();
			 return true;
		    }   // try 
		    catch (Exception e) 
		    { 
		    	System.out.println("No Aterts found");
		        return false; 
		    }  
	 }
    
}
