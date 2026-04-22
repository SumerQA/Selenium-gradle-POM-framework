package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Terminology_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Terminology_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Terminology_page() throws IOException, InterruptedException {	
		/*Home_index_Page HI_page = new Home_index_Page(driver);//Commented
		HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(1000);*/
		
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		//Commented
		/*FC_page.Click_on_tables_tab();
		Thread.sleep(1000);*/
		
		FC_page.Click_on_Terminology_tab();
		Thread.sleep(3000);
		Render_Notifications();
	    }
	 public void Change_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Clicked on Change Icon.");
	    }
	 
	 public void Terminology_list(String compTest, String ePath) throws IOException {                           
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			labrow :
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size()-1;colnum++){
					System.out.println(columns.get(colnum).getText());
					int rowno= rownum+1;
					((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[2]")));
					try {
						if(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[2]")).getText().equals(compTest)){
							Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]")).getText()+" is selected from table");
							((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[2]")));
							driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]")).click();
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
							break labrow;
							}else{
								((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'none';", driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[2]")));
							}
					} catch (Exception  e) {
						// TODO: handle exception
						System.out.println("Element is either Missing or does not recognize");
					}
					
					
					} 
				}
		    }
	 public boolean Terminology_Value(String compTest, String ePath) throws IOException {                           
			/*events eve = new events(driver);
			eve.Table_event(compTest, ePath);*/
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			labrow :
				if(rows.size()>0){
			    for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					if(columns.get(colnum).getText().equals(compTest)){
						int rowno= rownum+1;
						int colNo =colnum+1;
						System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).click();
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						break labrow;
						}
					} 
				}
			    
		    }else{
		    	System.out.println("Terminology List is Empty ");
		    	return false;
		    }
				return true;	
			}
	 public void English_En(String text) throws IOException {                           
			events ev = new events(driver);
			ev.SendKey_event("t_lan_English_EN", text);
		    }
	 public void English_US(String text) throws IOException {                           
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_English_US", text);
		    }
	 public void Dutch(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Dutch", text);
		    }
	 public void German(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_German", text);
		    }
	 public void French(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_french", text);
		    }
	 public void Italian(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_italian", text);
		    }
	 public void Spanish(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Spanish", text);
		    }
	 public void Portuguese(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Portuguese", text);
		    }
	 public void Polish(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Polish", text);
		    }
	 public void Chinese_Simplified(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_chinese", text);
		    }
	 public void Hindi(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_hindi", text);
		    }
	 public void Indonesians(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Indonesians", text);
		    }
	 public void Japanese(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Japanese", text);
		    }
	 public void korean(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_korean", text);
		    }
	 public void Malaysian(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_malaysian", text);
		    }
	 public void Thai(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Thai", text);
		    }
	 public void Vietnamese(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_vietnamese", text);
		    }
	 public void Turkish(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_Turkish", text);
		    }
	 public void Russian(String text) throws IOException { 
		    events ev = new events(driver);
		    ev.SendKey_event("t_lan_russian", text);
		    }
		    
	 public void Save_changes() throws IOException, InterruptedException {	
			 events ev = new events(driver);
			 ev.Click_event("Save_Panal_Changes");
			 Reporter.log("Save button is Clicked.");
			    }
	 
	 public void Reload() throws IOException, InterruptedException {	
		 events ev = new events(driver);
		 ev.Click_event("refresh");
		 Reporter.log("Reload button is Clicked.");
		    }
	 public void Notifications() throws IOException, InterruptedException {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("notifications: -----------------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("---------------------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		    }
	 public void Render_Notifications() throws IOException, InterruptedException {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				Reporter.log("notifications: -----------------------------------------------");
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_No_button");
				Reporter.log("---------------------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		    }
	}
