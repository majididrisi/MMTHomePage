package MMTSteps;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import MMTScripts.MMTLandingPage;
import MMTScripts.MMTTopMenu;
import MMTScripts.MMTVisa;
import config.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MMT_Definitions extends TestBase {
	
WebDriver driver;

//WebDriverWait wait = new WebDriverWait(driver,20);
//MMTLandingPage MMTlpage = new MMTLandingPage(driver);
	
	// hook
		@Before
		public void setUp() 
		{
			//Setting up Webdriver
			System.out.println("In Set Up method");
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sajid\\\\OneDrive\\\\Desktop\\\\Majid\\\\New Folder\\\\Module 4\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		}
	
	//Scenario header tab starts
		
	@Given("^User is on Landing page$")
	public void user_is_on_Landing_page() throws Throwable {
	     //Window handle & Url
		driver.manage().window().maximize();
	    driver.get("https://www.makemytrip.com/");
	}

	@Given("^Company Logo is displayed$")
	public void company_Logo_is_displayed() throws Throwable {
		MMTLandingPage MMTlpage = new MMTLandingPage(driver);
		   boolean LogoPresent = MMTlpage.Logo().isDisplayed(); //Checks Logo is displayed
	       Assert.assertTrue(LogoPresent, "Comapny logo is Not Displayed");// Asserts true if Logo is Displayed
	       System.out.println("Company logo is Displayed");	

	}

	@Given("^All tabs on Header tab are displayed$")
	public void all_tabs_on_Header_tab_are_displayed() throws Throwable {
		MMTLandingPage MMTlpage = new MMTLandingPage(driver);
	       String mytrips= MMTlpage.mytrips1().getText(); //Check for Header tab My trips
	       Assert.assertEquals(mytrips, "My Trips", "Header tab Not Found");
	       System.out.println(mytrips+" /icon is Displayed");
	       Thread.sleep(1000);
	       
	       WebElement support1 = driver.findElement(By.xpath("//p[contains(text(),'24x7')]"));
	       String support= support1.getText(); //Check for Header tab My trips
	       Assert.assertEquals(support, "24x7", "Header tab Not Found");
	       System.out.println(support+" /support icon is Displayed");
	       Thread.sleep(1000);
	       
	       boolean walletPresent = MMTlpage.Wallet().isDisplayed(); //Checks wallet is displayed
	       Assert.assertTrue(walletPresent, " Wallet icon is Not Displayed");// Asserts true if wallet icon is Displayed
	       System.out.println("Wallet icon is Displayed");
	       Thread.sleep(1000);
	       
	       boolean myBizPresent = MMTlpage.myBiz().isDisplayed(); //Checks myBiz is displayed
	       Assert.assertTrue(myBizPresent, "myBiz icon is Not Displayed");// Asserts true if myBiz icon is Displayed
	       System.out.println("myBiz icon is Displayed");
	       Thread.sleep(1000);
	       
	       boolean LoginSignInPresent = MMTlpage.LoginSignIn().isDisplayed(); //Checks Login/Create account icon is displayed
	       Assert.assertTrue(LoginSignInPresent, " Login or Create Account icon is Not Displayed");// Asserts true if Login/Create account icon is Displayed
	       System.out.println("Login or Create Account icon is Displayed");
	       Thread.sleep(1000);
	       
	       String Language= MMTlpage.lang().getText(); //Check for Header tab  for Language 
	       Assert.assertEquals(Language, "ENG", "Language tab is Not Dispalyed");
	       System.out.println("Language Selected is: "+Language);
	       Thread.sleep(1000);
	       
	       String Currency= MMTlpage.Curr().getText(); //Check for Header tab  for Currency 
	       Assert.assertEquals(Currency, "INR", "Currency tab is Not Dispalyed");
	       System.out.println("Currency diplayed is: "+Currency);
	       Thread.sleep(1000);
		
	}

	@Given("^Click on Country tab$")
	public void click_on_Country_tab() throws Throwable {
		MMTLandingPage MMTlpage = new MMTLandingPage(driver);
		Actions act = new Actions(driver);
		  //Click on Country for dropdown
	       String Country= MMTlpage.Country1().getText();  //Check for Header tab Country Change
	       Assert.assertEquals(Country, "IN", "Country tab is Not Dispalyed");
	       System.out.println("Country Displayed is: "+Country);
	       
	      
	       act.moveToElement(MMTlpage.Curr()).click().build().perform();
	       MMTlpage.Country1().click();
	}

	@Given("^Change Country$")
	public void change_Country() throws Throwable {
		MMTLandingPage MMTlpage = new MMTLandingPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,20);
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'UAE')]"))); //Changing Counry
	       MMTlpage.CountryChange().click(); 
	}

	@Then("^Changed Country is displayed$")
	public void changed_Country_is_displayed() throws Throwable {
		MMTLandingPage MMTlpage = new MMTLandingPage(driver);

	       String ChangedCountry = MMTlpage.ChangedCountry1().getText();
	       System.out.println("Changed Country is: "+ChangedCountry);
	}

	//Scenario Top Menu Starts
	
	@Given("^Top menu with all tabs is displayed$")
	public void top_menu_with_all_tabs_is_displayed() throws Throwable {
		MMTTopMenu Tmenu = new MMTTopMenu(driver);

		   // Flights Section
		   String Flights= Tmenu.flight().getText();
	       Assert.assertEquals(Flights, "Flights", "Top menu section is Not Found");
	       System.out.println(Flights+" section is Displayed");
	       
	       // Hotels section
	       String Hotels= Tmenu.hotel().getText(); //Check Top Menu Hotels section
	       Assert.assertEquals(Hotels, "Hotels", "Top menu section is Not Found");
	       System.out.println(Hotels+" section is Displayed");
	       
	       // Villa & apts section
	       String VillasNapts= Tmenu.villas().getText(); //Check Top Menu for Villas & Apts section
	       Assert.assertEquals(VillasNapts, "Villas & Apts", "Top menu section is Not Found");
	       System.out.println(VillasNapts+" section is Displayed");
	       
	       //Holidays section
	       String Holidays= Tmenu.Holiday().getText(); //Check Top Menu for Holidays section 
	       Assert.assertEquals(Holidays, Holidays, "Top menu section is Not Found");
	       System.out.println(Holidays+" section is Displayed");
	       
	       //Trains Section	
	       String Trains= Tmenu.train().getText(); //Check Top Menu for Trains section 
	       Assert.assertEquals(Trains, "Trains", "Top menu section is Not Found");
	       System.out.println(Trains+" section is Displayed");
	       
	       // Buses Section
	       String Buses= Tmenu.bus().getText(); //Check Top Menu for Buses section 
	       Assert.assertEquals(Buses, "Buses", "Top menu section is Not Found");
	       System.out.println(Buses+" section is Displayed");
	       
	       // Visa Section
	       String Visa= Tmenu.visa1().getText(); //Check Top Menu for Visa section 
	       Assert.assertEquals(Visa, "Visa", "Top menu section is Not Found");
	       System.out.println(Visa+" section is Displayed");
	       
	       // Cabs Section
	       String Cabs= Tmenu.cab().getText(); //Check Top Menu for Cabs section 
	       Assert.assertEquals(Cabs, "Cabs", "Top menu section is Not Found");
	       System.out.println(Cabs+" section is Displayed");
	       
	       // Charter Flights Section	       
	       String CharterFlights= Tmenu.charter().getText(); //Check Top Menu for Charter Flights section 
	       Assert.assertEquals(CharterFlights, CharterFlights, "Top menu section is Not Found");
	       System.out.println(CharterFlights+" section is Displayed");
		
	}

	@Given("^Click on each section and Check sections are Changing$")
	public void click_on_each_section_and_Check_sections_are_Changing() throws Throwable {
		    MMTTopMenu Tmenu = new MMTTopMenu(driver);
		    Actions act = new Actions(driver);
		 
		   // Hotels section
		   act.moveToElement(Tmenu.hotel()).click().build().perform();
	       Tmenu.hotel().click();
	       Thread.sleep(1000);
	       String Hotels= Tmenu.hotel().getText(); //Check Top Menu Hotels section
	       Assert.assertEquals(Hotels, "Hotels", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+Hotels);
	       Thread.sleep(1000);
	       
	       // Villa & apts section
	       Tmenu.villas().click();
	       String VillasNapts= Tmenu.villas().getText(); //Check Top Menu for Villas & Apts section
	       Assert.assertEquals(VillasNapts, "Villas & Apts", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+VillasNapts);
	       Thread.sleep(1000);
	       
	       //Holidays section
	       Tmenu.Holiday().click();
	       String Holidays= Tmenu.Holiday().getText(); //Check Top Menu for Holidays section 
	       Assert.assertEquals(Holidays, Holidays, "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+Holidays);
	       Thread.sleep(1000);
	       
	       //Trains Section	
	       Tmenu.train().click();
	       String Trains= Tmenu.train().getText(); //Check Top Menu for Trains section 
	       Assert.assertEquals(Trains, "Trains", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+Trains);
	       Thread.sleep(1000);
	       
	       // Buses Section
	       Tmenu.bus().click();
	       String Buses= Tmenu.bus().getText(); //Check Top Menu for Buses section 
	       Assert.assertEquals(Buses, "Buses", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+Buses);
	       Thread.sleep(1000);
	       
	       // Visa Section
	       Tmenu.visa1().click();
	       String Visa= Tmenu.visa1().getText(); //Check Top Menu for Visa section 
	       Assert.assertEquals(Visa, "Visa", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+Visa);
	       Thread.sleep(1000);
	       
	       // Cabs Section
	       Tmenu.cab().click();
	       String Cabs= Tmenu.cab().getText(); //Check Top Menu for Cabs section 
	       Assert.assertEquals(Cabs, "Cabs", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+Cabs);
	       Thread.sleep(1000);
	       
	       // Charter Flights Section	
	       Tmenu.charter().click();
	       String CharterFlights= Tmenu.charter().getText(); //Check Top Menu for Charter Flights section 
	       Assert.assertEquals(CharterFlights, CharterFlights, "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+CharterFlights);
	       Thread.sleep(1000);
		
	}

	@Then("^Scroll Down to See Top pinned Menu$")
	public void scroll_Down_to_See_Top_pinned_Menu() throws Throwable {
		  MMTTopMenu Tmenu = new MMTTopMenu(driver);
	      Actions act = new Actions(driver);
	      JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].scrollIntoView();", Tmenu.scroll() );
			Thread.sleep(2000);
	      // act.moveToElement(Tmenu.scroll()).perform();
	       //act.release().perform();
	       System.out.println("Scrolled Down to see the Top pinned menu");
	       Thread.sleep(600);
	}

	@Then("^Check for the availability of all the links on page$")
	public void check_for_the_availability_of_all_the_links_on_page() throws Throwable {


		//Storing the links in a list and traversing through the links
        List<WebElement> links = driver.findElements(By.tagName("a"));
 
        // This line will print the number of links and the count of links.
        System.out.println("No of links are "+ links.size());  
      
        //checking the links fetched.
        for(int i=0;i<links.size();i++)
        {
            WebElement E1= links.get(i);
            String url= E1.getAttribute("href");
            verifyLinks(url);
        }
    }
    
	//Scenario Links Starts
	
    public static void verifyLinks(String linkUrl)

    {
        try
        {
            URL url = new URL(linkUrl);
          //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection(); //check the HTTP status of each using HttpURLConnection class in Java.
            httpURLConnect.setConnectTimeout(5000);//waiting 5 seconds for connection timeout
            httpURLConnect.connect();
             // System.out.println("No. of invalid Links are: "+count);
            // System.out.println("No.of Valid Links are: "+count2);
            // System.out.println("No.of Exception Links are: "+count3);
            if(httpURLConnect.getResponseCode()>=400)// checking the response code either 200 or 404
            {
            
				
             System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage()+" is a broken link");
             
			
            
            }    
       
            //Fetching and Printing the response code obtained
            else 
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
				
            }
        }
        catch (Exception e) {
        	
        	
      }
        
		
	}
    
    //Scenario Visa Starts
    
    @Given("Change to Visa Section")
    public void change_to_Visa_Section() throws InterruptedException {
    	MMTVisa visa = new MMTVisa(driver);
   	    Actions act = new Actions(driver);
   	    
   	 
	       act.moveToElement(visa.Click()).click().build().perform();
	       visa.visa2().click(); // Changing Section to Visa 
	       String VisaStr= visa.visa2().getText(); //Check if section changed to Visa
	       Assert.assertEquals(VisaStr, "Visa", "Top menu section is Not Found");
	       System.out.println("Section is Changed to : "+VisaStr);
	       Thread.sleep(1000);
    }
    
    @Given("Select Destination")
    public void select_Destination() throws InterruptedException {
           MMTVisa visa = new MMTVisa(driver);
    	
    	   visa.Destination().click();
    	   visa.CountrySelect().click();
    	//   String VisaStr= visa.visa1().getText(); //Check if section changed to Visa
	      // Assert.assertEquals(VisaStr, "Visa", "Top menu section is Not Found");
	       System.out.println("Destination is Selected");
	       Thread.sleep(1000);
    	
    }

    @Given("Select Dates")
    public void select_Dates() throws InterruptedException {
    	MMTVisa visa = new MMTVisa(driver);
    	
    	   visa.DepartureDate().click();
    	   visa.ReturnDate().click();
    	  // String Ddate= visa.DepartureDate().getText(); //Check the Departure Date Selected
    	  // String Rdate= visa.ReturnDate().getText(); //Check the Return Date Selected

	      // Assert.assertEquals(D, "Visa", "Top menu section is Not Found");
	       System.out.println("Departure & return Dates are Selected");
	       Thread.sleep(1000);
    }

    @Given("Select Number of Travellers")
    public void select_Number_of_Travellers() throws InterruptedException {
      	MMTVisa visa = new MMTVisa(driver);
      	
      	visa.Traveller().click();
      	visa.Increase().click();
      	visa.btnApply().click();
	    System.out.println("No. of travellers are Selected");
	    Thread.sleep(1000);
    }

    @Then("Click on Search")
    public void click_on_Search() throws InterruptedException {
      	MMTVisa visa = new MMTVisa(driver);
      	
      	visa.btnSearch().click();
	    System.out.println("Departure & return Dates are Selected");
	    Thread.sleep(1000);
      	
    }

	
	@After
	public void tearDown() {
		driver.close();
		System.out.println("Driver closed");
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}



}
