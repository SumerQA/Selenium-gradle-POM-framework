package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Status_Maintenance_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Status_Maintenance_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Status_Maintenance_page() throws IOException, InterruptedException{	
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(500);*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		/*FC_page.Click_Disputes_tab();
		Thread.sleep(500);*/
		FC_page.Click_Status_Maintenance_tab();
		Thread.sleep(500);
		HI_page.Render_Notifications();
	    }
	 public void Creat_New_icon() throws IOException , InterruptedException{
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create icon is Clicked");
	    }
	 public void Update_icon() throws IOException , InterruptedException{	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Update icon is Clicked");
	    }
	 public void Delete_icon() throws IOException , InterruptedException{	
			events eve = new events(driver);
			eve.Click_event("delete_user");
			Reporter.log("Delete icon is Clicked");
		    }
	
	 public void Dispute_Status_Name(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path,text);
		Reporter.log(text+" : is Entered in the Dispute status name input field.");
		
	    }
	 public void Customer_letter(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			
		    }
	 public void Block_Unblock_Customer(String CusStatus) throws IOException {
			if(CusStatus.equals("1")){
				 JavascriptExecutor js =(JavascriptExecutor)driver;
				 js.executeScript("document.getElementById('BlockDebtor').click();");
			}else{
				JavascriptExecutor js =(JavascriptExecutor)driver;
				 js.executeScript("document.getElementById('UnblockDebtor').click();");
			}
		    }
	 public void Block_Unblock_Invoices(String InvStatus) throws IOException {
			if(InvStatus.equals("1")){
				JavascriptExecutor js =(JavascriptExecutor)driver;
				 js.executeScript("document.getElementById('BlockInvoices').click();");
			}else{
				JavascriptExecutor js =(JavascriptExecutor)driver;
				 js.executeScript("document.getElementById('UnblockInvoices').click();");
			}
		    }
	 public void Email_letter(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
	 public void Action_taker(String text) throws IOException {
			 events ev = new events(driver);
			 ev.Check_box_JS("EmailActionTaker", text);
		    }
	 public void Credit_Manager(String text) throws IOException {
			 events ev = new events(driver);
			 ev.Check_box_JS("EmailCreditManager", text);
		    }
	 public void Dispute_Manager(String text) throws IOException {
			 events ev = new events(driver);
			 ev.Check_box_JS("EmailQueryManager", text);
		    }
	 public void Account_Manager(String text) throws IOException {
			 events ev = new events(driver);
			 ev.Check_box_JS("EmailAccountManager", text);
		    }
	 public void Send_to(String text,String intext) throws IOException {
		 events ev = new events(driver);
		 Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById('ExtraEmail');"  +
                 "  if (chkBox.checked) {" +
                 "  return true  ;" +
                 "  }" +
                 " else{"+ " return false;" +"}" );
		 boolean checkboxStatus = (Boolean) bool;
		 if(text.equals("Yes")){
			
			 if(checkboxStatus){
				 System.out.println("Checkbox is already selected");
				 ev.SendKey_event("SM_SendTo_input", intext);
			 }else{
				 ((JavascriptExecutor) driver).executeScript("document.getElementById('ExtraEmail').click();");
				 ev.SendKey_event("SM_SendTo_input", intext);
			 }
		 }else{
			 if(checkboxStatus){
				 ((JavascriptExecutor) driver).executeScript("document.getElementById('ExtraEmail').click();");
			 }else{
				 System.out.println("Checkbo ix is unchecked already");
			 }
		 }
		    }
	 public void Refresh() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_refresh");
			Reporter.log("Relaod button is clicked.");
		    }
	 public void reload() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Relaod button is clicked.");
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save");
			Reporter.log("Save button is clicked.");
			
		    }
	 public void Save_as_new() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save_As_new");
			Reporter.log("Save as New button is clicked.");
			
		    }
	 public void SaveAll_Changes() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			Reporter.log("Save button is clicked.");
			
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save_and_Close");
			Reporter.log("Save and Close button is clicked.");
		    }
	 public void Cancel() throws IOException , InterruptedException{
			events eve = new events(driver);
			eve.Click_event("PS_Cancel");
			Reporter.log("Cancel button is clicked.");
			
		    }
	 public void Notification() throws IOException , InterruptedException{
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
			Reporter.log("link button is Clicked.");
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Unlink button is Clicked.");
		    }
	}
