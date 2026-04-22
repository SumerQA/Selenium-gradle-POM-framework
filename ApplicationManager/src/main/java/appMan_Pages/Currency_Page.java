package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Currency_Page {
	// WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();
	final WebDriver driver;

	public Currency_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void Goto_Currency_page() throws IOException, InterruptedException {
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*
		 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(1000);
		 */
		
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Currency_tab();
		Thread.sleep(1000);
		HI_page.Render_Notifications();
	}

	public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		if(driver.findElement(By.xpath(c.getElementName("C_Cancel"))).isDisplayed()){
			eve.Click_event("C_Cancel");
			Thread.sleep(1000);
			
		}
		else if(driver.findElement(By.xpath(c.getElementName("Close_Ex_rate"))).isDisplayed()){
			eve.Click_event("Close_Ex_rate");
			Thread.sleep(1000);
			
		}
		else{
			eve.Click_event("Create_NewUser_panal");
		}
	}

	public void Update_Currency_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
	}

	public void Delete_Currency_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("delete_user");
	}

	public void Exchange_rate_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("C_exchange_rate");
	}

	// Create Currency
	public void ISO_code(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);
	}

	public void Currency_code(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);

	}

	public void Description() throws IOException {
		events eve = new events(driver);
		eve.GetText_event("C_description");

	}

	public void Clear_Description_input() throws IOException {
		events eve = new events(driver);
		eve.Clear_InputField("C_description");

	}

	public void Display_text() throws IOException {
		events eve = new events(driver);
		eve.GetText_event("C_Display_text");

	}

	public void Display_text_Edit(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);

	}

	public void Display_text_Edit_Clear(String path) throws IOException {
		events eve = new events(driver);
		eve.Clear_InputField(path);

	}

	public void Display_Decimal(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);

	}

	public void Import_devide(String path, String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);

	}

	public void Exchange_rate_Currency(String action) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event("xchange_rate_currency_ddlist", action);

	}

	public void Refresh() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("C_Refresh");

	}

	public void Reload() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("refresh");

	}

	public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("C_Save"); 

	}

	public void Save_Exchange_Rate() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Save_ex_rate");

	}

	public void Close_Exchange_Rate() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Close_Ex_rate");

	}

	public void Save_Changes() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Save_IM_changes");

	}

	public void Save_and_Close() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("save_n_Close"); // C_Save_n_Close

	}
	public void Save_and_Close_button() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("C_Save_n_Close"); // C_Save_n_Close

	}

	public void Cancel() throws IOException, InterruptedException {
		events eve = new events(driver);
		if(driver.findElement(By.xpath(c.getElementName("C_Cancel"))).isDisplayed())
		{
			eve.Click_event("C_Cancel");
		}
		
	}

	public void Notifications() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			Reporter.log("Notificatio: ----------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("-----------------------------------------------------");
		}
	}
	public void No_Notifications() throws IOException, InterruptedException {
		events eve = new events(driver);
		if (driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()) {
			Reporter.log("Notificatio: ----------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_NO_button");
			Reporter.log("-----------------------------------------------------");
		}
	}
	public void Create_Exchange_Rate_icon() throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Click_event("C_create_currency_exchange_rate");
	}

	public void Exchange_Rate_inputField(String path, String text)
			throws IOException {
		events eve = new events(driver);
		eve.SendKey_event(path, text);
	}

	public void link() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Link");
	}

	public void Unlink() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Unlink");
	}
	
	public void Verify_Exchange_rate(String ePath) throws IOException, InterruptedException {
		WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				int rowno = rownum + 1;
				System.out.println(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText()+ " is selected");
				Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText()+ " is selected from table");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				String ex_rate = driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText();
				int t=Integer.parseInt(ex_rate);
				if(t==1){
					System.out.println("Exchange rate is "+ex_rate);
					
				}else{
					System.out.println("Exchange rate is Missing");
				}
					
				}
			}
		}
	public void Exchange_rate_Table(String ePath) throws IOException, InterruptedException {
		WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				System.out.println(columns.get(colnum).getText());
				int rowno = rownum + 1;
				//System.out.println(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText()+ " is selected");
				//Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText()+ " is selected from table");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				String x_rate =driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText();
				System.out.println("Exchange rate in table : " +x_rate);
				Reporter.log("Exchange rate in table : " +x_rate);
				}
			}
		}
	}
	

