package customerGroupsListScreens;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import locatorPages.ListScreenLocators;
import pages.CustomeGroupsListScreenPage;

@Listeners(ScreenShotOnFailure.class)
public class customerGroupsWithBalanceOverdue extends TestListenerAdapter {
	WebDriver driver;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "1094958";

	@Test(priority = 1, description = "Open 'Customer Groups with Balance Overdue' list screen")
	public void Open_customerGroupsWithBalanceOverdueListscreen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.CG_balanceOverdue);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customer groups with balance overdue");
	}

	@Test(priority = 2, description = "Open Customer Report in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CustomerReport() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		// CG_screen.CloseAllCustomerGroupListScreen();
	}

	@Test(priority = 3, description = "Open Export to Excel in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_ExporttoExcel() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		// CG_screen.CloseAllCustomerGroupListScreen();
	}

	@Test(priority = 4, description = "Open Advance Search in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_AdvanceSearch() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 5, description = "Open Customer Information Screen in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CIS() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		// CG_screen.CloseAllCustomerGroupListScreen();
	}

	@Test(priority = 6, description = "Open Customer Details in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CustomerDetails() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerDetailsIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		// CG_screen.CloseAllCustomerGroupListScreen();
	}

	@Test(priority = 7, description = "Open Customer Contacts in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_Contacts() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.contactIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		// CG_screen.CloseAllCustomerGroupListScreen();
	}

	@Test(priority = 8, description = "Open Make Note in 'Customer Groups with Balance Overdue' list screen without debtor selection"
	  ) public void Open_MakeNote() { 
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.noRowsSelected);
	    CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 9, description ="Open Committed Payments in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CommittedPayments() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.committedPaymentIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		//CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 11, description ="Open Payment Scheme in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_PaymentScheme() {
	  String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.paymentSchemeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 12, description ="Open Register Dispute in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_RegisterDispute() {
	  String ExpectedResult
	  =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.registerDisputeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 13, description ="Open Create Request Action in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CreateRequestAction()
	  { String ExpectedResult
	  =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.createRequestIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen();
	  }

	@Test(priority = 14, description =
	  "Open Block Customer in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_BlockCustomer() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.blockCustomer,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 15, description ="Open Unblock Customer in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_UnblockCustomer() {
	  String ExpectedResult  =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.unblockCustomer, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen();
	  }

	@Test(priority = 16, description ="Open Notes History in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_NotesHistory() {
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }
	  
	  @Test(priority = 17, description = "Open Committed Payment History in 'Customer Groups with Balance Overdue' list screen without debtor selection"
	  ) 
	  public void Open_CommittedPaymentHistory() { 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyCommittedPaymentIcon, ListScreenLocators.noRowsSelected);
		  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }
	  
	  @Test(priority = 18, description ="Open Payment Schemes History in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	  public void Open_PaymentSchemesHistory() { 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyPaymentSchemeIcon, ListScreenLocators.noRowsSelected);
		  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		  //CG_screen.CloseAllCustomerGroupListScreen();
	  }

	@Test(priority = 19, description ="Open Disputes History in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_DisputeHistory() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDisputeIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 20, description ="Open Dunning Letter History in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_DunningLetterHistory()
	  { 
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDunningLetter,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 21, description ="Open Email History in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_EmailHistory() {
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyEmailsIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 22, description ="Open SMS History in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_SMSHistory() { 
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historySms,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 23, description ="Open List of Outstanding Invoices in 'Customer Groups with Balance Overdue' list screen without debtor selection") 
	public void Open_OutstandingInvList() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofOutstandingInvIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen();
	  }

	@Test(priority = 24, description = "Open List of Invoices Paid in 'Customer Groups with Balance Overdue' list screen without debtor selection") 
	public void Open_PaidInvList() { 
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofPaidInvIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 25, description ="Open Customer User Fields in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CustomerUserFields() {
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerUserFieldsIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen();
	  }
	  
	  @Test(priority = 26, description ="Open Assign Customer Properties in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	  public void Open_AssignCustomerProperties() { 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.assignCustomerPropertiesIcon,ListScreenLocators.noRowsSelected);
		  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 27, description ="Open Customer Groups in 'Customer Groups with Balance Overdue' list screen without debtor selection")
	public void Open_CustomerGroups() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.
		customerGroupsIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 28, description ="Open Help Page in 'Customer Groups with Balance Overdue' list screen without debtor selection") 
	public void Open_HelpPage() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test CreditNext");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Test Connext");
	  //CG_screen.CloseAllCustomerGroupListScreen(); 
	  }

	@Test(priority = 29, description = "Open Customer Report in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CustomerReportDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Reports");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 30, description = "Open Export to Excel in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_ExporttoExcelDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 31, description = "Open Advance Search in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_AdvanceSearchDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 32, description = "Open Customer Information Screen in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CISDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "windows opened");
		CG_screen.closeCIS();
	}

	@Test(priority = 33, description = "Open Customer Details in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CustomerDetailsDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerDetailsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Debtor details");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customer details");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 34, description = "Open Customer Contacts in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_ContactsDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.contactIcon,ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Contact");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 35, description ="Open Make Note in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	  public void Open_MakeNoteDebtorSelection() { 
		CG_screen.selectDebtorinListScreen(debtID);
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.validateNoteScreen);
		  System.out.println(ExpectedResult+" : Make note screen");
		  CG_screen.closeModelDialog();
	  }

	@Test(priority = 36, description =
	  "Open Committed Payments in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	   public void  Open_CommittedPaymentsDebtorSelection() {
		  CG_screen.selectDebtorinListScreen(debtID); 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.committedPaymentIcon, ListScreenLocators.windowTitleText);
		  System.out.println(ExpectedResult+"Committed Paymets");
		  //CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		  CG_screen.closeCIS(); 
		  }

	@Test(priority = 37, description = "Open Payment Scheme in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_PaymentSchemeDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.paymentSchemeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Payment scheme");
		CG_screen.closeCIS();
	}

	@Test(priority = 38, description = "Open Register Dispute in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_RegisterDisputeDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.registerDisputeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Register Dispute");
		CG_screen.closeCIS();
	}

	@Test(priority = 39, description = "Open Create Request Action in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CreateRequestActionDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.createRequestIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Create request");
		CG_screen.closeCIS();
	}

	@Test(priority = 40, description = "Open Block Customer in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_BlockCustomerDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.blockCustomer,ListScreenLocators.validateNoteScreen);
		System.out.println(ExpectedResult + " :Block Customer");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 41, description = "Open Unblock Customer in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_UnblockCustomerDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.unblockCustomer,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Unblock Customer");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 42, description = "Open Notes History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_NotesHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Note History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 43, description = "Open Committed Payment History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CommittedPaymentHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyCommittedPaymentIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Committed payment History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 44, description = "Open Payment Schemes History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_PaymentSchemesHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyPaymentSchemeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Payment Scheme History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 45, description = "Open Disputes History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_DisputeHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDisputeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Dispute History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 46, description = "Open Dunning Letter History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_DunningLetterHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDunningLetter, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Dunning letter History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 47, description = "Open Email History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_EmailHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyEmailsIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Email History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 48, description = "Open SMS History in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_SMSHistoryDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historySms,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :SMS History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 49, description = "Open List of Outstanding Invoices in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_OutstandingInvListDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofOutstandingInvIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :List of Outstanding Invoices");
		CG_screen.closeCIS();
	}

	@Test(priority = 50, description = "Open List of Invoices Paid in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_PaidInvListDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofPaidInvIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :List of Paid Invoices");
		CG_screen.closeCIS();
	}

	@Test(priority = 51, description = "Open Customer User Fields in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CustomerUserFieldsDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerUserFieldsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Debtor User field insertion");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customer User field insertion");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 52, description = "Open Assign Customer Properties in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_AssignCustomerPropertiesDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.assignCustomerPropertiesIcon, ListScreenLocators.validateAssignCustomerProperties);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Assign debtor properties");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Assign customer properties");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 53, description = "Open Customer Groups in 'Customer Groups with Balance Overdue' list screen with debtor selection")
	public void Open_CustomerGroupsDebtorSelection() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerGroupsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customer group");
		CG_screen.closeModelDialog();
	}
	@Test(priority = 54, description = "Close 'Customer Groups with Balance Overdue' list screen")
	public void Close_customerGroupsWithBalanceOverdueListscreen() {
		CG_screen.CloseAllCustomerGroupListScreen();
	}

}