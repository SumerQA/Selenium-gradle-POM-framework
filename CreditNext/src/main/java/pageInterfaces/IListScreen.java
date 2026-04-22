package pageInterfaces;

import org.openqa.selenium.By;

public interface IListScreen {
	 void CloseListScreen(By locator);//Close the list screen
	 void SortBy(By locator); //Sorting columnn data 
	 void SortByValue(By locator, String text) throws InterruptedException; //Sorting columnn on column click	 
	 void ShowIconDetails(By locator);//Enable the Icon Name 
	 void OpenToolBarItem(By locator);//Open ToolBar item 
	 void MinimizeScreen(By locator);//Minimize the List Screen
	 void OpenListScreen(By locator);
	 void ApplyPageFilter(By locator, String input) throws InterruptedException;
}
