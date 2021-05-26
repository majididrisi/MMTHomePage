package MMTScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MMTVisa {
WebDriver driver;
	
	//using @FindBy annotation in PageFactory model
	
		@FindBy (xpath="//span[contains(text(),'INR')]")
		WebElement Click ;
		
		@FindBy (xpath="//*[@data-cy='menu_Visa']")
		WebElement visa2;
		
		@FindBy (xpath="//input[@id='fromCountryCode']")
		WebElement Destination;
		
		@FindBy (xpath="//span[contains (text(), 'Dubai')]")
		WebElement CountrySelect ;
		
		
		@FindBy (xpath="//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'][1]//p[text()='22']")
		WebElement DepartureDate;
		
		@FindBy (xpath="//div[@class='DayPicker-Months']//div[@class='DayPicker-Month'][2]//p[text()='19']")
		WebElement ReturnDate;
		
		@FindBy (xpath="//span[contains(text(), 'Traveller')]")
		WebElement Traveller;
		
	
		@FindBy (className="btnPlus")
		WebElement Increase;
		
		
		@FindBy (xpath="//button[text()='APPLY']")
		WebElement btnApply;
		
		@FindBy (id="search_button")
		WebElement btnSearch;
		
		public MMTVisa (WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);// this will return Login page object with all webElements initialized
												  
		}
		
		
		//methods returning respective elements
		public WebElement Click()
		{
			return Click;
		}

		public WebElement visa2()
		{
			return visa2;
		}
		
		public WebElement Destination()
		{
			return Destination;
		}
		
		public WebElement CountrySelect()
		{
			return CountrySelect;
		}
		public WebElement DepartureDate()
		{
			return DepartureDate;
		}
		public WebElement ReturnDate()
		{
			return ReturnDate;
		}
		public WebElement Traveller()
		{
			return Traveller;
		}
		public WebElement Increase()
		{
			return Increase;
		}
		public WebElement btnApply()
		{
			return btnApply;
		}
	    
		public WebElement btnSearch()
		{
			return btnSearch;
		}

}
