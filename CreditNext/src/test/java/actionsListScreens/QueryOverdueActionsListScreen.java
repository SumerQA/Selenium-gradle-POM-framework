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
public class QueryOverdueActionsListScreen extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "1097449";

	@Test(priority = 1, description = "Open Query Overdue Actions list screen")
	public void Open_QueryOverDueActionsListScreen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.QueryOverdueActionMenuItem);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Query overdue actions");
	}

	@Test(priority = 2, description = "Open Export to Excel in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_ExporttoExcel_In_QueryOverdue_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 3, description = "Open Advance Search in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_AdvanceSearch_In_QueryOverdue_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 4, description = "Open Delete Actions in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_DeleteActions_In_QueryOverdue_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.deleteActionsIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 5, description = "Open Customer Information Screen in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_CIS_In_QueryOverdue_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 6, description = "Open Bulk Send to Collection Agency in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_BulkSendToCollectionAgency_In_QueryOverdue_actions_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	
	@Test(priority = 7, description ="Open Help Page in 'Query Overdue Actions' list screen without debtor selection") 
	public void Open_HelpPage_In_QueryOverdue_actions_List_screen() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test CreditNext"); 
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test Connext"); 
	  }
	
	@Test(priority = 8, description = "Open Export to Excel in 'Query Overdue Actions' list screen with debtor selection")
	public void Open_ExporttoExcel_In_QueryOverdue_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 9, description = "Open Advance Search in 'Query Overdue Actions' list screen with debtor selection")
	public void Open_AdvanceSearch_In_QueryOverdue_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 10, description = "Open Delete Actions in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_DeleteActions_In_QueryOverdue_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.deleteActionsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Delete");
		CG_screen.closeDataModelDialog();
	}
	@Test(priority = 11, description = "Open Customer Information Screen in 'Query Overdue Actions' list screen with debtor selection")
	public void Open_CIS_In_QueryOverdue_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "windows opened");
		CG_screen.closeCIS();
	}
	@Test(priority = 12, description = "Open Bulk Send to Collection Agency in 'Query Overdue Actions' list screen without debtor selection")
	public void Open_BulkSendToCollectionAgency_In_QueryOverdue_actions_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkSendToCollectionAgencyIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Please select collection agency actions");
	}
	
	@Test(priority = 13, description = "Close 'Query Overdue Actions' list screen.")
	public void Close_queryOverdueActionsListScreen() {
		CG_screen.CloseActionsListScreen();
	}
}