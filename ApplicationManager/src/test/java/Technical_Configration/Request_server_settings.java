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
public class Request_server_settings {
	Common c= new Common();
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_Req_Server_settings");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void Select_Request_server_Enail_Setting() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("________________________ Request server settings Page_____________________________ ");
		  RSS_page.Email_server_list("Request server");
		  Thread.sleep(2000);
	  }
	  @Test(priority=2)
	  public void Clickon_Change_Icon() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(2000);
	  }
	  @Test(priority=3)
	  public void Enter_Request_server_name() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter request server name");
		  RSS_page.Name(arr.get(0));
	  }
	  @Test(priority=4)
	  public void Enter_Request_server_Descripotion() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Description(arr.get(1));
	  }
	  @Test(priority=5)
	  public void Enter_WebService_URL() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
	  }
	  
	  @Test(priority=6)
	  public void Enter_polling_interval() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Web service interval - ");
		  RSS_page.polling_interval(arr.get(3));
	  }
	  @Test(priority=7)
	  public void Select_Autheticationtype() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);;
		  Reporter.log("Select Authentication type - ");
		  ES_page.AuthenticationType("0");
	  }
	  @Test(priority=8)
	  public void Enter_Request_server_UserName() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email Address in Username- ");
		  RSS_page.Server_UserName(arr.get(4));
	  }
	  @Test(priority=9)
	  public void Enter_Request_server_EmailaddressFrom() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email FROM address - ");
		  RSS_page.Email_Address(arr.get(7));
	  }
	  @Test(priority=10)
	  public void Enter_Request_server_Password() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email Address Password - ");
		  RSS_page.Server_Password(arr.get(5));
	  }
	  @Test(priority=11)
	  public void Enter_Request_server_Password_check() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email Address Confirm password- ");
		  RSS_page.Server_Password_Check(arr.get(6));
	  }
	  @Test(priority=12)
	  public void Enter_Request_server_EmailaddressTo() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter Email To address - ");
		  RSS_page.toEmail_Address(arr.get(7));
	  }
	  @Test(priority=13)
	  public void Enter_SMTP_ServerName() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter SMTP Server Name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
	  }
	  @Test(priority=14)
	  public void Enter_SMTP_Port() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
	  }
	  @Test(priority=15)
	  public void Enter_IMAPServer_Name() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter IMAP Server Name - ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
	  }
	 	  
	  @Test(priority=16)
	  public void Enter_IMAP_port() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter IMAP Port - ");
		  RSS_page.IMAP_Port(arr.get(11));
	  }
	  @Test(priority=17)
	  public void Check_Use_Encryption_Checkbox() throws IOException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Check SSl Checkbox -");
		  RSS_page.Use_Encryption(arr.get(12));
	  }
	  @Test(priority=18)
	  public void Clickon_TestMailSettings_button() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Click on Test mailSettings Button -  ");
		  RSS_page.TestMailSettins_button();
		  Thread.sleep(8000);
		  RSS_page.Notification();
	  }
	  @Test(priority=19)
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
	  @Test(priority=20)
	  public void Validate_Request_server_Settings_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(2000);
		  RSS_page.Email_server_list("Request server");
		  Thread.sleep(1000);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(1500);
		  Reporter.log("Enter Service name");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter email From address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter email To address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  Thread.sleep(1500);
	  }
	  @Test(priority=21)
	  public void Validate_Name_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  RSS_page.Email_server_list("Request server");
		  Thread.sleep(1500);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(1500);
		  Reporter.log("Testing name field for mandatory check-");
		  RSS_page.Name("");
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email from address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=22)
	  public void Validate_Server_Username_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Testing Username field for mandatory check-e - ");
		  RSS_page.Server_UserName("");
		  Reporter.log("Enter Email From address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=23)
	  public void Validate_Server_Password_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request Service name");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email from Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Testing Password field for mandatory check- - ");
		  RSS_page.Server_Password("");
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  
	  @Test(priority=24)
	  public void Validate_Server_PasswordCheck_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email from Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Testing Confirm password field for mandatory check - ");
		  RSS_page.Server_Password_Check("");
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  } 
	  @Test(priority=25)
	  public void Validate_Server_EmailFromAddress_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Testing Email From Address field for mandatory check - ");
		  RSS_page.Email_Address("");
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));		  
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=26)
	  public void Validate_Server_EmailToAddress_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("make it Blank - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));		  
		  Reporter.log("Testing Email To Address field for mandatory check - ");
		  RSS_page.toEmail_Address("");
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=27)
	  public void Validate_SMTP_Servername_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email From Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Testing SMTP Server Name field for mandatory check - ");
		  RSS_page.SMTP_Server_Name("");
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=28)
	  public void Validate_SMTP_Port_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email From Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Testing SMTP port field for mandatory check ");
		  RSS_page.SMTP_Port("");
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=29)
	  public void Validate_IMAP_Servername_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email From Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Testing IMAP Server name field for mandatory check- ");
		  RSS_page.IMAP_Server_Name("");
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  @Test(priority=30)
	  public void Validate_IMAP_Port_mandatory_Fields() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Thread.sleep(1500);
		  Reporter.log("Enter request processing interval");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email From Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Testing IMAP Port field for mandatory check-- ");
		  RSS_page.IMAP_Port("");
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();
		  
	  }
	  
	  @Test(priority=31)
	  public void SetUp_Basic_Request_server_settings_Configration() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
			/*
			 * Thread.sleep(1500); RSS_page.Email_server_list("Request server");
			 * Thread.sleep(1000); Reporter.log("Click on Change Icon -");
			 * RSS_page.Clickon_Change_icon();
			 */
		  Thread.sleep(1500);
		  Reporter.log("Enter Service name");
		  RSS_page.Name(arr.get(0)+" Valid");
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));		
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("0");
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email From Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();  
		  
	  }
	 // @Test(priority=32)
	  public void SetUp_Microsoft_Request_server_settings_Configration() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Thread.sleep(1500);
		  RSS_page.Email_server_list("Request server");
		  Thread.sleep(1000);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(1500);
		  Reporter.log("Enter Service name");
		  RSS_page.Name(arr.get(0)+"  for Microsoft");
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));		 
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("3");
		  Reporter.log("Enter Client Secret - ");
		  ES_page.Private_Key_or_ClientSecret(arr.get(13));
		  Thread.sleep(500);
		  Reporter.log("Enter App ID ");
		  ES_page.Service_Account_or_AppID(arr.get(14));
		  Thread.sleep(500);
		  Reporter.log("Enter Tanent ID ");
		  ES_page.Tanent_Id(arr.get(15));
		  Thread.sleep(500);
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(16));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(13));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(13));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(16));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name("smtp.office365.com");
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name("imap.office365.com");
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  Reporter.log("Click on Test mailSettings Button -  ");
		  RSS_page.TestMailSettins_button();
		  Thread.sleep(8000);
		  RSS_page.Notification();
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();;
		  
	  }
	  //@Test(priority=33)
	  public void SetUp_Google_Request_server_settings_Configration() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Thread.sleep(1500);
		  RSS_page.Email_server_list("Request server");
		  Thread.sleep(1000);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(1500);
		  Reporter.log("Enter Service name");
		  RSS_page.Name(arr.get(0)+" for Google");
		  Reporter.log("Enter Description ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("2");
		  Reporter.log("Enter Private Key");
		  ES_page.Private_Key_or_ClientSecret(arr.get(17).substring(1, (arr.get(17)).length() - 1));
		  Thread.sleep(500);
		  Reporter.log("Enter Service Account");
		  ES_page.Service_Account_or_AppID(arr.get(18));
		  Thread.sleep(500);
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(19));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(20));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(20));
		  Reporter.log("Enter Server email server - ");
		  RSS_page.Email_Address(arr.get(19));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  Reporter.log("Click on Test mailSettings Button -  ");
		  RSS_page.TestMailSettins_button();
		  Thread.sleep(8000);
		  RSS_page.Notification();
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();;
		  
	  }
	  
	  
	  @Test(priority=34)
	  public void Test_Server_Account_Settings() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Request_Server_Settings_page RSS_page= PageFactory.initElements(driver, Request_Server_Settings_page.class);
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  RSS_page.Email_server_list("Request server");
		  Thread.sleep(1000);
		  Reporter.log("Click on Change Icon -");
		  RSS_page.Clickon_Change_icon();
		  Thread.sleep(1500);
		  Reporter.log("Enter Service Name");
		  RSS_page.Name(arr.get(0));
		  Reporter.log("Enter Description - ");
		  RSS_page.Description(arr.get(1));
		  Reporter.log("Enter Web service URL - ");
		  RSS_page.WebService_URL(arr.get(2));
		  Reporter.log("Enter Polling Interval - ");
		  RSS_page.polling_interval(arr.get(3));
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("0");
		  Reporter.log("Enter Server User Name - ");
		  RSS_page.Server_UserName(arr.get(4));
		  Reporter.log("Enter Email From Address - ");
		  RSS_page.Email_Address(arr.get(7));
		  Reporter.log("Enter Server Password - ");
		  RSS_page.Server_Password(arr.get(5));
		  Reporter.log("Enter Server Password Check - ");
		  RSS_page.Server_Password_Check(arr.get(6));
		  Reporter.log("Enter Email To Address - ");
		  RSS_page.toEmail_Address(arr.get(7));
		  Reporter.log("Enter SMTP server name - ");
		  RSS_page.SMTP_Server_Name(arr.get(8));
		  Reporter.log("Enter SMTP Port - ");
		  RSS_page.SMTP_Port(arr.get(9));
		  Reporter.log("Enter IMAP server name- ");
		  RSS_page.IMAP_Server_Name(arr.get(10));
		  Reporter.log("Enter IMAP port- ");
		  RSS_page.IMAP_Port(arr.get(11));
		  Reporter.log("Check Use encryption chechboxt- ");
		  RSS_page.Use_Encryption(arr.get(12));
		  RSS_page.TestMailSettins_button();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  RSS_page.Save_Req_Server_Settings_Changes();
		  Thread.sleep(2000);
		  RSS_page.Notification();
		  Thread.sleep(500);
		  RSS_page.Notification();;
		  
	  }
	  
}
