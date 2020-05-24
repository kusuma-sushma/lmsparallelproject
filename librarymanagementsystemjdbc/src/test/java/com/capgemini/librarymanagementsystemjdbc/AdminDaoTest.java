package com.capgemini.librarymanagementsystemjdbc;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDao;
import com.capgemini.librarymanagementsystemjdbc.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public class AdminDaoTest {
	AdminDao dao = new AdminDaoImplementation();

	@Test
	public void testAddUser() {
		UserInformation userInfo = new UserInformation();
		userInfo.setUserId(2);
		userInfo.setUsername("reshma");
		userInfo.setPassword("reshma");
		userInfo.setEmail("reshma@gmail.com");
		userInfo.setDepartment("ece");
		userInfo.setNoOfBooks(0);
		userInfo.setRole("student");
		boolean status = false;
		try {
			status = dao.addUser(userInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
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
		userInfo.setNoOfBooks(0);
		userInfo.setRole("student");
		boolean status = false;
		try {
			status = dao.addUser(userInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
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
		boolean status = false;
		try {
			status = dao.addBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
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
		boolean status = false;
		try {
			status = dao.addBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testAdminLogin() {
		UserInformation status = null;
		try {
			status = dao.adminLogin("sushma@gmail.com", "sushma");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testAdminLoginFalse() {
		UserInformation status = null;
		try {
			status = dao.adminLogin("sushma123@gmail.com", "sushma123");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testRemoveBook() {
		boolean status = false;
		try {
			status = dao.removeBook(123456);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBookFalse() {
		boolean status = false;
		try {
			status = dao.removeBook(121212);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testIssueBook() {
		boolean status = false;
		try {
			status = dao.issueBook(121212);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssueBookFalse() {
		boolean status = false;
		try {
			status = dao.issueBook(121212);
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
			status = dao.updateBook(bookInfo);
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
			status = dao.updateBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testSearchBook() {
		BooksInformation status = null;
		try {
			status = dao.searchBook(123455);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchBookFalse() {
		BooksInformation status = null;
		try {
			status = dao.searchBook(11);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testshowallusers() {
		List<UserInformation> users = null;
		try {
			users = dao.showAllUsers();
		} catch (LibraryManagementSystemException e) {
			users = null;
		}
		Assertions.assertNotNull(users);
	}

	@Test
	public void testshowallusersFalse() {
		List<UserInformation> users = null;
		try {
			users = dao.showAllUsers();
		} catch (LibraryManagementSystemException e) {
			users = null;
		}
		Assertions.assertNotEquals(null, users);
	}

	@Test
	public void testshowallbooks() {
		List<BooksInformation> books = null;
		try {
			books = dao.showAllBooks();
		} catch (LibraryManagementSystemException e) {
			books = null;
		}
		Assertions.assertNotNull(books);
	}

	@Test
	public void testshowallbooksFalse() {
		List<BooksInformation> books = null;
		try {
			books = dao.showAllBooks();
		} catch (LibraryManagementSystemException e) {
			books = null;
		}
		Assertions.assertNotEquals(null, books);
	}

	@Test
	public void testshowallrequests() {
		List<UserRequestInformation> requests = null;
		try {
			requests = dao.showAllRequests();
		} catch (LibraryManagementSystemException e) {
			requests = null;
		}
		Assertions.assertNotNull(requests);
	}

	@Test
	public void testshowallrequestsFalse() {
		List<UserRequestInformation> requests = null;
		try {
			requests = dao.showAllRequests();
		} catch (LibraryManagementSystemException e) {
			requests = null;
		}
		Assertions.assertNotEquals(null, requests);
	}

}
