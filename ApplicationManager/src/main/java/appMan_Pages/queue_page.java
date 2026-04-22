package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;


public class queue_page {
	Common c = new Common();	 
	final WebDriver driver;
	public  queue_page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
  public void click_on_batch() throws InterruptedException, IOException {
	 Home_index_Page HI_page = new Home_index_Page(driver);
	 events eve= new events(driver);
	 eve.Click_event_javaScript(driver.findElement(By.xpath(c.getElementName("og_batch"))));
	 Thread.sleep(1500);
	 HI_page.Render_Notifications();
	 
  }
  public void open_queue_page() throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Click_event("batch_queue_tab");
		 Thread.sleep(3000);
		 if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
			  driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
			  Thread.sleep(4000);
		  }
	  }
  public void Columns_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_column");
		 
	  }
  public void SelectAll() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_selectAll");
		 
	  }
  public void DeselectAll() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_DeselectAll");
		 
	  }
  public void Clear_Filter() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_clr_filter");
		 
	  }
  public void Refresh() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_refresh");
		 
	  }
  public void Delete() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_delete");
		 Thread.sleep(1500);
		 
	  }
  public void send() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("Q_send");
		 
	  }
  public void According_to_batch_rules_DDlist(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.DropDown_list("Q_Acc_to_batch_rule", text);
	  }
  public void Archive_CheckBox(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("Q_Archive", text);
	  }
  public void Cancel_acc_to_batch_rule() throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Click_event("Q_Cancel_button_acctobatchrule");
		 
	  }
  public void OK_acc_to_batch_rule() throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Click_event("Q_OK_button_acctobatchrule");
		 
	  }
  public void Search_Column_Input(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("Q_column_Search_input", text);
		 
	  }
  public void Select_All(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		eve.Checkbox("BS_TaskType_SelectAll", text);
		 
	  }
  public void Queue_Table(String compTest, String ePath) throws IOException {                           
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
					System.out.println("Column - "+ driver.findElement(By.xpath(c.getElementName("Q_tble_Column_name")+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
					Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
					driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					break labrow;
					}
				} 
			}
		    
	    }else{
	    	System.out.println("Queue is Empty ");
	    }
		}
  public void Get_Column_Name(String ePath) throws IOException {                           
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("th"));
				if(rows.size()>0){
			    for(int rownum = 0; rownum <rows.size(); rownum++) {
					if(rows.get(rownum).getAttribute("style").isEmpty()){ //display: block;  and display: none; 
						int rowno= rownum+1;
						System.out.println("Column - "+ driver.findElement(By.xpath(c.getElementName(ePath)+"/th["+rowno+"]/a")).getText());
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/th["+rowno+"]/a")).getText());
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						}
					} 
				}else{
					System.out.println("Searched Column(s) not exists.");
				}
			}
  public void Select_and_Search_Column(String ePath) throws IOException {                           
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("li"));
				if(rows.size()>0){
			    for(int rownum = 0; rownum <rows.size(); rownum++) {
					if(rows.get(rownum).getAttribute("class").isEmpty()){ //display: block;  and display: none; 
						int rowno= rownum+1;
						driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label/input")).click();
						System.out.println("Column - "+ driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label")).getText()+" is selected");
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label")).getText()+" is selected from table");
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						}
					} 
				}else{
					System.out.println("Searched Column(s) not exists.");
				}
			}
  public boolean  Search_and_SelectColumn(String ePath,String text) throws IOException {  //Q_table
	  driver.findElement(By.xpath(c.getElementName("Q_status_input"))).clear();
	  driver.findElement(By.xpath(c.getElementName("Q_status_input"))).sendKeys(text);
	  driver.findElement(By.xpath(c.getElementName("Q_status_input"))).sendKeys(Keys.ENTER);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			boolean flag=true;
				if(rows.size()>0){
			    for(int rownum = 0; rownum <1; rownum++) {
						int rowno= rownum+1;
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[4]/span")).click();
						System.out.println("Customer number-" + driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[4]")).getText() + "is Selected.");
						Reporter.log("Customer number-" + driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[4]")).getText() + "Is Selected.");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						flag=true;
						}
					}else{
						System.out.println("No items found in the grid.");
						flag=false;
					}
				return flag;
			}
  public boolean  Search_and_SelectMultiple_Column(String ePath,String text) throws IOException {  //Q_table
	  int rowl = 0;
	  driver.findElement(By.xpath(c.getElementName("Q_status_input"))).clear();
	  driver.findElement(By.xpath(c.getElementName("Q_status_input"))).sendKeys(text);
	  driver.findElement(By.xpath(c.getElementName("Q_status_input"))).sendKeys(Keys.ENTER);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			boolean flag=true;
				if(rows.size()>0){
					if(rows.size()>5){
						 rowl =4;
					}else{
						rowl=rows.size()-1;
					}
			    for(int rownum = 0; rownum <rowl; rownum++) {
						int rowno= rownum+1;
						Actions actions = new Actions(driver);
						actions.keyDown(Keys.CONTROL)
						       .click(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[4]/span")))
						       .keyUp(Keys.CONTROL)
						       .perform();
						//driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[4]/span")).click();
						System.out.println("Customer number-" + driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[8]")).getText() + "  is Selected.");
						Reporter.log("Customer number-" + driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[8]")).getText() + "  Is Selected.");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						flag=true;
			    }
					}else{
						System.out.println("No items found in the grid.");
						flag=false;
					}
				return flag;
			}
  public void Reason_Notification(String text) throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Q_notification_text"))).isDisplayed()){
				Reporter.log("Notification-----------------------------------------");
				eve.GetText_event("Q_notification_text");
				try {
					eve.SendKey_event("Q_notification_Reason", text);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				Thread.sleep(1500);
				eve.Click_event("Q_notification_OK");
				System.out.println("OK button is Clicked");
				Reporter.log("-----------------------------------------------------");
			}
	 }
  public void Notification(String txt) throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Q_notification_text"))).isDisplayed()){
				Reporter.log("Notification-----------------------------------------");
				eve.GetText_event("Q_notification_text");
				if(txt.equals("Yes")){
					eve.Click_event("Q_notification_OK");
					System.out.println("Ok button is Clicked");
				}else{
					eve.Click_event("Q_notification_NO");
					System.out.println("NO button is Clicked");
					}
				}
				Reporter.log("-----------------------------------------------------");
			}
  
  
}
