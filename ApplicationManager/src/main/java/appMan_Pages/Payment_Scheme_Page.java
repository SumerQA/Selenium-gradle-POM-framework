package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Payment_Scheme_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Payment_Scheme_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Payment_Scheme_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			/*HI_page.Select_Functional_Configration_Tab();
			Thread.sleep(1000);*/
			Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
			FC_page.Click_Payment_scheme_tab();
			Thread.sleep(1000);
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
	 public void Payment_scheme_Name(String path , String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ ": is Entered in the Payment scheme name input field");
		    }
		    
	 public void Number_ofExpected_payments(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path,text);
			Reporter.log(text+ ": is Entered in the Number of expected payments  input field");
		    }
	 public void Payment_Every(String path, String text, String rText) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			if(rText.equals("1")){
				eve.Click_event("PS_Payment_Every_week_rbutton");
			}else{
				eve.Click_event("PS_Payment_Every_Month_rbutton");
			}
			
		    }
	 public void Round_payment_to(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			
		    }
	 public void Control_days(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			
		    }
	 public void Delete_All_Active_Actions(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.Checkbox(path,text);
			
		    }
	 public void Block_Invoices(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.Checkbox(path,text);
		    }
	 
	 public void Checkbox_DDlist_dependencies(String text, String ddtext ,String cpath,String Ddpath) throws IOException, InterruptedException {
			events eve = new events(driver);
			if(text.equals("Yes")){
				if(driver.findElement(By.xpath(c.getElementName(cpath))).isSelected()){
					eve.DropDown_list_event(Ddpath, ddtext);
				}else{
					eve.Click_event(cpath);
					eve.DropDown_list_event(Ddpath, ddtext);
				}
			}else{
				if(driver.findElement(By.xpath(c.getElementName(cpath))).isSelected()){
					eve.Click_event(cpath);
				}else{
					System.out.println("Checkbox is Unchecked already");
				}
			}
			}
	 public void Send_Letter_On_Update_Checkbox(String text) throws IOException {
			events eve = new events(driver);
			eve.Checkbox("PS_Generate_telephone_action_onOverdue",text);
		    }
	 public void Generate_Telephone_Action_onOverdue(String text) throws IOException {
			events eve = new events(driver);
			eve.Checkbox("PS_Generate_telephone_action_onOverdue",text);
		    }
	 public void Generate_Telephone_Action_onCompletion(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.Check_box_JS(path, text);
		    }
	 
	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Refresh_panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Save_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_Panal_Changes");
			Reporter.log("Save button is Clicked.");
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save");
			Reporter.log("Save button is Clicked.");
			
		    }
	 public void Save_as_new() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save_As_new");
			Reporter.log("Save as New button is Clicked.");
			
		    }
	 public void Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Cancel");
			Reporter.log("Cancel button is Clicked.");
			
		    }
	 public void Save_and_Close() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("PS_Save_and_Close")));
			eve.Click_event_javaScript(Ele);
			Reporter.log("Save and Close button is Clicked.");
			
		    }
	 public void Notification() throws IOException, InterruptedException {
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification : ---------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("------------------------------------------------------");
			}
			
		    }
	 public void NO_Notification_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_changes_notification_NO_button");
			Reporter.log("No Button is Clicked.");
			
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
	}
