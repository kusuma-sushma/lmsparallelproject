package com.capgemini.librarymanagementsystemspringrest.service;

import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;

public interface UserService {

	UserInformation userLogin(String email, String password);

	boolean borrowBook(int userId, int bookId);

	boolean returnBook(int userId, int bookId);

}
