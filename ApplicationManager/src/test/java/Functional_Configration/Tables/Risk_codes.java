package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Risk_Code_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class Risk_codes {
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
			//System.out.println(arr.size());
	}
  @Test(priority=1,description="APP-19:Verify command button for risk code screen")
  public void Open_Risk_codes_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Thread.sleep(3000);
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("________________________ Risk codes ___________________________________________ ");
	  Reporter.log("********TestCase- APP-19:Verify command button for risk code screen. ********");
	  rc_page.Goto_Risk_Code_page();
	  Reporter.log("********End :TestCase- APP-19  ********");
	  System.out.println("Risk Code Page is opened");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("********Verify Create Icon. ********");
	  rc_page.Creat_New_icon();
	  Thread.sleep(500);
	 System.out.println("Create New panal is opened");
	 Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Enter_Risk_code_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("********Enter Risk code Name. ********");
	  rc_page.Risk_Code_name("RC_riskcode_name",arr.get(0));
	  Reporter.log(arr.get(0)+ " : is Entered in the Risk code name input field.");
	  System.out.println(arr.get(0)+ " : is Entered in risk code name field");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=4,description="APP-76:For Save & Close button: Select 'Administration' and 'Risk code' and click on Save and close button.")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("********TestCase- APP-76:For Save & Close button: Select 'Administration' and 'Risk code' and click on Save and close button.. ********");
	  rc_page.Save_and_Close();
	  Thread.sleep(800);
	  rc_page.Notifications();
	  Thread.sleep(800);
	  rc_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("********End :TestCase- APP-76  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5,description="APP-92:When risk code name is already in use")
  public void Verify_When_Risk_codes_name_is_alreadyin_use() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("********TestCase- APP-92:When risk code name is already in use. ********");
	  rc_page.Creat_New_icon();
	  Thread.sleep(500);
	  rc_page.Risk_Code_name("RC_riskcode_name",arr.get(0));
	  rc_page.Save_and_Close();
	  Thread.sleep(1500);
	  rc_page.Notifications();
	  Thread.sleep(1000);
	  rc_page.Notifications();
	  rc_page.Cancel();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("********End :TestCase- APP-92  ********");
	  Reporter.log("----------------------------------------");
  }
  
  
  @Test(priority=6,description="APP-73:Cancel Button")
  public void Verify_Cancel_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("********TestCase- APP-73:Cancel Button. ********");
	  rc_page.Creat_New_icon();
	  Thread.sleep(500);
	  rc_page.Risk_Code_name("RC_riskcode_name",arr.get(0));
	  rc_page.Cancel();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("********End :TestCase- APP-73  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7,description="APP-77:For Save & New button: Select 'Administration' and 'Risk code' and click on Save and new button..")
  public void Verify_Save_as_New_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-77:For Save & New button: Select 'Administration' and 'Risk code' and click on Save and new button. ********");
	  ev.Table_event(arr.get(0), "RC_riskcodes_table"); 
	  rc_page.Creat_New_icon();
	  Thread.sleep(500);
	  rc_page.Risk_Code_name("RC_riskcode_name",arr.get(0)+"saveASnEW");
	  rc_page.Save_as_New();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  rc_page.Cancel();
	  Thread.sleep(1500);
	  rc_page.Notifications();
	  Reporter.log("********End :TestCase- APP-77  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=8,description="APP-75:For Save button: Select 'Administration' and 'Risk code' and click on Save button.")
  public void Verify_Save_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-75:For Save button: Select 'Administration' and 'Risk code' and click on Save button. ********");
	  ev.Table_event(arr.get(0), "RC_riskcodes_table"); 
	  rc_page.Creat_New_icon();
	  Thread.sleep(500);
	  rc_page.Risk_Code_name("RC_riskcode_name",arr.get(0)+"save");
	  rc_page.Save();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  rc_page.Cancel();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("********End :TestCase- APP-75  ********");
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=9,description="APP-74:For Reload button:Select 'Administration' and 'Risk code' and click on update button.")
  public void Verify_Reload_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-74:For Reload button:Select 'Administration' and 'Risk code' and click on update button. ********");
	  ev.Table_event(arr.get(0), "RC_riskcodes_table"); 
	  rc_page.Creat_New_icon();
	  Thread.sleep(500);
	  rc_page.Risk_Code_name("RC_riskcode_name",arr.get(0)+"Reload");
	  rc_page.Reload_Create_panal();
	  Thread.sleep(500);
	  rc_page.Cancel();
	  Thread.sleep(300);
	  rc_page.Notifications();
	  Thread.sleep(1500);
	  Reporter.log("********End :TestCase- APP-74  ********");
	  Reporter.log("----------------------------------------");
  }
  
  @Test(priority=10,description="APP-86:Linking Risk code")
  public void Link_Risk_codes_to_Selected_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  Reporter.log("********TestCase- APP-86:Linking Risk code. ********");
	  events ev = new events(driver);
	  ev.Table_event(arr.get(1), "C_curr_admin_table");//Clicked on Administrations name
	  Thread.sleep(1000);
	  ev.Table_event(arr.get(0), "RC_riskcodes_table");        //Clicked on Risk codes table
	  Thread.sleep(500);
	  rc_page.link();
	  rc_page.Save_changes();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(500);
	  rc_page.Reload();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Reporter.log("********End :TestCase- APP-86  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=11,description="APP-78:Delete riskcode that is linked to an administation")
  public void Delete_Linked_Risk_codes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-78:Delete riskcode that is linked to an administation. ********");
	  ev.Table_event(arr.get(0), "RC_riskcodes_table"); 
	  rc_page.Delete_icon();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Reporter.log("********End :TestCase- APP-78  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=12,description="APP-87:Unlinking risk code")
  public void UnLink_Risk_codes_from_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-87:Unlinking risk code. ********");
	  ev.Table_event(arr.get(0), "RC_riskcode_linked_table");         //Clicked on Risk codes table
	  rc_page.Unlink();
	  Thread.sleep(500);
	  rc_page.Save_changes();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  Thread.sleep(500);
	  rc_page.Reload();
	  Thread.sleep(500);
	  rc_page.Notifications();
	  System.out.println("Newly Created risk Codes Unlinked Successfully");
	  Thread.sleep(500);
	  Reporter.log("********End :TestCase- APP-87  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13,description="APP-79:Delete riskcode that is not linked to an administation")
  public void Delete_Risk_codes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Risk_Code_Page rc_page = new Risk_Code_Page(driver);
	  events ev = new events(driver);
	  Reporter.log("********TestCase- APP-79:Delete riskcode that is not linked to an administation. ********");
	  ev.Table_event(arr.get(0), "RC_riskcodes_table"); 
	  rc_page.Delete_icon();
	  Thread.sleep(1000);
	  rc_page.Notifications();
	  Thread.sleep(1000);
	  rc_page.Notifications();
	  System.out.println("Newly Created risk Codes  Deleted Successfully");
	  Thread.sleep(1500);
	  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0), "RC_riskcodes_table");
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-79  ********");
	  Reporter.log("----------------------------------------");
  }
  
}
