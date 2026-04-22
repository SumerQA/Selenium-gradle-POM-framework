package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Configration_Files.WebDriverManager;
import Event_commands.events;

public class Client_Settings_page {
	WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;

	public Client_Settings_page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Client_Settings_Page() throws IOException,InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*
		 * HI_page.Select_Technical_Configration_Tab();
		 * System.out.println("Technical Configration tab is clicked");
		 */
		Technical_Configration_page TC_page = new Technical_Configration_page(driver);
		TC_page.Client_Settings_Tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
		System.out.println("Client Settings tab is clicked");
		Reporter.log("Client Settings tab is clicked");
	}

	public void Clickon_Change_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		System.out.println("Change button is Clicked");
		Reporter.log("Change button is Clicked");
	}

	public void Window_AuthMode() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Win_auth_mode");
	}

	public void Forms_AuthMode() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_form_auth_mode");
	}

	public void Autometically_create_newUSer(String text, String DDtext)
			throws IOException {
		events eve = new events(driver);
		Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById('AutomaticallyCreateNewUser');"	+ "  if (chkBox.checked) {"	+ "  return true  ;"+ "  }" + " else{" + " return false;" + "}");
		boolean checkboxStatus = (Boolean) bool;
		if (text.equals("Yes")) {
			if (checkboxStatus) {
				eve.DropDown_list_event("CS_Default_UGroup", DDtext);

			} else {
				((JavascriptExecutor) driver).executeScript("document.getElementById('AutomaticallyCreateNewUser').click();");
				eve.DropDown_list_event("CS_Default_UGroup", DDtext);
			}
		} else {
			if (checkboxStatus) {
				((JavascriptExecutor) driver).executeScript("document.getElementById('AutomaticallyCreateNewUser').click();");
			} else {
				System.out.println("Checkbox is unchecked already");
				Reporter.log("Checkbox is unchecked already");
			}
		}

	}

	public void Default_Usergroup() throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event("CS_Default_UGroup", "Test");
		System.out.println("Item Selected from DDlist");
	}

	public void Attachment_location(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_attachment_loc", text);
		Reporter.log(text+ " : is Entered in the Attachment Location Input field.");
	}

	public void Export_location(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_Exp_loc", text);
		Reporter.log(text+ " : is Entered in the Export Location Input field.");
	}
	public void Reset_picklist_Cache_button() throws IOException,InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Reset_picklist_Cache_button");
		System.out.println("Reset picklist Cache button is Clicked");
	}

	public void Reset_EF_Mode_button() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Reset_EF_mode_button");
		System.out.println("Reset EF Mode button is Clicked");
	}

	public void Save_Client_Settings_Changes() throws IOException,InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Save_Panal_Changes");
		Reporter.log("Save Button is clicked");
	}

	public void Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			Reporter.log("Notifications : ----------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("--------------------------------------------------");
		} else {
			System.out.println("No notification Found");
		}
	}

	public void Refresh_ClientSettings_Changes() throws IOException,InterruptedException {
		events eve = new events(driver);
		eve.Click_event("refresh");
		System.out.println("Refreshed Client Settings Page");
	}

}
