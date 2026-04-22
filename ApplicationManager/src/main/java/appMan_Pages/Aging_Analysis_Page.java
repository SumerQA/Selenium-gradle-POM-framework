package appMan_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Configration_Files.WebDriverManager;
import Event_commands.events;

public class Aging_Analysis_Page {
	WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;

	public Aging_Analysis_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Aging_Analysis_page() throws IOException,InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*
		 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(1000);
		 * Thread.sleep(1500);
		 */
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Aging_Analysis_tab();
		Thread.sleep(500);
		HI_page.Render_Notifications();
	}

	public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create Icon is Clicked.");
	}

	public void Update_Aging_Analysis_icon() throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
		Reporter.log("Generate ranges button is Clicked.");
	}

	public void Delete_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("delete_user");
		Reporter.log("Delete button is Clicked.");
	}

	public void Aging_Analysis_name(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text+ " : is Entered in the Aging Analysis name input field.");
	}

	public void Include_Credit_nots(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.Checkbox(path, text);
		;
	}

	public void Include_blocked_invoices(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.Checkbox(path, text);
		;
	}

	public void Calculate_from(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);
	}

	public void Aging_analysis_type(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);
	}

	public void Columns(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text + " : is Entered in the Column input field. ");

	}

	public void Start_At(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text + " : is Entered in the Start At input field. ");
	}

	public void Interval(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Reporter.log(text + " : is Entered in the Interval input field. ");
	}

	public void Generate_range_Button(String path) throws IOException,InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Generate ranges button is Clicked.");
	}

	public void Add_range_icon(String path) throws IOException,InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Add ranges button is Clicked.");
	}

	public void Add_range_Table(String path, String a, String b) throws IOException, InterruptedException {
		WebElement element = driver.findElement(By.xpath(c.getElementName(path)));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				if (columns.get(colnum).getText().equals("0")) {
					int rowno = rownum + 1;
					// driver.findElement(By.xpath("//*[@id='grid_bucket']/div[3]/table/tbody/tr["+rowno+"]/td[1]")).click();
					driver.findElement(By.xpath("//*[@id='grid_bucket']/div[3]/table/tbody/tr["+ rowno + "]/td[1]/span[1]/span/input[2]")).clear();
					Thread.sleep(500);
					driver.findElement(By.cssSelector("input[type='text'][tabindex='0']")).sendKeys(a);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='grid_bucket']/div[3]/table/tbody/tr["	+ rowno + "]/td[2]")).click();
					Thread.sleep(1000);
					driver.findElement(By.cssSelector("//input[@name='IntervalEnd']")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//*[@id='grid_bucket']/div[3]/table/tbody/tr["	+ rowno + "]/td[2]")).click();
					Thread.sleep(800);
					driver.findElement(By.cssSelector("tbody tr:nth-child(8) td:nth-child(2)")).sendKeys(b);
					Thread.sleep(2000);
					break;
				}
			}

		}
		// System.out.println("Usergroup is selected for linking with New User");
	}

	public void Delete_range_icon(String path) throws IOException,InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Delete ranges button is Clicked.");
	}

	public void Refresh() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("refresh");
		Reporter.log("Reload button is Clicked.");

	}

	public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("saveMain");
		// eve.Click_event("Save_IM_changes");
		Reporter.log("Save button is Clicked.");
	}

	public void Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
		} else {
			System.out.println("No notification Found");
		}
	}

	public void Cancel_Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_NO_button");
		} else {
			System.out.println("No notification Found");
		}
	}
}
