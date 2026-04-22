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
public class API_OutBound_settings_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  API_OutBound_settings_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Goto_Api_outbound_Settings_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			Technical_Configration_page TC_page = new Technical_Configration_page(driver);
			/*HI_page.Select_Technical_Configration_Tab();
			Thread.sleep(2000);
			System.out.println("Technical Configration tab is clicked");
			TC_page.API_Tab();*/
			TC_page.API_Outbound_Settings();
			Thread.sleep(1500);
			HI_page.Render_Notifications();
		    System.out.println("API Outbound settings page is opened");
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
	 public void Resource_name(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_rource_nm", text);       //API Client name 
			Reporter.log(text+" : is Entered in the Resource name Input Field.");
			Thread.sleep(500);
		    }
	 public void Description(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_r_desc", text);
			Reporter.log(text +": is Entered in the Description Input field.");
			Thread.sleep(500);
			}
	 public void Scheme_base_path(String text) throws IOException, InterruptedException {	
		 events eve=new events(driver);
		 eve.DropDown_list("api_r_scheme", text);
		     }
	 public void Host(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_r_Host", text);       //Refresh Period
			Reporter.log(text+" : is Entered in Host Input Field.");
			Thread.sleep(500);
		    }
	 public void Path(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_r_path", text);       //Refresh Period
			Reporter.log(text+" : is Entered in Path Input Field.");
			Thread.sleep(500);
		    }
	public void User_name_Authentication(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_r_uname_auth", text);
			System.out.println(text+" is entered in the Authentication:User Name input field");
			Reporter.log(text+" is entered in the Authentication:User Name input field");
			Thread.sleep(1000);
	       }
	public void Password_Authentication(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_r_pwd_auth", text);
		System.out.println(text+" is entered in the Authentication:Password input field");
		Reporter.log(text+" is entered in the Authentication:Password input field");
		Thread.sleep(1000);
       }
	public void Password_Check_Authentication(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_r_cpwd_auth", text);
		System.out.println(text+" is entered in the Authentication:Check Password input field");
		Reporter.log(text+" is entered in the Authentication:Check Password input field");
		Thread.sleep(1000);
       }
	public void Access_Token(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_os_acc_token", text);
		System.out.println(text+" is entered in the Access Token input field");
		Reporter.log(text+" is entered in the Access Token input field");
		Thread.sleep(1000);
       }
	public void Refresh_Token(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_os_ref_token", text);
		System.out.println(text+" is entered in the Access Token input field");
		Reporter.log(text+" is entered in the Access Token input field");
		Thread.sleep(1000);
       }
	public void Refresh_Icon() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_refresh_icon");
		System.out.println("Refresh Icon is clicked");
		Reporter.log("Refresh Icon is clicked");
		Thread.sleep(1000);
       }
	public void Save_Outbound_settings() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("Save_Panal_Changes");
		System.out.println("Save Icon is clicked");
		Reporter.log("Save Icon is clicked");
		Thread.sleep(1000);
       }
	public void List_of_API_Resources_table(String ePath, String name, String ipaddr) throws IOException, InterruptedException {	
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
				String msg = eve.GetText("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				System.out.println("Notification Message is: "+msg);
				Reporter.log("Notification Message is: "+msg);
				Thread.sleep(1500);
			}else{
				System.out.println("No notification Found");
				Thread.sleep(1500);
			}
	       }
	 public void Render_Notifications() {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				Reporter.log("Notificatio: ----------------------------------------");
				eve.GetText_event("TC_Notification_Message");
				try {
					eve.Click_event("TC_Notification_No_button");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Reporter.log("-----------------------------------------------------");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		    } 
	
}
