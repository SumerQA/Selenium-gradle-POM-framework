package Onguard_Login_Functionality;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import Configration_Files.Common;

public class Onguard_Application_Manager_Login_UserGroup {
	Common c = new Common();
	final WebDriver driver;
	public  Onguard_Application_Manager_Login_UserGroup(WebDriver driver)
	{   
		this.driver = driver;
	}
	
	
	 public void Select_UserGroup_from_DDList(int ug) {
	     Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("User_group"))));   
	     droplist.selectByIndex(ug);
	   }
	
	 public void Select_Administration_from_DDList(String text) {//Demo International
	     Select droplist = new Select(driver.findElement(By.xpath(c.getElementName("administration"))));   
	     droplist.selectByVisibleText(text);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     Reporter.log("Administration-  Demo International is selected");   
	   }
	 public void Previous_button() {
			driver.findElement(By.xpath(c.getElementName("UserGroup_Previous_Button"))).click();
			Reporter.log("Previous Button is clicked"); 
		   }
	 public void Click_on_Next_button() {
		driver.findElement(By.xpath(c.getElementName("UserGroup_Next_Button"))).click();
		   Reporter.log("Next Button is clicked"); 
	   }
	
	   }
