@foo
Feature: Pico y Placa Checker

  Background: Checker enable
    Given a checker initialized

  Scenario: Positive
    When I check "2020-04-06 14:30" and "STB0315" 
    Then the result is "true"

   Scenario: Negative
     When I check "2020-04-08 17:30" and "XLT0725" 
     Then the result is "false"

   Scenario: Negative
     When I check "2020-04-14 17:30" and "XLT0724" 
     Then the result is "false"

  Scenario: Saturday positive
     When I check "2020-04-25 10:30" and "XLT0729" 
     Then the result is "true"


Scenario: positive
     When I check "2020-04-13 07:30" and "XLT0721" 
     Then the result is "true"     