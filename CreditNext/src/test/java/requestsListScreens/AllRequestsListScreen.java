package requestsListScreens;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import locatorPages.ListScreenLocators;
import pages.CustomeGroupsListScreenPage;

@Listeners(ScreenShotOnFailure.class)
public class AllRequestsListScreen extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "1095633";

	@Test(priority = 1, description = "Open All Requests Actions list screen")
	public void Open_allRequestsListScreen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		CG_screen.ClickCustomerGroupMenuItem(ListScreenLocators.RequestsMenuItems);// Open Requests List screen
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.alRequestsMenuItem);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "All requests");
	}
	@Test(priority = 2, description = "Open Export to Excel in 'All Requests' list screen without debtor selection")
	public void Open_ExporttoExcel_In_All_Requests_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 3, description = "Open Advance Search in 'All Requests' list screen without debtor selection")
	public void Open_AdvanceSearch_In_All_Requests_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 4, description = "Open View Request actions in 'All Requests' list screen without debtor selection")
	public void Open_ViewRequestAction_In_All_Requests_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkChangeDisputeIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	
	@Test(priority = 5, description = "Open Customer Details in 'All Requests' list screen without debtor selection")
	public void Open_MakeNote_In_All_Requests_List_screen() {
		String 	  ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 6, description ="Open Notes History in 'All Requests' list screen without debtor selection")
	public void Open_Notes_In_All_Requests_List_screen() {
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	@Test(priority = 7, description ="Open Help Page in 'All Requests' list screen without debtor selection") 
	public void Open_HelpPage_In_All_Requests_List_screen() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test CreditNext"); 
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test Connext"); 
	  }
	
	@Test(priority = 8, description = "Open Export to Excel in 'All Requests' list screen with debtor selection")
	public void Open_ExporttoExcel_In_All_Requests_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 9, description = "Open Advance Search in 'All Requests' list screen with debtor selection")
	public void Open_AdvanceSearch_In_All_Requests_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 10, description = "Open View Request Action in 'All Requests' list screen without debtor selection")
	public void Open_ViewRequestAction_In_All_Requests_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkChangeDisputeIcon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult);
		CG_screen.closeCIS();
	}
	@Test(priority = 11, description ="Open Make Note in 'All Requests' list screen with debtor selection")
	  public void Open_MakeNote_In_All_Requests_DebtorSelection() { 
		CG_screen.selectDebtorinListScreen(debtID);
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.validateNoteScreen);
		  System.out.println(ExpectedResult+" : Make note screen");
		  CG_screen.closeModelDialog();
	  }
	@Test(priority = 12, description = "Open Notes History in 'All Requests' list screen with debtor selection")
	public void Open_NotesHistory_In_All_Requests_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Note History");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 13, description = "Close 'All Requests' list screen")
	public void Close_allRequestsListScreen() {
		CG_screen.CloseActionsListScreen();
	}
}