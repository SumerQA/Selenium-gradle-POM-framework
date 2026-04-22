package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;
public class API_Call_templetes_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  API_Call_templetes_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	 public void Goto_Api_Call_templetes_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			Technical_Configration_page TC_page = new Technical_Configration_page(driver);
			/*HI_page.Select_Technical_Configration_Tab();
			Thread.sleep(2000);
			System.out.println("Technical Configration tab is clicked");
			TC_page.API_Tab();*/
			TC_page.API_Call_Templetes();
			Thread.sleep(1500);
			HI_page.Render_Notifications();
		    System.out.println("API Call Templetes page is opened");
		    }
	 public void Create_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_Create_icon");
			System.out.println("Create Icon is Clicked");
			Thread.sleep(2000);
		    }
	 public void Update_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_Update_icon");
			System.out.println("Update Icon is Clicked");
			Thread.sleep(1500);
		    }
	 public void Delete_icon() throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.Click_event("api_Delete_Icon");
			System.out.println("Delete Icon is Clicked");
			Thread.sleep(1000);
		    }
	 public void Action_name(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_ct_act_nm", text);       //API Client name 
			Reporter.log(text+" : is Entered in the Action name Input Field.");
			Thread.sleep(500);
		    }
	 public void Description(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_r_desc", text);
			Reporter.log(text +": is Entered in the Description Input field.");
			Thread.sleep(500);
			}
	 public void API_Resource(String text) throws IOException, InterruptedException {	
		 events eve=new events(driver);
		 eve.DropDown_list("api_ct_apiRources", text);
		     }
	 public void Operation_trigger(String text) throws IOException, InterruptedException {	
			/*events eve=new events(driver);
			eve.DropDown_list_eventBy_index("api_ct_operatn",text);
			Thread.sleep(500);Operation*/
		 Select droplist = new Select(driver.findElement(By.id("Operation")));
			List<WebElement> op = droplist.getOptions();
			for (WebElement el : op) {
				try {
					if (el.getAttribute("value").equals(text)) {
						el.click();
						Reporter.log(text + " : is selected from DDlist");
						break;
					}

				} catch (Exception e) {
					System.out.println(text + "Not Found in DDlist");
					// TODO: handle exception
				}
			}
		    }
	 public void Path(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_r_path", text);       //Refresh Period
			Reporter.log(text+" : is Entered in Path Input Field.");
			Thread.sleep(500);
		    }
	public void Header_parameters(String text) throws IOException, InterruptedException {	
			events eve=new events(driver);
			eve.SendKey_event("api_header_params", text);
			System.out.println(text+" is entered in the Header input field");
			Reporter.log(text+" is entered in the Header input field");
			Thread.sleep(1000);
	       }
	public void Query_parameters(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_query_params", text);
		System.out.println(text+" is entered in the Query input field");
		Reporter.log(text+" is entered in the Query input field");
		Thread.sleep(1000);
       }
	public void Body_parameters(String text) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_body_params", text);
		System.out.println(text+" is entered in the Body input field");
		Reporter.log(text+" is entered in the Body field");
		Thread.sleep(1000);
       }
	public String Trigger(String action) throws IOException, InterruptedException {	
		String CF_value=null;
		Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("api_ct_trigger"))));
		List<WebElement> op = droplist.getOptions();
		for (WebElement el : op) {
			try {
				if (el.getAttribute("value").equals(action)) {
					CF_value=el.getText();
					el.click();
					Reporter.log(action + " : is selected from DDlist");
					break;
				}

			} catch (Exception e) {
				System.out.println(action + "Not Found in DDlist");
				// TODO: handle exception
			}
		}
		return CF_value;
       }
	public void Add_Call_Templete_Criteria_ICon() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_ct_add_criteria");
		Thread.sleep(1000);
       }
	public String Criteria_Field(String Criteriafield,String action) throws IOException, InterruptedException {	
		String CF_value=null;
		int count=0;
		Select droplist = new Select(driver.findElement(By.xpath(c.getElementName(Criteriafield))));
		List<WebElement> op = droplist.getOptions();
		for (WebElement el : op) {
			count++;
			try {
				if (el.getAttribute("id").equals(action)) {
					driver.findElement(By.xpath("//div[starts-with(@id,'popover')]/div[2]/form/div/div[1]/div/div/select[contains(@id,'apiCallTempField')]/option["+count+"]")).click();
					CF_value=el.getAttribute("fieldtype");
					Reporter.log(el.getText() + " : is selected from DDlist");
					break;
				}

			} catch (Exception e) {
				System.out.println(action + " :Not Found in DDlist");
				// TODO: handle exception
			}
		}
		Thread.sleep(1000);
		return CF_value;
       }
	public void Criteria_Operator(String Criteriafield,String Coperator) throws IOException, InterruptedException {	
		int count=0;
		Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("api_ct_coperatr"))));
		List<WebElement> op = droplist.getOptions();
		for (WebElement el : op) {
			count++;
			try {
				if (el.getAttribute("id").equals(Coperator)) {
					driver.findElement(By.xpath("//div[starts-with(@id,'popover')]/div[2]/form/div/div[2]/div/div/div/div[1]/select[contains(@id,'callTemplateOperators')]/option["+count+"]")).click();
					Reporter.log(el.getText() + " : is selected from DDlist");
					break;
				}
			} catch (Exception e) {
				System.out.println(Coperator + "Not Found in DDlist");
				// TODO: handle exception
			}
		}
       }
	public void Criteria_Value(String value) throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.SendKey_event("api_ct_cvlue", value);//value
		Thread.sleep(1000);
       }
	public void Add_Criteria() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_ct_addCritoList");
		Thread.sleep(1000);
       }
	public void Delete_Criteria() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_ct_DeleteCritoList");
		Thread.sleep(1000);
       }
	public void Save_Criteria() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_save_criteria");
		Thread.sleep(1000);
       }
	public void Save_and_Close_Criteria() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_save_n_Close_criteria");
		Thread.sleep(1000);
       }
	public void Refresh_Criteria() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_refresh_criteria");
		Thread.sleep(1000);
       }
	public void Cancel_Criteria() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_cancel_criteria");
		Thread.sleep(1000);
       }
	public void Delete_Criteria_Main() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_delete_criteria_main");
		Thread.sleep(1000);
       }
	public void Refresh_Icon() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("api_refresh_icon");
		System.out.println("Refresh Icon is clicked");
		Reporter.log("Refresh Icon is clicked");
		Thread.sleep(1000);
       }
	public void Save_Call_templetes() throws IOException, InterruptedException {	
		events eve=new events(driver);
		eve.Click_event("Save_Panal_Changes");
		System.out.println("Save Icon is clicked");
		Reporter.log("Save Icon is clicked");
		Thread.sleep(1000);
       }
	public void List_of_API_Call_Templetes_table(String ePath, String name, String ipaddr) throws IOException, InterruptedException {	
		WebElement element = driver.findElement(By.xpath(c.getElementName(ePath)));
		List<WebElement> rows = element.findElements(By.tagName("tr"));
		labrow: 
			for (int rownum = 0; rownum < rows.size(); rownum++) {
			List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
			// System.out.println("Number of columns:"+columns.size());
			for (int colnum = 0; colnum < columns.size(); colnum++) {
				int rowno = rownum + 1;
				int colNo = colnum + 1;
				System.out.println(columns.get(colnum).getText());
				if (driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[1]")).getText().equals(name) && driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[2]")).getText().equals(ipaddr)) {
					
					System.out.println(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[" + colNo + "]")).getText()+ " is selected");
					Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[" + colNo + "]")).getText()+ " is selected from table");
					driver.findElement(By.xpath(c.getElementName(ePath) + "/tr[" + rowno+ "]/td[" + colNo + "]")).click();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
					break labrow;
				}
				
			}
		 }
		
       }
	
	
	
	 public void Notification() throws IOException, InterruptedException {	
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: ---------------------------");
				String nt=eve.GetText("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				System.out.println("Notification Message: "+nt);
				Reporter.log("Notification Message: "+nt);
				Thread.sleep(1500);
			}else{
				System.out.println("No notification Found");
				Thread.sleep(1500);
			}
	       }
	 public void No_Notification() throws IOException, InterruptedException {	
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notifications: ---------------------------");
				String nt=eve.GetText("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_NO_button");
				System.out.println("Notification Message: "+nt);
				Reporter.log("Notification Message: "+nt);
				Thread.sleep(1500);
			}else{
				System.out.println("No notification Found");
				Thread.sleep(1500);
			}
	       }
	 public void Criteria_List_Display_Table(String compTest, String ePath) throws IOException { // Will get the table cells data and click on perticular cell
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
								System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]/span[1]")).getText()+" is selected");
								Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]/span[1]")).getText()+" is selected from table");
								driver.findElement(By.xpath(c.getElementName(ePath)+"/tr["+rowno+"]/td["+colNo+"]")).click();
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
								break labrow;
								}
					
					} 
				}
			//System.out.println("Usergroup is selected for linking with New User");
			}
	 
	 
	 public void API_Call_templete_trigger_Criteria_Table(String compTest, String ePath) throws IOException { // Will get the table cells data and click on perticular cell
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
			}
	 public void Insert_Criteria_to_Call_templete(String cFieldID,String oper) throws IOException, InterruptedException {	
		  String criter = Criteria_Field("api_ct_Cfield", cFieldID);
		  Criteria_Operator("api_ct_coperatr", oper);
			switch(criter){
			case ("0"):Criteria_Value("a");
			break;
			case ("1"):Criteria_Value("1");
			break;
			case ("3"):Criteria_Value("as12");
			break;
			}
	//	Add_Criteria();
		Thread.sleep(500);
	       }
	 public void Save_Criteria_to_Call_templete(String cFieldID,String oper) throws IOException, InterruptedException {	
		 Insert_Criteria_to_Call_templete(cFieldID, oper);
	     Add_Criteria();
		 Thread.sleep(500);
	       }
}
		
