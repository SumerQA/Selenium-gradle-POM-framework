package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.System_notes_Page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class System_notes {
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_System_notes");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Open_System_notes_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("________________________ System Notes ___________________________________________ ");
	  sn_page.Goto_system_notes();
	  System.out.println("System Notes Page is opened");
  }
  @Test(priority=2)
  public void Click_on_Change_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Click on Change Icon. ********");
	  sn_page.Change_icon();
	 System.out.println("Change Icon is clicked");
	 Reporter.log("----------------------------------------");
  }
  @Test(priority=3,description="APP-187:'All notes are visible'")
  public void Make_all_system_notes_Visible() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********TestCase- APP-187:'All notes are visible. ********");
	  sn_page.make_all_system_notes_visible("SN_makeAll_sys_nots_visible", arr.get(0));
	  Reporter.log("********End :TestCase- APP-187  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=4,description="APP-186:'All notes are invisible'")
  public void Make_all_system_notes_Invisible() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********TestCase- APP-186:'All notes are invisible. ********");
	  sn_page.make_all_system_notes_visible("SN_makeAll_sys_nots_Invisible",arr.get(1));
	  
  }
  @Test(priority=5)
  public void Check_Actions_Add_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify Actions:add checkbox. ********");
	  sn_page.Checkbox("chk_notes1", arr.get(2));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=6)
  public void Check_Actions_Delete_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify Actions: delete checkbox. ********");
	  sn_page.Checkbox("chk_notes4", arr.get(3));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7)
  public void Make_dispute_available_for_SSE_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Make dispute available for SSE'  checkbox. ********");
	  sn_page.Checkbox("chk_notes6", arr.get(4));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=8)
  public void Action_Done_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Actions: done '  checkbox. ********");
	  sn_page.Checkbox("chk_notes7", arr.get(5));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=9)
  public void Action_MoveAll_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Actions: Move all'  checkbox. ********");
	  sn_page.Checkbox("chk_notes3", arr.get(6));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=10)
  public void Committed_payment_delete_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Committed payment: delete'  checkbox. ********");
	  sn_page.Checkbox("chk_notes405", arr.get(7));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=11)
  public void Committed_payment_new_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Committed payment: new'  checkbox. ********");
	  sn_page.Checkbox("chk_notes404", arr.get(8));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=12)
  public void Committed_payment_Change_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Committed payment :Change'  checkbox. ********");
	  sn_page.Checkbox("chk_notes408", arr.get(9));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13)
  public void Debtor_Assign_user_groups_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Debtor : Assign user groups'  checkbox. ********");
	  sn_page.Checkbox("chk_notes506", arr.get(10));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=14)
  public void Debtor_Remove_user_groups_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Debtor : Remove user group '  checkbox. ********");
	  sn_page.Checkbox("chk_notes507", arr.get(11));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=15)
  public void Debtor_Change_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Debtor : Change'  checkbox. ********");
	  sn_page.Checkbox("chk_notes509", arr.get(12));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=16)
  public void Debtor_New_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Debtor : New'  checkbox. ********");
	  sn_page.Checkbox("chk_notes508", arr.get(13));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=17)
  public void Invoice_Change_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Invoice : Change'  checkbox. ********");
	  sn_page.Checkbox("chk_notes601", arr.get(14));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=18)
  public void Invoice_New_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Invoice : New'  checkbox. ********");
	  sn_page.Checkbox("chk_notes600", arr.get(15));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=19)
  public void Onguard_monitoring_off_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'OnGuard monitoring: off'  checkbox. ********");
	  sn_page.Checkbox("chk_notes406", arr.get(16));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=20)
  public void Onguard_monitoring_On_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'OnGuard monitoring: on'  checkbox. ********");
	  sn_page.Checkbox("chk_notes407", arr.get(17));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=21)
  public void Payment_scheme_delete_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Payment scheme: delete'  checkbox. ********");
	  sn_page.Checkbox("chk_notes401", arr.get(18));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=22)
  public void Payment_scheme_Modify_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Payment scheme: modify'  checkbox. ********");
	  sn_page.Checkbox("chk_notes402", arr.get(19));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=23)
  public void Payment_scheme_New_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'Payment scheme: new'  checkbox. ********");
	  sn_page.Checkbox("chk_notes400", arr.get(20));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=24)
  public void New_debtor_created_note_visible_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'New 'debtor created' note visible '  checkbox. ********");
	  sn_page.Checkbox("chk_notes700", arr.get(21));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=25)
  public void New_invoice_created_note_visible_Checkbox () throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********Verify 'New 'Invoice created' note visible'  checkbox. ********");
	  sn_page.Checkbox("chk_notes701", arr.get(22));
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=26,description="APP-189:Uncheck few fields and click on 'Save' button")
  public void Save_All_Changes() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********TestCase- APP-189:Uncheck few fields and click on 'Save' button. ********");
	  sn_page.Save_changes();
	  Thread.sleep(2000);
	  sn_page.Notifications();
	  Thread.sleep(1000);
	  sn_page.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-189  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=27,description="APP-188:UnCheck few fields and click on 'Reload' button")
  public void Verify_reload_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  System_notes_Page sn_page = new System_notes_Page(driver);
	  Reporter.log("********TestCase- APP-188:UnCheck few fields and click on 'Reload' button. ********");
	  sn_page.Change_icon();
	  Thread.sleep(1000);
	  sn_page.Checkbox("chk_notes1", "No");
	  Thread.sleep(500);
	  sn_page.Checkbox("chk_notes6", "No");
	  sn_page.Reload();
	  Thread.sleep(500);
	  sn_page.Save_changes();
	  Thread.sleep(2000);
	  sn_page.Notifications();
	  Thread.sleep(2000);
	  sn_page.Notifications();
	  Reporter.log("********End :TestCase- APP-188  ********");
	  Reporter.log("----------------------------------------");
  } 
}
