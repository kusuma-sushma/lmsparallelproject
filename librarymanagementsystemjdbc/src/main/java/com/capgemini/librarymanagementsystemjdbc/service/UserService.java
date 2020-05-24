package com.capgemini.librarymanagementsystemjdbc.service;

import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;

public interface UserService {

	UserInformation userLogin(String email, String password) throws LibraryManagementSystemException;

	boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException;

	boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException;

}
