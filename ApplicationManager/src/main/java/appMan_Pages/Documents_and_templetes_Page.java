package appMan_Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Documents_and_templetes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Documents_and_templetes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_communication_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
	   /* HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(3000);*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Communication_tab();
		Thread.sleep(2000);
		HI_page.Render_Notifications();
	    }
	 public void Click_on_Documents_and_templetes_tab() throws IOException, InterruptedException {	
		 events eve = new events(driver);
		 Home_index_Page HI_page = new Home_index_Page(driver);
		 eve.Click_event("com_doc_and_temp_tab");
		 Reporter.log("Clicked on Documents and templetes tab");
		 Thread.sleep(1500);
		 HI_page.Render_Notifications();
		    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal1");
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
	 public void General_Settings(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
			Reporter.log("General Settings tab is Clicked.");
		    }
	 public void Letter_Name(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+"is Entered in the Letter name input field.");
		    }
	 public void Interest_Scheme(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.DropDown_list(path, text);
			Reporter.log(text+": exists in Interest Scheme Ddlist.");
		    }
	 public void Cost_Scheme(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.DropDown_list(path, text);
			Reporter.log(text+": exists in Interest Scheme Ddlist..");
		    }
	 public void End_of_period_statement(String path, String action) throws IOException {                           
			events eve = new events(driver);
			eve.Dropdow_by_attribute(path, action);
		    }
	 public void Include_copy_invoice_as_attachment_in_letter (String id, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
		    }
	 public void Include_copy_invoice_as_attachment_in_email (String id, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
		    }
	 public void Count_asReminder_Letter(String path,String text) throws IOException {                           
			events eve = new events(driver);
			eve.Checkbox(path,text);
		    }
	 public void Table_Settings(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
			Reporter.log("Table Settings tab is Clicked.");
		    }
	 
	 public void GroupBy_1(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
		    
	 public void GroupBy_2(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			
		    }
	 public void Sort_by(String path,String text,String Sorttext) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			if(Sorttext.equals("Ascending")){
				eve.Click_event("com_sortby_asc");
			}else{
				eve.Click_event("com_sortby_desc");
			}
		    }
	 
	 
	 public void Calculate_subtotal(String path,String text, String cal_sub,String print_sub) throws IOException {                           
		 events eve = new events(driver);
			eve.Checkbox("com_cal_subtotal_checkbox",cal_sub);
			if(driver.findElement(By.xpath(c.getElementName("com_print_subtotal_bold"))).isEnabled()){
					eve.Checkbox("com_print_subtotal_bold",print_sub);
				    eve.DropDown_list_event(path, text);
		   }
			}
	 public void Templetes_Tab(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
			Reporter.log("Templete tab is Clicked.");	    
	 }
	 public void Templete(String path,String Scriptpath, String uploadpath) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);
			eve.Upload_File_event(Scriptpath, uploadpath);
		    }
	 public void Reminder_Language(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
		    }
	 public void Templete_Format(String text) throws IOException, InterruptedException {
			events eve = new events(driver);
			switch(text){
			case("1") : eve.Click_event("com_rtf");
			              break;
			case("2") : eve.Click_event("com_html");
			              break;
			case("3") : eve.Click_event("com_sms");
			              break;
			}
			}
	 public void Templete_table(String ePath, String compTest) throws IOException { 
			 events eve = new events(driver);
			 eve.Table_event(compTest, ePath);
			}
	 public void New_templete_icon() throws IOException, InterruptedException { 
			 events eve = new events(driver);
			 eve.Click_event("Com_New_temp_ICON");
			}
	 public void Edit_templete_icon() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Com_Edit_temp_ICON");
			
		    }
	 public void Delete_templete_icon() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Com_Delete_temp_ICON");
			
		    }
	 public void OnGuard_templete_Manager_icon(String path) throws IOException, InterruptedException {
			 events eve = new events(driver);
			 eve.Click_event(path);
		    }
	 	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("C_Refresh");
			Reporter.log("Reload Button is clicked");
			
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("save_icon");
			Reporter.log("Save Button is clicked");
			
		    }
	 public void Save_Panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			Reporter.log("Save Button is clicked");
	        }
			
	 public void Save_sa_New() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event("RE_Save_as_New");
			Reporter.log("Save as New Button is clicked");
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event("save_n_Close");
			Reporter.log("Save and Close Button is clicked");
		    }
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("save_icon");
			Reporter.log("Cancel Button is clicked");
			
		    }
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification : ------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("---------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		   }
	 public void Notification_No() throws IOException, InterruptedException {
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				Reporter.log("Notification : ---------------------------------------");
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_No_button");
				Reporter.log("------------------------------------------------------");
			 }
	 }
	
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Link Button is clicked");
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Unlink Button is clicked");
		    }
	}
