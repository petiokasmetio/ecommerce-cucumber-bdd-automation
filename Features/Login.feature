Feature: Login

  Scenario: Successful Login with valid credentials
    Given User launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    When When User enter Email "admin@yourstore.com" and Password "admin"
    When Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    Then User click on logout link
    Then Page title should be "Your store. Login"
    Then close browser

Scenario Outline: Login Data Driven
  Given User launch Chrome browser
  When User open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
  When When User enter Email "<email>" and Password "<password>"
  When Click on Login
  Then Page title should be "Dashboard / nopCommerce administration"
  Then User click on logout link
  Then Page title should be "Your store. Login"
  Then close browser

  Examples:
      |email|password|
      |admin@yourstore.com|admin|
      |madmin123@yourstore.com|madmin12312|
