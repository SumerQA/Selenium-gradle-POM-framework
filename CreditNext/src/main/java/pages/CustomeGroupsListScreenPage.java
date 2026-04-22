package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.events;
import locatorPages.ListScreenLocators;
import pageInterfaces.ListScreen;

public class CustomeGroupsListScreenPage extends ListScreen {
	final WebDriver driver;

	public CustomeGroupsListScreenPage(WebDriver driver) {
		super(driver);		
		this.driver=driver;
	}
	
	public String OpenCustomerGroupsListScreen(By locator) {
		try {
			Thread.sleep(3000);
			OpenListScreen(locator);
			return GetText(ListScreenLocators.ListScreenTitle);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "All Customer Group List not Opened";
	  }
	
	public void ClickCustomerGroupMenuItem(By locator)  {// Method to Open Customer groups Menu List
		
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			OpenListScreen(locator);//Open menu item
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
}
	
	public String OpentoolBarIconInCustonerGroupsListScreen(By Locator, By ele) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			OpenListScreen(Locator);
			Thread.sleep(500);
			return ValidateNoRowsSelectedAlert(ele);
			
		} catch (Exception e) {
			System.out.println("Icon not found");
			return "No Rows Selected Alert found";
		}
		
	  }
	public String  OpenhelpPage(){
		try {
			return handle_browser_tab(ListScreenLocators.heplIcon);
		} catch (Exception e) {
			return "Help Page not found";
		}
		
	  }
	public void ValidateOpenedListScreen(String expct, String act) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			assertPage(expct, act);
			//Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(expct +": not found on the List screen.");
		}
		
	}

	public void selectDebtorinListScreen(String debID) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			if (driver.findElement(By.xpath("//span[contains(text(),'" + debID + "')]")).isDisplayed()) {
				driver.findElement(By.xpath("//span[contains(text(),'" + debID + "')]")).click();
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println(debID + " : not found.");
		}

	}

	public void serchDebtornumber(String debID) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		   WebElement searchDebtor= driver.findElement(By.xpath("(//div[@ref='eFloatingFilterBody'])[1]/app-grid-filter/div/input"));
		   searchDebtor.clear();
		   searchDebtor.sendKeys(debID+Keys.ENTER);
		} catch (Exception e) {
			System.out.println("Filter not able to search");
		}
	}
	
	public void cleanSearchfile() {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement a=   driver.findElement(By.xpath("(//div[@ref='eFloatingFilterBody'])[1]/app-grid-filter/div/input"));
		a.sendKeys(Keys.CONTROL+"a");
		a.sendKeys(Keys.DELETE);
		a.sendKeys(Keys.ENTER);
		   
		   
		} catch (Exception e) {
			System.out.println("Filter not able to clear");
		}
	}
	public void selectDebtorinListScreenAnyCondition(String debID) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			if(driver.findElement(By.xpath("//span[contains(text(),'"+debID+"')]")).isDisplayed()) 
			{
				if(!driver.findElement(By.xpath("(//div[@ref='eCellWrapper'])[1]/span[1]")).isSelected())
						{
					driver.findElement(By.xpath("//span[contains(text(),'"+debID+"')]")).click();
					Thread.sleep(2000);
						}
			
			}
		} catch (Exception e) {
			System.out.println(debID +" : not found.");
		}
		
	}
	public void closeModelDialog() {// Method to Close Model Dialog
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			if(driver.findElement(ListScreenLocators.closeModelDialog).isDisplayed()){
				CloseListScreen(ListScreenLocators.closeModelDialog);
			}
	}
	public void closeDataModelDialog() {// Method to Close Data Model Window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));	
		if(driver.findElement(ListScreenLocators.closeDataModel).isDisplayed()){
				CloseListScreen(ListScreenLocators.closeDataModel);
			}
	}
	public void closeCIS() {// Method to CIS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		if(driver.findElement(ListScreenLocators.closeCISWindow).isDisplayed()){
			CloseListScreen(ListScreenLocators.closeCISWindow);
		}
	}
	public void closeActivateDebtorScreen() {// Method to CIS
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		if(driver.findElement(ListScreenLocators.okButton).isDisplayed()){
			CloseListScreen(ListScreenLocators.okButton);
		}
	}
	
	
	private String ValidateNoRowsSelectedAlert(By ele) throws InterruptedException {
		String result = null;
		try {
			Thread.sleep(1000);
			if(driver.findElement(ele).isDisplayed()){    
				Thread.sleep(1000);
				return GetText(ele);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Thread.sleep(2000);
			if(driver.findElement(ListScreenLocators.validateDebtorInCIS).isDisplayed()){    
				Thread.sleep(1500);
				return GetText(ListScreenLocators.validateDebtorInCIS);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Thread.sleep(2000);
			if(driver.findElement(ListScreenLocators.UsedDebtorScreen).isDisplayed()){ 
				result =GetText(ListScreenLocators.UsedDebtorScreen);
				Click(ListScreenLocators.proceedUsedDebtor);
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	
	public void CloseCustomerGroupsListScreen(By locator) {// Method to Close Customer groups Munu List
		CloseListScreen(locator);
	}

	public void ApplyPageFilterOnListScreen(By locator,String input)  {
		ApplyPageFilter(locator, input);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ClearPageFilterOnListScreen(By locator)  {
		try {
			ClearFilder(locator);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ShowIconDetailsOnListScreen(By locator) {
		ShowIconDetails(locator);
	}

	public void OpenToolBarItemOnListScreen(By locator) {
		OpenToolBarItem(locator);
	}

	public void MinimizeListScreen(By locator) {
		MinimizeScreen(locator);
	}

	public void SortColumnsData(By locator) {
		SortBy(locator);
		
	}

	public void QuickSearchOnListScreen(By locator ,String input) throws InterruptedException {
		SortByValue(locator, input);
	}
	
	public void CloseAllCustomerGroupListScreen() {
		CloseCustomerGroupsListScreen(ListScreenLocators.closeListScreen);
	}
	public void CloseActionsListScreen() {
		CloseCustomerGroupsListScreen(ListScreenLocators.closeListScreen);
	}
	public void ClickCIS_Button()
	{
		Click(ListScreenLocators.cisButton);
	}
}
