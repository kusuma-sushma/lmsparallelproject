package com.capgemini.librarymanagementsystemspringrest.dao;

import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;

public interface UserDao {

	UserInformation userLogin(String email, String password);

	boolean borrowBook(int userId, int bookId);

	boolean returnBook(int userId, int bookId);
}
