package Functional_Configration.Disputes;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Dispute_Action_Page;
import appMan_Pages.Functional_Configration_Page;
import appMan_Pages.Home_index_Page;
import appMan_Pages.Request_Page;
import appMan_Pages.Standard_Disputes_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Dispute_action {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("D_Dispute_Action");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 
	  @Test(priority=1)
	  public void Create_Dispute_requests() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Page r_page = new Request_Page(driver);
		  Reporter.log("<<======================{Dispute action Tab}=======================>> ");
		  Reporter.log("Create Dispute Request ---------->>");
		 Home_index_Page HI_page = new Home_index_Page(driver);
		  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		 // HI_page.Select_Functional_Configration_Tab();
		 // Thread.sleep(800);
		  FC_page.Request_tab();
		  Thread.sleep(1000);
		  HI_page.Render_Notifications();
		  Thread.sleep(500);
		  r_page.Creat_New_icon();
		  Thread.sleep(500);
		  r_page.Request_Name("RE_req_name", arr.get(0));
		  Thread.sleep(500);
		  r_page.Request_type("RE_req_type", arr.get(1),"RE_standard_act_taker", arr.get(6));
		  Thread.sleep(500);
		  r_page.Description("RE_description", arr.get(2));
		  Thread.sleep(300);
		  r_page.Period("RE_period",arr.get(4));
		  Thread.sleep(300);
		  r_page.Template("RE_Templete", arr.get(5));
		  Thread.sleep(300);
		  r_page.Save_and_Close();
		  Thread.sleep(500);
		  r_page.Notification();
		  Thread.sleep(500);
		  r_page.Notification();
		 System.out.println("New Dispute Request Is Created");
	  }
	  @Test(priority=2)
	  public void Goto_Dispute_action_Page() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Dispute_Action_Page DA_page = new Dispute_Action_Page(driver);
		  DA_page.Goto_Dispute_Action_page();
		  Thread.sleep(500);
		  System.out.println("Dispute action Page is opened");
	  }
	  @Test(priority=3,description="APP-509:linking actions")
	  public void Link_Inserted_requests_to_Administrations() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Dispute_Action_Page DA_page = new Dispute_Action_Page(driver);
		  events eve= new events(driver);
		  Reporter.log("Verify linking actions  ---------->>");
		  eve.Table_event(arr.get(7), "C_curr_admin_table");
		  eve.Table_event(arr.get(0), "DA_Dis_Act_table");
		  DA_page.link();	
		  Thread.sleep(500);
		  DA_page.SaveAll_Changes();
		  Thread.sleep(500);
		  DA_page.Notification();
		  Thread.sleep(500);
		  DA_page.Refresh();
		  Thread.sleep(500);
		  DA_page.Notification();
		  System.out.println("Linked to Selected Disputes");
	  }
	 
	 /* @Test(priority=4)
	  public void UnLink_from_LinkedDispute_Table() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Dispute_Action_Page DA_page = new Dispute_Action_Page(driver);
		  events eve= new events(driver);
		  eve.Table_event(arr.get(0), "DA_dis_act_linked_table");
		  DA_page.Unlink();
		  DA_page.SaveAll_Changes();
		  DA_page.Notification();
		  DA_page.Notification();
		  Thread.sleep(2000);
		  System.out.println("UnLinked Successfully");
	  }*/
	  @Test(priority=5)
	  public void Link_NewlyAdded_Dispute_action_in_Standard_disputes() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		  Standard_Disputes_Page sd_page= new Standard_Disputes_Page(driver);
		  Home_index_Page HI_page = new Home_index_Page(driver);
		  events evt = new events(driver);
		  Reporter.log("Verify Newly Added Dispute action in Standard disputes  ---------->>");
		  FC_page.Click_Standard_Disputes_tab();
		  Thread.sleep(2000);
		  HI_page.Render_Notifications();
		  Thread.sleep(500);
		  evt.Table_event(arr.get(7), "SD_Standard_dispute_table"); 
		  Thread.sleep(500);
		  sd_page.Update_Dispute_icon();
		  Thread.sleep(500);
		  sd_page.Automatic_cause("SD_auto_Solution", arr.get(0));
		  Thread.sleep(500);
		  sd_page.Save_and_Close();
		  Thread.sleep(500);
		  sd_page.Notification();
		  Thread.sleep(500);
		  sd_page.Notification();
		  Reporter.log("<<======================{End : Dispute action Section}=======================>> ");
	  }
}
