package Technical_Configration;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import appMan_Pages.Licence_Maintenance_page;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class Licence_maintenance {
	ReadXclData RD= new ReadXclData();
	ReadXclData rddata=new ReadXclData();
	 ArrayList<String>arr= new ArrayList<>();
	 @BeforeClass
	 public void  testData() throws Exception{
		 String[][] t = rddata.readdata("TC_Licence_Maintenance");
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
	}
	 @Test(priority=1)
	  public void Goto_licence_mainenance_Page() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Licence_Maintenance_page LM_page= PageFactory.initElements(driver, Licence_Maintenance_page.class);
		  Reporter.log("<<======================{Technical Configration}=======================>> ");
		  Reporter.log("________________________ Licence Maintenance_____________________________ ");
		  Reporter.log("************ Goto Licence Maintenance Tab ************ ");
		  LM_page.Goto_Licence_Maintenance_Page();
	  }
	  @Test(priority=2)
	  public void Enter_Licence_name() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Licence_Maintenance_page LM_page= PageFactory.initElements(driver, Licence_Maintenance_page.class);
		  Reporter.log("************ Test Case: APP-683:Apply valid license************  ");
		  Reporter.log("************ Verify Licence Name input field. ************ ");
		  Reporter.log("Enter Licence Name -");
		  LM_page.Enter_Licence_Name(arr.get(0));
		  Reporter.log(arr.get(0)+" : is Entered in the Licence name input field");
		  
		  Thread.sleep(1000);
	  }
	  @Test(priority=3)
	  public void Enter_Licence_Number() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Licence_Maintenance_page LM_page= PageFactory.initElements(driver, Licence_Maintenance_page.class);
		  Reporter.log("************ Enter Licence Number************ ");
		  LM_page.Enter_Licence_No("02","002",arr.get(1));
		  Thread.sleep(1000);
	  }
	  @Test(priority=4)
	  public void Upload_Licence_File() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Licence_Maintenance_page LM_page= PageFactory.initElements(driver, Licence_Maintenance_page.class);
		  Reporter.log("************ Upload File Using File Uplaod dialog box************ ");
		  LM_page.Upload_Licence_File_Location(arr.get(2));
		  Thread.sleep(1000);
	  }
	  @Test(priority=5,description="APP-683:Apply valid license")
	  public void Save_LicencePage_Changes() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Licence_Maintenance_page LM_page= PageFactory.initElements(driver, Licence_Maintenance_page.class);
		  Reporter.log("************ Save Changes ************  ");
		  LM_page.Save_Licence_Changes();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Reporter.log("********End :TestCase- APP-683  ********");
		  Reporter.log("----------------------------------------");
	  }
	  @Test(priority=6,description="APP-684:Apply invalid file name and number")
	  public void Apply_Invalid_Filename_and_Licence_number() throws IOException, InterruptedException {
		  WebDriver driver=WebDriverManager.getDriverInstance();
		  Licence_Maintenance_page LM_page= PageFactory.initElements(driver, Licence_Maintenance_page.class);
		  Reporter.log("************ Test Case: APP-684:Apply invalid file name and number************  ");
		  LM_page.Save_Licence_Changes();
		  Thread.sleep(3000);
		  LM_page.Notification();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(2000);
		  LM_page.Enter_Licence_Name(arr.get(0)+"s");
		  Reporter.log(arr.get(0)+"s" +" : is Enteed in the Licence name field");
		  LM_page.Save_Licence_Changes();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(500);
		  LM_page.Enter_Licence_No("021","0021",arr.get(1));
		  Reporter.log("021 , 0021"+"," +arr.get(1)+" : is Entered in the Licence Number Fields");
		  Thread.sleep(500);
		  LM_page.Save_Licence_Changes();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(500);
		  LM_page.Upload_Licence_File_Location(arr.get(2));
		  Thread.sleep(500);
		  LM_page.Save_Licence_Changes();
		  Thread.sleep(1000);
		  LM_page.Notification();
		  Thread.sleep(500);
		  LM_page.Notification();
		  Reporter.log("********End :TestCase- APP-684  ********");
		  Reporter.log("----------------------------------------");
		  Reporter.log("________________________ End of Licence Maintenance Section_____________________________ ");
	  }
}
