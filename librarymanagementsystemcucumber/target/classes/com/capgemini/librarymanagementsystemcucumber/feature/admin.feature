Feature: After Admin logged in he can perform few operations like addBook, addUser, updateBook, removeBook, IssueBook, searchBook, showUsers, showBooks, showRequests

  Background: 
    Given Admin is on login page
    When Admin gives "sushma@gmail.com", "sushma"
    Then Admin should be able to logged in

  Scenario Outline: Adding User
    Given Admin is on add user page
    When Admin enter User Details like <username>, <email>, <password>, <department>
    Then User Added Successfully

    Examples: 
      | username | email               | password | department |
      | "asd"    | "1231456@gmail.com" | "122222" | "cse"      |

  Scenario Outline: Adding Book
    Given Admin is on add book page
    When Admin enters Book Details like <bookName>, <bookAuthor>, <bookCategory>, <bookPublisher>
    Then Book Added Successfully

    Examples: 
      | bookName  | bookAuthor  | bookCategory | bookPublisher |
      | "Phython" | "Mark Lutz" | "cse"        | "Shroff"      |

  Scenario Outline: Updating Book
    Given Admin is on get all books page
    Then Books has found Successfully
    Given Admin is on update book page
    When Admin enters Book Details like <bookId>, <bookName>, <bookAuthor>, <bookCategory>, <bookPublisher>
    Then Book Upated Successfully

    Examples: 
      | bookId | bookName   | bookAuthor     | bookCategory | bookPublisher      |
      |     95 | "Networks" | "MichaelSteer" | "ECE"        | "ncsul University" |

  Scenario Outline: Deleting Book
    Given Admin is on get all books page
    Then Books has found Successfully
    Given Admin is on delete book page
    When Admin enters <bookId>
    Then Book Deleted Successfully

    Examples: 
      | bookId |
      |    146 |

  Scenario Outline: Issuing Book
    Given Admin is on get all requests page
    Then Requests has found Successfully
    Given Admin is on issue book page
    When Admin enters requestId <requestId>
    Then Book Issued Successfully

    Examples: 
      | requestId |
      |       137 |

  Scenario Outline: Searching Book
    Given Admin is on get all books page
    Then Books has found Successfully
    Given Admin is on search book page
    When Admin enters Book Id for search <bookId>
    Then Book has found Successfully

    Examples: 
      | bookId |
      |     93 |

  Scenario Outline: Get All Users
    Given Admin is on get all users page
    Then Users has found Successfully
