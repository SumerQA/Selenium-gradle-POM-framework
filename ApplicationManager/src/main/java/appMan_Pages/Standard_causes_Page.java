package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Standard_causes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Standard_causes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Standard_Causes_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*HI_page.Select_Functional_Configration_Tab();*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		//FC_page.Click_Disputes_tab();
		FC_page.Click_Standard_Causes_tab();
		Thread.sleep(500);
		HI_page.Render_Notifications();
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
			Reporter.log(text+ " : is entered in the description input field");
		    }
		    
	 public void code(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path,text);
		Reporter.log(text+ " : is entered in the Code input field");
	    }
	 public void Refresh() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_refresh");
			Reporter.log("Reload Icon is Clicked.");
		    }
	 public void Reload() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Reload Icon is Clicked.");
		    }
	 public void Save() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_Save");
			Reporter.log("Save Icon is Clicked.");
			
		    }
	 public void Save_sa_New() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_Save_As_new");
			Reporter.log("Save Icon is Clicked.");
			
		    }
	 public void SaveAll_Changes() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			Reporter.log("Save Icon is Clicked.");
			
		    }
	 public void Save_and_Close() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("PS_Save_and_Close")));
			eve.Click_event_javaScript(Ele);
			Reporter.log("Save and Close Icon is Clicked.");
			
		    }
	 public void Cancel() throws IOException , InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Cancel");
			Reporter.log("Cancel Icon is Clicked.");
			
		    }
	 public void Notification() throws IOException , InterruptedException{
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: ------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("---------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		    }

public void No_Notification() throws IOException , InterruptedException{
 events eve = new events(driver);
	if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
		Reporter.log("Notifications: ------------------------------");
		eve.GetText_event("Save_changes_notification_Message");
		eve.Click_event("Save_changes_notification_NO_button");
		Reporter.log("---------------------------------------------");
	}else{
		System.out.println("No notification Found");
	}
    }
	 
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
			Reporter.log("link button is Clicked.");
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Unlink button is Clicked.");
		    }
	}
