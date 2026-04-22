package Functional_Configration.Administrations_tab_Functionality;

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
import Event_commands.events;
import appMan_Pages.Administrator_Page;
import appMan_Pages.Functional_Configration_Page;
import appMan_Pages.Home_index_Page;
import appMan_Pages.Users_Page;
@Listeners(ScreenShotOnFailure.class)
public class Fun_Config_Admin_Tab {
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_administration");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
			//System.out.println(arr.size());
	}
	 @Test(priority=1)
	 public void Open_Administrations_page() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 Reporter.log("<<======================{Functional Configration: Administrations}=======================>> ");
		 A_fun.goto_Administrations_panal();
		 Thread.sleep(1000);
	 }
	 @Test(priority=2,description="APP-229:Creating a new administration")
	 public void Click_on_Create_New_Admin_Item() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 Reporter.log("********Testcase : APP-229:Creating a new Administration ********");
		 A_fun.Create_icon();
		 Thread.sleep(1000);
	 }
	 @Test(priority=3,description="APP-229:Creating a new administration")
	 public void Enter_Administrations_Name() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Enter_Administrator_Name(arr.get(0));
		 Reporter.log(arr.get(0) + "  : is Entered in the Administration name Field");
		 Thread.sleep(500);
	 }
	 @Test(priority=4,description="APP-229:Creating a new administration")
	 public void Check_Active_checkbox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Active_CheckBox(arr.get(1));
	 }
	 @Test(priority=5,description="APP-229:Creating a new administration")
	 public void Check_Maintain_contacts_via_import_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Maintain_contacts_via_import_CheckBox(arr.get(2));
	 }
	 @Test(priority=6,description="APP-229:Creating a new administration")
	 public void Check_Maintain_Address_via_import_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Maintain_Address_via_import_CheckBox(arr.get(3));
	 }
	 @Test(priority=7,description="APP-229:Creating a new administration")
	 public void Check_Address1_mustbe_Entered_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Address1_mustbe_Entered_CheckBox(arr.get(4));
	 }
	 @Test(priority=8,description="APP-229:Creating a new administration")
	 public void Check_AlwaysUse_Customer_Dunning_lang_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_AlwaysUse_Customer_Dunning_lang_CheckBox(arr.get(5));
	 }
	 @Test(priority=9,description="APP-229:Creating a new administration")
	 public void Check_Customer_number_numeric_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Customer_number_numeric_CheckBox(arr.get(6));
	 }
	 @Test(priority=10,description="APP-229:Creating a new administration")
	 public void Check_Invoice_number_numeric_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Invoice_number_numeric_CheckBox(arr.get(7));
	 }
	 @Test(priority=11,description="APP-229:Creating a new administration")
	 public void Check_DueDateToday_isnot_overdue_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_DueDateToday_isnot_overdue_CheckBox(arr.get(8));
	 }
	 @Test(priority=12,description="APP-229:Creating a new administration")
	 public void Check_Monitoring_Relatedto_DueDate_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Monitoring_Relatedto_DueDate_CheckBox(arr.get(9));
	 }
	 @Test(priority=13,description="APP-229:Creating a new administration")
	 public void Check_Amaximum_of_1dispute_per_invoice_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Amaximum_of_1dispute_per_invoice_CheckBox(arr.get(10));
	 }
	 @Test(priority=14,description="APP-229:Creating a new administration")
	 public void Check_CustomerGroup_applyMyProfile_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_CustomerGroup_applyMyProfile_CheckBox(arr.get(11));
	 }
	 @Test(priority=15,description="APP-229:Creating a new administration")
	 public void Check_CustomerGroup_NoInheriting_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_CustomerGroup_NoInheriting_CheckBox(arr.get(12));
	 }
	 @Test(priority=16,description="APP-229:Creating a new administration")
	 public void Check_Display_Import_SourceIn_TreeCheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Display_Import_SourceIn_TreeCheckBox(arr.get(13));
	 }
	 @Test(priority=17,description="APP-229:Creating a new administration")
	 public void Check_Send_letter_as_PDF_CheckBox() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Check_Send_letter_as_PDF_CheckBox(arr.get(14));
	 }
	 @Test(priority=18,description="APP-229:Creating a new administration")
	 public void Select_DSO_Calculation_Radiobutton() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Select_DSO_Calculation(arr.get(15));
	 }
	 @Test(priority=19,description="APP-229:Creating a new administration")
	 public void Enter_Standard_Printer() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Enter_Standard_Printer(arr.get(16));
		 Reporter.log(arr.get(16) +" : is Entered in Standard printer Input Field");
	 }
	 @Test(priority=20,description="APP-229:Creating a new administration")
	 public void Select_Invoice_reference() throws IOException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 A_fun.Select_Invoice_reference(arr.get(17));
		
	 }
	 @Test(priority=21,description="APP-229:Creating a new administration")
	 public void Save_Changes() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 Thread.sleep(1000);
		 A_fun.save();
		 Thread.sleep(1000);
		 A_fun.Notification();
		 Thread.sleep(1000);
		 A_fun.Notification();
		 Thread.sleep(1000);
		 Reporter.log("********End :TestCase- APP-229  ********");
		 Reporter.log("----------------------------------------");
	 }
	 
	  @Test(priority=22,description="APP-230:Update the administration")
	  public void Edit_Administrations() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Administrator_Page CNA_fun = PageFactory.initElements(driver, Administrator_Page.class);
		  Users_Page u_page = PageFactory.initElements(driver, Users_Page.class);
		  Reporter.log("********Testcase : APP-230:Update the administration ********");
		  u_page.Select_Usergroup_to_Link(arr.get(0),"fun_con_Admin_table","sort_fun_con_Admin_table");
		  Reporter.log(arr.get(0) + " : is Selected from Administrations table");
		  CNA_fun.Change_icon();
		  Reporter.log("Clicked on Change Icon");
		  CNA_fun.Enter_Administrator_Name(arr.get(0));
		  Reporter.log(arr.get(0) +" : is Entered in the Administration name field");
		  CNA_fun.Check_Maintain_contacts_via_import_CheckBox(arr.get(2));
		  CNA_fun.Check_Maintain_Address_via_import_CheckBox(arr.get(3));
		  CNA_fun.Check_Address1_mustbe_Entered_CheckBox(arr.get(4));
		  CNA_fun.Check_AlwaysUse_Customer_Dunning_lang_CheckBox(arr.get(5));
		  CNA_fun.Check_Customer_number_numeric_CheckBox(arr.get(6));
		  CNA_fun.Check_Invoice_number_numeric_CheckBox(arr.get(7));
		  CNA_fun.Check_DueDateToday_isnot_overdue_CheckBox(arr.get(8));
		  CNA_fun.Check_Monitoring_Relatedto_DueDate_CheckBox(arr.get(9));
		  CNA_fun.Check_Amaximum_of_1dispute_per_invoice_CheckBox(arr.get(10));
		  CNA_fun.Check_CustomerGroup_applyMyProfile_CheckBox(arr.get(11));
		  CNA_fun.Check_CustomerGroup_NoInheriting_CheckBox(arr.get(12));
		  CNA_fun.Check_Display_Import_SourceIn_TreeCheckBox(arr.get(13));
		  CNA_fun.Check_Send_letter_as_PDF_CheckBox(arr.get(14));
		  CNA_fun.Select_DSO_Calculation(arr.get(15));
		  CNA_fun.Enter_Standard_Printer(arr.get(16));
		  CNA_fun.Select_Invoice_reference(arr.get(17));
		  Thread.sleep(1000);
		  CNA_fun.save();
		  Reporter.log("Clicked on Save Button");
		  Thread.sleep(1000);
		  CNA_fun.Notification();
		  Thread.sleep(500);
		  CNA_fun.Notification();
		  Thread.sleep(500);
		  Reporter.log("********End :TestCase- APP-230  ********");
		  Reporter.log("----------------------------------------");
	  }
  @Test(priority=23)
	 public void Activate_Newly_Created_Administration() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Home_index_Page hom = new Home_index_Page(driver);
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 Reporter.log("********Testcase : Activate_Newly_Created_Administration ********");
		 events eve= new events(driver);
		 eve.Table_event(arr.get(0), "fun_con_Admin_table");
		 hom.Render_Notifications();
		 A_fun.Notification();
		 Thread.sleep(500);
		 A_fun.Change_icon();
		 Thread.sleep(500);
		 A_fun.Check_Active_CheckBox(arr.get(1));
		 Thread.sleep(1000);
		 A_fun.save();
		 Thread.sleep(500);
		 A_fun.Notification();
		 A_fun.Check_Active_CheckBox("No");
		 A_fun.save();
		 Thread.sleep(500);
		 A_fun.Notification();
		 Thread.sleep(500);
		 A_fun.Notification();
		 Thread.sleep(500);
		 Reporter.log("********End :TestCase ********");
		 Reporter.log("------------------------------");
	 }  
  @Test(priority=24,description="APP-232:Deleting: Select an Active administration")
	 public void Delete_Active_Administrations() throws IOException, InterruptedException {
		 WebDriver driver=WebDriverManager.getDriverInstance();
		 Home_index_Page hom = new Home_index_Page(driver);
		 Administrator_Page A_fun = PageFactory.initElements(driver, Administrator_Page.class);
		 Functional_Configration_Page FC_page= PageFactory.initElements(driver, Functional_Configration_Page.class);
		 Reporter.log("********Testcase : APP-232:Deleting: Select an Active administration ********");
		 A_fun.Delete_Admin("Active","fun_con_Admin_table");
		 hom.Render_Notifications();
		 Thread.sleep(500);
		 FC_page.Delete_Administration();
		 System.out.println("Delete Active Admin***************************");
		 Thread.sleep(1000);
		 A_fun.Notification();
		 Thread.sleep(500);
		 A_fun.Notification();
		 Thread.sleep(1000);
		 Reporter.log("********End :TestCase- APP-232 ********");
		 Reporter.log("---------------------------------------");
	 } 
   @Test(priority=25,description="APP-231:Deleting: Select an Inactive administration")
  public void Delete_Admin() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Functional_Configration_Page FC_page= PageFactory.initElements(driver, Functional_Configration_Page.class);
	  Administrator_Page CNA_fun = PageFactory.initElements(driver, Administrator_Page.class);
	  Reporter.log("********Testcase : APP-231:Deleting: Select an Inactive administration ********");
	  events eve= new events(driver);
	  eve.Table_event(arr.get(0), "fun_con_Admin_table");
	  FC_page.Delete_Administration();
	  Thread.sleep(1000);
	  CNA_fun.Notification();
	  Thread.sleep(500);
	  CNA_fun.Notification();
	  Reporter.log("********End :TestCase- APP-231 ********");
	  Reporter.log("---------------------------------------");
	 
  } 
}
