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

public class Batch_rules_page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Batch_rules_page(WebDriver driver)
	{   
		this.driver = driver;
	}
  public void open_batch_rules_page() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("batch_rules_batch");
	 Reporter.log("batch rules Tab is Clicked");
	 
  }
  public void Create_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Create_batchrule");
		 Reporter.log("Create Icon is clicked");
		 
	  }
  public void Change_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Change_batchrule");
		 Reporter.log("Change Icon is clicked");
	  }
  public void Delete_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Delete_batchrule");
		 Reporter.log("Delete Icon is clicked");
	  }
  public void Reload_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Reload_batchrule");
		 Reporter.log("Reload Icon is clicked");
	  }
  public void Save_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Save_batchrule");
		 Reporter.log("Save Icon is clicked");
	  }
  public void Cancel_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Cancel_batchrule");
		 Reporter.log("Cancel Icon is clicked");
	  }
  public void Link_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Link_batch");
		 Reporter.log("Link Icon is clicked");
	  }
  public void Unlink_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Unlink_batch");
		 Reporter.log("Unlink Icon is clicked");
	  }
  public void Enter_New_BatchRule(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("New_batchrule_input", text);
		 Reporter.log(text+": is Entered in the batch rule sets input field.");
	  }
  public void Output_Media_Type_DDlist(String action) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("output_mediaType_DDList", action);
		 
	  }
  public void update_batchRule(String compTest,String textinput) throws InterruptedException {
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  WebElement element= driver.findElement(By.xpath(c.getElementName("batchrule_sets_table")));
		List<WebElement> rows=element.findElements(By.tagName("tr"));
		labrow :
		for(int rownum = 0; rownum <rows.size(); rownum++) {
			List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
			//System.out.println("Number of columns:"+columns.size());
			for(int colnum=0; colnum<columns.size();colnum++){
				System.out.println(columns.get(colnum).getText());
				if(columns.get(colnum).getText().equals(compTest)){
					int rowno= rownum+1;
					int colNo =colnum+1;
					System.out.println(driver.findElement(By.xpath(c.getElementName("batchrule_sets_table")+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
					Reporter.log(driver.findElement(By.xpath(c.getElementName("batchrule_sets_table")+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
					driver.findElement(By.xpath(c.getElementName("batchrule_sets_table")+"/tr["+rowno+"]/td["+colNo+"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					br_page.Change_Icon();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
					driver.findElement(By.xpath(c.getElementName("batchrule_sets_table")+"/tr["+rowno+"]/td["+colNo+"]/input")).clear();
					driver.findElement(By.xpath(c.getElementName("batchrule_sets_table")+"/tr["+rowno+"]/td["+colNo+"]/input")).sendKeys(textinput);
					Reporter.log(textinput+ " is Entered in the Batch rule sets input filed");
					break labrow;
					}
				} 
			}
		 
	  }
  public void Export_path(String path,String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event(path, text);
		 Reporter.log(text +" is Entered in the Export path Input Field");
	  }
  public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification-----------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("-----------------------------------------------------");
			}
	 }
  public void Render_Notifications() throws IOException, InterruptedException {
	  events eve = new events(driver);
		if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
			Reporter.log("Notificatio: ----------------------------------------");
			eve.GetText_event("TC_Notification_Message");
			eve.Click_event("TC_Notification_No_button");
			Reporter.log("-----------------------------------------------------");
		}
	    }
}
