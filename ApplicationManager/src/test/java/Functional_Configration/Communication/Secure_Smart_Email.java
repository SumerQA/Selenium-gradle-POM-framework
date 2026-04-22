package Functional_Configration.Communication;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Secure_Smart_Email_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class Secure_Smart_Email {
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Comm_Secure_Smart_Email");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Secure_Smart_Email_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("<<======================{Secure Smart Email Tab}=======================>> ");
	  sse_page.Goto_Secure_smart_email();
	  Thread.sleep(500);
	  System.out.println("Secure Smart Email page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Create Icon ---------->>");
	  sse_page.Change_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Enter_Database_ID() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Database ID Input field ---------->>");
	  sse_page.Database_ID("sse_db_id",arr.get(0));
  }
  @Test(priority=4)
  public void Enter_SSE_web_site_URL() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify SSE web site URL Input field ---------->>");
	  sse_page.SSE_Website_URL("sse_websire_url", arr.get(1));
  }
  @Test(priority=5)
  public void Enter_Number_of_days_valid_for_SSE() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Number of days valid for SSE Input field ---------->>");
	  sse_page.Numberof_days_ValidforSSE("sse_linkvalid", arr.get(2));
  }
  @Test(priority=6)
  public void Enter_URL_to_SSE_website_logo() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify URL to SSE web site logo Input field ---------->>");
	  sse_page.URL_to_SSE_website_logo("sse_website_logoURL", arr.get(3));
  }
  @Test(priority=7)
  public void Enter_Web_site_welcome_text() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Web site welcome text Input field ---------->>");
	  sse_page.Web_site_welcome_text("sse_website_welcome_text", arr.get(4));
  }
  @Test(priority=8)
  public void Enter_Subject_line_CopyInvoice_email() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Subject line Copy-Invoice e-mail Input field ---------->>");
	  sse_page.Subjectline_CopyInvoice_email("sse_sub_line", arr.get(5));
  }
  @Test(priority=9)
  public void Enter_Maximum_number_of_days_committed_payment () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Maximum number of days committed payment  Input field ---------->>");
	  sse_page.Max_numof_days_committed_payment("sse_max_no_days_committed",arr.get(6));
  }
  @Test(priority=10)
  public void Enter_numberof_Days_monitoring() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Number of days monitoring  Input field ---------->>");
	  sse_page.Number_of_days_monitoring("sse_days_monitoring", arr.get(7));
  }
  @Test(priority=11)
  public void Check_Block_invoices_on_committed_payment() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify Block invoices on committed payment Input field ---------->>");
	  sse_page.Block_invoices_on_committed_payment(arr.get(8));
  }
 
  @Test(priority=12,description="APP-184:For Save button")
  public void Save_Complete_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify: For Save button ---------->>");
	  sse_page.Save();
	  Thread.sleep(1000);
	  sse_page.Notification();
	  Thread.sleep(500);
	  sse_page.Notification();
	  Thread.sleep(500);
  }
  @Test(priority=13,description="APP-183:For Reload button")
  public void Verify_Reload_button_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Secure_Smart_Email_Page sse_page = new Secure_Smart_Email_Page(driver);
	  Reporter.log("Verify: For Reload button ---------->>");
	  sse_page.Change_icon();
	  sse_page.Database_ID("sse_db_id",arr.get(0)+" Refresh");
	  sse_page.SSE_Website_URL("sse_websire_url", arr.get(1)+" Refresh");
	  sse_page.Numberof_days_ValidforSSE("sse_linkvalid", arr.get(2)+" Refresh");
	  sse_page.URL_to_SSE_website_logo("sse_website_logoURL", arr.get(3)+" Refresh");
	  sse_page.Web_site_welcome_text("sse_website_welcome_text", arr.get(4)+" Refresh");
	  sse_page.Subjectline_CopyInvoice_email("sse_sub_line", arr.get(5)+" Refresh");
	  sse_page.Max_numof_days_committed_payment("sse_max_no_days_committed",arr.get(6)+" Refresh");
	  sse_page.Number_of_days_monitoring("sse_days_monitoring", arr.get(7)+" : refresh");
	  Thread.sleep(1000);
	  sse_page.Refresh();
	  Thread.sleep(500);
	  sse_page.Notification();
	  Thread.sleep(500);
	  sse_page.Save();
	  sse_page.Notification();
	  Thread.sleep(500);
	  sse_page.Notification();
	  Thread.sleep(500);
	  Reporter.log("<<======================{End : Secure Smart Emial Section}=======================>> ");
  }
}
