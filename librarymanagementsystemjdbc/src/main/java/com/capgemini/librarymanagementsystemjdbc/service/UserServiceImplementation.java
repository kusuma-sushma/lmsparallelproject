package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dao.UserDao;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryManagementSystemFactory;

public class UserServiceImplementation implements UserService {

	private UserDao userDao = LibraryManagementSystemFactory.getUserDao();

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
