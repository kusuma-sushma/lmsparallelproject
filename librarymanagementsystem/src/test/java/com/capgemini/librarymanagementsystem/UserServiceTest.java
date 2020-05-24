package com.capgemini.librarymanagementsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.service.UserServiceImplementation;

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
		UserRequestInformation status = null;
		try {
			status = service.borrowBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testBorrowBookFalse() {
		UserRequestInformation status = null;
		try {
			status = service.borrowBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

	@Test
	public void testReturnBook() {
		UserRequestInformation status = null;
		try {
			status = service.returnBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNotNull(status);
	}

	@Test
	public void testReturnBookFalse() {
		UserRequestInformation status = null;
		try {
			status = service.returnBook(121212, 123123);
		} catch (LibraryManagementSystemException e) {
			status = null;
		}
		Assertions.assertNull(status);
	}

}
