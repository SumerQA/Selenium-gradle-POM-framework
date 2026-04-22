package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;
public class Request_Server_Settings_page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Request_Server_Settings_page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Clickon_Create_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("Create_NewUser_panal");
			System.out.println("Create icon is Clicked");
			Reporter.log("Create icon is Clicked");
	    }
	 public void Purpose_Server_settings(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.DropDown_list("ES_purpose", text);
			System.out.println("Create Icon is Clicked");
		    }
	 
	 public void Clickon_Change_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("Change_Existing_User");
			System.out.println("Change button is Clicked");
			Reporter.log("Change button is Clicked");
	    }
	 public void Clickon_Delete_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("D_arole_icon");
			System.out.println("Delete button is Clicked");
			Reporter.log("Delete button is Clicked");
	    }
	 
	 public void Name(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_name",text);
			System.out.println(text+" is entered in Name field");
		    } 
	 
	 public void Description(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_desc",text);
			System.out.println(text+" is entered in Description field");
		    } 
	 public void WebService_URL(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_WebServices_URL", text);
			System.out.println("Web Service URL is entered");
			Reporter.log(text+ ": is Entered in the Web Service URL Input field.");
	       }
	 public void polling_interval(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_Req_Poll_interval",text);
			System.out.println(text+" is entered in Polling Interval field");
		    }
	 
	 public void Server_UserName(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_Uname",text);
			System.out.println(text+" is entered in UserName field");
		    }
	 public void Server_Password(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_pass",text);
			System.out.println(text+" is entered in Password field");
		    }
	 public void Server_Password_Check(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_PassCheck",text);
			System.out.println(text+" is entered in Password Check field");
		    }
	 public void Email_Address(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_Email_Adderss",text);
			System.out.println("Email From Address is Entered");
			Reporter.log(text+ ": is Entered in the Email FROM Address Input field.");
		   }
	 public void toEmail_Address(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_toEmail_Address",text);
			System.out.println("Email TO Address is Entered");
			Reporter.log(text+ ": is Entered in the Email To Address Input field.");
		   }
	 	
	 public void SMTP_Server_Name(String text) throws IOException {	
		events eve=new events(driver);
		eve.SendKey_event("RSS_SMTP_Server_name", text);
		Reporter.log(text + ": is Entered in the SMTP Server name field.");
      }
	 public void SMTP_Port(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("RSS_SMTP_port", text);
			Reporter.log(text +" : is Entered in the SMTP Port input field.");
	    }
	 
	 public void IMAP_Server_Name(String text) throws IOException {	
		events eve=new events(driver);
		eve.SendKey_event("RSS_IMAP_Server_name", text);
		Reporter.log(text + ": is Entered in the IMAP Server Name field.");
     }
	
	public void IMAP_Port(String text) throws IOException {	
		events eve=new events(driver);
		eve.SendKey_event("RSS_IMAP_port", text);
		Reporter.log(text + ": is Entered in the IMAP Port Input field.");
    }
	public void Use_Encryption(String text) throws IOException {	
		events eve=new events(driver);
		eve.Check_box_JS("useEncryption", text);
	//	eve.Checkbox("RSS_SSl_checkbox",text);
    }
	public void Mark_actionAs_Completed(String text) throws IOException {	
		events eve=new events(driver);
		eve.Check_box_JS("MarkActionAsCompleted", text);
	//	eve.Checkbox("RSS_SSl_checkbox",text);
    }
	public void TestMailSettins_button() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("RSS_TestMailSettins_button");
		System.out.println("Test MailSettings button is clicked");
		Reporter.log("Test MailSettings button is clicked");
    }
	
	 public void Save_Req_Server_Settings_Changes() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("Save_Panal_Changes");
			System.out.println("Save button is Clicked");
			Reporter.log("Save button is Clicked");
	       }
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: ------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("---------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
	 }
	 public void Refresh_Licence_Changes() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("refresh");
      }
	 public void Email_server_list(String text) throws IOException {	
			events eve=new events(driver);
			eve.Table_event(text, "RSS_Email_serverList_table");	
	    }
}
