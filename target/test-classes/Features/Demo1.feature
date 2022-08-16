Feature: Search functionality

  Background: 
    Given user verifies the launched application

  Scenario Outline: TC_01-To Validate the  the search functonality in swisscom website
    When User enters the "<deviceName>" in the searchbar and clicks on the search button
    Then User verifies the display of the iphone and verifies it
    When user tries to open a new tab and enters the "<newurl>"
    Then User verifies the display of iphonemini and clicks on it
    Then User verifies the different storage options for different colors
    Then User switches to second tab and enter "<Internet>" in search bar

    Examples: 
      | deviceName | newurl | Internet |
      | iphone     | url    | Internet |
