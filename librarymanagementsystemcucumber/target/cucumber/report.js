$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("admin.feature");
formatter.feature({
  "line": 1,
  "name": "After Admin logged in he can perform few operations like addBook, addUser, updateBook, removeBook, IssueBook, searchBook, showUsers, showBooks, showRequests",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 8,
  "name": "Adding User",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-user",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Admin is on add user page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Admin enter User Details like \u003cusername\u003e, \u003cemail\u003e, \u003cpassword\u003e, \u003cdepartment\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User Added Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 13,
  "name": "",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-user;",
  "rows": [
    {
      "cells": [
        "username",
        "email",
        "password",
        "department"
      ],
      "line": 14,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-user;;1"
    },
    {
      "cells": [
        "\"asd\"",
        "\"1231456@gmail.com\"",
        "\"122222\"",
        "\"cse\""
      ],
      "line": 15,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-user;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 42589157000,
  "status": "passed"
});
formatter.before({
  "duration": 35049443800,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"sushma@gmail.com\", \"sushma\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin should be able to logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 7168520200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sushma@gmail.com",
      "offset": 13
    },
    {
      "val": "sushma",
      "offset": 33
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 6910153200,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_able_to_logged_in()"
});
formatter.result({
  "duration": 312502600,
  "error_message": "java.lang.AssertionError: Admin  is not at login page\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.capgemini.librarymanagementsystemcucumber.steps.AdminSteps.admin_should_be_able_to_logged_in(AdminSteps.java:65)\r\n\tat ✽.Then Admin should be able to logged in(admin.feature:6)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 15,
  "name": "Adding User",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-user;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 9,
  "name": "Admin is on add user page",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "Admin enter User Details like \"asd\", \"1231456@gmail.com\", \"122222\", \"cse\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "User Added Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_add_user_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "asd",
      "offset": 31
    },
    {
      "val": "1231456@gmail.com",
      "offset": 38
    },
    {
      "val": "122222",
      "offset": 59
    },
    {
      "val": "cse",
      "offset": 69
    }
  ],
  "location": "AdminSteps.admin_enter_User_Details_like(String,String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.user_Added_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 17,
  "name": "Adding Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Admin is on add book page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Admin enters Book Details like \u003cbookName\u003e, \u003cbookAuthor\u003e, \u003cbookCategory\u003e, \u003cbookPublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book Added Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-book;",
  "rows": [
    {
      "cells": [
        "bookName",
        "bookAuthor",
        "bookCategory",
        "bookPublisher"
      ],
      "line": 23,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-book;;1"
    },
    {
      "cells": [
        "\"Phython\"",
        "\"Mark Lutz\"",
        "\"cse\"",
        "\"Shroff\""
      ],
      "line": 24,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 77636985800,
  "status": "passed"
});
formatter.before({
  "duration": 35759404200,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"sushma@gmail.com\", \"sushma\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin should be able to logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 5370234200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sushma@gmail.com",
      "offset": 13
    },
    {
      "val": "sushma",
      "offset": 33
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 7820530000,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_able_to_logged_in()"
});
formatter.result({
  "duration": 811857800,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Adding Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;adding-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 18,
  "name": "Admin is on add book page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Admin enters Book Details like \"Phython\", \"Mark Lutz\", \"cse\", \"Shroff\"",
  "matchedColumns": [
    0,
    1,
    2,
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "Book Added Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_add_book_page()"
});
formatter.result({
  "duration": 6505755400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Phython",
      "offset": 32
    },
    {
      "val": "Mark Lutz",
      "offset": 43
    },
    {
      "val": "cse",
      "offset": 56
    },
    {
      "val": "Shroff",
      "offset": 63
    }
  ],
  "location": "AdminSteps.admin_enters_Book_Details_like(String,String,String,String)"
});
formatter.result({
  "duration": 6210021300,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_Added_Successfully()"
});
formatter.result({
  "duration": 380000,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Updating Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;updating-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "Admin is on get all books page",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "Books has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Admin is on update book page",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Admin enters Book Details like \u003cbookId\u003e, \u003cbookName\u003e, \u003cbookAuthor\u003e, \u003cbookCategory\u003e, \u003cbookPublisher\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Book Upated Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;updating-book;",
  "rows": [
    {
      "cells": [
        "bookId",
        "bookName",
        "bookAuthor",
        "bookCategory",
        "bookPublisher"
      ],
      "line": 34,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;updating-book;;1"
    },
    {
      "cells": [
        "95",
        "\"Networks\"",
        "\"MichaelSteer\"",
        "\"ECE\"",
        "\"ncsul University\""
      ],
      "line": 35,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;updating-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 28168420600,
  "status": "passed"
});
formatter.before({
  "duration": 42591778000,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"sushma@gmail.com\", \"sushma\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin should be able to logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 5355739700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sushma@gmail.com",
      "offset": 13
    },
    {
      "val": "sushma",
      "offset": 33
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 8211621200,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_able_to_logged_in()"
});
formatter.result({
  "duration": 208019400,
  "status": "passed"
});
formatter.scenario({
  "line": 35,
  "name": "Updating Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;updating-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 27,
  "name": "Admin is on get all books page",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "Books has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Admin is on update book page",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "Admin enters Book Details like 95, \"Networks\", \"MichaelSteer\", \"ECE\", \"ncsul University\"",
  "matchedColumns": [
    0,
    1,
    2,
    3,
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Book Upated Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_get_all_books_page()"
});
formatter.result({
  "duration": 15165954700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.books_has_found_Successfully()"
});
formatter.result({
  "duration": 248700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_is_on_update_book_page()"
});
formatter.result({
  "duration": 6758912800,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "95",
      "offset": 31
    },
    {
      "val": "Networks",
      "offset": 36
    },
    {
      "val": "MichaelSteer",
      "offset": 48
    },
    {
      "val": "ECE",
      "offset": 64
    },
    {
      "val": "ncsul University",
      "offset": 71
    }
  ],
  "location": "AdminSteps.admin_enters_Book_Details_like(int,String,String,String,String)"
});
formatter.result({
  "duration": 5762918700,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.book_Upated_Successfully()"
});
formatter.result({
  "duration": 132300,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 37,
  "name": "Deleting Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;deleting-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 38,
  "name": "Admin is on get all books page",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Books has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "Admin is on delete book page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "Admin enters \u003cbookId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "Book Deleted Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 44,
  "name": "",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;deleting-book;",
  "rows": [
    {
      "cells": [
        "bookId"
      ],
      "line": 45,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;deleting-book;;1"
    },
    {
      "cells": [
        "146"
      ],
      "line": 46,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;deleting-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 135721954200,
  "status": "passed"
});
formatter.before({
  "duration": 32853098100,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"sushma@gmail.com\", \"sushma\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin should be able to logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "duration": 5462942200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "sushma@gmail.com",
      "offset": 13
    },
    {
      "val": "sushma",
      "offset": 33
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "duration": 7074574000,
  "status": "passed"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_able_to_logged_in()"
});
formatter.result({
  "duration": 603862700,
  "error_message": "java.lang.AssertionError: Admin  is not at login page\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.assertTrue(Assert.java:41)\r\n\tat com.capgemini.librarymanagementsystemcucumber.steps.AdminSteps.admin_should_be_able_to_logged_in(AdminSteps.java:65)\r\n\tat ✽.Then Admin should be able to logged in(admin.feature:6)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 46,
  "name": "Deleting Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;deleting-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 38,
  "name": "Admin is on get all books page",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "Books has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "Admin is on delete book page",
  "keyword": "Given "
});
formatter.step({
  "line": 41,
  "name": "Admin enters 146",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "Book Deleted Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_get_all_books_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.books_has_found_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.admin_is_on_delete_book_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "146",
      "offset": 13
    }
  ],
  "location": "AdminSteps.admin_enters(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.book_Deleted_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 48,
  "name": "Issuing Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;issuing-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 49,
  "name": "Admin is on get all requests page",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "Requests has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "Admin is on issue book page",
  "keyword": "Given "
});
formatter.step({
  "line": 52,
  "name": "Admin enters requestId \u003crequestId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 53,
  "name": "Book Issued Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 55,
  "name": "",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;issuing-book;",
  "rows": [
    {
      "cells": [
        "requestId"
      ],
      "line": 56,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;issuing-book;;1"
    },
    {
      "cells": [
        "137"
      ],
      "line": 57,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;issuing-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 324471460700,
  "error_message": "org.openqa.selenium.TimeoutException: timeout\n  (Session info: chrome\u003d83.0.4103.97)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.18362 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nBuild info: version: \u00273.11.0\u0027, revision: \u0027e59cfb3\u0027, time: \u00272018-03-11T20:26:55.152Z\u0027\nSystem info: host: \u0027SOLTIVW\u0027, ip: \u0027192.168.43.155\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_241\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, acceptSslCerts: false, applicationCacheEnabled: false, browserConnectionEnabled: false, browserName: chrome, chrome: {chromedriverVersion: 2.42.591088 (7b2b2dca23cca0..., userDataDir: C:\\Users\\User\\AppData\\Local...}, cssSelectorsEnabled: true, databaseEnabled: false, goog:chromeOptions: {debuggerAddress: localhost:58658}, handlesAlerts: true, hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, setWindowRect: true, takesHeapSnapshot: true, takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , version: 83.0.4103.97, webStorageEnabled: true}\nSession ID: 5a61ba10bbbcec9df9d3c6b2277028fb\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:214)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:166)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:80)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:44)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:158)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:83)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.get(RemoteWebDriver.java:273)\r\n\tat com.capgemini.librarymanagementsystemcucumber.steps.UserSteps.openBrowser(UserSteps.java:32)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runtime.Runtime.runHookIfTagsMatch(Runtime.java:224)\r\n\tat cucumber.runtime.Runtime.runHooks(Runtime.java:212)\r\n\tat cucumber.runtime.Runtime.runBeforeHooks(Runtime.java:202)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:40)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ExamplesRunner.run(ExamplesRunner.java:59)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.ScenarioOutlineRunner.run(ScenarioOutlineRunner.java:53)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)\r\n\tat org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:542)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)\r\n\tat org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)\r\n",
  "status": "failed"
});
formatter.before({
  "duration": 314088980900,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"sushma@gmail.com\", \"sushma\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin should be able to logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "sushma@gmail.com",
      "offset": 13
    },
    {
      "val": "sushma",
      "offset": 33
    }
  ],
  "location": "AdminSteps.admin_gives(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.admin_should_be_able_to_logged_in()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 57,
  "name": "Issuing Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;issuing-book;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 49,
  "name": "Admin is on get all requests page",
  "keyword": "Given "
});
formatter.step({
  "line": 50,
  "name": "Requests has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 51,
  "name": "Admin is on issue book page",
  "keyword": "Given "
});
formatter.step({
  "line": 52,
  "name": "Admin enters requestId 137",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 53,
  "name": "Book Issued Successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_get_all_requests_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.requests_has_found_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.admin_is_on_issue_book_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "137",
      "offset": 23
    }
  ],
  "location": "AdminSteps.admin_enters_requestId(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "AdminSteps.book_Issued_Successfully()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 59,
  "name": "Searching Book",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;searching-book",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 60,
  "name": "Admin is on get all books page",
  "keyword": "Given "
});
formatter.step({
  "line": 61,
  "name": "Books has found Successfully",
  "keyword": "Then "
});
formatter.step({
  "line": 62,
  "name": "Admin is on search book page",
  "keyword": "Given "
});
formatter.step({
  "line": 63,
  "name": "Admin enters Book Id for search \u003cbookId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 64,
  "name": "Book has found Successfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 66,
  "name": "",
  "description": "",
  "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;searching-book;",
  "rows": [
    {
      "cells": [
        "bookId"
      ],
      "line": 67,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;searching-book;;1"
    },
    {
      "cells": [
        "93"
      ],
      "line": 68,
      "id": "after-admin-logged-in-he-can-perform-few-operations-like-addbook,-adduser,-updatebook,-removebook,-issuebook,-searchbook,-showusers,-showbooks,-showrequests;searching-book;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 23885105300,
  "status": "passed"
});
formatter.before({
  "duration": 22011557400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Admin is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Admin gives \"sushma@gmail.com\", \"sushma\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Admin should be able to logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "AdminSteps.admin_is_on_login_page()"
});
