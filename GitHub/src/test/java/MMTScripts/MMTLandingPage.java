package MMTScripts;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import config.TestBase;

public class MMTLandingPage extends TestBase {
	WebDriver driver;
	
	//using @FindBy annotation in PageFactory model
	
		@FindBy (xpath="//img[@src='//imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/header/mmtLogoWhite.png\']")
		WebElement Logo ;
		
		@FindBy (xpath="//p[contains(text(),'My Trips')]")
		WebElement mytrips1;
		
		@FindBy (xpath="//p[contains(text(),'24x7")
		WebElement support1;
		
		@FindBy (xpath="//*[@data-cy='Wallet']")
		WebElement Wallet;
		
		@FindBy (xpath="//span[contains(@class,'myBizIcon')]")
		WebElement myBiz;
		
		@FindBy (xpath="//*[@data-cy='account']")
		WebElement LoginSignIn ;
		
		@FindBy (xpath="//span[contains(text(),'ENG')]")
		WebElement lang ;
		
		@FindBy (xpath="//span[contains(text(),'INR')]")
		WebElement Curr ;
		
		@FindBy (xpath="//span[contains(text(),'IN')]")
		WebElement Country1;
		
		
		@FindBy (xpath="//span[contains(text(),'UAE')]")
		WebElement CountryChange;
		
		@FindBy (xpath="//span[contains(text(),'UAE')]")
		WebElement ChangedCountry1;
		
		public MMTLandingPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);// this will return Login page object with all webElements initialized
												  
		}
		
		
		//methods returning respective elements
		public WebElement Logo()
		{
			return Logo;
		}

		public WebElement mytrips1()
		{
			return mytrips1;
		}
		
		public WebElement support1()
		{
			return support1;
		}
		
		public WebElement Wallet()
		{
			return Wallet;
		}
		public WebElement myBiz()
		{
			return myBiz;
		}
		public WebElement LoginSignIn()
		{
			return LoginSignIn;
		}
		public WebElement lang()
		{
			return lang;
		}
		public WebElement Curr()
		{
			return Curr;
		}
		public WebElement Country1()
		{
			return Country1;
		}
		public WebElement CountryChange()
		{
			return CountryChange;
		}
		public WebElement ChangedCountry1()
		{
			return ChangedCountry1;
		}
		
}
