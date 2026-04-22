package allCreateActionsFunctionality;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import InvoicesListScreens.allInvoicesListScreen;
import customerGroupsListScreens.customerGroupsListScreen;
import locatorPages.All_ActionsLocators;
import pages.CreateActionsPage;
import pages.CustomeGroupsListScreenPage;
@Parameters({ "login","password","language","group", "Administration","AppManURL" })
@Listeners(ScreenShotOnFailure.class)
public class CreateLetterActionOnInvoiceScreen extends TestListenerAdapter {
	WebDriver driver = null;
	CreateActionsPage CG_Actions = null;
	String debtID = "1092684";
	String ActionDebtorID="1095062";
	String InvoiceID = "2022P7051294489100001";
	String emailto="vinod.kumar@sdnatech.com";
	String emailcc="vinod.kumar+1@sdnatech.com";
	String emailbcc="vinod.kumar+2@sdnatech.com";
	private String testtemplate="Automation test  Letter";
	allInvoicesListScreen CustomerG_Listscreen;

	@Test(priority = 1, description = "Verify that Create Print type Letter action using RTF template with preview and execute from batch and verify in History and timeline")
	public void CreatePrint_Type_Letter_Action_using_RTF_Temp_with_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");	
		driver = WebDriverManager.getDriverInstance();
		CG_Actions = new CreateActionsPage(driver);
		CustomerG_Listscreen =new allInvoicesListScreen();
		CustomerG_Listscreen.Open_allInvoicesListScreen();
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Print", "RTF");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.perviewInvoice();
		CG_Actions.closePerviewInvoice();
		CG_Actions.SaveDocumentLetter();
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");
	
	}

	@Test(priority = 2, description = "Verify that Create Print type Letter action using HTML template with preview and execute from batch and verify in History and timeline")
	public void CreatePrint_Type_Letter_Action_using_HTML_Temp_with_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Print", "HTML");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.perviewInvoice();
		CG_Actions.closePerviewInvoice();
		CG_Actions.SaveDocumentLetter();
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 3, description = "Verify that Create Email type Letter action using RTF template with preview and execute from batch and verify in History and timeline")
	public void CreateEmail_Type_Letter_Action_using_RTF_Temp_with_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Email", "RTF");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.perviewInvoice();
		CG_Actions.closePerviewInvoice();
		CG_Actions.SaveDocumentLetter();
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 4, description = "Verify that Create Email type Letter action using HTML template with preview and execute from batch and verify in History and timeline")
	public void CreateEmail_Type_Letter_Action_using_HTML_Temp_with_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Email", "HTML");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.perviewInvoice();
		CG_Actions.closePerviewInvoice();
		CG_Actions.SaveDocumentLetter();
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");
	}

	@Test(priority = 5, description = "Verify that Create SMS type Letter action using RTF template with preview and execute from batch and verify in History and timeline")
	public void CreateSMS_Type_Letter_Action_using_RTF_Temp_with_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "SMS", "RTF");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.perviewInvoice();
		CG_Actions.closePerviewInvoice();
		CG_Actions.SaveDocumentLetter();
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 6, description = "Verify that Create SMS type Letter action using HTML template with preview and execute from batch and verify in History and timeline")
	public void CreateSMS_Type_Letter_Action_using_HTML_Temp_with_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "SMS", "HTML");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.perviewInvoice();
		CG_Actions.closePerviewInvoice();
		CG_Actions.SaveDocumentLetter();
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 7, description = "Verify that Create Print type Letter action using RTF template without preview and execute from batch and verify in History and timeline")
	public void CreatePrint_Type_Letter_Action_using_RTF_Temp_without_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Print", "RTF");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.SaveDocumentLetter();
		CG_Actions.emailADDforAction(emailto, emailcc, emailbcc);	
		CG_Actions.getSubjectofLetterAction();
		System.out.println(CG_Actions.getSubjectofLetterAction());
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 8, description = "Verify that Create Print type Letter action using HTML template without preview and execute from batch and verify in History and timeline")
	public void CreatePrint_Type_Letter_Action_using_HTML_Temp_without_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Print", "HTML");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.SaveDocumentLetter();
		CG_Actions.emailADDforAction(emailto, emailcc, emailbcc);	
		CG_Actions.getSubjectofLetterAction();
		System.out.println(CG_Actions.getSubjectofLetterAction());
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 9, description = "Verify that Create Email type Letter action using RTF template without preview and execute from batch and verify in History and timeline")
	public void CreateEmail_Type_Letter_Action_using_RTF_Temp_without_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Email", "RTF");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.SaveDocumentLetter();
		CG_Actions.emailADDforAction(emailto, emailcc, emailbcc);	
		CG_Actions.getSubjectofLetterAction();
		System.out.println(CG_Actions.getSubjectofLetterAction());
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 10, description = "Verify that Create Email type Letter action using HTML template without preview and execute from batch and verify in History and timeline")
	public void CreateEmail_Type_Letter_Action_using_HTML_Temp_without_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "Email", "HTML");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.SaveDocumentLetter();
		CG_Actions.emailADDforAction(emailto, emailcc, emailbcc);	
		CG_Actions.getSubjectofLetterAction();
		System.out.println(CG_Actions.getSubjectofLetterAction());
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 11, description = "Verify that Create SMS type Letter action using RTF template without preview and execute from batch and verify in History and timeline")
	public void CreateSMS_Type_Letter_Action_using_RTF_Temp_without_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "SMS", "RTF");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.SaveDocumentLetter();
		CG_Actions.emailADDforAction(emailto, emailcc, emailbcc);	
		CG_Actions.getSubjectofLetterAction();
		System.out.println(CG_Actions.getSubjectofLetterAction());
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}

	@Test(priority = 12, description = "Verify that Create SMS type Letter action using HTML template without preview and execute from batch and verify in History and timeline")
	public void CreateSMS_Type_Letter_Action_using_HTML_Temp_without_Perview_VerifyHistory_AND_Timeline(String AppManURL,String login, String password, String group, String Administration ) throws InterruptedException {
		System.out.println("******************************* Start Testcase *********************************");
		CG_Actions.selectDebtor(ActionDebtorID);
		CG_Actions.click_CIS_button();
		CG_Actions.click_CIS_Action_Button();
		CG_Actions.ClickAction_LetterAction();
		CG_Actions.Create_DocumentSettingsOfLetterForm(testtemplate, "Dutch", "SMS", "HTML");
		CG_Actions.AddSingleInvoiceinAction(InvoiceID);
		CG_Actions.SaveDocumentLetter();
		CG_Actions.emailADDforAction(emailto, emailcc, emailbcc);	
		CG_Actions.getSubjectofLetterAction();
		System.out.println(CG_Actions.getSubjectofLetterAction());
		//String expectedTitle = CG_Actions.getWindowPopupTitle(); 
		//CG_Actions.validationOnAction(expectedTitle, "Test");
		String ExpectedSuccessMsg = CG_Actions.getsuccessMessageONLetterComplete();
		CG_Actions.validationOnAction(ExpectedSuccessMsg, "Letter Sent");
		CG_Actions.closeDataModelDialog();
		CG_Actions.closeCIS();
		CG_Actions.LoginAppman(AppManURL, login, password, group, Administration);
		System.out.println("******************************* End Testcase *********************************");

	}
}