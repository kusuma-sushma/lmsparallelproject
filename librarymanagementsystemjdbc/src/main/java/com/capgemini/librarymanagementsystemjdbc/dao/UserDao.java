package com.capgemini.librarymanagementsystemjdbc.dao;

import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public interface UserDao {

	UserInformation userLogin(String email, String password) throws LibraryManagementSystemException;

	boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException;

	boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException;

}
