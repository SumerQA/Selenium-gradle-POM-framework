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

public class General_Profile_Page {
	Common c = new Common();
	final WebDriver driver;
	public  General_Profile_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_General_profile_DDlist() throws IOException {	
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.general_profile();
		Reporter.log("General Profile DDlist is Clicked.");
		
	    }
	 public void General_profile_items(String path) throws IOException, InterruptedException {
		 events eve = new events(driver);
	     eve.Click_event(path);
		
			}
	 public void About() throws IOException, InterruptedException {
	     WebElement element= driver.findElement(By.xpath(c.getElementName("Get_AboutText")));
			List<WebElement> rows=element.findElements(By.tagName("div"));
			System.out.println("***********************************************");
			Reporter.log("***********************************************");
			for(int rownum = 0; rownum <(rows.size())-9; rownum++) {
						int rowno= rownum+1;
						String label = driver.findElement(By.xpath(c.getElementName("Get_AboutText")+"/div["+rowno+"]/label")).getText();
						String value = driver.findElement(By.xpath(c.getElementName("Get_AboutText")+"/div["+rowno+"]/div")).getText();
						System.out.println(label  +"  -   " + value);
						Reporter.log(label  +"  -   " + value);
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						}
			 events eve = new events(driver);
		     eve.Click_event("OK_About_button");
		     Reporter.log("***********************************************");
			System.out.println("***********************************************");
		 }
	 public void OK_About() throws IOException, InterruptedException {
	     events eve = new events(driver);
	     eve.Click_event("OK_About_button");
	     Reporter.log("Ok button is clicked");
		 }
	 public void to(String text) throws IOException {
	     events eve = new events(driver);
	     eve.SendKey_event("SC_to", text);
	     Reporter.log(text +" : is Entered in the 'to' input field.");
		 }
	 public void CC(String text) throws IOException {
	     events eve = new events(driver);
	     eve.SendKey_event("SC_cc", text);
	     Reporter.log(text +" : is Entered in the 'CC' input field.");
		 }
	 public void BCC(String text) throws IOException {
	     events eve = new events(driver);
	     eve.SendKey_event("SC_bcc", text);
	     Reporter.log(text +" : is Entered in the 'BCC' input field.");
		 }
	 public void Subject(String text) throws IOException {
	     events eve = new events(driver);
	     eve.SendKey_event("SC_subject", text);
	     Reporter.log(text +" : is Entered in the 'Subject' input field.");
		 }
	 public void Body(String text) throws IOException {
	     events eve = new events(driver);
	     eve.SendKey_event("SC_body", text);
	     Reporter.log(text +" : is Entered in the 'Body' input field.");
		 }
	 public void Add_Attachment(String Scriptpath,String uploadpath) throws IOException, InterruptedException {
	     events eve = new events(driver);
	     eve.Click_event("BC_Add_attachment");
	     eve.Upload_File_event(Scriptpath, uploadpath);
		 }
	 public void Attachments() throws IOException, InterruptedException {
		 WebElement element= driver.findElement(By.xpath(c.getElementName("BC_Attachment")));
			List<WebElement> rows=element.findElements(By.tagName("Span"));
			System.out.println(rows.size());
			for(int rownum = 0; rownum <rows.size()-1; rownum++) {
				for(WebElement ele:rows){
						int rowno= rownum+1;
						System.out.println(ele.getText());
						driver.findElement(By.xpath(c.getElementName("BC_Attachment")+"/Span["+rowno+"]")).click();
						 events eve = new events(driver);
					     eve.Click_event("BC_Delete_attachment");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						}
			}
		 }
	 public void Send() throws IOException, InterruptedException {
	     events eve = new events(driver);
	     eve.Click_event("BC_Send");
	     Reporter.log("Send button is Clicked");
	     Thread.sleep(3000);
		 }
	 public void Cancel() throws IOException, InterruptedException {
	     events eve = new events(driver);
	     eve.Click_event("BC_Cancel");
	     Reporter.log("Cancel button is Clicked");
		 }
	 public void Read_Error_Log() throws IOException, InterruptedException {
	     events eve = new events(driver);
	     eve.GetText_event("BC_error_log");
	     eve.Click_event("BC_error_log_OK_button");
		 }
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification:---------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("----------------------------------------------");
			}else{
				System.out.println("No notification Found");
			}
		    }
	}


