package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.events;
import locatorPages.All_ActionsLocators;
import locatorPages.ListScreenLocators;
import locatorPages.LoginPageLocators;
import pageInterfaces.ListScreen;

public class CreateActionsPage extends ListScreen {
	final WebDriver driver;

	public CreateActionsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void selectDebtor(String debID) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			if (driver.findElement(By.xpath("//span[contains(text(),'" + debID + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + debID + "')]")).click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println(debID + " : not found.");
		}
	}

	public void click_CIS_button() {
		try {
			Thread.sleep(2000);
			Click_event(All_ActionsLocators.cisICon);
			System.out.println("Click  CIS button from menu tabs successfully");
			// Click(All_ActionsLocators.cisICon);
		} catch (Exception e) {
			System.out.println("CIS icon not working" + e.getMessage());
		}

	}

	public void click_CIS_Action_Button() throws InterruptedException {
		Thread.sleep(2000);
		Click_event(All_ActionsLocators.Debt_Actionbutton);
		System.out.println("Click  'CIS > Action' button from menu tabs successfully");
	}

	public void ClickAction_LetterAction() throws InterruptedException {
		Thread.sleep(2000);
		Click_event(All_ActionsLocators.action_CreateLetter);
		System.out.println("Click Letter button successfully");
	}

	public void ClickAction_EmailAction() throws InterruptedException {
		Thread.sleep(2000);
		Click_event(All_ActionsLocators.action_SendEmail);
		System.out.println("Email action button clic successfully");
	}

	public void Create_DocumentSettingsOfLetterForm(String letter, String language, String destination, String template) {
	try {	  // Wait for the selectDunningLetter element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));   
        wait.until(ExpectedConditions.visibilityOfElementLocated(All_ActionsLocators.DocumentLettertitlepage));

        Select dunningLetter = new Select(driver.findElement(All_ActionsLocators.selectDunningLetter));
        dunningLetter.selectByVisibleText(letter);

        Select DunningLanguage = new Select(driver.findElement(All_ActionsLocators.selectLanguageofDebtor));
        DunningLanguage.selectByVisibleText(language);

        Select destinationType = new Select(driver.findElement(All_ActionsLocators.selectDestinationType));
        destinationType.selectByVisibleText(destination);

        Select templateType = new Select(driver.findElement(All_ActionsLocators.selectTemplateType));
        templateType.selectByVisibleText(template);

        System.out.println("Filled Document setting required fields successfully");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error: Dunning letter fields not visible or an exception occurred");
    }
	}
	
		public void AddSingleInvoiceinAction(String debID) {
		try {
			waitForElementFluent(100, 5);
			if (driver.findElement(By.xpath("//span[contains(text(),'" + debID + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + debID + "')]")).click();
				Thread.sleep(2000);
				Click(All_ActionsLocators.addSelectedInvoiceInAction);
				System.out.println("Add single invoice in progress Action");
			}
		} catch (Exception e) {
			System.out.println(debID + " : not found.");
		}
	}

	public void perviewInvoice() {
	
			 try {
			        // Wait for the PerviewClick element to be clickable
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			        WebElement perviewElement = wait.until(ExpectedConditions.elementToBeClickable(All_ActionsLocators.PerviewClick));

			        if (perviewElement.isDisplayed()) {
			            Click(All_ActionsLocators.PerviewClick);
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			        System.out.println("Error: Preview button is not visible or an exception occurred");
			    }
			}
	
			public void closePerviewInvoice() {
				try {
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					if (driver.findElement(All_ActionsLocators.editDocumentTitle).isDisplayed()) {

						Click(All_ActionsLocators.Save_CloseButtonOnPerview);
						System.out.println("Preview invoice closed successfully");
						Thread.sleep(2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Error: InterruptedException occurred while closing the preview invoice");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Error: An exception occurred while closing the preview invoice");
				}
			}

			public void SaveDocumentLetter() throws InterruptedException {
		 
		   try  
		      {
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	           if(driver.findElement(All_ActionsLocators.DocumentLettertitlepage).isDisplayed())
	             {
			  Click(All_ActionsLocators.Save_CloseButtonOnLetterDocumentSetting);
			    System.out.println("Document letter saved successfully");
	             }
		      }
		 catch(Exception e)
			{
				// Element is not present, you can perform another action or report it
				System.out.println(e.getStackTrace() + " : Element not found.");
			}
			}


	public boolean validationOnAction(String expct, String act) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			assertPage(expct, act);
			// Thread.sleep(3000);
			System.out.println("Validation passed as expected");

		} catch (Exception e) {
			System.out.println(expct + ":this value does not match as expected");
		}
		return true;

	}

	public String getWindowPopupTitle() throws InterruptedException {
		String titleName = GetText(All_ActionsLocators.windowTitleText);
		return titleName;
	}

	public String getsuccessMessageONLetterComplete() throws InterruptedException {
		waitForElementFluent(100, 5);
		String titleName = GetText(All_ActionsLocators.SuccessMessageforLetter);
		return titleName;
	}

	public void closeDataModelDialog() {// Method to Close Data Model Window
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			if (driver.findElement(ListScreenLocators.closeDataModel).isDisplayed()) {
				CloseListScreen(ListScreenLocators.closeDataModel);
				System.out.println("Close Model window successfully");
			}
		} catch (Exception e) {
			System.out.println("No popup model visible " + e.getMessage());
		}
	}

	public void closeCIS() {// Method to CIS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if (driver.findElement(ListScreenLocators.closeCISWindow).isDisplayed()) {
			CloseListScreen(ListScreenLocators.closeCISWindow);
		}
	}

	public void emailADDforAction(String to, String cc, String bcc) throws InterruptedException {
		waitForElementFluent(100, 5);
		SendKey(All_ActionsLocators.EmailTO, to);
		SendKey(All_ActionsLocators.EmailCC, cc);
		SendKey(All_ActionsLocators.EmailBCC, bcc);
		System.out.println("Add Emails for send Email successfully");

	}

	public String getSubjectofLetterAction() throws InterruptedException {
		waitForElementFluent(100, 5);
		String emailSubject = GetText(All_ActionsLocators.getSubjectEmail);
		return emailSubject;
	}
	
	public void CreatedActionViewOnTimeLine()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		clickandholdElement(All_ActionsLocators.newlyCreatedDunningLetterOnTimeline);
	}
	
	public String getactioncreatedInfo() throws InterruptedException
	{
		String infoAction = GetText(All_ActionsLocators.lastCreatedDunningInfoInTimeline);
		return infoAction;
	}
	 
	
	public void clickOnHistory()
	{
		Click(All_ActionsLocators.Debt_Historybutton);
	}
	
	public boolean isTextPresentInElement(By locator, String expectedText) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // Wait for the element to be visible
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            // Get the text of the element
            String actualText = element.getText();

            // Use Assert to check if the actual text contains the expected text
            Assert.assertTrue(actualText.contains(expectedText),
                    "The element's text contain the as expected text: " + expectedText);

            return true;
        } catch (Exception e) {
            System.out.println("Element with locator " + locator.toString() +
                    " was not found or the text does not match the expected text: " + expectedText);
           
        }
		return false;

	}
	
	public void LoginAppman(String appmanURL, String login, String pass, String group, String admin) throws InterruptedException
	{
		driver.get(appmanURL);
		Thread.sleep(5000);
		
		// Perform login actions
		SendKey(LoginPageLocators.appmalogin, login);
		SendKey(LoginPageLocators.appmanpassword, pass);
		Click(LoginPageLocators.appmanselectLanguage);
	  	Click(LoginPageLocators.nextButton);
	  	
	 // Check for the notification popup
	  	if(driver.findElement(LoginPageLocators.appmanNotification).isDisplayed()){
	  		Click(LoginPageLocators.notificationPopup_yes);
	  	}
	  	else {
	        System.out.println("No popup is displayed");
	    }
	    // Continue the login process
	    SendKey(LoginPageLocators.userGroup, group);
	    SendKey(LoginPageLocators.admin, admin);
	    Click(LoginPageLocators.appmanFinishLogin);
	    Thread.sleep(10000);	
	  	}
	
	public void batchExecutionFromAppMan()
	{
		
	}
	}
	

