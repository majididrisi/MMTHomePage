package MMTScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.TestBase;

public class MMTTopMenu extends TestBase {

WebDriver driver;
	
	//using @FindBy annotation in PageFactory model
	
		@FindBy (xpath="//*[@data-cy='menu_Flights']")
		WebElement flight ;
		
		@FindBy (xpath="//*[@data-cy='menu_Hotels']")
		WebElement hotel;
		
		@FindBy (xpath="//*[@data-cy='menu_Villasmore']")
		WebElement villas;
		
		@FindBy (xpath="//*[@data-cy='menu_Holidays']")
		WebElement Holiday;
		
		@FindBy (xpath="//*[@data-cy='menu_Trains']")
		WebElement train;
		
		@FindBy (xpath="//*[@data-cy='menu_Buses']")
		WebElement bus ;
		
		@FindBy (xpath="//*[@data-cy='menu_Visa']")
		WebElement visa1 ;
		
		@FindBy (xpath="//*[@data-cy='menu_Cabs']")
		WebElement cab ;
		
		@FindBy (xpath="//*[@data-cy='menu_Charters']")
		WebElement charter ;
		
		
		@FindBy (xpath="//p[contains(text(),'© 2021 MAKEMYTRIP PVT. LTD.')]")
		WebElement scroll;
		
		public MMTTopMenu (WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);// this will return Login page object with all webElements initialized
												  
		}
		
		
		//methods returning respective elements
		public WebElement flight()
		{
			return flight;
		}

		public WebElement hotel()
		{
			return hotel;
		}
		
		public WebElement villas()
		{
			return villas;
		}
		
		public WebElement Holiday()
		{
			return Holiday;
		}
		public WebElement train()
		{
			return train;
		}
		public WebElement bus()
		{
			return bus;
		}
		public WebElement visa1()
		{
			return visa1;
		}
		public WebElement cab()
		{
			return cab;
		}
		public WebElement charter()
		{
			return charter;
		}
		public WebElement scroll()
		{
			return scroll;
		}
	
		
}


