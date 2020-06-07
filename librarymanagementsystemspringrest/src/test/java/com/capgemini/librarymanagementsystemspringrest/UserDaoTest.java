package com.capgemini.librarymanagementsystemspringrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagementsystemspringrest.dao.UserDao;
import com.capgemini.librarymanagementsystemspringrest.dao.UserDaoImplementation;
import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;

public class UserDaoTest {
	private UserDao dao = new UserDaoImplementation();

	@Test
	public void testUserLogin() {
		UserInformation status = dao.userLogin("padma@gmail.com", "padma1");
		Assertions.assertNotNull(status);
	}

	@Test
	public void testUserLoginFalse() {
		UserInformation status = dao.userLogin("padma123@gmail.com", "padma123");
		Assertions.assertNull(status);
	}

	@Test
	public void testBorrowBook() {
		boolean status = dao.borrowBook(22, 64);
		Assertions.assertTrue(status);
	}

	@Test
	public void testBorrowBookFalse() {
		boolean status = dao.borrowBook(22, 64);
		Assertions.assertFalse(status);
	}

	@Test
	public void testReturnBook() {
		boolean status = dao.returnBook(22, 64);
		Assertions.assertTrue(status);
	}

	@Test
	public void testReturnBookFalse() {
		boolean status = dao.returnBook(22, 64);
		Assertions.assertFalse(status);
	}

}
