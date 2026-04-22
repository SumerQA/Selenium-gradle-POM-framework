package Queue;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Configration_Files.connectDB;
import Event_commands.events;
import appMan_Pages.queue_page;
@Listeners(ScreenShotOnFailure.class)
public class Queue {
	connectDB db = new connectDB();
	Common c= new Common();
  @Test(priority=2)
  public void Open_Queue_Tab() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.open_queue_page();
	  Thread.sleep(1000);
	  
	  
  }
  
@Test(priority=3)
  public void Verify_Select_All_Button() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.SelectAll();
	  Thread.sleep(1000);
  }
  @Test(priority=4)
  public void Verify_Deselect_All_Button() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.DeselectAll();
	  Thread.sleep(1000);
  }
  @Test(priority=5)
  public void Verify_Column_Button() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.Columns_Icon();
	  Thread.sleep(1000);
  }
  @Test(priority=6)
  public void Uncheck_SelectAll_Checkbox() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.Select_All("NO");
	  Thread.sleep(1000);
	  qp.Columns_Icon();
	  
  }
  @Test(priority=7)
  public void Check_SelectAll_Checkbox() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.Columns_Icon();
	  Thread.sleep(1000);
	  qp.Select_All("Yes");
	  Thread.sleep(1000);
	  qp.Columns_Icon();
  }
  @Test(priority=8)
  public void Verify_Search_in_Column() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  qp.Columns_Icon();
	  Thread.sleep(1000);
	  qp.Select_All("No");
	  qp.Columns_Icon();
	  Thread.sleep(1000);
	  qp.Columns_Icon();
	  qp.Search_Column_Input("cus");
	  Thread.sleep(1500);
	  qp.Select_and_Search_Column("BS_search_TaskType");
	  Thread.sleep(1000);
	  qp.Columns_Icon();
  }
  @Test(priority=9)
  public void Verify_Searched_Column_in_Grid() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  Thread.sleep(1500);
	  qp.Get_Column_Name("Q_tble_Column_name");
	  Thread.sleep(1000);
	  
  }
  @Test(priority=10)
  public void Verify_Refresh_Icon() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  events eve = new events(driver);
	  eve.Drag_and_Drop("Q_table");
	  Thread.sleep(1000);
	  qp.Refresh();
	  Thread.sleep(2000);
	  qp.Columns_Icon();
	  Thread.sleep(1000);
	  qp.Select_All("Yes");
	  qp.Columns_Icon();
	  Thread.sleep(1000);
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=11)
  public void Verify_Send_According_to_Batch_rules_For_Single_Action(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  events eve = new events(driver);
	  qp.send();
	  Thread.sleep(1500);
	  qp.Notification("Yes");
	  Thread.sleep(1500);
	  String myque=eve.getLocale(Locale, "Queued");
	  Thread.sleep(1000);
	  String status = db.getQuery(DataSource,DatabaseName,myque);
	  Thread.sleep(1000);
	  if(qp.Search_and_SelectColumn("Q_table", status)){
		  Thread.sleep(1000);
		  qp.send();
		  Thread.sleep(2000);
		  qp.Notification("Yes");
		  qp.According_to_batch_rules_DDlist("Batch Rule for Print");
		  Thread.sleep(1000);
		  qp.Archive_CheckBox("Yes");
		  Thread.sleep(1000);
		  qp.Cancel_acc_to_batch_rule();
		  Thread.sleep(1500);
		  qp.send();
		  Thread.sleep(2000);
		  qp.Notification("Yes");
		  qp.According_to_batch_rules_DDlist("Batch Rule for Print");
		  qp.Archive_CheckBox("Yes");
		  qp.OK_acc_to_batch_rule();
		  Thread.sleep(1500);
		  qp.Notification("Yes");
		  Thread.sleep(5000);
		  qp.Refresh();
		  qp.Notification("Yes");
		  Thread.sleep(2000);
	  } else{
		  System.out.println("Item does not exists or queued");
		  Reporter.log("Item does not exists or queued");
	  }      
	 
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=12)
  public void Verify_Send_According_to_Batch_rules_For_Multiple_Action(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  events eve = new events(driver);
	  String myque=eve.getLocale(Locale, "Queued");
	  String status = db.getQuery(DataSource,DatabaseName,myque);
	  if(qp.Search_and_SelectMultiple_Column("Q_table", status)){
		  Thread.sleep(1000);
		  qp.send();
		  Thread.sleep(2000);
		  qp.Notification("Yes");
		  qp.According_to_batch_rules_DDlist("Batch Rule for Export");
		  Thread.sleep(1000);
		  qp.Archive_CheckBox("Yes");
		  Thread.sleep(1000);
		  qp.OK_acc_to_batch_rule();
		  Thread.sleep(1500);
		  qp.Notification("Yes");
		  Thread.sleep(5000);
		  qp.Refresh();
		  Thread.sleep(2000); 
	  } else{
		  System.out.println("Item doesnot exists or queued");
		  Reporter.log("Item does not exists or queued");
	  }
	 
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=13)
  public void Delete_Failed_Action_From_Queue(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  events eve = new events(driver);
	  Thread.sleep(3000);
	  String myque=eve.getLocale(Locale, "failed");
	  String status = db.getQuery(DataSource,DatabaseName,myque);
	  if(qp.Search_and_SelectColumn("Q_table", status)){
		  try {
			  qp.Delete();
			  qp.Notification("Yes");
			  qp.Notification("Yes");
		} catch (Exception e) {
			// TODO: handle exception
		}
		  Thread.sleep(2000);
		  qp.Notification("No");
		  Thread.sleep(1500);
		  qp.Notification("No");
	  }
	  
	  String myque1=eve.getLocale(Locale, "failed");
	  String status1 = db.getQuery(DataSource,DatabaseName,myque1);
	  if(qp.Search_and_SelectColumn("Q_table", status1)){
		  Thread.sleep(1000);
		  qp.Delete();
		  Thread.sleep(1000);
		  qp.Reason_Notification("No Comments please");
		  Thread.sleep(1000);
		  qp.Notification("Yes");
		  qp.Notification("Yes");
		  Thread.sleep(1500);
		  qp.Refresh();
		  Thread.sleep(3000);  
	  }
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=14)
  public void Delete_Multiple_Action_From_Queue(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  queue_page qp = new queue_page(driver);
	  events eve = new events(driver);
	  String myque=eve.getLocale(Locale, "failed");
	  String status = db.getQuery(DataSource,DatabaseName,myque);
	  if(qp.Search_and_SelectMultiple_Column("Q_table", status)){
		  Thread.sleep(1000);
		  try {
			  qp.Delete();
			  Thread.sleep(1000);
			  qp.Notification("Yes");
			  qp.Notification("Yes");
		} catch (Exception e) {
			// TODO: handle exception
		}
		  Thread.sleep(2000);
		  qp.Notification("No");
		  qp.Notification("No");
	  }
	  String myque1=eve.getLocale(Locale, "failed");
	  String status1 = db.getQuery(DataSource,DatabaseName,myque1);
	  if(qp.Search_and_SelectMultiple_Column("Q_table", status1)){
		  Thread.sleep(1000);
		  qp.Delete();
		  Thread.sleep(1000);
		  qp.Reason_Notification("No Comments please");
		  Thread.sleep(1000);
		  qp.Notification("Yes");
		  Thread.sleep(1000);
		  qp.Notification("Yes");
		  Thread.sleep(2000); 
	  }else{
		  System.out.println("Items with failed status not found");
		  Reporter.log("Items with failed status not found");
		  
	  }
	  
  }
}
