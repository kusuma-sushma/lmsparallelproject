package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.database.LibraryManagementSystemDataBase;
import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;

public class AdminDaoImplementation implements AdminDao {

	Date date = new Date();
	Date expectedReturnDate;
	Date returnedDate;

	@Override
	public AdminInformation adminLogin(String email, String password) throws LibraryManagementSystemException {
		AdminInformation adminInfo = LibraryManagementSystemFactory.getAdminInfo();
		if (adminInfo.getEmail().equals(email)) {
			if (adminInfo.getPassword().equals(password)) {
				return adminInfo;
			} else {
				throw new LibraryManagementSystemException("password which is entered is invalid");
			}
		} else {
			throw new LibraryManagementSystemException("email which is entered is invalid");
		}
	}

	@Override
	public boolean addUser(UserInformation userInfo) throws LibraryManagementSystemException {
		for (UserInformation userBean : LibraryManagementSystemDataBase.user) {
			if (userBean.getUserId() == userInfo.getUserId()) {
				return false;
			} else if (userBean.getEmail().equals(userInfo.getEmail())) {
				throw new LibraryManagementSystemException("User details already exists, unable to add the user");
			}
		}

		LibraryManagementSystemDataBase.user.add(userInfo);

		return true;

	}

	@Override
	public boolean addBook(BooksInformation bookInfo) throws LibraryManagementSystemException {
		for (BooksInformation addbook : LibraryManagementSystemDataBase.book) {
			if (addbook.getBookId() == bookInfo.getBookId()) {
				return false;
			}
		}
		LibraryManagementSystemDataBase.book.add(bookInfo);
		return true;
	}

	@Override
	public boolean removeBook(int bookId) throws LibraryManagementSystemException {
		for (BooksInformation remove : LibraryManagementSystemDataBase.book) {
			if (remove.getBookId() == bookId) {
				LibraryManagementSystemDataBase.book.remove(remove);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean issueBook(int userId, int bookId) throws LibraryManagementSystemException {
		UserInformation userInfo = LibraryManagementSystemFactory.getUserInfo();
		BooksInformation bookInfo = LibraryManagementSystemFactory.getBookInfo();
		boolean isValid = false;
		UserRequestInformation userRequestInfo = LibraryManagementSystemFactory.userRequest();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();

		int noOfBooksBorrowed = userInfo.getNoOfBooksBorrowed();
		for (UserRequestInformation info : LibraryManagementSystemDataBase.requests) {
			if (info.getUserId() == userId) {
				if (info.getBookId() == bookId) {
					if (info.isBookIssued() == false) {
						userRequestInfo = info;
						info.setBookIssued(true);
						isValid = true;
					}
				}
			}
		}

		if (isValid) {
			for (BooksInformation info2 : LibraryManagementSystemDataBase.book) {
				if (info2.getBookId() == bookInfo.getBookId()) {
					bookInfo = info2;
				}
			}
			for (UserInformation userInfo2 : LibraryManagementSystemDataBase.user) {
				if (userInfo2.getUserId() == userInfo.getUserId()) {
					userInfo = userInfo2;
					noOfBooksBorrowed = userInfo.getNoOfBooksBorrowed();
				}
			}
			if (noOfBooksBorrowed < 3) {
				bookInfo.setBookAvailable(false);
				noOfBooksBorrowed++;
				System.out.println(noOfBooksBorrowed);
				userInfo.setNoOfBooksBorrowed(noOfBooksBorrowed);
				userRequestInfo.setDateOfIssued(date);
				userRequestInfo.setActualReturnDate(expectedReturnDate);
				return true;
			} else {
				LibraryManagementSystemDataBase.requests.remove(userRequestInfo);
				throw new LibraryManagementSystemException("Book can not be issued to the user");
			}

		} else {
			throw new LibraryManagementSystemException("User has already borrowed 3 books");
		}
	}

	@Override
	public BooksInformation updateBook(int bookId) {
		for (BooksInformation bookInfo : LibraryManagementSystemDataBase.book) {
			if (bookInfo.getBookId() == bookId) {
				return bookInfo;
			}
		}
		return null;
	}

	@Override
	public BooksInformation searchBook(int bookId) {
		for (BooksInformation bookInfo : LibraryManagementSystemDataBase.book) {
			if (bookInfo.getBookId() == bookId) {
				return bookInfo;
			}
		}
		return null;
	}

	@Override
	public List<BooksInformation> showAllBooks() {
		List<BooksInformation> booksList = new ArrayList<BooksInformation>();

		for (BooksInformation bookInfo : LibraryManagementSystemDataBase.book) {
			bookInfo.getBookId();
			bookInfo.getBookName();
			bookInfo.getBookAuthor();
			bookInfo.getBookCategory();
			bookInfo.getBookPublisher();
			booksList.add(bookInfo);
		}
		if (booksList.isEmpty()) {
			return null;
		} else {
			return booksList;
		}

	}

	@Override
	public List<UserInformation> showAllUsers() {
		List<UserInformation> userInfo = new ArrayList<UserInformation>();
		for (UserInformation userInfo1 : LibraryManagementSystemDataBase.user) {
			userInfo1.getUserId();
			userInfo1.getUsername();
			userInfo1.getEmail();
			userInfo1.getNoOfBooksBorrowed();
			userInfo.add(userInfo1);
		}
		if (userInfo.isEmpty()) {
			return null;
		} else {
			return userInfo;
		}
	}

	@Override
	public List<UserRequestInformation> showAllRequests() {
		List<UserRequestInformation> userRequestInfo = new ArrayList<UserRequestInformation>();
		for (UserRequestInformation requestInfo : LibraryManagementSystemDataBase.requests) {
			requestInfo.getBookId();
			requestInfo.getUserId();
			requestInfo.isBookIssued();
			requestInfo.isBookReturned();
			userRequestInfo.add(requestInfo);
		}
		if (userRequestInfo.isEmpty()) {
			return null;
		} else {
			return userRequestInfo;
		}

	}

	@Override
	public boolean isBookRecevied(int userId, int bookId) throws LibraryManagementSystemException {
		boolean isRecieved = false;
		double fine;
		UserRequestInformation userRequestInfo = LibraryManagementSystemFactory.userRequest();
		for (UserRequestInformation requestInfo : LibraryManagementSystemDataBase.requests) {

			if (requestInfo.getBookId() == bookId && requestInfo.getUserId() == userId
					&& requestInfo.isBookReturned() == true) {
				isRecieved = true;
				expectedReturnDate = requestInfo.getActualReturnDate();
				returnedDate = requestInfo.getDateOfReturn();
				LibraryManagementSystemDataBase.requests.remove(requestInfo);
				userRequestInfo = requestInfo;
			}
		}
		if (isRecieved) {
			long expectDate = expectedReturnDate.getTime();
			long returnDate = returnedDate.getTime();
			long diff = returnDate - expectDate;
			int NoOfDays = (int) (diff / (24 * 60 * 60 * 1000));
			for (BooksInformation bookInfo1 : LibraryManagementSystemDataBase.book) {
				if (bookInfo1.getBookId() == bookInfo1.getBookId()) {
					bookInfo1.setBookAvailable(true);

				}
			}
			for (UserInformation userInfo1 : LibraryManagementSystemDataBase.user) {
				if (userInfo1.getUserId() == userInfo1.getUserId()) {
					int noOfBooks = userInfo1.getNoOfBooksBorrowed();
					noOfBooks--;
					userInfo1.setNoOfBooksBorrowed(noOfBooks);
					fine = userInfo1.getFine();
					if (NoOfDays > 0) {
						fine = fine + (NoOfDays * 1.8);
						userInfo1.setFine(fine);
					}
					break;
				}
			}
			return true;
		}
		throw new LibraryManagementSystemException(
				"Invalid user or book credentials, Book is not able to receive by admin");
	}

}
