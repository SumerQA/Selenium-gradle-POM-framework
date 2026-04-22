package disputesListScreens;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import locatorPages.ListScreenLocators;
import pages.CustomeGroupsListScreenPage;

@Listeners(ScreenShotOnFailure.class)
public class DisputesOnPaidInvoicesListScreen extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "421";

	@Test(priority = 1, description = "Open Disputes on paid invoices list screen")
	public void Open_DisputesOnPaidInvListScreen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.disputesonPaidInv);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Disputes on paid invoices");
	}
	@Test(priority = 2, description = "Open Customer Report in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_Report_In_DisputesOnPaidInvoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 3, description = "Open Export to Excel in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_ExporttoExcel_In_DisputesOnPaidInvoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 4, description = "Open Advance Search in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_AdvanceSearch_In_DisputesOnPaidInvoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 5, description = "Open Bulk Change Disputes in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_BulkChangeDisputes_In_DisputesOnPaidInvoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkChangeDisputeIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 6, description = "Open Dispute Details in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_DisputeDetails_In_DisputesOnPaidInvoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.DisputeDetailsIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 7, description = "Open Customer Details in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_MakeNote_In_DisputesOnPaidInvoices_List_screen() {
		String 	ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	@Test(priority = 8, description ="Open Notes History in 'Disputes on paid invoices' list screen without debtor selection")
	public void Open_Notes_In_DisputesOnPaidInvoices_List_screen() {
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	@Test(priority = 9, description ="Open Help Page in 'Disputes on paid invoices' list screen without debtor selection") 
	public void Open_HelpPage_In_DisputesOnPaidInvoices_List_screen() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard CreditNext");
       //CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard Connext");
	  }
	@Test(priority = 10, description = "Open Dispute Report in 'Disputes on paid invoices' list screen with debtor selection", enabled = false)
	public void Open_Report_In_DisputesOnPaidInvoices_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Reports");
		CG_screen.closeDataModelDialog();
	}
	@Test(priority = 11, description = "Open Export to Excel in 'Disputes on paid invoices' list screen with debtor selection", enabled = false)
	public void Open_ExporttoExcel_In_DisputesOnPaidInvoices_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 12, description = "Open Advance Search in 'Disputes on paid invoices' list screen with debtor selection", enabled = false)
	public void Open_AdvanceSearch_In_DisputesOnPaidInvoices_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 13, description = "Open Bulk Change Dispute in 'Disputes on paid invoices' list screen without debtor selection", enabled = false)
	public void Open_BulkChangeDisputes_In_DisputesOnPaidInvoices_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.bulkChangeDisputeIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Change Dispute");
		
		CG_screen.closeModelDialog();
	}
	@Test(priority = 14, description = "Open Dispute Details in 'Disputes on paid invoices' list screen without debtor selection", enabled = false)
	public void Open_DisputeDetails_In_DisputesOnPaidInvoices_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.DisputeDetailsIcon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Change Dispute");
		CG_screen.closeCIS();
	}
	@Test(priority = 15, description ="Open Make Note in 'Disputes on paid invoices' list screen with debtor selection", enabled = false)
	  public void Open_MakeNote_In_DisputesOnPaidInvoices_DebtorSelection() { 
		CG_screen.selectDebtorinListScreen(debtID);
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.validateNoteScreen);
		  System.out.println(ExpectedResult+" : Make note screen");
		  CG_screen.closeModelDialog();
	  }
	@Test(priority = 16, description = "Open Notes History in 'Disputes on paid invoices' list screen with debtor selection", enabled = false)
	public void Open_NotesHistory_In_DisputesOnPaidInvoices_DebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Note History");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 17, description = "close'Disputes on paid invoices' list screen")
	public void Close_disputesonPaidInvListScreen() {
		CG_screen.CloseActionsListScreen();
	}
}