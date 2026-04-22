package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Profiles_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Profiles_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Profile_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		//Commented area
		/*HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(1500);
		*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		FC_page.Click_Profiles_tab();
		Thread.sleep(1500);
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
	 public void Profile_Name(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
	 public void profile_Type(String path, String text) throws IOException, InterruptedException { 
			events eve = new events(driver);
			eve.DropDown_list_eventBy_index(path,text);
		    }
	 public void Rest_Period(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
		    
	 public void Show_rest_Period_Checkbox(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.Check_box_JS(path, text);
			
		    }
	 public void End_of_monthCreation_checkbox(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.Checkbox(path,text);
		    }
	 public void Emd_of_month(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
	 public void Emd_of_month_Plus_XDays(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
	 public void Recuring_Actions(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			
		    }
	 public void Recuring_Actions_Items(String path) throws IOException {          //recurring action items  
		 WebElement element= driver.findElement(By.xpath(c.getElementName(path)));
		 Actions builder=new Actions(driver);
			List<WebElement> rows=element.findElements(By.tagName("div"));
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				int rowno =rownum+1;
				if(!driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img")).getAttribute("title").isEmpty()){
					String tooltip = driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img")).getAttribute("title");
					WebElement wtool = driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img"));
					System.out.println(tooltip);
						builder.moveToElement(wtool).perform();
						break;
			}
				}
			}
	 public void Update_Recuring_Actions_Items(String path) throws IOException {          //recurring action items  
		 WebElement element= driver.findElement(By.xpath(c.getElementName(path)));
		 Actions builder=new Actions(driver);
			List<WebElement> rows=element.findElements(By.tagName("div"));
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				int rowno =rownum+1;
				if(!driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img")).getAttribute("title").isEmpty()){
					String tooltip = driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img")).getAttribute("title");
					WebElement wtool = driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img"));
					System.out.println(tooltip);
						builder.moveToElement(wtool).perform();
						builder.moveToElement(driver.findElement(By.xpath(c.getElementName(path)+"/div["+rowno+"]/img"))).doubleClick().build().perform();
						break;
			}
				}
			}
	 public void Always_generate_actions(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			
		    }
	 public void Action_Type(String path, String text) throws IOException {
		 events eve = new events(driver);
			switch(text){
			case("1"): 
				eve.DropDown_list_eventBy_index(path, "0");
			    break;     
			case("2"):
				eve.DropDown_list_eventBy_index(path, "1");
			    break;
			case("3"):
				eve.DropDown_list_eventBy_index(path, "2");
			break;
			}  
	 }	
	 
	 public void phone_Action(String path, String attribID) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, attribID);
		}
	 
	 public void Dunning_letter_Action(String path,String text,String outputChannalPath, String outputChannaltext,String reciptextpath,String reciptext,String letterPath, String letterText,String InvcText, String CreditNotesText) throws IOException, InterruptedException {
			    events eve = new events(driver);
			    eve.Dropdow_by_attribute(path, text);
				if(outputChannaltext.equals("2")){
					eve.Dropdow_by_attribute(outputChannalPath, outputChannaltext);
				}else{
					eve.Dropdow_by_attribute(outputChannalPath, outputChannaltext);
					eve.Dropdow_by_attribute(reciptextpath,reciptext);
				}
				eve.DropDown_list_event(letterPath,letterText);
				
				if(InvcText.equals("No invoices selected")){                                            //Invoices radio button
					eve.Click_event("p_a_No_invoice_selected");
				}if(InvcText.equals("Include all outstanding invoices of this customer?")){
					eve.Click_event("//*[@id='divDunningLetterSettings']/div[4]/div[2]/div/label");
				}else{
					eve.Click_event("p_a_nclude_all_Overdue_Invoices_for_this_customer");
				}
				
				if(CreditNotesText.equals("Do not include credit notes")){                                            //Credit Notes button
					eve.Click_event("p_a_donot_inculde_credit_notes");
				}if(CreditNotesText.equals("Include all credit notes")){
					eve.Click_event("p_a_Include_all_credit_notes");
				}else{
					eve.Click_event("p_a_Include_only_credit_notes_overdue");
				}
				
				eve.Checkbox("p_a_include_blocked_invoices","Yes"); 
				if(driver.findElement(By.xpath(c.getElementName("p_a_Generate_follow_up_phone"))).isSelected()){
					eve.Checkbox("p_a_Generate_follow_up_phone","Yes");
				}else{
					eve.Checkbox("p_a_Generate_follow_up_phone","Yes");
					eve.SendKey_event("p_a_afternDays", "10");
				}
				                                                    
			}
	 
	 public void E_mail_action(String path,String text, String emailAfternDays) throws IOException {
			 events eve = new events(driver);
			 eve.Dropdow_by_attribute(path, text);
			 eve.Checkbox("p_a_acc_mngr","Yes");                         
			 eve.Checkbox("p_a_Crfedit_mngr","Yes");  
			 eve.Checkbox("p_a_signedBy","Yes");//Credit manager 
             eve.DropDown_list_event("p_a_templete", "HTML test");
              if(driver.findElement(By.xpath(c.getElementName("p_a_Generate_follow_up_phone_action"))).isSelected()){
             	 eve.Checkbox("p_a_Generate_follow_up_phone_action","Yes");
              }else{
             	 eve.Checkbox("p_a_Generate_follow_up_phone_action","Yes");
             	 eve.SendKey_event("p_a_EmailAfter_n_Days", emailAfternDays);
              }
			}
	 
	 public void Block_monitoring_Action(String path, String text, String block_cust, String BlockInv) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, text);
		 eve.Checkbox("p_a_block_cust",block_cust);
		 eve.Checkbox("p_a_block_inv", BlockInv);	 
		 }
	 
	 public void Assign_Customer_Status_Action(String path, String text, String cspath, String cstext) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, text);
		 eve.DropDown_list_event(cspath, cstext);
		}
	 
	 public void Assign_Risk_Code_Action(String path, String text, String rcpath, String rctext) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, text);
		 eve.DropDown_list_event(rcpath, rctext);
		}
	 
	 public void Assign_User_Group_Action(String path, String text,String ugpath, String ugtext) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, text);
		 eve.DropDown_list_event(ugpath, ugtext);
		}
	 
	 public void Assign_Profile_Action(String path, String text,String appath, String aptext) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, text);
		 eve.DropDown_list_event(appath, aptext);
		}
	 
	 public void Remove_User_Group_Action(String path, String text,String ugapath, String ugatext) throws IOException {
		 events eve = new events(driver);
		 eve.Dropdow_by_attribute(path, text);
		 eve.DropDown_list_event(ugapath, ugatext);
		}
	 
	 public void Request_Action(String path, String text,String rapath, String ratext) throws IOException {
		 events eve = new events(driver);
		 try {
			 eve.Dropdow_by_attribute(path, text);
			 eve.DropDown_list_event(rapath, ratext);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		 
		}
	 
	 
	 public void Criteria(String path,String text) throws IOException {
		 WebElement element= driver.findElement(By.xpath(c.getElementName(path)));
			List<WebElement> rows=element.findElements(By.tagName("span"));
			for(WebElement el:rows){
				if(el.getText().equals(text)){
					el.click();
					el.click();
					break;
				}
			}
		}
	 
	 
	 public void Balance_Criteria_to_Generate_the_Action(String C_o_Text, String C_control,String balInput, String blocked_inv_Checkbox,String credit_inv_Checkbox) throws IOException, InterruptedException {  
		 events eve = new events(driver);
		 eve.DropDown_list_event("p_a_Conditional_operator", C_o_Text);
	     if(C_control.equals("Balance")){
			if(driver.findElement(By.xpath(c.getElementName("p_a_balance_Rbutton"))).isEnabled()){
				 eve.Click_event("p_a_balance_Rbutton");
				 eve.SendKey_event("p_a_balance_input", balInput);
			}
			}else{
				if(driver.findElement(By.xpath(c.getElementName("p_a_percentage_of_C_limit"))).isEnabled()){
					 eve.Click_event("p_a_percentage_of_C_limit");
					 eve.SendKey_event("p_a_percentage_of_C_limit_input", balInput);
			}
			 }
			 
			 eve.Checkbox("p_a_Include_blocked_invoice_checkbox",blocked_inv_Checkbox);
			 if(driver.findElement(By.xpath(c.getElementName("p_a_include_credit_invoices"))).isEnabled()){
				 eve.Checkbox("p_a_include_credit_invoices",credit_inv_Checkbox);
			 }
			 
		 }
	  
	 
	 public void Number_Criteria_to_Generate_the_Action(String C_o_Text,String balInput, String blocked_inv_Checkbox,String credit_inv_Checkbox) throws IOException, InterruptedException {  
		 events eve = new events(driver);
		 eve.DropDown_list_event("p_a_Conditional_operator", C_o_Text);
				eve.SendKey_event("p_a_nomber_of_invoice", balInput);
				eve.Checkbox("p_a_Include_blocked_invoice_checkbox",blocked_inv_Checkbox);
				if(driver.findElement(By.xpath(c.getElementName("p_a_include_credit_invoices"))).isDisplayed()){
					eve.Checkbox("p_a_include_credit_invoices",credit_inv_Checkbox);
				}
	  }
	 
	 public void UDF_Criteria_to_Generate_the_Action(String path,String C_o_Text,String Input) throws IOException, InterruptedException {  
		 events eve = new events(driver);
		 eve.DropDown_list_event("p_a_Conditional_operator", C_o_Text);
		 eve.SendKey_event(path, Input);
	  }
	 public void Time_UDF_Criteria_to_Generate_the_Action(String C_o_Text,String UD_field, String date_input) throws IOException, InterruptedException {  
		 events eve = new events(driver);
		 eve.Click_event("");// Click on Customer Score 
		 eve.DropDown_list_event("p_a_Conditional_operator", C_o_Text);
		 if(UD_field.equals("Date")){
			 eve.Click_event("p_a_today_Rbutton");
			 eve.SendKey_event("p_a_date_input", date_input);
		 }
	  }
	 
	 
	 public void Perform_During_import(String path,String text) throws IOException {
			 if(driver.findElement(By.xpath(c.getElementName(path))).isDisplayed()){
				 events eve = new events(driver);
					eve.Checkbox(path,text); 
			 }
				
		    }
	 
	 public void From_Days(String path,String text) throws IOException {
			 if(driver.findElement(By.xpath(c.getElementName(path))).isEnabled()){
				 events eve = new events(driver);
				 eve.SendKey_event(path, text); 
			 }
		    }
	 
	 public void Generate_action(String text) throws IOException, InterruptedException {
		 
			 events eve = new events(driver);
			 if(driver.findElement(By.xpath(c.getElementName("p_always_generate"))).isSelected()){
			 if(text.equals("Always generate")){
				eve.Click_event("p_always_generate");
			 }else{
				 eve.Click_event("p_generate_in_sequence");
			 }
			 }
		    }
	 
	 public void Comments(String path,String text) throws IOException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
	 
	 public void Recurs(String text) throws IOException, InterruptedException {
			 events eve = new events(driver);
			 try {
				 if(driver.findElement(By.xpath(c.getElementName("p_weekly_recure"))).isEnabled()){
					 if(text.equals("Weekly")){
						eve.Click_event("p_weekly_recure");
						}else{
							eve.Click_event("p_monthly_recure");
						}
					 }
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			 
		    }
	 
	 public void Oldest_invoice_action_table(String ePath) throws IOException {
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			for(int rownum = 1; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					int rowno= rownum+1;
					int colNo =colnum+1;
					Actions builder=new Actions(driver);
					try {
						System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img")).toString());
						if(!driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img")).getAttribute("title").isEmpty()){
						String tooltip = driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img")).getAttribute("title");
						WebElement wtool = driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img"));
						System.out.println(tooltip);
							builder.moveToElement(wtool).perform();
							Thread.sleep(500);
							break;
							}
					} catch (Exception e) {
						System.out.println("not found");					}
					
					} 
				}
		    }
	 
	 public void Update_Oldest_invoice_action_table(String ePath,String text) throws IOException {
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			for(int rownum = 1; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					int rowno= rownum+1;
					int colNo =colnum+1;
					Actions builder=new Actions(driver);
					try {
						//System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img")).toString());
						if(!driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img")).getAttribute("title").isEmpty()){
						String tooltip = driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img")).getAttribute("title");
						WebElement wtool = driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img"));
						System.out.println(tooltip);
						String[] lines = tooltip.split("\n");
						if(lines[0].equals(text)){
							builder.moveToElement(wtool).perform();
							builder.moveToElement(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]"+"/div/div/img"))).doubleClick().build().perform();
							Thread.sleep(500);
							break;
						}
						break;
							}
					} catch (Exception e) {
						System.out.println("not found");					}
					
					} 
				}
		    }
	 
	 public void Criteria_to_generate_the_Action(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);
		    }
	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("C_Refresh");
			
		    }
	 public void Update_actionto_generate() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_change_actionto_gen");
			
		    }
	 public void Delete_actionto_generate() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_delete_actionto_gen");
		    }
	 public void Reload() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
			
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("save_icon");
			
		    }
	 public void Save_panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event("save_n_Close");
		    }
	 public void Save_and_Close_Generated_Action() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event_javaScript(driver.findElement(By.xpath("//*[@id='divMain']/div[3]/div/div[2]/div/div/ul/li[3]/a/img")));
		    }
	 public void Save_Generated_Action() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event("P_Save_action");
		    }
	 public void Relaod_Generated_Action() throws IOException, InterruptedException {
			events eve = new events(driver);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			eve.Click_event_javaScript(driver.findElement(By.xpath("//*[@id='divMain']/div[3]/div/div[2]/div/div/ul/li[1]")));
		    }
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_Close_profile");
			
		    }
	 public void Cancel_Generated_Action() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_Cancel_action");
			
		    }
	 public void Create_Criteria() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_Crate_Criteria");
			
		    }
	 public void Change_Criteria() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_Change_Criteria");
			
		    }
	 public void Delete_Criteria() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("P_Delete_Criteria");
			
		    }
	 
	 public void Notification() throws IOException, InterruptedException {
				events eve = new events(driver);
				if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
					eve.GetText_event("Save_changes_notification_Message");
					eve.Click_event("Save_changes_notification_OK_button");
				}else{
					System.out.println("No notification Found");
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
	 
	 public void Table_event(String compTest, String ePath) throws IOException {  //Will get the table cells data and click on particular cell
		  WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			labrow :
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					Pattern r = Pattern.compile(compTest);
				      // Now create matcher object.
				      Matcher m = r.matcher(columns.get(colnum).getText());
				      if(m.find()){
				    			int rowno= rownum+1;
								int colNo =colnum+1;
								System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
								Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).click();
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
								break labrow;
								}
					
					} 
				}
			//System.out.println("Usergroup is selected for linking with New User");
			}
	}
