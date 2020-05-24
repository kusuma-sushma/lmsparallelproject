package com.capgemini.librarymanagementsystemjpahibernate.dao;

import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public interface UserDao {

	UserInformation userLogin(String email, String password) throws LibraryManagementSystemException;

	boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException;

	boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException;
}
