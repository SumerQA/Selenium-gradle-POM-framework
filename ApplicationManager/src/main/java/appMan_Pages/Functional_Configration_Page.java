package appMan_Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import Configration_Files.Common;
import Configration_Files.WebDriverManager;

public class Functional_Configration_Page {
	Common c = new Common();
	final WebDriver driver;
	WebDriverManager mgr = new WebDriverManager();
	public  Functional_Configration_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Clickon_Administration_tab() throws IOException {      //Will Click on Administration tab Functional Configration
		driver.findElement(By.xpath(c.getElementName("fun_conf_admin"))).click();
		System.out.println("Clicked on Functional Configration Administration tab in Functional Configration section");   
		Reporter.log("Clicked on Administration Tab");
	}
	 public void Click_on_tables_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("table_tab"))).click();
		System.out.println("Clicked on Tables Tab"); 
		Reporter.log("Clicked on Tables Tab");
		    }
	 public void Click_on_Dunning_lang_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("dunning_lang_tab"))).click();
		System.out.println("Clicked on Dunning Language in Tables section");
		Reporter.log("Clicked on Dunning Language in Tables section");
	    }
	 public void Click_on_Customer_Status_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("cust_stats"))).click();
		System.out.println("Clicked on Customer Status tab in Tables section"); 
		Reporter.log("Clicked on Customer Status tab in Tables section");
	    }
	 public void Click_on_RiskCode_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("risk_code_tab"))).click();
		System.out.println("Clicked on Risk code tab in Tables section");  
	    }
	 public void Click_on_Payment_method_tab() throws IOException {	
			driver.findElement(By.xpath(c.getElementName("p_method_tab"))).click();
			System.out.println("Clicked on Payment Method tab in Tables section");  
		    }
	 public void Click_on_User_defined_fields_tab() throws IOException, InterruptedException {	
		driver.findElement(By.xpath(c.getElementName("U_Def_Field"))).click();
		Thread.sleep(1000);
		System.out.println("Clicked on User defined fields tab in Tables section");  
		Reporter.log("Clicked on User defined fields tab in Tables section");
	    }
	 public void Click_on_Terminology_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("terminology"))).click();
		System.out.println("Clicked on Terminology tab in Tables section");  
		Reporter.log("Clicked on Terminology tab in Tables section");
	    }

	 public void Click_on_System_Notes_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("sys_nots"))).click();
		System.out.println("Clicked on System Notes tab in Tables section"); 
		Reporter.log("Clicked on System Notes tab in Tables section");
	    }
	 public void Click_on_Country_Code_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("curr_code"))).click();
		System.out.println("Clicked on Currency Code tab in Tables section");  
	    }
	 public void Click_Currency_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("currrency"))).click();
		Reporter.log("Clicked on Currency Tab");
		System.out.println("Clicked on Currency tab in Functional Configration Section");  
	    }
	 public void Click_Aging_Analysis_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("aging_analysis"))).click();
		Reporter.log("Clicked on Aging Analysis Tab.");
		System.out.println("Clicked on Aging Analysis in Functional Configration Section");  
	    }
	 public void Click_Payment_scheme_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("paym_scheme"))).click();
		Reporter.log("Payment Schemes Tab is Clicked.");
		System.out.println("Clicked on Payment Schemes in Functional Configration Section");  
	    }
	 public void Click_interest_Scheme_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("int_scheme"))).click();
		Reporter.log("Clicked on Interest Scheme Tab.");
		System.out.println("Clicked on Interest Scheme in Functional Configration Section");  
	    }
	 public void Click_Cost_Scheme_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("cost_scheme"))).click();
		Reporter.log("Cost Schemes Tab is Clicked.");
		System.out.println("Clicked on Cost Schemes in Functional Configration Section");  
	    }
	 public void Request_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("req"))).click();
		Reporter.log("Request Tab is Clicked.");
		System.out.println("Clicked on Request in Functional Configration Section");
		
	    }
	 public void Click_Disputes_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("Disp"))).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Clicked on Disputs in Functional Configration Section"); 
		Reporter.log("Clicked on Disputs in Functional Configration Section");
	    }
	 public void Click_Standard_Disputes_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("stand_disp"))).click();
		System.out.println("Clicked on Standard dispute in disputes Section"); 
		Reporter.log("Clicked on Standard dispute in disputes Section");
	    }
	 public void Click_Standard_Causes_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("stand_caus"))).click();
		System.out.println("Clicked on Standard Causes in disputes Section");  
		Reporter.log("Clicked on Standard causes in disputes Section");
	    }
	 public void Click_Standard_solutions_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("stand_sol"))).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Clicked on Standard Solutions in disputes Section");  
	    }
	 public void Click_Status_Maintenance_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("stats_ment"))).click();
		System.out.println("Clicked on Status maintenance in disputes Section");  
		Reporter.log("Clicked on Status maintenance in disputes Section");
	    }
	 public void Click_Dispute_Action_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("disp_act"))).click();
		System.out.println("Clicked on Dispute_Action in disputes Section"); 
		Reporter.log("Clicked on Dispute_Action in disputes Section");
	    }
	 public void Click_Export_Settings_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("exp_sett"))).click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		System.out.println("Clicked on Export Settings in Functional Configration Section");  
	    }
	 public void Click_Communication_tab() throws IOException {
		driver.findElement(By.xpath(c.getElementName("Comm"))).click();
		System.out.println("Clicked on Communication in Functional Configration Section"); 
		Reporter.log("Communication Tab is Clicked.");
	    }
	 public void Click_Documents_templates_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("doc_temp"))).click();
		System.out.println("Clicked on Documents and Templates in Communication Section"); 
		Reporter.log("Clicked on Documents and Templates Tab.");
	    }
	    
	  public void Click_Entity_tables_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("Entity_tables"))).click();
		System.out.println("Clicked on Entity Tables tab in Communication Section"); 
		Reporter.log("Clicked on Entity tables Tab.");
		}
	 public void Click_Secure_Smart_Email_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("Sec_smart_email"))).click();
		System.out.println("Clicked on Secure Smart Email in Communication Section");  
		Reporter.log("Clicked on Secure Smart Email Tab.");
	    }
	 public void Click_Profiles_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("prof"))).click();
		System.out.println("Clicked on Profile in Functional Configration Section");  
	    }
	 public void Click_Collection_Interface_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("coll_interface"))).click();
		System.out.println("Clicked on Collection Interface in Functional Configration Section");  
		Reporter.log("Collection interface Tab is Clicked.");
	    }
	 public void Click_Customer_Scoring_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("cus_scor"))).click();
		Reporter.log("Clicked on Customer Scoring in Functional Configration Section");
		System.out.println("Clicked on Customer Scoring in Functional Configration Section");  
	    }
	 public void Click_import_Rules_tab() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("imp_rules"))).click();
		Reporter.log("Clicked on Import Rules in Functional Configration Section");
		System.out.println("Clicked on Import Rules in Functional Configration Section");  
	    }
	 public void general_profile() throws IOException {	
		driver.findElement(By.xpath(c.getElementName("DD_logout"))).click();
	    }
	
	
	 public void Click_on_CreateNew_Administration_icon() throws IOException, InterruptedException {	
		Users_Page UP= new Users_Page(driver);
		UP.Open_Create_NewUser_panal();
		
	    }
	
	 public void Edit_Existing_Administration() throws IOException, InterruptedException {	
		Users_Page UP= new Users_Page(driver);
		UP.Click_On_Change_icon();
	    }
	
	 public void Delete_Administration() throws IOException, InterruptedException {
		Users_Page UP= new Users_Page(driver);
		UP.Delete_icon();
	    }
	
	 public void Admin_Notifications() throws IOException, InterruptedException {
		Security_Page ImS_Page= new Security_Page(driver);		
		ImS_Page.Save_All_Changes_Notifications();
	    }
	
	 public void Refresh_Admin_Chanes() throws IOException, InterruptedException {
		Users_Page u_Page= new Users_Page(driver);		
		u_Page.refresh_icon();
	    }
	
	
	 }