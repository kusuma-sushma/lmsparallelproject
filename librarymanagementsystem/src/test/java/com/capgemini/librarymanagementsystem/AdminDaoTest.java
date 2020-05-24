package com.capgemini.librarymanagementsystem;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;

public class AdminDaoTest {
	AdminDao dao = new AdminDaoImplementation();

	@Test
	public void testAddUser() {
		UserInformation userInfo = new UserInformation();
		userInfo.setUserId(12);
		userInfo.setUsername("kiara");
		userInfo.setPassword("kiara");
		userInfo.setEmail("kiara@gmail.com");
		userInfo.setDepartment("ece");
		userInfo.setNoOfBooksBorrowed(0);
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
		userInfo.setUserId(12);
		userInfo.setUsername("kiara");
		userInfo.setPassword("kiara");
		userInfo.setEmail("kiara@gmail.com");
		userInfo.setDepartment("ece");
		userInfo.setNoOfBooksBorrowed(0);
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
		bookInfo.setBookId(12);
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
		bookInfo.setBookId(12);
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
		AdminInformation status = null;
		try {
			status = dao.adminLogin("sushma@gmail.com", "sushma");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testAdminLoginFalse() {
		AdminInformation status = null;
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
			status = dao.removeBook(1);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testRemoveBookFalse() {
		boolean status = false;
		try {
			status = dao.removeBook(11);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testIssueBook() {
		boolean status = false;
		try {
			status = dao.issueBook(121212, 123456);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testIssueBookFalse() {
		boolean status = false;
		try {
			status = dao.issueBook(121212, 123456);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testUpdateBook() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookAuthor("sushma");
		BooksInformation status = dao.updateBook(1);
		Assertions.assertNotNull(status);
	}

	@Test
	public void testUpdateBookFalse() {
		BooksInformation bookInfo = new BooksInformation();
		bookInfo.setBookAuthor("sushma");
		BooksInformation status = dao.updateBook(10);
		Assertions.assertNull(status);
	}

	@Test
	public void testSearchBook() {
		BooksInformation status = dao.searchBook(123123);
		Assertions.assertNotNull(status);
	}

	@Test
	public void testSearchBookFalse() {
		BooksInformation status = dao.searchBook(11);
		Assertions.assertNotEquals(null, status);
	}

	@Test
	public void testshowallusers() {
		List<UserInformation> users = dao.showAllUsers();
		Assertions.assertNotNull(users);
	}

	@Test
	public void testshowallusersFalse() {
		List<UserInformation> users = dao.showAllUsers();
		Assertions.assertNotEquals(null, users);
	}

	@Test
	public void testshowallbooks() {
		List<BooksInformation> books = dao.showAllBooks();
		Assertions.assertNotNull(books);
	}

	@Test
	public void testshowallbooksFalse() {
		List<BooksInformation> books = dao.showAllBooks();
		Assertions.assertNotEquals(null, books);
	}

	@Test
	public void testshowallrequests() {
		List<UserRequestInformation> requests = dao.showAllRequests();
		Assertions.assertNotNull(requests);
	}

	@Test
	public void testshowallrequestsFalse() {
		List<UserRequestInformation> requests = dao.showAllRequests();
		Assertions.assertNotEquals(null, requests);
	}
}
