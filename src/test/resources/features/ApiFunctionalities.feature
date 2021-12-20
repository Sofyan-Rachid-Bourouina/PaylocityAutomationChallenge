Feature: Get Employee List

  @api
  Scenario: Get All Employee List
    Given I logged into Paylocity api using "TestUser101" and "e@H}6fvqtr*9"
    When I send GET request to "/Prod/api/employees" endpoint
    Then status code should be 200
    And I should be able to see list of employees
      | 0443a978-c52e-43ab-a4a3-7c4c0f6199ed |
      | 8adc0468-c1f5-44f0-a372-ce61658949e7 |
      | a0b065bf-ca0e-44a6-83c5-c88166dc3e7f |
      | a6b37210-04f5-46ba-98e1-efe87c76a545 |
      | f28f7939-6d7a-48fd-bf56-ea490350ff33 |
      | f6de702b-74d3-4250-9255-e7ab94ae439c |












