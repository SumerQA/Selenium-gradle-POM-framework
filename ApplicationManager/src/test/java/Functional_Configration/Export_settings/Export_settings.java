package Functional_Configration.Export_settings;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Batch_rules_page;
import appMan_Pages.queue_page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Event_commands.events;
import appMan_Pages.Collection_interface_Page;
import appMan_Pages.Export_Settings_Page;
import appMan_Pages.Functional_Configration_Page;
import appMan_Pages.Home_index_Page;
@Listeners(ScreenShotOnFailure.class)
public class Export_settings {
	String Efield = null;
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("FC_Export_Settings");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
 @Test(priority=1)
  public void Goto_Export_settings_page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Goto_Export_Settings_page();
	  Thread.sleep(1500);
	  System.out.println("Export settings Page is opened");
  }
 
  
@Test(priority=2)
  public void Create_CSV_FixedLength_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" batch to CSV Fixed length");
	  x_page.Description("ES_Desc", arr.get(1)+" batch to CSV Fixed length");
	  x_page.Export_type("ES_Exp_type", arr.get(2));//Batch Export
	  x_page.Export_Format("ES_Exp_Format", "1");//CSV/Fixed length
	  x_page.Repeat_debtor_information_on_every_line("Yes");
	  x_page.TextBetween("textBetween", "Yes", "Text only", "$");
	  //Tab delimited text file =1
	  //Fixed length settings=2
	  //Seperator=3
	  x_page.TextFilesettings("2", "$$$");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
    @Test(priority=3)
  public void Create_CSV_Using_Seperator_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" batch to CSV Seperator");
	  x_page.Description("ES_Desc", arr.get(1)+" batch to CSV Seperator");
	  x_page.Export_type("ES_Exp_type", arr.get(2));//Batch Export
	  x_page.Export_Format("ES_Exp_Format", "1");//CSV/Fixed length
	  x_page.Repeat_debtor_information_on_every_line("Yes");
	  x_page.TextBetween("textBetween", "Yes", "Text only", "$");
	  //Tab delimited text file =1
	  //Fixed length settings=2
	  //Seperator=3
	  x_page.TextFilesettings("3", "@@@");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=4)
  public void Create_XML_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" batch to XML");
	  x_page.Description("ES_Desc", arr.get(1)+" batch to XML");
	  x_page.Export_type("ES_Exp_type", arr.get(2));
	  x_page.Export_Format("ES_Exp_Format", "2");
	  x_page.XML_mainHeader("MyHeader");
	  x_page.Debtor_XML_Tag("MyDebtorTag");
	  x_page.Inv_XML_Tag("MyINVTag");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=5)
  public void Create_EXCEL_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Batch to Excel");
	  x_page.Description("ES_Desc", arr.get(1)+" Batch to Excel");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", arr.get(2));
	  x_page.Export_Format("ES_Exp_Format", "3");
	  x_page.Include_Column_Header_Checkbox("Yes");
	  x_page.TextBetween("textBetween", "Yes", "All fields", "@");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=6)
  public void Create_Letter_to_File_Batch_Export_in_PDF() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Letter to PDF File");
	  x_page.Description("ES_Desc", arr.get(1)+" Letter to PDF File");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", arr.get(2));
	  x_page.Export_Format("ES_Exp_Format", "4");//Letter to File
	  x_page.Document_type("ES_Doc_type", arr.get(4));//PDF
	  x_page.Unique_Identifier("ES_Unique_Identifier", arr.get(5));
	  x_page.Date("ES_Date", arr.get(6));
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
  }
  
  @Test(priority=7)
  public void Create_Letter_to_File_Batch_Export_in_TIFF() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Letter to TIFF File");
	  x_page.Description("ES_Desc", arr.get(1)+" Letter to TIFF File");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", arr.get(2));
	  x_page.Export_Format("ES_Exp_Format", "4");//Letter to File
	  x_page.Document_type("ES_Doc_type", "2");//TIFF
	  x_page.Unique_Identifier("ES_Unique_Identifier", arr.get(5));
	  x_page.Date("ES_Date", arr.get(6));
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
  }

  @Test(priority=8)
  public void Create_CSV_FixedLength_Collection_agency_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Collection Agency to CSV Fixed length");
	  x_page.Description("ES_Desc", arr.get(1)+" Collection Agency to CSV Fixed length");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", "0");//Collection Agency Export
	  x_page.Export_Format("ES_Exp_Format", arr.get(3));
	  x_page.Repeat_debtor_information_on_every_line("Yes");
	  x_page.TextBetween("textBetween", "Yes", "Text only", "$");
	  //Tab delimited text file =1
	  //Fixed length settings=2
	  //Seperator=3
	  x_page.TextFilesettings("2", "$$$");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=9)
  public void Create_Tab_delimated_text_Collection_agency_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Collection Agency to CSV Tab Delimated text_Text Only");
	  x_page.Description("ES_Desc", arr.get(1)+" Collection Agency to CSV Tab Delimated text _Text Only");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", "0");//Collection Agency Export
	  x_page.Export_Format("ES_Exp_Format", arr.get(3));
	  x_page.Repeat_debtor_information_on_every_line("Yes");
	  x_page.TextBetween("textBetween", "Yes", "Text only", "%");
	  //Tab delimited text file =1
	  //Fixed length settings=2
	  //Seperator=3
	  x_page.TextFilesettings("1", "@@@");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=10)
  public void Create_Tab_delimated_AllFields_Collection_agency_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Collection Agency to CSV Tab Delimated text_AllFields");
	  x_page.Description("ES_Desc", arr.get(1)+" Collection Agency to CSV Tab Delimated text _AllFields");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", "0");//Collection Agency Export
	  x_page.Export_Format("ES_Exp_Format", arr.get(3));
	  x_page.Repeat_debtor_information_on_every_line("Yes");
	  x_page.TextBetween("textBetween", "Yes", "All fields", "#");
	  //Tab delimited text file =1
	  //Fixed length settings=2
	  //Seperator=3
	  x_page.TextFilesettings("1", "***");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=11)
  public void Create_XML_Collection_agency_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Collection Agency to XML");
	  x_page.Description("ES_Desc", arr.get(1)+" Collection Agency to XML");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", "0");//Collection Agency
	  x_page.Export_Format("ES_Exp_Format", "2");//XML
	  x_page.XML_mainHeader("MyHeader");
	  x_page.Debtor_XML_Tag("MyDebtorTag");
	  x_page.Inv_XML_Tag("MyINVTag");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }
  @Test(priority=12)
  public void Create_EXCEL_Collection_agency_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Collection Agency to Excel");
	  x_page.Description("ES_Desc", arr.get(1)+" Collection Agency to Excel");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", "0");//Collection Agency
	  x_page.Export_Format("ES_Exp_Format", "3");
	  x_page.Include_Column_Header_Checkbox("Yes");
	  x_page.TextBetween("textBetween", "Yes", "All fields", "*");
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  Thread.sleep(1500);
	  
  }

  
  public void Insert_Customer_UDF_Field_in_Collection_agency_to_XML() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Collection Agency to XML", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("5");//Customer User defined Field
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }
  @Test(priority=14)
  public void Insert_Invoice_Field_in_Collection_agency_to_XML() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Collection Agency to XML", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("1");//Invoice Fields
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }
  @Test(priority=15)
  public void Insert_Invoice_UDF_Field_in_Collection_agency_to_XML() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Collection Agency to XML", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("0");//Debtor fields
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }
  
  
  @Test(priority=16)
  public void Verify_Reload_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  x_page.Creat_New_icon();
	  Thread.sleep(1500);
	  System.out.println("Create New panal is opened");
	  x_page.Export_Name("ES_Exp_Name",arr.get(0)+" Collection Agency to Excel");
	  x_page.Description("ES_Desc", arr.get(1)+" Collection Agency to Excel");
	  System.out.println(arr.get(1)+" is Entered in Description input field");
	  x_page.Export_type("ES_Exp_type", "0");//Collection Agency
	  x_page.Export_Format("ES_Exp_Format", "3");
	  x_page.Include_Column_Header_Checkbox("Yes");
	  x_page.TextBetween("textBetween", "Yes", "All fields", "%");
	  x_page.Refresh_Changes();
	  Thread.sleep(1000);
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
  }
  
  @Test(priority=17)
  public void Verify_Update_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to CSV Fixed length", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Update_icon();
	  Thread.sleep(1500);
	  x_page.Include_Column_Header_Checkbox("Yes");
	  Thread.sleep(1000);
	  x_page.Save_Changes();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  driver.navigate().refresh();
	  }
	  
  @Test(priority=18)
  public void Define_Debtor_Export_Fields_For_Batch_to_CSV_Fixed_length() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to CSV Fixed length", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  Thread.sleep(1500);
	  x_page.Field_type("0");//Debtor Fields
	  Thread.sleep(500);
	  Efield=eve.GetText_By_Attribute("ES_Select_Field","56");
	  x_page.Select_Field("56");//Date
	  Thread.sleep(500);
	  x_page.Create_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  }
  @Test(priority=19)
  public void Update_Debtor_Export_Fields_For_Batch_to_CSV_Fixed_length() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to CSV Fixed length", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  eve.Table_event("Invoice Debtor name", "ES_ExportField_table");
	  Thread.sleep(1000);
	  x_page.Reload_Export_Fields_Icon();
	  Thread.sleep(500);
	  eve.Table_event(Efield, "ES_ExportField_table");
	  Thread.sleep(1500);
	  x_page.Fixed_Length("200");
	  Thread.sleep(1000);
	  x_page.Update_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  x_page.Close_Export_Fields_Icon();
	  }
 @Test(priority=20)
  public void Define_Customer_UDF_Export_Fields_For_CSV_Using_Seperator_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to CSV Seperator", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  Thread.sleep(1500);
	  x_page.Field_type("5");//Customer UDF fields
	  Thread.sleep(500);
	  x_page.Select_Field("1001");//Klantgroep
	  x_page.Create_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }

  @Test(priority=21)
  public void Define_Invoice_Fields_For_XML_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to XML", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  Thread.sleep(1500);
	  x_page.Field_type("1");//Invoice Fields
	  Thread.sleep(500);
	  x_page.Select_Field("81");//Invoice Debtor name
	  x_page.Create_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }
  
  @Test(priority=22)
  public void Define_Invoice_UDF_Fields_For_XML_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to XML", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  Thread.sleep(1500);
	  x_page.Field_type("6");//Invoice Fields
	  Thread.sleep(500);
	  Efield=eve.GetText_By_Attribute("ES_Select_Field","2006");
	  x_page.Select_Field("2006");//URL
	  x_page.Create_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	  
	  
  }
  
  
  @Test(priority=23)
  public void Verify_Delete_Export_Filed() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to XML", "ES_Export_Def_table");
	  x_page.Define_Export_Fields_Icon();
	  eve.Table_event(Efield, "ES_ExportField_table");
	  x_page.Delete_Export_Fields_Icon();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(1000);
	  x_page.Notification();	  
	  Thread.sleep(1000);
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(1000);
	  x_page.Notification();
	  Thread.sleep(1000);
	  x_page.Notification();
  }
  
  public void Define_Fixed_Value_For_XML_Batch_Export() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" batch to XML", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  Thread.sleep(1500);
	  x_page.Field_type("-1");//Fixed Value removed now
	  Thread.sleep(500);
	  x_page.Export_Field("Testing Fixed Value");
	  x_page.Fixed_Length("200");
	  x_page.Standard_value("DB Fixed value");
	  Thread.sleep(500);
	  x_page.Create_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Save_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Close_Export_Fields_Icon();
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }
 
  @Test(priority=25)
  public void Insert_All_Debtor_Export_Field_in_Batch_to_Excel() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Batch to Excel", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("0");//Debtor Fields
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
  }
  @Test(priority=26)
  public void Insert_Customer_UDF_Field_in_Batch_to_Excel() throws IOException, InterruptedException {
	 WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Batch to Excel", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("5");//Customer User defined Field
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();   
  }
  @Test(priority=27)
  public void Insert_Invoice_Field_in_Batch_to_Excel() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Batch to Excel", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("1");//Invoice Fields
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();  
  }
  @Test(priority=28)
  public void Insert_Invoice_UDF_Field_in_Batch_to_Excel() throws IOException, InterruptedException {
	   WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Batch to Excel", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  x_page.Insert_All_Export_Fields("6");//Invoice user defined fields
	  x_page.Save_and_close_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();  
  }

  
 
  public void Insert_Fixed_Value_in_Batch_to_Excel() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event(arr.get(0)+" Batch to Excel", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Define_Export_Fields_Icon();
	  Thread.sleep(1000);
	  x_page.Field_type("-1");//Fixed Value
	  Thread.sleep(500);
	  x_page.Export_Field("Testing Fixed Value in batch to Excel");
	  x_page.Fixed_Length("150");
	  x_page.Standard_value("DB Fixed value");
	  Thread.sleep(500);
	  x_page.Create_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Save_Export_Fields_Icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Close_Export_Fields_Icon();
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Notification();
	
	
  }
  
  
  @Test(priority=30)
  public void Create_Batchrule_and_linkTo_Batch_Export_Settings_in_Batch() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Home_index_Page HI_page = new Home_index_Page(driver);
	  Batch_rules_page br_page = new Batch_rules_page(driver);
	  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
	  queue_page qp = new queue_page(driver);
	  events eve = new events(driver);
	  qp.click_on_batch();
	  Thread.sleep(2000);
	  br_page.open_batch_rules_page();
	  Thread.sleep(1000);
	  br_page.Create_Icon();
	  Thread.sleep(500);
	  br_page.Enter_New_BatchRule("Batch Rule for Export Settings");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(1000);
	  br_page.Notification();
	  Reporter.log("===================>> Link Batch Rule to Media Type 'Export'.");
	  eve.Table_event("Batch Rule for Export Settings", "batchrule_sets_table");
	  br_page.Output_Media_Type_DDlist("3");
	  eve.Table_event("Export Batch to Excel", "output_mediaType_table");
	  br_page.Change_Icon();
	  Thread.sleep(500);
	  Thread.sleep(500); 
	  br_page.Link_Icon();
	  Thread.sleep(500);
	  br_page.Export_path("CI_Export_to_inputField", "test");
	  Thread.sleep(500);
	  br_page.Save_Icon();
	  Thread.sleep(500);
	  br_page.Notification();
	  Thread.sleep(500);
	  eve.Click_event("App_Man");
	  Thread.sleep(1500);
	  br_page.Render_Notifications();
	  Thread.sleep(1000);
	  HI_page.Select_Functional_Configration_Tab();
	  Thread.sleep(1500);
	  br_page.Render_Notifications();
	  FC_page.Click_Export_Settings_tab();
	  Thread.sleep(3000);
	  br_page.Render_Notifications();
  }
  @Test(priority=31)
  public void Verify_Export_settings_XMLFile_in_Collection_interfaces_tab() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Collection_interface_Page ci_page  = new Collection_interface_Page(driver);
	  Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
	  ci_page.Goto_Collection_interface_page();
	  Thread.sleep(3000);
	  System.out.println("Collection_inerfaces Page is opened");
	  ci_page.Creat_New_icon();
	  Thread.sleep(1000);
	  ci_page.Select_Export_File("CI_select_Export_File","Export Collection Agency to XML");
	  Thread.sleep(1000);
	  ci_page.Close();
	  Thread.sleep(2000);
	  ci_page.Notification();
	  Thread.sleep(1000);
	  FC_page.Click_Export_Settings_tab();
	  Thread.sleep(5000);
	  ci_page.RenderNotification();
	  Thread.sleep(1000);   
	  }
 
  public void Delete_Export_settings_Functionality() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Export_Settings_Page x_page = new Export_Settings_Page(driver);
	  events eve = new events(driver);
	  eve.Table_event("TEST", "ES_Export_Def_table");
	  Thread.sleep(1000);
	  x_page.Delete_icon();
	  Thread.sleep(500);
	  x_page.Notification();
	  Thread.sleep(500);
	  x_page.Save_Changes();
	  Thread.sleep(1500);
	  x_page.Notification();
	  eve.CheckItem_AfterDeleting_In_Table_event("TEST", "ES_Export_Def_table");
	  }
  
}
