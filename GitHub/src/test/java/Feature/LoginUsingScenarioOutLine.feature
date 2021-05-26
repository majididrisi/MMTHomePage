Feature: Login Functionality

Background: Click on Login Link
Given User is on landing page
And User clicks on Login Link

@MultipleValidLogins
Scenario Outline: Log in to OpenCart website

And User enters "<email>" and "<password>"
When User click on Login button
Then User logs-in in to website and home page is displayed

Examples:
|email             |password  |
|guest@guest.com   |12345     |
|guest1@guest.com  |12345     |
|guest2@guest.com  |12345     |

@MultipleInvalidLogins
Scenario Outline: Log in to OpenCart website

And User enters invalid "<email>" and "<password>"
When User click on Login button
Then User is not able to Login to the website and Warning message is displayed

Examples:
|email             |password  |
|guest@guest.com   |1ssss     |
|guest1@guest.com  |          |
|guest2@guest.com  |ajdjd     |
