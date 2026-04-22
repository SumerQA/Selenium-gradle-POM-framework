package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class entity_tables_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  entity_tables_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_communication_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(3000);
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Communication_tab();
		Thread.sleep(2000);
		HI_page.Render_Notifications();
	    }
	 public void Click_on_Entity_Tables_tab() throws IOException, InterruptedException {	
		 events eve = new events(driver);
		 Home_index_Page HI_page = new Home_index_Page(driver);
		 eve.Click_event("et_et_tab");
		 Reporter.log("Clicked on Entity Tables tab");
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
		eve.Click_event("is_update_icon");
		Reporter.log("Update Icon is Clicked.");
	    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("is_delete_icon");
			Reporter.log("Delete Icon is Clicked.");
		    }
	 public void Entity_table_Name(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+"is Entered in the Entity table name input field.");
		    }
	 public void Description(String path, String text) throws IOException, InterruptedException {
			 events eve = new events(driver);
			 eve.SendKey_event(path, text);
		    }
	
	 public void Enter_Entity_Values(String path, String text, Boolean onUpdate) throws IOException, InterruptedException {
		 WebElement element = driver.findElement(By.xpath(c.getElementName(path)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			for (int rownum = 0; rownum < rows.size(); rownum++) {
						int rowno = rownum + 1;
						driver.findElement(By.xpath(c.getElementName(path) + "/tr[" + rowno+ "]/td[2]")).click();
						Thread.sleep(1000);
						if(onUpdate) {
							driver.findElement(By.xpath("//input[@name='Content']")).clear();
							Thread.sleep(1000);
							driver.findElement(By.xpath(c.getElementName(path) + "/tr[" + rowno+ "]/td[2]")).click();
							Thread.sleep(1000);							
						}						
						driver.findElement(By.xpath(c.getElementName(path) + "/tr[" + rowno+ "]/td[2]/input")).sendKeys(text + rowno);
						System.out.println(text+": is Entered  for "+driver.findElement(By.xpath(c.getElementName(path) + "/tr[" + rowno+ "]/td[1]")).getText()+ " Code");
						Reporter.log(text+": is Entered  for "+driver.findElement(By.xpath(c.getElementName(path) + "/tr[" + rowno+ "]/td[1]")).getText()+ " Code");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				}
		    }
	 public void Entity_Item20(String path,String Scriptpath, String uploadpath) throws IOException, InterruptedException {
		    events eve = new events(driver);
			eve.Click_event(path);
			eve.Upload_File_event(Scriptpath, uploadpath);
	    }
	 
	 	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_refresh");
			Reporter.log("Reload Button is clicked");
			
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save");
			Reporter.log("Save Button is clicked");
			
		    }
	 public void Save_Panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_Panal_Changes");
			Reporter.log("Save Button is clicked");
	        }
			
	 public void Save_sa_New() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event("PS_Save_As_new");
			Reporter.log("Save as New Button is clicked");
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event("PS_Save_and_Close");
			Reporter.log("Save and Close Button is clicked");
		    }
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Cancel");
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
