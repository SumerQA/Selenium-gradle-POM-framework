package appMan_Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Create_User {
	Common c = new Common();
	final WebDriver driver;

	public Create_User(WebDriver driver) {
		this.driver = driver;
	}

	public void Enter_title() throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("title", "");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public void Enter_Name(String u_name) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("Name", u_name);
		Reporter.log(u_name + "is Entered in Name Field");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public void Enter_Initials(String u_initials) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("initials", u_initials);
		Reporter.log(u_initials + "is Entered in initials Field");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public void Select_Gender(String u_gender) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event("Gender", u_gender);
		Reporter.log(u_gender + "is selected from DDlist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public void Enter_Email(String u_email) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("Email", u_email);
		Reporter.log(u_email + " :is entered in Email field");
	}

	public void Select_Prefered_lang(String path, String text)
			throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event(path, text);
		Reporter.log(text + " :is selected from Prefered language DDlist");
	}

	public void Enter_LoginName(String uLname) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("login_name", uLname);
		Reporter.log(uLname + " :is entered in login Name field");
	}

	public void Enter_LoginPassword(String uLpwd) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("login_password", uLpwd);
		Reporter.log(uLpwd + " :is entered in Password field");
	}

	public void Enter_Confirm_Password(String Con_pwd) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("login_Confirm_password", Con_pwd);
		Reporter.log(Con_pwd + " :is entered in Password field");
	}

	public void Select_Active_Checkbox(String text) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("UserStatus", text);
	}

	public void Select_ActionTaker(String AT_text) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("ActionTaker", AT_text);
	}

	public void Select_ReportUser(String r_userText) throws IOException,
			InterruptedException {
		events eve = new events(driver);
		eve.Check_box_JS("ReportUser", r_userText);
	}

	public void Details_tab() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("u_details_tab");
	}

	public void Enter_TelephoneNo(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("Detail_tel_no", text);
	}

	public void Enter_TelephoneExt(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("Detail_tel_ex", text);
	}

	public void Enter_MobileNo(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_Mob_No1", text);
	}

	public void Enter_MobileNo2(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_Mob_No2", text);
	}

	public void Enter_FaxNo(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_faxNo", text);
	}

	public void Enter_URL(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_URL", text);
	}

	public void Select_manager(String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event("detail_mgr_ddlist", text);
	}

	public void Enter_Dept1(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_dept1", text);
	}

	public void Enter_Dept2(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_dept2", text);
	}

	public void Enter_Job_Desc(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_job_desc", text);
	}

	public void Enter_Sign_As(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_sign_as", text);
	}

	public void Enter_Signature(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_signature", text);
	}

	public void Enter_Note(String text) throws IOException {
		events eve = new events(driver);
		eve.SendKey_event("detail_note", text);
	}

	public void Settings_tab() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Users_settings_tab");
	}

	public void show_User_status() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("status");
	}

	public void Select_requist_recipent(String text) throws IOException {
		events eve = new events(driver);
		eve.DropDown_list_event("Settings_req_recp", text);
	}

	public void Check_SendEmailBYme(String id, String text, String SMTPUser,String emailServer, String AuthType,String EmailAddrFrom , String Pass) throws IOException {
		events eve = new events(driver);
		Object bool = ((JavascriptExecutor) driver)
				.executeScript("var chkBox = document.getElementById(" + "'"
						+ id + "'" + ");" + "  if (chkBox.checked) {"
						+ "  return true  ;" + "  }" + " else{"
						+ " return false;" + "}");
		boolean checkboxStatus = (Boolean) bool;
		if (text.equals("Yes")) {

			if (checkboxStatus) {
				System.out.println("Checkbox is already Checked");
				Reporter.log("Checkbox is already Checked");
				eve.DropDown_list("Settings_AuthenticationType", AuthType);
				eve.DropDown_list("Settings_Email_server", emailServer);
				eve.SendKey_event("Settings_Mail_server_uname", SMTPUser);//SendByme username
				eve.SendKey_event("Settings_Email_addressFrom", EmailAddrFrom);//SendByme from address
				eve.SendKey_event("Settings_Email_Pass", Pass);//SendByme from PWD
				
			} else {
				((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				Reporter.log("Checkbox is Checked Now");
				eve.DropDown_list("Settings_AuthenticationType", AuthType);
				eve.DropDown_list("Settings_Email_server", emailServer);
				eve.SendKey_event("Settings_Mail_server_uname", SMTPUser);//SendByme username
				eve.SendKey_event("Settings_Email_addressFrom", EmailAddrFrom);//SendByme from address
				eve.SendKey_event("Settings_Email_Pass", Pass);//SendByme from PWD
				}
		}
		 else {
			 if (checkboxStatus) {
				((JavascriptExecutor) driver)
						.executeScript("document.getElementById(" + "'" + id
								+ "'" + ").click();");
			} else {
				System.out.println("Checkbox is unchecked already");
				Reporter.log("Checkbox is unchecked already");
			}
		}

	}

	public void Select_Save_n_Close() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("save_n_Close");
	}

	public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("save_icon");
	}

	public void Save_as_New() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("RE_Save_as_New");
	}

	public void Close() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("close_create_panal");
	}

	public void Reload() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Reload_create_panal");
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

	public void Create_New(String u_name, String u_initials, String u_gender,
			String u_email, String uLname, String uLpwd, String text)
			throws IOException, InterruptedException {
		Enter_Name(u_name);
		Enter_Initials(u_initials);
		Select_Gender(u_gender);
		Enter_Email(u_email);
		Enter_LoginName(uLname);
		Enter_LoginPassword(uLpwd);
		Select_Active_Checkbox(text);
		Select_Save_n_Close();
		Notification();
	}
}
