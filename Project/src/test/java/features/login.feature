Feature: Application login

  Scenario Outline: Positive test validating login
    Given initialize browser with chrome
    And navigate to "http://qaclickacademy.com" site
    And Click on login link in home page to land on sign in Page
    When user enters <username> and <password> and <text> and log in
    Then navigate to the "https://qaclickacademy.usefedora.com/" site
    Then verify that user is successfully logged in
    Then Browser have to close

    Examples: 
      | username              | password | text  |
      | test99@gmail.com      |   123456 | love  |
      | mangathaman@gmail.com |    98765 | hurts |
