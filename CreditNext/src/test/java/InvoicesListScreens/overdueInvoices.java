package InvoicesListScreens;

import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import locatorPages.ListScreenLocators;
import pages.CustomeGroupsListScreenPage;

@Listeners(ScreenShotOnFailure.class)
public class overdueInvoices extends TestListenerAdapter {
	WebDriver driver = null;
	CustomeGroupsListScreenPage CG_screen = null;
	String noRowsSelected = "You must select at least one row";
	String InvNum = "2015P7051185239300001";

	@Test(priority = 1, description = "Open 'Overdue Invoices' list screen")
	public void Open_IOverdueInvoices_List_screen() {
		driver = WebDriverManager.getDriverInstance();
		CG_screen = new CustomeGroupsListScreenPage(driver);
		String ExpectedResult = CG_screen.OpenCustomerGroupsListScreen(ListScreenLocators.overdueInvoices);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Overdue invoices");
	}

	@Test(priority = 2, description = "Open Invoice Report in 'Overdue Invoices' list screen without invoice selection")
	public void Open_InvoiceReport_In_Overdue_Invoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 3, description = "Open Export to Excel in 'Overdue Invoices' list screen without invoice selection")
	public void Open_ExporttoExcel_In_Overdue_Invoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
		// CG_screen.CloseAllCustomerGroupListScreen();
	}

	@Test(priority = 4, description = "Open Advance Search in 'Overdue Invoices' list screen without invoice selection")
	public void Open_AdvanceSearch_In_Overdue_Invoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.windowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 5, description = "Open Invoice Information Screen in 'Overdue Invoices' list screen without invoice selection")
	public void Open_CIS_In_Overdue_Invoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 6, description = "Open Invoice Details in 'Overdue Invoices' list screen without invoice selection")
	public void Open_InvoiceDetails_In_Overdue_Invoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.invDetailsIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 7, description = "Open Make Note in 'Overdue Invoices' list screen without invoice selection")
	public void Open_MakeNote_In_Overdue_Invoices_List_screen() { String
	  ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 8, description ="Open Committed Payments in 'Overdue Invoices' list screen without invoice selection")
	public void Open_CommittedPayments_In_Overdue_Invoices_List_screen() {
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.committedPaymentIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 9, description ="Open Payment Scheme in 'Overdue Invoices' list screen without invoice selection")
	public void Open_PaymentScheme_In_Overdue_Invoices_List_screen() {
	  String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.paymentSchemeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 10, description ="Open Register Dispute in 'Overdue Invoices' list screen without invoice selection")
	public void Open_RegisterDispute_In_Overdue_Invoices_List_screen() {
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.registerDisputeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }

	@Test(priority = 11, description ="Open Notes History in 'Overdue Invoices' list screen without invoice selection")
	public void Open_NotesHistory_In_Overdue_Invoices_List_screen() {
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon, ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	  
	@Test(priority = 12, description = "Open Committed Payment History in 'Overdue Invoices' list screen without invoice selection") 
	public void Open_CommittedPaymentHistory_In_Overdue_Invoices_List_screen() { 
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyCommittedPaymentIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}
	  
	@Test(priority = 13, description ="Open Payment Schemes History in 'Overdue Invoices' list screen without invoice selection")
	public void Open_PaymentSchemesHistory_In_Overdue_Invoices_List_screen() { 
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyPaymentSchemeIcon, ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 14, description ="Open Disputes History in 'Overdue Invoices' list screen without invoice selection")
	public void Open_DisputeHistory_In_Overdue_Invoices_List_screen() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDisputeIcon,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 15, description ="Open Invoice User Fields in 'Overdue Invoices' list screen without invoice selection")
	public void Open_InvoiceUserFields_In_Overdue_Invoices_List_screen() {
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.invUDFFieldsIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	  
	@Test(priority = 16, description ="Open Assign Invoice Properties in 'Overdue Invoices' list screen without invoice selection")
	public void Open_AssignInvoiceProperties_In_Overdue_Invoices_List_screen() { 
	  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.assignInvoicePropertiesIcon,ListScreenLocators.noRowsSelected);
	  CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	}

	@Test(priority = 17, description ="Open Onguard date and CA Status in 'Overdue Invoices' list screen without invoice selection")
	public void Open_ChangeOnguardDateandCAStatusHistory_In_Overdue_Invoices_List_screen() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.changeOGdateandCAStatus,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	@Test(priority = 18, description ="Open partials payments in 'Overdue Invoices' list screen without invoice selection")
	public void Open_showPartialPayment_In_Overdue_Invoices_List_screen() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.showPartialPayment,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	@Test(priority = 19, description ="Open Invoice total in 'Overdue Invoices' list screen without invoice selection")
	public void Open_InvoiceTotal_In_Overdue_Invoices_List_screen() {
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.invTotal,ListScreenLocators.noRowsSelected);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, noRowsSelected);
	  }
	@Test(priority = 20, description ="Open Help Page in 'Overdue Invoices' list screen without invoice selection") 
	public void Open_HelpPage_In_Overdue_Invoices_List_screen() { 
		String ExpectedResult =CG_screen.OpenhelpPage();
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard CreditNext"); 
		//CG_screen.ValidateOpenedListScreen(ExpectedResult, "Help file Onguard Connext"); 
	  } 
	@Test(priority = 21, description = "Open Invoice Report in 'Overdue Invoices' list screen with invoice selection")
	public void Open_InvoiceReport_c() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.ReportIcon,ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Reports");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 22, description = "Open Export to Excel in 'Overdue Invoices' list screen with invoice selection")
	public void Open_ExporttoExcel_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.excelToExportIcon, ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Export options");
		CG_screen.closeDataModelDialog();
	}

	@Test(priority = 23, description = "Open Advance Search in 'Overdue Invoices' list screen with invoice selection")
	public void Open_AdvanceSearch_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.advanceSearchIcon, ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Advanced search");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 24, description = "Open Invoice Information Screen in 'Overdue Invoices' list screen with invoice selection")
	public void Open_CIS_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.cisICon,ListScreenLocators.validateDebtorInCIS);
		System.out.println(ExpectedResult + "windows opened");
		CG_screen.closeCIS();
	}

	@Test(priority = 25, description = "Open Invoice Details in 'Overdue Invoices' list screen with invoice selection")
	public void Open_InvoiceDetails_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.invDetailsIcon, ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Invoice details");
		CG_screen.closeModelDialog();
	}

	@Test(priority = 26, description = "Open Make Note in 'Overdue Invoices' list screen with invoice selection")
	public void Open_MakeNote_with_OverdueInvoiceSelection() { 
		 CG_screen.selectDebtorinListScreen(InvNum);
		 String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.makeNoteIcon , ListScreenLocators.validateNoteScreen);
		 System.out.println(ExpectedResult+" : Make note screen");
		 CG_screen.closeModelDialog();
	  }

	@Test(priority = 27, description ="Open Committed Payments in 'Overdue Invoices' list screen with invoice selection")
	public void Open_CommittedPayments_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.committedPaymentIcon, ListScreenLocators.validateDebtorInCIS);
		System.out.println(ExpectedResult+"Committed Paymets");
		CG_screen.closeCIS(); 
	  }

	@Test(priority = 28, description ="Open Payment Scheme in 'Overdue Invoices' list screen with invoice selection")
	public void Open_PaymentScheme_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult = CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.paymentSchemeIcon, ListScreenLocators.validateDebtorInCIS);
		System.out.println(ExpectedResult + "Payment scheme");
		CG_screen.closeCIS();
	  }

	@Test(priority = 29, description ="Open Register Dispute in 'Overdue Invoices' list screen with invoice selection")
	public void Open_RegisterDispute_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.registerDisputeIcon, ListScreenLocators.validateDebtorInCIS);
		System.out.println(ExpectedResult + "Register Dispute");
		CG_screen.closeCIS();
	  }

	@Test(priority = 30, description ="Open Notes History in 'Overdue Invoices' list screen with invoice selection")
	public void Open_NotesHistory_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult=CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyNotesIcon, ListScreenLocators.invWindowTitleText);
		System.out.println(ExpectedResult + " :Note History");
		CG_screen.closeModelDialog();
	  }
	  
	  @Test(priority = 31, description = "Open Committed Payment History in 'Overdue Invoices' list screen with invoice selection") 
	  public void Open_CommittedPaymentHistory_with_OverdueInvoiceSelection() { 
		  CG_screen.selectDebtorinListScreen(InvNum);
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyCommittedPaymentIcon, ListScreenLocators.invWindowTitleText);
		  System.out.println(ExpectedResult + " :Committed payment History");
		  CG_screen.closeModelDialog();
	  }
	  
	  @Test(priority = 32, description ="Open Payment Schemes History in 'Overdue Invoices' list screen with invoice selection")
	  public void Open_PaymentSchemesHistory_with_OverdueInvoiceSelection() { 
		  CG_screen.selectDebtorinListScreen(InvNum);
		  String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyPaymentSchemeIcon, ListScreenLocators.invWindowTitleText);
		  System.out.println(ExpectedResult + " :Payment Scheme History");
		  CG_screen.closeModelDialog();
	  }

	@Test(priority = 33, description ="Open Disputes History in 'Overdue Invoices' list screen with invoice selection")
	public void Open_DisputeHistory_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.historyDisputeIcon,ListScreenLocators.invWindowTitleText);
		System.out.println(ExpectedResult + " :Dispute History");
		CG_screen.closeModelDialog();
	  }

	@Test(priority = 34, description ="Open Invoice User Fields in 'Overdue Invoices' list screen with invoice selection")
	public void Open_InvoiceUserFields_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.invUDFFieldsIcon,ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Invoice User field insertion");
		CG_screen.closeModelDialog();
	  }
	  
	 @Test(priority = 35, description ="Open Assign Invoice Properties in 'Overdue Invoices' list screen with invoice selection")
	 public void Open_AssignInvoiceProperties_with_OverdueInvoiceSelection() throws InterruptedException { 
		// CG_screen.selectDebtorinListScreenAnyCondition(InvNum);
		 Thread.sleep(5000);
		 CG_screen.selectDebtorinListScreen(InvNum);
		 String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.assignInvoicePropertiesIcon,ListScreenLocators.assignInvPropertiesText);
		 CG_screen.ValidateOpenedListScreen(ExpectedResult, "Assign invoice properties");
		 CG_screen.closeDataModelDialog();
	  }

	@Test(priority = 36, description ="Open Change Onguard date and CA Status in 'Overdue Invoices' list screen with invoice selection")
	public void Open_ChangeOnguardDateandCAStatusHistory_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.changeOGdateandCAStatus,ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Change Onguard days and collection agency status");
		CG_screen.closeDataModelDialog();
	  }
	@Test(priority = 37, description ="Open Partial payments in 'Overdue Invoices' list screen with invoice selection")
	public void Open_showPartialPayment_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.showPartialPayment,ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Partial payments");
		CG_screen.closeDataModelDialog();
	  }
	@Test(priority = 38, description ="Open Invoice totals in 'Overdue Invoices' list screen with invoice selection")
	public void Open_InvoiceTotal_with_OverdueInvoiceSelection() {
		CG_screen.selectDebtorinListScreen(InvNum);
		String ExpectedResult =CG_screen.OpentoolBarIconInCustonerGroupsListScreen(ListScreenLocators.invTotal,ListScreenLocators.invWindowTitleText);
		CG_screen.ValidateOpenedListScreen(ExpectedResult, "Invoice totals");
		CG_screen.closeDataModelDialog();
	  }
	@Test(priority = 39, description = "Close 'Overdue Invoices'list screen")
	public void Close_OverdueInvoicesListscreen() {
		CG_screen.CloseAllCustomerGroupListScreen();
	}
}