package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Customer_Status_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Debtor_status {
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_Risk_code");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1,description="APP-28:Verify the button in toolbar of customer status")
  public void Open_Debtor_status_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  Reporter.log("________________________ Customer Status ___________________________________________ ");
	  Reporter.log("********TestCase- APP-28:Verify the button in toolbar of customer status. ********");
	  cs_page.Goto_Customer_status_page();
	  Thread.sleep(1000);
	  System.out.println("Debtor status Page is opened");
	  Reporter.log("********End :TestCase- APP-28  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  Reporter.log("********Verify Create Icon. ********");
	  cs_page.Creat_New_icon();
	  Thread.sleep(500);
	  System.out.println("Create New panal is opened");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Enter_Debtor_status_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  Reporter.log("********Enter Debtor status Name. ********");
	  cs_page.Customer_Status_name("cs_cus_ststs_name",arr.get(0));
	  Reporter.log(arr.get(0) + " :is Entered in the Debtor status Name input field.");
	  System.out.println("Customer Status name  is Entered");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=4,description="APP-193:Save & Close button")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  Reporter.log("********TestCase- APP-193:Save & Close button. ********");
	  cs_page.Save_and_Close();
	  Thread.sleep(1000);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-193  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5,description="APP-192:Save as New button")
  public void check_Save_as_New_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  Reporter.log("********TestCase- APP-192:Save as New button. ********");
	  cs_page.Creat_New_icon();
	  Thread.sleep(500);
	  cs_page.Customer_Status_name("cs_cus_ststs_name",arr.get(0)+"Save as New");
	  cs_page.Save_as_New();
	  Thread.sleep(1000);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  cs_page.Cancel();
	  Thread.sleep(500);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-192  ********");
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=6,description="APP-191:Reload, save and cancel button")
  public void check_Reload_save_and_cancel_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  Reporter.log("********TestCase- APP-191:Reload, save and cancel button. ********");
	  cs_page.Creat_New_icon();
	  Thread.sleep(500);
	  cs_page.Customer_Status_name("cs_cus_ststs_name",arr.get(0)+"Reload");
	  Reporter.log(arr.get(0)+"Reload" + ": is Entered in the Customer Statis Name input field.");
	  cs_page.Reload();
	  cs_page.Customer_Status_name("cs_cus_ststs_name",arr.get(0)+"Save");
	  cs_page.Save();
	  Thread.sleep(500);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  cs_page.Cancel();
	  Thread.sleep(500);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-191 ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7,description="APP-199:For update: Cancel button")
  public void Verify_Cancel_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-199:For update: Cancel button. ********");
	  ev.Table_event(arr.get(0), "cs_cus_stats_table"); 
	  cs_page.Update_icon();
	  Thread.sleep(500);
	  cs_page.Customer_Status_name("cs_cus_ststs_name",arr.get(0)+"Cancel");
	  cs_page.Cancel();
	  cs_page.Notifications();
	  Reporter.log("********End :TestCase- APP-199 ********");
	  Reporter.log("----------------------------------------");
	  
  }
  @Test(priority=8,description="APP-202:Linking customer to single admins")
  public void Link_Debtor_status_to_Selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-202:Linking customer to single admins. ********");
	  ev.Table_event(arr.get(1), "C_curr_admin_table");//Clicked on Administrations name
	  Thread.sleep(1000);
	  ev.Table_event(arr.get(0), "cs_cus_stats_table");   
	  Thread.sleep(1000);//Clicked on Customer status table
	  cs_page.link();
	  cs_page.Save_changes();
	  Thread.sleep(2000);
	  cs_page.Notifications();
	  System.out.println("Newly Created Debtor status linked Successfully");
	  Reporter.log("********End :TestCase- APP-202 ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=9,description="Delete Linkded Debtor Status")
  public void Delete_Linked_Debtor_status() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-200:Deleting. ********");
	  ev.Table_event(arr.get(0), "cs_cus_stats_table"); 
	  cs_page.Delete_icon();
	  Thread.sleep(2000);
	  cs_page.Notifications();
	  Thread.sleep(1000);
	  cs_page.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=10,description="APP-205:Unlinking customer :not in use in profile,import or debtor")
  public void UnLink_Debtor_status_from_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-205:Unlinking customer :not in use in profile,import or debtor. ********");
	  ev.Table_event(arr.get(1), "C_curr_admin_table");//Clicked on Administrations name
	  Thread.sleep(1000);
	  ev.Table_event(arr.get(0), "cs_sus_stats_Linked_table");  
	  Thread.sleep(1000);
	  cs_page.Unlink();
	  cs_page.Save_changes();
	  Thread.sleep(500);
	  cs_page.Notifications();
	  Thread.sleep(500);
	  cs_page.Notifications();
	  System.out.println("Newly Created Debtor status Unlinked Successfully");
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-205 ********");
	  Reporter.log("----------------------------------------");
  }
  /*@Test(priority=10,description="APP-206:Prioritising the customer status.")
  public void Verify_Prioritisation_of_customer_status() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  events ev = new events(driver);
	  ev.Sort_From_Table("cs_cus_stats_table", arr.get(0), "1");//Clicked on Administrations name
	  cs_page.Save_changes();
	  Thread.sleep(500);
  }*/
  
  @Test(priority=11,description="APP-200:Deleting")
  public void Delete_Debtor_status() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Customer_Status_Page cs_page = new Customer_Status_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-200:Deleting. ********");
	  ev.Table_event(arr.get(0), "cs_cus_stats_table"); 
	  cs_page.Delete_icon();
	  Thread.sleep(2000);
	  cs_page.Notifications();
	  Thread.sleep(1000);
	  cs_page.Notifications();
	  cs_page.Save_changes();
	  Thread.sleep(1000);
	  cs_page.Notifications();
	  Thread.sleep(1000);
	  cs_page.Notifications();
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "cs_cus_stats_table");
	  //System.out.println("Newly Created Debtor status is  Deleted Successfully");
	  Thread.sleep(2000);
	  Reporter.log("********End :TestCase- APP-200 ********");
	  Reporter.log("----------------------------------------");
  }
  
}
