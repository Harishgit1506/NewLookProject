Feature: Login Functinality of New Look Site
@test
 Scenario: Verify that user should not login with unvalid credentials.
    Given User launch site URL
    Then Verify the new look logo is present or not
    And Click on the user Account button
    When User enter unvalid username and password
    And user click on login button
    And verify the error message