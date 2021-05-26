Feature: Login Functionality

@Login
Scenario: Log in to OpenCart website

Given User is on landing page
And User clicks on Login Link
And User enters email id and password
When User click on Login button
Then User logs-in in to website and home page is displayed

