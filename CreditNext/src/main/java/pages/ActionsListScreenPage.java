package pages;

import org.openqa.selenium.WebDriver;

import locatorPages.ListScreenLocators;
import pageInterfaces.ListScreen;

public class ActionsListScreenPage extends ListScreen {

	final WebDriver driver;

	public ActionsListScreenPage(WebDriver driver) {
		super(driver);		
		this.driver=driver;
	}

	
	
	
}
