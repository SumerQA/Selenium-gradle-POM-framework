package Functional_Configration.Currency;

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
import appMan_Pages.Currency_Page;
@Listeners(ScreenShotOnFailure.class)
public class Currency {
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Currency");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Goto_Currency_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  Reporter.log("<<======================{Currency Tab}=======================>> ");
	  c_page.Goto_Currency_page();
	  System.out.println("Currency Page is opened");
  }
@Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
  }
  @Test(priority=3)
  public void Select_ISO_Code() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  System.out.println(arr.get(0)+" :  is selected from DDlist");
  }
  @Test(priority=4)
  public void Enter_Currency_Code() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Currency_code("C_Currency_code",arr.get(1));
	  System.out.println(arr.get(1)+ "  is entered in Currency Code Input Field. ");
  }
  @Test(priority=5)
  public void Description() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Description();
  }
  @Test(priority=6)
  public void Enter_Display_text() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Display_text();
	  c_page.Display_text_Edit("C_Display_text",arr.get(2));
	  System.out.println(arr.get(2)+ "is Entered in the Display text Input Field");
  }
  @Test(priority=7)
  public void Select_Display_Decimal() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  System.out.println(arr.get(3)+ " is Selected from Display Decimal DDlist");
  }
  @Test(priority=8)
  public void Select_Import_Devide() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  System.out.println(arr.get(4)+" is Selected from Import devide DDlist");
  }
  @Test(priority=9)
  public void Save_Newly_created_Currency() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Save();
	  Thread.sleep(2000);
	  System.out.println("Newly Created Currency:- "+arr.get(0)+" is saved Sucessfully");
  }
  @Test(priority=10,description = "You have added a new currency. Do you like to enter the exchange rate now?-Clicked on Yes button")
  public void Enter_Exchange_rate_Now() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Notifications();
  }
  @Test(priority=11)
  public void Create_Exchange_rate() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(1000);
	  System.out.println("Create New Exchange rate section is opened");
  }
  @Test(priority=12)
  public void Enter_Exchange_rate() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", arr.get(5));
	  System.out.println("Exchange rate is Entered");
  }
  @Test(priority=13,description="APP-295:Save and close button")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Save_and_Close();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
  }
  @Test(priority=14)
  public void Update_Exchange_rate() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  events eve = new events(driver);
	  Currency_Page c_page = new Currency_Page(driver);
	  eve.Table_event(arr.get(1), "C_currencies_table");
	  Thread.sleep(1000);
	  c_page.Exchange_rate_icon();
	  Thread.sleep(2000);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(1000);
	  c_page.Exchange_rate_Currency("7");
	  Thread.sleep(500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", "8.7");
	  Thread.sleep(1000);
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Close_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
  }
  @Test(priority=15,description="Save and Close New Currency with No Notification button")
  public void Create_Currency_with_SaveandClose_and_No_Notification_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  c_page.Currency_code("C_Currency_code",arr.get(1)+" doller");
	  c_page.Display_text_Edit("C_Display_text",arr.get(2)+" doller");
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  Thread.sleep(1500);
	  c_page.Save_and_Close_button();
	  Thread.sleep(1000);
	  c_page.No_Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  c_page.Cancel();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
  }
  @Test(priority=16,description="Save and Close New Currency with No Notification button")
  public void Create_Currency_with_Save_and_Yes_Notification_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  driver.navigate().refresh();
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code","AUD");
	  c_page.Currency_code("C_Currency_code","AUD");
	  c_page.Display_text_Edit("C_Display_text","AUD");
	  c_page.Display_Decimal("C_Display_decimal","3 (123,456)");
	  c_page.Import_devide("C_Import_devide","100");
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(2500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Notifications();
	  Thread.sleep(2000);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", ".25");
	  System.out.println("Exchange rate is Entered");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(1500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Notifications();
	  c_page.Close_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  
  }
  @Test(priority=17,description="Save and Close New Currency with No Notification button")
  public void Create_Currency_with_Save_and_No_Notification_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  driver.navigate().refresh();
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code","AUD");
	  c_page.Currency_code("C_Currency_code","AUD1");
	  c_page.Display_text_Edit("C_Display_text","AUD1");
	  c_page.Display_Decimal("C_Display_decimal","3 (123,456)");
	  c_page.Import_devide("C_Import_devide","100");
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(1500);
	  c_page.No_Notifications();
	  Thread.sleep(1500);
	  c_page.No_Notifications();
	  Thread.sleep(1500);
	  c_page.Cancel();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  
  }
  @Test(priority=18,description="Verify conversion rate of the Currency Created with No Icon in Notification")
  public void Check_Currency_conversion_rate_created_without_Conversion() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  events ev = new events(driver);
	  driver.navigate().refresh();
	  Thread.sleep(1000);
	  ev.Table_event(arr.get(1)+" doller", "C_currencies_table");        //Clicked on currencies table
	  Thread.sleep(1000);
	  c_page.Exchange_rate_icon();
	  Thread.sleep(1000);;
	  c_page.Verify_Exchange_rate("C_exchange_rate_table");
	  c_page.Close_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
	
  } 
  @Test(priority=19,description="Verify conversion rate of the Currency Created with No Icon in Notification")
  public void Validate_Currency_Exchange_rate_with_valid_and_Invalid_Input() throws IOException, InterruptedException {
	   WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event("AUD", "C_currencies_table");        //Clicked on currencies table
	  Thread.sleep(1000);
	  c_page.Exchange_rate_icon();
	  Thread.sleep(1000);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", " ");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", "Test");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", "0123456789");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", "@@@");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", ".0000002");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", "132456789");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", ".000002");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(1500);
	  c_page.Exchange_rate_Table("C_exchange_rate_table");
	  c_page.Close_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();  
  } 
  @Test(priority=20,description="Change Exchange rate Currency with System Currency and Add Exchange rate")
  public void Change_Exchange_rate_Currency_with_System_Currency_and_Add_Conversion_rate() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event("AUD", "C_currencies_table");        //Clicked on currencies table
	  Thread.sleep(1000);
	  c_page.Exchange_rate_icon();
	  Thread.sleep(1000);;
	  c_page.Exchange_rate_Currency("(USD)");
	  Thread.sleep(800);
	  c_page.Create_Exchange_Rate_icon();
	  Thread.sleep(500);
	  c_page.Exchange_Rate_inputField("C_exchange_rate_input_field", "0.9");
	  c_page.Save_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  c_page.Close_Exchange_Rate();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();  
  } 
@Test(priority=21,description="APP-285:Pop-Up message appears when we enter the same currency code")
  public void Verify_PopUp_message_for_same_currency_code() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  c_page.Currency_code("C_Currency_code",arr.get(1));
	  c_page.Display_text_Edit("C_Display_text",arr.get(2));
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  Thread.sleep(1500);
	  c_page.Save();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  c_page.Cancel();
	  Thread.sleep(1000);
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications(); 
  }
  @Test(priority=22,description="APP-293:Reload, Save and cancel button")
  public void Verify_Reload_Save_and_cancel_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  c_page.Currency_code("C_Currency_code",arr.get(1));
	  c_page.Display_text_Edit("C_Display_text",arr.get(2));
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  c_page.Refresh();
	  Thread.sleep(1000);
	  c_page.Save();
	  Thread.sleep(2000);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Cancel();
	  Thread.sleep(500);
	  c_page.Notifications();
  }
  
  @Test(priority=23,description="Verify Currency Code mandatory field.")
  public void Check_Currency_Code_mandatory_field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  c_page.Display_text_Edit("C_Display_text",arr.get(2));
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  c_page.Save();
	  Thread.sleep(2000);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Cancel();
	  Thread.sleep(500);
	  c_page.Notifications();
  }
  
  @Test(priority=24,description="APP-298:Enter the vale in all the fields except 'Descriptiobn' and click on save button.")
  public void Check_Description_mandatory_field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  c_page.Currency_code("C_Currency_code",arr.get(1));
	  c_page.Clear_Description_input();
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  c_page.Save();
	  Thread.sleep(2000);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Cancel();
	  Thread.sleep(500);
	  c_page.Notifications();
  }
  
  
  @Test(priority=25,description="APP-299:Enter the vale in all the fields except 'Display text' and click on save button.")
  public void Check_Display_text_mandatory_field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  c_page.Creat_New_icon();
	  Thread.sleep(1000);
	  c_page.ISO_code("C_ISO_code",arr.get(0));
	  c_page.Currency_code("C_Currency_code",arr.get(1));
	  c_page.Display_text_Edit_Clear("C_Display_text");
	  c_page.Display_Decimal("C_Display_decimal",arr.get(3));
	  c_page.Import_devide("C_Import_devide",arr.get(4));
	  c_page.Save();
	  Thread.sleep(2000);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Cancel();
	  Thread.sleep(500);
	  c_page.Notifications();
  }
  
  @Test(priority=26,description="APP-288:Linking currencies code to administartion")
  public void Link_Currency_to_Selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(6), "C_curr_admin_table");//Clicked on Administrations name
	  Thread.sleep(1000);
	  ev.Table_event(arr.get(1), "C_currencies_table");        //Clicked on currencies table
	  Thread.sleep(1000);
	  c_page.link();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Save_Changes();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Reload();
	  Thread.sleep(1000);
	  System.out.println("Newly Created Cost Scheme "+(arr.get(1)) + ": is linked Successfully");
  }

 @Test(priority=27,description="APP-290:Unlinking currency from currency linked to selected administartion")
  public void UnLink_Currency_from_Selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event(arr.get(1), "C_linked_to_admin_table");//Clicked on Currencies linked to the selected administrations  table
	  Thread.sleep(1000);
	  c_page.Unlink();
	  c_page.Notifications();
	  Thread.sleep(1000);
	  c_page.Notifications();
  }
  @Test(priority=28)
  public void Delete_Currency() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Currency_Page c_page = new Currency_Page(driver);
	  events ev = new events(driver);
	  ev.Table_event_Click_First("C_currencies_table");
	  Thread.sleep(1000);
	  c_page.link();
	  Thread.sleep(500);
	  c_page.Notifications();
	  c_page.Save_Changes();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(500);
	  ev.Table_event(arr.get(1), "C_currencies_table");//Clicked on Currencies linked to the selected administrations  table
	  c_page.Delete_Currency_icon();
	  Thread.sleep(500);
	  c_page.Notifications();
	  Thread.sleep(500);
	  c_page.Notifications();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(1), "C_currencies_table");
	  System.out.println("Newly Created Currency Deleted Successfully");
	  Reporter.log("<<======================{End : Currency Section}=======================>> ");
  }
  
}
