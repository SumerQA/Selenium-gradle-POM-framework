package appMan_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.WebDriverManager;
import Event_commands.events;


public class Administrator_Page {
	WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;

	public Administrator_Page(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void goto_Administrations_panal() throws IOException,InterruptedException {
		Home_index_Page hom = PageFactory.initElements(driver,Home_index_Page.class);
		Functional_Configration_Page FC_page = PageFactory.initElements(driver,Functional_Configration_Page.class);
		hom.Select_Functional_Configration_Tab();
		Thread.sleep(1500);
		FC_page.Clickon_Administration_tab();
		Thread.sleep(500);
		hom.Render_Notifications();
	}

	@Test
	public void Enter_Administrator_Name(String Admin_name) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("create_admin", Admin_name);
	}

	@Test
	public void Check_Active_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("IsActive", text);
	}

	@Test
	public void Check_Maintain_contacts_via_import_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_12", text);
	}

	@Test
	public void Check_Maintain_Address_via_import_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_13", text);
	}

	@Test
	public void Check_Address1_mustbe_Entered_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_17", text);
	}

	@Test
	public void Check_AlwaysUse_Customer_Dunning_lang_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_9", text);
	}

	@Test
	public void Check_Customer_number_numeric_CheckBox(String text)	throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_1", text);
	}

	@Test
	public void Check_Invoice_number_numeric_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_2", text);
	}

	@Test
	public void Check_DueDateToday_isnot_overdue_CheckBox(String text)throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_21", text);
	}

	@Test
	public void Check_Monitoring_Relatedto_DueDate_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_3", text);
	}

	@Test
	public void Check_Amaximum_of_1dispute_per_invoice_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_15", text);
	}

	@Test
	public void Check_CustomerGroup_applyMyProfile_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_19", text);
	}

	@Test
	public void Check_CustomerGroup_NoInheriting_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_18", text);
	}

	@Test
	public void Check_Display_Import_SourceIn_TreeCheckBox(String text)	throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_16", text);
	}

	@Test
	public void Check_Send_letter_as_PDF_CheckBox(String text) throws IOException {
		events eve = new events(driver);
		eve.Check_box_JS("chk_26", text);
	}

	@Test
	public void Select_DSO_Calculation(String text) throws IOException,InterruptedException {
		events eve = new events(driver);
		if (text.equals("1")) {
			eve.Click_event("DSO_salesWeight");
			Reporter.log("First Radio Button is selected");
		} else {
			eve.Click_event("DSO_Countback");
			Reporter.log("Second Radio Button is selected");
		}
	}

	@Test
	public void Enter_Standard_Printer(String Stand_printer) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("Stand_Printer", Stand_printer);
	}

	@Test
	public void Select_Invoice_reference(String Inv_ref) throws IOException {
		try {
			events eve = new events(driver);
			eve.DropDown_list_event("Invoice_reference", Inv_ref);
		} catch (Exception e) {
			// TODO: handle exception
			throw new ElementNotInteractableException(Inv_ref+ ": Not found in the DDList");
		}

	}

	public void save() throws InterruptedException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("saveMain");

	}

	public void Create_icon() throws InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Reporter.log("Create Icon is clicked");

	}

	public void Change_icon() throws InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
	}

	public void Delete_Admin(String compTest, String ePath) throws IOException { // Will  get the table cells data and click on particular cell
		WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		labrow: 
			for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				List<WebElement> tag1 = rows.get(rownum).findElements(By.tagName("img"));
				for (int tag1s = 0; tag1s < tag1.size(); tag1s++) {
					int rowno = rownum + 1;
					System.out.println(columns.get(colnum).getText());
					if (driver.findElement(By.xpath("//*[@id='grid_Admins']/div[2]/table/tbody/tr["+ rowno + "]/td[3]/img")).getAttribute("title").equals(compTest)) {
						driver.findElement(By.xpath("//*[@id='grid_Admins']/div[2]/table/tbody/tr["+ rowno + "]/td[3]")).click();
						break labrow;
					}
				}
			}
		}
	}

	public void Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			Reporter.log("Notifications ---------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("--------------------------------");
		} else {
			System.out.println("No notification Found");
		}
	}

}
