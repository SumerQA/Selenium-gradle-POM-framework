package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Standard_Solutions_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Standard_Solutions_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Standard_Solutions_page() throws IOException , InterruptedException{	
		 
		 /*Home_index_Page HI_page = new Home_index_Page(driver);		
		 HI_page.Select_Functional_Configration_Tab();
		 Thread.sleep(800);*/
		 
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		
		/*FC_page.Click_Disputes_tab();
		 Thread.sleep(800);*/
		
		FC_page.Click_Standard_solutions_tab();
		Thread.sleep(500);
		Render_Notifications();
	    }
	 public void Creat_New_icon() throws IOException , InterruptedException{
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create Icon is Clicked.");
	    }
	 public void Update_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Update Icon is Clicked.");
	    }
	 public void Delete_icon() throws IOException , InterruptedException{	
			events eve = new events(driver);
			eve.Click_event("delete_user");
			Reporter.log("Delete Icon is Clicked.");
		    }
	 public void Description(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+": is Entered in the Description input field. ");
		    }
		    
	 public void code(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path,text);
		Reporter.log(text+": is Entered in the Code input field. ");
		
	    }
	 public void Refresh() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("SS_Reload");
			Reporter.log("Reload button is Clicked.");
		    }
	 public void Save() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("SS_Save");
			Reporter.log("Save button is Clicked.");
			
		    }
	 public void Save_as_new() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("SS_save_as_new");
			Reporter.log("Save as New button is Clicked.");
			
		    }
	 public void SaveAll_Changes() throws IOException , InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			Reporter.log("Save button is Clicked.");
			
		    }
	 public void Save_and_Close() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("save_close_UG_icon");
			Reporter.log("Save and Close button is Clicked.");
		    }
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("SS_Cancel");
			Reporter.log("Cancel button is Clicked.");
			
		    }
	 public void SaveChanges() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("SS_SaveChanges");
			Reporter.log("Save icon clicked.");
		    }
	 public void Notification() throws IOException , InterruptedException{
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications:-------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("---------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
	 }
	 public void Notification_Yes() throws IOException , InterruptedException{
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Yes_button"))).isDisplayed()){
				Reporter.log("Notifications:-------------------------------------");
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_Yes_button");
				Reporter.log("---------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
	 }
	 
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Link button is Clicked.");
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Unlink button is Clicked.");
		    }
	 public void Render_Notifications() throws IOException, InterruptedException {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				Reporter.log("Notificatio: ----------------------------------------");
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_No_button");
				Reporter.log("-----------------------------------------------------");
				Thread.sleep(2000);
			}
		    }
	}
