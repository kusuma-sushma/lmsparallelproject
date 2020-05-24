package com.capgemini.librarymanagementsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dao.UserDao;
import com.capgemini.librarymanagementsystem.dao.UserDaoImplementation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;

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
			status = dao.userLogin("padma123@gmail.com", "padma123");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testBorrowBook() {
		UserRequestInformation status = null;
		try {
			status = dao.borrowBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testBorrowBookFalse() {
		UserRequestInformation status = null;
		try {
			status = dao.borrowBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testReturnBook() {
		UserRequestInformation status = null;
		try {
			status = dao.returnBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testReturnBookFalse() {
		UserRequestInformation status = null;
		try {
			status = dao.returnBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

}
