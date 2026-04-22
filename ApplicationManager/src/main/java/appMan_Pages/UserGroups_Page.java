package appMan_Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Event_commands.events;

public class UserGroups_Page {
	Common c = new Common();
	final WebDriver driver;
	public  UserGroups_Page(WebDriver driver)
	{   
		this.driver = driver;
	}
	@Test
	 public void Clickon_UserGroups_Tab() throws IOException, InterruptedException {      
		events eve = new events(driver);
		//Commented section
		/*Home_index_Page OG_NU= PageFactory.initElements(driver, Home_index_Page.class);//Will Click on Uses tab under User manager
		OG_NU.Select_Manager_Users_Tab();
		Thread.sleep(1500);*/
		
	  	eve.Click_event("usergroups");
		Thread.sleep(2000);
	  	if(driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).isDisplayed()){
	  		
	  		driver.findElement(By.xpath(c.getElementName("TC_Notification_No_button"))).click();
	  		Thread.sleep(1500);
	  	 }
	    }
	@Test
	 public void Create_New_UserGroups_panal() throws IOException, InterruptedException {	                   //Click and Open the Create New User Panal 
		events eve = new events(driver);
	  	eve.Click_event("Create_New_usergroups");
	    }
}
	
	
	
	
	
	
	
	
	
	
	