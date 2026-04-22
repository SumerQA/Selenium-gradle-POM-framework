package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Risk_Code_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Risk_Code_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Risk_Code_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
	//	HI_page.Select_Functional_Configration_Tab();
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		//Thread.sleep(500);
		//FC_page.Click_on_tables_tab();
		//Thread.sleep(500);
		FC_page.Click_on_RiskCode_tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
	    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create Icon is Clicked");
	    }
	 public void Update_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
	    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("delete_user");
		    }
	 
	 public void Risk_Code_name(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
		    
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
		    }
	 public void Save_changes() throws IOException {	
			 events ev = new events(driver);
			 ev.Click_eventBy_ClassName("saveMain");
			    }
	 public void Reload() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
			
		    }
	 public void Reload_Create_panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_refresh");
			
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("RC_save_and_Close");
			
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save");
			
		    }
	 public void Save_as_New() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save_As_new");
			
		    }
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Cancel");
			
		    }
	 public void Notifications() throws IOException , InterruptedException{
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
