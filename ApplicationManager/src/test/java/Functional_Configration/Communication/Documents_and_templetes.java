package Functional_Configration.Communication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Documents_and_templetes_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Documents_and_templetes {
	ReadXclData rddata=new ReadXclData();
	WebDriverManager mgr= new WebDriverManager();
	 ArrayList<String>arr= new ArrayList<>();
	// File templete_file = new File("Datafiles");
	 File templete_file = new File("src");
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Comm_Documents_Templetes");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Documents_and_templetes_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("<<======================{Documents and templetes Tab}=======================>> ");
	  c_page.Goto_communication_page();
	  Thread.sleep(2000);
	  c_page.Click_on_Documents_and_templetes_tab();
	  Thread.sleep(3000);
	  System.out.println("Documents and templetes page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  c_page.Creat_New_icon();
	  Thread.sleep(3000);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Letter_Name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Enter Letter Name ---------->>");
	  c_page.Letter_Name("com_letter_name", arr.get(0));
	  Thread.sleep(1000);
  }
  @Test(priority=4)
  public void Check_Count_as_reminder_letter() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.Count_asReminder_Letter("com_countas_reminder_letter", arr.get(1));
	  Thread.sleep(1000);
  }
  @Test(priority=5)
  public void Select_Interest_scheme() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.Interest_Scheme("com_int_scheme",mgr.getparam("FC_Interest_schemes", 0)+"Save");
	  Thread.sleep(1000);
  }
  @Test(priority=6)
  public void Select_Cost_scheme() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.Interest_Scheme("com_cost_scheme",mgr.getparam("FC_Cost_Scheme", 0)+"Save as New");
	  Thread.sleep(1000);
  }
  @Test(priority=7)
  public void Select_End_of_period_statement() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.End_of_period_statement("com_EOS_dd", arr.get(14));
	  Thread.sleep(1000);
  }
  @Test(priority=8)
  public void Check_include_copy_invoice_as_attachment_in_the_letter() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.Include_copy_invoice_as_attachment_in_letter("InvoiceCopiesInLetter", arr.get(15));
	  Thread.sleep(1000);
  }
  @Test(priority=9)
  public void Check_include_copy_invoice_as_attachment_in_the_Email() throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.Include_copy_invoice_as_attachment_in_letter("InvoiceCopiesInEmail", arr.get(16));
	  Thread.sleep(1000);
  }
  @Test(priority=10)
  public void Click_on_Table_settings_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  c_page.Table_Settings("com_table_settings");
	  Thread.sleep(1000);
  }
  @Test(priority=11)
  public void Select_GroupBy_1() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Select GroupBy 1 ---------->>");
	  c_page.GroupBy_1("com_groupby_1",  arr.get(2));
	  Thread.sleep(1000);
  }
  @Test(priority=12)
  public void Select_GroupBy_2() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Select GroupBy 2 ---------->>");
	  c_page.GroupBy_2("com_groupby_2",  arr.get(3));
	  Thread.sleep(1000);
  }
  @Test(priority=13)
  public void Sort_by() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Sort by functionality ---------->>");
	  c_page.Sort_by("com_sortby_ddlist",  arr.get(4),  arr.get(5));
	  Thread.sleep(1000);
  }
  @Test(priority=14)
  public void Check_Calculate_subtotal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Calculate subtotal Checkbox ---------->>");
	  c_page.Calculate_subtotal("com_sumin_column",  arr.get(8),  arr.get(6), arr.get(7));
	  Thread.sleep(1000);
  }
  @Test(priority=15)
  public void Click_on_Templetes_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Click on Templetes Tab ---------->>");
	  c_page.Templetes_Tab("com_templete_tab");
	  Thread.sleep(1000);
  }
  @Test(priority=16)
  public void Enter_HTML_templete_orFile_Origin_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify File Uploading in Templete field ---------->>");
	  File file = new File("src");                                   //File upload Script folder
	  String paths=  arr.get(9);
	  String[] Fpath = paths.split(",");
	  String filepath = templete_file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Letter_Email_templates\\"+Fpath[0];
	  Thread.sleep(1000);
	  c_page.Templete("com_templete_orFile_Origin_name",file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Autoit_Script\\upload.exe", "file:///"+filepath);   
	  System.out.println(filepath+ ": File path of the templete");
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=17)
  public void Select_Dunning_language() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Dunning letter DDlist ---------->>");
	  c_page.Reminder_Language("com_reminder_language",  arr.get(11));
	  Thread.sleep(1000);
  }
  @Test(priority=18)
  public void Select_Templete_Format() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Templete format Radio Button ---------->>");
	  c_page.Templete_Format( arr.get(12));
	  Thread.sleep(1000);
  }
 
  @Test(priority=19)
  public void Save_New_tamplete_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Save Button ---------->>");
	  c_page.Save();
	  Thread.sleep(1000);
	  c_page.Notification();
  }
  @Test(priority=20)
  public void Check_HTML_templete_in_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Reporter.log("Verify Newly Created HTML Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  String[] templete = templetes.split(",");
	  String temp = templete[0]; 
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  System.out.println("HTML templete exists in the dunning letter templete Table");
  }
  
  
  @Test(priority=21)
  public void Enter_RTF_templete_orFile_Origin_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify File Uploading in Templete field ---------->>");
	  c_page.New_templete_icon();
	  Thread.sleep(1000);
	  File file = new File("src");                                   //File upload Script folder
	  String paths=  arr.get(9);
	  String[] Fpath = paths.split(",");
	//add /src/ to the file path
	  String filepath =  templete_file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Letter_Email_templates\\"+Fpath[1]; 
	  //String filepath =  arr.get(9);
	  Thread.sleep(1000);
	  c_page.Templete("com_templete_orFile_Origin_name",file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Autoit_Script\\upload.exe", "file:///"+filepath);
	  System.out.println(filepath+ " : File path of the templete");
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Reminder_Language("com_reminder_language",  arr.get(11));
	  Thread.sleep(1000);
	  c_page.Templete_Format("1"); // 1 is For RTF format
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
  }
  
  @Test(priority=22)
  public void Check_RTF_templete_in_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Newly Created RTF Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  Thread.sleep(2000);
	  String[] templete = templetes.split(",");
	  Thread.sleep(2000);
	  String temp = templete[1]; 
	  Thread.sleep(2000);
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  c_page.Notification();
	  System.out.println("RTF templete exists in the dunning letter templete Table");  
  }
  
  @Test(priority=23)
  public void Enter_SMS_templete_orFile_Origin_name() throws IOException, InterruptedException {
      WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify File Uploading in Templete field ---------->>");
	  c_page.New_templete_icon();
	  Thread.sleep(1000);
	  File file = new File("src");                                   //File upload Script folder
	  String paths=  arr.get(9);
	  String[] Fpath = paths.split(",");
	//add /src/ to the file path
	  String filepath =  templete_file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Letter_Email_templates\\"+Fpath[2]; 
	  Thread.sleep(1000);
	  c_page.Templete("com_templete_orFile_Origin_name",file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Autoit_Script\\upload.exe", "file:///"+filepath);
	  System.out.println(filepath+ ": File path of the templete");
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Reminder_Language("com_reminder_language",  arr.get(11));
	  Thread.sleep(1000);
	  c_page.Templete_Format("3"); // 3 is For SMS format
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();  
  }
  
  @Test(priority=24)
  public void Check_SMS_templete_in_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Reporter.log("Verify Newly Created SMS Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  String[] templete = templetes.split(",");
	  String temp = templete[2]; 
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  System.out.println("SMS templete exists in the dunning letter templete Table");
  }
  @Test(priority=25)
  public void Verify_Invalid_templete_in_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Newly Created HTML Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  String[] templete = templetes.split(",");
	  String temp = templete[0]; 
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  System.out.println("HTML templete is Selected in dunning letter templete Table for Updation");
	  c_page.Edit_templete_icon();
	  Thread.sleep(1000);
	  String paths=  arr.get(9);
	  String[] Fpath = paths.split(",");
	//add /src/ to the file path
	  String filepath =  templete_file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Letter_Email_templates\\"+Fpath[3]; 
	  File file = new File("src");
	  c_page.Templete("com_templete_orFile_Origin_name",file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Autoit_Script\\upload.exe", "file:///"+filepath);
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=26)
  public void Update_HTML_templete_in_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Newly Created HTML Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  String[] templete = templetes.split(",");
	  String temp = templete[0]; 
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  System.out.println("HTML templete is Selected in dunning le  tter templete Table for Updation");
	  c_page.Edit_templete_icon();
	  Thread.sleep(1000);
	  String paths=  arr.get(9);
	  String[] Fpath = paths.split(",");
	  //add /src/ to the file path
	  String filepath =  templete_file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Letter_Email_templates\\"+Fpath[4]; 
	  File file = new File("src");
	  c_page.Templete("com_templete_orFile_Origin_name",file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Autoit_Script\\upload.exe", "file:///"+filepath);
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=27)
  public void Verify_Updated_HTML_templete_in_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Reporter.log("Verify Newly Created SMS Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  String[] templete = templetes.split(",");
	  String temp = templete[3]; 
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  System.out.println("HTML templete exists in the dunning letter templete Table. Updated Successfully !");
  }
  
  @Test(priority=28)
  public void Delete_SMS_templete_From_Dunning_letter_templetes_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Deletion of  Newly Created SMS Templete in  Dunning letter Tamplete table. ---------->>");
	  String templetes=  arr.get(10);
	  String[] templete = templetes.split(",");
	  String temp = templete[2]; 
	  eve.Table_event( temp, "com_templetes_table");
	  Thread.sleep(1000);
	  System.out.println("SMS templete is Selected in dunning letter templete Table");
	  c_page.Delete_templete_icon();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();
	  
  }
  @Test(priority=29,description="APP-281:Save and close")
  public void Save_and_Closethe_Complete_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  Reporter.log("Verify Save and Close Button ---------->>");
	  c_page.Save_and_Close();
	  Thread.sleep(2000);
	  isNotificationPresent();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  c_page.Notification();
  }
  @Test(priority=30,description="APP-267:Updating a letter")
  public void Update_Dunning_Letter() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event_With_Pagination( arr.get(0), "com_reminder_letters_table","com_dunning_ltr_table_id");
	  Reporter.log("Verify Updating a letter ---------->>");
	  Thread.sleep(1000);
	  c_page.Update_icon();
	  Thread.sleep(1500);
	  c_page.Letter_Name("com_letter_name", arr.get(0));
	  Thread.sleep(1000);
	  c_page.Table_Settings("com_table_settings");
	  Thread.sleep(1000);
	  c_page.GroupBy_1("com_groupby_1",  arr.get(2));
	  Thread.sleep(1000);
	  c_page.GroupBy_2("com_groupby_2",  arr.get(3));
	  Thread.sleep(1000);
	  c_page.Sort_by("com_sortby_ddlist",  arr.get(4),  arr.get(5));
	  Thread.sleep(1000);
	  c_page.Save_and_Close();
	  Thread.sleep(2000);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();
	  
  }

  @Test(priority=31,description="APP-270:Linking the dunning letters")
  public void Link_Dunning_Letter() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Linking the dunning letters ---------->>");
	  Thread.sleep(1000);
	  eve.Table_event( arr.get(13), "fun_con_Admin_table");
	  Thread.sleep(1000);
	  eve.Table_event_With_Pagination(arr.get(0), "com_reminder_letters_table","com_dunning_ltr_table_id");
	  Thread.sleep(1000);
	  c_page.link();
	  Thread.sleep(1000);
	  c_page.Save_Panal();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
  }
  @Test(priority=32,description="APP-268:Deleting a linked letter")
  public void Delete_Linked_Dunning_Letter() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event_With_Pagination(arr.get(0),"com_reminder_letters_table","com_dunning_ltr_table_id");
	  Thread.sleep(1000);
	  c_page.Delete_icon();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
  }
  @Test(priority=33,description="APP-272:Unlinking a letter")
  public void UnLink_Dunning_Letter() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Unlinking a letter ---------->>");
	  eve.Table_event_With_Pagination(arr.get(0),"com_unlink_letter_tab","com_unlink_lttr_table_id");
	  Thread.sleep(1000);
	  c_page.Unlink();
	  Thread.sleep(2000);
	  c_page.Save_Panal();
	  Thread.sleep(1500);
	  c_page.Notification();
	  Thread.sleep(500);
	  c_page.Notification();
  }
  @Test(priority=34,description="APP-268:Deleting a letter")
  public void Delete_New_templete() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Documents_and_templetes_Page c_page = new Documents_and_templetes_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Deleting a letter ---------->>");
	  eve.Table_event_With_Pagination(arr.get(0),"com_reminder_letters_table","com_dunning_ltr_table_id");
	  Thread.sleep(1000);
	  c_page.Delete_icon();
	  Thread.sleep(1000);
	  c_page.Notification();
	  Thread.sleep(1000);
	  Thread.sleep(1000);
	  c_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0),"com_reminder_letters_table");
	  Reporter.log("<<======================{End : Documents and templetes Section}=======================>> ");
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
