package Batch_scheduler;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Batch_rules_page;
import appMan_Pages.batch_Scheduler_page;
@Listeners(ScreenShotOnFailure.class)
public class Batch_scheduler {
	String immidiate_task_Print ="Immidiate Print2";
  @Test(priority=1)
  public void Open_batch_scheduler() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.open_batch_Scheduler_page();
	  Thread.sleep(2000);
  }
@Test(priority=2)
  public void Create_Immidiate_Schedule_task_For_Print() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name(immidiate_task_Print);
	  ps_page.TaskType("0");   //print
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Print");  //Email
	  Thread.sleep(1000);
	  ps_page.Immidiate_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=3)
  public void Create_Filter_Immidiate_Schedule_task_For_Print() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  ps_page.Filters_DDlist("Customer Alphanumeric");   // Alphanumeric UDF field
	  ps_page.Filters_Condition("0");  //= Is equal to
	  Thread.sleep(700);
	  ps_page.Filters_Input("9");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
  }
  @Test(priority=4)
  public void Save_and_Close_Button() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  
  @Test(priority=5)
  public void Create_Daily_EveryDay_Schedule_task_For_Print() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily EveryDay Print");
	  ps_page.TaskType("0");   //print
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Print");  //Email         
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_radio_button_schedule_pattern();
	  Thread.sleep(500);
	  ps_page.Every_Days_Input_schedule_pattern("1");
	  Thread.sleep(1500);
	  ps_page.Start_Tyme_DDlist("18:30");
	  Thread.sleep(500);
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=6)
  public void Create_Filter_Daily_EveryDay_Schedule_task_For_Print() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new appMan_Pages.batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Numeric");   // Numeric UDF field
	  ps_page.Filters_Condition("1");  // > Is greater than
	  Thread.sleep(700);
	  ps_page.Filters_Input("7");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
  }
  
  @Test(priority=7)
  public void Save_and_Cancel_Button() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Save();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
	  ps_page.Cancel();
	  
  }
  @Test(priority=8)
  public void Create_Weekly_Schedule_task_For_Print() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Weekly Print");
	  ps_page.TaskType("0");   //print
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Print");  //Email
	  Thread.sleep(1000);
	  ps_page.Weekly_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeeksOn_Input_schedule_pattern("1");
	  Thread.sleep(500);
	  ps_page.Monday("Yes");
	  ps_page.Friday("Yes");
	  Thread.sleep(1000);
	  ps_page.Start_Tyme_DDlist("18:30");
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=9)
  public void Create_Filter_Weekly_Schedule_task_For_Print() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Logical");   //logical UDF field
	  ps_page.Logical_DD("True");  //logical value -True ,False
	  Thread.sleep(1000);
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=10)
  public void Create_Daily_EveryWeekDay_Schedule_task_For_Print() throws InterruptedException, StaleElementReferenceException{
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Weekly Every Week Day Print");
	  ps_page.TaskType("0");   //print
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Print");  //Email
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeekDay_rButtonschedule_pattern();
	  Thread.sleep(500);
	  ps_page.Start_Tyme_DDlist("18:00");
	  Thread.sleep(500);
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=11)
  public void Create_Filter_Daily_EveryWeekDay_Schedule_task_For_Print() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Date");   //Date UDF field
	  ps_page.Filters_Condition("2");  //< Is less than
	  Thread.sleep(700);
	  ps_page.Date_Input("7/28/2016");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  
  @Test(priority=12)
  public void Create_Immidiate_Schedule_task_For_Email() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Immidiate Email");
	  ps_page.TaskType("1");   //Email
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Email");  //Email
	  Thread.sleep(1000);
	  ps_page.Immidiate_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  
  @Test(priority=13)
  public void Create_Filter_Immidiate_Schedule_task_For_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Picklist");   //picklist UDF field
	  ps_page.Filters_Condition("0"); // equal to
	  Thread.sleep(700);
	  ps_page.filter_picklist_value("TestPicklist value");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(1000);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  
  @Test(priority=14)
  public void Create_Daily_EveryDay_Schedule_task_For_Email() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Every Day Email");
	  ps_page.TaskType("1");   //Email-----
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Email");  //Email
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_radio_button_schedule_pattern();
	  Thread.sleep(500);
	  ps_page.Every_Days_Input_schedule_pattern("2");
	  Thread.sleep(500);
	  ps_page.Start_Tyme_DDlist("18:30");
	  Thread.sleep(500);
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=15)
  public void Create_Filter_Daily_EveryDay_Schedule_task_For_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Curr Code");   //Currency Code UDF field
	  ps_page.Filters_Condition("0");  //= Is equal to
	  Thread.sleep(700);
	  ps_page.filter_currencyCode_DDlist("USD");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=16)
  public void Create_Weekly_Schedule_task_For_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Weekly Email Task");
	  ps_page.TaskType("1");   //Email----
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Email");  //Email
	  Thread.sleep(1000);
	  ps_page.Weekly_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeeksOn_Input_schedule_pattern("1");
	  Thread.sleep(500);
	  ps_page.Monday("Yes");
	  ps_page.Friday("Yes");
	  Thread.sleep(1000);
	  ps_page.Start_Tyme_DDlist("19:30");
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=17)
  public void Create_Filter_Weekly_Schedule_task_For_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Currency");   //Currency UDF field
	  ps_page.Filters_Condition("5");  //= Is equal to
	  Thread.sleep(700);
	  ps_page.Filters_Input("19");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=18)
  public void Create_Daily_EveryWeekDay_Schedule_task_For_Email() throws InterruptedException,StaleElementReferenceException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Every Week Day Email");
	  ps_page.TaskType("1");   //Email --
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Email");  //Email
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeekDay_rButtonschedule_pattern();
	  Thread.sleep(500);
	  ps_page.Start_Tyme_DDlist("19:30");
	  Thread.sleep(500);
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=19)
  public void Create_Filter_Daily_EveryWeekDay_Schedule_task_For_Email() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Alphanumeric");   //Alphanumeric UDF
	  ps_page.Filters_Condition("6");  //Starts with
	  Thread.sleep(700);
	  ps_page.Filters_Input("S");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  
  @Test(priority=20)
  public void Create_Immidiate_Schedule_task_For_Export() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Immidiate Export");
	  ps_page.TaskType("3");   //Export
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Export");  //Email
	  Thread.sleep(1000);
	  ps_page.Immidiate_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  
  @Test(priority=21)
  public void Create_Filter_Immidiate_Schedule_task_For_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Alphanumeric");   //Alphanumeric UDF
	  ps_page.Filters_Condition("7");  //Contains
	  Thread.sleep(700);
	  ps_page.Filters_Input("A4");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  
  @Test(priority=22)
  public void Create_Daily_EveryDay_Schedule_task_For_Export() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Every Day Export");
	  ps_page.TaskType("3");   //Export-----
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Export");  //Email
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_radio_button_schedule_pattern();
	  Thread.sleep(500);
	  ps_page.Every_Days_Input_schedule_pattern("1");
	  Thread.sleep(700);
	  ps_page.Start_Tyme_DDlist("19:00");
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=23)
  public void Create_Filter_Daily_EveryDay_Schedule_task_For_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Alphanumeric");   //Alphanumeric
	  ps_page.Filters_Condition("9");  //Doesn't start with
	  Thread.sleep(700);
	  ps_page.Filters_Input("S");
	  ps_page.Cancel_filer();
	  Thread.sleep(1500);
	  ps_page.Save_and_Close();
	  Thread.sleep(2000);
	  ps_page.Notification();
	  Thread.sleep(1500);
	  ps_page.Notification();
  }
  @Test(priority=24)
  public void Create_Weekly_Schedule_task_For_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Weekly Export");
	  ps_page.TaskType("3");   //Export----
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Export");  //Export
	  Thread.sleep(1000);
	  ps_page.Weekly_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeeksOn_Input_schedule_pattern("1");
	  Thread.sleep(500);
	  ps_page.Monday("Yes");
	  ps_page.Friday("FR");
	  Thread.sleep(1000);
	  ps_page.Start_Tyme_DDlist("18:30");
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=25)
  public void Create_Filter_Weekly_Schedule_task_For_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Alphanumeric");   //Alphanumeric UDF
	  ps_page.Filters_Condition("10");  //Doesn't contain the text
	  Thread.sleep(700);
	  ps_page.Filters_Input("X");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=26)
  public void Create_Daily_EveryWeekDay_Schedule_task_For_Export() throws InterruptedException ,StaleElementReferenceException{
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Every Week Day Export");
	  ps_page.TaskType("3");   //Export --
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Export");  //Export
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeekDay_rButtonschedule_pattern();
	  Thread.sleep(500);
	  ps_page.Start_Tyme_DDlist("21:30");
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=27)
  public void Create_Filter_Daily_EveryWeekDay_Schedule_task_For_Export() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Numeric");   //Numeric UDF
	  ps_page.Filters_Condition("4");  //<= Is less than or equal to
	  Thread.sleep(700);
	  ps_page.Filters_Input("20");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=28)
  public void Create_Immidiate_Schedule_task_For_SMS() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Immidiate SMS");
	  ps_page.TaskType("4");   //SMS
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for Export");  //Email
	  Thread.sleep(1000);
	  ps_page.Immidiate_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  
  @Test(priority=29)
  public void Create_Filter_Immidiate_Schedule_task_For_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Numeric");   //Customer Number
	  ps_page.Filters_Condition("3");  //>= Is greater than or equal to
	  Thread.sleep(700);
	  ps_page.Filters_Input("5");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  
  @Test(priority=30)
  public void Create_Daily_EveryDay_Schedule_task_For_SMS() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Every Day SMS");
	  ps_page.TaskType("4");   //SMS-----
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for SMS");  //SMS
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_radio_button_schedule_pattern();
	  Thread.sleep(500);
	  ps_page.Every_Days_Input_schedule_pattern("1");
	  Thread.sleep(500);
	  ps_page.Start_Tyme_DDlist("18:30");
	  Thread.sleep(500);
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=31)
  public void Create_Filter_Daily_EveryDay_Schedule_task_For_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Numeric");   //Numeric UDF field
	  ps_page.Filters_Condition("0");  //= Is equal to 
	  Thread.sleep(700);
	  ps_page.Filters_Input("19");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=32)
  public void Create_Weekly_Schedule_task_For_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Weekly SMS");
	  ps_page.TaskType("4");   //SMS----
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for SMS");  //Email
	  Thread.sleep(1000);
	  ps_page.Weekly_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeeksOn_Input_schedule_pattern("1");
	  Thread.sleep(500);
	  ps_page.Monday("Yes");
	  ps_page.Friday("Yes");
	  Thread.sleep(1000);
	  ps_page.Start_Tyme_DDlist("19:30");
	  ps_page.Order_By("Yes", "1", "2");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=33)
  public void Create_Filter_Weekly_Schedule_task_For_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Numeric");   //Customer Number
	  ps_page.Filters_Condition("1");  //> Is greater than
	  Thread.sleep(700);
	  ps_page.Filters_Input("9");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(500);
	  ps_page.Notification();
  }
  @Test(priority=34)
  public void Create_Daily_EveryWeekDay_Schedule_task_For_SMS() throws InterruptedException,StaleElementReferenceException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Create_Button();
	  Thread.sleep(2000);
	  ps_page.Scheduke_Name("Daily Every Week Day SMS");
	  ps_page.TaskType("4");   //SMS --
	  Thread.sleep(1000);
	  ps_page.Batch_rule_used("Batch Rule for SMS");  //Email
	  Thread.sleep(1000);
	  ps_page.Daily_schedule_pattern();
	  Thread.sleep(1000);
	  ps_page.Every_WeekDay_rButtonschedule_pattern();
	  Thread.sleep(500);
	  ps_page.Start_Tyme_DDlist("21:30");
	  ps_page.Order_By("Yes", "1", "1");
	  Thread.sleep(1000);
	  ps_page.Archive("No", "1");
	  Thread.sleep(1000);
  }
  @Test(priority=35)
  public void Create_Filter_Daily_EveryWeekDay_Schedule_task_For_SMS() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Filters_DDlist();
	  Thread.sleep(1000);
	  ps_page.New_filer_Icon();
	  Thread.sleep(1000);
	  //ps_page.TaskType("0");
	  ps_page.Filters_DDlist("Customer Currency");   //Customer Number
	  ps_page.Filters_Condition("5");  //<> Not equal to
	  Thread.sleep(700);
	  ps_page.Filters_Input("USD");
	  ps_page.Cancel_filer();
	  Thread.sleep(1000);
	  ps_page.Save_and_Close();
	  Thread.sleep(500);
	  ps_page.Notification();
	  Thread.sleep(1500);
	  ps_page.Notification();
  }
  
  @Test(priority=36)
  public void Find_Immidiate_Schedule_task() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  ps_page.Find_Schedule_Task_From_Grid("BS_Immidiate_task_grid");
	  Thread.sleep(1500);
  }
  @Test(priority=37)
  public void Update_Immidiate_Schedule_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.Update_Schedule_Task_From_Grid("BS_Immidiate_task_grid",immidiate_task_Print);
		  Thread.sleep(1500);
		  ps_page.Change_Button();
		  Thread.sleep(1500);
		  ps_page.Notification();
		  Thread.sleep(1500);
		  ps_page.Archive("Yes", "Export for batch");
		  Thread.sleep(1000);
		  ps_page.Save();
		  Thread.sleep(1500);
		  ps_page.Notification();
		  Thread.sleep(800);
		  ps_page.Cancel();
		  Thread.sleep(1500);
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Records not found");
		
	}
	 
  }
  @Test(priority=38)
  public void open_Batch_Log_for_Immidiate_Schedule_task() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.open_batch_log("BS_Immidiate_task_grid", immidiate_task_Print);
		  Thread.sleep(1500);
		  ps_page.Notification();
		  ps_page.View__Scheduled_Task("BS_batch_log");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		  ps_page.Cancel_batch_Log();
		  Thread.sleep(2000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
  @Test(priority=39)
  public void Find_All_Day_ScheduledTask() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.Day_Task();
		  Thread.sleep(1500);
		  System.out.println("Task Schedulded for a day---->>");
		  ps_page.Find_Schedule_Task_From_Grid("BS_All_scheduled_task_grid");
		  Thread.sleep(1500);
		  ps_page.Notification();
		  System.out.println("-----------------------------------------");
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
  @Test(priority=40)
  public void Find_All_WorkWeek_ScheduledTask() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.workweek_Task();
		  Thread.sleep(1500);
		  System.out.println("Task Schedulded for Work week---->>");
		  ps_page.Find_Schedule_Task_From_Grid("BS_All_scheduled_task_grid");
		  Thread.sleep(1500);
		  ps_page.Notification();
		  System.out.println("-----------------------------------------");
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	 
  }
  @Test(priority=41)
  public void Find_All_Week_ScheduledTask() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.Week_Task();
		  Thread.sleep(1500);
		  System.out.println("Task Schedulded for Week---->>");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		  ps_page.Find_Schedule_Task_From_Grid("BS_All_scheduled_task_grid");
		  Thread.sleep(1500);
		  ps_page.Notification();
		  System.out.println("-----------------------------------------");
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
  @Test(priority=42)
  public void Find_All_Month_ScheduledTask() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.Month_Task();
		  Thread.sleep(1500);
		  System.out.println("Task Schedulded for month --->>");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  ps_page.Find_Schedule_Task_From_Grid("BS_Month_scheduled_task_grid");
		  Thread.sleep(1500);
		  System.out.println("-----------------------------------------");
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
 
  @Test(priority=43)
  public void Update_Weekly_Email_Scheduled_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.workweek_Task();
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(2000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(3000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_All_scheduled_task_grid","Weekly Email Task");
		  Thread.sleep(5000);
		  ps_page.Change_Button();
		  Thread.sleep(2000);
		  ps_page.Notification();
		  ps_page.Wednesday("Yes");
		  Thread.sleep(800);
		  ps_page.Start_Tyme_DDlist("18:30");
		  Thread.sleep(1000);
		  try {
			  ps_page.Archive("Yes", "Export for batch");
			  Thread.sleep(1000);
		} catch (ElementNotInteractableException e) {
			// TODO: handle exception
		}
		  
		  ps_page.Save();
		  Thread.sleep(1500);
		  ps_page.Notification();
		  Thread.sleep(800);
		  ps_page.Cancel();
		  Thread.sleep(2000);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
	  
  }
  @Test(priority=44)
  public void open_Daily_EveryDay_Export_Scheduled_task() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  events eve = new events(driver);
	  try {
		  ps_page.workweek_Task();
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(1000);
		  ps_page.open_batch_log("BS_All_scheduled_task_grid", "Weekly Email Task(1)");
		  Thread.sleep(1000);
		  ps_page.Notification();
		  ps_page.Cancel();
		  Thread.sleep(1000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	
	 
  }
  @Test(priority=45)
  public void Update_Daily_Every_Day_Export_Scheduled_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.workweek_Task();
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_All_scheduled_task_grid","Daily Every Day Export");
		  Thread.sleep(1500);
		  ps_page.Change_Button();
		  Thread.sleep(1000);
		  ps_page.Notification();
		  Thread.sleep(2000);
		  ps_page.Archive("Yes", "Export for batch");
		  Thread.sleep(1000);
		  ps_page.Save();
		  Thread.sleep(1500);
		  ps_page.Notification();
		  Thread.sleep(800);
		  ps_page.Cancel();
		  Thread.sleep(5000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	 
	  
  }
  @Test(priority=47)
  public void Update_Daily_Every_WeekDay_SMS_Scheduled_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.workweek_Task();
		  Thread.sleep(2000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_All_scheduled_task_grid","Daily Every Week Day SMS");
		  Thread.sleep(1500);
		  ps_page.Change_Button();
		  Thread.sleep(2000);
		  ps_page.Notification();
		  ps_page.Start_Tyme_DDlist("22:30");
		  Thread.sleep(1000);
		  ps_page.Save();
		  Thread.sleep(1500);
		  ps_page.Notification();
		  Thread.sleep(800);
		  ps_page.Cancel();
		  Thread.sleep(3000);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
	  
  }
  @Test(priority=48)
  public void open_Daily_Every_WeekDay_SMS_Scheduled_task() throws InterruptedException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  events eve = new events(driver);
	  try {
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  ps_page.open_batch_log("BS_All_scheduled_task_grid", "Daily Every Week Day SMS(1)");
		  Thread.sleep(1000);
		  ps_page.Notification();
		  ps_page.Cancel();
		  Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
  }
  @Test(priority=49)
  public void Delete_Immidiate_Schedule_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.serch_Task_Type("BS_search_TaskType", "Print tasks");
		  Thread.sleep(1000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_Immidiate_task_grid",immidiate_task_Print);
		  Thread.sleep(1000);
		  ps_page.Delete_Button();
		  Thread.sleep(1000);
		  ps_page.Notification();
		  Thread.sleep(700);
		  ps_page.Notification();
		  Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
  
  @Test(priority=50)
  public void Delete_Weekly_Email_Scheduled_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.serch_Task_Type("BS_search_TaskType", "Email tasks");
		  Thread.sleep(1000);
		  ps_page.workweek_Task();
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(1000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_All_scheduled_task_grid","Weekly Email Task(1)");
		  Thread.sleep(1000);
		  ps_page.Delete_Button();
		  Thread.sleep(800);
		  ps_page.Notification();
		  Thread.sleep(700);
		  ps_page.Notification();
		  Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
  @Test(priority=51)
  public void Delete_Daily_Every_Day_Export_Scheduled_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.serch_Task_Type("BS_search_TaskType", "Export tasks");
		  Thread.sleep(1000);
		  ps_page.workweek_Task();
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(1000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_All_scheduled_task_grid","Daily Every Day Export");
		  Thread.sleep(1000);
		  ps_page.Delete_Button();
		  Thread.sleep(800);
		  ps_page.Notification();
		  Thread.sleep(700);
		  ps_page.Notification();
		  Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	  
  }
  @Test(priority=52)
  public void Delete_Daily_Every_WeekDay_SMS_Scheduled_task() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  batch_Scheduler_page ps_page = new batch_Scheduler_page(driver);
	  try {
		  ps_page.serch_Task_Type("BS_search_TaskType", "SMS tasks");
		  Thread.sleep(1000);
		  ps_page.Week_Task();
		  Thread.sleep(2000);
		  ps_page.Show_full_Day();
		  Thread.sleep(1000);
		  eve.Click_event("BS_Next_arrow");  // Click on Next Arrow
		  Thread.sleep(1000);
		  ps_page.Update_Schedule_Task_From_Grid("BS_All_scheduled_task_grid","Daily Every Week Day SMS(1)");
		  Thread.sleep(1000);
		  ps_page.Delete_Button();
		  Thread.sleep(800);
		  ps_page.Notification();
		  Thread.sleep(700);
		  ps_page.Notification();
		  Thread.sleep(3000);
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	 
  }
  @Test(priority=53)
  public void Delete_Multiple_Batch_rules_Sets() throws InterruptedException, IOException {
	  WebDriver driver= WebDriverManager.getDriverInstance();
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  events eve = new events(driver);
	  try {
		  br_page.open_batch_rules_page();
		  Thread.sleep(2000);
		  Reporter.log("===================>> Delete Multiple Batch Rule.");
		  eve.Drag_and_Drop("batchrule_sets_table");
		  br_page.Delete_Icon();
		  Thread.sleep(1000);
		  br_page.Notification();
		  Thread.sleep(1000);
		  br_page.Notification();
		  Thread.sleep(1000);
		  br_page.Reload_Icon();
		  Reporter.log("----------------------------------------");
		  Reporter.log("<<======================{End : batch Rules Tab Section}=======================>> ");
	} catch (Exception e) {
		System.out.println(e.getMessage());
		throw new ElementNotInteractableException("Record(s) not found");
	}
	 
  }
}
