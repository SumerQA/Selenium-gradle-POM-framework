package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Dunning_lang_Page;
import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Dunning_languages {
	Common c = new Common();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_Dunning_lang");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
			//System.out.println(arr.size());
	}
	
  @Test(priority=1,description="APP-12:Check buttons in toolbar of dunning languages")
  public void Goto_Dunning_languages_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("<<======================{Application Manager Tables Module}=======================>> ");
	  Reporter.log("________________________ Dunning languages ___________________________________________ ");
	  Reporter.log("********TestCase- APP-12:Check buttons in toolbar of dunning languages. ********");
	  DL.Goto_Dunning_lang_tab();
	  Reporter.log("********End :TestCase- APP-12  ********");
	  Thread.sleep(500);
	  Reporter.log("----------------------------------------");
	  
  }
  @Test(priority=2,description="APP-114: Create dunning language' button in Dunning languages screen")
  public void Open_Create_New_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-114: Create dunning language' button in Dunning languages screen. ********");
	  DL.Crete_Dunning_lang_icon();
	  Reporter.log("********End :TestCase- APP-114  ********");
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Enter_Dunning_language_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter Dunning language Name. ********");
	  DL.Enter_Dunning_Lang_Name("DN_Lang_Name",arr.get(0));
	  Reporter.log(arr.get(0)+ " : is entered in the Dunning language Name field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=4)
  public void Select_Linkto_Login_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Select link to login language. ********");
	  DL.Select_Linked_to_Login_lang("linkto_login_lang",arr.get(1));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5)
  public void Enter_valuein_Att_Field() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in Att. Field ********");
	  DL.Enter_Att("att", arr.get(2));
	  Reporter.log(arr.get(2) +" : is Entered in the Att. input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=6)
  public void Enter_valuein_Dear_Field() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in Dear.. Field ********");
	  DL.Enter_Dear("dear",arr.get(3));
	  Reporter.log(arr.get(3) +" : is Entered in the Dear.. input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7)
  public void Enter_AttMale_for_Contact_detail() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in Att. (male) Field ********");
	  DL.Enter_Att_male("att_male",arr.get(4));
	  Reporter.log(arr.get(4) +" : is Entered in the Att. (male) input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=8)
  public void Enter_AttFemale_for_Contact_detail() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in Att. (female) Field ********");
	  DL.Enter_Att_Female("att_female", arr.get(5));
	  Reporter.log(arr.get(5) +" : is Entered in the Att. (female) input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=9)
  public void Enter_DearSir_for_Contact_detail() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in Dear sir.. Field ********");
	  DL.Enter_DearSir("dearSir", arr.get(6));
	  Reporter.log(arr.get(6) +" : is Entered in the Dear sir.. input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=10)
  public void Enter_DearMadam_for_Contact_detail() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in Dear madam.. Field ********");
	  DL.Enter_DearMadam("dear_madam", arr.get(7));
	  Reporter.log(arr.get(7) +" : is Entered in the Dear madam.. input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=11,description="APP-14:Layout of 'Settings' tab in dunning languages settings slide panel")
  public void Verify_settings_Tab () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test case : APP-14:Layout of 'Settings' tab in dunning languages settings slide panel ********");
	  DL.Select_Settings_Tab("DL_Settings");
	  Reporter.log("********End :TestCase- APP-14  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=12)
  public void Mark_committed_payments_settings () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter value in  Mark committed payments Field ********");
	  DL.Select_Settings_Tab("DL_Settings");
	  DL.Check_mark_Committed_payment_checkbox(arr.get(8),arr.get(9));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13)
  public void Mark_overdue_invoice_settings () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Mark overdue invoices. ********");
	  DL.Check_mark_overdue_Invoice_checkbox(arr.get(10),arr.get(11));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=14)
  public void Mark_invoices_in_payment_schemes_settings () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Mark invoices in payment schemes . ********");
	  DL.Check_mark_invoicesin_payment_Plan(arr.get(12),arr.get(13));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=15)
  public void Mark_invoices_withDisputes_settings () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Mark invoices with disputes. ********");
	  DL.Check_mark_invoiceWith_dispute(arr.get(14),arr.get(15));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=16)
  public void Mark_invoices_with_payment_in_progres_settings () throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Mark invoices with payment in progress . ********");
	  DL.Check_mark_invoiceWith_paymentinProgress(arr.get(16),arr.get(17));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=17)
  public void Check_Display_currency_in_invoice_table_checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Display currency in invoice table. ********");
	  DL.Check_display_Currencyin_Invoicetable("DisplayCurrenyIn_InvoiceTable",arr.get(18));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=18)
  public void Check_Display_currency_with_Balance_checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Display currency with balance. ********");
	  DL.Check_display_Currencywithbalance("display_Currencywithbalance_checkbox",arr.get(19));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=19)
  public void Include_blocked_invoices_checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Include blocked invoices. ********");
	  DL.Check_Includeblocked_Invoices("Check_Includeblocked_Invoices",arr.get(20));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=20,description="APP-15:Layout of 'E-mail' tab in dunning languages settings slide panel")
  public void Verify_Email_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test Case : APP-15:Layout of 'E-mail' tab in dunning languages settings slide panel ********");
	  DL.Click_Email_tab("DL_Email_tab");
	  Reporter.log("********End :TestCase- APP-15  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=21)
  public void Enter_Email_Subject() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter Subject in E-mail Section. ********");
	  //DL.Click_Email_tab("DL_Email_tab");
	  DL.Enter_Subject("DL_Sub", arr.get(21));
	  Reporter.log(arr.get(21)+" : is entered in Subject input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=22)
  public void Enter_Email_text() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Enter Email Text in E-mail Section. ********");
	  DL.Enter_EmailText("emailText",arr.get(22));
	  Reporter.log(arr.get(22)+" : is entered in Email input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=23,description="APP-16:Layout of 'Formats' tab in dunning languages settings slide panel")
  public void Verify_Formats_Tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test Case : APP-16:Layout of 'Formats' tab in dunning languages settings slide panel ********");
	  DL.Click_Formats("Formats");
	  System.out.println("item Selected from Culture DDlist");
	  Reporter.log("********End :TestCase- APP-16  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=24)
  public void Select_Culture() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Culture Dropdown list. ********");
	  DL.Select_Item_from_DDlist("culture",arr.get(23));
	  System.out.println("item Selected from Culture DDlist");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=25)
  public void Select_Date_Format_inLetter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Date format in letter Dropdown list. ********");
	  DL.Select_Item_from_DDlist("DateFormat_inLetter",arr.get(24));
	  System.out.println("Date format is selected");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=26)
  public void Select_Date_Format_inInvoice() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Date format in invoice table . ********");
	  DL.Select_Item_from_DDlist("DateFormat_inInvoiceTable",arr.get(25));
	  System.out.println("Date format for Invoice table  is selected");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=27)
  public void Select_Amount_format() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Verify Amount format . ********");
	  DL.Select_Item_from_DDlist("amount_format",arr.get(26));
	  System.out.println("Date format for Invoice table  is selected");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=28,description="APP-136:In Formats tab,setting for payment scheme letter (week)")
  public void Enter_week_inPayment_Scheme_letter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test Case : APP-136:In Formats tab,setting for payment scheme letter (week) ********");
	  DL.Enter_week("DL_week",arr.get(27));
	  Reporter.log(arr.get(27)+" : is entered in the Week input field. ");
	  Reporter.log("********End :TestCase- APP-136  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=29,description="APP-135:In Formats tab,setting for payment scheme letter (weeks)")
  public void Enter_Weeks_inPayment_Scheme_letter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test Case : APP-135:In Formats tab,setting for payment scheme letter (weeks) ********");
	  DL.Enter_weeks("DL_weeks", arr.get(28));
	  Reporter.log(arr.get(28)+" : is entered in the Weeks input field. ");
	  Reporter.log("********End :TestCase- APP-135  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=30,description="APP-137:In Formats tab,setting for payment scheme letter (month)")
  public void Enter_Month_inPayment_Scheme_letter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test Case : APP-137:In Formats tab,setting for payment scheme letter (month) ********");
	  DL.Enter_Month("DL_month", arr.get(29));
	  Reporter.log(arr.get(29)+" : is entered in the Month input field. ");
	  Reporter.log("********End :TestCase- APP-137  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=31,description="APP-134:In Format tab,setting for payment scheme letter (months)")
  public void Enter_Months_inPayment_Scheme_letter() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********Test Case : APP-134:In Format tab,setting for payment scheme letter (months) ********");
	  DL.Enter_Months("DL_months", arr.get(30));
	  Reporter.log(arr.get(30)+" : is entered in the Months input field. ");
	  Reporter.log("********End :TestCase- APP-134  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=32,description="APP-119:Save and Close button in dunning setting table")
  public void Save_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-119:Save and Close button in dunning setting table ********");
	  DL.Save_and_Close();
	  Thread.sleep(2000);
	  DL.Notifications();
	  Thread.sleep(2000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-119  ********");
	  Reporter.log("---------------------------------------");
  }
  @Test(priority=33,description="APP-117:Reload button with unSaved changes")
  public void Check_Reload_Button_With_Unsaved_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-117:Reload button with unSaved changes ********");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.Update_icon();
	  Thread.sleep(1000);
	  DL.Enter_Dunning_Lang_Name("DN_Lang_Name",arr.get(0)+"Test");
	  DL.Select_Linked_to_Login_lang("linkto_login_lang",arr.get(1));
	  DL.Enter_Att("att", arr.get(2)+"Test");
	  DL.Enter_Dear("dear",arr.get(3)+"Test");
	  DL.Enter_Att_male("att_male",arr.get(4)+"Test");
	  DL.Enter_Att_Female("att_female", arr.get(5)+"Test");
	  Thread.sleep(1000);
	  DL.Refresh();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-117  ********");
	  Reporter.log("---------------------------------------");
  }
  @Test(priority=34,description="APP-118:Save button")
  public void Check_Save_Button_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-118:Save button ********");
	  DL.Enter_Dunning_Lang_Name("DN_Lang_Name",arr.get(0));
	  DL.Select_Linked_to_Login_lang("linkto_login_lang",arr.get(1));
	  DL.Enter_Att("att", arr.get(2));
	  DL.Enter_Dear("dear",arr.get(3));
	  DL.Enter_Att_male("att_male",arr.get(4));
	  DL.Enter_Att_Female("att_female", arr.get(5));
	  DL.Save();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Cancel();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Reporter.log("********End :TestCase- APP-118  ********");
	  Reporter.log("---------------------------------------");
  }
  @Test(priority=35,description="APP-120:Save as New button")
  public void Check_Save_As_New_Button_changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-120:Save as New button ********");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.Update_icon();
	  Thread.sleep(1000);
	  DL.Enter_Dunning_Lang_Name("DN_Lang_Name",arr.get(0)+"New");
	  DL.Select_Linked_to_Login_lang("linkto_login_lang",arr.get(1));
	  DL.Enter_Att("att", arr.get(2));
	  DL.Enter_Dear("dear",arr.get(3));
	  DL.Enter_Att_male("att_male",arr.get(4));
	  DL.Enter_Att_Female("att_female", arr.get(5));
	  DL.Save_As_New();
	  Thread.sleep(1000);
	  DL.Notifications();
	  DL.Cancel();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Reporter.log("********End :TestCase- APP-120  ********");
	  Reporter.log("---------------------------------------");
  }
  
  @Test(priority=36,description="APP-140:Create multiple Dunning languages of same name")
  public void Create_multiple_Dunning_languages_of_same_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-140:Create multiple Dunning languages of same name ********");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.Update_icon();
	  Thread.sleep(1000);
	  DL.Enter_Dunning_Lang_Name("DN_Lang_Name",arr.get(0));
	  DL.Save_and_Close();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Reporter.log("********End :TestCase- APP-140  ********");
	  Reporter.log("---------------------------------------");
  }
  @Test(priority=37,description="APP-618:Reload button")
  public void Veriy_Reload_Button_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-618:Reload button ********");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.Update_icon();
	  Thread.sleep(1000);
	  DL.Enter_Dunning_Lang_Name("DN_Lang_Name",arr.get(0)+"Test Reload");
	  Thread.sleep(1000);
	  DL.Refresh();
	  Thread.sleep(1000);
	  DL.Cancel();
	  DL.Notifications();
	  Reporter.log("********End :TestCase- APP-618  ********");
	  Reporter.log("---------------------------------------");
  }
  
  @Test(priority=38)
  public void Verify_All_mandatory_Fields() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  DL.Crete_Dunning_lang_icon();
	  Thread.sleep(1500);
	  Reporter.log("********Enter Dunning language Name. ********");
	  DL.Save();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Cancel();
	  Thread.sleep(1000);
	  DL.Notifications();
  }
  
  
  @Test(priority=39,description="APP-143:Linking dunning language single administration and single language.")
  public void Link_Dunning_languages_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  events eve = new events(driver);
	  Reporter.log("********TestCase- APP-143:Linking dunning language single administration and single language. ********");
	  eve.Table_event(arr.get(31), "C_curr_admin_table");
	  Thread.sleep(1000);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.link();
	  Thread.sleep(1000);
	  DL.Save_changes();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-143  ********");
	  Reporter.log("---------------------------------------");
  }
  
  @Test(priority=40)
  public void Delete_Linked_Dunning_languages() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.Delete_icon();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("---------------------------------------");
  }
  
  @Test(priority= 41,description="APP-148:Unlinking dunning language ,not in use")
  public void UnLink_Dunning_languages_from_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-148:Unlinking dunning language ,not in use. ********");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dlang_linked_table");
	  Thread.sleep(1000);
	  DL.Unlink();
	  Thread.sleep(1000);
	  DL.Save_changes();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-148  ********");
	  Reporter.log("---------------------------------------");
  }
  @Test(priority=42,description="APP-116:Delete Dunning languages")
  public void Delete_Dunning_languages() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Dunning_lang_Page DL = PageFactory.initElements(driver, Dunning_lang_Page.class);
	  Reporter.log("********TestCase- APP-116:Delete Dunning languages. ********");
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  DL.Delete_icon();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  DL.Notifications();
	  Thread.sleep(1000);
	  eve.CheckItem_AfterDeleting_In_Table_event(arr.get(0),"DL_Dunning_lang_table");
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-116  ********");
	  Reporter.log("---------------------------------------");
  }
}
