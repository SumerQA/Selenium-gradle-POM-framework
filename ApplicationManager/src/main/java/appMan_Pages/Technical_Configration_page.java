package appMan_Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.WebDriverManager;
import Event_commands.events;
public class Technical_Configration_page {
	WebDriverManager mgr= new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;
	public  Technical_Configration_page(WebDriver driver)
	{   
		this.driver = driver;
	}
  @Test
  public void Licence_Maintenance_Tab() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_licence_Main");
	  Reporter.log("Licence Maintenance Tab is clicked");
	  
  }
   @Test
  public void Client_Settings_Tab() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_Client_settgs");
  }
  @Test
  public void Email_Servers_Tab() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_Email_servers");
  }
  @Test
  public void Printers_Tab() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_printers");
	  Reporter.log("Printers tab is Clicked");
  }
  
  @Test
  public void API_Tab() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_api_c");
	  Reporter.log("API tab is Clicked");
	  Thread.sleep(1000);
  }
  @Test
  public void API_Inbound_Settings() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_api_inbound");
	  Reporter.log("Clicked on API Inbound settings page");
  }
  @Test
  public void API_Outbound_Settings() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_api_outbound");
	  Reporter.log("Clicked on API Outbound settings page");
	  Thread.sleep(2000);
  }
  @Test
  public void API_Call_Templetes() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_api_call_temps");
	  Reporter.log("Clicked on API Call templetes page");
	  Thread.sleep(2000);
  }
  @Test
  public void Notification_Message() {
	  events eve =new events(driver);
	  eve.GetText_event("TC_Notification_Message");
  }
  @Test
  public void Save_Notification_Yes() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_Notification_Yes_button");
  }
  @Test
  public void Save_Notification_NO() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_Notification_No_button");
  }
  @Test
  public void Save_Notification_Cancel() throws InterruptedException {
	  events eve =new events(driver);
	  eve.Click_event("TC_Notification_Cancel_button");
  }
}
