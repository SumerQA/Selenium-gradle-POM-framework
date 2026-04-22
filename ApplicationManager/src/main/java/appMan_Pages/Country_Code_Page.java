package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Country_Code_Page {
	// WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;

	public Country_Code_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Country_Code_page() throws IOException,
			InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*
		 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(1500);
		 */
		Functional_Configration_Page FC_page = new Functional_Configration_Page(
				driver);
		/*
		 * FC_page.Click_on_tables_tab(); Thread.sleep(1500)
		 */;
		FC_page.Click_on_Country_Code_tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
	}

	public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create Icon is Clicked.");
	}

	public void Update_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Update Icon is Clicked.");
	}

	public void Delete_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("delete_user");
	}

	public void Country_Code_table_name(String path, String text)
			throws IOException {
		// ((JavascriptExecutor)
		// driver).executeScript("document.getElementById('CountryCodesId').remove();");
		((JavascriptExecutor) driver)
				.executeScript("document.getElementById('CountryCodesName').value="
						+ "'" + text + "'" + ";");
		Reporter.log(text + " : is Entered in the Input field.");
	}

	public void Create_new_Code_icon() throws IOException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("img_ccsadd");
		Reporter.log("Create Button is Clicked.");
	}

	public void Update_new_Code_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("cc_code_des_Update");
		Reporter.log("Update Icon is Clicked.");
	}

	public void Delete_new_Code_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("img_ccsdelete");
		// eve.Click_event("cc_code_des_delete");
		Reporter.log("Delete Icon is Clicked.");
	}

	public void Code_Input(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text + ": entered in the Code Input Field.");
	}

	public void Description_Input(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text + ": entered in the Description Input Field.");
	}

	public void link() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
		eve.Click_event_javaScript(ele);
		Reporter.log("Link Icon is Clicked.");
	}

	public void Unlink() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver
				.findElement(By.xpath(c.getElementName("Unlink")));
		eve.Click_event_javaScript(ele);
		Reporter.log("Unlink Icon is Clicked.");
	}

	public void Save() throws IOException, InterruptedException {
		events ev = new events(driver);
		ev.Click_eventBy_ClassName("save_img");
		Reporter.log("Save Icon is Clicked.");
	}

	public void Save_as_New() throws IOException, InterruptedException {
		events ev = new events(driver);
		ev.Click_event("PS_Save_As_new");
		Reporter.log("Save as New Icon is Clicked.");
	}

	public void Save_and_Close() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("saveclose_img");
		// eve.Click_event("RC_save_and_Close");
		Reporter.log("Save and Close Button is Clicked.");

	}

	public void Cancel() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("close_img");
		// eve.Click_event("PS_Cancel");
		Reporter.log("Cancel Button is Clicked.");

	}

	public void Reload() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("PS_refresh");
		Reporter.log("Reload Button is Clicked.");

	}

	public void Notifications() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver
				.findElement(
						By.xpath(c
								.getElementName("Save_changes_notification_Message")))
				.isDisplayed()) {
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
		} else {
			System.out.println("No notification Found");
		}
	}

	public void Cancel_Notifications() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver
				.findElement(
						By.xpath(c
								.getElementName("Save_changes_notification_Message")))
				.isDisplayed()) {
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_NO_button");
		} else {
			System.out.println("No notification Found");
		}
	}

	public void Save_changes() throws IOException {
		events ev = new events(driver);
		ev.Click_eventBy_ClassName("saveMain");
	}
}
