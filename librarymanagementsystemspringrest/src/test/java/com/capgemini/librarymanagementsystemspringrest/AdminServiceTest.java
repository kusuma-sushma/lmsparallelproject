package com.capgemini.librarymanagementsystemspringrest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemspringrest.dto.BooksInformation;
import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;
import com.capgemini.librarymanagementsystemspringrest.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemspringrest.service.AdminService;
import com.capgemini.librarymanagementsystemspringrest.service.AdminServiceImplementation;

public class AdminServiceTest {
	private AdminService service = new AdminServiceImplementation();

	@Test
	public void testAddUser() {
		UserInformation userInfo = new UserInformation();
		userInfo.setUserId(76);
		userInfo.setUsername("kiara");
		userInfo.setPassword("kiara");
		userInfo.setEmail("kiara@gmail.com");
		userInfo.setDepartment("ece");
		boolean status = service.addUser(userInfo);
		Assertions.assertTrue(status);
	}

	@Test
	public void testAddUserFalse() {
		UserInformation userInfo = new UserInformation();
		userInfo.setUserId(76);
		userInfo.setUsername("kiara");
		userInfo.setPassword("kiara");
		userInfo.setEmail("kiara@gmail.com");
		userInfo.setDepartment("ece");
		boolean status = service.addUser(userInfo);
		Assertions.assertFalse(status);
	}

	@Test
	public void testAddBook() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookId(68);
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
		bookInfo.setBookId(68);
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
		UserInformation status = service.adminLogin("sushma@gmail.com", "sushma");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testAdminLoginFalse() {
		UserInformation status = service.adminLogin("sushma123@gmail.com", "sushma123");
		Assertions.assertNull(status);
	}

	@Test
	public void testRemoveBook() {
		boolean status = service.removeBook(68);
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBookFalse() {
		boolean status = service.removeBook(123);
		Assertions.assertFalse(status);
	}

	@Test
	public void testIssueBook() {
		boolean status = service.issueBook(1212);
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssueBookFalse() {
		boolean status = service.issueBook(1212);
		Assertions.assertFalse(status);
	}

	@Test
	public void testUpdateBook() {
		BooksInformation bookInfo = new BooksInformation();
		boolean status = service.updateBook(bookInfo);
		Assertions.assertTrue(status);
	}

	@Test
	public void testUpdateBookFalse() {
		BooksInformation bookInfo = new BooksInformation();
		boolean status = service.updateBook(bookInfo);
		Assertions.assertFalse(status);
	}

	@Test
	public void testSearchBook() {
		BooksInformation status = service.searchBook(65);
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchBookFalse() {
		BooksInformation status = service.searchBook(123);
		Assertions.assertNull(status);
	}

	@Test
	public void testshowallusers() {
		List<UserInformation> users = service.showAllUsers();
		Assertions.assertNotNull(users);
	}

	@Test
	public void testshowallusersFalse() {
		List<UserInformation> users = service.showAllUsers();
		Assertions.assertNotEquals(null, users);
	}

	@Test
	public void testshowallbooks() {
		List<BooksInformation> books = service.showAllBooks();
		Assertions.assertNotNull(books);
	}

	@Test
	public void testshowallbooksFalse() {
		List<BooksInformation> books = service.showAllBooks();
		Assertions.assertNotEquals(null, books);
	}

	@Test
	public void testshowallrequests() {
		List<UserRequestInformation> requests = service.showAllRequests();
		Assertions.assertNotNull(requests);
	}

	@Test
	public void testshowallrequestsFalse() {
		List<UserRequestInformation> requests = service.showAllRequests();
		Assertions.assertNotEquals(null, requests);
	}

}
