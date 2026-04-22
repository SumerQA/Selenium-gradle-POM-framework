package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;
public class Security_Page {
	Common c = new Common();
	String user= "Albert Mr";
	static String s; 
	static String s1; 
	final WebDriver driver;
	public  Security_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Open_Security_Tab() throws IOException , InterruptedException{	
	//   Home_index_Page HI_page = new Home_index_Page(driver);
		events eve = new events(driver);
		eve.Click_event("Security_tab");
		Reporter.log("Security tab is Clicked");
		Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
		//HI_page.Render_Notifications();
	    }
	
	 public void Unlock_User_Icon() throws IOException, InterruptedException{	                   //Click and Open the Create New User Panal 
		events eve = new events(driver);
		eve.Click_event("unlock_user");
		Reporter.log("Unlock Icon is Clicked");
	    }
	
	 public void lock_User_Icon() throws IOException, InterruptedException {	                   //Click and Open the Create New User Panal 
		events eve = new events(driver);
		eve.Click_event("lock_user");
		Reporter.log("lock Icon is Clicked");
	    }
	
	 public void Enable_Password_checkbox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("Enabled", text);
	    }
	
	 public void validity_password(String val) throws IOException {
		events eve= new events(driver);
		eve.SendKey_JS("ExpireDays", val);
	    }
	
	 public void last_n_password_cannot_be_used(String val) throws IOException {
		events eve= new events(driver);
		eve.SendKey_JS("NotLastPasswords", val);
	    }
	
	 public void User_blocked_after_n_attempt(String val) throws IOException {
		events eve= new events(driver);
		eve.SendKey_JS("LockAfter", val);
	    }
	
	 public void Strong_password(String text) throws IOException {	                   //Click and Open the Create New User Panal 
		events eve = new events(driver);
		eve.Check_box_JS("StrongPassword", text);
	    }
	
	 public void Minimum_length_password(String val) throws IOException {	
		events eve= new events(driver);
		eve.SendKey_JS("MinChars", val);
	    }
	
	 public void Check_Password_Length(String val) throws IOException, InterruptedException {	
		 Users_Page usr= PageFactory.initElements(driver, Users_Page.class);
		 Create_User OG_CU1= PageFactory.initElements(driver, Create_User.class);
		 usr.Clickon_Users_Tab();
		 Thread.sleep(5000);
		 Reporter.log("Users Tab is clicked Successfully");
		 usr.Select_Usergroup_to_Link(user,"Users_table","sort_users_table");
		 Thread.sleep(1000);
		 usr.Click_On_Change_icon();
		 Thread.sleep(1000);
		 OG_CU1.Enter_LoginPassword(val);
		 OG_CU1.Enter_Confirm_Password(val);
		 OG_CU1.Select_Save_n_Close();
		 Thread.sleep(2000);
		 OG_CU1.Notification();
		 OG_CU1.Close();
		 Thread.sleep(1500);
		 OG_CU1.Notification();
	    }
	
	
	 public void Maximum_length_password(String val) throws IOException {	
		events eve= new events(driver);
		eve.SendKey_JS("MaxChars", val);
	    }
	
	 public void Exception_tab() throws IOException, InterruptedException{
		events eve = new events(driver);
		eve.Click_event("Exceptions_tab");
	    }
	 public void overview_tab() throws IOException, InterruptedException{
			events eve = new events(driver);
			eve.Click_event("Overview_tab");
		    }
	
	 public void sort_exceotion_table() throws IOException, InterruptedException{
		events eve = new events(driver);
		eve.Click_event("sort_exception_table");
	    }
	
	 public void Lock_Unlock_table(String compTest, String ePath,String ePath1) throws IOException {  //Will get the table cells data and click on particular cell
		events eve = new events(driver);
		eve.Table_event_With_Pagination(compTest, ePath,ePath1);
		}
	
	 public void Save_All_Changes_Notifications() throws IOException , InterruptedException{
			 events eve = new events(driver);
			     if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
			    	 Reporter.log("--------------Notification---------------");
				       eve.GetText_event("Save_changes_notification_Message");
				       eve.Click_event("Save_changes_notification_OK_button");
				     Reporter.log("-----------------------------------------");
			   }else{
				      System.out.println("No notification Found");
		      }
		     
	}
	
	public void Cancel_Changes_Notifications() throws IOException , InterruptedException{
			 events eve = new events(driver);
		     if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
		    	 Reporter.log("--------------Notification---------------");
			       eve.GetText_event("TC_Notification_Message");
			       eve.Click_event("TC_Notification_No_button");
			     Reporter.log("-----------------------------------------");
		   }else{
			      System.out.println("No notification Found");
		      }
	}
	
	public void Render_Usermanager_to_IndexPage() throws IOException , InterruptedException{	                 
		Home_index_Page hi= new Home_index_Page(driver);
		hi.UserManager_Index();
		System.out.println("Rendered back to Home Index page");
		
	   }
	
	
	public String Mini_length_Password(String len) {
		int num = Integer.parseInt(len);
		StringBuffer sb = new StringBuffer(10); 
		for(int i=1;i<=num-1;i++){
			s = sb.append("a").toString(); 
			} 
		//System.out.println(s);
		return s; 
		}

	public String Maxi_length_Password(String len) {
		int num = Integer.parseInt(len);
		
		StringBuffer sb = new StringBuffer(100); 
		for(int i=1;i<= num+1;i++){
			s1 = sb.append("a").toString(); 
			} 
		//System.out.println(s1);
		return s1; 
		}
	
	
	
}
