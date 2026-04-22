package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;


public class batch_Scheduler_page {
	Common c = new Common();	 
	final WebDriver driver;
	public  batch_Scheduler_page(WebDriver driver)
	{   
		this.driver = driver;
	}
  public void open_batch_Scheduler_page() throws InterruptedException, IOException {
	 Home_index_Page HI_page = new Home_index_Page(driver);
	 events eve= new events(driver);
	 eve.Click_event("batch_b_scheduler");
	 Thread.sleep(1000);
	 HI_page.Render_Notifications();
	 
  }
  public void Task_Type_Button() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_TaskType");
		 
	  }
  public void Create_Button() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_Create");
		 
	  }
  public void Change_Button() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_change");
		 
	  }
  public void Delete_Button() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_Delete");
		 
	  }
  public void Scheduke_Name(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_schedule_name", text);
		 
	  }
  public void TaskType(String action) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_TaskType", action);
		 
	  }
  public void Batch_rule_used(String action) throws InterruptedException {
		 events eve= new events(driver);
		 eve.DropDown_list("BS_batchrule_used", action);
		 //eve.Dropdow_by_attribute("BS_batchrule_used", action);
		 
	  }
  public void Immidiate_schedule_pattern() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_immidiate_rButton");
		 
	  }
  public void Daily_schedule_pattern() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_daily_rButton");
		 
	  }
  public void Weekly_schedule_pattern() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_weekly_rButton");
		 
	  }
  public void Every_radio_button_schedule_pattern() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_Every_rButton");
		 
	  }
  public void Every_WeeksOn_Input_schedule_pattern(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_Ever_weeksOn", text);
		 
	  }
  public void Monday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_mon", text);
		 
	  }
  public void Tuesday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_Tue", text);
		 
	  }
  public void Wednesday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_Wed", text);
		 
	  }
  public void Thursday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_thu", text);
		 
	  }
  public void Friday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_Fri", text);
		 
	  }
  public void Saturday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_Sat", text);
		 
	  }
  public void Sunday(String text) throws InterruptedException, IOException {
		 events eve= new events(driver);
		 eve.Checkbox("BS_Sun", text);
		 
	  }
  public void Every_Days_Input_schedule_pattern(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_Every_InputField", text);
		 
	  }
  public void Every_WeekDay_rButtonschedule_pattern() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_Every_weekday");
		 
	  }
  public void Start_Tyme(String Tval) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_Start_time_DDlist", Tval);
	  }
  public void Start_Tyme_DDlist(String Tval) throws InterruptedException {
	     events eve= new events(driver);
	     eve.SendKey_JS("StartTime", Tval);
  }
  
  public void Day_Task() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_Day_task");
		 
	  }
  public void workweek_Task() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_workweek_task");
		 
	  }
  public void Week_Task() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_week_task");
		 
	  }
  public void Month_Task() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_month_task");
		 
	  }
  public void  Show_full_Day() throws InterruptedException {
	  events eve = new events(driver);
	  if(driver.findElement(By.xpath(c.getElementName("BS_show_full_Day"))).isEnabled()){
		  eve.Click_event("BS_show_full_Day");
	  }
	  
	
}
  
  
  
  public void Order_By(String chbox, String att,String condition) throws InterruptedException {
	  events eve= new events(driver);
	  Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById("+"'OrdersBy'"+");"  +
              "  if (chkBox.checked) {" +
              "  return true  ;" +
              "  }" +
              " else{"+ " return false;" +"}" );
		 boolean checkboxStatus = (Boolean) bool;
		 if(chbox.equals("Yes")){
			
			 if(checkboxStatus){
				 System.out.println("Checkbox is already Checked");
				 Reporter.log("Checkbox is already Checked");
			 }else{
				 ((JavascriptExecutor) driver).executeScript("document.getElementById("+"'OrdersBy'"+").click();");
				 Reporter.log("Checkbox is Checked Now");
				 eve.Dropdow_by_attribute("BS_ordrBY_attribute_Ddlist", att);//Attribute DDlist
				 Thread.sleep(500);
				 eve.Dropdow_by_attribute("BS_OrderBy_Condition", condition);//Condition DDlist
			 }
		 }else{
			 if(checkboxStatus){
				 ((JavascriptExecutor) driver).executeScript("document.getElementById("+"'OrdersBy'"+").click();");
			 }else{
				 System.out.println("Checkbox is unchecked already");
				 Reporter.log("Checkbo ix is unchecked already");
			 }
		 }
	  }
  public void Archive(String chbox, String expDef) throws InterruptedException {
	  events eve= new events(driver);
	  Object bool = ((JavascriptExecutor) driver).executeScript("var chkBox = document.getElementById("+"'Archive'"+");"  +
              "  if (chkBox.checked) {" +
              "  return true  ;" +
              "  }" +
              " else{"+ " return false;" +"}" );
		 boolean checkboxStatus = (Boolean) bool;
		 if(chbox.equals("Yes")){
			
			 if(checkboxStatus){
				 System.out.println("Checkbox is already Checked");
				 Reporter.log("Checkbox is already Checked");
			 }else{
				 ((JavascriptExecutor) driver).executeScript("document.getElementById("+"'Archive'"+").click();");
				 Reporter.log("Checkbox is Checked Now");
				 try {
					 eve.Dropdow_by_attribute("BS_exportDef", expDef);//Export definition DDlist
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Not found in DDlist");
				}
				 
			 }
		 }else{
			 if(checkboxStatus){
				 ((JavascriptExecutor) driver).executeScript("document.getElementById("+"'Archive'"+").click();");
			 }else{
				 System.out.println("Checkbox is unchecked already");
				 Reporter.log("Checkbo ix is unchecked already");
			 }
		 }
	  }
  public void Filters_DDlist() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_filters");
		 
	  }
  public void Filters_MenuItem(String opt,String cond) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_filter_options", opt);
	  }
  public void Filters_Condition(String cond) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_filter_condition", cond);
	  }
  public void Logical_DD(String cond) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_logical_dd", cond);
	  }
  public void Filters_Input(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_filter_input", text);
		 
	  }
  public void Date_Input(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_date_input", text);
		 
	  }
  public void filter_picklist_value(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.DropDown_list("BS_fielter_picklist_value", text);
		 
	  }
  public void filter_currencyCode_DDlist(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.DropDown_list_event("BS_logical_dd", text);
		 
	  }
  public void Filters_DDlist(String action) throws InterruptedException {
		 events eve= new events(driver);
		 eve.DropDown_list("BS_filter_options", action);
		 //eve.Dropdow_by_attribute("BS_filter_DDlist", action);
		 
	  }
  public void Filters_DatePicker(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_datePicker_input", text);
		 
	  }
  public void Delete_filer() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_Delete_filter");
		 
	 }
  public void New_filer_Icon() throws InterruptedException {
		 events eve= new events(driver);
		 eve.Click_event("BS_New_filer_Icon");
		 
	  }
  public void Filters_MenuItem1(String opt,String cond) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_filter_options1", opt);
	  }
public void Filters_Condition1(String opt,String cond) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_filter_condition1", cond);
	  }
public void Filters_Input1(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_filter_input1", text);
		 
	  }
public void Filters_DDlist1(String action) throws InterruptedException {
		 events eve= new events(driver);
		 eve.Dropdow_by_attribute("BS_filter_DDlist1", action);
		 
	  }
public void Filters_DatePicker1(String text) throws InterruptedException {
		 events eve= new events(driver);
		 eve.SendKey_event("BS_datePicker_input1", text);
		 
	  }
public void Delete_filer1() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Delete_filter1");
	 
 }
public void Clear_filer() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Clear_filter_icon");
	 
}
public void Cancel_filer() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Cancel_filter_icon");
	 
}
public void Reload() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Relaod_scheduleNewTas");
	 
}
public void Save() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Save_scheduleNewTas");
	 
}
public void Save_and_Close() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Save_n_Close_scheduleNewTas");
	 
}
public void Cancel() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Cancel_scheduleNewTas");
}
public void Cancel_batch_Log() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("Bs_Cancel_batch_log");
}

public void Refresh_panal() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Refresh_Panal");
	 
}
public void Save_panal() throws InterruptedException {
	 events eve= new events(driver);
	 eve.Click_event("BS_Refresh_Panal");
	 
}
public void Notification() throws IOException, InterruptedException {
	 events eve = new events(driver);
		if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
			Reporter.log("Notification-----------------------------------------");
			eve.GetText_event("Save_changes_notification_Message");
			eve.Click_event("BS_batch_notify_Yes");
			Reporter.log("-----------------------------------------------------");
		}
}
public void Find_Schedule_Task_From_Grid(String ePath) throws InterruptedException {
WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
List<WebElement> rows=element.findElements(By.tagName("div"));
if(rows.size()>1){
try {
	for(int rownum = 0; rownum <rows.size(); rownum++) {
		int rowno= rownum+1;
				System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]")).getText());
				Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]")).getText());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				}
} catch (Exception e) {
	// TODO: handle exception
}}else {
	System.out.println("Immidiate Task Not Found in Grid");
}

		} 
public void Update_Schedule_Task_From_Grid(String ePath,String text) throws InterruptedException {
WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
List<WebElement> rows=element.findElements(By.tagName("div"));
if(rows.size()>1){
try {
	for(int rownum = 0; rownum <rows.size(); rownum++) {
		int rowno= rownum+1;
		System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]")).getText());
		if(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]")).getText().equals(text)){
		
				driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]")).click();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
				}
} catch (Exception e) {
	// TODO: handle exception
}}else {
	System.out.println("");
}

		} 
public void View__Scheduled_Task(String ePath) throws InterruptedException {
WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
element.findElements(By.tagName("div"));
System.out.println("<-------------------------------------------------------------------->");
try {
	for(int rownum = 0; rownum <5; rownum++) {
		int rowno= rownum+1;
		System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]/div[1]")).getText()+"  :" +driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]/div[2]")).getText());
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
				}
	System.out.println("<-------------------------------------------------------------------->");
} catch (Exception e) {
	// TODO: handle exception
}

		} 

public void open_batch_log(String ePath,String text) throws InterruptedException {
WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
List<WebElement> rows=element.findElements(By.tagName("div"));
if(rows.size()>1){
try {
	for(int rownum = 0; rownum <rows.size(); rownum++) {
		int rowno= rownum+1;
		if(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]")).getText().equals(text)){
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(c.getElementName(ePath)+"/div["+rowno+"]"))).doubleClick().build().perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		}
				}
} catch (Exception e) {
	// TODO: handle exception
	//throw new ElementNotFoundException(text, "", "Not found");
}}else {
	System.out.println("Scheduled Task Not Found in Grid");
}

		} 
public void serch_Task_Type(String ePath,String text) throws InterruptedException, IOException {
	events eve = new events(driver);
	eve.Click_event("BS_srearch_taskType_button");
	eve.Checkbox("BS_TaskType_SelectAll", "No");
	
	WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
	List<WebElement> rows=element.findElements(By.tagName("li"));
	try {
		for(int rownum = 0; rownum <rows.size(); rownum++) {
			int rowno= rownum+2;
			
			if(!driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label")).getText().equals(text) && driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label/input")).isSelected() ){
			        driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label")).click();
			        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			}else{
				if(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label")).getText().equals(text)){
					//eve.Checkbox(ePath+"/li["+rowno+"]/a/label/input", "Yes");
					String text1 = "Yes";
					 if(text1.equals("Yes")){
						  if(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label/input")).isSelected()){
							  System.out.println("Checkbox is already checked");
						  }else{
							  driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label/input")).click();
							  System.out.println("Checkbox is checked Now");
							  Reporter.log("Checkbox is checked Now");
						  }
					  }else{
						  if(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label/input")).isSelected()){
							  driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/a/label/input")).click();
							  System.out.println("Checkbox is Unchecked now");
							  Reporter.log("Checkbox is Unchecked now");
						  }else{
							  System.out.println("Checkbox is Unchecked already");
							  Reporter.log("Checkbox is Unchecked already");
						  }
					  }
				}
				
			}
					}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
}

