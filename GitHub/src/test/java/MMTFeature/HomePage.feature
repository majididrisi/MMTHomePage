Feature: Home Page Test case

Background: Open Landing page
Given User is on Landing page

@Home
Scenario: Logo, Header tab and Links

And Company Logo is displayed
Given All tabs on Header tab are displayed
And Click on Country tab
And Change Country
Then Changed Country is displayed


@Top
Scenario: Top menus

And Top menu with all tabs is displayed
And Click on each section and Check sections are Changing
Then Scroll Down to See Top pinned Menu

@links
Scenario:
Then Check for the availability of all the links on page


@Visa
Scenario: 
And Change to Visa Section
And Select Destination
And Select Dates
And Select Number of Travellers
Then Click on Search
