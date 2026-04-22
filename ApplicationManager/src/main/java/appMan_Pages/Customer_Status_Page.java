package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Customer_Status_Page {
	Common c = new Common();
	final WebDriver driver;

	public Customer_Status_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Customer_status_page() throws IOException,InterruptedException {
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		Home_index_Page HI_page = new Home_index_Page(driver);
		
		/*HI_page.Select_Functional_Configration_Tab(); 
		Thread.sleep(2500);
		FC_page.Click_on_tables_tab();
		Thread.sleep(1500);*/
		 
		FC_page.Click_on_Customer_Status_tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
	}

	public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Clicked on Create Icon.");
	}

	public void Update_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Clicked on Change icon");
	}

	public void Delete_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("delete_user");
		Reporter.log("Delete button is Clicked.");
	}

	public void Customer_Status_name(String path, String text)
			throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
	}

	public void link() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
		eve.Click_event_javaScript(ele);
		Reporter.log("link Button Is Clicked.");
	}

	public void Unlink() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver
				.findElement(By.xpath(c.getElementName("Unlink")));
		eve.Click_event_javaScript(ele);
		Reporter.log("Unlink button is Clicked.");
	}

	public void Save_changes() throws IOException {
		events ev = new events(driver);
		ev.Click_eventBy_ClassName("saveMain");
	}

	public void Save_and_Close() throws IOException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("saveClose");
		Reporter.log("Save and Close button  is Clicked.");

	}

	public void Save_as_New() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("PS_Save_As_new");
		Reporter.log("Save as New button is Clicked.");

	}

	public void Cancel() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("PS_Cancel");
		Reporter.log("Cancel Button is Clicked.");
	}

	public void Reload() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("PS_refresh");
		Reporter.log("Reload Button is Clicked.");
	}

	public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("PS_Save");
		Reporter.log("Save Button is Clicked.");
	}

	public void Notifications() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			Reporter.log("Notifications: --------------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("-----------------------------------------------------------");
		} else {
			System.out.println("No notification Found");
		}
	}
}
