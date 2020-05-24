package com.capgemini.librarymanagementsystemjdbc.dao;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public interface AdminDao {

	UserInformation adminLogin(String email, String password) throws LibraryManagementSystemException;

	boolean addUser(UserInformation userInfo) throws LibraryManagementSystemException;

	boolean addBook(BooksInformation bookInfo) throws LibraryManagementSystemException;

	boolean removeBook(int bookId) throws LibraryManagementSystemException;

	boolean issueBook(int requestId) throws LibraryManagementSystemException;

	boolean updateBook(BooksInformation bookInfo) throws LibraryManagementSystemException;

	BooksInformation searchBook(int bookId) throws LibraryManagementSystemException;

	List<BooksInformation> showAllBooks() throws LibraryManagementSystemException;

	List<UserInformation> showAllUsers() throws LibraryManagementSystemException;

	List<UserRequestInformation> showAllRequests() throws LibraryManagementSystemException;

}
