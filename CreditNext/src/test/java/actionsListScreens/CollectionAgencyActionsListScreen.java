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
public class CollectionAgencyActionsListScreen extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "000744";

	@Test(priority = 1, description = "Open Collection Agency Actions list screen")
	public void Open_CollectionAgencyActionsListScreen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.caActionMenuItem);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Collection agency actions");
	}

	@Test(priority = 2, description = "Open Export to Excel in 'Collection Agency Actions' list screen without debtor selection")
	public void Open_ExporttoExcel_In_Reminder_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 3, description = "Open Advance Search in 'Collection Agency Actions' list screen without debtor selection")
	public void Open_AdvanceSearch_In_Reminder_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 4, description = "Open Customer Details in 'Collection Agency Actions' list screen without debtor selection")
	public void Open_DeleteActions_In_Reminder_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.deleteActionsIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 5, description = "Open Customer Information Screen in 'Collection Agency Actions' list screen without debtor selection")
	public void Open_CIS_In_Reminder_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 6, description = "Open Customer Details in 'Collection Agency Actions' list screen without debtor selection")
	public void Open_BulkSendToCollectionAgency_In_Reminder_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	
	@Test(priority = 7, description ="Open Help Page in 'Collection Agency Actions' list screen without debtor selection") 
	public void Open_HelpPage_In_Reminder_actions_List_screen() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test CreditNext");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test Connext"); 
	  }
	
	@Test(priority = 8, description = "Open Export to Excel in 'Collection Agency Actions' list screen with debtor selection", enabled = false)
	public void Open_ExporttoExcel_In_Reminder_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 9, description = "Open Advance Search in 'Collection Agency Actions' list screen with debtor selection", enabled = false)
	public void Open_AdvanceSearch_In_Reminder_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 10, description = "Open Customer Details in 'Collection Agency Actions' list screen without debtor selection", enabled = false)
	public void Open_DeleteActions_In_Reminder_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.deleteActionsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Delete");
		CG_screen.closeDataModelDialog();
	}
	@Test(priority = 11, description = "Open Customer Information Screen in 'Collection Agency Actions' list screen with debtor selection", enabled = false)
	public void Open_CIS_In_Reminder_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "windows opened");
		CG_screen.closeCIS();
	}
	@Test(priority = 12, description = "Open Customer Details in 'Collection Agency Actions' list screen without debtor selection", enabled = false)
	public void Open_BulkSendToCollectionAgency_In_Reminder_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.noRowsSelected);
		System.out.println(ExpectedResult);
		CG_screen.closeCIS();
	}
	
	@Test(priority = 13, description = "Open Customer Details in 'Collection Agency Actions' list screen without debtor selection", enabled = false)
	public void Open_CollectionAgencyActions_from__All_actions_SingleDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.validateDebtorInCIS);
		System.out.println(ExpectedResult);
		CG_screen.closeCIS();
		CG_screen.ClearPageFilterOnListScreen(ListScreenLocators.actionTypeInputField);
	}
	@Test(priority = 14, description = "Close 'Collection Agency Actions' list screen")
	public void Close_collectionAgencyActionsListScreen() {
		CG_screen.CloseActionsListScreen();
	}
}