Feature: UI login functionality

@ui
Scenario: Logging in to Paylocity Benefits Dashboard
Given user logs in using username "TestUser101" and password "e@H}6fvqtr*9"
And I click on Log in button
Then I should be able to see the Dashboard page"Employees - Paylocity Benefits Dashboard"