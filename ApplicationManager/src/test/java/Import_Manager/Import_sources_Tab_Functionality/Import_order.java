package Import_Manager.Import_sources_Tab_Functionality;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Home_index_Page;
import appMan_Pages.Import_Sources_Page;
import appMan_Pages.Import_order_page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Import_order {
	WebDriverManager mgr = new  WebDriverManager();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("IM_Import_Order");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Open_Import_order_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  //Home_index_Page HI_page= PageFactory.initElements(driver, Home_index_Page.class);
	  Import_order_page ImpO_page= PageFactory.initElements(driver, Import_order_page.class);
	  Reporter.log("<<======================{Import Order}=======================>> ");
	 // HI_page.Select_Import_Manager_Tab();
	  //Thread.sleep(1000);
	  ImpO_page.Clickon_import_order_Tab();
	  Thread.sleep(1500);
  }
  
  @Test(priority=2,description="APP-591:Sorting the administration grid")
  public void Sort_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_order_page ImpO_page= PageFactory.initElements(driver, Import_order_page.class);
	  events eve =  new events(driver);
	  Reporter.log("********APP-591:Sorting the administration grid********");
	  ImpO_page.Change_Icon();
	  eve.Sort_From_Table("IO_Admin_table", arr.get(0), arr.get(1));
	  Reporter.log("********End :TestCase- APP-591  ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority=3,description="APP-592:Sorting the Import source")
  public void Sort_Import_source() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_order_page ImpO_page= PageFactory.initElements(driver, Import_order_page.class);
	  events eve =  new events(driver);
	  Reporter.log("********APP-592:Sorting the Import source********");
	  ImpO_page.Change_Icon();
	  eve.Table_event(arr.get(0), "IO_Admin_table");
	  Thread.sleep(1000);
	  eve.Sort_From_Table("IO_imp_src_table", arr.get(2), arr.get(3));
	  ImpO_page.Save_icon();
	  Thread.sleep(1000);
	  ImpO_page.Save_changes_Notification();
	  Thread.sleep(1000);
	  ImpO_page.Save_changes_Notification();
	  Reporter.log("********End :TestCase- APP-592  ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority=4)
  public void Save_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_order_page ImpO_page= PageFactory.initElements(driver, Import_order_page.class);
	  ImpO_page.Save_icon();
	  Thread.sleep(3000);
	  ImpO_page.Save_changes_Notification();
	  Thread.sleep(1000);
	  ImpO_page.Save_changes_Notification();
	  Thread.sleep(2000);
  }
  
  @Test(priority=5,description="APP-581:Delete import source button")
  public void Delete_Import_sources_Linked_to_Administrator() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Reporter.log("********APP-581:Delete import source button********");
	  Import_Sources_Page IS_page= PageFactory.initElements(driver, Import_Sources_Page.class);
	  IS_page.Clickon_import_sources_Tab();
	  Thread.sleep(500);
	  eve.Click_event("sort_Import_sources_table");
	  Thread.sleep(500);
	  eve.Table_event(mgr.getparam("IM_Import_Sources",0), "Import_sources_table");
	  Thread.sleep(500);
	  IS_page.Delete_icon();
	  Thread.sleep(1000);
	  IS_page.Save_changes_Notification();
	  Thread.sleep(1000);
	  IS_page.Save_changes_Notification();
	  Reporter.log("********End :TestCase- APP-581  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=6)
  public void render_back_to_Home_Index_page () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_order_page ImpO_page= PageFactory.initElements(driver, Import_order_page.class);
	  Home_index_Page hi= new Home_index_Page(driver);
	  hi.Import_Source_Index();
	  ImpO_page.Render_Notifications();
	  System.out.println("Rendered back to Home page");
	  Thread.sleep(1000);
  }
}
