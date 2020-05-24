package com.capgemini.librarymanagementsystemjpahibernate.service;

import com.capgemini.librarymanagementsystemjpahibernate.dao.UserDao;
import com.capgemini.librarymanagementsystemjpahibernate.dao.UserDaoImplementation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public class UserServiceImplementation implements UserService {

	private UserDao userDao = new UserDaoImplementation();

	@Override
	public UserInformation userLogin(String email, String password) throws LibraryManagementSystemException {
		try {
			return userDao.userLogin(email, password);
		} catch (LibraryManagementSystemException e) {
			return null;
		}
	}

	@Override
	public boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException {
		try {
			return userDao.borrowBook(userId, bookId);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

	@Override
	public boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException {
		try {
			return userDao.returnBook(userId, bookId);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

}
