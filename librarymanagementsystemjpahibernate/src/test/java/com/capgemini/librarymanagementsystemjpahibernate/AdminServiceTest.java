package com.capgemini.librarymanagementsystemjpahibernate;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjpahibernate.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjpahibernate.service.AdminService;
import com.capgemini.librarymanagementsystemjpahibernate.service.AdminServiceImplementation;

public class AdminServiceTest {
	AdminService service = new AdminServiceImplementation();

	@Test
	public void testAddUser() {
		UserInformation userInfo = new UserInformation();
		userInfo.setUserId(1);
		userInfo.setUsername("kiara");
		userInfo.setPassword("kiara");
		userInfo.setEmail("kiara@gmail.com");
		userInfo.setDepartment("ece");
		userInfo.setNoOfBooksBorrowed(0);
		boolean status = service.addUser(userInfo);
		Assertions.assertTrue(status);
	}

	@Test
	public void testAddUserFalse() {
		UserInformation userInfo = new UserInformation();
		userInfo.setUserId(1);
		userInfo.setUsername("kiara");
		userInfo.setPassword("kiara");
		userInfo.setEmail("kiara@gmail.com");
		userInfo.setDepartment("ece");
		userInfo.setNoOfBooksBorrowed(0);
		boolean status = service.addUser(userInfo);
		Assertions.assertFalse(status);
	}

	@Test
	public void testAddBook() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookId(1);
		bookInfo.setBookName("java");
		bookInfo.setBookAuthor("charles");
		bookInfo.setBookCategory("tech");
		bookInfo.setBookPublisher("ms");
		bookInfo.setBookAvailable(true);
		boolean status = service.addBook(bookInfo);
		Assertions.assertTrue(status);
	}

	@Test
	public void testAddBookFalse() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookId(1);
		bookInfo.setBookName("java");
		bookInfo.setBookAuthor("charles");
		bookInfo.setBookCategory("tech");
		bookInfo.setBookPublisher("ms");
		bookInfo.setBookAvailable(true);
		boolean status = service.addBook(bookInfo);
		Assertions.assertFalse(status);
	}

	@Test
	public void testAdminLogin() {
		UserInformation status = null;
		try {
			status = service.adminLogin("sushma@gmail.com", "sushma");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testAdminLoginFalse() {
		UserInformation status = null;
		try {
			status = service.adminLogin("sushma123@gmail.com", "sushma123");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testRemoveBook() {
		boolean status = false;
		try {
			status = service.removeBook(1);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBookFalse() {
		boolean status = false;
		try {
			status = service.removeBook(11);
		} catch (LibraryManagementSystemException e) {
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testIssueBook() {
		boolean status = false;
		try {
			status = service.issueBook(121212);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssueBookFalse() {
		boolean status = false;
		try {
			status = service.issueBook(121212);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testUpdateBook() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookAuthor("sushma");
		boolean status = false;
		try {
			status = service.updateBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testUpdateBookFalse() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookAuthor("sushma");
		boolean status = false;
		try {
			status = service.updateBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testSearchBook() {
		BooksInformation status = service.searchBook(121212);
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchBookFalse() {
		BooksInformation status = service.searchBook(11);
		Assertions.assertNull(status);
	}

	@Test
	public void testshowallusers() {
		List<UserInformation> users = null;
		try {
			users = service.showAllUsers();
		} catch (LibraryManagementSystemException e) {
			users = null;
		}
		Assertions.assertNotNull(users);
	}

	@Test
	public void testshowallusersFalse() {
		List<UserInformation> users = null;
		try {
			users = service.showAllUsers();
		} catch (LibraryManagementSystemException e) {
			users = null;
		}
		Assertions.assertNotEquals(null, users);
	}

	@Test
	public void testshowallbooks() {
		List<BooksInformation> books = null;
		try {
			books = service.showAllBooks();
		} catch (LibraryManagementSystemException e) {
			books = null;
		}
		Assertions.assertNotNull(books);
	}

	@Test
	public void testshowallbooksFalse() {
		List<BooksInformation> books = null;
		try {
			books = service.showAllBooks();
		} catch (LibraryManagementSystemException e) {
			books = null;
		}
		Assertions.assertNotEquals(null, books);
	}

	@Test
	public void testshowallrequests() {
		List<UserRequestInformation> requests = null;
		try {
			requests = service.showAllRequests();
		} catch (LibraryManagementSystemException e) {
			requests = null;
		}
		Assertions.assertNotNull(requests);
	}

	@Test
	public void testshowallrequestsFalse() {
		List<UserRequestInformation> requests = null;
		try {
			requests = service.showAllRequests();
		} catch (LibraryManagementSystemException e) {
			requests = null;
		}
		Assertions.assertNotEquals(null, requests);
	}

}
