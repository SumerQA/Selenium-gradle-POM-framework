package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class System_notes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  System_notes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_system_notes() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*HI_page.Select_Functional_Configration_Tab();*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		//FC_page.Click_on_tables_tab();
		FC_page.Click_on_System_Notes_tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
	    }
	 public void Change_icon() throws IOException , InterruptedException{	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Change Icon is Clicked");
	    }
	 public void make_all_system_notes_visible(String path, String text) throws IOException , InterruptedException{	
		 if(text.equals("yes")){
			 events eve = new events(driver);
				eve.Click_event(path);
				System.out.println("Make all system notes Visible Option is Clicked");
		 }
		    }
	 public void make_all_system_notes_Invisible(String path, String text) throws IOException , InterruptedException{	
		 if(text.equals("yes")){
				events eve = new events(driver);
				eve.Click_event(path);
				System.out.println("Make all system notes Invisible Option is Clicked");
		 }
		    }
	 
	 public void Checkbox(String id, String text) throws IOException {  
			 events eve = new events(driver);
			 eve.Check_box_JS(id, text);
		    }
	 public void Save_changes() throws IOException {	
			 events ev = new events(driver);
			 ev.Click_eventBy_ClassName("saveMain");
			 Reporter.log("Save button is Clicked.");
			    }
	 public void Reload() throws IOException, InterruptedException {	
		 events ev = new events(driver);
		// ev.Click_eventBy_ClassName("refresh");
		 ev.Click_event("SN_reload_Button");
		 Reporter.log("Reload button is Clicked.");
		    }
	 public void Notifications() throws IOException, InterruptedException {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: --------------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("-----------------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		    }
	}
