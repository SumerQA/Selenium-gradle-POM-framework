package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Configration_Files.Common;
import Event_commands.events;

public class Import_Log_Page {
	Common c = new Common();
	final WebDriver driver;
	public  Import_Log_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Goto_import_Log_Tab() throws IOException, InterruptedException { 
		/* Home_index_Page HI_page = new Home_index_Page(driver);
			HI_page.Select_Functional_Configration_Tab();*/
		events eve = new events(driver);
		eve.Click_event("IL_imp_log_tab");
		Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
	    }
	
	 public void change_icon() throws IOException, InterruptedException { 
		 events eve = new events(driver);
		 eve.Click_event("Change_Existing_User");
	}
	
	 public void Import_Log_remove_After(String text,String val) throws IOException { 
		 events eve = new  events(driver);
		 Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById('ImportLogInDB');"  +
                 "  if (chkBox.checked) {" +
                 "  return true  ;" +
                 "  }" +
                 " else{"+ " return false;" +"}" );
		 boolean checkboxStatus = (Boolean) bool;
		 if(text.equals("Yes")){
			
			 if(checkboxStatus){
				 System.out.println("Checkbox is already selected");
				 eve.SendKey_JS("ImportOptionValue", val);
			 }else{
				 ((JavascriptExecutor) driver).executeScript("document.getElementById('ImportLogInDB').click();");
				 eve.SendKey_JS("ImportOptionValue", val);
			 }
		 }else{
				 if(checkboxStatus){
					 ((JavascriptExecutor) driver).executeScript("document.getElementById('ImportLogInDB').click();");
				 }else{
					 System.out.println("Checkbox is unchecked already");
				 }
			  }
	}
	
	 public void ImportLog_messages_screen(String text) throws IOException {  
		events eve = new events(driver);
		eve.DropDown_list_event("IL_import_log_ddlist", text);
			}
	 public void ImportLog_messages_Database(String text) throws IOException {  
			events eve = new events(driver);
			eve.DropDown_list_event("IL_import_log_DB_ddlist", text);
				}
	 public void ImportLog_messages_Window(String text) throws IOException {  
			events eve = new events(driver);
			eve.DropDown_list_event("IL_import_log_window_ddlist", text);
				}
	 public void Select_importLog_to_View() throws IOException {  
		 Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("IL_select_imp_log_toView"))));   
		    	droplist.selectByIndex(2);
		    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				}
	 
	 
	 
	 public void View_log() throws IOException, InterruptedException {   
		events eve = new events(driver);
		eve.Click_event("IL_View_Log");
		}
	 
	 public void Read_All_logs() throws IOException {  
				WebElement element= driver.findElement(By.xpath(c.getElementName("IL_log_table")));
				List<WebElement> rows=element.findElements(By.tagName("tr"));
				System.out.println("<<===================> Imported Log lines <===================>>");
				for(int rownum = 0; rownum <rows.size(); rownum++) {
					List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
					for(WebElement e:columns) {
						System.out.println(e.getText());
					}
				}
				System.out.println("<<===================> End of Log line <===================>>");
	     }	
	
	 public void Save() throws IOException, InterruptedException {   
			events eve = new events(driver);
			eve.Click_event("Save_Panal_Changes");
			}
	 public void refresh() throws IOException, InterruptedException {   
			events eve = new events(driver);
			eve.Click_event("refresh");
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
