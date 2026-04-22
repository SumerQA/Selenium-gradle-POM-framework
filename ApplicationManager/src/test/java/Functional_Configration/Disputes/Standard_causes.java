package Functional_Configration.Disputes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Standard_causes_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Standard_causes {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("D_Standard_Cause");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Standard_causes_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("<<======================{Standard causes Tab}=======================>> ");
	  SC_page.Goto_Standard_Causes_page();
	  Thread.sleep(500);
	  System.out.println("Standard causes Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  SC_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Description() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify Description input field. ---------->>");
	  SC_page.Description("SD_desc",arr.get(0));                      
	  System.out.println(arr.get(0)+ " is Entered in description Field");
  }
  @Test(priority=4)
  public void Enter_Code() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify Code input field. ---------->>");
	  SC_page.code("SD_code", arr.get(1));
	  System.out.println(arr.get(1)+ " is entered in Code field");
  }
 
  @Test(priority=5,description="APP-477:save and close button")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify Save and Close button. ---------->>");
	  SC_page.Save_and_Close();
	  Thread.sleep(500);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Notification();
  }
  
  @Test(priority=6,description="APP-479:save multiple causes of same name")
  public void Verify_multiple_causes_of_same_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify multiple causes of same name. ---------->>");
	  SC_page.Creat_New_icon();
	  Thread.sleep(500);
	  SC_page.Description("SD_desc",arr.get(0));
	  SC_page.code("SD_code", arr.get(1));
	  SC_page.Save_and_Close();
	  Thread.sleep(500);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Cancel();
	  SC_page.Notification();
	  Thread.sleep(1500);
  }
  
  @Test(priority=7,description="APP-478:save as new")
  public void Verify_Save_as_New_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify Save as New button. ---------->>");
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0), "SC_Standard_Cause_table");
	  SC_page.Update_icon();
	  Thread.sleep(500);
	  SC_page.Description("SD_desc",arr.get(0)+" New");
	  SC_page.code("SD_code", arr.get(1)+" New");
	  SC_page.Save_sa_New();
	  Thread.sleep(500);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Cancel();
	  SC_page.Notification();
	  Thread.sleep(1500);
  }
  @Test(priority=8,description="APP-476:save button")
  public void Verify_Save_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  Reporter.log("Verify Save button. ---------->>");
	  SC_page.Creat_New_icon();
	  Thread.sleep(500);
	  SC_page.Description("SD_desc",arr.get(0)+" Save");
	  SC_page.code("SD_code", arr.get(1)+" Save");
	  SC_page.Save();
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Cancel();
	  SC_page.Notification();
	  Thread.sleep(1500);
  }
  
  @Test(priority=9,description="APP-480:Linking Standard causes")
  public void Link_Standard_causes_to_disputes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Linking Standard causes. ---------->>");
	  ev.Table_event(arr.get(2), "C_curr_admin_table");  //Clicked on Disputes table
	  ev.Table_event(arr.get(0), "SC_Standard_Cause_table");        //Clicked on Standard Cause table
	  SC_page.link();
	  Thread.sleep(500);
	  SC_page.SaveAll_Changes();
	  Thread.sleep(500);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Reload();
	  System.out.println("Newly Created Standard Caues is  linked Successfully");
	  Thread.sleep(1500);
  }
  @Test(priority=10,description="APP-474:Delete Linked Standard cause")
  public void Delete_Linked_Standard_causes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(0), "SC_Standard_Cause_table");        //Clicked on Standard Dispute table
	  Thread.sleep(1000);
	  SC_page.Delete_icon();
	  Thread.sleep(1500);
	  SC_page.Notification();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=11,description="APP-474:Delete")
  public void Delete_newly_Created_Standard_causes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_causes_Page SC_page = new Standard_causes_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Delete functionality. ---------->>");
	  ev.Table_event(arr.get(0)+" New", "SC_Standard_Cause_table");        //Clicked on Standard Dispute table
	  Thread.sleep(1000);
	  SC_page.Delete_icon();
	  Thread.sleep(800);
	  SC_page.Notification();
	  Thread.sleep(800);
	  SC_page.Notification();
	  SC_page.SaveAll_Changes();
	  Thread.sleep(500);
	  SC_page.Notification();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+" New", "SC_Standard_Cause_table");
	  System.out.println("Newly Created Standard cause is  Deleted Successfully");
	  Reporter.log("<<======================{End: Standard causes Tab}=======================>> ");
  }
}
