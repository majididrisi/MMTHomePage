Feature: Buy product
This feature describes functionality of buying various products

Background: Login Function
Given User is on landing page
And User clicks on Login Link
And User enters email id and password
When User click on Login button
And User logs-in in to website and home page is displayed

@FunctionalTest @Mac
Scenario: Buy Mac
And User selects Mac as product
And User click on Add-to Cart button for Mac
Then Product Mac gets added to Shopping cart

@FunctionalTest @Monitor
Scenario: Buy Samsung Monitor
And User selects Samsung SyncMaster 941BW Monitor as product
And User click on Add-to Cart button for Samsung SyncMaster 941BW Monitor
Then Product Samsung SyncMaster 941BW Monitor gets added to Shopping cart