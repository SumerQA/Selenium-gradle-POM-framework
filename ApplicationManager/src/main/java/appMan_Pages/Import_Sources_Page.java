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

public class Import_Sources_Page {
	Common c = new Common();
	final WebDriver driver;
	public  Import_Sources_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Clickon_import_sources_Tab() throws IOException, InterruptedException {  
		events eve = new events(driver);
		eve.Click_event("import_sources_Tab");
		Reporter.log("********Import Cource Tab is Clicked ********");
		Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
	    }
	
	 public void Clickon_Create_New_Icon() throws IOException, InterruptedException {    
		Users_Page up = new Users_Page(driver);
		up.Open_Create_NewUser_panal();
	}
	
	 public void ImportSources_Edit_icon() throws IOException, InterruptedException { 
		Users_Page up = new Users_Page(driver);
		up.Click_On_Change_icon();
	}
	 public void Check_Editable_Field() throws IOException, InterruptedException { 
			if(driver.findElement(By.xpath(c.getElementName("ImpSrc_name"))).isEnabled()){
				driver.findElement(By.xpath(c.getElementName("ImpSrc_name"))).sendKeys("Test Editable field");
				System.out.println("Fields are Editable");
				Reporter.log("Fields are Editable");
			}
		}
	
	 public void Delete_icon() throws IOException, InterruptedException {    
		Users_Page up = new Users_Page(driver);
		up.Delete_icon();
		}
	
	 public void Import_sources_table(String text, String path) throws IOException { 
		 events eve = new events(driver);
		 eve.Table_event(text, path);
		}
	
	 public void Advanced_Settings_Tab() throws IOException, InterruptedException {  
		events eve = new events(driver);
		eve.Click_event("advan_settings");
			}
	
	 public void Scheduled_Settings_Tab() throws IOException, InterruptedException {   
		events eve = new events(driver);
		eve.Click_event("scheduled_settings_Tab");
		}
	 
	 public void SMTP_Settings_Tab() throws IOException, InterruptedException {  
		 events eve = new events(driver);
			eve.Click_event("smtp_setting_Tab");
			}
	 
	 public void Enter_Import_Sources_name(String IS_name) throws IOException {  
		 events eve = new events(driver);
		 eve.SendKey_event("ImpSrc_name", IS_name);
	    }
    
	 public void Check_Financial_Interface_checkbox(String text) throws IOException {    
		 events eve = new events(driver);
		 eve.Check_box_JS("ImportType", text);
	    }
    
	 public void link_to_Administration(String type) throws IOException {   
		 events eve = new events(driver);
		 eve.DropDown_list_event("Link_To_adminstration", type);
	    }
    
	 public void link_to_Import_Sources(String type1) throws IOException { 
		 try {
			 Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("LinkTo_Import_Source"))));   
	  	     droplist.selectByVisibleText(type1);
	  	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Something went wrong");
		}
  		
	    }
    
	 public void Customer_XML_Path(String c_xml_path) throws IOException {     	
    	driver.findElement(By.xpath(c.getElementName("Cus_XML_path"))).sendKeys(c_xml_path);
 	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    }
    
	 public void Invoice_XML_Path(String inv_xml_path) throws IOException {     	
   	   driver.findElement(By.xpath(c.getElementName("Invoice_XML_path"))).sendKeys(inv_xml_path);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    }
    
	 public void import_LogFile_Path(String logfile_path) throws IOException {     	
  	   driver.findElement(By.xpath(c.getElementName("Import_LogFile_path"))).sendKeys(logfile_path);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    }
    
	 public void Check_unique_invoice_key_CheckBox() throws IOException {     	
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("document.getElementById('ChkUniqueInvoiceKey').click();");
	    }
    
	 public void Auto_act_of_new_customers_at_import(String text) throws IOException { 
		 events eve= new events(driver);
		 eve.Check_box_JS("AutoActiveCustomer8", text);
	    }
    
	 public void Aut_act_of_cust_scoring_for_new_customers(String text) throws IOException { 
		 events eve= new events(driver);
		 eve.Check_box_JS("AutoActiveCustomerScore22", text);
		 
   	}
    
	  public void Imp_after_this_hour_seenas_next_day_DDList(String time) throws IOException { 
    	
    	  driver.findElement(By.xpath(c.getElementName("Importing_after_this_hour_is_seen_as_the_next_day_DDList"))).click();		   
    	  List<WebElement> options = driver.findElements(By.tagName("li"));
    	    for(WebElement option : options){	    	  
    		      if(option.getText().equals(time)){	    	  
    		    	   option.click();
    		    	   Reporter.log("Selected Country is  " + option.getText() );
    		    	   System.out.println("Selected Country is........................." + option.getText());
    			       break;		       
    			    }
    		      }
  	}
    
	  public void Imp_after_this_hour_seenas_next_day_InputField(String time) throws IOException {
    	driver.findElement(By.xpath(c.getElementName("Importing_after_this_hour_is_seen_as_the_next_inputBox"))).sendKeys(time);
	}
    
	  public void Invoice_due_date_checkbox(String text, String ddText, String inputText) throws IOException {
		  events eve =  new events(driver);
		  Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById('ChkInvoiceDueDate');"  +
	                 "  if (chkBox.checked) {" +
	                 "  return true  ;" +
	                 "  }" +
	                 " else{"+ " return false;" +"}" );
			 boolean checkboxStatus = (Boolean) bool;
			 if(text.equals("Yes")){
				
				 if(checkboxStatus){
					 System.out.println("Checkbox is already selected");
				 }else{
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ChkInvoiceDueDate').click();");
					 eve.DropDown_list_event("inv_due_date_DDlist", ddText);
					 if(driver.findElement(By.xpath(c.getElementName("inv_due_date_InputField"))).isEnabled()){
					 eve.SendKey_event("inv_due_date_InputField", inputText);
					 }
				 }
			 }else{
				 if(checkboxStatus){
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ChkInvoiceDueDate').click();");
				 }else{
					 System.out.println("Checkbox is unchecked already");
				 }
			 }
    }	
    
	  public void Unique_invoice_Key_Checkbox(String text, String ddText) throws IOException {
		  
		  events eve =  new events(driver);
		  Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById('ChkUniqueInvoiceKey');"  +
	                 "  if (chkBox.checked) {" +
	                 "  return true  ;" +
	                 "  }" +
	                 " else{"+ " return false;" +"}" );
			 boolean checkboxStatus = (Boolean) bool;
			 if(text.equals("Yes")){
				
				 if(checkboxStatus){
					 System.out.println("Checkbox is already selected");
				 }else{
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ChkUniqueInvoiceKey').click();");
					 eve.DropDown_list_event("Unique_invoice_key_DDList", ddText);
				 }
			 }else{
				 if(checkboxStatus){
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ChkUniqueInvoiceKey').click();");
				 }else{
					 System.out.println("Checkbox is unchecked already");
				 }
			 }
	}
    
	  public void Skip_when_invoice_row_invalid_Checkbox(String text, String ddText) throws IOException {
		  
		  events eve =  new events(driver);
		  Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById('ChkSkipRowInvalidAction17');"  +
	                 "  if (chkBox.checked) {" +
	                 "  return true  ;" +
	                 "  }" +
	                 " else{"+ " return false;" +"}" );
			 boolean checkboxStatus = (Boolean) bool;
			 if(text.equals("Yes")){
				
				 if(checkboxStatus){
					 System.out.println("Checkbox is already selected");
				 }else{
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ChkSkipRowInvalidAction17').click();");
					 eve.DropDown_list_event("Skip_when_invoice_row_invalid_DDlist", ddText);
				 }
			 }else{
				 if(checkboxStatus){
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ChkSkipRowInvalidAction17').click();");
				 }else{
					 System.out.println("Checkbox is unchecked already");
				 }
			 }
	}
    
	  public void Run_customer_import_fileson(String day) throws IOException {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;    	
    	switch(day){
    	case "Sunday": 
    		 jse.executeScript("document.getElementById('AutoImportCSunday').click();");
    		 break;
    	case "Monday":
    		 jse.executeScript("document.getElementById('AutoImportCMonday').click();");
    		break;
    	case "Tuesday":
    		 jse.executeScript("document.getElementById('AutoImportCTuesday').click();");
    		break;
    	case "Wednesday":
    		 jse.executeScript("document.getElementById('AutoImportCWednesday').click();");
    		break;
    	case "Thursday":
    		 jse.executeScript("document.getElementById('AutoImportCThursday').click();");
    		break;
    	case "Friday":
    		 jse.executeScript("document.getElementById('AutoImportCFriday').click();"); 
    		break;
    	case "Saturday":
    		 jse.executeScript("document.getElementById('AutoImportCSaturday').click();");	
    		break;
    	}
	}
    
 	  public void Run_invoice_import_fileson(String day) throws IOException {
     	JavascriptExecutor jse = (JavascriptExecutor)driver;    	
     	switch(day){
     	case "Sunday": 
     		 jse.executeScript("document.getElementById('AutoImportISunday').click();");
     		 break;
     	case "Monday":
     		 jse.executeScript("document.getElementById('AutoImportIMonday').click();");
     		break;
     	case "Tuesday":
     		 jse.executeScript("document.getElementById('AutoImportITuesday').click();");
     		break;
     	case "Wednesday":
     		 jse.executeScript("document.getElementById('AutoImportIWednesday').click();");
     		break;
     	case "Thursday":
     		 jse.executeScript("document.getElementById('AutoImportIThursday').click();");
     		break;
     	case "Friday":
     		 jse.executeScript("document.getElementById('AutoImportIFriday').click();"); 
     		break;
     	case "Saturday":
     		 jse.executeScript("document.getElementById('AutoImportISaturday').click();");	
     		break;
     	}
 	}
    
	 public void Enter_Email_Address(String smtp_Email) throws IOException { 
		 events eve= new events(driver);
		 eve.SendKey_event("Email_addr", smtp_Email);
	    }
    
	 public void Enter_Mail_Server_Username(String smtp_mailServer) throws IOException {   
		 events eve= new events(driver);
		 eve.SendKey_event("Mail_Server_Username", smtp_mailServer);
	    }
      
	 public void Enter_Mail_Server_password(String smtp_mailPwd) throws IOException {    
		 events eve= new events(driver);
		 eve.SendKey_event("Mail_Server_Password", smtp_mailPwd);
	    }
      
	 public void clickon_Save_IM_Change_icon() throws IOException, InterruptedException { 
		 events eve= new events(driver);
		 eve.Click_event("Save_IM_changes");
	    }
	 public void Reload() throws IOException, InterruptedException { 
		 events eve= new events(driver);
		 eve.Click_event("refresh");
	    }
    
	 public void Render_Notifications() throws IOException, InterruptedException {  
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				Reporter.log("---------------- Notification-----------------");
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_No_button");
				Reporter.log("----------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
			
			}
	 public void Save_changes_Notification() throws IOException, InterruptedException {
			events eve = new events(driver);
		    if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
		    	Reporter.log("---------------- Notification-----------------");
			       eve.GetText_event("Save_changes_notification_Message");
			       eve.Click_event("Save_changes_notification_OK_button");
			       Reporter.log("----------------------------------------------");
		  }else{
			      System.out.println("No notification Found");
		     }
			}
	 public void Cancel_changes_Notification() throws IOException, InterruptedException {
			events eve = new events(driver);
		    if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
		    	Reporter.log("---------------- Notification-----------------");
			       eve.GetText_event("Save_changes_notification_Message");
			       eve.Click_event("Save_changes_notification_NO_button");
			       Reporter.log("----------------------------------------------");
		  }
			}
	 
}
