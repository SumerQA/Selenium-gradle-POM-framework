package Login_Functionality;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Configration_Files.Common;
import Configration_Files.ReadXclData;
import Configration_Files.ScreenShotOnFailure;
import Configration_Files.WebDriverManager;
@Listeners(ScreenShotOnFailure.class)
public class Login extends TestListenerAdapter {	
	ReadXclData RD= new ReadXclData();
	WebDriver driver=null;
	WebDriverManager man = new WebDriverManager();
	Test_Application_Manager_Login OG_Login1= null;
	Test_Application_Manager_Login_UserGroup OG_Login2= null;
	Common c = new Common();
	@Test
	@Parameters({"Locale", "ActiveUser", "ValidPassword", "NewPassword", "UserGroup"})
	public void Login_User(String Locale,String ActiveUser, String ValidPassword, String NewPassword, String UserGroup) throws Exception{
		driver=WebDriverManager.getDriverInstance();
		OG_Login1= PageFactory.initElements(driver, Test_Application_Manager_Login.class);
		OG_Login2= PageFactory.initElements(driver, Test_Application_Manager_Login_UserGroup.class);
		Login_FirstScreen(Locale, ActiveUser, ValidPassword);
	    if(Login_Password_Expire(Locale, ValidPassword, NewPassword, NewPassword))
	    {
	    	Login_FirstScreen(Locale, ActiveUser, NewPassword);
	    	Login_SecondScreen(UserGroup);
	    }
	    else{
	    	Login_SecondScreen(UserGroup);
	    }
	    
	}
	public boolean Login_Password_Expire(String Locale,String p1,String p2,String p3) throws Exception{
		if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).getText().equals("Your password has expired. Click OK to update your password")){
			driver.findElement(By.xpath(c.getElementName("Password_expire_OK"))).click();
			Thread.sleep(2000);
			Change_password(p1,p2,p3);
			return true;
		}
		return false;
		
	}
	public void ChooseLocale(String Locale) throws Exception{
		switch(Locale){
		 case("EN") :  OG_Login1.Choose_Language("English");
		 break;
		 case("NL") :  OG_Login1.Choose_Language("Dutch");
		 break;
		 case("FR") :  OG_Login1.Choose_Language("French");
		 break;
		 case("DE") :  OG_Login1.Choose_Language("German");
		 break;
		 case("ES") :  OG_Login1.Choose_Language("Spanish");
		 break;
		 case("PT") :  OG_Login1.Choose_Language("Portuguese");
		 break;
		 case("IT") :  OG_Login1.Choose_Language("Italian");
		 break;
		 case("PO") :  OG_Login1.Choose_Language("Polish");
		 break;
		 case("RUS") :  OG_Login1.Choose_Language("Russian");
		 break;
		 case("TUR") :  OG_Login1.Choose_Language("Turkish");
		 break;
		 }
	}
	public void Change_password(String oldPWD, String nPWD, String CnfPWD) throws Exception{
		driver.findElement(By.xpath(c.getElementName("old_password"))).sendKeys(oldPWD);
		driver.findElement(By.xpath(c.getElementName("New_password"))).sendKeys(nPWD);
		driver.findElement(By.xpath(c.getElementName("Confirm_Password"))).sendKeys(CnfPWD);
		Thread.sleep(1000);
		driver.findElement(By.xpath(c.getElementName("Next_Button"))).click();
		Thread.sleep(1500);
		if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
			Reporter.log(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).getText()+" from "+oldPWD +" to "+nPWD);
			System.out.println(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).getText()+" from "+oldPWD +" to "+nPWD);
			driver.findElement(By.xpath(c.getElementName("Password_expire_OK"))).click();
		}
	}
	public void Login_FirstScreen(String Locale, String username, String pwd) throws Exception{
		OG_Login1.Enter_User_Name(username);//edwin
		Thread.sleep(800);
		OG_Login1.Enter_Password(pwd);
		ChooseLocale(Locale);
		OG_Login1.ClickOn_next_Button();
	}
	public void Login_SecondScreen(String admin) throws Exception{	
	 Thread.sleep(3000);
	 if(driver.findElement(By.xpath(c.getElementName("Save_changes_notification_Message"))).isDisplayed()){
		 driver.findElement(By.xpath(c.getElementName("Password_expire_OK"))).click();
		 Thread.sleep(3000);
		 OG_Login2.Select_Administration_from_DDList(admin);
		 Thread.sleep(1500);
		 OG_Login2.Click_on_Next_button();
	 }else{
		 OG_Login2.Select_Administration_from_DDList(admin);
		 Thread.sleep(1500);
		 OG_Login2.Click_on_Next_button();
	 }
  }
}
