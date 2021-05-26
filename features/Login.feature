Feature: Login Page

  Scenario: Login and Logout validation
    Given user launch the "Chrome" browser
    When user Launch the URL "https://www.nopcommerce.com/en/login"
    And user enters username as "Mathesh123" and password as "Math@esh02"
    And user click on Login Button
    Then user click on Logout Button
    Then verify page tile
    Then close the browser
