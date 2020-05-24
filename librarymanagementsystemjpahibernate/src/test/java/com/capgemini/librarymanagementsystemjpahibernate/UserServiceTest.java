package com.capgemini.librarymanagementsystemjpahibernate;
//import org.junit.jupiter.api.Assertions;

//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjpahibernate.service.UserService;
import com.capgemini.librarymanagementsystemjpahibernate.service.UserServiceImplementation;

public class UserServiceTest {

	UserService service = new UserServiceImplementation();

	@Test
	public void testUserLogin() {
		UserInformation status = null;
		try {
			status = service.userLogin("akhil@gmail.com", "akhil1");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testUserLoginFalse() {
		UserInformation status = null;
		try {
			status = service.userLogin("padma123@gmail.com", "padma123");
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testBorrowBook() {
		boolean status = false;
		try {
			status = service.borrowBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testBorrowBookFalse() {
		boolean status = false;
		try {
			status = service.borrowBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
		}
		Assertions.assertFalse(status);
	}

	@Test
	public void testReturnBook() {
		boolean status = false;
		try {
			status = service.returnBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertTrue(status);
	}

	@Test
	public void testReturnBookFalse() {
		boolean status = false;
		try {
			status = service.returnBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = false;
		}
		Assertions.assertFalse(status);
	}
}
