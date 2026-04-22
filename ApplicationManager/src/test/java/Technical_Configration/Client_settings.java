package Technical_Configration;

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
import appMan_Pages.Client_Settings_page;
@Listeners(ScreenShotOnFailure.class)
public class Client_settings {
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_Client_Settings");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void Goto_Client_settings_page() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("________________________ Client Settings_____________________________ ");
		  CS_page.Goto_Client_Settings_Page();
	  }
	  @Test(priority=2)
	  public void Clickon_Change_Icon() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Click on change Icon - ");
		  CS_page.Clickon_Change_icon();
		  Thread.sleep(500);
	  }
	  @Test(priority=3)
	  public void Select_Authentication_mode() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Select Autentication Mode - ");
		  String mode = arr.get(0);
		  switch(mode){
		  case("1"): CS_page.Window_AuthMode();
		                   System.out.println("Windows radio button is clicked");
		                   Reporter.log("Windows radio button is clicked"); 
		                   break;
		  case("2 "): CS_page.Forms_AuthMode();
		                  System.out.println("Forms radio button is clicked");
		                  Reporter.log("Forms radio button is clicked"); 
                           break;
		  }
		  
	  }
	  @Test(priority=4)
	  public void Check_Autometically_create_aNew_User() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Check Automatically create New User Checkbox - ");
			  CS_page.Autometically_create_newUSer(arr.get(1),arr.get(2));
	  }
	  @Test(priority=5)
	  public void Enter_Attachments_location() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Enter Attachment Location -");
		  CS_page.Attachment_location(arr.get(3));
	  }
	  @Test(priority=6)
	  public void Enter_Export_location() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Enter Attachment Location -");
		  CS_page.Export_location(arr.get(4));
	  }
	  @Test(priority=7)
	  public void Save_Client_settings_Changes() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Save Client Settings Changes -");
		  CS_page.Save_Client_Settings_Changes();
		  Thread.sleep(1000);
		  CS_page.Notification();
		  Thread.sleep(500);
		  CS_page.Notification();
	  }
	//  @Test(priority=8)
	  public void Clickon_Reset_PickList_Cache() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Click on Reset Picklist Cache Button -");
		  CS_page.Reset_picklist_Cache_button();
		  Thread.sleep(2000);
		  CS_page.Notification();
		  Thread.sleep(2000);
		  CS_page.Notification();
	  }
	 // @Test(priority=9)
	  public void Clickon_Reset_EFmode() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Client_Settings_page CS_page = PageFactory.initElements(driver, Client_Settings_page.class);
		  Reporter.log("Click on Reset EFmode Button -");
		  CS_page.Reset_EF_Mode_button();
		  Thread.sleep(2000);
		  CS_page.Notification();
		  Thread.sleep(2000);
		  CS_page.Notification();
		  Thread.sleep(2000);
		  Reporter.log("______________________ End of Client Settings Section___________________________");
	  }
	  
}
