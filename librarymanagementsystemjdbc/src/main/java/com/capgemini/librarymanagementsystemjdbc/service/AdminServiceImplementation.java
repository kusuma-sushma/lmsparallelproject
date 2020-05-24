package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dao.AdminDao;
import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryManagementSystemFactory;

public class AdminServiceImplementation implements AdminService {

	private AdminDao adminDao = LibraryManagementSystemFactory.getAdminDao();

	@Override
	public boolean addUser(UserInformation userInfo) throws LibraryManagementSystemException {
		try {
			return adminDao.addUser(userInfo);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
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
	public boolean addBook(BooksInformation info) throws LibraryManagementSystemException {
		try {
			return adminDao.addBook(info);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

	@Override
	public boolean removeBook(int bookId) throws LibraryManagementSystemException {
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
	public boolean updateBook(BooksInformation bookInfo) throws LibraryManagementSystemException {
		try {
			return adminDao.updateBook(bookInfo);
		} catch (LibraryManagementSystemException e) {
			return false;
		}
	}

	@Override
	public BooksInformation searchBook(int bookId) throws LibraryManagementSystemException {
		try {
			return adminDao.searchBook(bookId);
		} catch (LibraryManagementSystemException e) {
			return null;
		}
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
