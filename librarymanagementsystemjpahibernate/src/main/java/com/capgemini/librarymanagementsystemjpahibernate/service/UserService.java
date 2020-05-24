package com.capgemini.librarymanagementsystemjpahibernate.service;

import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public interface UserService {

	UserInformation userLogin(String email, String password) throws LibraryManagementSystemException;

	boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException;

	boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException;

}
