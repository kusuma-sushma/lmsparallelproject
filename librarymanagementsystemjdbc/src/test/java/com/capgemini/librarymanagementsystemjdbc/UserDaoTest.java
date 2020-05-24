package com.capgemini.librarymanagementsystemjdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDao;
import com.capgemini.librarymanagementsystemjdbc.dao.UserDaoImplementation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public class UserDaoTest {

	UserDao dao = new UserDaoImplementation();

	@Test
	public void testUserLogin() {
		UserInformation status = null;
		try {
			status = dao.userLogin("akhil@gmail.com", "akhil1");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testUserLoginFalse() {
		UserInformation status = null;
		try {
			status = dao.userLogin("akhil123@gmail.com", "akhil123");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testBorrowBook() {
		boolean status = false;
		try {
			status = dao.borrowBook(121212, 123455);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testBorrowBookFalse() {
		boolean status = false;
		try {
			status = dao.borrowBook(121212, 123455);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testReturnBook() {
		boolean status = false;
		try {
			status = dao.returnBook(121212, 123455);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testReturnBookFalse() {
		boolean status = false;
		try {
			status = dao.returnBook(121212, 123455);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}

}
