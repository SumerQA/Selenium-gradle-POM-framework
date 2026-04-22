package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Import_rules_Page {
   // WebDriverManager mgr = new WebDriverManager();
	Common c = new Common();	 
	final WebDriver driver;
	public  Import_rules_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_import_rules_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		
		/*HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(1000);*/
		
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_import_Rules_tab();
		Thread.sleep(2000);
		HI_page.Render_Notifications();
	    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
	    }
	 public void Update_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
	    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("delete_user");
		    }
	 public void Import_rulebook_name(String ir_name) throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.SendKey_event("IR_import_rules_name", ir_name);
			Reporter.log(ir_name+ " : is ernerted in the import rules name input field.");
		    }
	                                                             //Create Currency
	 public void Activated(String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS("IsActive", text);
		    }
		    
	 public void Account_manager(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Account_manager", text);
			
		    }
	 public void Credit_manager(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Credit_manager", text);
			
		    }
	 public void Dispute_manager(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Dispute_Manager", text);
			
		    }
	 public void Undersigned(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Undersigned", text);
			
		    }
	 public void User_group(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Usergroup", text);
			
		    }
	 public void Profile(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Profile", text);
			
		    }
	 public void Group_Profile(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Group_profile", text);
			
		    }
	 public void Debtor_status(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Debtor_status", text);
			
		    }
	 public void Risk_Code(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Risk_code", text);
			
		    }
	 public void Dunning_language(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Dunning_language", text);
			
		    }
	 public void Monitoring(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Monitoring", text);
			
		    }
	 public void Collection_agency(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Collection_agency", text);
			
		    }
	 public void Entity_table(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Entity_Table", text);
			
		    }
	 public void Interest_Scheme(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Int_Scheme", text);
			
		    }
	 public void Cost_Scheme(String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Cost_Scheme", text);
			
		    }
	 public void Reload() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Reload");
			
		    }
	 public void Debtor_rules_tab() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_debtor_rules_tab");
			
		    }
	 public void Invoice_rules_tab() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Invoice_rules_Tab");
			
		    }
	 public void Assign_Property_Action(String action) throws IOException, InterruptedException {
		 Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("IR_property_list")))); 
			List<WebElement> op = droplist.getOptions();
				for(WebElement el :op){
					try {
						if(el.getAttribute("value").equals(action)){
							//droplist.selectByVisibleText(action);
							el.click();
							Reporter.log( action+ " : is selected from DDlist");
					    	break;
					   }
						
					} catch (Exception e) {
						System.out.println(action+ "Not Found in DDlist");
						// TODO: handle exception
					}
					   }
			/*events eve = new events(driver);
			eve.DropDown_list("IR_property_list", action);*/
			
		    }
	 public void Assign_Property_Action_Invoice_Rule(String action) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Dropdow_by_attribute("IR_property_list_Invoice_rules", action);
			
		    }
	 public void Apply_rules(String action) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Dropdow_by_attribute("IR_property_list", action);
			
		    }
	 public void Apply_rules_to(String action) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Dropdow_by_attribute("IR_apply_rules_to", action);
			
		    }
	 public void Check_ALL_data_Checkbox(String action) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Checkbox("IR_chkAllData_chkbob", action);
			
		    }
		    
	 public void Criteria_Import_rule_(String action,String field,String operator,String value ,String impsrc) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Dropdow_by_attribute("IR_Action_option_DDlist", action);
			eve.Dropdow_by_attribute("IR_field", field);
			eve.Dropdow_by_attribute("IR_Conditional_op", operator);
			eve.SendKey_event("IR_criteria_value", value);
			try {
				eve.Dropdow_by_attribute("IR_import_source_ddlist", impsrc);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Import Source List is Empty");
			}
			
		    }
	 public void Assign_Entity_table_(String action,String field,String operator,String value ,String impsrc) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.DropDown_list("IR_Action_option_DDlist", action);
			eve.Dropdow_by_attribute("IR_field", field);
			eve.Dropdow_by_attribute("IR_Conditional_op", operator);
			eve.SendKey_event("IR_criteria_value", value);
			try {
				eve.Dropdow_by_attribute("IR_import_source_ddlist", impsrc);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Import Source List is Empty");
			}
			
		    }
	 public void Credit_limit_Criteria_Import_rule_(String text,String action,String field,String operator,String value ,String impsrc) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Check_box_JS("IsCreditLimit", "No");
			try {
				eve.SendKey_event("IR_Credit_limit", text);
			} catch (Exception e) {
				// TODO: handle exception
			}
			eve.Dropdow_by_attribute("IR_currency", action);
			eve.Dropdow_by_attribute("IR_field", field);
			eve.Dropdow_by_attribute("IR_Conditional_op", operator);
			eve.SendKey_event("IR_criteria_value", value);
			try {
				eve.Dropdow_by_attribute("IR_import_source_ddlist", impsrc);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Import Source List is Empty");
			}
		    }
	 public void Date_Criteria_Import_rule(String action,String field,String operator,String value ,String impsrc) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Dropdow_by_attribute("IR_Action_option_DDlist", action);
			eve.Dropdow_by_attribute("IR_field", field);
			eve.Dropdow_by_attribute("IR_Conditional_op", operator);
			Thread.sleep(500);
			
			try {
				eve.Dropdow_by_attribute("IR_import_source_ddlist", impsrc);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Import Source List is Empty");
			}
			eve.date_time_Picker(value);
		    }
	 public void Create_criteria_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_create_criteria_icon");
			
		    }
	 public void Import_rule_Table(String ePath,String txt) throws IOException, InterruptedException {
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
						int rowno= rownum+1;
						int colNo =colnum+1;
						System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
						if(txt.equals("Yes")){
							if(!driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).isSelected()){
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).click();
							}
						}else{
							if(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).isSelected()){
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).click();
							}
							
						}
					} 
				}
		    }
	 
	 public void Delete_Import_rule_Table(String ePath,String txt) throws IOException, InterruptedException {
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
						int rowno= rownum+1;
						int colNo =colnum+1;
						System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
						if(txt.equals("Yes")){
							if(!driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).isSelected()){
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).click();
							}else{
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[2]")).click();
							}
						}else{
							if(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).isSelected()){
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td[1]/span/input")).click();
							}
							
						}
					} 
				}
		    }
	 public void Update_criteria_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_update_criteria_icon");
			
		    }
	 public void Delete_criteria_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_delete_criteria_icon");
			
		    }
	 public void Reload_Criteria() throws IOException, InterruptedException {
		    events eve = new events(driver);
			eve.Click_eventBy_ClassName("reloadCR");
			
		    }
	 public void Save_Criteria() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Save_Criteria");
			
		    }
	 public void Save_and_Close_Criteria() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("saveCloseCR");
			
		    }
	 public void Cancel_Criteria() throws IOException, InterruptedException {
		 events eve = new events(driver);
			eve.Click_eventBy_ClassName("closeAllCR");
			
		    }
	 public void Reload_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
		    }
	 public void Create_import_rule_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Create_rulebook");
			
		    }
	 public void Update_import_rule_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Update_roolbook");
			
		    }
	 public void Delete_import_rule_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Delete_roolbook");
			
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Save");
			
		    }
	 public void Save_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Save_and_close"); //C_Save_n_Close
			
		    }
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("IR_Cancel");
		    }
	 public void Notifications() throws IOException, InterruptedException {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notificatio: ----------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("-----------------------------------------------------");
			}
		    }
	 public void link() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Link");
		    }
	 public void Unlink() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Unlink");
		    }
	 public void Select_First_Row_From_Criteria_Table(String ePath) throws IOException {  //Will get the table cells data and click on particular cell
			System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).getText()+" is selected");
			Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).getText()+" is selected from table");
			driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						
			}
	 
	public boolean Verify_Criteria_in_table(String ePath,String keyword) throws IOException {  //Will get the table cells data and click on particular cell
			System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).getText()+" is selected");
			Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).getText()+" is selected from table");
			String string=driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).getText();
			Reporter.log("Criteria: "+ string);
			boolean found = Arrays.asList(string.split(" ")).contains(keyword);
				/*if(found){
				      System.out.println("Keyword matched the string");
				}else{
					throw new ElementNotVisibleException("Not Found");
				}
				driver.findElement(By.xpath(c.getElementName(ePath)+"/tr/td[1]")).click();
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);*/
				return found;
			} 
	   	}
