package appMan_Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Collection_interface_Page {
	// WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;

	public Collection_interface_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Collection_interface_page() throws IOException,
			InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*
		 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(1500);
		 */
		Functional_Configration_Page FC_page = new Functional_Configration_Page(
				driver);
		FC_page.Click_Collection_Interface_tab();
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
		Reporter.log("Delete Icon is Clicked.");
	}

	public void Collection_Interface_tab(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Collection Interface Tab is Clicked.");
	}

	public void Name(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text + " : is Entered in the Name input field.");

	}

	public void Select_Export_File(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);
	}

	public void Select_Default_letter(String path, String text)
			throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);
	}

	public void Print() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('Print').click();");
	}

	public void Email() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('Email').click();");

	}

	public void Email_Settings(String path, String to_path, String cc_path,
			String bcc_path, String subject_path, String to_text,
			String cc_text, String bcc_text, String subject_Text)
			throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path); // Email Settings tab
		eve.SendKey_event(to_path, to_text);
		eve.SendKey_event(cc_path, cc_text);
		eve.SendKey_event(bcc_path, bcc_text);
		eve.SendKey_event(subject_path, subject_Text);
	}

	public void Export_to(String val, String IFpath, String text)
			throws IOException {
		events eve = new events(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (val.equals("Yes")) {
			js.executeScript("document.getElementById('Export').click();");
			eve.SendKey_event(IFpath, text);
		}
	}

	public void Include_Customer_Notes(String val) throws IOException {
		events ev = new events(driver);
		ev.Check_box_JS("IncludeCustomerNotes", val);
	}

	public void Include_Invoice_Notes(String val1) throws IOException {
		events ev = new events(driver);
		ev.Check_box_JS("IncludeInvoiceNotes", val1);
	}

	public void Include_Dunning_letters_sent(String text) throws IOException {
		events ev = new events(driver);
		ev.Check_box_JS("IncludeSentLetters", text);
	}

	public void Include_Email_sent(String val) throws IOException {
		events ev = new events(driver);
		ev.Check_box_JS("IncludeSentMails", val);
	}

	public void Include_SMS_sent(String val) throws IOException {
		events ev = new events(driver);
		ev.Check_box_JS("IncludeSentSMSs", val);
	}

	public void Start_date(String id, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_JS(id, text);

	}

	public void Refresh() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("RE_Refresh");
		Reporter.log("Reload button is clicked.");

	}

	public void Reload() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("refresh");
		Reporter.log("Reload button is clicked.");
	}

	public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("RE_Save");
		Reporter.log("Save button is clicked.");
	}

	public void Save_Panal() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Save_IM_changes");
		Reporter.log("Save button is clicked.");

	}

	public void Close() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("RE_cancel");
		Reporter.log("Cancel button is clicked.");

	}

	public void Save_as_New() throws IOException, InterruptedException {
		events eve = new events(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		eve.Click_event("RE_Save_as_New");
		Reporter.log("Save as New Button is clicked");
	}

	public void Save_and_Close() throws IOException {
		events eve = new events(driver);
		WebElement Ele = driver.findElement(By.xpath(c
				.getElementName("RE_Save_and_Close")));
		eve.Click_event_javaScript(Ele);

	}

	public void Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver
				.findElement(
						By.xpath(c
								.getElementName("Save_changes_notification_Message")))
				.isDisplayed()) {
			Reporter.log("Notifications: ------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("---------------------------------------------------");
		} else {
			System.out.println("No notification Found");
		}

	}

	public void NO_Notification_button() throws IOException,
			InterruptedException {
		events eve = new events(driver);
		if (driver
				.findElement(
						By.xpath(c
								.getElementName("Save_changes_notification_Message")))
				.isDisplayed()) {
			Reporter.log("Notifications: ------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_NO_button");
			Reporter.log("---------------------------------------------------");
		} else {
			System.out.println("No notification Found");
		}
	}
	 public void RenderNotification() throws IOException, InterruptedException {
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("TC_Notification_Message"))).isDisplayed()){
				eve.GetText_event("TC_Notification_Message");
				eve.Click_event("TC_Notification_Yes_button");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			}else{
				System.out.println("No notification Found");
			}
			}

	public void link() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
		eve.Click_event_javaScript(ele);
		Reporter.log("Link Button is Clicked.");
	}

	public void Unlink() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver
				.findElement(By.xpath(c.getElementName("Unlink")));
		eve.Click_event_javaScript(ele);
		Reporter.log("Unlink Button is Clicked.");
	}
}
