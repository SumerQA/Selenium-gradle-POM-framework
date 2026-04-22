package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Dispute_Action_Page {
	Common c = new Common();
	final WebDriver driver;

	public Dispute_Action_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Dispute_Action_page() throws IOException,
			InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*
		 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(500);
		 */
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Disputes_tab();
		Thread.sleep(500);
		FC_page.Click_Dispute_Action_tab();
		Thread.sleep(500);
		HI_page.Render_Notifications();
	}

	public void Refresh() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("refresh");
		Reporter.log("reload button is Clicked.");
	}

	public void SaveAll_Changes() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Save_IM_changes");
		Reporter.log("Save button is Clicked.");
	}

	public void Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			Reporter.log("Notifications:--------------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("----------------------------------------------------------");
		} else {
			System.out.println("No notification Found");
		}
	}

	public void link() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
		eve.Click_event_javaScript(ele);
		Reporter.log("link button is Clicked.");
	}

	public void Unlink() throws IOException {
		events eve = new events(driver);
		WebElement ele = driver
				.findElement(By.xpath(c.getElementName("Unlink")));
		eve.Click_event_javaScript(ele);
		Reporter.log("Unlink button is Clicked.");
	}
}
