package Technical_Configration;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
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
import Event_commands.events;
import appMan_Pages.Email_Servers_page;
import appMan_Pages.Home_index_Page;
@Listeners(ScreenShotOnFailure.class)
public class Report_servers {
	Common c = new Common();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_Report_Server");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	  @Test(priority=1)
	  public void Create_New_Report_servers() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Home_index_Page HI_page = new Home_index_Page(driver);
		  Reporter.log("Open report server - ");
		  ES_page.Listof_EmailServers("Report server");
		  Thread.sleep(1500);
		  HI_page.Render_Notifications();
		  ES_page.Change_icon();
		  Reporter.log("Enter Server Name - ");
		  Thread.sleep(1000);
	  }
	  @Test(priority=2, enabled =false)
	  public void Select_Report_server_fromOption() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Server Name - ");
		  ES_page.Purpose_Server_settings("Report server");
		  Thread.sleep(500);
	  }
	  @Test(priority=3)
	  public void Select_AutheticationType() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Server Name - ");
		  ES_page.AuthenticationType("0");
		  Thread.sleep(500);
	  }
	  @Test(priority=4)
	  public void Enter_Report_Server_Name() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
	  }
	  @Test(priority=5)
	  public void Enter_Report_server_Description() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
	  }
	  @Test(priority=6)
	  public void Enter_Report_server_User_Name() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
	  }
	  @Test(priority=7)
	  public void Enter_Report_server_Email_AddressFrom() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Email From Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
	  }
	  
	  @Test(priority=8)
	  public void Enter_Report_server_password() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
	  }
	  @Test(priority=9)
	  public void Report_server_Check_Password() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
	  }
	  @Test(priority=10)
	  public void Enter_Report_server_Email_AddressTo() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
	  }
	  @Test(priority=11)
	  public void Enter_Report_Server_Name_SMTP() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
	  }
	  @Test(priority=12)
	  public void EnterReport_server_SMTP_Port() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
	  }
	  @Test(priority=13)
	  public void Select_Authentication_Mode() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
	  }
	  @Test(priority=14)
	  public void Clickon_Test_account_Settings_button() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Test Account Settings button- ");
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(7000);
		  ES_page.Notification();
	  }
	  @Test(priority=15)
	  public void Save_Report_Servers_Changes() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Save button - ");
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(5000);
		  ES_page.Notification();
		  Thread.sleep(2000);
		  ES_page.Notification();
	  }
	  @Test(priority=16)
	  public void Check_Newly_created_Serverin_EmailServer_List() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Check Newly Created Server in Email Server List.- ");
		  ES_page.Listof_EmailServers(arr.get(0));
		  Thread.sleep(500);
		  
	  }
	  @Test(priority=17)
	  public void Validate_Report_Server_Name_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Thread.sleep(500);
		  ES_page.Change_icon();
		  Thread.sleep(500);
		  ES_page.Server_Name("");
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode("None");
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(500);
		  ES_page.Notification();
	  }
	  	  
	  @Test(priority=18)
	  public void Validate_User_Name_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_UName"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }else{
			  ES_page.Listof_EmailServers(arr.get(0));
			  Thread.sleep(1000);
			  ES_page.Change_icon();
			  Thread.sleep(1500);
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_UName");
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode("Logon");
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=19)
	  public void Validate_Password_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_PWD"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_PWD");
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=20)
	  public void Validate_Confirm_Password_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_Check_PWD"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_Check_PWD");
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=21)
	  public void Validate_Email_Address_From_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_Email_address"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_Email_address");
		  Thread.sleep(500);		  
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);		  
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=21,enabled = false)
	  public void Validate_Email_Address_To_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_Email_address"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));		  
		  Thread.sleep(500);		  
		  Reporter.log("Clear To Email Address - ");
		  eve.Clear_InputField("ES_ToEmail_address");
		  Thread.sleep(500);		  
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=22)
	  public void Validate_SMTP_Server_Name_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_SMTP_Server_Name"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_SMTP_Server_Name");
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=23)
	  public void Validate_SMTP_Port_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_SMPT_Port"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_SMPT_Port");
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1000);
		  ES_page.Notification();
	  }
	  @Test(priority=24)
	  public void Setup_Basic_SMTP_settings_for_ReportServer() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  ES_page.Listof_EmailServers("Report server");
		  Thread.sleep(1500);
		  ES_page.Change_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
		  Reporter.log("Enter From Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(7000);
		  ES_page.Notification();
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		 
	  }
	  @Test(priority=24)
	  public void Setup_Google_SMTP_settings_for_ReportServer() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  ES_page.Listof_EmailServers("Report server");
		  Thread.sleep(1500);
		  ES_page.Change_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description----- ");
		  ES_page.Description("Report server created for Google account");
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("Google Oauth ");
		  Reporter.log("Enter Private Key");
		  ES_page.Private_Key_or_ClientSecret(arr.get(13).substring(1, (arr.get(13)).length() - 1));
		  Thread.sleep(500);
		  Reporter.log("Enter Service Account");
		  ES_page.Service_Account_or_AppID(arr.get(14));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(15));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(16));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(16));
		  Thread.sleep(500);
		  Reporter.log("Enter Email Address - ");
		  ES_page.Email_Address(arr.get(15));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(7000);
		  ES_page.Notification();
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		 
	  }
	//  @Test(priority=25)
	  public void Setup_Microsoft_SMTP_settings_for_ReportServer() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  ES_page.Listof_EmailServers("Report server");
		  Thread.sleep(1500);
		  ES_page.Change_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description("Report server created for MicroSoft account");
		  Thread.sleep(500);
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("Microsoft Oauth ");
		  Reporter.log("Enter Client Secret - ");
		  ES_page.Private_Key_or_ClientSecret(arr.get(9));
		  Thread.sleep(500);
		  Reporter.log("Enter App ID ");
		  ES_page.Service_Account_or_AppID(arr.get(10));
		  Thread.sleep(500);
		  Reporter.log("Enter Tanent ID ");
		  ES_page.Tanent_Id(arr.get(11));
		  Thread.sleep(500);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(12));
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(9));
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(9));
		  Thread.sleep(500);
		  Reporter.log("Enter Email Address - ");
		  ES_page.Email_Address(arr.get(12));
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP("smtp.office365.com");
		  Thread.sleep(500);
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Authentication_mode(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(7000);
		  ES_page.Notification();
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		 
	  }
	  
}
