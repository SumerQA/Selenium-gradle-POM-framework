package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;


public class Users_Page{
	Common c = new Common();
	final WebDriver driver;
	public  Users_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Clickon_Users_Tab() throws IOException, InterruptedException {                                //Will Click on Uses tab under User manager
		events eve = new events(driver);
	  	eve.Click_event("Users_tab");
	  	Reporter.log("Users Tab is Clicked");
	  	Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	}
	    }
	
	 public void Open_Create_NewUser_panal() throws IOException, InterruptedException {	                   //Click and Open the Create New User Panal 
		events eve = new events(driver);
	  	eve.Click_event("Create_NewUser_panal");
	  	Reporter.log("Create Icon is Clicked");
	    }
	
	 public void Select_Usergroup_to_Link(String compTest, String ePath,String SorttablePath) throws IOException, InterruptedException {  //Will get the table cells data and click on particular cell
		events eve = new events(driver);
		eve.Click_event(SorttablePath);
		Thread.sleep(1000);
	  	eve.Table_event(compTest, ePath);
		}
	 public void Click_On_Change_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("Change_Existing_User");
		Reporter.log("Change Icon is Clicked");
	    }
	
	 public void link_User_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
	  	eve.Click_event("Link");
		Reporter.log("Link Icon is Clicked");
	    }
	
	 public void Unlink_User_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("Unlink");
		Reporter.log("Unlink Icon is Clicked");
	    }
	
	
	 public void Click_Active_Inactive_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
	  	eve.Click_event("status");
	    }
	
	 public void Delete_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
	  	eve.Click_event("delete_user");
		Reporter.log("Delete Icon is Clicked");
	    }
	 public void Save_All_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("Save_Panal_Changes");
	    }
	 public void refresh_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("refresh");
	    }
	 
	public Create_User UsersTab() throws IOException, InterruptedException {	
		 Clickon_Users_Tab();
		 Click_On_Change_icon();
		 return PageFactory.initElements(driver, Create_User.class);
		 }
	 
	 public void Notification() throws IOException, InterruptedException {
	     events eve = new events(driver);
	    // mgr.fluentWait(By.xpath(c.getElementName("Save_changes_notification_Message")));
		    if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
			    eve.GetText_event("Save_changes_notification_Message");
			    eve.Click_event("Save_changes_notification_OK_button");
		   }else{
			   System.out.println("No notification Found");
		        }
	}
	 
	 public void Enter_UserGroups_Name(String uname) throws IOException {	
		events eve = new events(driver);
		eve.SendKey_event("usergroupsName", uname);
		Reporter.log(uname+ " is Entered in UserGroup Name Field");
	    }
	
	 public void Select_Role() throws IOException {	
		events eve = new events(driver);
		eve.DropDown_list_event("role", "Third Template");
	    }
	
	 public void Dashboard() throws IOException {	
		events eve = new events(driver);
		eve.DropDown_list_event("dashboard", " ");
	    }
	
	 public void DisputeManager_Checkbox(String text) throws IOException, InterruptedException {	
		events eve = new events(driver);
		if(text.equals("Yes")){
			if(driver.findElement(By.xpath(c.getElementName("disputeManager_checkbox"))).isSelected()){
				System.out.println("Checkbox already selected");
			}else{
				eve.Click_event("disputeManager_checkbox");
			}
		}else{
			if(driver.findElement(By.xpath(c.getElementName("disputeManager_checkbox"))).isSelected()){
				eve.Click_event("disputeManager_checkbox");
			}else{
				System.out.println("Checkbox alredy unchecked");
			}
		}
	    }
	 public void Allow_UG_toManage_Req_Checkbox(String text) throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Check_box_JS("AllowManageRequests",text);
		    }
	 public boolean Allow_UG_toManage_Req_Checkbox_reslt(String id) throws IOException, InterruptedException {
		 Object bool = ((JavascriptExecutor) driver)
					.executeScript("var chkBox = document.getElementById(" + "'"
							+ id + "'" + ");" + "  if (chkBox.checked) {"
							+ "  return true  ;" + "  }" + " else{"
							+ " return false;" + "}");
			boolean checkboxStatus = (Boolean) bool;
			if (checkboxStatus) {
					return true;
				} else {
					return false;
				}
	 }
	 public void Reload_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("reload");
		Reporter.log("Reload Icon is Clicked");
	    }
	
	 public void Save_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("save_UG_icon");
		Reporter.log("Save Icon is Clicked");
	    }
	
	 public void Save_and_New_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("save&New_UG_icon");
		Reporter.log("Save as New Icon is Clicked");
	    }
	
	 public void Save_and_Close_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("save_close_UG_icon");
		Reporter.log("Sane and Close Icon is Clicked");
	    }
	
	 public void Close() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("close_icon");
		Reporter.log("Close Icon is Clicked");
	    }
	
	 }