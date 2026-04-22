package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Configration_Files.Common;
import Event_commands.events;

public class Import_order_page {
	Common c = new Common();
	final WebDriver driver;
	public  Import_order_page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Clickon_import_order_Tab() throws IOException, InterruptedException {  
		events eve = new events(driver);
		eve.Click_event("IO_imp_order_tab");
		Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
	    }
	
	 public void Change_Icon() throws IOException, InterruptedException {    
		events ev= new events(driver);
		ev.Click_event("Change_Existing_User");
	}
	
	 public void Save_icon() throws IOException, InterruptedException { 
		 events eve = new events(driver);
		 eve.Click_event("Save_IM_changes");
	    }
	 public void Refresh_icon() throws IOException, InterruptedException { 
		 events eve = new events(driver);
		 eve.Click_event("refresh");
	    }
    
	 public void Render_Notifications() throws IOException, InterruptedException {  
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_No_button");
			}else{
				System.out.println("No notification Found");
			}
			
			}
	 public void Save_changes_Notification() throws IOException, InterruptedException {
			events eve = new events(driver);
		    if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
			       eve.GetText_event("Save_changes_notification_Message");
			       eve.Click_event("Save_changes_notification_OK_button");
		  }else{
			      System.out.println("No notification Found");
		     }
			}
	 
}
