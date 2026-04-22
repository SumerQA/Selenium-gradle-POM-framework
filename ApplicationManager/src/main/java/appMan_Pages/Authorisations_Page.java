package appMan_Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Event_commands.events;

public class Authorisations_Page {
	Common c = new Common();
	final WebDriver driver;
	public  Authorisations_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	@Test
	 public void Open_Authorisations_Tab() throws IOException, InterruptedException {                                
		events eve = new events(driver);
	  	eve.Click_event("auth_panal_tab");
		Thread.sleep(1000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
	    }
	@Test
	 public void Create_New_AuthRole_panal() throws IOException, InterruptedException {	                 
		events eve = new events(driver);
	  	eve.Click_event("C_arole_icon");
	  	Thread.sleep(2000);
	    }
	
	@Test
	 public void Update_New_AuthRol_button() throws IOException, InterruptedException {	                    
		events eve = new events(driver);
	  	eve.Click_event("U_arole_icon");
	  	Thread.sleep(2500);
	    }
	
	@Test
	 public void Delete_New_AuthRol_button() throws IOException, InterruptedException {	                   
		events eve = new events(driver);
	  	eve.Click_event("D_arole_icon");
	  	Thread.sleep(1000);
	  		    }
	
	@Test
	 public void Link_button() throws IOException, InterruptedException {	                   
		events eve = new events(driver);
	  	eve.Click_event("link_arole_icon");
	  	Thread.sleep(1500);
	    }

	@Test
	 public void Unlink_button() throws IOException, InterruptedException {	                   
		events eve = new events(driver);
	  	eve.Click_event("Unlink_arole_icon");
	  	Thread.sleep(1000);
	    }
	@Test
	 public void Save_After_linking_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("Save_arole_Alinking");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Reload_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("Refresh_arole_Alinking");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Role_Name(String path,String text) throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.SendKey_event(path, text);
	  	Thread.sleep(500);
	    }
	@Test
	 public void Description(String path,String text) throws IOException, InterruptedException {	                  
		events eve = new events(driver);
		eve.SendKey_event(path, text);
		Thread.sleep(500);
	    }
	
	@Test
	 public void Copy_Of(String path,String text) throws IOException, InterruptedException {	                  
		events eve = new events(driver);
		eve.DropDown_list(path, text);
		Thread.sleep(1000);
	    }
	@Test
	 public void Application_functional_tab(String role) throws IOException, InterruptedException {	                  
		events eve = new events(driver);
		eve.Click_event("R_aFunctional_tab");
		Thread.sleep(1000);
		
	    }
	@Test
	 public void General_Tab() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("R_Gen_tab");
	  	Thread.sleep(1000);
	    }
	@Test
	 public void Role_Save_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("R_Save_icon");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Role_Save_AS_New_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("R_SAN_icon");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Role_Save_and_Close_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("R_SAC_icon");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Role_Cancel_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("R_Cancel_icon");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Role_Reload_Icon() throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Click_event("R_reload_icon");
	  	Thread.sleep(1500);
	    }
	@Test
	 public void Users_Table(String compTest,String ePath,String ePath1) throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Table_event_With_Pagination(compTest, ePath,ePath1);
	  	Thread.sleep(1000);
	    }
	@Test
	 public void Roles_Table(String compTest,String ePath) throws IOException, InterruptedException {	                  
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("li"));
			for(int rownum = 0; rownum <rows.size(); rownum++) {
				Pattern r = Pattern.compile(compTest);
				// Now create matcher object.
				Matcher m = r.matcher(rows.get(rownum).getText());
				      if(m.find()){
				    			int rowno= rownum+1;
								System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).getText()+" is selected");
								Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).getText()+" is selected");
								driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).click();
								driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
								Thread.sleep(1000);
								break;
								}
					
					} 
		}
	@Test
	 public void Chield_Role_Table(String compTest,String ePath, String chieldrolename,String exp) throws IOException, InterruptedException {	                  
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("li"));
			labrow:  for(int rownum = 0; rownum <rows.size(); rownum++) {
				Pattern r = Pattern.compile(compTest);
				// Now create matcher object.
				Matcher m = r.matcher(rows.get(rownum).getText());
				      if(m.find()){
				    			int rowno= rownum+1;
								System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).getText()+" is selected");
								Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).getText()+" is selected from table");
								driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span[2]")).click();
								Thread.sleep(500);
								driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span[1]")).click();
								Thread.sleep(700);
								WebElement element1= driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/ul"));
								List<WebElement> crows=element1.findElements(By.tagName("li"));
								for(int crownum = 0; crownum <crows.size(); crownum++) {
									Pattern r1 = Pattern.compile(chieldrolename);
									// Now create matcher object.
									Matcher m1 = r1.matcher(rows.get(rownum).getText());
									      if(m1.find()){
									    			int crowno= crownum+1;
													System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/ul/li["+crowno+"]/div/span")).getText()+" is selected");
													Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/ul/li["+crowno+"]/div/span")).getText()+" is selected from table");
													driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/ul/li["+crowno+"]/div/span")).click();
													driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
													Thread.sleep(1000);
													if(exp.equals("Yes")){
														driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span[1]")).click();
														Thread.sleep(700);
													}
													break labrow;
													}
											} 
								
								}
					
					} 
		}
	@Test
	 public void Expand_and_Collepse_Table(String compTest,String ePath) throws IOException, InterruptedException {	                  
		 WebElement element= driver.findElement(By.xpath(c.getElementName(ePath)));
			List<WebElement> rows=element.findElements(By.tagName("li"));
			labrow: for(int rownum = 0; rownum <rows.size(); rownum++) {
				Pattern r = Pattern.compile(compTest);
				// Now create matcher object.
				Matcher m = r.matcher(rows.get(rownum).getText());
				      if(m.find()){
				    			int rowno= rownum+1;
								System.out.println(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).getText()+" is selected");
								Reporter.log(driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span")).getText()+" is selected from table");
								Thread.sleep(500);
								driver.findElement(By.xpath(c.getElementName(ePath)+"/li["+rowno+"]/div/span[1]")).click();
								Thread.sleep(500);	
								break labrow;
								}
					
					} 
		}
	@Test
	 public void Users_Linked_to_Role_Table(String compTest,String ePath,String ePath1) throws IOException, InterruptedException {	                  
		events eve = new events(driver);
	  	eve.Table_event_With_Pagination(compTest, ePath,ePath1);
	  	Thread.sleep(1000);
	    }
	
	 public void Notification() throws IOException, InterruptedException {
		 events eve = new events(driver);
			if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
				Reporter.log("Notification-----------------------------------------");
				eve.GetText_event("Save_changes_notification_Message");
				eve.Click_event("Save_changes_notification_OK_button");
				Reporter.log("-----------------------------------------------------");
				Thread.sleep(1000);
			}
	 }
	}