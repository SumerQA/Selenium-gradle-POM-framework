package appMan_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Interest_Schemes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Interest_Schemes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Interest_Scheme_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			/*HI_page.Select_Functional_Configration_Tab();
			Thread.sleep(1000);*/
			Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
			FC_page.Click_interest_Scheme_tab();
			Thread.sleep(1000);
			HI_page.Render_Notifications();
		    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("is_create_icon");
			Reporter.log("Create Icon is Clicked.");
		    }
	 public void Update_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("is_update_icon");
			Reporter.log("Update Icon is Clicked.");
		    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("is_delete_icon");
			Reporter.log("Delete Icon is Clicked.");
		    }
	                                                             
	 public void Interest_scheme_Name(String path , String text) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ ": is Entered in the Interest scheme name input field");
			Thread.sleep(700);
		    }
	 public void Description(String path , String text) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ ": is Entered in the Description input field");
			Thread.sleep(700);
		    }
	 		    
	 public void Calculate_From(String path,String input_path, String text,String InputText) throws IOException, InterruptedException {
			events eve = new events(driver);
			switch(text){
				case("1"):eve.Dropdow_by_attribute(path, text);
				Thread.sleep(700);
				break;
				case("2"):eve.Dropdow_by_attribute(path, text);
				Thread.sleep(700);
				break;
				case("3"):
					eve.Dropdow_by_attribute(path, text);
				    Thread.sleep(700);
				    Thread.sleep(500);
				   	eve.SendKey_event(input_path, InputText);
					break;
					} 
				    
				}
			
	 public void Currency(String path, String text) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			Thread.sleep(700);
			
		    }
	 public void Threshold_value(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			
		    }
	 public void Clear_Threshold_value(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Clear_InputField(path);
			Thread.sleep(700);
			
		    }
	 public void Include_paid_invoice(String path,String text) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			Thread.sleep(700);
			
		    }
	 public void Add_Interest_Icon(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);
			Thread.sleep(700);
		    }
	 
	
	 
	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("is_Refresh_icon");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Refresh_panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Save_Panel_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_Panal_Changes");
			Reporter.log("Save button is Clicked.");
			Thread.sleep(700);
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			try {
				eve.Click_event("is_Save_iCon");
				Thread.sleep(700);
				Reporter.log("Save button is Clicked.");
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		    }
	 public void Save_as_new() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("is_save_as_new_icon");
			Reporter.log("Save as New button is Clicked.");
			Thread.sleep(700);
			
		    }
	 public void Close() throws IOException, InterruptedException {
		 try {
			 events eve = new events(driver);
			 eve.Click_event("is_Cancel_icon");
			 Thread.sleep(700);
			 Reporter.log("Cancel button is Clicked.");
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
		    }
	 public void Save_and_Close() throws IOException {
			events eve = new events(driver);
			WebElement Ele = driver.findElement(By.xpath(c.getElementName("is_save_and_Close")));
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
	 public void Notification_No() throws IOException, InterruptedException {
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				Reporter.log("Notification : ---------------------------------------");
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_No_button");
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
	 
	 public void Add_Interest(String path,String val) throws IOException, InterruptedException {
		    events eve=new events(driver);
			WebElement element = driver.findElement(By.xpath(c.getElementName(path)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			int cou=rows.size();
			int pers = cou+1;
			eve.Click_event("is_add_interest_persantage");
			
			driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +pers+"]/td[2]/input")).sendKeys(val);
		    }
	 
	 public void Update_Interest(String path,String val,String val1) throws IOException, InterruptedException {
			WebElement element = driver.findElement(By.xpath(c.getElementName(path)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			int cou=rows.size();
			for(int i=1;i<=cou;i++){
				String persntg=driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +i+"]/td[2]")).getText();
				if(persntg.contains(val)){
					driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +i+"]/td[2]")).click();
					driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +i+"]/td[2]/input")).clear();
					driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +i+"]/td[2]/input")).sendKeys(val1);	
					break;
				}
			}
	   }
	 public void Update_Interest_date(String path,String val,String val1) throws IOException, InterruptedException {
		    events eve = new events(driver);
			WebElement element = driver.findElement(By.xpath(c.getElementName(path)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			int cou=rows.size();
			for(int i=1;i<=cou;i++){
				String persntg=driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +i+"]/td[2]")).getText();
				if(persntg.contains(val)){
					driver.findElement(By.xpath(c.getElementName(path) + "/tr[" +i+"]/td[3]")).click();
					eve.date_time_Picker(val1);	
					Thread.sleep(1000);
					if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_OK_button"))).isDisplayed()){
						driver.findElement(By.xpath(c.getElementName("Save_changes_notification_OK_button"))).click();
						int vval = Integer.parseInt(val1);
						vval+=1;
						val1=Integer.toString(vval);
						Update_Interest_date(path, val, val1);
						
					}
					break;
				}
			}
	   }
	}
