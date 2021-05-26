Feature: Login Functionality
@LoginFails
Scenario: Log in to OpenCart website

Given User is on landing page
And User clicks on Login Link
And User enters invalid email id and password
When User click on Login button
Then User is not able to Login to the website and Warning message is displayed
