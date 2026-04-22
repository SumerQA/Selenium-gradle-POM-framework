package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Event_commands.events;
public class Home_index_Page {
	Common c = new Common();	 
	final WebDriver driver;
	//WebDriverManager mgr = new WebDriverManager();
	public  Home_index_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	@Test
	 public void Select_Manager_Users_Tab() throws IOException, InterruptedException {	
		driver.findElement(By.xpath(c.getElementName("user_Manager_tab"))).click();
		Thread.sleep(1000);
	    System.out.println("Users Manager tab is Selected-------"); 
	    Reporter.log("Users Manager tab is Selected-------");
	    Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
	    }
	@Test
	 public void Select_Import_Manager_Tab() throws IOException, InterruptedException {	
		driver.findElement(By.xpath(c.getElementName("ImportManager_Tab"))).click();
	    System.out.println("Import Manager tab is Selected-------");
	    Reporter.log("Import Manager tab is Selected-------");
	    Thread.sleep(1500);
	    }
	@Test
	 public void Select_Functional_Configration_Tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("FunctionalConfigration_Tab"))).click();
	    System.out.println("Functional Configration tab is Selected-------");  
	    Reporter.log("Functional Configration tab is Selected-------");
	    }
	@Test
	 public void Select_Technical_Configration_Tab() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("TechnicalConfigration_Tab");
	    System.out.println("Technical Configration Tab is Selected-------"); 
	    Reporter.log("Technical Configration Tab is Selected-------");
	    }
	@Test
	public void UserManager_Index() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("user_manager_index");
	   }
	@Test
	public void Import_Source_Index() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Import_source_home_index");
	   }
	@Test
	public void Functional_Configration_Index() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("functiona_con_index");
	   }
	@Test
	public void logout() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("DD_logout");
		eve.Click_event("logout_text");
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
