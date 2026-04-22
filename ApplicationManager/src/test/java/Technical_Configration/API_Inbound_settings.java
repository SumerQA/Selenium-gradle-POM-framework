package Technical_Configration;

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
import appMan_Pages.API_Inbound_settings_Page;
@Listeners(ScreenShotOnFailure.class)
public class API_Inbound_settings {
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_API_Client");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void Open_API_Inbound_settings_Page() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  Reporter.log("________________________ API Client Page_____________________________ ");
		  Thread.sleep(5000);
		  api_page.Goto_Api_Inbound_Settings_page();
	  }
	  @Test(priority=2)
	  public void Create_New_ICon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  Reporter.log("Click on Create Button - ");
		  api_page.Create_icon();
		  Thread.sleep(1000);
	  }
	  @Test(priority=3)
	  public void Enter_API_client_Name() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  api_page.API_Client_name(arr.get(0));
	  }
	  @Test(priority=4)
	  public void Enter_IP_Address() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  api_page.IP_address(arr.get(1));
	  }
	  @Test(priority=5)
	  public void Enter_Token_Expiry_Date() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  api_page.Access_Token_Expiry("5");
		  Thread.sleep(1000);
	  }
	  @Test(priority=6)
	  public void Enter_Refresh_period_Maximun_Days() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  api_page.Refresh_Period("50");
		  Thread.sleep(1000);
	  }
	  @Test(priority=7)
	  public void Save_API_client_Settings() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  Thread.sleep(1000);
		  api_page.Notification();
	  }
	  @Test(priority=8)
	  public void Verify_mandatory_Fields() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);	
		  api_page.Create_icon();
		  api_page.API_Client_name("");
		  api_page.IP_address(arr.get(1));
		  api_page.Access_Token_Expiry("6");
		  api_page.Refresh_Period("126");
		  Thread.sleep(1000);
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.API_Client_name(arr.get(0)+"1");
		  api_page.IP_address("");
		  api_page.Refresh_Period("65");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		 // api_page.Refresh_Icon();
		  api_page.API_Client_name(arr.get(0)+"1");
		  api_page.IP_address(arr.get(1));
		  api_page.Refresh_Period("");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.API_Client_name(arr.get(0)+"1");
		  api_page.IP_address(arr.get(1));
		  api_page.Refresh_Period("366");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.Refresh_Icon();
		  api_page.API_Client_name(arr.get(0)+"1");
		  api_page.IP_address(arr.get(1));
		  api_page.Refresh_Period("30");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.Notification();
	  }
	  @Test(priority=9)
	  public void Verify_Redundancy_in_API_User() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);	
		  api_page.Create_icon();
		  api_page.API_Client_name(arr.get(0));
		  api_page.IP_address(arr.get(1));
		  api_page.Access_Token_Expiry("7");
		  api_page.Refresh_Period("30");
		  api_page.Generate_token_Button();
		  api_page.Notification();
	  }
	  @Test(priority=10)
	  public void Verify_Same_User_name_with_Different_IPaddress() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);	
		  api_page.API_Client_name(arr.get(0));
		  api_page.IP_address("192.168.0.105");
		  api_page.Access_Token_Expiry("8");
		  api_page.Refresh_Period("99");
		  api_page.Generate_token_Button();
		  api_page.Notification();
	  }
	  @Test(priority=11)
	  public void Verify_Valid_IPaddress_Format() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);	
		  api_page.Create_icon();
		  api_page.API_Client_name(arr.get(0)+"2");
		  api_page.IP_address("");
		  api_page.Access_Token_Expiry("9");
		  api_page.Refresh_Period("45");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.IP_address("test");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.IP_address("@@@@");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.IP_address("1.0");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.IP_address("192.168.0.1");
		  api_page.Generate_token_Button();
		  api_page.Notification();
		  api_page.Notification();
	  }
	  @Test(priority=12)
	  public void Update_API_client_User() throws Exception  {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);	
		  api_page.List_of_API_Connection_table("api_connections_Table",arr.get(0)+"2", "192.168.0.1");
		  api_page.Update_icon();
		  api_page.IP_address("192.168.0.111");
		  api_page.Access_Token_Expiry("15");
		  api_page.Refresh_Period("87");
		  api_page.Generate_token_Button();
		  api_page.Notification();		
		  api_page.Notification();
		  
	  }
	  
	  @Test(priority=13)
	  public void Delete_API_client_User() throws Exception  {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Inbound_settings_Page api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);	
		  events ev= new events(driver);
		  api_page.List_of_API_Connection_table("api_connections_Table",arr.get(0)+"2", "192.168.0.111");
		  api_page.Delete_icon();
		  api_page.Notification();
		  api_page.Notification();
		  ev.CheckItem_AfterDeleting_In_Table_event(arr.get(0)+"2", "api_connections_Table");
		  Thread.sleep(5000);
	  }
	 
}
