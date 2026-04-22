package Technical_Configration;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import appMan_Pages.Email_Servers_page;
import appMan_Pages.Request_Server_Settings_page;
@Listeners(ScreenShotOnFailure.class)
public class EmailtoOnguard_settings {
	Common c= new Common();
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_EmailToOnguard");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void EmailtoOnguard_Create_icon() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("________________________ Email to Onguard server settings Page_____________________________ ");
		  RSS_page.Clickon_Create_icon();
		  Thread.sleep(1000);
		  RSS_page.Purpose_Server_settings("Email to Onguard");
	  }
	  @Test(priority=2)
	  public void Select_EmailtoOnguard_from_Purpose() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Select Email to Onguard from ddlist");
		  RSS_page.Purpose_Server_settings("Email to Onguard");
		  Thread.sleep(2000);
	  }
	  @Test(priority=3)
	  public void Enter_EmailtoOnguatd_server_name() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Server name");
		  RSS_page.Name(arr.get(0));
	  }
	  @Test(priority=4)
	  public void Enter_EmailtoOnguatd_server_Description() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter server Description");
		  RSS_page.Description(arr.get(1));
	  }
	  	  
	  @Test(priority=5)
	  public void Enter_polling_interval() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter polling interval - ");
		  RSS_page.polling_interval(arr.get(2));
	  }
	  @Test(priority=6)
	  public void Enter_EmailtoOnguatd_server_UserName() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Server_UserName(arr.get(3));
	  }
	  @Test(priority=7)
	  public void Enter_EmailtoOnguatd_server_Password() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Password - ");
		  RSS_page.Server_Password(arr.get(4));
	  }
	  @Test(priority=8)
	  public void Enter_EmailtoOnguatd_server_Password_check() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Password check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
	  }
	  @Test(priority=9)
	  public void Enter_EmailtoOnguatd_server_EmailaddressFrom() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email address - ");
		  RSS_page.Email_Address(arr.get(6));
	  }
	  
	  @Test(priority=10)
	  public void Enter_IMAPServer_Name() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter IMAP Server Name - ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
	  }
	 	  
	  @Test(priority=11)
	  public void Enter_IMAP_port() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter IMAP Port - ");
		  RSS_page.IMAP_Port(arr.get(8));
	  }
	  @Test(priority=12)
	  public void Check_Use_Encryption_Checkbox() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Check SSl Checkbox -");
		  RSS_page.Use_Encryption(arr.get(9));
	  }
	  @Test(priority=13)
	  public void Check_Mark_actionAsCompleted_Checkbox() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
	  }
	  
	  @Test(priority=14)
	  public void Save_Changes() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Save All Changes -  ");
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  }
	  @Test(priority=15)
	  public void Validate_EmailtoOnguard_Settings_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Email_server_list(arr.get(0));
		  Thread.sleep(1000);
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(500);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name(arr.get(0)+"New");
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=17)
	  public void Validate_Name_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Create_icon();
		  Thread.sleep(1000);
		  RSS_page.Purpose_Server_settings("Email to Onguard");
		  Thread.sleep(1000);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name("");
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=18)
	  public void Validate_Polling_Interval_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval("");
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=19)
	  public void Validate_EmailtoOnguard_Server_Username_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName("");
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=20)
	  public void Validate_Server_Password_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password("");
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  
	  @Test(priority=21)
	  public void Validate_Server_PasswordCheck_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check("");
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  } 
	  @Test(priority=22)
	  public void Validate_Server_EmailAddress_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address("");
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  
	  @Test(priority=23)
	  public void Validate_IMAP_Servername_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to onguard name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name("");
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=24)
	  public void Validate_IMAP_Port_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email to onguard Name");
		  RSS_page.Name(arr.get(1));
		  Reporter.log("Enter Email Address - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port("");
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  
	  @Test(priority=25,enabled = true)
	  public void SetUp_Basic_EmailToOnguard_server_settings_Configration() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page= PageFactory.initElements(driver, Email_Servers_page.class);
		  RSS_page.Clickon_Create_icon();
		  Thread.sleep(1000);
		  RSS_page.Purpose_Server_settings("Email to Onguard");
		  Reporter.log("Enter Email to onguard Name");
		  RSS_page.Name(arr.get(0)+"New1");
		  Reporter.log("Enter DEscription - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Select Authentication Type ");
		  ES_page.AuthenticationType("0");// 0- for basic auth type
		  Thread.sleep(500);
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(3));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(4));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(5));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(6));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	 // @Test(priority=26)
	  public void SetUp_Google_EmailToOnguardt_server_settings_Configration() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page= PageFactory.initElements(driver, Email_Servers_page.class);
		  RSS_page.Clickon_Create_icon();
		  Thread.sleep(1000);
		  RSS_page.Purpose_Server_settings("Email to Onguard");
		  Reporter.log("Enter Email to onguard Name");
		  RSS_page.Name(arr.get(0)+" Google");
		  Reporter.log("Enter Description - ");
		  RSS_page.Description("Email to Onguard server settings for Google");
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Select Authentication Type - ");
		  ES_page.AuthenticationType("1");
		  Reporter.log("Enter Private Key - ");
		  ES_page.Private_Key_or_ClientSecret(arr.get(15).substring(1, (arr.get(15)).length() - 1));
		  Reporter.log("Enter Service Account - ");
		  ES_page.Service_Account_or_AppID(arr.get(16));		  
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(17));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(18));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(18));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(17));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(7));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	 // @Test(priority=27)
	  public void SetUp_Microsoft_EmailToOnguardt_server_settings_Configration() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page= PageFactory.initElements(driver, Email_Servers_page.class);
		  RSS_page.Clickon_Create_icon();
		  Thread.sleep(1000);
		  RSS_page.Purpose_Server_settings("Email to Onguard");
		  Reporter.log("Enter Email to onguard Name");
		  RSS_page.Name(arr.get(0)+" for MicroSoft");
		  Reporter.log("Enter DEscription - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(2));
		  Reporter.log("Select Authentication Type ");
		  ES_page.AuthenticationType("1");
		  Reporter.log("Enter Client Secret - ");
		  ES_page.Private_Key_or_ClientSecret(arr.get(11));
		  Reporter.log("Enter App ID - ");
		  ES_page.Service_Account_or_AppID(arr.get(12));
		  Reporter.log("Enter Tanent ID - ");
		  ES_page.Tanent_Id(arr.get(13));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(14));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(11));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(11));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(14));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name("outlook.office365.com");
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(8));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(9));
		  Reporter.log("Check Mark Action as completed Checkbox -");
		  RSS_page.Mark_actionAs_Completed(arr.get(10));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=28)
	  public void Delete_EmailtoOnguard_server() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  RSS_page.Email_server_list(arr.get(0)+"New1");
		  RSS_page.Clickon_Delete_icon();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
	  }  
}
