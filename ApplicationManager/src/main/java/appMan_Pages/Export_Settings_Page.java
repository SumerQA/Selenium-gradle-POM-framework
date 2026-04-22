package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Configration_Files.Common;
import Event_commands.events;

public class Export_Settings_Page {
	Common c = new Common();	 
	final WebDriver driver;
	public  Export_Settings_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	 public void Goto_Export_Settings_page() throws IOException, InterruptedException {	
			Home_index_Page HI_page = new Home_index_Page(driver);
			
			/*
			 * HI_page.Select_Functional_Configration_Tab(); Thread.sleep(1500);
			 */
			
			Functional_Configration_Page FC_page = new Functional_Configration_Page(driver);
			FC_page.Click_Export_Settings_tab();
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
	 //Create Export
	 public void Export_Name(String path , String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
			
		    }
	 public void Description(String path , String text) throws IOException {                           
			events eve = new events(driver);
			eve.SendKey_event(path, text);
		    }
		    
	 public void Export_type(String path, String action) throws IOException {
		 events eve = new events(driver);
		 	eve.Dropdow_by_attribute(path, action);
		
	        }
	 public void Export_Format(String path, String action) throws IOException, InterruptedException {
		 	events eve = new events(driver);
		 	eve.Dropdow_by_attribute(path, action);
		     			
	        }
	 public void Document_type(String path, String text) throws IOException {
		     events eve = new events(driver);
			 eve.Dropdow_by_attribute(path, text); 
	        }
	 public void Unique_Identifier(String path, String text) throws IOException {
		     events eve = new events(driver);
			 eve.Dropdow_by_attribute(path, text); 
	        }
	 public void Date(String path, String text) throws IOException {
		     events eve = new events(driver);
			 eve.Dropdow_by_attribute(path, text); 
	        }
	 public void Save_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_IM_changes");
			
		    }
	 public void Refresh_Changes() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("refresh");
			
		    }
	 
	 public void Notification() throws IOException, InterruptedException {
			events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			}else{
				System.out.println("No notification Found");
			}
			}
	
	 public void NO_Notification_button() throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Click_event("Save_changes_notification_NO_button");
		    }
	 
	
	 public void TextBetween(String id,String text,String txtbtn,String clschar) throws IOException, InterruptedException {
			events eve = new events(driver);
			Object bool = ((JavascriptExecutor) driver)
					.executeScript("var chkBox = document.getElementById(" + "'"
							+ id + "'" + ");" + "  if (chkBox.checked) {"
							+ "  return true  ;" + "  }" + " else{"
							+ " return false;" + "}");
			boolean checkboxStatus = (Boolean) bool;
			if (text.equals("Yes")) {

				if (checkboxStatus) {
					System.out.println("Checkbox is already Checked");
					Reporter.log("Checkbox is already Checked");
					switch(txtbtn){
					case("Text only"):eve.Click_event("ES_TextOnly");
					break;
					case("All fields"):eve.Click_event("ES_AllFields");
					break;
					}
					eve.SendKey_event("ES_closingCharacter", clschar);
				} else {
					((JavascriptExecutor) driver).executeScript("document.getElementById(" + "'" + id+ "'" + ").click();");
					Reporter.log("Checkbox is Checked Now");
					switch(txtbtn){
					case("Text only"):eve.Click_event("ES_TextOnly");
					break;
					case("All fields"):eve.Click_event("ES_AllFields");
					break;
					}
					eve.SendKey_event("ES_closingCharacter", clschar);
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
	 
	 public void TextFilesettings(String format,String SepText) throws IOException, InterruptedException {
			events eve = new events(driver);
			switch(format){
			case("1"):
				eve.Click_event("ES_TabDelimited");//Tab delimited text file
			break;
			case("2"):
				eve.Click_event("ES_FixedLength");//Fixed length settings
			break;
			case("3"):
				eve.Click_event("ES_Separator");//Seperator
			    eve.SendKey_event("ES_SepCchar", SepText);
			break;
			}
			
		    }
	 public void XML_mainHeader(String XMLtext) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event("ES_xmlMainHeader", XMLtext);
			
		    }
	 public void Debtor_XML_Tag(String DXTLtext) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event("ES_dxt", DXTLtext);
			
		    }
	 public void Inv_XML_Tag(String IXTLtext) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event("ES_INVXMLTag", IXTLtext);
			
		    }
	 public void Include_Column_Header_Checkbox(String text) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.Check_box_JS("columnHeaders", text);
			
		    } 
    public void Repeat_debtor_information_on_every_line(String text) throws IOException, InterruptedException {
		    events eve = new events(driver);
		    eve.Check_box_JS("reproduceDebtorInformartion", text); //Repeat debtor information on every line
				
			}
    public void Define_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_DEF_icon");
			
		}
    public void Create_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_Add_X_field");
			
		}
    public void Update_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_Update_X_field");
			
		}
    public void Reload_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_Reload_X_field");
			
		}
    public void Save_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_Save_X_field");
			
		}
    public void Save_and_close_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_SaveClose_X_field");
	    Thread.sleep(1000);
	    if(driver.findElement(By.xpath(c.getElementName("ES_Close_X_field"))).isDisplayed()) {
	    	eve.Click_event("ES_Close_X_field");
	    	Thread.sleep(1000);
	    }
			
		}
    public void Close_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_Close_X_field");
			
		}
    public void Delete_Export_Fields_Icon() throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Click_event("ES_delete_X_icon");
			
		}
    public void Field_type(String ft) throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Dropdow_by_attribute("ES_FT", ft);
			
		}
    public void Insert_All_Export_Fields(String ft) throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Dropdow_by_attribute("ES_FT", ft);
	    Thread.sleep(1000);
	    int count=0;
		Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("ES_Select_Field"))));
		List<WebElement> op = droplist.getOptions();
		for (int i=0;i<op.size();i++) {
			 {
				int opt=i+1;
				if(count>0){
					 eve.Dropdow_by_attribute("ES_FT", ft);
					 driver.findElement(By.xpath("//*[@id='exportFieldSelect']/option["+opt+"]")).click();
					 Thread.sleep(500);
					 Create_Export_Fields_Icon();
				}else{
					driver.findElement(By.xpath("//*[@id='exportFieldSelect']/option["+opt+"]")).click();
					Thread.sleep(500);
					Create_Export_Fields_Icon();
				}
				count++;	
				}

			}
		}
			
		
    public void Select_Field(String sf) throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.Dropdow_by_attribute("ES_Select_Field", sf);
			
		}
    public void Export_Field(String text) throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.SendKey_event("ES_X_field", text);
			
		}
    public void Fixed_Length(String text) throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.SendKey_event("ES_F_length", text);
			
		}
    public void Standard_value(String text) throws IOException, InterruptedException {
	    events eve = new events(driver);
	    eve.SendKey_event("ES_S_value", text);
			
		}
	}
