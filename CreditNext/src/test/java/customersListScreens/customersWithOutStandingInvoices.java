package customersListScreens;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import locatorPages.ListScreenLocators;
import pages.CustomeGroupsListScreenPage;

@Listeners(ScreenShotOnFailure.class)
public class customersWithOutStandingInvoices extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String debtID = "1094933";

	@Test(priority = 1, description = "Open 'Customers with Outstanding Balance' list screen")
	public void Open_customersWithOutStandingInvoices_List_screen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.C_outstandingInv);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Debtors with outstanding invoices");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customers with outstanding invoices");
	}

	@Test(priority = 2, description = "Open Customer Report in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_CustomerReport_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 3, description = "Open Export to Excel in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_ExporttoExcel_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 4, description = "Open Advance Search in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_AdvanceSearch_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 5, description = "Open Customer Information Screen in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_CIS_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 6, description = "Open Customer Details in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_CustomerDetails_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerDetailsIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 7, description = "Open Customer Contacts in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_Contacts_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.contactIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 8, description = "Open Make Note in 'Customers with Outstanding Balance' list screen without debtor selection"
	  ) public void Open_MakeNote_customersWithOutStandingInvoices() { 
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.noRowsSelected);
	    CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 9, description ="Open Committed Payments in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_CommittedPayments_customersWithOutStandingInvoices() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.committedPaymentIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 11, description ="Open Payment Scheme in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_PaymentScheme_customersWithOutStandingInvoices() {
	  String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.paymentSchemeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 12, description ="Open Register Dispute in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_RegisterDispute_customersWithOutStandingInvoices() {
	  String ExpectedResult
	  =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.registerDisputeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 13, description ="Open Create Request Action in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_CreateRequestAction_customersWithOutStandingInvoices()
	  { String ExpectedResult
	  =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.createRequestIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 14, description =
	  "Open Block Customer in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_BlockCustomer_customersWithOutStandingInvoices() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.blockCustomer,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 15, description ="Open Unblock Customer in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_UnblockCustomer_customersWithOutStandingInvoices() {
	  String ExpectedResult  =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.unblockCustomer, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 16, description ="Open Notes History in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_NotesHistory_customersWithOutStandingInvoices() {
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	  
	  @Test(priority = 17, description = "Open Committed Payment History in 'Customers with Outstanding Balance' list screen without debtor selection"
	  ) 
	  public void Open_CommittedPaymentHistory_customersWithOutStandingInvoices() { 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyCommittedPaymentIcon, ListScreenLocators.noRowsSelected);
		  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	  
	  @Test(priority = 18, description ="Open Payment Schemes History in 'Customers with Outstanding Balance' list screen without debtor selection")
	  public void Open_PaymentSchemesHistory_customersWithOutStandingInvoices() { 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyPaymentSchemeIcon, ListScreenLocators.noRowsSelected);
		  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 19, description ="Open Disputes History in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_DisputeHistory_customersWithOutStandingInvoices() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDisputeIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 20, description ="Open Dunning Letter History in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_DunningLetterHistory_customersWithOutStandingInvoices()
	  { 
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDunningLetter,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 21, description ="Open Email History in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_EmailHistory_customersWithOutStandingInvoices() {
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyEmailsIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 22, description ="Open SMS History in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_SMSHistory_customersWithOutStandingInvoices() { 
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historySms,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 23, description ="Open List of Outstanding Invoices in 'Customers with Outstanding Balance' list screen without debtor selection") 
	public void Open_OutstandingInvList_customersWithOutStandingInvoices() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofOutstandingInvIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 24, description = "Open List of Invoices Paid in 'Customers with Outstanding Balance' list screen without debtor selection") 
	public void Open_PaidInvList_customersWithOutStandingInvoices() { 
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofPaidInvIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 25, description ="Open Customer User Fields in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_CustomerUserFields_customersWithOutStandingInvoices() {
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerUserFieldsIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	  
	  @Test(priority = 26, description ="Open Assign Customer Properties in 'Customers with Outstanding Balance' list screen without debtor selection")
	  public void Open_AssignCustomerProperties_customersWithOutStandingInvoices() { 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.assignCustomerPropertiesIcon,ListScreenLocators.noRowsSelected);
		  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 27, description ="Open Customer Groups in 'Customers with Outstanding Balance' list screen without debtor selection")
	public void Open_ActivateCustomer_customersWithOutStandingInvoices() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.activateCustomerIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 28, description ="Open Help Page in 'Customers with Outstanding Balance' list screen without debtor selection") 
	public void Open_HelpPage_customersWithOutStandingInvoices() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard CreditNext");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard Connext");
	  }

	@Test(priority = 29, description = "Open Customer Report in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_CustomerReportDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Reports");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 30, description = "Open Export to Excel in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_ExporttoExcelDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 31, description = "Open Advance Search in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_AdvanceSearchDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 32, description = "Open Customer Information Screen in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_CISDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "windows opened");
		CG_screen.closeCIS();
	}

	@Test(priority = 33, description = "Open Customer Details in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_CustomerDetailsDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerDetailsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Debtor details");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customer details");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 34, description = "Open Customer Contacts in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_ContactsDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.contactIcon,ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Contact");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 35, description ="Open Make Note in 'Customers with Outstanding Balance' list screen with debtor selection")
	  public void Open_MakeNoteDebtorSelection_customersWithOutStandingInvoices() { 
		CG_screen.selectDebtorinListScreen(debtID);
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.validateNoteScreen);
		  System.out.println(ExpectedResult+" : Make note screen");
		  CG_screen.closeModelDialog();
	  }

	@Test(priority = 36, description =
	  "Open Committed Payments in 'Customers with Outstanding Balance' list screen with debtor selection")
	   public void  Open_CommittedPaymentsDebtorSelection_customersWithOutStandingInvoices() {
		  CG_screen.selectDebtorinListScreen(debtID); 
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.committedPaymentIcon, ListScreenLocators.windowTitleText);
		  System.out.println(ExpectedResult+"Committed Paymets");
		  //CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		  CG_screen.closeCIS(); 
		  }

	@Test(priority = 37, description = "Open Payment Scheme in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_PaymentSchemeDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.paymentSchemeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Payment scheme");
		CG_screen.closeCIS();
	}

	@Test(priority = 38, description = "Open Register Dispute in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_RegisterDisputeDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.registerDisputeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Register Dispute");
		CG_screen.closeCIS();
	}

	@Test(priority = 39, description = "Open Create Request Action in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_CreateRequestActionDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.createRequestIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + "Create request");
		CG_screen.closeCIS();
	}

	@Test(priority = 40, description = "Open Block Customer in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_BlockCustomerDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.blockCustomer,ListScreenLocators.validateNoteScreen);
		System.out.println(ExpectedResult + " :Block Customer");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 41, description = "Open Unblock Customer in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_UnblockCustomerDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.unblockCustomer,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Unblock Customer");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 42, description = "Open Notes History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_NotesHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Note History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 43, description = "Open Committed Payment History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_CommittedPaymentHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyCommittedPaymentIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Committed payment History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 44, description = "Open Payment Schemes History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_PaymentSchemesHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyPaymentSchemeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Payment Scheme History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 45, description = "Open Disputes History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_DisputeHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDisputeIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Dispute History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 46, description = "Open Dunning Letter History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_DunningLetterHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDunningLetter, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Dunning letter History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 47, description = "Open Email History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_EmailHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyEmailsIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :Email History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 48, description = "Open SMS History in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_SMSHistoryDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historySms,ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :SMS History");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 49, description = "Open List of Outstanding Invoices in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_OutstandingInvListDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofOutstandingInvIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :List of Outstanding Invoices");
		CG_screen.closeCIS();
	}

	@Test(priority = 50, description = "Open List of Invoices Paid in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_PaidInvListDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.listofPaidInvIcon, ListScreenLocators.windowTitleText);
		System.out.println(ExpectedResult + " :List of Paid Invoices");
		CG_screen.closeCIS();
	}

	@Test(priority = 51, description = "Open Customer User Fields in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_CustomerUserFieldsDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.customerUserFieldsIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Debtor User field insertion");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Customer User field insertion");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 52, description = "Open Assign Customer Properties in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_AssignCustomerPropertiesDebtorSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.assignCustomerPropertiesIcon, ListScreenLocators.validateAssignCustomerProperties);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Assign debtor properties");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Assign customer properties");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 53, description = "Open Activate customer in 'Customers with Outstanding Balance' list screen with debtor selection")
	public void Open_ActivateCustomerInSelection_customersWithOutStandingInvoices() {
		CG_screen.selectDebtorinListScreen(debtID);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.activateCustomerIcon, ListScreenLocators.popupTitleText);
		//String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.activateCustomerIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "0 Debtors Activated");
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "0 Customers Activated");
		CG_screen.closeActivateDebtorScreen();
	}
	@Test(priority = 54, description = "Close 'Customers with Outstanding Balance' list screen")
	public void Close_customersWithOutStandingInvoices_Listscreen() {
		CG_screen.CloseAllCustomerGroupListScreen();
	}

}