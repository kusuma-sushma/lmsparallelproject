package com.capgemini.librarymanagementsystemjdbc.service;

import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public interface AdminService {

	boolean addUser(UserInformation userInfo) throws LibraryManagementSystemException;

	public UserInformation adminLogin(String email, String password) throws LibraryManagementSystemException;

	public boolean addBook(BooksInformation info) throws LibraryManagementSystemException;

	public boolean removeBook(int bookId) throws LibraryManagementSystemException;

	boolean issueBook(int requestId) throws LibraryManagementSystemException;

	boolean updateBook(BooksInformation bookInfo) throws LibraryManagementSystemException;

	BooksInformation searchBook(int bookId) throws LibraryManagementSystemException;

	List<BooksInformation> showAllBooks() throws LibraryManagementSystemException;

	List<UserRequestInformation> showAllRequests() throws LibraryManagementSystemException;

	List<UserInformation> showAllUsers() throws LibraryManagementSystemException;

}
