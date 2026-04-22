package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class User_Defind_Fields_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  User_Defind_Fields_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_User_Defind_Fields_page() throws IOException, InterruptedException {	
		Home_index_Page HI_page = new Home_index_Page(driver);
		/*HI_page.Select_Functional_Configration_Tab();
		Thread.sleep(2000);*/
		Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
		//FC_page.Click_on_tables_tab();
    	Thread.sleep(1500);
		FC_page.Click_on_User_defined_fields_tab();
		Thread.sleep(1500);
		HI_page.Render_Notifications();
	    }
	 public void Creat_New_icon() throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Create_NewUser_panal");
		Thread.sleep(500);
	    }
	 public void Update_icon() throws IOException, InterruptedException {	
		events eve = new events(driver);
		eve.Click_event("Change_Existing_User");
	    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve = new events(driver);
			eve.Click_event("delete_user");
		    }
	 
	 public void field_name(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+" : is Entered in the field name input field");
		    }
		    
	 public void User_Fields_type(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Dropdow_by_attribute(path, text);
			/*Select droplist = new Select(driver.findElement(By.xpath(c.getElementName(path))));
			switch(text){
	    case("1"):
	    	droplist.selectByIndex(0);
		    break;     
		case("2"):
			droplist.selectByIndex(1);
		    break;
		case("3"):
			droplist.selectByIndex(2);
			break;
	 }
			eve.DropDown_list_event(path, text);*/
		    }
	 public void Field_number(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+" : is entered in the Filed number input field.");
		    }
	 public void Fields_type(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Dropdow_by_attribute(path, text);
	 }
	 public void Fields_length(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			Reporter.log(text+" : is entered in the Fileds length input field.");
	 }
	 public void Hide_decimal_checkbox(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
	 }
	 public void Pick_list_DDList(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
	 }
	 public void Currency_code_field_number(String path, String text) throws IOException {                           
			events eve = new events(driver);
			eve.DropDown_list_event(path, text);
	 }
	 public void Activated(String id, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
	 }
	 public void Imported(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
	 }
	 public void Canbe_changedBy_User(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
	 }
	 public void Listed(String id, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
			}
	 public void Save_history(String id, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
			}
	 public void Partial_Payment_Information (String id, String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
	 }
	 public void Available_for_batch(String id,String text) throws IOException {                           
			events eve = new events(driver);
			eve.Check_box_JS(id, text);
	 }
	 public void pick_list_tab(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
	 }
	 public void UserFields_Tab() throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event("Overview_tab");
	 }
	 public void Create_pick_list_icon() throws IOException {                           
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("plCreate");
	 }
	 public void Update_pick_list_icon() throws IOException {                           
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("plUpdate");
	 }
	 public void Delete_pick_list_icon() throws IOException {                           
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("plDelete");
	 }

	 public void picklist_name_input(String path,String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
	 }
	 public void Change_pick_list_icon(String path) throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_event(path);
	 }
	 public void Create_Display_Name_icon() throws IOException {                           
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("plvCreate");
	 }
	 public void Update_Display_Name_icon() throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("plvUpdate");
	 }
	 public void Update_Picklistfrom_table(String compTest, String ePath, String val ) throws IOException, InterruptedException {                           
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			labrow :
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					if(columns.get(colnum).getText().equals(compTest)){
						int rowno= rownum+1;
						int colNo =colnum+1;
						System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).click();
						Update_pick_list_icon();
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]/input")).clear();
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]/input")).sendKeys(val);
						Reporter.log(val+" : is Entered in picklist value field");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						break labrow;
						}
					} 
				}
	 }
	 public void Update_Picklist_value_from_table(String compTest, String ePath, String val ) throws IOException, InterruptedException {                           
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("tr"));
			labrow :
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("td"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					if(columns.get(colnum).getText().equals(compTest)){
						int rowno= rownum+1;
						int colNo =colnum+1;
						System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected");
						Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).getText()+" is selected from table");
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).click();
						Update_Display_Name_icon();
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]/input")).clear();
						driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]/input")).sendKeys(val);
						Reporter.log(val+" : is Entered in picklist value field");
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
						break labrow;
						}
					} 
				}
	 }
	 
	 
	 public void Delete_Display_Name_icon() throws IOException, InterruptedException {                           
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("plvDelete");
	 }
	 
	 public void Display_name_input(String path,String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
	 }
	 public void Refresh() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("reloadPL");
		    }
	 public void Refresh_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
		    }
	 public void Save() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("savePL");
		    }
	 public void Save1() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("udf_save");
		    }
	 public void Save_As_New() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("udf_save_asNew");
		    }
	 
	 public void Cancel() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("udf_cancel");
		    }
	 public void link() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Link")));
			eve.Click_event_javaScript(ele);
		    }
	 public void Unlink() throws IOException {
			events eve = new events(driver);
			WebElement ele = driver.findElement(By.xpath(c.getElementName("Unlink")));
			eve.Click_event_javaScript(ele);
		    }
	 public void Save_changes() throws IOException, InterruptedException {	
			 events ev = new events(driver);
			 ev.Click_event("Save_IM_changes");
			    }
	 public void Save_and_Close() throws IOException {
			events eve = new events(driver);
			eve.Click_eventBy_ClassName("saveClose");
		    }
	 public void Notifications() throws IOException, InterruptedException {
		  events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Thread.sleep(2000);
			
			}else{
				System.out.println("No notification Found");
			}
		    }
	 public void Find_UDF_in_table(String path , String compText) throws IOException, InterruptedException { 
			    WebElement element= driver.findElement(By.xpath(c.getElementName(path)));
				List<WebElement> rows=element.findElements(By.tagName("ul"));
				labrow :
				for(int rownum = 0; rownum <rows.size(); rownum++) {
					List<WebElement> columns=rows.get(rownum).findElements(By.tagName("li"));
					//System.out.println("Number of columns:"+columns.size());
					for(int colnum=0; colnum<columns.size();colnum++){
						System.out.println(columns.get(colnum).getText());
						if(columns.get(colnum).getText().equals(compText)){
							int colNo =colnum+1;
							System.out.println(driver.findElement(By.xpath(c.getElementName(path)+"/ul/li["+colNo+"]/div/span[2]")).getText()+" is selected");
							Reporter.log(driver.findElement(By.xpath(c.getElementName(path)+"/ul/li["+colNo+"]/div/span[2]")).getText()+" is selected");
							driver.findElement(By.xpath(c.getElementName(path)+"/ul/li["+colNo+"]/div/span[1]/input")).click();
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
							break labrow;
							}
						} 
					}
		 }
	 public void Select_UDF_in_table(String path , String Alpha,String num,String logi,String date,String picklist,String curr,String curr_code) throws IOException, InterruptedException { 
		    WebElement element= driver.findElement(By.xpath(c.getElementName(path)));
			List<WebElement> rows=element.findElements(By.tagName("ul"));
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				List<WebElement> columns=rows.get(rownum).findElements(By.tagName("li"));
				//System.out.println("Number of columns:"+columns.size());
				for(int colnum=0; colnum<columns.size();colnum++){
					System.out.println(columns.get(colnum).getText());
					if(columns.get(colnum).getText().equalsIgnoreCase(Alpha) || columns.get(colnum).getText().equalsIgnoreCase(num) || columns.get(colnum).getText().equalsIgnoreCase(logi) || columns.get(colnum).getText().equalsIgnoreCase(date) || columns.get(colnum).getText().equalsIgnoreCase(picklist) || columns.get(colnum).getText().equalsIgnoreCase(curr) || columns.get(colnum).getText().equalsIgnoreCase(curr_code)){
						int colNo =colnum+1;
						try {
							driver.findElement(By.xpath(c.getElementName(path)+"/ul/li["+colNo+"]/div/span[1]/input")).click();
						} catch (Exception e) {
							// TODO: handle exception
						}
						
						}
					} 
				}
	      }
	}
