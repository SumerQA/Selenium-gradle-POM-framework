package Functional_Configration.Tables;

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
import appMan_Pages.Payment_method_Page;
@Listeners(ScreenShotOnFailure.class)
public class Payment_method {
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_Payment_method");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1,description="Verify command button for Payment method screen")
  public void Open_Payment_method_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("________________________ Payment Method Page ___________________________________________ ");
	  pm_page.Goto_Payment_method_page();
	  Reporter.log("Payment method Page is opened");
	  System.out.println("Payment method Page is opened");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=2)
  public void Click_on_create_icon_in_Payment_method_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("********Verify Create Icon. ********");
	  pm_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
	 Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Enter_Enter_Payment_method_Name_in_Create_Payment_method_panal() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("********Enter Payment method Name. ********");
	  pm_page.Payment_method_name("PM_pMethod_name",arr.get(0));//-----------------------------------
	  Reporter.log(arr.get(0)+ " : is Entered in the Payment method name input field.");
	  System.out.println(arr.get(0)+ " : is Entered in Payment method name input field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=4)
  public void Save_and_Close_in_Create_Payment_method_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("Verify Save and Close functionality------");
	  pm_page.Save_and_Close();
	  Thread.sleep(800);
	  pm_page.Notifications();
	  Thread.sleep(800);
	  pm_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5,description="Verify Payment method name is already in use")
  public void Verify_When_Payment_method_name_is_alreadyin_use_in_Payment_method_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("Verify Payment method name is already in use------------");
	  pm_page.Creat_New_icon();
	  Thread.sleep(500);
	  pm_page.Payment_method_name("PM_pMethod_name",arr.get(0));
	  pm_page.Save_and_Close();
	  Thread.sleep(1500);
	  pm_page.Notifications();
	  Thread.sleep(1000);
	  pm_page.Notifications();
	  pm_page.Cancel();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
  }
  
  
  @Test(priority=6,description="Verify Cancel Button Functionality")
  public void Verify_Cancel_Button_in_Create_Payment_method_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("Verify Cancel Button Functionality");
	  pm_page.Creat_New_icon();
	  Thread.sleep(500);
	  pm_page.Payment_method_name("PM_pMethod_name",arr.get(0));
	  pm_page.Cancel();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7,description="Verify- Save & New button: Select 'Administration' and 'Payment method' and click on Save and new button..")
  public void Verify_Save_as_New_Button_in_Create_Payment_method_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify- Save & New button: Select 'Administration' and 'Payment method' and click on Save and new button..");
	  ev.Table_event(arr.get(0), "PM_pMethod_table"); //--------------
	  pm_page.Creat_New_icon();
	  Thread.sleep(500);
	  pm_page.Payment_method_name("PM_pMethod_name",arr.get(0)+"saveASnEW");
	  pm_page.Save_as_New();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  pm_page.Cancel();
	  Thread.sleep(1500);
	  pm_page.Notifications();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=8,description="Verify- Save button: Select 'Administration' and 'Payment method' and click on Save button.")
  public void Verify_Save_Button_in_Create_Payment_method_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify- Save button: Select 'Administration' and 'Payment method' and click on Save button.");
	  ev.Table_event(arr.get(0), "PM_pMethod_table"); 
	  pm_page.Creat_New_icon();
	  Thread.sleep(500);
	  pm_page.Payment_method_name("PM_pMethod_name",arr.get(0)+"save");
	  pm_page.Save();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  pm_page.Cancel();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=9,description="Verify Reload button:Select 'Administration' and 'Risk code' and click on update button.")
  public void Verify_Reload_Button_in_Create_Payment_method_panal() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Reload button:Select 'Administration' and 'Risk code' and click on update button.");
	  ev.Table_event(arr.get(0), "PM_pMethod_table"); 
	  pm_page.Creat_New_icon();
	  Thread.sleep(500);
	  pm_page.Payment_method_name("PM_pMethod_name",arr.get(0)+"Reload");
	  pm_page.Reload_Create_panal();
	  Thread.sleep(500);
	  pm_page.Cancel();
	  Thread.sleep(300);
	  pm_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=10,description="Verify Linking Payment method functionality")
  public void Link_Payment_method_to_Selected_Administrations_in_Payment_method_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  Reporter.log("Verify Linking Payment method functionality");
	  events ev = new events(driver);
	  ev.Table_event(arr.get(1), "C_curr_admin_table");//Clicked on Administrations name
	  Thread.sleep(1000);
	  ev.Table_event(arr.get(0), "PM_pMethod_table");        //Clicked on Payment method table
	  Thread.sleep(500);
	  pm_page.link();
	  pm_page.Save_changes();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(500);
	  pm_page.Reload();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=11,description="Verify Delete Payment method that is linked to an administation")
  public void Delete_Linked_Payment_method_in_Payment_method_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Delete Payment method that is linked to an administation");
	  ev.Table_event(arr.get(0), "PM_pMethod_table"); 
	  pm_page.Delete_icon();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=12,description="Verify Unlinking Payment method functionality ")
  public void UnLink_Payment_method_from_Administrations_in_Payment_method_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Unlinking Payment method functionality");
	  ev.Table_event(arr.get(0), "PM_pMethod_linked_table");         //Clicked on Payment method table
	  pm_page.Unlink();
	  Thread.sleep(500);
	  pm_page.Save_changes();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  Thread.sleep(500);
	  pm_page.Reload();
	  Thread.sleep(500);
	  pm_page.Notifications();
	  System.out.println("Newly Created Payment methd Unlinked Successfully");
	  Thread.sleep(500);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13,description="Verify Delete Payment method that is not linked to an administation")
  public void Delete_Payment_method_Created_in_Payment_method_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Payment_method_Page pm_page = new Payment_method_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("Verify Delete Payment method that is not linked to an administation");
	  ev.Table_event(arr.get(0), "PM_pMethod_table"); 
	  pm_page.Delete_icon();
	  Thread.sleep(1000);
	  pm_page.Notifications();
	  Thread.sleep(1000);
	  pm_page.Notifications();
	  Thread.sleep(1500);
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "PM_pMethod_table");
	  Thread.sleep(1000);
	  Reporter.log("----------------------------------------");
	  Reporter.log("________________________ END - Payment Method Page ___________________________________________ ");
  }
}
