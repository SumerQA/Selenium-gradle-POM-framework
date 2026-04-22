package Functional_Configration.Communication;

import java.io.File;
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
import appMan_Pages.Documents_and_templetes_Page;
import appMan_Pages.entity_tables_Page;
@Listeners(ScreenShotOnFailure.class)
public class Entity_tables {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Comm_entity_tables");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Entity_tables_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  Reporter.log("<<======================{Entity tables Tab}=======================>> ");
	  //et_page.Goto_communication_page();
	  Thread.sleep(2000);
	  et_page.Click_on_Entity_Tables_tab();
	  Thread.sleep(1500);
	  System.out.println("Entity tables page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  et_page.Creat_New_icon();
	  Thread.sleep(1500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Entity_tables_Name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  Reporter.log("Enter Entity table Name ---------->>");
	  et_page.Entity_table_Name("et_etname", arr.get(0));
	  Thread.sleep(1000);
  }
  @Test(priority=4)
  public void Enter_Description() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  et_page.Description("et_des", arr.get(1));
	  Thread.sleep(1000);
  }
  @Test(priority=5)
  public void Enter_Entity_values() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  et_page.Enter_Entity_Values("et_eValues_table", "Test",false);
	  Thread.sleep(1000);
  }
  @Test(priority=6)
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  Reporter.log("Verify Save and Close Button ---------->>");
	  et_page.Save_and_Close();
	  Thread.sleep(1000);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Notification();
  }
  @Test(priority=7)
  public void Verify_mandatoty_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  et_page.Creat_New_icon();
	  Thread.sleep(1000);
	  //et_page.Entity_table_Name("et_etname", arr.get(0));
	  et_page.Description("et_des", arr.get(1));
	  et_page.Enter_Entity_Values("et_eValues_table", "Test",false);
	  et_page.Save_and_Close();
	  Thread.sleep(1000);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Cancel();
	  Thread.sleep(1000);
	  et_page.Notification();
	}
  @Test(priority=8)
  public void Verify_Save_and_Cancel_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  et_page.Creat_New_icon();
	  Thread.sleep(1500);
	  et_page.Entity_table_Name("et_etname", arr.get(0)+" Save");
	  et_page.Description("et_des", arr.get(1));
	  et_page.Enter_Entity_Values("et_eValues_table", "SAVE",false);
	  et_page.Save();
	  Thread.sleep(1000);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Cancel();
	  Thread.sleep(1000);
	  et_page.Notification();
	}
  
  @Test(priority=9)
  public void Verify_Save_As_New_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  et_page.Creat_New_icon();
	  Thread.sleep(1000);
	  et_page.Entity_table_Name("et_etname", arr.get(0)+" Save As New");
	  et_page.Description("et_des", arr.get(1));
	  et_page.Enter_Entity_Values("et_eValues_table", "SAN",false);
	  et_page.Save_sa_New();
	  Thread.sleep(1000);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Cancel();
	  Thread.sleep(1000);
	  et_page.Notification();
	}
  
  @Test(priority=10)
  public void Verify_Reload_and_Cancel_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  et_page.Creat_New_icon();
	  Thread.sleep(1000);
	  et_page.Entity_table_Name("et_etname", arr.get(0)+" Reload");
	  et_page.Description("et_des", arr.get(1));
	  et_page.Enter_Entity_Values("et_eValues_table", "RAC",false);
	  et_page.Refresh();
	  Thread.sleep(1000);
	  et_page.Cancel();
	  Thread.sleep(1000);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Notification();
	}
  
  @Test(priority=11)
  public void Update_Entity_Values() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  eve.Table_event( arr.get(0), "et_entity_table");
	  et_page.Update_icon();
	  Thread.sleep(1000);
	  et_page.Enter_Entity_Values("et_eValues_table", "Update",true);
	  Thread.sleep(1000);
	  et_page.Save_and_Close();
	  Thread.sleep(1500);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Notification();
	}
  @Test(priority=12)
  public void Uplaod_and_Delete_entityItem20File() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  entity_tables_Page et_page = new entity_tables_Page(driver);
	  eve.Table_event( arr.get(0), "et_entity_table");
	  et_page.Update_icon();
	  Thread.sleep(1000);
	  File file = new File("Autoit_Script");                                   //File upload Script folder
	  et_page.Entity_Item20("et_upload_icon",file.getAbsolutePath()+"/upload.exe", "file:///"+file.getAbsolutePath()+"/interest_sch.jpg");
	  Thread.sleep(1000);
	  et_page.Save_and_Close();
	  Thread.sleep(1500);
	  et_page.Notification();
	  Thread.sleep(1000);
	  et_page.Notification();
	}

  @Test(priority=13)
  public void Link_Entity_tables_to_Admin() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Linking the Entity Table to Admin ---------->>");
	  Thread.sleep(1000);
	  eve.Table_event(arr.get(3),"et_admin_tbl");
	  Thread.sleep(1000);
	  eve.Table_event( arr.get(0), "et_entity_table");
	  Thread.sleep(1000);
	  c_page.link();
	  Thread.sleep(1000);
	  c_page.Save_Panal();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
  }
  @Test(priority=14)
  public void Delete_Entity_tables_After_Linking_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"et_entity_table");
	  Thread.sleep(1000);
	  c_page.Delete_icon();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  Thread.sleep(1000);
	  c_page.Notification();
  }
  @Test(priority=15)
  public void UnLink_Entity_tables_from_selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Unlinking Entity Table ---------->>");
	  eve.Table_event(arr.get(0),"et_entity_Unlink_table");
	  Thread.sleep(1000);
	  c_page.Unlink();
	  Thread.sleep(2000);
	  c_page.Save_Panal();
	  Thread.sleep(500);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();
  }
  @Test(priority=16)
  public void Delete_Entity_tables_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event( arr.get(0)+" Save As New","et_entity_table");
	  Thread.sleep(1000);
	  c_page.Delete_icon();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  Thread.sleep(1000);
	  c_page.Notification();
	  Reporter.log("<<======================{End : Entity Tables Section}=======================>> ");
  }
}	 
