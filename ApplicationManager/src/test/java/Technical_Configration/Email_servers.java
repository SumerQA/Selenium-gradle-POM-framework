package Technical_Configration;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
import appMan_Pages.Create_User;
import appMan_Pages.Email_Servers_page;
import appMan_Pages.Home_index_Page;
import appMan_Pages.Users_Page;
@Listeners(ScreenShotOnFailure.class)
public class Email_servers {
	Common c = new Common();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_Email_Servers");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void Open_Email_servers_Page() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Home_index_Page HI_page = new Home_index_Page(driver);
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("________________________ Email Server tab_____________________________ ");
		  try {
			  ES_page.Goto_Email_Server_Page();
			  Thread.sleep(1500);
			  HI_page.Render_Notifications();
		} catch (StaleElementReferenceException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		  
		  Thread.sleep(1000);
	  }
	  @Test(priority=2)
	  public void Create_New_Email_servers() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Create Button - ");
		  ES_page.New_Email_Server_icon();
		  Thread.sleep(1000);
	  }
	  @Test(priority=3)
	  public void Select_Email_sever_from_Purpose() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Server Name - ");
		  ES_page.Purpose_Server_settings("Email server");
		  Thread.sleep(500);
	  }
	  @Test(priority=4)
	  public void Enter_Server_Name() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
	  }
	  @Test(priority=5)
	  public void Enter_Description() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Description - ");
		  ES_page.Description(arr.get(1));
		  Thread.sleep(500);
	  }
	  @Test(priority=6)
	  public void Select_Authentication_type() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter User Name - ");
		  ES_page.AuthenticationType("0");
		  Thread.sleep(500);
	  }
	  @Test(priority=7)
	  public void Enter_User_Name() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName(arr.get(2));
		  Thread.sleep(500);
	  }
	  @Test(priority=8)
	  public void Enter_password() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Password - ");
		  ES_page.Password(arr.get(3));
		  Thread.sleep(500);
	  }
	  @Test(priority=9)
	  public void Check_Password() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password(arr.get(4));
		  Thread.sleep(500);
	  }
	  @Test(priority=10)
	  public void Enter_Email_Address() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Email Address - ");
		  ES_page.Email_Address(arr.get(5));
		  Thread.sleep(500);
	  }
	  @Test(priority=11)
	  public void Enter_To_Email_Address() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Email Address - ");
		  ES_page.ToEmail_Address(arr.get(5));
		  Thread.sleep(500);
	  }
	  @Test(priority=12)
	  public void Enter_Server_Name_SMTP() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
	  }
	  @Test(priority=13)
	  public void Enter_Port_Number() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
	  }
	  @Test(priority=14)
	  public void Select_Use_Encryption() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
	  }
	  @Test(priority=15)
	  public void Clickon_Test_account_Settings_button() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Test Account Settings button- ");
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(20000);
		  ES_page.Notification();
		  Thread.sleep(3000);
		  ES_page.Notification();
	  }
	  @Test(priority=16)
	  public void Save_Email_Servers_Changes() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Save button - ");
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(7000);
		  ES_page.Notification();
		  Thread.sleep(2000);
		  ES_page.Notification();
	  }
	  @Test(priority=17)
	  public void Check_Newly_created_Serverin_EmailServer_List() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Check Newly Created Server in Email Server List.- ");
		  ES_page.Listof_EmailServers(arr.get(0));
		  System.out.println("Newly Created Server is Present in the List");
		  Thread.sleep(1000);
		  
	  }
	  @Test(priority=18)
	  public void Validate_Server_Name_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  ES_page.Listof_EmailServers(arr.get(0));
		  ES_page.Change_icon();
		  Thread.sleep(1500);
		  eve.Clear_InputField("ES_S_name");
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(500);
		  ES_page.Notification();
	  }
	  @Test(priority=19)
	  public void Validate_Description_Input_Field() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  events eve= new events(driver);
		  if(driver.findElement(By.xpath(c.getElementName("ES_description"))).isEnabled()){
			  System.out.println("Previous Changes not Saved");
		  }
		  Reporter.log("Enter Server Name - ");
		  ES_page.Server_Name(arr.get(0));
		  Thread.sleep(500);
		  eve.Clear_InputField("ES_description");
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(500);
		  ES_page.Notification();
		  if(driver.findElement(By.xpath(c.getElementName("ES_description"))).isEnabled()){
			  System.out.println("changes not saved");
			 // throw new InvalidInputException("Changes not saved for Empty field");
		  }
	  }
	  
	  @Test(priority=20)
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=21)
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=22)
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=23)
	  public void Validate_Email_Address_Input_Field() throws IOException, InterruptedException {
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=24, enabled = false)
	  public void Validate_ToEmail_Address_Input_Field() throws IOException, InterruptedException {
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
		  ES_page.Email_Address(arr.get(5));		  
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  eve.Clear_InputField("ES_ToEmail_address");
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP(arr.get(6));
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP(arr.get(7));
		  Thread.sleep(500);
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=25)
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(1500);
		  ES_page.Notification();
	  }
	  @Test(priority=26)
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
		  Reporter.log("Enter Email Address - ");
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
		  ES_page.Use_Encryption(arr.get(8));
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
	  @Test(priority=27)
	  public void Delete_Email_server_From_List() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on delete button - ");
		  ES_page.Listof_EmailServers(arr.get(0));
		  Thread.sleep(1000);
		  ES_page.Delete_icon();
		  Thread.sleep(1000);
		  ES_page.Notification();
		  Thread.sleep(500);
		  ES_page.Notification();
		  
		  
	  }
	  @Test(priority=28)
	  public void Configure_Basic_Authentication_Email_server() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Create Button - ");
		  ES_page.New_Email_Server_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Purpose_Server_settings("Email server");
		  Thread.sleep(1500);
		  ES_page.Server_Name("EmailServer");
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description("Email server created");
		  Thread.sleep(500);
		  Reporter.log("Select Authentication Type - ");
		  ES_page.AuthenticationType("0");
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName("qa.email@sdnatech.com");
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password("sdna@123");
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password("sdna@123");
		  Thread.sleep(500);
		  Reporter.log("Enter Email Address - ");
		  ES_page.Email_Address("qa.email@sdnatech.com");
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address("qa.email@sdnatech.com");
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP("smtp.gmail.com");
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP("587");
		  Thread.sleep(500);
		  ES_page.Use_Encryption("Yes");
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(500);
		  ES_page.Notification();
	  }
	 
	 // @Test(priority=29,description="Create Email server for microsoft Oauth")
	  public void Configure_Microsoft_Oauth_Email_server() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Create Button - ");
		  ES_page.New_Email_Server_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Purpose_Server_settings("Email server");
		  Thread.sleep(1500);
		  ES_page.Server_Name("EmailServer- Microsoft");
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description("Email server created for MicroSoft Oauth");
		  Thread.sleep(500);
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("2");
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
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP("587");
		  Thread.sleep(500);
		  ES_page.Use_Encryption("Yes");
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(10000);
		  ES_page.Notification();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
	  }
	  
	  //@Test(priority=30)
	  public void Configure_Google_Oauth_Email_server() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Create Button - ");
		  ES_page.New_Email_Server_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Purpose_Server_settings("Email server");
		  Thread.sleep(1500);
		  ES_page.Server_Name("Google Email Server");
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description("Email server created for Google Oauth");
		  Thread.sleep(500);
		  Reporter.log("Select Authentication Type");
		  ES_page.AuthenticationType("1");
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
		  ES_page.Server_Name_SMTP("smtp.gmail.com");
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP("587");
		  Thread.sleep(500);
		  ES_page.Use_Encryption("Yes");
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(10000);
		  ES_page.Notification();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		 
	  }
	  
	 // @Test(priority=31)
	  public void Verify_for_NON_SSL_Email_server() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Email_Servers_page ES_page = PageFactory.initElements(driver, Email_Servers_page.class);
		  Reporter.log("Click on Create Button - ");
		  ES_page.New_Email_Server_icon();
		  Reporter.log("Enter Server Name - ");
		  ES_page.Purpose_Server_settings("Email server");
		  Thread.sleep(1500);
		  ES_page.Server_Name("Non SSL Email server");
		  Thread.sleep(500);
		  Reporter.log("Enter Description - ");
		  ES_page.Description("Email server without SSL");
		  Thread.sleep(500);
		  ES_page.AuthenticationType("0");
		  Reporter.log("Enter Server User Name - ");
		  Reporter.log("Enter User Name - ");
		  ES_page.UserName("sumer.singh@sdnaglobal.com");
		  Thread.sleep(500);
		  Reporter.log("Enter Password - ");
		  ES_page.Password("sdna@123");
		  Thread.sleep(500);
		  Reporter.log("Enter Password Check - ");
		  ES_page.Check_Password("sdna@123");
		  Thread.sleep(500);
		  Reporter.log("Enter Email Address - ");
		  ES_page.Email_Address("sumer.singh@sdnaglobal.com");
		  Thread.sleep(500);
		  Reporter.log("Enter To Email Address - ");
		  ES_page.ToEmail_Address("sumer.singh@sdnaglobal.com");
		  Thread.sleep(500);
		  Reporter.log("Enter SMTP Server Name - ");
		  ES_page.Server_Name_SMTP("mail.smtp2go.com");
		  Thread.sleep(500);
		  Reporter.log("Enter Port - ");
		  ES_page.port_SMTP("2525");
		  Thread.sleep(500);
		  ES_page.Use_Encryption("No");
		  Thread.sleep(500);
		  ES_page.Test_Account_Settings_Button();
		  Thread.sleep(5000);
		  ES_page.verify_Email_sent_with_nonSSL();
		  Thread.sleep(500);
		  ES_page.Save_Email_Server_Changes();
		  Thread.sleep(3000);
		  ES_page.Notification();
		  Thread.sleep(500);
		  ES_page.Notification();
	  }
	  
	  @Test(priority=32)
	  public void Verify_Email_server_in_User_settings_tab() throws Exception{
			WebDriver driver=WebDriverManager.getDriverInstance();
			Home_index_Page OG_NU= PageFactory.initElements(driver, Home_index_Page.class);
			Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
			Users_Page U_edit= PageFactory.initElements(driver, Users_Page.class);
			Reporter.log("********Verify email server in User settings tab  ********");
			if(driver.findElement(By.xpath("//*[@id='div_API']/h2/span")).isDisplayed()){
				driver.findElement(By.xpath("//*[@id='div_API']/h2")).click();
				Thread.sleep(1500);
				OG_CU1.Notification();
			}
			OG_NU.Select_Manager_Users_Tab();
			Thread.sleep(1500);
			U_edit.Clickon_Users_Tab();
			Thread.sleep(2000);
			U_edit.Select_Usergroup_to_Link("Albert Craig A","Users_table","sort_users_table");
			Thread.sleep(1500);
			U_edit.Click_On_Change_icon();
			Thread.sleep(2000);
			OG_CU1.Enter_Initials("Mr");
			Thread.sleep(500);
			OG_CU1.Settings_tab();
			Thread.sleep(1000);
			OG_CU1.Select_requist_recipent("Email");
			OG_CU1.Check_SendEmailBYme("UseSystemReplyAddress", "Yes", "test.email@sdnatech.com","EmailServer","Basic Authentication","test.email@sdnatech.com","sdna@1234");
			Thread.sleep(1000);
			OG_CU1.Select_Save_n_Close();
			Thread.sleep(1000);
			OG_CU1.Notification();
			if(driver.findElement(By.xpath("//*[@id='div_usermanager']/h2/span")).isDisplayed()){
				driver.findElement(By.xpath("//*[@id='div_usermanager']/h2")).click();
				Thread.sleep(2000);
				OG_CU1.Notification();
			}
			OG_NU.Select_Technical_Configration_Tab();
			Thread.sleep(2000);
			System.out.println("Technical Configration tab is clicked");
			Open_Email_servers_Page();
			Reporter.log("********End of Email Server tab  ********");
		}
}
