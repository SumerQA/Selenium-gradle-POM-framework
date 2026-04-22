package pageInterfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utility.events;

public class ListScreen extends events implements IListScreen {
	final WebDriver driver;
	public ListScreen(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	@Override
	public void OpenListScreen(By locator) {
		Click(locator);
	}

	@Override
	public void CloseListScreen(By locator) {
		Click(locator);
	}

	@Override
	public void ApplyPageFilter(By locator,String input) {
		try {
			SendKeyAndEnter(locator, input);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void ShowIconDetails(By locator) {
		Click(locator);
		
	}

	@Override
	public void OpenToolBarItem(By locator) {
		Click(locator);
		
	}

	@Override
	public void MinimizeScreen(By locator) {
		Click(locator);
		
	}

	@Override
	public void SortBy(By locator) {
		Click(locator);
		
	}

	@Override
	public void SortByValue(By locator ,String input) throws InterruptedException {
		SendKey(locator, input);
	}
	public void ClearFilder(By locator) throws InterruptedException {
		ClearInput(locator);
	}
}
