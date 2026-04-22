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
public class API_Inbound_settings_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  API_Inbound_settings_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Goto_Api_Inbound_Settings_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			//Commentsed section
			/*HI_page.Select_Technical_Configration_Tab();
			Thread.sleep(2000);
			System.out.println("Technical Configration tab is clicked");//
*/			
			Technical_Configration_page TC_page = new Technical_Configration_page(driver);
			TC_page.API_Tab();
			TC_page.API_Inbound_Settings();
			Thread.sleep(1500);
			HI_page.Render_Notifications();
		    System.out.println("API Inbound settings page is opened");
		    }
	 public void Create_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_Create_icon");
			System.out.println("Create Icon is Clicked");
			Thread.sleep(1500);
		    }
	 public void Update_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_Update_icon");
			System.out.println("Update Icon is Clicked");
			Thread.sleep(1500);
		    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_Delete_Icon");
			System.out.println("Delete Icon is Clicked");
			Thread.sleep(1000);
		    }
	 public void API_Client_name(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_client_name", text);       //API Client name 
			Reporter.log(text+" : is Entered in the API client name Input Field.");
			Thread.sleep(500);
		    }
	 public void IP_address(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_ip_addr", text);
			Reporter.log(text +": is Entered in the IP Address Input field.");
			Thread.sleep(500);
			}
	 public void Access_Token_Expiry(String date) throws IOException, InterruptedException {	
		 events eve=new events(driver);
		 eve.date_time_Picker(date);
		     }
	 public void Refresh_Period(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_R_period_mx", text);       //Refresh Period
			Reporter.log(text+" : is Entered in Refresh Period Input Field.");
			Thread.sleep(500);
		    }
	public void Generate_token_Button() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_generate_token");
			System.out.println("Generate Token Button is clicked");
			Reporter.log("Generate Token Button is clicked");
			Thread.sleep(1000);
	       }
	public void Refresh_Icon() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_refresh_icon");
		System.out.println("Refresh Icon is clicked");
		Reporter.log("Refresh Icon is clicked");
		Thread.sleep(1000);
       }
	public void List_of_API_Connection_table(String ePath, String name, String ipaddr) throws IOException, InterruptedException {	
		WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		labrow: 
			for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				int rowno = rownum + 1;
				int colNo = colnum + 1;
				System.out.println(columns.get(colnum).getText());
				if (driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[1]")).getText().equals(name) && driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText().equals(ipaddr)) {
					
					System.out.println(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[" + colNo + "]")).getText()+ " is selected");
					Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[" + colNo + "]")).getText()+ " is selected from table");
					driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[" + colNo + "]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					break labrow;
				}
				
			}
		 }
		
       }
	
	
	
	 public void Notification() throws IOException, InterruptedException {	
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: ---------------------------");
				String msg =eve.GetText("Save_changes_notification_Message");
				System.out.println("Notification Message is : "+msg);
				Reporter.log("Notification Message is : "+msg);
				Thread.sleep(300);
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("------------------------------------------");
				Thread.sleep(1500);
			}else{
				System.out.println("No notification Found");
				Thread.sleep(1500);
			}
	       }
	 
	
}
