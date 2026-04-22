package Onguard_Login_Functionality;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Event_commands.events;


public class Onguard_Application_Manager_Login {
	Common c = new Common();
	//WebDriverManager mgr = new WebDriverManager();
	  ArrayList<String>arr= new ArrayList<>();
	  List<String> list = new ArrayList<>();
	final WebDriver driver;
	public  Onguard_Application_Manager_Login(WebDriver driver)
	{   
		this.driver = driver;
	}
	 
	
	 public void Enter_User_Name(String uname) throws IOException, InterruptedException {
		events eve = new events(driver);
		eve.SendKey_event("User_name", uname);
	     System.out.println(uname+ "  is Entered in the User name field");
	     Reporter.log(uname+ "  is Entered in the User name field");
	    }
	
	 public void Enter_Password(String pwd) throws InterruptedException {
		events eve = new events(driver);
		eve.Clear_InputField("Password");
		eve.SendKey_event("Password", pwd);
	    Reporter.log(pwd+ "  is Entered in the Password field");
	    System.out.println(pwd + " is Entered in the Password field");   
	   }
	 public void Old_password(String uname) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event("old_password", uname);
		     System.out.println(uname+ "  is Entered in the Old Password Input field");
		     Reporter.log(uname+ "  is Entered in the Old Password Input field");
		    }
	 public void New_password(String uname) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event("New_password", uname);
		     System.out.println(uname+ "  is Entered in the New Password Input field");
		     Reporter.log(uname+ "  is Entered in the New Password Input field");
		    }
	 public void Confirm_password(String uname) throws IOException, InterruptedException {
			events eve = new events(driver);
			eve.SendKey_event("Confirm_Password", uname);
		     System.out.println(uname+ "  is Entered in the Confirm Password Input field");
		     Reporter.log(uname+ "  is Entered in the Confirm Password Input field");
		    }
	 public void Choose_Language(String lang) throws InterruptedException {
	   driver.findElement(By.xpath(c.getElementName("language"))).click(); 
	   Thread.sleep(1000);
	   List<WebElement> options = driver.findElements(By.xpath(c.getElementName("language_DDList")));
	   for(WebElement option : options) {     	 
		  // System.out.println(option.getText());
		    if(option.getText().equals(lang)){
		    	option.click();
		    	Thread.sleep(1000);
		    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			     break;
			       }
		    }
	   System.out.println(lang+" is enterd in the language field");
	   Reporter.log(lang + ":  is enterd in the language field");
	   }
	
	 public void ClickOn_next_Button() throws InterruptedException {
		events eve = new events(driver);
		eve.Click_event("Next_Button");
	    System.out.println("Next Button is clicked"); 
	    Reporter.log("Next Button is clicked");
	   }
	
	 
	public Onguard_Application_Manager_Login_UserGroup FormSubmission(String locale) throws Exception {	

		 ReadXclData rddata=new ReadXclData();
		 String xlfile = null;
		 switch(locale){
		 case ("EN") :xlfile  = "Login_TestData_EN";
		 break;
		 case ("NL") :xlfile  = "Login_TestData_Dutch";
		 break;
		 case ("FR") :xlfile  = "Login_TestData_French";
		 break;
		 case ("DE") :xlfile  = "Login_TestData_German";
		 break;
		 case ("ES") :xlfile  = "Login_TestData_Spanish";
		 break;
		 case ("PT") :xlfile  = "Login_TestData_Portuguese";
		 break;
		 case ("IT") :xlfile  = "Login_TestData_Italian";
		 break;
		 case ("PO") :xlfile  = "Login_TestData_Polish";
		 break;
		 case ("RUS") :xlfile  = "Login_TestData_Russian";
		 break;
		 case ("TUR") :xlfile  = "Login_TestData_Turkish";
		 break;
		 }
		 String[][] t = rddata.readdata(xlfile);
		 
			for(String[] rt : t){
				 for(String val : rt){
				    arr.add(val);
				    }
				 }
			int row = arr.size()/3;
			for(int i=0;i<=row-1;i++){
				List<String> temp = new ArrayList<>();
				for(int s=0;s<=2;s++){
					temp.add(arr.get((i*3)+s));
					//System.out.println(arr.get((i*3)+s));
				}
				for(int j=0 ; j<temp.size() ; j++){
					try {
						switch(j){
							case 0:
								Enter_User_Name(temp.get(j));
								 break;
							case 1:
								Choose_Language(temp.get(j));
								break;	
							case 2:
								Enter_Password(temp.get(j));
								Thread.sleep(500);
								break;
													
						}
						 
					} catch (Exception e) {
						// TODO: handle exception
						new ArrayIndexOutOfBoundsException();
						System.out.println("error found");
						Reporter.log("error found");
					}
				}
				Thread.sleep(500);
				ClickOn_next_Button();
				Thread.sleep(500);
				isNotificationPresent();
			}		                
				
		 return PageFactory.initElements(driver, Onguard_Application_Manager_Login_UserGroup.class);
	}
	 boolean isNotificationPresent() {
		 try 
		    { 
			String notification= driver.findElement(By.xpath("//*[@id='messageToDisplay_popover']")).getText();
			System.out.println("Notifications : " + notification);
			Reporter.log("Notification ---------------------------------");
			Reporter.log(notification);
			
		       driver.findElement(By.xpath("//*[@id='popup']/div[2]/div/a[1]")).click();
		       Reporter.log("----------------------------------------------");
		        return true; 
		    }   // try 
		    catch (Exception e) 
		    { 
		        return false; 
		    }  
	 }	 
}