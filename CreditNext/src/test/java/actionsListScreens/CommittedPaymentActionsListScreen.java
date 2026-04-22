package actionsListScreens;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import locatorPages.ListScreenLocators;
import pages.CustomeGroupsListScreenPage;

@Listeners(ScreenShotOnFailure.class)
public class CommittedPaymentActionsListScreen extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "000793";

	@Test(priority = 1, description = "Open Committed payment Actions list screen")
	public void Open_CommittedPaymentActionsActionsListScreen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.committedPaymentActionMenuItem);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Committed Payment Actions");
	}

	@Test(priority = 2, description = "Open Export to Excel in 'Committed payment Actions' list screen without debtor selection")
	public void Open_ExporttoExcel_In_CommittedPayment_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 3, description = "Open Advance Search in 'Committed payment Actions' list screen without debtor selection")
	public void Open_AdvanceSearch_In_CommittedPayment_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 4, description = "Open Customer Details in 'Committed payment Actions' list screen without debtor selection")
	public void Open_DeleteActions_In_CommittedPayment_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.deleteActionsIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 5, description = "Open Customer Information Screen in 'Committed payment Actions' list screen without debtor selection")
	public void Open_CIS_In_CommittedPayment_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 6, description = "Open Customer Details in 'Committed payment Actions' list screen without debtor selection")
	public void Open_BulkSendToCollectionAgency_In_CommittedPayment_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	
	@Test(priority = 7, description ="Open Help Page in 'Committed payment Actions' list screen without debtor selection") 
	public void Open_HelpPage_In_CommittedPayment_actions_List_screen() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard Connext"); 
	  }
	
	@Test(priority = 8,enabled = false, description = "Open Export to Excel in 'Committed payment Actions' list screen with debtor selection")
	public void Open_ExporttoExcel_In_CommittedPayment_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 9,enabled = false, description = "Open Advance Search in 'Committed payment Actions' list screen with debtor selection")
	public void Open_AdvanceSearch_In_CommittedPayment_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 10,enabled = false, description = "Open Customer Details in 'Committed payment Actions' list screen without debtor selection")
	public void Open_DeleteActions_In_CommittedPayment_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.deleteActionsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Delete");
		CG_screen.closeDataModelDialog();
	}
	@Test(priority = 11,enabled = false, description = "Open Customer Information Screen in 'Committed payment Actions' list screen with debtor selection")
	public void Open_CIS_In_CommittedPayment_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "windows opened");
		CG_screen.closeCIS();
	}
	@Test(enabled = false, priority = 12, description = "Open Customer Details in 'Committed payment Actions' list screen without debtor selection")
	public void Open_BulkSendToCollectionAgency_In_CommittedPayment_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Please select collection agency actions");
	}
	
	@Test(priority = 13,enabled = false, description = "Close 'Committed payment Actions' list screen.")
	public void Close_committedPaymentActionsListScreen() {
		CG_screen.CloseActionsListScreen();
	}
}