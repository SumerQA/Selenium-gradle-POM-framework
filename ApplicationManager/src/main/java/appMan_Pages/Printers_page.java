package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;
public class Printers_page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Printers_page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Goto_Printers_Page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			/*HI_page.Select_Technical_Configration_Tab();
			System.out.println("Technical Configration tab is clicked");*/
			Technical_Configration_page TC_page = new Technical_Configration_page(driver);
			TC_page.Printers_Tab();
			Thread.sleep(1500);
			HI_page.Render_Notifications();
			System.out.println("Printers tab is clicked");
		    }
	 public void New_Printer_Settings_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("Create_NewUser_panal");
			System.out.println("New Printer Settings Icon is Clicked");
		    }
	 public void Change_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("Change_Existing_User");
			System.out.println("Edit button is Clicked");
		    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("delete_user");
			System.out.println("Delete button is Clicked");
			Reporter.log("Delete button is Clicked");
		    }
	 public void Printer_Name(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("P_printer_name", text);       //Printer Name
			Reporter.log(text+" : is Entered in the Printer Name field.");
		    }
	 public void Description(String text) throws IOException {	
			events eve=new events(driver);
			eve.SendKey_event("P_Description", text);
			Reporter.log(text +": is Entered in the Description Input field.");
			}
	 public void Printer_Location(String text) throws IOException {	
		    events eve=new events(driver);
			eve.SendKey_event("P_printer_Location", text);
			Reporter.log(text +": is Entered in the Printer Location input field." );
			}
	 public void Listof_Printers(String text) throws IOException {	
		    events eve=new events(driver);
			eve.Table_event(text, "P_Listof_Printers");                           //Search for printer in printers List table
		    } 
	 public void Check_Existing_Printer(String text) throws IOException {	
		    events eve=new events(driver);
			eve.CheckItem_AfterDeleting_In_Table_event(text, "P_Listof_Printers");                           //Search for printer in printers List table
		    } 
	public void Save_Printer_Settings_Changes() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("Save_Panal_Changes");
			System.out.println("Save button is clicked");
			Reporter.log("Save button is clicked");
	       }
	 public void Notification() throws IOException, InterruptedException {	
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: ---------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
	       }
	 
	 public void Refresh_Printer_Settings_Changes() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("refresh");
			System.out.println("Refreshed Printer Settings Page");
	       }
	 
}
