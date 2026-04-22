package Technical_Configration;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Printers_page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class Printers {
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_Printers");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void Open_Printers_Page() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("________________________ Printers_____________________________ ");
		  p_page.Goto_Printers_Page();
	  }
	  @Test(priority=2)
	  public void Create_New_Printer() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Click on Create Button - ");
		  p_page.New_Printer_Settings_icon();
		  Thread.sleep(500);
	  }
	  @Test(priority=3)
	  public void Enter_Printer_Name() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Enter Printer Name - ");
		  p_page.Printer_Name(arr.get(0));
	  }
	  @Test(priority=4)
	  public void Enter_Description() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Enter Description - ");
		  p_page.Description(arr.get(1));
	  }
	  @Test(priority=5)
	  public void Enter_Printer_location() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Enter Printer Location - ");
		  p_page.Printer_Location(arr.get(2));
	  }
	  @Test(priority=6)
	  public void Save_Printers_Setting_Changes() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Click on Save Button - ");
		  p_page.Save_Printer_Settings_Changes();
		  p_page.Notification();
		  Thread.sleep(1000);
		  p_page.Notification();
	  }
	  @Test(priority=7)
	  public void Check_Newly_created_Printerin_PrinterList() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Check Newly created Printer in Printer List");
		  p_page.Listof_Printers(arr.get(0));	 
		  
	  }
	  @Test(priority=8)
	  public void Check_Update_Button() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Check update Button- ");
		  p_page.Change_icon();
		  Thread.sleep(400);
		  p_page.Printer_Name(arr.get(0)+"Test");
	  }
	  @Test(priority=9)
	  public void Check_Reload_Button() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Check update Button- ");
		  p_page.Refresh_Printer_Settings_Changes();
		  Thread.sleep(400);
		  p_page.Save_Printer_Settings_Changes();
		  Thread.sleep(400);
		  p_page.Notification();
		  p_page.Notification();
	  }
	  @Test(priority=10)
	  public void Delete_Printer_From_List() throws Exception  {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Delete Newly created Printer from Printer List");
		  p_page.Listof_Printers(arr.get(0));
		  Thread.sleep(500);
		  p_page.Delete_icon();	
		  Thread.sleep(1000);
		  p_page.Notification();
		  Thread.sleep(500);
		  p_page.Notification();
	  }
	  @Test(priority=11)
	  public void Check_Printer_Deleted_from_Printer_List() throws Exception  {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Printers_page p_page = PageFactory.initElements(driver, Printers_page.class);
		  Reporter.log("Check Printer deleted from Printer List");
		  p_page.Check_Existing_Printer(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("________________________ End :Printers Section _____________________________ ");
	  }
}
