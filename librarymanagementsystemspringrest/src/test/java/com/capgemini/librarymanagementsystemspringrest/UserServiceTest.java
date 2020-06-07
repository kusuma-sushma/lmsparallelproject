package com.capgemini.librarymanagementsystemspringrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;
import com.capgemini.librarymanagementsystemspringrest.service.UserService;
import com.capgemini.librarymanagementsystemspringrest.service.UserServiceImplementation;

public class UserServiceTest {
	@Autowired
	private UserService service = new UserServiceImplementation();

	@Test
	public void testUserLogin() {
		UserInformation status = service.userLogin("padma@gmail.com", "padma1");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testUserLoginFalse() {
		UserInformation status = service.userLogin("padma123@gmail.com", "padma123");
		Assertions.assertNull(status);
	}

	@Test
	public void testBorrowBook() {
		boolean status = service.borrowBook(22, 64);
		Assertions.assertTrue(status);
	}

	@Test
	public void testBorrowBookFalse() {
		boolean status = service.borrowBook(22, 64);
		Assertions.assertFalse(status);
	}

	@Test
	public void testReturnBook() {
		boolean status = service.returnBook(22, 64);
		Assertions.assertTrue(status);
	}

	@Test
	public void testReturnBookFalse() {
		boolean status = service.returnBook(22, 64);
		Assertions.assertFalse(status);
	}

}
