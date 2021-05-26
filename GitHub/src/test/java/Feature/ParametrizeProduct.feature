Feature: Parameterize Buying Prouct

Background: Login Function
Given User is on landing page
And User clicks on Login Link
And User enters email id and password
When User click on Login button
And User logs-in in to website and home page is displayed

@BuyingProduct
Scenario Outline: Buying Products
And User Selects  "<Category>" and "<subCategory>"
And User clicks on Add to cart button for the "<product>"
Then "<product>" gets added to shopping cart

Examples:
| Category   | subCategory   | product                  |
| Desktops   | Mac           | iMac                     |
| Components | Monitors      | Samsung SyncMaster 941BW |