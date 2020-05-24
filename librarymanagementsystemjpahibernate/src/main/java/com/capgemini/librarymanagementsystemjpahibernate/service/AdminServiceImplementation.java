package com.capgemini.librarymanagementsystemjpahibernate.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjpahibernate.dao.AdminDao;
import com.capgemini.librarymanagementsystemjpahibernate.dao.AdminDaoImplementation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public class AdminServiceImplementation implements AdminService {

	private AdminDao adminDao = new AdminDaoImplementation();

	@Override
	public boolean addUser(UserInformation userInfo) {
		return adminDao.addUser(userInfo);
	}

	@Override
	public UserInformation adminLogin(String email, String password) throws LibraryManagementSystemException {
		try {
			return adminDao.adminLogin(email, password);
		} catch (LibraryManagementSystemException e) {
			return null;
		}
	}

	@Override
	public boolean addBook(BooksInformation info) {
		return adminDao.addBook(info);
	}

	@Override
	public boolean removeBook(int bookId) {
		try {
			return adminDao.removeBook(bookId);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

	@Override
	public boolean issueBook(int requestId) throws LibraryManagementSystemException {
		try {
			return adminDao.issueBook(requestId);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

	@Override
	public boolean updateBook(BooksInformation bookInfo) {
		try {
			return adminDao.updateBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

	@Override
	public BooksInformation searchBook(int bookId) {
		return adminDao.searchBook(bookId);
	}

	@Override
	public List<BooksInformation> showAllBooks() throws LibraryManagementSystemException {
		try {
			return adminDao.showAllBooks();
		} catch (LibraryManagementSystemException e) {
			return null;
		}
	}

	@Override
	public List<UserRequestInformation> showAllRequests() throws LibraryManagementSystemException {
		try {
			return adminDao.showAllRequests();
		} catch (LibraryManagementSystemException e) {
			return null;
		}
	}

	@Override
	public List<UserInformation> showAllUsers() throws LibraryManagementSystemException {
		try {
			return adminDao.showAllUsers();
		} catch (LibraryManagementSystemException e) {
			return null;
		}
	}

}
