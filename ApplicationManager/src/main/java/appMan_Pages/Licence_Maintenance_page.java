package appMan_Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Event_commands.events;
public class Licence_Maintenance_page {
	Common c = new Common();	 
	final WebDriver driver;
	
	public  Licence_Maintenance_page(WebDriver driver)
	{   
		this.driver = driver;
	}
	@Test
	 public void Goto_Licence_Maintenance_Page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		HI_page.Select_Technical_Configration_Tab();
		Thread.sleep(2000);
		System.out.println("Technical Configration tab is clicked");
		Reporter.log("Technical Configration tab is clicked");
		Technical_Configration_page TC_page = new Technical_Configration_page(driver);
		TC_page.Licence_Maintenance_Tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
		System.out.println("licence maintenance tab is clicked");
	    }
	@Test
	 public void Enter_Licence_Name(String text) throws IOException {	
		events eve=new events(driver);
		eve.SendKey_event("lic_name", text);
	    }
	@Test
	 public void Enter_Licence_No(String text,String text2,String text3) throws IOException {	
		events eve=new events(driver);
		eve.SendKey_event("lic_no_1", text);	
		eve.SendKey_event("lic_no_2", text2);	
		eve.SendKey_event("lic_no_3", text3);
		Reporter.log(text + ","+ text2 +"," +text3+ ","+ ": is Entered in the Licence Number input fields");
	    }
	@Test
	 public void Upload_Licence_File_Location(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		File templete_file = new File("src");
		eve.Click_event("browse_Lic_file");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String filepath =  templete_file.getAbsolutePath()+"\\test\\resources\\Templates\\Licesce\\"+text;
		File file= new File("src");
		//eve.Upload_File_event(file.getAbsolutePath()+"\\upload.exe", "file:///"+filepath);
		eve.Upload_File_event(file.getAbsolutePath()+"\\test\\resources\\Datafiles\\Autoit_Script\\upload.exe", "file:///"+filepath);
		
		System.out.println(filepath+"  :Licence File Uploaded Successfully");
		Thread.sleep(2000);
		System.out.println("Licence File Uploaded Successfully");
		Reporter.log(text+ ": Licence File Uploaded Successfully");
        }
	@Test
	 public void Save_Licence_Changes() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("Save_Panal_Changes");
		System.out.println("licence Changes Done successfully");
        Reporter.log("licence Changes Done successfully");
       }
	@Test
	 public void Refresh_Licence_Changes() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("refresh");
		System.out.println("Refreshed the licence Page");
		Reporter.log("Refreshed the licence Page");
      }
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification: -----------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("--------------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
	 }
}
