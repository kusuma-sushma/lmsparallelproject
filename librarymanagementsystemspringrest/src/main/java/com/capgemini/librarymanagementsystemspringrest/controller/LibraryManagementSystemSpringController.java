package com.capgemini.librarymanagementsystemspringrest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystemspringrest.dto.BooksInformation;
import com.capgemini.librarymanagementsystemspringrest.dto.LibraryManagementSystemResponse;
import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;
import com.capgemini.librarymanagementsystemspringrest.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemspringrest.service.AdminService;
import com.capgemini.librarymanagementsystemspringrest.service.UserService;

@RestController
@CrossOrigin("http://localhost:4200")
public class LibraryManagementSystemSpringController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;

	@GetMapping(path = "/getBook", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getBook(int bookId) {
		BooksInformation bookInfo = adminService.searchBook(bookId);
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (bookInfo != null) {
			response.setBookInfo(bookInfo);
		} else {
			response.setError(true);
			response.setMessage("BookId which was given not present in the library");
		}
		return response;
	}

	@PostMapping(path = "/addUser", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse addUser(@RequestBody UserInformation userInfo) {
		boolean isAdded = adminService.addUser(userInfo);
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (isAdded) {
			response.setMessage("User Added Successfully");
		} else {
			response.setError(true);
			response.setMessage("User Email Id is already present. Unable to add user");
		}
		return response;
	}

	@PostMapping(path = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse addBook(@RequestBody BooksInformation bookInfo) {
		boolean isAdded = adminService.addBook(bookInfo);
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (isAdded) {
			response.setMessage("Book Added Successfully");
		} else {
			response.setError(true);
			response.setMessage("Book Details which was given is already present. Unable to add book");
		}
		return response;
	}

	@GetMapping(path = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getAllUsers() {
		List<UserInformation> userList = adminService.showAllUsers();
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (userList != null && !userList.isEmpty()) {
			response.setUsersList(userList);
		} else {
			response.setError(true);
			response.setMessage("No Users are present in the library");
		}
		return response;
	}

	@GetMapping(path = "/getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getAllBooks() {
		List<BooksInformation> bookList = adminService.showAllBooks();
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (bookList != null && !bookList.isEmpty()) {
			response.setBooksList(bookList);
		} else {
			response.setError(true);
			response.setMessage("No Books are present in the library");
		}
		return response;
	}

	@GetMapping(path = "/getAllRequests", produces = MediaType.APPLICATION_JSON_VALUE)
	public LibraryManagementSystemResponse getAllRequests() {
		List<UserRequestInformation> userRequestList = adminService.showAllRequests();
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (userRequestList != null && !userRequestList.isEmpty()) {
			response.setUsersRequestList(userRequestList);
		} else {
			response.setError(true);
			response.setMessage("No Users Requests are present in the library");
		}
		return response;
	}

	@PutMapping(path = "/updateBook", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse updateBook(@RequestBody BooksInformation bookInfo) {
		boolean isUpdate = adminService.updateBook(bookInfo);
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (isUpdate) {
			response.setMessage("Book Updated successfully");
		} else {
			response.setError(true);
			response.setMessage("Book Id doesn't match, book can't be updated!");
		}
		return response;

	}

	@DeleteMapping(path = "/deleteBook/{bookId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse deleteBook(@PathVariable(name = "bookId") int bookId) {
		boolean isDeleted = adminService.removeBook(bookId);
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (isDeleted) {
			response.setMessage("BookId" + bookId);
			response.setMessage("Book Deleted successfully");
		} else {
			response.setError(true);
			response.setMessage("Book id which was given is not present in the library" + bookId);
		}
		return response;

	}

	@PostMapping(path = "/adminLogin", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse adminLogin(@RequestBody Map<String, String> inputJson) {
		UserInformation adminLogin = adminService.adminLogin(inputJson.get("email"), inputJson.get("password"));
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (adminLogin != null) {
			response.setMessage("Admin Logged in Successfully");
			response.setUserInfo(adminLogin);
		} else {
			response.setError(true);
			response.setMessage("Credentials which was given is invalid, Unable to login");
		}
		return response;
	}

	@PostMapping(path = "/userLogin", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse userLogin(@RequestBody Map<String, String> inputJson) {
		UserInformation userLogin = userService.userLogin(inputJson.get("email"), inputJson.get("password"));
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (userLogin != null) {
			response.setMessage("User Logged in Successfully");
			response.setUserInfo(userLogin);
		} else {
			response.setError(true);
			response.setMessage("User Details which was given is invalid, Unable to login");
		}
		return response;
	}

	@PostMapping(path = "/issueBook", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse issueBook(@RequestBody UserRequestInformation requestInfo) {
		boolean issued = adminService.issueBook(requestInfo.getRequestId());
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (issued) {
			response.setMessage("Book Issued to the User Successfully");
		} else {
			response.setError(true);
			response.setMessage("Book has already issued to user");
		}
		return response;
	}

	@PostMapping(path = "/borrowBook/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse borrowBook(@RequestBody BooksInformation bookInfo,
			@PathVariable int userId) {
		boolean borrow = userService.borrowBook(userId, bookInfo.getBookId());
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (borrow) {
			response.setMessage("Request has been send to admin");
		} else {
			response.setError(true);
			response.setMessage("Unable to make request!");
		}
		return response;
	}

	@PostMapping(path = "/returnBook/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public LibraryManagementSystemResponse returnBook(@RequestBody UserRequestInformation requestInfo,
			@PathVariable int userId) {
		boolean returning = userService.returnBook(userId, requestInfo.getBookId());
		LibraryManagementSystemResponse response = new LibraryManagementSystemResponse();
		if (returning) {
			response.setMessage("Returned Book to admin Successfully ");
		} else {
			response.setError(true);
			response.setMessage("Book hasn't issued yet!");
		}
		return response;
	}

}
