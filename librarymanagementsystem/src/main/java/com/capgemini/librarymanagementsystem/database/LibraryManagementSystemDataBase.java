package com.capgemini.librarymanagementsystem.database;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;

public class LibraryManagementSystemDataBase {

	public static final List<UserInformation> user = new ArrayList<UserInformation>();
	public static final List<AdminInformation> admin = new ArrayList<>();
	public static final List<BooksInformation> book = new ArrayList<>();
	public static final List<UserRequestInformation> requests = new ArrayList<>();

	public static void database() {
		user.add(new UserInformation(121212, "Akhil", "akhil1", "akhil@gmail.com", "civil", 0, 5.853));
		user.add(new UserInformation(123123, "Nikhil", "nikhil", "nikhil@gmail.com", "mech", 0, 2.89));
		user.add(new UserInformation(123456, "Padma", "padma1", "padma@gmail.com", "ece", 0, 0.0));

		book.add(new BooksInformation(121212, "Networks", "ECE", "Michael Steer", "North Carolina SUL", true));
		book.add(new BooksInformation(123123, "Phython", "CSE", "Mark Lutz", "Shroff", true));
		book.add(new BooksInformation(123456, "Surveying & Levelling ", "CIVIL", "Basak", "McGraw Hill", true));

	}
}