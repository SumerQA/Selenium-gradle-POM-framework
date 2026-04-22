package Functional_Configration.Disputes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Functional_Configration_Page;
import appMan_Pages.Standard_Disputes_Page;
import appMan_Pages.Standard_Solutions_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Standard_solutions {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("D_Standard_Solution");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Standard_solutions_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page Ss_page = new Standard_Solutions_Page(driver);
	  Reporter.log("<<======================{Standard solutions Tab}=======================>> ");
	  Ss_page.Goto_Standard_Solutions_page();
	  Thread.sleep(500);
	  System.out.println("Standard solutions Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  SC_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Description() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  Reporter.log("Verify Description input field ---------->>");
	  SC_page.Description("SD_desc", arr.get(0));                      
	  System.out.println("StandardSolution Description is Entered in description Field");
  }
  @Test(priority=4)
  public void Enter_Code() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  Reporter.log("Verify Code input field ---------->>");
	  SC_page.code("SD_code", arr.get(1));
	  System.out.println("Code is entered");
  }
 
  @Test(priority=5,description="APP-490:save and close button")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  Reporter.log("Verify save and close button ---------->>");
	  SC_page.Save_and_Close();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Notification();
	  Thread.sleep(500);
	  
  }
  @Test(priority=6,description="APP-492:save multiple solutions of same name")
  public void Verify_multiple_solutions_of_same_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  Reporter.log("Verify multiple solutions of same name ---------->>");
	  SC_page.Creat_New_icon();
	  Thread.sleep(1000);
	  SC_page.Description("SD_desc", arr.get(0)); 
	  SC_page.code("SD_code", arr.get(1));
	  SC_page.Save_and_Close();
	  Thread.sleep(800);
	  SC_page.Notification();
	  Thread.sleep(800);
	  SC_page.Notification();
	  SC_page.Cancel();
	  Thread.sleep(1000);
	  SC_page.Notification();
  }
  
  @Test(priority=7,description="APP-491:save as new")
  public void Verify_Save_as_New_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify save as new button ---------->>");
	  ev.Table_event(arr.get(0), "SS_Standard_Solutions_table");
	  SC_page.Update_icon();
	  Thread.sleep(1000);
	  SC_page.Description("SD_desc", arr.get(0)+"New"); 
	  SC_page.code("SD_code", arr.get(1)+"New");
	  SC_page.Save_as_new();
	  Thread.sleep(800);
	  SC_page.Notification();
	  SC_page.Cancel();
	  Thread.sleep(500);
	  SC_page.Notification();
  }
  
  @Test(priority=8,description="APP-483:new+ mandatory fields")
  public void Verify_Mandatory_Fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  Reporter.log("Verify new+ mandatory fields ---------->>");
	  SC_page.Creat_New_icon();
	  Thread.sleep(1000);
	  SC_page.Save();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  SC_page.Cancel();
	  Thread.sleep(500);
	  SC_page.Notification();
  }
  
  @Test(priority=9,description="APP-493: Linking Standard solutions")
  public void Link_Standard_solutions_to_Disputes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Linking Standard solutions ---------->>");
	  ev.Table_event(arr.get(2), "SS_disputes_table");//Clicked on Distute table
	  ev.Table_event(arr.get(0), "SS_Standard_Solutions_table");        //Clicked on Standard Solution table
	  SC_page.link();
	  Thread.sleep(1500);
	  SC_page.SaveAll_Changes();
	  Thread.sleep(1500);
	  SC_page.Notification();
	  System.out.println("Newly Created Standard solutions is linked Successfully");
  }
  
  @Test(priority=10,description="APP-487:delete Linked Standard solutions")
  public void Delete_Linked_Standard_solutions_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  events ev = new events(driver);
	  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
	  FC_page.Click_Standard_solutions_tab();
	  Thread.sleep(1000);
	  SC_page.Render_Notifications();
	  Thread.sleep(500);
	  ev.Table_event(arr.get(0), "SS_Standard_Solutions_table");        //Clicked on Standard Solution table
	  Thread.sleep(500);
	  SC_page.Delete_icon();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1500);
	  SC_page.SaveAll_Changes();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=11)
  public void Link_NewlyAdded_Standred_causes_and_solutions_in_Standard_disputes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
	  Standard_Disputes_Page sd_page= new Standard_Disputes_Page(driver);
	  events evt = new events(driver);
	  Reporter.log("Verify _Newly Added Standred cause and Standard solution in_Standard disputes Section ---------->>");
	  FC_page.Click_Standard_Disputes_tab();
	  Thread.sleep(2000);
	  evt.Table_event(arr.get(4), "SD_Standard_dispute_table"); 
	  sd_page.Update_Dispute_icon();
	  Thread.sleep(1000);
	  sd_page.Complete_disputes_automatically();
	  Thread.sleep(1000);
	  sd_page.Automatic_cause("SD_auto_cause", arr.get(3));   //Standard cause
	  Thread.sleep(500);
	  sd_page.Automatic_solution("SD_auto_sol", arr.get(0));   //Standard Solution
	  sd_page.Save();
	  Thread.sleep(2000);
	  sd_page.Notification();
	  Thread.sleep(1000);
	  sd_page.Notification();
	  Thread.sleep(1000);
	  sd_page.Cancel();
	  Thread.sleep(1000);
	  sd_page.Notification();
	  Thread.sleep(1000);	  
	  sd_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=12,description="APP-487:delete")
  public void Verify_Delete_Standard_solutions_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Standard_Solutions_Page SC_page = new Standard_Solutions_Page(driver);
	  events ev = new events(driver);
	  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
	  FC_page.Click_Standard_solutions_tab();
	  Thread.sleep(1000);
	  SC_page.Notification_Yes();
	  Reporter.log("Verify Delete button functionality ---------->>");
	  ev.Table_event(arr.get(0)+"New", "SS_Standard_Solutions_table");        //Clicked on Standard Solution table
	  SC_page.Delete_icon();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(1000);
	  SC_page.SaveChanges();
	  Thread.sleep(1000);
	  SC_page.Notification();
	  Thread.sleep(500);
	  SC_page.Notification();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+"New", "SS_Standard_Solutions_table");
	  Reporter.log("<<======================{End: Standard solutions Tab}=======================>> ");
  }
}
