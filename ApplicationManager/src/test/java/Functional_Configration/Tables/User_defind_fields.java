package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.User_Defind_Fields_Page;
import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
@Listeners(ScreenShotOnFailure.class)
public class User_defind_fields {
	String Cus_Alphanumeric ="Customer Alphanumeric" ;
	String Cus_numeric = "Customer Numeric";
	String Cus_logical =  "Customer Logical";
	String Cus_date = "Customer Date";
	String Cus_picklist =  "Customer Picklist";
	String Cus_Currency =  "Customer Currency";
	String Cus_Curr_Code =  "Customer Curr Code";
	
	Common c = new Common();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_UDF");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
			//String cus_stats_Name = "Defaulter cust";
	}
  @Test(priority=1)
  public void Open_User_defined_fields_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("________________________ User Defind Fields ___________________________________________ ");
	  udf_page.Goto_User_Defind_Fields_page();
	  Thread.sleep(2000);
	  System.out.println("User Defind Fields Page is opened");
  }
  @Test(priority=2)
  public void Click_on_create_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
  } 
  @Test(priority=3)
  public void Enter_Field_Name() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name", arr.get(0));
	  System.out.println("Field name  is Entered");
  }
  @Test(priority=4)
  public void Select_User_Field_Type() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", arr.get(1));                       //User Field type
	  System.out.println("User Field Type is selected");
  }
  @Test(priority=5)
  public void Enter_Field_number() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", arr.get(2));                      //Field Number
	  System.out.println("Field number  is Entered");
  }
   @Test(priority=6)
  public void Select_Field_type() throws IOException, InterruptedException {
	  Reporter.log("Verify Filed Type. ********");
	  String type =arr.get(3);
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  udf_page.Fields_type("udf_field_type", type);
		switch(type){
		case("0"): 
			udf_page.Fields_length("udf_field_length", arr.get(4));
		    break;     
		case("1"):
			udf_page.Hide_decimal_checkbox("udf_hide_decimal");
		    break;
		case("4"):
			udf_page.Pick_list_DDList("udf_picklist_dd", arr.get(5));
		case("5"):
		    udf_page.Currency_code_field_number("udf_currency_code_field_no",arr.get(6));
		}  
  }
  @Test(priority=7)
  public void Fields_props_Activated_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("********Verify Field properties Activated Checkbox. ********");
	  udf_page.Activated("FieldActivated",arr.get(8));                      //Field Number
  }
  
  @Test(priority=8)
  public void Imported_RadioButton() throws IOException, InterruptedException {
	  String text=arr.get(9);
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify  Imported and  Can be changed by user Checkbox. ********");
	  if(text.equals("1")){
		  if(driver.findElement(By.xpath(c.getElementName("udf_imported"))).isEnabled()){
			  udf_page.Imported("udf_imported");
		  }else{
			  System.out.println("Imported radio button is Disable");
		  }
	  }else{
		  if(driver.findElement(By.xpath(c.getElementName("udf_canbe_chan_byUser"))).isDisplayed()){
			  udf_page.Canbe_changedBy_User("udf_canbe_chan_byUser");
		  }else{
			  System.out.println("Can be Changed by user radio button is Disable");
		  }
	  }
  }
  @Test(priority=9)
  public void Check_Listed_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify  Listed ? Checkbox. ********");
	  if(driver.findElement(By.xpath(c.getElementName("udf_listed"))).isEnabled()){
		  udf_page.Listed("Listed",arr.get(10));
	  }else{
		  System.out.println("Listed Checkbox is Disable");
	  }
  }
  @Test(priority=10)
  public void Check_Save_History_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify  Save history Checkbox. ********");
	  if(driver.findElement(By.xpath(c.getElementName("udf_save_history"))).isEnabled()){
		  udf_page.Save_history("KeepHistory", arr.get(11));
	  }else{
		  System.out.println("Save History Checkbox is Disable");
	  }
  }
  @Test(priority=11)
  public void partial_payment_information_Checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Partial Payment Information Checkbox. ********");
	  if(driver.findElement(By.xpath(c.getElementName("udf_partial_payment_info"))).isEnabled()){
		  udf_page.Partial_Payment_Information("FieldPaymentInfo", arr.get(12));
	  }else{
		  System.out.println("Partial payment information Checkbox is Disable");
	  }
  }
  @Test(priority=12)
  public void Availableto_batch_checkbox() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Available for Batch Checkbox. ********");
	  if(driver.findElement(By.xpath(c.getElementName("udf_avail_tobatch"))).isEnabled()){
		  udf_page.Available_for_batch("AvailableForBatch", arr.get(13));
	  }else{
		  System.out.println("Available to batch Checkbox is Disable");
	  }
  }
  
  @Test(priority=13,description="APP-239:Save picklist")
  public void Add_pick_list() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Save picklist. ********");
	  udf_page.pick_list_tab("udf_picklist_tab");
	  udf_page.Create_pick_list_icon();
	  udf_page.picklist_name_input("udf_enter_picklist",arr.get(14));
	  Thread.sleep(1000);
	  udf_page.Save();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(1000);
  }
  @Test(priority=14,description="APP-249: multiple picklist of same name")
  public void Verify_multiple_picklist_of_same_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify multiple picklist of same name. ********");
	//  udf_page.pick_list_tab("udf_picklist_tab");
	  udf_page.Create_pick_list_icon();
	  udf_page.picklist_name_input("udf_enter_picklist",arr.get(14));
	  udf_page.Save();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(1000);
  }
  
  @Test(priority=15,description="APP-240: Save pick list and pick list values")
  public void Add_Picklist_Value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve= new events(driver);
	  Reporter.log("Verify Save pick list and pick list values. ********");
	  eve.Table_event(arr.get(14), "udf_picklist_table");
	  Thread.sleep(1000);
	  udf_page.Create_Display_Name_icon();
	  udf_page.Display_name_input("udf_create_displayName_value", arr.get(15));
	  udf_page.Save();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(1000);
  }
   @Test(priority=16,description="APP-250:Multiple picklist value of same name")
  public void Verify_Multiple_picklist_value_of_same_name() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve= new events(driver);
	  Reporter.log("Verify Multiple picklist value of same name. ********");
	  eve.Table_event(arr.get(14), "udf_picklist_table");
	  Thread.sleep(1000);
	  udf_page.Create_Display_Name_icon();
	  udf_page.Display_name_input("udf_create_displayName_value", arr.get(15));
	  Thread.sleep(1000);
	  udf_page.Save();
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(1000); 
	  }
  
  
  @Test(priority=17,description="APP-241:update picklist")
  public void Update_pick_list() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify update picklist. ********");
	  udf_page.Update_Picklistfrom_table(arr.get(14),"udf_picklist_table",arr.get(14)+"Update");
	  Thread.sleep(1000);
	  udf_page.Save();
	  Thread.sleep(2000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(1000);
  }
  
  @Test(priority=18,description="APP-242:Update picklist value")
  public void Update_pick_list_Value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Update picklist value. ********");
	  events eve= new events(driver);
	  eve.Table_event(arr.get(14)+"Update", "udf_picklist_table");
	  Thread.sleep(500);
	  try {
		
	} catch (Exception e) {
		 udf_page.Update_Picklist_value_from_table( arr.get(15), "udf_create_displayName_table", arr.get(15)+" update");
		 Thread.sleep(1000);
	}
	 	  udf_page.Save();
	  Thread.sleep(2500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(500);
  }
  @Test(priority=19,description="APP-244:Delete pick list values")
  public void Delete_pick_list_Value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve= new events(driver);
	  Reporter.log("Verify Delete pick list values. ********");
	  eve.Table_event(arr.get(14)+"Update", "udf_picklist_table");
	  Thread.sleep(2000);
	  eve.Table_event(arr.get(15)+" update", "udf_create_displayName_table");
	  Thread.sleep(500);
	  udf_page.Delete_Display_Name_icon();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  
  } 
  @Test(priority=20,description="APP-243: Delete pick list")
  public void Delete_pick_list() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve= new events(driver);
	  Reporter.log("Verify Delete pick list. ********");
	  eve.Table_event(arr.get(14)+"Update", "udf_picklist_table");
	  Thread.sleep(1500);
	  udf_page.Delete_pick_list_icon();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  
  } 
  
  @Test(priority=21,description="APP-248: Save and Close button")
  public void Save_and_Close() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Save and Close button. ********");
	  driver.findElement(By.xpath(c.getElementName("CI__Create_collection_Interface"))).click();
	  Thread.sleep(3000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  @Test(priority=22)
  public void Create_Dispute_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(1500);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name", "Dispute user");                //Dispute User name
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "4");                       //User Field type Dispute
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "401");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "0"); // Alphanumeric
	  udf_page.Fields_length("udf_field_length", "321");
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Listed("Listed", "Yes"); 
	  udf_page.Save_history("KeepHistory", "Yes");
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  }
  
  @Test(priority=23)
  public void Link_Dispute_User_Defind_Field_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Linking UDF. ********");
	  eve.Table_event(arr.get(16), "C_curr_admin_table");
	  eve.Click_event("udf_table_Dispute_click_arrow");
	  Thread.sleep(1000);
	  udf_page.Find_UDF_in_table("udf_table_DisputeUDF","Dispute user"+"(401)");
	  Thread.sleep(1000);
	  udf_page.link();
	  Thread.sleep(500);
	  udf_page.Save_changes();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  }
  
  @Test(priority=24)
  public void Unlink_Dispute_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Unlinking UDF. ********");
	  eve.Table_event(arr.get(16), "C_curr_admin_table");
	  eve.Click_event("udf_Unlink_table_Dispute_click_arrow");
	  Thread.sleep(1000);
	  udf_page.Find_UDF_in_table("udf_Unlink_table_DisputeUDF","Dispute user"+"(401)");
	  Thread.sleep(1000);
	  udf_page.Unlink();
	  Thread.sleep(500);
	  udf_page.Save_changes();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  } 
  @Test(priority=25)
  public void Delete_Dispute_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve =  new events(driver);
	  Reporter.log("Verify Linking UDF. ********");
	  eve.Click_event("udf_table_Dispute_click_arrow");
	  Thread.sleep(1000);
	  udf_page.Find_UDF_in_table("udf_table_DisputeUDF","Dispute user"+"(401)");
	  Thread.sleep(1000);
	  udf_page.Delete_icon();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  }
  @Test(priority=26)
  public void Create_Alphanumeric_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name", Cus_Alphanumeric);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "101");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "0"); // Alphanumeric
	  udf_page.Fields_length("udf_field_length", "123");
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  @Test(priority=27)
  public void Create_Numeric_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name", Cus_numeric);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type- Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "102");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "1"); // Numeric
	  udf_page.Hide_decimal_checkbox("udf_hide_decimal");
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  @Test(priority=28)
  public void Create_Logical_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name",Cus_logical);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type- Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "103");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "2"); // Logical
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  @Test(priority=29)
  public void Create_Date_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name", Cus_date);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type- Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "104");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "3"); // Date
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  @Test(priority=30)
  public void Create_Picklist_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(2000);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name",Cus_picklist);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type- Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "105");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Add pickList Save picklist. ********");
	  udf_page.pick_list_tab("udf_picklist_tab");
	  udf_page.Create_pick_list_icon();
	  udf_page.picklist_name_input("udf_enter_picklist","TestPicklist");
	  Thread.sleep(1000);
	  udf_page.Save();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  udf_page.Refresh();
	  Thread.sleep(1000);
	  eve.Table_event("TestPicklist", "udf_picklist_table");
	  Thread.sleep(1000);
	  udf_page.Create_Display_Name_icon();
	  udf_page.Display_name_input("udf_create_displayName_value", "TestPicklist value");
	  udf_page.Save();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Refresh();
	  Thread.sleep(1000);
	  udf_page.UserFields_Tab();
	  Thread.sleep(1000);
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "4"); // Picklists
	  eve.DropDown_list("udf_picklist_dd", "TestPicklist");
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(2000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  udf_page.Canbe_changedBy_User("udf_canbe_chan_byUser");
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
	  udf_page.Notifications();
  }
  @Test(priority=31)
  public void Create_Currency_Code_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(2000);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name",Cus_Curr_Code);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type- Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "106");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	 
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "6"); // Currency Code
	  //eve.DropDown_list("udf_picklist_dd", "TestPicklist");
	  udf_page.Activated("FieldActivated","Yes");
	  Thread.sleep(1000);
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  @Test(priority=32)
  public void Create_Currency_Customer_User_Defind_Field() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  Reporter.log("Verify Create Icon. ********");
	  udf_page.Creat_New_icon();
	  System.out.println("Create New panal is opened");
	  Thread.sleep(500);
	  Reporter.log("Verify Field name input field. ********");
	  udf_page.field_name("udf_f_name",Cus_Currency);
	  System.out.println("Field name  is Entered");
	  Thread.sleep(1000);
	  Reporter.log("Verify User field type DDlist. ********");
	  udf_page.User_Fields_type("udf_user_field_type", "0");                       //User Field type- Debtor
	  System.out.println("User Field Type is selected");
	  Thread.sleep(1000);
	  Reporter.log("Verify Field number input field. ********");
	  udf_page.Field_number("udf_field_num", "107");                      //Field Number
	  System.out.println("Field number  is Entered");
	  Thread.sleep(1000);
	 
	  Reporter.log("Verify Filed Type. ********");
	  udf_page.Fields_type("udf_field_type", "5"); // Currency Code
	  udf_page.Currency_code_field_number("udf_currency_code_field_no","Customer Curr Code");
	  udf_page.Activated("FieldActivated","Yes");
	  udf_page.Available_for_batch("AvailableForBatch","Yes");   
	  Thread.sleep(1000);
	  udf_page.Save_and_Close();
	  Thread.sleep(3000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(2000);
  }
  
  
  @Test(priority=33,description="APP-257: Define user field >>save as new")
  public void Save_as_New_button_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify save as new button. ********");
	  switch(arr.get(1)){
		case("0"): 
			eve.Click_event("udf_table_CustomerUDF_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_CustomerUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;     
		case("1"):
			eve.Click_event("udf_table_invoice_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_InvoiceUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;
		case("2"):
			eve.Click_event("udf_table_Dispute_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_DisputeUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;
		}  
	  udf_page.Update_icon();
	  Thread.sleep(1000);
	  udf_page.field_name("udf_f_name", arr.get(0)+" New");
	  udf_page.Field_number("udf_field_num", arr.get(2)+"1");   
	  Thread.sleep(800);
	  udf_page.Save_As_New();
	  Thread.sleep(800);
	  udf_page.Notifications();
	  Thread.sleep(800);
	  udf_page.Notifications();
	  udf_page.Cancel();
	  Thread.sleep(2000);
	  udf_page.Notifications();
  }
  @Test(priority=34,description="APP-256:Define user field >>save and cancel button")
  public void Save_and_Cancel_button_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Save and Cancel button. ********");
	  switch(arr.get(1)){
		case("0"): 
			eve.Click_event("udf_table_CustomerUDF_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_CustomerUDF",arr.get(0)+" New"+"("+arr.get(2)+"1"+")");
		    break;     
		case("1"):
			eve.Click_event("udf_table_invoice_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_InvoiceUDF",arr.get(0)+" New"+"("+arr.get(2)+"1"+")");
		    break;
		case("2"):
			eve.Click_event("udf_table_Dispute_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_DisputeUDF",arr.get(0)+" New"+"("+arr.get(2)+"1"+")");
		    break;
		}  
	  udf_page.Update_icon();
	  Thread.sleep(1000);
	  udf_page.field_name("udf_f_name", arr.get(0)+"Save");
	  udf_page.Field_number("udf_field_num", arr.get(2)+"2");   
	  Thread.sleep(800);
	  udf_page.Save1();
	  Thread.sleep(800);
	  udf_page.Notifications();
	  Thread.sleep(800);
	  udf_page.Notifications();
	  udf_page.Cancel();
	  Thread.sleep(2000);
	  udf_page.Notifications();
  }
  
  @Test(priority=35)
  public void Link_UDF_to_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Linking UDF. ********");
	  eve.Table_event(arr.get(16), "C_curr_admin_table");
	  Thread.sleep(500);
	  switch(arr.get(1)){
		case("0"): 
			eve.Click_event("udf_table_CustomerUDF_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_CustomerUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;     
		case("1"):
			eve.Click_event("udf_table_invoice_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_InvoiceUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;
		case("2"):
			eve.Click_event("udf_table_Dispute_click_arrow");
			Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_table_DisputeUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;
		}  
	  
	  Thread.sleep(1000);
	  udf_page.link();
	  Thread.sleep(500);
	 udf_page.Save_changes();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  }
  @Test(priority=36)
  public void Link_Multiple_UDF_Administrations() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Linking UDF. ********");
	  eve.Table_event(arr.get(16), "C_curr_admin_table");
	  Thread.sleep(500);
	  eve.Click_event("udf_table_CustomerUDF_click_arrow");
	  Thread.sleep(1000);
	  udf_page.Select_UDF_in_table("udf_table_CustomerUDF", Cus_Alphanumeric+"(101)", Cus_numeric+"(102)", Cus_logical+"(103)", Cus_date+"(104)", Cus_picklist+"(105)", Cus_Currency+"(107)", Cus_Curr_Code+"(106)");
	  Thread.sleep(1000);
	  udf_page.link();
	  Thread.sleep(500);
	 udf_page.Save_changes();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
  }
  @Test(priority=37)
  public void Delete_Multiple_Linked_UDF_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  eve.Click_event("udf_table_CustomerUDF_click_arrow");
	  Thread.sleep(1000);
	  udf_page.Select_UDF_in_table("udf_table_CustomerUDF", Cus_Alphanumeric+"(101)", Cus_numeric+"(102)", Cus_logical+"(103)", Cus_date+"(104)", Cus_picklist+"(105)", Cus_Currency+"(107)", Cus_Curr_Code+"(106)");
	  Thread.sleep(1000);
	  udf_page.Delete_icon();
	  Thread.sleep(1500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  }
  
  @Test(priority=38)
  public void UnLink_UDF_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Unlinking UDF. ********");
	  eve.Table_event(arr.get(16), "C_curr_admin_table");
	  Thread.sleep(500);
	  switch(arr.get(1)){
		case("0"): 
			eve.Click_event("udf_Unlink_table_CustomerUDF_click_arrow");
		    Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_Unlink_table_CustomerUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;     
		case("1"):
			eve.Click_event("udf_Unlink_table_invoice_click_arrow");
		    Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_Unlink_table_InvoiceUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;
		case("2"):
			eve.Click_event("udf_Unlink_table_Dispute_click_arrow");
		    Thread.sleep(1000);
		    udf_page.Find_UDF_in_table("udf_Unlink_table_DisputeUDF",arr.get(0)+"("+arr.get(2)+")");
		    break;
		}  
	  
	  Thread.sleep(1000);
	  udf_page.Unlink();
	  Thread.sleep(500);
	  udf_page.Save_changes();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
  }
  
  @Test(priority=39)
  public void Delete_User_Defind_Fields_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  User_Defind_Fields_Page udf_page = new User_Defind_Fields_Page(driver);
	  events eve = new events(driver);
	  Reporter.log("Verify Unlinking UDF. ********");
	  Thread.sleep(500);
	  switch(arr.get(1)){
		  case("0"): 
				eve.Click_event("udf_table_CustomerUDF_click_arrow");
				Thread.sleep(1000);
			    udf_page.Find_UDF_in_table("udf_table_CustomerUDF",arr.get(0)+"("+arr.get(2)+")");
			    break;     
			case("1"):
				eve.Click_event("udf_table_invoice_click_arrow");
				Thread.sleep(1000);
			    udf_page.Find_UDF_in_table("udf_table_InvoiceUDF",arr.get(0)+"("+arr.get(2)+")");
			    break;
			case("2"):
				eve.Click_event("udf_table_Dispute_click_arrow");
				Thread.sleep(1000);
			    udf_page.Find_UDF_in_table("udf_table_DisputeUDF",arr.get(0)+"("+arr.get(2)+")");
			    break;
		}  
	  
	  Thread.sleep(1000);
	  udf_page.Delete_icon();
	  Thread.sleep(500);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  udf_page.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("________________________ End: User Defind Fields Section___________________________________________ ");
  }
}
