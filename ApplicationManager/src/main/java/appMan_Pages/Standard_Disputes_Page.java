package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Standard_Disputes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Standard_Disputes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Standard_Dispute_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(500);*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Disputes_tab();
		Thread.sleep(2000);
		FC_page.Click_Standard_Disputes_tab();
		Thread.sleep(1000);
		Thread.sleep(500);
		HI_page.Render_Notifications();
	    }
	 public void Creat_New_icon() throws IOException , InterruptedException{
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create icon is Clicked.");
	    }
	 public void Update_Dispute_icon() throws IOException , InterruptedException{	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Update icon is Clicked.");
	    }
	 public void Delete_Dispute_icon() throws IOException , InterruptedException{	
			events eve = new events(driver);
			eve.Click_event("delete_user");
			Reporter.log("Delete icon is Clicked.");
		    }
	 public void Description(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ " : is Entered in the Description input field.");
		    }
		    
	 public void code(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path,text);
		Reporter.log(text+ " : is Entered in the Code input field.");
		
	    }
	 public void Action_Period(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ " : is Entered in the Action Period input field.");
			
		    }
	 public void Monitoring_on_dispute_end_date(String text) throws IOException {
		 events ev = new events(driver);
		 ev.Check_box_JS("IsMonitored", text);
		    }
	 public void Make_dispute_available_for_SSE(String text) throws IOException {
		 events ev = new events(driver);
		 ev.Check_box_JS("AvailableForSSE", text);
		    }
	 public void Complete_disputes_automatically() throws IOException {
		    ((JavascriptExecutor) driver).executeScript("document.getElementById('CompleteDispute').click();");
	 	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			System.out.println("Checked the checkbox");	
		    }
	 public void Automatic_cause(String path, String text) throws IOException {
		 
		 Select droplist = new Select(driver.findElement(By.xpath(c.getElementName(path)))); 
			List<WebElement> op = droplist.getOptions();
				for(WebElement el :op){
					
					if(el.getText().trim().equals(text)){
						el.click();
						Reporter.log( text+ " : is selected from DDlist");
				    	break;
				   }
					   }
		    }
		
	 public void Automatic_solution(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
	 
	 public void Select_dispute_action(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
	 public void Dispute_Manager_Administration(String path) throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event(path);
		    }
	 public void debtor(String path) throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event(path);
		    }
	 public void Dispute_Manager_Customer(String path) throws IOException {
			events eve = new events(driver);
			eve.Checkbox(path,"Yes");
		    }
	 public void Dispute_Manager_Selection(String path) throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event(path);;
		    }
	 public void Dispute_Manager_Selection_DDList(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
	 public void Dispute_Manager_Editable(String text) throws IOException {
		 events ev = new events(driver);
		 ev.Check_box_JS("IsManagerEditable", text);
		    }
	 public void Change_Test_days(String text) throws IOException {
		 events eve = new events(driver);
		 eve.Check_box_JS("AutomaticTestDays", text);
		    }
	 public void Refresh() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_refresh");
			Reporter.log("Reload icon is Clicked.");
			
		    }
	 public void Reload_panal() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Reload icon is Clicked.");
		    }
	 public void Save() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_Save");
			Reporter.log("Save icon is Clicked.");
			
		    }
	 public void Save_as_New() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_Save_As_new");
			Reporter.log("Save as new icon is Clicked.");
		    }
	 public void Save_and_Close() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("PS_Save_and_Close")));
			eve.Click_event_javaScript(Ele);
			Reporter.log("Save and Close icon is Clicked.");
			
		    }
	 public void Save_ALL_Changes() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("Save_IM_changes")));
			eve.Click_event_javaScript(Ele);
			Reporter.log("Save icon is Clicked.");
			
		    }
	 public void Cancel() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_Cancel");
			Reporter.log("Cancel icon is Clicked.");
			
		    }
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications:-------------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("---------------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		    }
	  
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Link Icon is Clicked.");
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Unlink Icon is Clicked.");
		    }
	}
