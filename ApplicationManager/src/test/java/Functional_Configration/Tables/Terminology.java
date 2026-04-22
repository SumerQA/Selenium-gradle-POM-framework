package Functional_Configration.Tables;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
import Configration_Files.connectDB;
import appMan_Pages.Terminology_Page;
@Listeners(ScreenShotOnFailure.class)
public class Terminology {
	connectDB db = new connectDB();
	 ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("Table_terminology");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
  @Test(priority=1)
  public void Open_Terminology_Page() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Thread.sleep(3000);
	  Reporter.log("________________________ Terminology ___________________________________________ ");
	  tp_page.Goto_Terminology_page();
	  System.out.println("Terminology Page is opened");
	  Thread.sleep(500);
  }
  @Test(priority=2)
  public void Select_terminology_from_list() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Select terminology from List. ********");
	  tp_page.Terminology_list(arr.get(0), "t_terminology_list_table");
	  Reporter.log(arr.get(0)+" : is Selected from terminology List");
	  System.out.println("Clicked on Terminology List Table");
	  Thread.sleep(1000);
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=3)
  public void Select_terminology_Value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Select item from terminology value List. ********");
	  tp_page.Terminology_Value(arr.get(1), "t_terminology_value_table");
	  Reporter.log(arr.get(1)+" : is Selected from terminology value List");
	 System.out.println("Terminology value is selected");
	 Thread.sleep(500);
	 Reporter.log("----------------------------------------");
  }
  @Test(priority=4)
  public void Click_on_Change_icon() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Click on change Icon. ********");
	  tp_page.Change_icon();
	  Thread.sleep(500);
	  System.out.println("Clicked on Change icon");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=5)
  public void Enter_valuefor_English_EN() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in English Field. ********");
	  tp_page.English_En(arr.get(2));
	  Reporter.log(arr.get(2)+ " : is Entered in the English input field.");
	  Reporter.log("----------------------------------------");
	 
  }
  @Test(priority=6)
  public void Enter_valuefor_English_US() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in English US Field. ********");
	  tp_page.English_US(arr.get(3));
	  Reporter.log(arr.get(3)+ " : is Entered in the English US input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=7)
  public void Enter_valuefor_Dutch_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Dutch Field. ********");
	  tp_page.Dutch(arr.get(4));
	  Reporter.log(arr.get(4)+ " : is Entered in the Dutch input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=8)
  public void Enter_valuefor_German_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in German Field. ********");
	  tp_page.German(arr.get(5));
	  Reporter.log(arr.get(5)+ " : is Entered in the Dutch input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=9)
  public void Enter_valuefor_French_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in French Field. ********");
	  tp_page.French(arr.get(6));
	  Reporter.log(arr.get(6)+ " : is Entered in the French input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=10)
  public void Enter_valuefor_Italian_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Italian Field. ********");
	  tp_page.Italian(arr.get(7));
	  Reporter.log(arr.get(7)+ " : is Entered in the Italian input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=11)
  public void Enter_valuefor_Spanish_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Spanish Field. ********");
	  tp_page.Spanish(arr.get(8));
	  Reporter.log(arr.get(8)+ " : is Entered in the Spanish input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=12)
  public void Enter_valuefor_Portuguese_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Portuguese Field. ********");
	  tp_page.Portuguese(arr.get(9));
	  Reporter.log(arr.get(9)+ " : is Entered in the Portuguese input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=13)
  public void Enter_valuefor_Polish_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Polish Field. ********");
	  tp_page.Polish(arr.get(10));
	  Reporter.log(arr.get(10)+ " : is Entered in the Polish input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=14)
  public void Enter_valuefor_Chinese_Simplified_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Chinese Field. ********");
	  tp_page.Chinese_Simplified(arr.get(11));
	  Reporter.log(arr.get(11)+ " : is Entered in the Chinese input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=15)
  public void Enter_valuefor_Hindi_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Hindi Field. ********");
	  tp_page.Hindi(arr.get(12));
	  Reporter.log(arr.get(12)+ " : is Entered in the Hindi input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=16)
  public void Enter_valuefor_Indonesian_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Indonesian Field. ********");
	  tp_page.Indonesians(arr.get(13));
	  Reporter.log(arr.get(13)+ " : is Entered in the Indonesian input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=17)
  public void Enter_valuefor_Japanese_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Japanese Field. ********");
	  tp_page.Japanese(arr.get(14));
	  Reporter.log(arr.get(14)+ " : is Entered in the Japanese input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=18)
  public void Enter_valuefor_korean_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in korean Field. ********");
	  tp_page.korean(arr.get(15));
	  Reporter.log(arr.get(15)+ " : is Entered in the korean input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=19)
  public void Enter_valuefor_Malaysian_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Malaysian Field. ********");
	  tp_page.Malaysian(arr.get(16));
	  Reporter.log(arr.get(16)+ " : is Entered in the Malaysian input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=20)
  public void Enter_valuefor_Thai_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Thai Field. ********");
	  tp_page.Thai(arr.get(17));
	  Reporter.log(arr.get(17)+ " : is Entered in the Thai input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=21)
  public void Enter_valuefor_Vietnamese_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Thai Field. ********");
	  tp_page.Vietnamese(arr.get(18));
	  Reporter.log(arr.get(18)+ " : is Entered in the Vietnamese input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=22)
  public void Enter_valuefor_Turkish_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Turkish Field. ********");
	  tp_page.Turkish(arr.get(19));
	  Reporter.log(arr.get(19)+ " : is Entered in the Turkish input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=23)
  public void Enter_valuefor_Russian_language() throws IOException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********Enter value in Russian Field. ********");
	  tp_page.Russian(arr.get(20));
	  Reporter.log(arr.get(20)+ " : is Entered in the Russian input field.");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=24,description="APP-410:Save button")
  public void Verify_Save_Button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********TestCase- APP-410:Save button. ********");
	  tp_page.Save_changes();
	  isNotificationPresent();
	  Thread.sleep(1000);
	  tp_page.Notifications();
	  Thread.sleep(1000);
	  tp_page.Notifications();
	  Thread.sleep(1000);
	  Reporter.log("********End :TestCase- APP-410  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=25,description="APP-406:Reload button")
  public void Verify_Reload_button() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  Reporter.log("********TestCase- APP-406:Reload button. ********");
	  tp_page.Terminology_list(arr.get(0), "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value(arr.get(1), "t_terminology_value_table");
	  if(list){
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(arr.get(2)+"Test");
		  tp_page.English_US(arr.get(3)+"Test");
		  tp_page.Dutch(arr.get(4)+"Test");
		  tp_page.German(arr.get(5)+"Test");
		  tp_page.French(arr.get(6)+"Test");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("********End :TestCase- APP-406  ********");
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=26)
  public void Verify_Action_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("27", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Call the client", "t_terminology_value_table");
	  if(list){
		  String action = "Call the client";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(action);
		  tp_page.English_US(action);
		  tp_page.Dutch(action+" NL");
		  tp_page.German(action+" DE");
		  tp_page.French(action+" FR");
		  tp_page.Italian(action+" IT");
		  tp_page.Spanish(action+" ES");
		  tp_page.Portuguese(action+" PT");
		  tp_page.Polish(action+" POL");
		  tp_page.Chinese_Simplified(action+" CH");
		  tp_page.Hindi(action+" HIN");
		  tp_page.Indonesians(action+" INDO");
		  tp_page.Japanese(action+" Jap");
		  tp_page.korean(action+" KO");
		  tp_page.Malaysian(action+" Mal");
		  tp_page.Thai(action+" TH");
		  tp_page.Vietnamese(action+" VIE");
		  tp_page.Turkish(action+" TUR");
		  tp_page.Russian(action+" RUS");
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=27)
  public void Verify_Ageing_analysis_definitions_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("9", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("aging", "t_terminology_value_table");
	  if(list){
		  String value ="Standaard";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=28)
  public void Verify_Cost_schemes_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("42", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Temping", "t_terminology_value_table");
	  if(list){
		  String value ="Temping";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
 @Test(priority=29)
  public void Verify_Country_codes_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("7", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Test", "t_terminology_value_table");
	  if(list){
		  String value ="Test";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=30)
  public void Verify_Currency_descriptions_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("10", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Euro", "t_terminology_value_table");
	  if(list){
		  String value ="Euro";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=31)
  public void Verify_Debtor_status_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("26", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("High AlrertSave", "t_terminology_value_table");
	  if(list){
		  String value ="High AlrertSave";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  //tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=32)
  public void Verify_Dunning_languages_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("14", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Spanish MXNNew", "t_terminology_value_table");
	  if(list){
		  String value ="Spanish MXNNew";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=33)
  public void Verify_Dunning_letters_Terminology_List_value(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("6", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("HR Test", "t_terminology_value_table");
	  if(list){
		  String value ="HR Test";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=34)
  public void Verify_Dunning_status_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("64", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Test brief", "t_terminology_value_table");
	  if(list){
		  String value ="Test brief";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=35)
  public void Verify_Import_sources_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("38", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("STP Services", "t_terminology_value_table");
	  if(list){
		  String value ="STP Services";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=36)
  public void Verify_Menu_items_Terminology_List_value(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("10000", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Actieve klanten", "t_terminology_value_table");
	  if(list){
		  String value ="Actieve klanten";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=37)
  public void Verify_Notes_maintenance_definitions_Terminology_List_value(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("8", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Test", "t_terminology_value_table");
	  if(list){
		  String value ="Test";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=38)
  public void Verify_Pick_lists_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("34", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("TestPicklist", "t_terminology_value_table");
	  if(list){
		  String value ="TestPicklist";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=39)
  public void Verify_Picklist_items_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("35", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("TestPicklist", "t_terminology_value_table");
	  if(list){
		  String value ="TestPicklist value";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=40)
  public void Verify_Profile_name_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("12", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Nieuw", "t_terminology_value_table");
	  if(list){
		  String value ="New";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		 // tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=41)
  public void Verify_Reports_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("62", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Dashboard", "t_terminology_value_table");
	  if(list){
		  String value ="Dashboard";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.Italian(value+" IT");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		 // tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=42)
  public void Verify_Risk_codes_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("4", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("High Alrertsave", "t_terminology_value_table");
	  if(list){
		  String value ="High Alrertsave";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		 // tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=43)
  public void Verify_Standard_causes_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("2", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Agency", "t_terminology_value_table");
	  if(list){
		  String value ="Agency";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		 // tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=44)
  public void Verify_Standard_disputes_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("1", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Wrong VAT number", "t_terminology_value_table");
	  if(list){
		  String value ="Wrong VAT number";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		 // tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=45)
  public void Verify_Standard_solutions_Terminology_List_value(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("3", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Credit Nota", "t_terminology_value_table");
	  if(list){
		  String value ="Credit Nota";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		 // tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=46)
  public void Verify_Standard_text_Terminology_List_value(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("199", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("debtor", "t_terminology_value_table");
	  if(list){
		  String value ="debtor";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Parameters({"Locale","DataSource","DatabaseName"})
  @Test(priority=47)
  public void Verify_Status_Maintenance_Terminology_List_value(String Locale,String DataSource,String DatabaseName) throws Exception {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("29", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("In process", "t_terminology_value_table");
	  if(list){
		  String value ="In progress";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=48)
  public void Verify_User_fields_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("11", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Customer Alphanumeric", "t_terminology_value_table");
	  if(list){
		  String value ="Customer Alphanumeric";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=49)
  public void Verify_User_groups_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("23", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("Test User Groop111", "t_terminology_value_table");
	  if(list){
		  String value ="Test User Groop111";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(500);
	  }
	  Reporter.log("----------------------------------------");
  }
  @Test(priority=50)
  public void Verify_XML_Service_Name_Terminology_List_value() throws IOException, InterruptedException {
	  WebDriver driver=WebDriverManager.getDriverInstance();
	  Terminology_Page tp_page = new Terminology_Page(driver);
	  tp_page.Terminology_list("32", "t_terminology_list_table");
	  boolean list= tp_page.Terminology_Value("XML", "t_terminology_value_table");
	  if(list){
		  String value ="XML";
		  tp_page.Change_icon();
		  Thread.sleep(1500);
		  tp_page.English_En(value);
		  tp_page.English_US(value);
		  tp_page.Dutch(value+" NL");
		  tp_page.German(value+" DE");
		  tp_page.French(value+" FR");
		  tp_page.Italian(value+" IT");
		  tp_page.Spanish(value+" ES");
		  tp_page.Portuguese(value+" PT");
		  tp_page.Polish(value+" POL");
		  tp_page.Chinese_Simplified(value+" CH");
		  tp_page.Hindi(value+" HIN");
		  tp_page.Indonesians(value+" INDO");
		  tp_page.Japanese(value+" Jap");
		  tp_page.korean(value+" KO");
		  tp_page.Malaysian(value+" Mal");
		  tp_page.Thai(value+" TH");
		  tp_page.Vietnamese(value+" VIE");
		  tp_page.Turkish(value+" TUR");
		  tp_page.Russian(value+" RUS");
		  tp_page.Reload();
		  Thread.sleep(1000);
		  tp_page.Save_changes();
		  Thread.sleep(500);
		  isNotificationPresent();
		  Thread.sleep(1000);
		  tp_page.Notifications();
		  Thread.sleep(500);
		  tp_page.Notifications();
		  Thread.sleep(1000);
	  }
	  Reporter.log("----------------------------------------");
  }
  private boolean isNotificationPresent() {
		 
		 try 
		    { 
			 WebDriver driver=WebDriverManager.getDriverInstance();
			 Alert alert = driver.switchTo().alert(); 
			 System.out.println("==============     "+alert.getText()+"====================");
			 Reporter.log("Alert Found: "+ alert.getText());
			 alert.dismiss();
			 return true;
		    }   // try 
		    catch (Exception e) 
		    { 
		    	System.out.println("No Aterts found");
		        return false; 
		    }  
	 }
  public String  getTerminology_Type(String locale,int terminology_type,int terminology_id) throws Exception {
	  String myque = null;
	  switch(locale){
	  
		 case("EN") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=130 and terminology_id="+terminology_id+"";
		 break;
		 case("NL") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=100 and terminology_id="+terminology_id+"";
		 break;
		 case("FR") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=110 and terminology_id="+terminology_id+"";
		 break;
		 case("DE") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=120 and terminology_id="+terminology_id+"";
		 break;
		 case("ES") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=140 and terminology_id="+terminology_id+"";
		 break;
		 case("PT") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=150 and terminology_id="+terminology_id+"";
		 break;
		 case("IT") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=160 and terminology_id="+terminology_id+"";
		 break;
		 case("PO") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=170 and terminology_id="+terminology_id+"";
		 break;
		 case("RUS") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=130 and terminology_id="+terminology_id+"";
		 break;
		 case("TUR") :   myque="select terminology_text from terminology where terminology_type="+terminology_type+" and terminology_language_code=130 and terminology_id="+terminology_id+"";
		 break;
		 }
	return myque;
	 
	 }
}
