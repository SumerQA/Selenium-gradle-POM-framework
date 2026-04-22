package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Secure_Smart_Email_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Secure_Smart_Email_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Secure_smart_email() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		//HI_page.Select_Functional_Configration_Tab();
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Secure_Smart_Email_tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
	    }
	 public void Change_icon() throws IOException , InterruptedException{
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Create Icon is clicked.");
	    }
	 public void Database_ID(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Database ID input filed.");
			}
	 public void SSE_Website_URL(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the SSE web site URL input filed.");
		    }
	 public void Numberof_days_ValidforSSE(String path,String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Number of days valid for SSE input filed.");
		    }
	 public void URL_to_SSE_website_logo(String path,String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the URL to SSE web site logo input filed.");
		    }
	 public void Web_site_welcome_text(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Web site welcome text input filed.");
		    }
		    
	 public void Subjectline_CopyInvoice_email(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Subject line Copy-Invoice e-mail input filed.");
			
		    }
	 public void Max_numof_days_committed_payment(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Maximum number of days committed payment input filed.");
			
	 }
	 public void Number_of_days_monitoring(String path,String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Number of days monitoring input filed.");
			}
	 public void Templetes_Tab(String path) throws IOException , InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
		    }
	 public void Block_invoices_on_committed_payment(String text) throws IOException {
		 events ev = new events(driver);
		 ev.Check_box_JS("blockInvoices", text);
		    }
	
	 public void Refresh() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Save() throws IOException , InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_Panal_Changes");
			Reporter.log("Save button is Clicked.");
			
		    }
	
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications:------------------------------->");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("--------------------------------------------->");
			}else{
				System.out.println("No notification Found");
			}
		    }
	
	}
