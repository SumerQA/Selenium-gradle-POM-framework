package Import_Manager.Import_sources_Tab_Functionality;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import appMan_Pages.Import_Log_Page;
@Listeners(ScreenShotOnFailure.class)
public class Import_Log {
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("IM_Import_Log");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	 }
	
  @Test(priority=1)
  public void Open_Importlog_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	// Home_index_Page HI_page= PageFactory.initElements(driver, Home_index_Page.class);
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("<<======================{Import manager -Import Log}=======================>> ");
	 // HI_page.Select_Import_Manager_Tab();
	 // Thread.sleep(1500);
	  Impl_page.Goto_import_Log_Tab();
	  //driver.navigate().refresh();
	  Thread.sleep(3000);
	  
  }
  
  @Test(priority=2,description="APP-598:Edit import log settings button")
  public void Clickon_Change_Icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("********APP-598:Edit import log settings button********");
	 // driver.navigate().refresh();
	  Impl_page.change_icon();
	  Thread.sleep(2000);
	  Reporter.log("********End :TestCase- APP-598  ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority=3,description="APP-597:For Edit check-box 'Import log (in database) remove after'")
  public void Import_LoginDB_remove_after() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("********APP-597:For Edit check-box 'Import log (in database) remove after'********");
	  Impl_page.Import_Log_remove_After(arr.get(0),arr.get(1));
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-597  ********");
	  Reporter.log("----------------------------------------");
	  }
  @Test(priority=4,description="APP-599:verify values in combobox")
  public void Select_Importlog_the_messages_screen_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("********APP-599:verify values in combobox'********");
	  Impl_page.ImportLog_messages_screen(arr.get(2));
  }
  @Test(priority=5,description="APP-599:verify values in combobox")
  public void Select_Importlog_the_messages_Database_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Impl_page.ImportLog_messages_Database(arr.get(3));
  }
  @Test(priority=6,description="APP-599:verify values in combobox")
  public void Select_Importlog_the_messages_Windows_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Impl_page.ImportLog_messages_Window(arr.get(4));
	  Reporter.log("********End :TestCase- APP-599  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7,description="APP-600: Select import log to view")
  public void Select_importlog_to_view () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("********APP-600: Select import log to view********");
	  Impl_page.Select_importLog_to_View();
	  
  }
  @Test(priority=8,description="APP-600: Select import log to view")
  public void read_All_logs() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Impl_page.View_log();
	  Impl_page.Read_All_logs();
	  Reporter.log("********End :TestCase- APP-600  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=9,description="APP-596:For save button")
  public void Save_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("********APP-596:For save button********");
	  Impl_page.Save();
	  Thread.sleep(3000);
	  Impl_page.Save_changes_Notification();
	  Thread.sleep(500);
	  Impl_page.Save_changes_Notification();
	  Reporter.log("********End :TestCase- APP-596  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=9,description="APP-595:For Reload button")
  public void Reload_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Import_Log_Page Impl_page= PageFactory.initElements(driver, Import_Log_Page.class);
	  Reporter.log("********APP-595:For Reload button********");
	  Impl_page.change_icon();
	  Thread.sleep(500);
	  Impl_page.ImportLog_messages_screen(arr.get(2));
	  Thread.sleep(500);
	  Impl_page.refresh();
	  Impl_page.Save_changes_Notification();
	  Thread.sleep(500);
	  Impl_page.Save_changes_Notification();
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-595  ********");
	  Reporter.log("----------------------------------------");
  }
 
 
}
