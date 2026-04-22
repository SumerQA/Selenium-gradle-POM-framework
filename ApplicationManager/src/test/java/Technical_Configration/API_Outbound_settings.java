package Technical_Configration;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Configration_Files.connectDB;
import appMan_Pages.API_Call_templetes_Page;
import appMan_Pages.API_Inbound_settings_Page;
import appMan_Pages.API_OutBound_settings_Page;
import appMan_Pages.Technical_Configration_page;
@Listeners(ScreenShotOnFailure.class)
public class API_Outbound_settings {
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	connectDB db = new connectDB();
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
	  public void Open_API_Outbound_settings_Page() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  Reporter.log("________________________ API Client Page_____________________________ ");
		 Thread.sleep(5000);
		  api_page.Goto_Api_outbound_Settings_page();
	  }
	  @Test(priority=2)
	  public void Create_New_ICon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  Reporter.log("Click on Create Button - ");
		  api_page.Create_icon();
		  Thread.sleep(1000);
	  }
	  @Test(priority=3)
	  public void Enter_Resource_Name() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Resource_name(arr.get(3));
	  }
	  @Test(priority=4)
	  public void Enter_Description_for_new_Rosource() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Description("For "+ arr.get(3));
	  }
	  @Test(priority=5)
	  public void Select_Scheme_for_new_Resource() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Scheme_base_path("HTTP");
		  Thread.sleep(1000);
	  }
	  @Test(priority=6)
	  public void Enter_Host_Base_path_for_new_Resource() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Host(arr.get(4));
		  Thread.sleep(1000);
	  }
	  @Test(priority=7)
	  public void Enter_Path_for_new_Resource() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Path(arr.get(5));
		  Thread.sleep(1000);
	  }
	  @Test(priority=8)
	  public void Enter_User_Name_for_Authentication() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.User_name_Authentication("sumer");
		  Thread.sleep(1000);
	  }
	  @Test(priority=9)
	  public void Enter_Password_for_Authentication() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Password_Authentication("test");
		  Thread.sleep(1000);
	  }
	  @Test(priority=10)
	  public void Enter_Check_Password_for_Authentication() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Password_Check_Authentication("test");
		  Thread.sleep(1000);
	  }
	  @Parameters({"DataSource","DatabaseName"})
	//  @Test(priority=11)
	  public void Enter_Access_Token_Generated_in_Inbound_settins_page(String DataSource,String DatabaseName) throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  String token = db.getQuery(DataSource,DatabaseName,"select token from api_clients where client_name='"+arr.get(0)+"'");
		  Thread.sleep(2000);
		  api_page.Access_Token(token);
		  Thread.sleep(1000);
	  }
	  @Parameters({"DataSource","DatabaseName"})
	//  @Test(priority=12)
	  public void Enter_Refresh_Token_Generated_in_Inbound_settings_page(String DataSource,String DatabaseName) throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  String api_refresh_token = db.getQuery(DataSource,DatabaseName,"select api_refresh_token from api_clients where client_name='"+arr.get(0)+"'");
		  Thread.sleep(2000);
		  api_page.Refresh_Token(api_refresh_token);
		  Thread.sleep(1000);
	  }
	  @Test(priority=13)
	  public void Save_Outbound_Settings_for_new_API_Resource() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  api_page.Save_Outbound_settings();
		  api_page.Notification();
	  }
	  @Test(priority=14)
	  public void Verify_API_Resource_in_Call_Templetes_page() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  Technical_Configration_page TC_page = new Technical_Configration_page(driver);
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);
		  TC_page.API_Call_Templetes();
		  api_page.Create_icon();
		  ct.API_Resource(arr.get(3));
		  ct.Refresh_Icon();
		  TC_page.API_Outbound_Settings();
		  Thread.sleep(1500);
		  api_page.Render_Notifications();
		  api_page.Notification();
	  }
	  @Test(priority=15)
	  public void Verify_all_mandatory_Fields_in_Outbound_settings_page() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);	
		  API_Inbound_settings_Page Inbound_api_page = PageFactory.initElements(driver, API_Inbound_settings_Page.class);
		  api_page.Create_icon();
		  api_page.Resource_name("");
		  api_page.Description("Testing Mandatory Fields");
		  api_page.Scheme_base_path("HTTP");
		  api_page.Host(arr.get(4));
		  api_page.Path(arr.get(5));
		  api_page.Save_Outbound_settings();
		  Thread.sleep(1500);
		  api_page.Notification();
		  api_page.Resource_name(arr.get(3));
		  api_page.Description("Testing Mandatory Fields");
		  api_page.Scheme_base_path("HTTP");
		  api_page.Host("");
		  api_page.Path(arr.get(5));
		  api_page.Save_Outbound_settings();
		  Thread.sleep(1500);
		  api_page.Notification();
		  api_page.Resource_name(arr.get(3));
		  api_page.Description("Testing Mandatory Fields");
		  api_page.Scheme_base_path("HTTP");
		  api_page.Host(arr.get(4));
		  api_page.Path("");
		  api_page.Save_Outbound_settings();
		  Thread.sleep(1500);
		  api_page.Notification();
		  api_page.Refresh_Icon();
		  Thread.sleep(1000);
		  api_page.Resource_name("R2-Test");
		  api_page.Description("Testing Mandatory Fields");
		  api_page.Scheme_base_path("HTTP");
		  api_page.Host("192.168.0.181");
		  api_page.Path(arr.get(5));
		  Inbound_api_page.Access_Token_Expiry("15");
		  api_page.Save_Outbound_settings();
		  api_page.Notification();
		  api_page.Notification();
	  }
	  @Test(priority=16)
	  public void Verify_Redundancy_in_Outbound_settings_page_for_APi_Resource() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);	
		  api_page.Create_icon();
		  api_page.Resource_name(arr.get(3));
		  api_page.Description("Testing redundancy");
		  api_page.Scheme_base_path("HTTP");
		  api_page.Host(arr.get(4));
		  api_page.Path(arr.get(5));
		  api_page.Save_Outbound_settings();
		  Thread.sleep(1000);
		  api_page.Notification();
		  api_page.Refresh_Icon();
	  }
	 
	  @Test(priority=17)
	  public void Update_Newly_Created_API_Resource() throws Exception  {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);	
		  api_page.List_of_API_Resources_table("api_resource_Table","R2-Test", "Testing Mandatory Fields");
		  api_page.Update_icon();
		  api_page.Resource_name("R2-Test update");
		  api_page.Description("Testing update functionality");
		  api_page.Scheme_base_path("HTTP");
		  api_page.Host("192.168.0.121");
		  api_page.Path(arr.get(5));
		  api_page.Save_Outbound_settings();
		  Thread.sleep(1000);
		  api_page.Notification();
		  api_page.Notification();
		  Thread.sleep(1000);
		  
	  }
	  
	  @Test(priority=18)
	  public void Verify_Delete_API_Resource_from_API_resource_List() throws Exception  {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_OutBound_settings_Page api_page = PageFactory.initElements(driver, API_OutBound_settings_Page.class);	
		  api_page.List_of_API_Resources_table("api_resource_Table","R2-Test update", "Testing update functionality");
		  Thread.sleep(1500);
		  api_page.Delete_icon();
		  Thread.sleep(1500);
		  api_page.Notification();
		  api_page.Notification();
		  Thread.sleep(5000);
	  }
	 
}
