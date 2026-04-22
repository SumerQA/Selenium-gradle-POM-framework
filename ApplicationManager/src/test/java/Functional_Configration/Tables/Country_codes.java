package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Country_Code_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Country_codes {
	
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_Country_Code");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1,description="APP-22:Verify command button for country code screen")
  public void Open_Country_codes_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  Reporter.log("________________________ Country codes Tab ___________________________________________ ");
	  cc_page.Goto_Country_Code_page();
	  Thread.sleep(3000);
	  System.out.println("Country codes Page is opened");
  }
  
  @Test(priority=2,description="APP-25:Verify the command button for slide panel in country code defination")
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  Reporter.log("********TestCase- APP-25:Verify the command button for slide panel in country code defination. ********");
	  cc_page.Creat_New_icon();
	 System.out.println("Create New panal is opened");
	 Thread.sleep(3000);
	 Reporter.log("********End :TestCase- APP-25  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Enter_Country_code_table_Name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  Reporter.log("********Enter value in Country code Table name field. ********");
	  cc_page.Country_Code_table_name("cc_country_codet_name",arr.get(0));
	  Thread.sleep(500);
	  cc_page.Create_new_Code_icon();
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
	  System.out.println("Country code table name  is Entered");
  }
  @Test(priority=4)
  public void Enter_Code_and_description() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  Reporter.log("********Enter value in Code and Description input field. ********");
	  cc_page.Create_new_Code_icon();
	  Thread.sleep(2000);
	  cc_page.Code_Input("cc_code_input", arr.get(1));   //Code
	  Thread.sleep(1000);
	  cc_page.Description_Input("cc_description_input",arr.get(2));
	 // cc_page.Save();
	  System.out.println("Country code table name  is Entered");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5,description="APP-166:For Save & Close button: When we edit 'Country code table name' field.")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  Reporter.log("********TestCase- APP-166:For Save & Close button: When we edit 'Country codes table name' field. ********");
	  cc_page.Save();
	  Thread.sleep(2000);
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  cc_page.Cancel();
	  Thread.sleep(500);
	  cc_page.Notifications();
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-166  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=6,description="APP-154:Pop-Up: When we enter the same country code and Description")
  public void Verify_same_country_code_and_Description() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  Reporter.log("********TestCase- APP-154:Pop-Up: When we enter the same country code and Description. ********");
	  System.out.println("TestCase- APP-154:Pop-Up: When we enter the same country code and Description.");
	  cc_page.Creat_New_icon();
	  Thread.sleep(2000);
	  cc_page.Country_Code_table_name("cc_country_codet_name",arr.get(0));
	  Thread.sleep(1000);
	  cc_page.Create_new_Code_icon();
	  Thread.sleep(2000);
	  cc_page.Code_Input("cc_code_input", arr.get(1));                      //Code
	  Thread.sleep(1000);
	  cc_page.Description_Input("cc_description_input",arr.get(2));
	  Thread.sleep(1000);
	  cc_page.Save_and_Close();
	  Thread.sleep(2000);
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  cc_page.Cancel();
	  Thread.sleep(2000);
	  cc_page.Notifications();
	  Thread.sleep(1500);
	  System.out.println("Verify same country code and Description");
	  Reporter.log("********End :TestCase- APP-154  ********");
	  Reporter.log("----------------------------------------");
  }
  
  
   @Test(priority=7,description="APP-158:For Reload button: when we update 'Country code table name'.")
   public void Verify_Reload_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-158:For Reload button: when we update 'Country code table name'. ********");
	  ev.Table_event(arr.get(0), "cc_country_code_table");
	  Thread.sleep(1000);
	  cc_page.Update_icon();
	  Thread.sleep(1000);
	  cc_page.Country_Code_table_name("cc_country_codet_name",arr.get(0)+"Reload");
	  Thread.sleep(1000);
	  cc_page.Reload();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  cc_page.Cancel();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-158  ********");
	  Reporter.log("----------------------------------------");
  }
   @Test(priority=8,description="APP-159:For save button: When we change value in 'Code/description'.")
   public void Verify_Save_Button_in_Code_description_Field() throws IOException, InterruptedException {
 	  WebDriver driver=WebDriverManager.getDriverInstance();
 	  Country_Code_Page cc_page = new Country_Code_Page(driver);
 	  events ev = new events(driver);
 	  Reporter.log("********TestCase- APP-159:For save button: When we change value in 'Code/description'. ********");
 	  ev.Table_event(arr.get(0), "cc_country_code_table");
 	  Thread.sleep(1000);
 	  cc_page.Cancel_Notifications();
 	  Thread.sleep(1000);
 	  cc_page.Update_icon();
 	  Thread.sleep(2000);
 	  ev.Table_event( arr.get(1),"cc_code_des_table");
 	  Thread.sleep(1000);
 	  cc_page.Update_new_Code_icon();
 	  Thread.sleep(2000);
 	  cc_page.Notifications();
 	  cc_page.Code_Input("cc_code_input", arr.get(1)+"Save");
 	  Thread.sleep(1000);
 	  cc_page.Description_Input("cc_description_input",arr.get(2)+"Save");
 	  Thread.sleep(2000);
 	  cc_page.Save();
 	  Thread.sleep(1000);
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  cc_page.Notifications();
 	  Thread.sleep(2000);
 	  cc_page.Cancel();
 	  Thread.sleep(1000);
	  cc_page.Notifications();
 	  Thread.sleep(3000);
 	  Reporter.log("********End :TestCase- APP-159  ********");
 	  Reporter.log("----------------------------------------");
   }
   @Test(priority=9,description="APP-162:Cancel button : when we click on yes/no button.")
   public void Verify_Cancel_Button() throws IOException, InterruptedException {
 	  WebDriver driver=WebDriverManager.getDriverInstance();
 	  Country_Code_Page cc_page = new Country_Code_Page(driver);
 	  events ev = new events(driver);
 	  Reporter.log("********TestCase- APP-162:Cancel button : when we click on yes/no button.. ********");
 	  ev.Table_event(arr.get(0), "cc_country_code_table");
 	  Thread.sleep(1000);
 	  cc_page.Update_icon();
 	  Thread.sleep(2000);
 	  cc_page.Country_Code_table_name("cc_country_codet_name",arr.get(0));
 	  Thread.sleep(500);
 	  ev.Table_event( arr.get(1)+"Save","cc_code_des_table");
 	  cc_page.Update_new_Code_icon();
 	  Thread.sleep(1000);
 	  cc_page.Code_Input("cc_code_input", arr.get(1)+"Test1");
 	  cc_page.Description_Input("cc_description_input",arr.get(2)+"Test1");
 	  cc_page.Cancel();
 	  Thread.sleep(2000);
 	 Thread.sleep(2000);
 	  cc_page.Cancel_Notifications();
 	  Reporter.log("********End :TestCase- APP-162  ********");
	  Reporter.log("----------------------------------------");
   }
   @Test(priority=10,description="APP-161:For 'Save as New' button: When we change value in 'Code/description'.")
   public void Verify_Save_as_New_Button_in_Code_description_Field() throws IOException, InterruptedException {
 	  WebDriver driver=WebDriverManager.getDriverInstance();
 	  Country_Code_Page cc_page = new Country_Code_Page(driver);
 	  events ev = new events(driver);
 	  Reporter.log("********TestCase- APP-161:For 'Save as New' button: When we change value in 'Code/description'. ********");
 	  ev.Table_event(arr.get(0), "cc_country_code_table");
 	  Thread.sleep(1000);
 	  cc_page.Update_icon();
 	  Thread.sleep(1000);
 	  cc_page.Country_Code_table_name("cc_country_codet_name",arr.get(0)+"Test");
 	  ev.Table_event( arr.get(1)+"Save","cc_code_des_table");
 	  cc_page.Update_new_Code_icon();
 	  Thread.sleep(2000);
 	  cc_page.Code_Input("cc_code_input", arr.get(1));
 	  Thread.sleep(1000);
 	  cc_page.Description_Input("cc_description_input",arr.get(2));
 	 Thread.sleep(1000);
 	  cc_page.Save_as_New();
 	 Thread.sleep(1000);
	  cc_page.Notifications();
 	  Thread.sleep(1000);
 	  cc_page.Cancel();
 	  Thread.sleep(2000);
 	  Reporter.log("********End :TestCase- APP-161  ********");
	  Reporter.log("----------------------------------------");
   }
    
  
   @Test(priority=11,description="APP-164:For Delete: code and description from detail panel.")
   public void Delete_code_description_from_detail_panel() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-164:For Delete: code and description from detail panel. ********");
	  ev.Table_event(arr.get(0)+"Test", "cc_country_code_table");
	  Thread.sleep(1000);
	  cc_page.Update_icon();
	  Thread.sleep(2000);
	  ev.Table_event(arr.get(1),"cc_code_des_table");
	  cc_page.Delete_new_Code_icon();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  Thread.sleep(500);
	  cc_page.Notifications();
	  cc_page.Cancel();
	  Thread.sleep(2000);
	  Reporter.log("********End :TestCase- APP-164  ********");
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=12)
  public void Link_Country_Code_table_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********Verify Link Country Code table to Administration . ********");
	  ev.Table_event(arr.get(3), "C_curr_admin_table");//Clicked on Administrations name
	  ev.Table_event(arr.get(0), "cc_country_code_table");        //Clicked on country code table table
	  Thread.sleep(1000);
	  cc_page.link();
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  cc_page.Save_changes();
	  Thread.sleep(2000);
	  cc_page.Notifications();
	  System.out.println("Newly Created Country code table is  linked Successfully");
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13,description="APP-163:For Delete: when the country code is linked to the administration")
  public void Delete_when_country_code_is_linked_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-163:For Delete: when the country code is linked to the administration. ********");
	  ev.Table_event(arr.get(0), "cc_country_code_table");        //Clicked on country code table table
	  Thread.sleep(1000);
	  cc_page.Delete_icon();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  Reporter.log("********End :TestCase- APP-163  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=14,description="APP-170:Unlinking country code")
  public void UnLink_Country_code_table_from_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("******** Test Case : APP-170:Unlinking country code. ********");
	  ev.Table_event(arr.get(0), "cc_country_code_unlink_table");   
	  Thread.sleep(1000);
	  cc_page.Unlink();
	  Thread.sleep(500);
	  cc_page.Save_changes();
	  Thread.sleep(3000);
	  cc_page.Notifications();
	  Thread.sleep(1000);
	  cc_page.Notifications();
	  System.out.println("Newly Created country code table is Unlinked Successfully");
	  Thread.sleep(3000);
	  Reporter.log("********End :TestCase- APP-170  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=15)
  public void Delete_Country_code_table() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********Delete Country Code . ********");
	  ev.Table_event(arr.get(0), "cc_country_code_table"); 
	  Thread.sleep(1000);
	  cc_page.Delete_icon();
	  Thread.sleep(500);
	  cc_page.Notifications();
	  Thread.sleep(500);
	  cc_page.Notifications();
	  cc_page.Save_changes();
	  Thread.sleep(500);
	  cc_page.Notifications();
	  Thread.sleep(500);
	  cc_page.Notifications();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "cc_country_code_table");
	  Thread.sleep(1000);
	  System.out.println("Newly Created country code table is  Deleted Successfully");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=16)
  public void Render_back_to_Home_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Country_Code_Page cc_page = new Country_Code_Page(driver);
	  events ev = new events(driver);
	  ev.Click_event("CI_Render_back");
	  cc_page.Cancel_Notifications();
  } 
  
}
