package appMan_Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Cost_Schemes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Cost_Schemes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Cost_Scheme_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			/*
			 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(1500);
			 */
			Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
			FC_page.Click_Cost_Scheme_tab();
			Thread.sleep(1000);
			HI_page.Render_Notifications();
		    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("is_create_icon");
			Reporter.log("Create Icon is Clicked.");
		    }
	 public void Update_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("is_update_icon");
			Reporter.log("Update Icon is Clicked.");
		    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("is_delete_icon");
			Reporter.log("Delete Icon is Clicked.");
		    }
	                                                             
	 public void Cost_scheme_Name(String path , String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ ": is Entered in the Interest scheme name input field");
		    }
	 public void Description(String path , String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+ ": is Entered in the Description input field");
		    }
	 
	 public void Currency(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			
		    }
	 public void Rounding(String path, String text) throws IOException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
			
		    }		    
	
	 public void Apply_Admin_Costs(String path,String id, String text,String Inputtext) throws IOException {
		 	events eve=new events(driver);
			Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById(" + "'"+ id + "'" + ");" + "  if (chkBox.checked) {"+ "  return true  ;" + "  }" + " else{"+ " return false;" + "}");
			boolean checkboxStatus = (Boolean) bool;
			if (text.equals("Yes")) {				
				if (checkboxStatus) {
				System.out.println("Checkbox is already Checked");
				Reporter.log("Checkbox is already Checked");
				eve.SendKey_event(path, Inputtext);
				} else {
				((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				Reporter.log("Checkbox is Checked Now");
				eve.SendKey_event(path, Inputtext);
				}
			} else {
				if (checkboxStatus) {
					((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				} else {
				System.out.println("Checkbox is unchecked already");
				Reporter.log("Checkbo ix is unchecked already");
				}
              }
			
		    }
	
	 public void Apply_Collection_Costs(String path,String id, String text,String Inputtext) throws IOException {
		 	events eve=new events(driver);
			Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById(" + "'"+ id + "'" + ");" + "  if (chkBox.checked) {"+ "  return true  ;" + "  }" + " else{"+ " return false;" + "}");
			boolean checkboxStatus = (Boolean) bool;
			if (text.equals("Yes")) {				
				if (checkboxStatus) {
				System.out.println("Checkbox is already Checked");
				Reporter.log("Checkbox is already Checked");
				eve.SendKey_event(path, Inputtext);
				} else {
				((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				Reporter.log("Checkbox is Checked Now");
				eve.SendKey_event(path, Inputtext);
				}
			} else {
				if (checkboxStatus) {
					((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				} else {
				System.out.println("Checkbox is unchecked already");
				Reporter.log("Checkbo ix is unchecked already");
				}
              }
		    }
	 
	 public void Variable_Collection_Costs(String id, String text, String cb_on,String tb_of,String max_cost) throws IOException, InterruptedException {
		 	Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById(" + "'"+ id + "'" + ");" + "  if (chkBox.checked) {"+ "  return true  ;" + "  }" + " else{"+ " return false;" + "}");
			boolean checkboxStatus = (Boolean) bool;
			if (text.equals("Yes")) {				
				if (checkboxStatus) {
				System.out.println("Checkbox is already Checked");
				Reporter.log("Checkbox is already Checked");
				Cost_based_on("Cos_Cost_based_on", cb_on);
				Total_balance_of("Cos_ddlTotalBalance", tb_of);
				maximum_Cost("COs_txtMaxCost", max_cost);
				} else {
				((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				Reporter.log("Checkbox is Checked Now");
				Cost_based_on("Cos_Cost_based_on", cb_on);
				Total_balance_of("Cos_ddlTotalBalance", tb_of);
				maximum_Cost("COs_txtMaxCost", max_cost);
				}
			} else {
				if (checkboxStatus) {
					((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
				} else {
				System.out.println("Checkbox is unchecked already");
				Reporter.log("Checkbo ix is unchecked already");
				}
              }
			
		    }
	 public void Cost_based_on(String path, String action) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.DropDown_list_event(path, action);
			
		    }
	 public void Total_balance_of(String path, String action) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Dropdow_by_attribute(path, action);
			
		    }
	 public void Add_ICON_Collection_Cost_Scheme_range(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);//Click on Add Icon
			
		    }
	 public void Update_ICON_Collection_Cost_Scheme_range(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);//Click on Add Icon
			
		    }
	 public void Delete_ICON_Collection_Cost_Scheme_range(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);//Click on Add Icon
			
		    }
	 
	 public void Add_Collection_Cost_Scheme_range(String ePath,String from,String to,String value) throws IOException, InterruptedException {
			WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			int cou=rows.size();
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[2]/span[1]/span/input[1]")).clear();
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[2]/span[1]/span/input[1]")).sendKeys(from);
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[3]/span[1]/span/input[1]")).clear();
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[3]/span[1]/span/input[1]")).sendKeys(to);
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[4]/input")).clear();
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[4]/input")).sendKeys(value);
		    }
	 public void Update_Collection_Cost_Scheme_range(String ePath,String updatePath,String from) throws IOException, InterruptedException {
			WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			int cou=rows.size();
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]/td[2]")).click();
			driver.findElement(By.xpath(c.getElementName(updatePath))).click();
			Thread.sleep(800);
			driver.findElement(By.xpath("//input[@data-bind='value:From']")).clear();
			Thread.sleep(800);
			driver.findElement(By.xpath("//tbody/tr[@role='row']/td[2]/span[1]/span[1]/input[1]")).click();
			Thread.sleep(3000);
			Clear_InputFieldJS(from);
		     }
	 public void Select_Collection_Cost_Scheme_range(String ePath) throws IOException, InterruptedException {
			WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows = element.findElements(By.tagName("tr"));
			int cou=rows.size();
			driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + cou+ "]")).click();
		     }
	 public void maximum_Cost(String path,String text) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event(path, text);
						
		    }

	public void Collection_Cost_Scheme_ICon() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Cos_coll_cost_scheme_btn");
			
	    } 
	
	 public void Cancel_Collection_Cost_range_window_icon(String path) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event(path);
			
		    }
	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("RE_Refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Refresh_panal() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
			Reporter.log("Reload button is Clicked.");
			
		    }
	 public void Save_Panel_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_Panal_Changes");
			Reporter.log("Save button is Clicked.");
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Cos_Save_Icon");//a[starts-with(@class,'save')]/img[contains(@src,'save_16')]
			Reporter.log("Save button is Clicked.");
			
		    }
	 public void Save_as_new() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Cos_Save_as_New_Icon");
			Reporter.log("Save as New button is Clicked.");
			
		    }
	 public void Close() throws IOException, InterruptedException {
		 try {
			 events eve = new events(driver);
			eve.Click_event("PS_Cancel");
				 
			 
		} catch (Exception e) {
			// TODO: handle exception
		}
			
			
		    }
	 public void Save_and_Close() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("PS_Save_and_Close");
			Reporter.log("Save and Close button is Clicked.");
			
		    }
	 public void Notification() throws IOException, InterruptedException {
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification : ---------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("------------------------------------------------------");
			}
			
		    }
	 public void NO_Notification_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_changes_notification_NO_button");
			Reporter.log("No Button is Clicked.");
			
		    }
	 
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Link button is Clicked.");
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
			Reporter.log("Unlink button is Clicked.");
		    }
	 public void Clear_InputFieldJS(String val) {
			((JavascriptExecutor) driver).executeScript("document.querySelector(\"input[role='spinbutton'][type='text'][data-bind='value:From']\").value="+val+";");
		}

	}
