package Utility;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import locatorPages.All_ActionsLocators;

public class events {
	final WebDriver driver;

	public events(WebDriver driver) {
		this.driver = driver;
	}
//return the text from perticular locator
	public String GetText(By locator) throws InterruptedException {
		
		return driver.findElement(locator).getText();
		
	}
	public String GetText1(By locator, Duration waitTime) throws InterruptedException {
	try
    {
    	waitForElement(locator, waitTime);
    	if (driver.findElement(locator).isDisplayed()) {
    		
    		return driver.findElement(locator).getText();
    	}
    }   // try 
    catch (NoSuchElementException e)
    {
    	System.out.println("Error found" + e.getMessage());
    }
	return null;
	}
		//Enter the value in the specified locator 
	public void SendKey(By locator,String text) throws InterruptedException {
		waitForElement(locator, Duration.ofSeconds(3));
		driver.findElement(locator).sendKeys(text);
		
	}
	public void SendKeyAndEnter(By locator,String text) throws InterruptedException {
		driver.findElement(locator).click();
		driver.findElement(locator).sendKeys(text + Keys.ENTER);
		
	}
	public void ClearInput(By locator) throws InterruptedException {
		driver.findElement(locator).clear();
		
	}
	//Click event will be performed
	public void Click_event(By locator) throws InterruptedException {
		driver.findElement(locator).click();
	}
     //Click event by using class name locator
	public void Click_eventBy_ClassName(By locator) {
		driver.findElement(locator).click();
	}
	//Select value from DDlist based on text input match
	public void DDlistOptionsByText(By locator, String text) throws InterruptedException
    {
		driver.findElement(locator).click(); 
	    Thread.sleep(4000);
	    List<WebElement> options = driver.findElements(locator);
	    for(WebElement option : options) {     	 
		  // System.out.println(option.getText());
		    if(option.getText().equals(text)){
		    	option.click();
		    	Thread.sleep(1000);
			     break;
			       }
		    }
		   System.out.println(text+" is enterd in the language field");
		   Reporter.log(text + ":  is enterd in the language field"); 
    }
	//Select value from DDlist based visible text directly
    public void DDlistSelectByText(By locator, String text)
    {
        Select droplist = new Select(driver.findElement(locator));
        droplist.selectByVisibleText(text);           
    }
    //Click event on passed locator
	public void Click(By locator)   
	{
		waitForElement(locator, Duration.ofSeconds(20));
        driver.findElement(locator).click();      
    }
	
	//Click using javaScriptexecutor based on element id
    public void JavaScriptClickByElementId(String locator)
    {
        JavascriptExecutor executor = (JavascriptExecutor) driver;            
        executor.executeScript("document.getElementById(" + "'" + locator + "'" + ").click();");
    }
    //Assertion based on Expected and Actual result
    public void assertPage(String ExpectedTitle,String ActualTitle){
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
    
    public Boolean isNotificationPresent(By locator, By clickElement, Duration waitTime)
    {
    	
        try
        {
        	waitForElement(locator, waitTime);
        	if (driver.findElement(locator).isDisplayed()) {
        		 driver.findElement(clickElement).click();   
                 Thread.sleep(1000);
                 return true;
        	}
        }   // try 
        catch (NoSuchElementException e)
        {
        	System.out.println("Error found" + e.getMessage());
        }
        catch (Exception e)
        {
        	System.out.println("Error found" + e.getMessage());
        }
		return false;
    }
    
    public void waitForElement(By locator,Duration time) {
	    WebDriverWait wait = new WebDriverWait(driver,time);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
    public void waitForElementFluent(int maxtime, int intervaltime)
    {
    	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
    			.withTimeout(Duration.ofSeconds(maxtime))
    	        .pollingEvery(Duration.ofSeconds(intervaltime))
    	        .ignoring(NoSuchElementException.class);
    	
    }
    
    public String HandleAlertPopUp() {
    	
    	 Alert alert = driver.switchTo().alert();		
         String alertMessage= driver.switchTo().alert().getText();		
         System.out.println(alertMessage);	
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
         // Accepting alert		
         alert.accept();
		return alertMessage;		
    }
    public String  handle_browser_tab(By path) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		WebElement link = driver.findElement(path);
		Actions newTab = new Actions(driver);
		newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		// handle windows change
		String base = driver.getWindowHandle();
		Set<String> set = driver.getWindowHandles();

		set.remove(base);
		assert set.size() == 1;
		driver.switchTo().window((String) set.toArray()[0]);
        String title=driver.getTitle();
		// close the window
		driver.close();
		driver.switchTo().window(base);

		// handle windows change and switch back to the main window
		Thread.sleep(1500);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		return title;
	}
    public WebElement getWebElement(WebDriver driver, String id) {
		WebElement myDynamicElement = null;
		try {
			myDynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
			return myDynamicElement;
		} catch (TimeoutException ex) {
			return null;
		}
	}
    
    public void clickandholdElement(By locator)
    {
    	Actions action = new Actions(driver);
      WebElement actionIconOnTimeline =driver.findElement(locator);
      action.clickAndHold(actionIconOnTimeline).perform();
    }
    
    
   
}