package locatorPages;

import org.openqa.selenium.By;

public class ListScreenLocators {
	//********************************************CUSTOMERS LIST SCREEN******************************//
	//MenuList HomePage
	 public static By TestMenuItem = By.xpath("//div[@id='side-navigation']//div/ul/li[1]/a[1]");
	 public static By CustomerGroupsMenuItem = By.xpath("//div[@id='side-navigation']//div/ul/li[2]/a[1]");
	 public static By CustomersMenuItem = By.xpath("//div[@id='side-navigation']//div/ul/li[3]/a[1]");
     public static By InvoicesMenuItems = By.xpath("//div[@id='side-navigation']//div/ul/li[4]/a[1]");
     public static By ActionsMenuItems = By.xpath("//div[@id='side-navigation']//div/ul/li[5]/a[1]");
     public static By DisputesMenuItems = By.xpath("//div[@id='side-navigation']//div/ul/li[6]/a[1]");
     public static By RequestsMenuItems = By.xpath("//div[@id='side-navigation']//div/ul/li[7]/a[1]");
     public static By HelpMenuItems = By.xpath("//div[@id='side-navigation']//div/ul/li[8]/a[1]");
     public static By ListScreenTitle = By.xpath("//div[@id='all-debators-window']/div/div/div[1]/div/span");
   
     //Customers groups child Menu Items
     
	 public static By CG_All = By.xpath("//div[@id='side-navigation']//li[2]//div[1]//a[1]");
	 public static By CG_outstandingInv = By.xpath("//div[@id='side-navigation']//li[2]//div[1]//a[2]");
     public static By CG_balanceOverdue = By.xpath("//div[@id='side-navigation']//li[2]//div[1]//a[3]");
     public static By CG_CreditLtdExceeed = By.xpath("//div[@id='side-navigation']//li[2]//div[1]//a[4]");    
     
     public static By closeListScreen = By.xpath("//a[contains(@class,'btn-box close-window')]"); //Close List Screen
     public static By minimizeListScreen = By.xpath("//a[contains(@class,'btn-box close-window')]"); //Minimize List Screen
     public static By cisButton= By.xpath("//img[@title='Customer information screen']");
   
     //Customers child Menu Items
     
   	 public static By allCustomers = By.xpath("//div[@id='side-navigation']//li[3]//div[1]//a[1]");
   	 public static By C_outstandingInv = By.xpath("//div[@id='side-navigation']//li[3]//div[1]//a[3]");
     public static By C_balanceOverdue = By.xpath("//div[@id='side-navigation']//li[3]//div[1]//a[4]");
     public static By C_CreditLtdExceeed = By.xpath("//div[@id='side-navigation']//li[3]//div[1]//a[5]"); 
     
     //List screen Menu toolbar icons
     public static By ReportIcon = By.xpath("//img[@title='Reports']");
     public static By excelToExportIcon = By.xpath("//img[@title='Export to Excel']");
     public static By advanceSearchIcon = By.xpath("//img[@title='Advanced search']");
     public static By cisICon = By.xpath("//img[@title='Customer information screen']");
     public static By customerDetailsIcon = By.xpath("//img[@title='Debtor details']");      //img[@title='Customer details']
     public static By contactIcon = By.xpath("//img[@title='Contacts']");
     public static By makeNoteIcon = By.xpath("//img[@title='Make note']");
     public static By committedPaymentIcon = By.xpath("//img[@title='Committed payments']");  
     public static By paymentSchemeIcon = By.xpath("//img[@title='Payment scheme']");
     public static By registerDisputeIcon = By.xpath("//img[@title='Register dispute']");
     public static By createRequestIcon = By.xpath("//img[@title='Create request action']");
     public static By unblockCustomer = By.xpath("//img[@title='Unblock debtor']");     //img[@title='Unblock customer']
     public static By blockCustomer = By.xpath("//img[@title='Block debtor']");        //img[@title='Block customer']
     public static By historyNotesIcon = By.xpath("//img[@title='Notes']");
     public static By historyCommittedPaymentIcon = By.xpath("//img[@title='History committed payments']");
     public static By historyPaymentSchemeIcon = By.xpath("//img[@title='History payment schemes']");
     public static By historyDisputeIcon = By.xpath("//img[@title='History disputes']");
     public static By historyDunningLetter = By.xpath("//img[@title='History dunning letters']");
     public static By historyEmailsIcon = By.xpath("//img[@title='History emails']");
     public static By customerUserFields = By.xpath("//img[@title='Customer user fields']");
     public static By historySms = By.xpath("//img[@title='History SMS']");
     public static By listofOutstandingInvIcon = By.xpath("//img[@title='List of outstanding invoices']");
     public static By listofPaidInvIcon = By.xpath("//img[@title='List of invoices paid']");
     public static By customerUserFieldsIcon = By.xpath("//img[@title='Debtor user fields']");  //img[@title='Customer user fields']
     public static By assignCustomerPropertiesIcon = By.xpath("//img[@title='Assign debtor properties']");  // //img[@title='Assign customer properties']
     public static By customerGroupsIcon = By.xpath("//img[@title='Customer groups']"); 
     public static By activateCustomerIcon = By.xpath("//img[@title='Activate debtor']");   //  //img[@title='Activate customer']
     public static By heplIcon = By.xpath("//img[@title='Help']");
     public static By hepltext = By.xpath("//img[@title='Help']");
     public static By noRowsSelected = By.xpath("//div[starts-with(@class,'p-toast-detail') or @class='ui-toast-detail']");    //    ("//div[@class='ui-toast-detail']")
     public static By windowTitleText = By.cssSelector("div[class='col no-padding justify-content-start'] span[class='window-title-text']");
     public static By popupTitleText = By.xpath("//div[starts-with(@class,'p-toast-message-content')]//following::p");
     public static By closeModelDialog = By.xpath("//img[@alt='Cancel']");
     public static By closeDataModel = By.xpath("//a[@data-dismiss='modal']");
     public static By closeCISWindow = By.xpath("//a[@class='btn-box close-window']");
     public static By validateDebtorInCIS = By.xpath("//span[@class='selected-debtors-name']");
     public static By validateNoteScreen = By.xpath("//span[@class='window-title-text ng-star-inserted']");
     public static By validateAssignCustomerProperties = By.xpath("//span[@class='window-title-text'][normalize-space()='Assign debtor properties']");    // //span[@class='window-title-text'][normalize-space()='Assign customer properties']
     //Debtor selection
     public static By selectdebtor = By.xpath("//div[@role='presentation']//div[4]//div[1]//div[1]//span[1]//span[2]");
     public static By proceedUsedDebtor = By.xpath("//button[normalize-space()='Proceed']");
     public static By UsedDebtorScreen = By.cssSelector("div[class='ng-star-inserted'] p");
     
     //********************************************INVOICES LIST SCREEN******************************//
     
//Customers child Menu Items
     
   	 public static By allInvoices = By.xpath("//div[@id='side-navigation']//li[4]//div[1]//a[1]");
   	 public static By paidInvoices = By.xpath("//div[@id='side-navigation']//li[4]//div[1]//a[2]");
     public static By outstandingInvoices = By.xpath("//div[@id='side-navigation']//li[4]//div[1]//a[3]");
     public static By overdueInvoices = By.xpath("//div[@id='side-navigation']//li[4]//div[1]//a[4]"); 
 
   //Customers child Menu Items
     public static By invDetailsIcon = By.xpath("//img[@title='Invoice details']");  
     public static By invUDFFieldsIcon = By.xpath("//img[@title='Invoice user fields']"); 
     public static By assignInvoicePropertiesIcon = By.xpath("//img[@title='Assign invoice properties']");
     public static By changeOGdateandCAStatus = By.xpath("//img[@title='Change Test days and collection agency status']");
     public static By showPartialPayment = By.xpath("//img[@title='Show partial payments']");
     public static By invTotal = By.xpath("//img[@title='Invoice totals']");
     
     public static By invWindowTitleText = By.xpath("//div[@class='col no-padding justify-content-start']/span"); 
     public static By assignInvPropertiesText = By.xpath("//div[@class='col no-padding justify-content-start ng-star-inserted']/span");
   
     public static By okButton = By.xpath("//button[normalize-space()='Ok']");  
     
   //********************************************Actions LIST SCREEN******************************//
     
   	 public static By allactionsMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[1]");
   	 public static By letteractionsMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[2]");
     public static By telephoneActionsMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[3]");
     public static By reminderActionsMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[4]"); 
     public static By caActionMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[5]");
     public static By emailActionsMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[6]"); 
     public static By QueryOverdueActionMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[7]");
     public static By committedPaymentActionMenuItem = By.xpath("//div[@id='side-navigation']//li[5]//div[1]//a[8]");
     
     //Actions List Screen icons
     public static By deleteActionsIcon = By.xpath("//img[@title='Delete actions']");
     public static By bulkSendToCollectionAgencyIcon = By.xpath("//img[@title='Bulk send to collection agency']");
     public static By actionTypeInputField = By.xpath("//div[@id='main-content-wrap']//div[4]//div[1]//app-grid-filter[1]//div[1]//input[1]");
     
     
     //********************************************Disputes LIST SCREEN******************************//
     public static By aldisputesMenuItem = By.xpath("//div[@id='side-navigation']//li[6]//div[1]//a[1]");
   	 public static By disMgrMenuItem = By.xpath("//div[@id='side-navigation']//li[6]//div[1]//a[2]");
     public static By outstandingQueries = By.xpath("//div[@id='side-navigation']//li[6]//div[1]//a[3]");
     public static By disputesOverdue = By.xpath("//div[@id='side-navigation']//li[6]//div[1]//a[4]"); 
     public static By closedDisputes = By.xpath("//div[@id='side-navigation']//li[6]//div[1]//a[5]");
     public static By disputesonPaidInv = By.xpath("//div[@id='side-navigation']//li[6]//div[1]//a[6]"); 
     
     public static By bulkChangeDisputeIcon = By.xpath("//ul[@class='toolbar']/li[5]");
     public static By DisputeDetailsIcon = By.xpath("//ul[@class='toolbar']/li[6]");
     
   //********************************************Requests LIST SCREEN******************************//
     public static By alRequestsMenuItem = By.xpath("//div[@id='side-navigation']//li[7]//div[1]//a[1]");
   	 public static By pendingRequestsMenuItem = By.xpath("//div[@id='side-navigation']//li[7]//div[1]//a[2]");
     public static By receivedReqMenuItem = By.xpath("//div[@id='side-navigation']//li[7]//div[1]//a[3]");
     public static By sentRequestMenuItem = By.xpath("//div[@id='side-navigation']//li[7]//div[1]//a[4]"); 
     public static By receivedResponseMenuItem = By.xpath("//div[@id='side-navigation']//li[7]//div[1]//a[5]");
   
    
}
