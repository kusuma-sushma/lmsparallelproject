Feature: Ater User Login he performs Operations like Request a Book and Return a Book

  Background: 
    Given User is on login page
    When User gives "akhil@gmail.com", "akhil1"
    Then User should be logged in

  Scenario Outline: Request a Book
    Given User is on Book Request page
    When User Requests a Book by entering details bookId <bookId>
    Then User placed the Request Successfully

    Examples: 
      | bookId |
      |    145 |

  Scenario Outline: Return a Book
    Given User is on Book Return page
    When User Returns a Book by entering details bookId <bookId>
    Then User Returned Book Successfully

    Examples: 
      | bookId |
      |     64 |
