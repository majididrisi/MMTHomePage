package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

public class StepDefinition {
	WebDriver driver;
	
	// hook
		@Before
		public void setUp() {
			System.out.println("In Set Up method");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sajid\\OneDrive\\Desktop\\Majid\\New Folder\\Module 4\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		}

		@Given("^User is on landing page$")
		public void user_is_on_landing_page() throws Throwable {
			System.out.println("On landing page");
			driver.get("https://demo.opencart.com/");
		}

		@Given("^User clicks on Login Link$")
		public void user_clicks_on_Login_Link() throws Throwable {
			// clicking on Login
			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			driver.findElement(By.xpath("//a[@title='My Account']/following-sibling::ul//a[contains(text(),'Login')]"))
					.click();
		}

		@Given("^User enters email id and password$")
		public void user_enters_email_id_and_password() throws Throwable {
			// entering user detail..
			driver.findElement(By.id("input-email")).sendKeys("guest@guest.com");
			driver.findElement(By.id("input-password")).sendKeys("12345");
		}

		@Given("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
		public void user_enters_and(String email, String password) throws Throwable {
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-password")).sendKeys(password);
		}

		@When("^User click on Login button$")
		public void user_click_on_Login_button() throws Throwable {

			driver.findElement(By.xpath("//input[@type='submit'][@value='Login']")).click();

		}

		@Then("^User logs-in in to website and home page is displayed$")
		public void user_logs_in_in_to_website_and_home_page_is_displayed() throws Throwable {
			String assertText2 = driver.findElement(By.xpath("//div[@id='content']/h2")).getText();
			Assert.assertEquals(assertText2, "My Account", "Login failed");
		}

		@When("^User selects Mac as product$")
		public void user_selects_Mac_as_product() throws Throwable {
			WebElement deskTopLnk = driver.findElement(By.xpath("//a[contains(text(),'Desktops')]"));
			WebElement macLnk = driver.findElement(
					By.xpath("//a[contains(text(),'Desktops')]//following-sibling::div//a[contains(text(),'Mac')]"));

			Actions builder = new Actions(driver);

			Action hoverNclick = builder.moveToElement(deskTopLnk).pause(1000).moveToElement(macLnk).click().build();

			hoverNclick.perform();
		}

		@When("^User click on Add-to Cart button for Mac$")
		public void user_click_on_Add_to_Cart_button_for_Mac() throws Throwable {
			driver.findElement(By.xpath(
					"//div[@id='content']//a[contains(text(),'iMac')]//following::button//span[contains(text(),'Add to Cart')]//ancestor::button"))
					.click();
		}

		@Then("^Product Mac gets added to Shopping cart$")
		public void product_Mac_gets_added_to_Shopping_cart() throws Throwable {
			driver.findElement(By.id("cart-total")).click();

			boolean flag = false;
			String prodDesc = driver
					.findElement(By
							.xpath("//div[@id='cart']//table[@class='table table-striped']//td/a[contains(text(),'iMac')]"))
					.getText();
			String prodQty = driver
					.findElement(
							By.xpath("//div[@id='cart']//table[@class='table table-striped']//td[contains(text(),'x 1')]"))
					.getText();
			if (prodDesc.equals("iMac") && prodQty.equals("x 1")) {
				flag = true;
			}

			Assert.assertTrue(flag);
		}

		@When("^User selects Samsung SyncMaster (\\d+)BW Monitor as product$")
		public void user_selects_Samsung_SyncMaster_BW_Monitor_as_product(int arg1) throws Throwable {
			WebElement componentLnk = driver.findElement(By.xpath("//a[contains(text(),'Components')]"));
			WebElement samsungLnk = driver.findElement(
					By.xpath("//a[contains(text(),'Components')]//following-sibling::div//a[contains(text(),'Monitors')]"));

			Actions builder = new Actions(driver);

			Action hoverNclick = builder.moveToElement(componentLnk).pause(1000).moveToElement(samsungLnk).click().build();

			hoverNclick.perform();
		}

		@When("^User click on Add-to Cart button for Samsung SyncMaster (\\d+)BW Monitor$")
		public void user_click_on_Add_to_Cart_button_for_Samsung_SyncMaster_BW_Monitor(int arg1) throws Throwable {
			driver.findElement(By.xpath(
					"//div[@id='content']//a[contains(text(),'Samsung SyncMaster 941BW')]//following::button//span[contains(text(),'Add to Cart')]//ancestor::button"))
					.click();
		}

		@Then("^Product Samsung SyncMaster (\\d+)BW Monitor gets added to Shopping cart$")
		public void product_Samsung_SyncMaster_BW_Monitor_gets_added_to_Shopping_cart(int arg1) throws Throwable {
			driver.findElement(By.id("cart-total")).click();
			boolean flag = false;
			String prodDesc = driver.findElement(By.xpath(
					"//div[@id='cart']//table[@class='table table-striped']//td/a[contains(text(),'Samsung SyncMaster')]"))
					.getText();
			String prodQty = driver
					.findElement(
							By.xpath("//div[@id='cart']//table[@class='table table-striped']//td[contains(text(),'x 1')]"))
					.getText();
//			System.out.println("Inside Shhopping cart for Samsung check");
//			System.out.println("Prod desc " + prodDesc);
//			System.out.println("Prod qty " + prodQty);
			if (prodDesc.equals("Samsung SyncMaster 941BW") && prodQty.equals("x 1")) {
				flag = true;
			}

			Assert.assertTrue(flag);
		}

	/*	@Given("^User enters email id and wrong password$")
		public void user_enters_email_id_and_wrong_password() throws Throwable {
			// entering user detail with wrong password..
			driver.findElement(By.id("input-email")).sendKeys("guest@guest.com");
			driver.findElement(By.id("input-password")).sendKeys("1234");
		}
	*/
		@Given("^User enters \"([^\"]*)\" id and \"([^\"]*)\"$")
		public void user_enters_id_and(String email, String wrongPwd) throws Throwable {
			driver.findElement(By.id("input-email")).sendKeys(email);
			driver.findElement(By.id("input-password")).sendKeys(wrongPwd);
		}
		
		@Then("^Log in fails and error message is displayed$")
		public void log_in_fails_and_error_message_is_displayed() throws Throwable {
//		String assertText3 = driver.findElement(By.xpath("//div[@id='account-login']//div[contains(text(),'No match for E-Mail Address and/or Password')]")).getText();
			String assertText3 = driver
					.findElement(By.xpath("//div[@id='account-login']//div[@class='alert alert-danger alert-dismissible']"))
					.getText();

			Assert.assertEquals(assertText3, "Warning: No match for E-Mail Address and/or Password.");
		}
		
		@When("^User Selects  \"([^\"]*)\" and \"([^\"]*)\"$")
		public void user_Selects_and(String Category, String subCategory) throws Throwable {
			WebElement CategoryLnk = driver.findElement(By.xpath("//a[contains(text(),'"+ Category +"')]"));
			WebElement subCategoryLnk = driver.findElement(
				By.xpath("//a[contains(text(),'"+Category+"')]//following-sibling::div//a[contains(text(),'"+ subCategory +"')]"));
			
			System.out.println("Product Category Selected is: " + CategoryLnk.getText());
			System.out.println("Product SubCategory Selected is: " + subCategoryLnk.getText());
			

			Actions builder = new Actions(driver);
		    Action hoverNclick = builder.moveToElement(CategoryLnk).pause(1000).moveToElement(subCategoryLnk).click().build();
		
			hoverNclick.perform();
		    
		}

		@When("^User clicks on Add to cart button for the \"([^\"]*)\"$")
		public void user_clicks_on_Add_to_cart_button_for_the(String product) throws Throwable {
			driver.findElement(By.xpath(
					"//div[@id='content']//a[contains(text(),'"+ product +"')]//following::button//span[contains(text(),'Add to Cart')]//ancestor::button"))
					.click();
		}

		@Then("^\"([^\"]*)\" gets added to shopping cart$")
		public void gets_added_to_shopping_cart(String product) throws Throwable {
			driver.findElement(By.id("cart-total")).click();

			boolean flag = false;
			String prodDesc = driver
					.findElement(By
							.xpath("//div[@id='cart']//table[@class='table table-striped']//td/a[contains(text(),'"+product+"')]"))
					.getText();
			String prodQty = driver
					.findElement(
							By.xpath("//div[@id='cart']//table[@class='table table-striped']//td[contains(text(),'x 1')]"))
					.getText();
			if (prodDesc.equals(product) && prodQty.equals("x 1")) {
				flag = true;
			}

			Assert.assertTrue(flag);
		}
		

		@After
		public void tearDown() {
			driver.close();
			System.out.println("Driver closed");
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		}
}
	