package com.capgemini.librarymanagementsystemjpahibernate.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjpahibernate.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public interface AdminDao {

	UserInformation adminLogin(String email, String password) throws LibraryManagementSystemException;

	boolean addUser(UserInformation userInfo);

	boolean addBook(BooksInformation bookInfo);

	boolean removeBook(int bookId) throws LibraryManagementSystemException;

	boolean issueBook(int requestId) throws LibraryManagementSystemException;

	boolean updateBook(BooksInformation bookInfo) throws LibraryManagementSystemException;

	BooksInformation searchBook(int bookId);

	List<BooksInformation> showAllBooks() throws LibraryManagementSystemException;

	List<UserInformation> showAllUsers() throws LibraryManagementSystemException;

	List<UserRequestInformation> showAllRequests() throws LibraryManagementSystemException;

}
