package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.dao.AdminDao;
import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;

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
	public AdminInformation adminLogin(String email, String password) throws LibraryManagementSystemException {
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
	public boolean issueBook(int userId, int bookId) throws LibraryManagementSystemException {
		try {
			return adminDao.issueBook(userId, bookId);
		} catch (LibraryManagementSystemException e) {
			return false;
		}

	}

	@Override
	public BooksInformation updateBook(int bookId) {
		return adminDao.updateBook(bookId);
	}

	@Override
	public BooksInformation searchBook(int bookId) {
		return adminDao.searchBook(bookId);
	}

	@Override
	public List<BooksInformation> showAllBooks() {
		return adminDao.showAllBooks();
	}

	@Override
	public List<UserRequestInformation> showAllRequests() {
		return adminDao.showAllRequests();
	}

	@Override
	public List<UserInformation> showAllUsers() {
		return adminDao.showAllUsers();
	}

	@Override
	public boolean isBookRecevied(int userId, int bookId) throws LibraryManagementSystemException {
		try {
			return adminDao.isBookRecevied(userId, bookId);
		} catch (LibraryManagementSystemException e) {
			return false;
		}

	}

}
