package Technical_Configration;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Configration_Files.connectDB;
import appMan_Pages.API_Call_templetes_Page;
@Listeners(ScreenShotOnFailure.class)
public class Call_templetes {
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	connectDB db = new connectDB();
	static String trigger=null;
	 ArrayList<String>arr= new ArrayList<>();
	 ArrayList<String>t= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_API_Client");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	
	}
	 @Test(priority=1)
	  public void Open_Call_templete_Page() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  Reporter.log("________________________ API Call Templete Page_____________________________ ");
		  Thread.sleep(5000);
		  ct_page.Goto_Api_Call_templetes_page();
	  }
	 @Test(priority=2)
	  public void Verify_Create_API_Call_templete_Icon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  Reporter.log("Click on Create Button - ");
		  ct_page.Create_icon();
		  Thread.sleep(1000);
	  }
	  @Test(priority=3)
	  public void Enter_Action_Name() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.Action_name("A1_ARC_161");
	  }
	  @Test(priority=4)
	  public void Enter_Description() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.Description(" For R1 161");
	  }
	  @Test(priority=5)
	  public void Select_Trigger_to_Create_API_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  trigger=ct_page.Trigger("0");
		  Thread.sleep(1000);
	  }
	  @Test(priority=6)
	  public void Select_API_Resource_Created_In_Outbound_setting_section() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.API_Resource(arr.get(3));
		  Thread.sleep(1000);
	  }
	  @Test(priority=7)
	  public void Select_Operation_to_API_request() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.Operation_trigger("1");
		  Thread.sleep(1000);
	  }
	  @Test(priority=8)
	  public void Enter_API_request_Path() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.Path("TestRequestCustomerNo");
		  Thread.sleep(1000);
	  }
	  @Test(priority=9)
	  public void Enter_API_request_Header_parameter_Value() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  Thread.sleep(2000);
		  if(!t.isEmpty()){
			  ct_page.Header_parameters(t.get(0));
			  Thread.sleep(1000); 
		  }else{
			  ct_page.Header_parameters("");
			  Thread.sleep(1000); 
		  }
		  
	  }
	  @Test(priority=10)
	  public void  Enter_API_request_Query_parameter_Value() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  Thread.sleep(2000);
		  ct_page.Query_parameters(t.get(1));
		  Thread.sleep(1000);
	  }
	  @Test(priority=11)
	  public void EEnter_API_request_Body_parameter_Value() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  Thread.sleep(2000);
		  ct_page.Body_parameters(t.get(2));
		  Thread.sleep(1000);
		  t.clear();
	  }
	
	  @Test(priority=12)
	  public void Verify_Save_New_Call_Templete_Icon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  Thread.sleep(2000);
		  ct_page.Save_Call_templetes();
		  ct_page.Notification();
		  Thread.sleep(1500);
	  }
	  @Test(priority=13)
	  public void Verify_Update_Icon_functionality_to_modify_created_API_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.List_of_API_Call_Templetes_table("api_call_templete_table", "A1_ARC_161", trigger);
		  Thread.sleep(1000);
		  ct_page.Update_icon();		  
		  Thread.sleep(1000);
		  ct_page.Action_name("A1_ARC_161 update");
		  trigger= ct_page.Trigger("1");
		  Thread.sleep(800);
		  ct_page.Save_Call_templetes();
		  Thread.sleep(1500);
		  ct_page.Notification();
		  Thread.sleep(500);
		  ct_page.Notification();
		  Thread.sleep(500);
	  }
	  @Test(priority=14)
	  public void Verify_Delete_Icon_functionality_to_delete_created_API_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.List_of_API_Call_Templetes_table("api_call_templete_table", "A1_ARC_161 update", trigger);
		  Thread.sleep(1000);
		  ct_page.Delete_icon();
		  Thread.sleep(1000);
		  ct_page.Notification();
		  ct_page.Notification();
	  }
	  @Test(priority=15)
	  public void Verify_mandatory_Fields() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct = PageFactory.initElements(driver, API_Call_templetes_Page.class);	
		  ct.Create_icon();
		  trigger=ct.Trigger("0");//Assign risk code
		  ct.Action_name("");
		  ct.Description("Check mandatoty field");
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));		  
		  ct.Header_parameters("");
		  ct.Query_parameters("");
		  ct.Body_parameters("");
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
		  ct.Action_name(arr.get(3)+"-D-UDF");
		  ct.Description("Check Mandatory field");
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path("");		  
		  ct.Header_parameters("");
		  ct.Query_parameters("");
		  ct.Body_parameters("");
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=16)
	  public void Create_Assign_Risk_Code_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("0");//Assign risk code
		  ct.Action_name(arr.get(3)+"-ARC");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));	
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=17)
	  public void Create_Assign_debtor_status_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("1");//Assign debtor status
		  ct.Action_name(arr.get(3)+"-ADS");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));	
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=18)
	  public void Create_Assign_profile_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("2");//Assign Profile
		  ct.Action_name(arr.get(3)+"-AP");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));	
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=19)
	  public void Create_Block_debtor_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("3");//Block debtor
		  ct.Action_name(arr.get(3)+"-BD");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));	
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=20)
	  public void Create_Unblock_debtor_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("4");//Unblock debtor
		  ct.Action_name(arr.get(3)+"-UD");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=21)
	  public void Create_Save_Dispute_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("5");//Save Dispute
		  ct.Action_name(arr.get(3)+"-SD");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));	
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=22)
	  public void Create_Create_User_Defind_Field_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("6");//Create user defind field
		  ct.Action_name(arr.get(3)+"-C-UDF");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));		
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=23)
	  public void Create_Delete_User_Defind_Field_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("7");//Delete user defind field
		  ct.Action_name(arr.get(3)+"-D-UDF");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	 
	  @Test(priority=24)
	  public void Create_Bulk_Change_Dispute_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("8");//Bulk Change Dispute
		  ct.Action_name(arr.get(3)+"-BCD");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=25)
	  public void Create_Import_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("9");//Import
		  ct.Action_name(arr.get(3)+"-Import");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=26)
	  public void Create_Create_Payment_Scheme_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("10");//Create Payment Scheme
		  ct.Action_name(arr.get(3)+"-CreatePS");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  
	  @Test(priority=27)
	  public void Create_Modify_Payment_Scheme_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("11");//Modify Payment Scheme
		  ct.Action_name(arr.get(3)+"-ModifyPS");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  
	  @Test(priority=28)
	  public void Create_Cancel_Payment_Scheme_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("12");//Cancel Payment Scheme
		  ct.Action_name(arr.get(3)+"-CancelPS");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=29)
	  public void Create_Assign_Collection_Profile_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("13");//Assign Collection Profile
		  ct.Action_name(arr.get(3)+"-AssignCP");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  
	  @Test(priority=30)
	  public void Create_Assign_Collection_Interface_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("14");//Assign Collection Interface
		  ct.Action_name(arr.get(3)+"-AssignCI");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  }
	  @Test(priority=31)
	  public void Create_Set_Credit_Notes_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("15");//Set Credit Notes
		  ct.Action_name(arr.get(3)+"-SetCN");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  } 
	  
	  @Test(priority=32)
	  public void Create_Create_Committed_Payment_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("16");//Create committed payment
		  ct.Action_name(arr.get(3)+"-CreateCP");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  } 
	  @Test(priority=33)
	  public void Create_Update_Committed_Payment_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("17");//Update committed payment
		  ct.Action_name(arr.get(3)+"-UpdateCP");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  } 
	  @Test(priority=34)
	  public void Create_Cancel_Committed_Payment_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("18");//Cancel committed payment
		  ct.Action_name(arr.get(3)+"-CancelCP");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  } 
	  @Test(priority=35)
	  public void Create_Invoice_Block_Status_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("19");//Invoice Block Status
		  ct.Action_name(arr.get(3)+"-InvoiceBS");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  } 
	  @Test(priority=36)
	  public void Create_Update_User_Defined_Fields_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("20");//Update User Defined Fields
		  ct.Action_name(arr.get(3)+"-UpdateUDF");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("1");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
	  } 
	  @Test(priority=37)
	  public void Verify_Redundancy_in_API_Call_templete() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Create_icon();
		  trigger=ct.Trigger("0");//Assign risk code
		  ct.Action_name(arr.get(3)+"-ARC");
		  ct.Description(trigger+" for"+arr.get(3));
		  ct.API_Resource(arr.get(3));
		  ct.Operation_trigger("Post");
		  ct.Path(arr.get(6));
		  t = rddata.Read_Excel_Rows("CallTemplate parameters","CallTemplate_parameters",trigger);
		  if(!t.isEmpty()){
			  ct.Header_parameters(t.get(0));
			  ct.Query_parameters(t.get(1));
			  ct.Body_parameters(t.get(2));
			  t.clear();
		  }else{
			  ct.Header_parameters("");
			  ct.Query_parameters("");
			  ct.Body_parameters("");
		  }
		  ct.Save_Call_templetes();
		  ct.Notification();
		  ct.Notification();
		  ct.Refresh_Icon();
	  }
	 
	  @Test(priority=38)
	  public void Verify_Add_Criteria_Icon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.List_of_API_Call_Templetes_table("api_call_templete_table", arr.get(3)+"-ARC","Assign risk code");
		  Thread.sleep(1000);
		  ct.Update_icon();	
		  Thread.sleep(1000);
		  ct.Add_Call_Templete_Criteria_ICon();
		  ct.Insert_Criteria_to_Call_templete("109", "0");
	  } 
	  @Test(priority=39)
	  public void Verify_Refresh_Criteria_Icon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Refresh_Criteria();
		  ct.Save_Criteria();
		  ct.Notification();
		  ct.Notification();
	  } 
	  @Test(priority=40)
	  public void Verify_Save_Criteria_Icon_from_Display_List() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Save_Criteria_to_Call_templete("109", "0");
		  ct.Notification();
	  } 
	  @Test(priority=41)
	  public void Verify_Update_Criteria_Icon_from_Display_List() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.API_Call_templete_trigger_Criteria_Table("Administration", "api_ct_apiCallTempTriggerCriteria");
		  Thread.sleep(1000);
		  ct.Save_Criteria_to_Call_templete("28", "1000");
		  ct.Notification();
	  } 
	  @Test(priority=42)
	  public void Verify_Delete_Criteria_Icon_from_Display_List() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Criteria_List_Display_Table("Balance", "api_ct_CriteriaListDisplay_table");
		  ct.Delete_Criteria();
		  ct.Notification();
	  } 
	  @Test(priority=43)
	  public void Verify_Cancel_Criteria_Icon() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.Cancel_Criteria();
		  ct.Notification();
	  }
	  @Test(priority=44)
	  public void Add_Criteria_in_API_Call_templete_trigger() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.List_of_API_Call_Templetes_table("api_call_templete_table", arr.get(3)+"-ARC","Assign risk code");
		  Thread.sleep(1000);
		  ct.Update_icon();	
		  Thread.sleep(1000);
		  ct.Add_Call_Templete_Criteria_ICon();
		  ct.Save_Criteria_to_Call_templete("109", "0");
		  ct.Save_and_Close_Criteria();
		  ct.Notification();
		  Thread.sleep(1000);
	  } 
	  @Test(priority=45)  
	  public void Add_Multiple_Criteria_in_API_Call_templete_trigger() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.List_of_API_Call_Templetes_table("api_call_templete_table", arr.get(3)+"-ARC","Assign risk code");
		  Thread.sleep(1000);
		  ct.Update_icon();	
		  Thread.sleep(1000);
		  ct.Add_Call_Templete_Criteria_ICon();		 
		  ct.Save_Criteria_to_Call_templete("28", "0");
		  ct.Save_Criteria_to_Call_templete("119", "0");
		  ct.Save_Criteria_to_Call_templete("110", "0");
		  ct.Save_and_Close_Criteria();
		  ct.Notification();
		  Thread.sleep(1000);
	  } 
	  @Test(priority=46)
	  public void Delete_Call_templete_Linked_Criteria_init() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct_page = PageFactory.initElements(driver, API_Call_templetes_Page.class);
		  ct_page.List_of_API_Call_Templetes_table("api_call_templete_table", arr.get(3)+"-ARC", "Assign risk code");
		  Thread.sleep(1000);
		  ct_page.Delete_icon();
		  Thread.sleep(1000);
		  ct_page.Notification();
		  ct_page.Notification();
	  }
	  @Test(priority=47)
	  public void Delete_Criteria_from_API_Call_templete_trigger() throws Exception {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  API_Call_templetes_Page ct= new API_Call_templetes_Page(driver);
		  ct.List_of_API_Call_Templetes_table("api_call_templete_table", arr.get(3)+"-ARC","Assign risk code");
		  Thread.sleep(1000);
		  ct.API_Call_templete_trigger_Criteria_Table("Administration", "api_ct_apiCallTempTriggerCriteria");
		  Thread.sleep(1000);
		  ct.Update_icon();	
		  Thread.sleep(1000);
		  ct.Delete_Criteria_Main();
		  ct.No_Notification();
		//  ct.Delete_Criteria_Main();
		  ct.Notification();
		  Thread.sleep(5000);
	  }  
}
