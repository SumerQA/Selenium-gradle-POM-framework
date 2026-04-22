package appMan_Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.WebDriverManager;
import Event_commands.events;

public class Dunning_lang_Page {
	Common c = new Common();	
	final WebDriver driver;
	public  Dunning_lang_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	public void Goto_Dunning_lang_tab() throws IOException, InterruptedException {	
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Home_index_Page  hom = PageFactory.initElements(driver, Home_index_Page.class);
	  Functional_Configration_Page FC_page= PageFactory.initElements(driver, Functional_Configration_Page.class);
		/*
		 * hom.Select_Functional_Configration_Tab(); Thread.sleep(1500);
		 */
	  FC_page.Click_on_tables_tab();
	  Thread.sleep(2000);
	  hom.Render_Notifications();
	  Thread.sleep(1500);
	  FC_page.Click_on_Dunning_lang_tab();
	  Thread.sleep(2000);
	  hom.Render_Notifications();
	  Thread.sleep(1500);
	  }
	@Test
	 public void Crete_Dunning_lang_icon() throws IOException, InterruptedException {	
		Home_index_Page  hom = PageFactory.initElements(driver, Home_index_Page.class);
		events eve = new events(driver);
	  	eve.Click_event("Create_NewUser_panal");  
	  	Reporter.log("Dunning languages Tab is Clicked");
	  	hom.Render_Notifications();
	    }
	@Test
	 public void Update_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
	  	eve.Click_event("Change_Existing_User");  		
	    }
	@Test
	 public void Delete_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
	  	eve.Click_event("delete_user");  
	  	Reporter.log("Delete button is clicked");
	    }
  @Test
	 public void Enter_Dunning_Lang_Name(String path,String text) throws IOException {	
	    events eve = new events(driver);
	    eve.SendKey_event(path,text);
	    }
  @Test
	 public void Select_Linked_to_Login_lang(String path, String text) throws IOException {	
	  events eve = new events(driver);
	    eve.DropDown_list_event(path,text);
	    }
  @Test
	 public void Enter_Att(String path, String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_Dear(String path, String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_Att_male(String path, String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_Att_Female(String path, String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_DearSir(String path, String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_DearMadam(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Select_Settings_Tab(String path) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  eve.Click_event(path);
	  Reporter.log("Clicked on Settings tab");
	    }
  @Test
	 public void Check_mark_Committed_payment_checkbox(String comtext,String text) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  if(comtext.equals("Yes")){
		  if(driver.findElement(By.xpath(c.getElementName("mark_commotted_payments"))).isSelected()){
			  eve.SendKey_event("mark_commotted_payments_In_field", text);
			  Reporter.log(text +" : is Entered in Input field.");
			    }
		 else {
			 eve.Click_event("mark_commotted_payments");
			 eve.SendKey_event("mark_commotted_payments_In_field", text);
			 Reporter.log(text +" : is Entered in Input field.");
			  }   		
	  }else{
		  if(driver.findElement(By.xpath(c.getElementName("mark_commotted_payments"))).isSelected()){
			  eve.Click_event("mark_commotted_payments");
			  Reporter.log("mark commotted payments Checkbox is checked Now");
			    }
		 else {
			System.out.println("checkbox is unchecked already");
			Reporter.log("Checkbox is unchecked already");
			  }   		
	  }
	  }
	 
  @Test
	 public void Check_mark_overdue_Invoice_checkbox(String comtext,String text) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  if(comtext.equals("Yes")){
		  if(driver.findElement(By.xpath(c.getElementName("mark_overdue_invoice_checkbox"))).isSelected()){
			  eve.SendKey_event("mark_commotted_payments_In_field", text);
			  Reporter.log(text +" : is Entered in the input field");
			    }
		 else {
			 eve.Click_event("mark_overdue_invoice_checkbox");
			 eve.SendKey_event("mark_overdue_invoice_Infield", text);
			 Reporter.log(text +" : is Entered in the input field");
			  }   		
	  }else{
		  if(driver.findElement(By.xpath(c.getElementName("mark_overdue_invoice_checkbox"))).isSelected()){
			  eve.Click_event("mark_overdue_invoice_checkbox");
			    }
		 else {
			System.out.println("checkbox is unchecked already");
			  }   		
	  }
	  }
	  
  @Test
	 public void Check_mark_invoicesin_payment_Plan(String comtext,String text) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  if(comtext.equals("Yes")){
		  if(driver.findElement(By.xpath(c.getElementName("mark_invoicesin_payment_scheme_checkbox"))).isSelected()){
			  eve.SendKey_event("mark_invoicesin_payment_plan_Infield", text);
			  Reporter.log(text+ " : is Entered in  Mark invoices in payment schemes input field.");
			    }
		 else {
			 eve.Click_event("mark_invoicesin_payment_scheme_checkbox");
			 eve.SendKey_event("mark_invoicesin_payment_plan_Infield", text);
			 Reporter.log(text+ " : is Entered in  Mark invoices in payment schemes input field.");
			  }   		
	  }else{
		  if(driver.findElement(By.xpath(c.getElementName("mark_invoicesin_payment_scheme_checkbox"))).isSelected()){
			  eve.Click_event("mark_invoicesin_payment_scheme_checkbox");
			    }
		 else {
			System.out.println("checkbox is unchecked already");
			  }   		
	  }
	  }
  @Test
	 public void Check_mark_invoiceWith_dispute(String comtext,String text) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  if(comtext.equals("Yes")){
		  if(driver.findElement(By.xpath(c.getElementName("mark_invoiceWith_dispute_checkbox"))).isSelected()){
			  eve.SendKey_event("mark_invoiceWith_dispute_Infield", text);
			  Reporter.log(text+ " : is Entered in Mark invoices with disputes input field.");
			    }
		 else {
			 eve.Click_event("mark_invoiceWith_dispute_checkbox");
			 eve.SendKey_event("mark_invoiceWith_dispute_Infield", text);
			 Reporter.log(text+ " : is Entered in Mark invoices with disputes input field.");
			  }   		
	  }else{
		  if(driver.findElement(By.xpath(c.getElementName("mark_invoiceWith_dispute_checkbox"))).isSelected()){
			  eve.Click_event("mark_invoiceWith_dispute_checkbox");
			    }
		 else {
			System.out.println("checkbox is unchecked already");
			  }   		
	  }
	    }
  @Test
	 public void Check_mark_invoiceWith_paymentinProgress(String comtext,String text) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  if(comtext.equals("Yes")){
		  if(driver.findElement(By.xpath(c.getElementName("mark_invoiceWith_paymentinProgress_checkbox"))).isSelected()){
			  eve.SendKey_event("mark_invoiceWith_paymentinProgress_InField", text);
			  Reporter.log(text +": is Entered in Mark invoices with payment in progress input field.");
			    }
		 else {
			 eve.Click_event("mark_invoiceWith_paymentinProgress_checkbox");
			 eve.SendKey_event("mark_invoiceWith_paymentinProgress_InField", text);
			 Reporter.log(text +": is Entered in Mark invoices with payment in progress input field.");
			  }   		
	  }else{
		  if(driver.findElement(By.xpath(c.getElementName("mark_invoiceWith_paymentinProgress_checkbox"))).isSelected()){
			  eve.Click_event("mark_invoiceWith_paymentinProgress_checkbox");
			    }
		 else {
			System.out.println("checkbox is unchecked already");
			  }   		
	  }
	    }
  @Test
	 public void Check_display_Currencyin_Invoicetable(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.Checkbox(path, text);
	    }
  @Test
	 public void Check_display_Currencywithbalance(String path,String text) throws IOException {
	  events eve = new events(driver);
	  eve.Checkbox(path, text);
	    }
  @Test
	 public void Check_Includeblocked_Invoices(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.Checkbox(path, text);
	    }
  @Test
	 public void Click_Email_tab(String path) throws IOException, InterruptedException {	
	  events eve = new events(driver);
	  eve.Click_event(path);
	  Reporter.log("E-mail tab is clicked");
	    }
  @Test
	 public void Enter_Subject(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path, text);
	    }
  @Test
	 public void Enter_EmailText(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Click_Formats(String path) throws IOException, InterruptedException {
	  events eve = new events(driver);
	  eve.Click_event(path);
	  Reporter.log("Formats tab is Clicked");
	    }
  
  @Test
	 public void Select_Item_from_DDlist(String path, String text) throws IOException {	
	  events eve = new events(driver);
	  eve.DropDown_list(path, text);	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    }
  @Test
	 public void Enter_week(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_weeks(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_Month(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Enter_Months(String path,String text) throws IOException {	
	  events eve = new events(driver);
	  eve.SendKey_event(path,text);
	    }
  @Test
	 public void Save_changes() throws IOException {	
	 events ev = new events(driver);
	 ev.Click_eventBy_ClassName("saveMain");
	    }
  
  public void Save_As_New() throws IOException, InterruptedException {	
		 events ev = new events(driver);
		 ev.Click_event("RE_Save_as_New");
		    }
  @Test
	 public void Save_and_Close() throws IOException, InterruptedException {	
	 events ev = new events(driver);
	 ev.Click_event("RE_Save_and_Close");
	    }
  @Test
	 public void Cancel() throws IOException, InterruptedException {	
	 events ev = new events(driver);
	 ev.Click_event("RE_cancel");
	
	    }
  @Test
	 public void Notifications() throws IOException, InterruptedException {
	  events eve = new events(driver);
		if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
			Reporter.log("Notifications: --------------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("Save_changes_notification_OK_button");
			Reporter.log("-----------------------------------------------------------");
		}else{
			System.out.println("No notification Found");
		}
	    }
  
	@Test
	 public void Refresh() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("RE_Refresh");
	    }
	@Test
	 public void Save() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("DL_Cancel_button_Create");
	    }
	@Test
	 public void link() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("Link");
	    }
	public void Unlink() throws IOException, InterruptedException {
		events eve = new events(driver);
	  	eve.Click_event("Unlink");
	    }
}
