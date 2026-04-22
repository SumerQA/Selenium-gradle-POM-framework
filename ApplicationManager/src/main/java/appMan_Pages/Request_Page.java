package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Request_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Request_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Requests_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			/*HI_page.Select_Functional_Configration_Tab();
			Thread.sleep(800);*/
			Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
			FC_page.Request_tab();
			Thread.sleep(2000);
			HI_page.Render_Notifications();
		    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Create_NewUser_panal");
			Reporter.log("Create Icon is Clicked.");
		    }
	 public void Update_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("Change_Existing_User");
			Reporter.log("Update Icon is Clicked.");
		    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("delete_user");
			Reporter.log("Delete Icon is Clicked.");
		    }
	                                                             //Create Currency
	 public void Request_Name(String path , String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the request name input field.");
		    }
		    
	 public void Request_Name_Clear(String path) throws IOException {                           
			events eve = new events(driver);
			eve.Clear_InputField(path);
		    }
	 public void Request_type(String rTypepath, String rTtext,String saTpath, String saTtext) throws IOException {
		 events eve = new events(driver);
		 if(rTtext.trim().equals("1")){
			 eve.DropDown_list_event(rTypepath, rTtext); 
			 eve.DropDown_list_event(saTpath, saTtext);
		 }else{
			 eve.DropDown_list_event(rTypepath, rTtext); 
		 }
			
	        }
	 public void Description (String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Description input field.");
		    }
	 public void Monitoring (String text) throws IOException {
			events eve = new events(driver);
			eve.Checkbox("RE_monitoring",text);
			
		    }
	 public void Period(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text +" : is Entered in the Period input field.");
			
		    }
	 public void Period_Clear(String path) throws IOException {
			events eve = new events(driver);
			eve.Clear_InputField(path);
			
		    }
	 public void Template (String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
	 public void Standard_action_taker(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
	 } 
	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("RE_Refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("RE_Save");
			Reporter.log("Save button is Clicked.");
		    }
	 public void Save_panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("saveMain");
			Reporter.log("Save button is Clicked.");
			
		    }
	 public void Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("RE_cancel");
			Reporter.log("Cancel button is Clicked.");
			
		    }
	 public void Save_as_New() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("RE_Save_as_New")));
			eve.Click_event_javaScript(Ele);
			Reporter.log("Save as New button is Clicked.");
			
		    }
	 public void Save_and_Close() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("RE_Save_and_Close")));
			eve.Click_event_javaScript(Ele);
			Reporter.log("Save and Close button is Clicked.");
			
		    }
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification-----------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("-----------------------------------------------------");
			}
	 }
	 public void link() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Link");
			Reporter.log("Link Icon is Clicked.");
		    }
	 public void Unlink() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Unlink");
			Reporter.log("Unlink Icon is Clicked.");
		    }
	}
