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

public class Customer_Scoring_Page {
	Common c = new Common();
	final WebDriver driver;

	public Customer_Scoring_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Customer_Scoring_page() throws IOException,
			InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		
		// HI_page.Select_Functional_Configration_Tab(); Thread.sleep(800);
		 
		Functional_Configration_Page FC_page = new Functional_Configration_Page(
				driver);
		FC_page.Click_Customer_Scoring_tab();
		Thread.sleep(1000);
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

	// Create Currency
	public void Customer_scoring_definition_name(String text)
			throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_Customer_scoring_definition_name", text);
		Reporter.log(text
				+ " : is Entered in the Customer scoring definition name  input field.");
	}

	public void Weighting(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_Weighting", text);
		Reporter.log(text + " : is Entered in the Weighting  input field.");
	}

	public void Weighting_change(String inputtext, String CheckText)
			throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("weghingchange", CheckText);
		Thread.sleep(500);
		if (CheckText.equals("Yes")) {
			eve.SendKey_event("CS_Weighting_Changes", inputtext);
			Reporter.log(inputtext
					+ " : is Entered in the Weighting changes  input field.");

		}
	}

	public void Freeze_component_when_no_outstanding_invoices(String path,
			String text) throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("nooutstandinginvoice", text);
		Thread.sleep(500);
	}

	public void Unweighted(String text) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("unweighing", text);
		Thread.sleep(500);
	}

	public void Calculation_method(String text) throws IOException {
		events eve = new events(driver);
		if (driver.findElement(
				By.xpath(c.getElementName("CS_Calculation_method")))
				.isDisplayed()) {
			eve.DropDown_list_event("CS_Calculation_method", text);
		}
	}

	public void Include_debit_invoices(String text, String text1, String text2,
			String text3) throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("debitinvoice", text);
		if (text.equals("Yes")) {
			eve.Check_box_JS("creditinvoice", text1); // Include credit invoices
			eve.Check_box_JS("blockedinvoice", text2); // Include blocked
														// invoices
			eve.Check_box_JS("overdueinvoice", text3); // Include overdue
														// invoices only
		}
	}

	public void From(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_range_From", text);
		Reporter.log(text + " : is Entered in the From input field.");
	}

	public void to(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_range_to", text);
		Reporter.log(text + " : is Entered in the to input field.");
	}

	public void Period_Weeks(String text) throws IOException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("CS_Period")))
				.isDisplayed()) {
			eve.SendKey_event("CS_Period", text);
			Reporter.log(text
					+ " : is Entered in the Preiod(weeks) input field.");
		}
	}

	public void paid_Invoices_Weeks(String text) throws IOException {
		events eve = new events(driver);
		if (driver.findElement(
				By.xpath(c.getElementName("CS_paid_Invoices_Weeks")))
				.isDisplayed()) {
			eve.SendKey_event("CS_paid_Invoices_Weeks", text);
			Reporter.log(text
					+ " : is Entered in the paid Invoices(Weeks) input field.");
		}
	}

	public void Outstanding_invoices_Weeks(String text) throws IOException {
		events eve = new events(driver);
		if (driver.findElement(
				By.xpath(c.getElementName("CS_Outstanding_invoices_Weeks")))
				.isDisplayed()) {
			eve.SendKey_event("CS_Outstanding_invoices_Weeks", text);
			Reporter.log(text
					+ " : is Entered in the Outstanding invoices(Weeks) input field.");
		}
	}

	public void Score_Points(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("CS_Score_points", text);
		Reporter.log(text + " : is Entered in the to input field.");
	}

	public void Related_item(String text) throws IOException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("CS_Relateditem")))
				.isDisplayed()) {
			eve.DropDown_list_event("CS_Relateditem", text);
		}
	}

	public void Text_value(String text) throws IOException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("CS_text_value")))
				.isDisplayed()) {
			eve.SendKey_event("CS_text_value", text);
			Reporter.log(text + " : is Entered in the Text value input field.");
		}

	}

	public void Reload() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("reload");
		Reporter.log("Reload button is Clicked.");

	}

	public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("save_UG_icon");
		Reporter.log("Save button is Clicked.");
	}

	public void Save_panal() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_eventBy_ClassName("saveMain");
		Reporter.log("Save button is Clicked.");

	}

	public void Cancel_Customer_Scoring() throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Cancel");
		Reporter.log("Cancel button is Clicked.");
	}

	public void Cancel() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("close_icon");
		Reporter.log("Cancel button is Clicked.");
	}

	public void Save_as_New() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("save&New_UG_icon");
		Reporter.log("Save as New button is Clicked.");

	}

	public void Save_and_Close() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("save_close_UG_icon");
		Reporter.log("Save and Close button is Clicked.");

	}

	public void Create_Range() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Create_Range_icon");
		Reporter.log("Create Range button is Clicked.");

	}

	public void Update_Range() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Change_Range_icon");
		Reporter.log("Change Range button is Clicked.");

	}

	public void Delete_Range() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("CS_Delete_Range_icon");
		Reporter.log("Delete Range button is Clicked.");

	}

	public void Notification() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver
				.findElement(
						By.xpath(c
								.getElementName("Save_changes_notification_Message")))
				.isDisplayed()) {
			Reporter.log("Notification-----------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("-----------------------------------------------------");
		}
	}

	public void link() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Link");
		Reporter.log("Link Icon is Clicked.");
	}

	public void Unlink() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Unlink");
		Reporter.log("Unlink Icon is Clicked.");
	}

	public void Aging_Cust_scor_Click(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Aging Menu list is Clicked.");
	}

	public void Counts_and_balances_Click(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Counts and balances Menu list is Clicked.");
	}

	public void Collection_Activities_Click(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Collection Activities Menu list is Clicked.");
	}

	public void Debtor_Properties_Click(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Debtor Properties Menu list is Clicked.");
	}

	public void Credit_Limit_Click(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("Credit  Limit  Menu list is Clicked.");
	}

	public void User_Fields_Click(String path) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event(path);
		Reporter.log("User Fields Menu list is Clicked.");
	}

	public void Aging_Cust_Scoring_table(String path, String input)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[1]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[1]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[1]/ul/li["
								+ colNo + "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Add_range_Aging_Cust_Scoring(String path, String input,
			String CalculationType, String from, String to, String period,
			String point, String paidInv, String outstInv) throws IOException,
			InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[1]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[1]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[1]/ul/li["
								+ colNo + "]/div/span")).click();
				Thread.sleep(500);
				Weighting_change("test", "No");
				Unweighted("No");
				Calculation_method(CalculationType);
				Include_debit_invoices("Yes", "Yes", "No", "Yes");
				Weighting(input);
				From(from);
				to(to);
				Period_Weeks(period);
				Score_Points(point);
				paid_Invoices_Weeks(paidInv);
				Outstanding_invoices_Weeks(outstInv);
				Thread.sleep(500);
				Create_Range();
				Thread.sleep(1000);
				if (colNo == 4) {
					break labrow;
				}

			}
		}

	}

	public void Counts_Balances_table(String path, String input)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[2]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[2]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[2]/ul/li["
								+ colNo + "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Add_range_Counts_Balances_table(String path, String input,
			String from, String to, String period, String point)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[2]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[2]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[2]/ul/li["
								+ colNo + "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				From(from);
				to(to);
				Period_Weeks(period);
				Score_Points(point);
				Thread.sleep(500);
				Create_Range();
				Thread.sleep(1000);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Collection_Activity_table(String path, String input)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Update_range_Counts_Balances_table(String path, String Action,
			String from, String to, String point) throws IOException,
			InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("li"));
		int count = 0;
		labrow:

		for (int rownum = 0; rownum < rows.size(); rownum++) {
			if (count == 0) {
				System.out.println(rows.get(rownum).getText());
				int rowNo = rownum + 1;
				count++;
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/div/span")).click();
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).click();
				Thread.sleep(1500);
				if (Action.equals("Update")) {
					From(from);
					to(to);
					Score_Points(point);
					Thread.sleep(500);
				}
				switch (Action) {
				case ("Update"):
					Update_Range();
					break;
				}
				switch (Action) {
				case ("Delete"):
					Delete_Range();
					break labrow;

				}
			} else {
				break labrow;
			}

		}

	}

	public void Update_range_Aging_table(String path, String Action,
			String from, String to, String point, String period)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("li"));
		int count = 0;
		labrow:

		for (int rownum = 0; rownum < rows.size(); rownum++) {
			if (count == 0) {
				System.out.println(rows.get(rownum).getText());
				int rowNo = rownum + 1;
				count++;
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/div/span")).click();
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).click();
				Thread.sleep(1500);
				if (Action.equals("Update")) {
					From(from);
					to(to);
					Period_Weeks(period);
					Score_Points(point);
					Thread.sleep(500);
				}
				switch (Action) {
				case ("Update"):
					Update_Range();
					break;
				}
				switch (Action) {
				case ("Delete"):
					Delete_Range();
					break labrow;

				}
			} else {
				break labrow;
			}

		}

	}

	public void Update_range_Debtor_Prop_table(String path, String Action,
			String related, String point) throws IOException,
			InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("li"));
		int count = 0;
		labrow:

		for (int rownum = 0; rownum < rows.size(); rownum++) {
			if (count == 0) {
				System.out.println(rows.get(rownum).getText());
				int rowNo = rownum + 1;
				count++;
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/div/span")).click();
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).click();
				Thread.sleep(1500);
				if (Action.equals("Update")) {
					Related_item(related);
					Score_Points(point);
					Thread.sleep(500);
				}
				switch (Action) {
				case ("Update"):
					Update_Range();
					break;
				}
				switch (Action) {
				case ("Delete"):
					Delete_Range();
					break labrow;

				}
			} else {
				break labrow;
			}

		}

	}

	public void Update_range_User_Fields_table(String path, String Action,
			String text, String point) throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("li"));
		int count = 0;
		labrow:

		for (int rownum = 0; rownum < rows.size(); rownum++) {
			if (count == 0) {
				System.out.println(rows.get(rownum).getText());
				int rowNo = rownum + 1;
				count++;
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/div/span")).click();
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/li[" + rowNo
								+ "]/ul/li/div/span")).click();
				Thread.sleep(1500);
				if (Action.equals("Update")) {
					Text_value(text);
					Score_Points(point);
					Thread.sleep(500);
				}
				switch (Action) {
				case ("Update"):
					Update_Range();
					break;
				}
				switch (Action) {
				case ("Delete"):
					Delete_Range();
					break labrow;

				}
			} else {
				break labrow;
			}

		}

	}

	public void Add_Range_Collection_Activity_table(String path, String input,
			String from, String to, String period, String point)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				From(from);
				to(to);
				Period_Weeks(period);
				Score_Points(point);
				Thread.sleep(500);
				Create_Range();
				Thread.sleep(1000);

				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Debtor_props_table(String path, String input)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Add_range_Debtor_props_table(String path, String input,
			String relateditem, String textval, String point)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				Related_item("");
				Text_value(textval);
				Score_Points(point);
				Thread.sleep(500);
				Create_Range();
				Thread.sleep(1000);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Credit_limit(String path, String input) throws IOException,
			InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				if (colNo == 1) {
					break labrow;
				}
			}
		}

	}

	public void Add_range_Credit_limit(String path, String input, String from,
			String to, String point) throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[" + colNo
								+ "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				From(from);
				to(to);
				Score_Points(point);
				Thread.sleep(500);
				Create_Range();
				Thread.sleep(1000);

				if (colNo == 1) {
					break labrow;
				}
			}
		}

	}

	public void User_fields_table(String path, String input)
			throws IOException, InterruptedException {
		WebElement element = driver
				.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		labrow: for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(
					By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < 4; colnum++) {
				System.out.println(columns.get(colnum).getText());
				int colNo = colnum + 1;
				System.out.println(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[6]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				Reporter.log(driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[6]/ul/li["
								+ colNo + "]/div/span")).getText()
						+ " is selected");
				driver.findElement(
						By.xpath(c.getElementName(path) + "/ul/li[6]/ul/li["
								+ colNo + "]/div/span")).click();
				Thread.sleep(500);
				Weighting(input);
				if (colNo == 4) {
					break labrow;
				}
			}
		}

	}

	public void Add_range_User_fields_table(String path, String input,String textval, String point) throws IOException,InterruptedException {
		WebElement element = driver.findElement(By.xpath(c.getElementName(path))); // CS_Aging_items
		List<WebElement> rows = element.findElements(By.tagName("ul"));
		for (int rownum = 0; rownum < rows.size(); rownum++)
		  {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("li"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 1; colnum <= columns.size(); colnum++) {
				if(columns.get(colnum).getText().contains("Customer Alphanumeric")){
					System.out.println(driver.findElement(By.xpath(c.getElementName(path) + "/ul/li[" + colnum + "]/div/span")).getText()+ " is selected");
					Reporter.log(driver.findElement(By.xpath(c.getElementName(path) + "/ul/li[" + colnum	+ "]/div/span")).getText()+ " is selected");
					driver.findElement(By.xpath(c.getElementName(path) + "/ul/li[" + colnum+ "]/div/span")).click();
					Thread.sleep(500);
					Weighting(input);
					Text_value(textval);
					Score_Points(point);
					Create_Range();
					Thread.sleep(1000);
				}		
			}
		}

	}

	public void Customer_scoring_Type(String type) throws IOException,
			InterruptedException {
		WebDriver driver = WebDriverManager.getDriverInstance();
		Customer_Scoring_Page cs_page = new Customer_Scoring_Page(driver);
		switch (type) {
		case ("1"):
			cs_page.Aging_Cust_scor_Click("CS_Aging_cus_Scor_Click");
			Thread.sleep(500);
			break;
		case ("2"):
			cs_page.Counts_and_balances_Click("CS_Counts_n_balances_click");
			Thread.sleep(500);
			break;
		case ("3"):
			cs_page.Collection_Activities_Click("CS_Collection_activities_click");
			Thread.sleep(500);
			break;
		case ("4"):
			cs_page.Debtor_Properties_Click("CS_debtor_props_click");
			Thread.sleep(500);
			break;
		case ("5"):
			cs_page.Credit_Limit_Click("CS_Credit_Limit_click");
			Thread.sleep(500);
			break;
		case ("6"):
			cs_page.User_Fields_Click("CS_User_fieldsclick");
			Thread.sleep(500);
			break;

		}
	}

}
