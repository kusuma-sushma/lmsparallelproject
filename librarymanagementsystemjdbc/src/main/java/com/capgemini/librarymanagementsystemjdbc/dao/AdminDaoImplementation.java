package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;

public class AdminDaoImplementation implements AdminDao {

	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Calendar calendar = Calendar.getInstance();
	String todayDate = dateFormat.format(calendar.getTime());
	Date actualReturnDate;
	Date returnDate;

	@Override
	public UserInformation adminLogin(String email, String password) throws LibraryManagementSystemException {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.adminLogin)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			try (ResultSet result = preparedStatement.executeQuery()) {
				if (result.next()) {
					UserInformation adminInfo = new UserInformation();
					adminInfo.setEmail(email);
					adminInfo.setPassword(password);
					return adminInfo;
				} else {
					throw new LibraryManagementSystemException("email or password which is entered is invalid");
				}
			} catch (LibraryManagementSystemException lmse) {
				throw new LibraryManagementSystemException(lmse.getMessage());
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}
	}

	@Override
	public boolean addUser(UserInformation user) throws LibraryManagementSystemException {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.addUser)) {
			preparedStatement.setInt(1, user.getUserId());
			preparedStatement.setString(2, user.getUsername());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getDepartment());
			int count = preparedStatement.executeUpdate();
			if (count != 0) {
				return true;
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Unable to add the User, user already exists");
		}
		return false;

	}

	@Override
	public boolean addBook(BooksInformation info) throws LibraryManagementSystemException {
		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.addBook)) {
			preparedStatement.setInt(1, info.getBookId());
			preparedStatement.setString(2, info.getBookName());
			preparedStatement.setString(3, info.getBookCategory());
			preparedStatement.setString(4, info.getBookAuthor());
			preparedStatement.setString(5, info.getBookPublisher());
			int count = preparedStatement.executeUpdate();
			if (count != 0) {
				return true;
			}

		} catch (Exception e) {
			throw new LibraryManagementSystemException("Unable to add the Book, book already exists");
		}
		return false;

	}

	@Override
	public boolean removeBook(int bookid) throws LibraryManagementSystemException {
		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.removeBook)) {
			preparedStatement.setInt(1, bookid);
			int count = preparedStatement.executeUpdate();
			if (count != 0) {
				return true;
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Unable to delete the Book, book is not present");
		}
		return false;

	}

	@Override
	public boolean issueBook(int requestId) throws LibraryManagementSystemException {
		int userId;
		int bookId;
		int noOfBooksBorrowed;

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement request = connection.prepareStatement(QueryMapper.request);
				PreparedStatement getUser = connection.prepareStatement(QueryMapper.getUsersBooks);
				PreparedStatement issueBook = connection.prepareStatement(QueryMapper.issueBook);
				PreparedStatement bookAvailable = connection.prepareStatement(QueryMapper.bookAvailable);
				PreparedStatement setBooksBorrowedStmt = connection
						.prepareStatement(QueryMapper.setNoOfBooksBorrowed);) {

			request.setInt(1, requestId);
			try (ResultSet requestResult = request.executeQuery();) {

				if (requestResult.next()) {
					userId = requestResult.getInt("userId");
					bookId = requestResult.getInt("bookId");
					getUser.setInt(1, userId);

					try (ResultSet userResult = getUser.executeQuery();) {

						if (userResult.next()) {
							UserInformation users = new UserInformation();
							users.setNoOfBooks(userResult.getInt("noOfBooksBorrowed"));
							noOfBooksBorrowed = users.getNoOfBooks();

							issueBook.setInt(1, requestId);
							int updateDate = issueBook.executeUpdate();
							if (updateDate != 0) {
								bookAvailable.setInt(1, bookId);
								bookAvailable.executeUpdate();
								noOfBooksBorrowed++;

								setBooksBorrowedStmt.setInt(1, noOfBooksBorrowed);
								setBooksBorrowedStmt.setInt(2, userId);
								setBooksBorrowedStmt.executeUpdate();

							} else {
								throw new LibraryManagementSystemException(
										"Request Id which was given is not present ");
							}
						}
					}

				} else {
					throw new LibraryManagementSystemException("Request Id which was given is invalid");
				}
			}

		} catch (Exception e) {
			throw new LibraryManagementSystemException("Book Id which was given is not available in the library");

		}
		return true;
	}

	@Override
	public boolean updateBook(BooksInformation bookInfo) throws LibraryManagementSystemException {
		List<BooksInformation> listBook = new ArrayList<BooksInformation>();

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.updateBook)) {
			preparedStatement.setString(1, bookInfo.getBookName());
			preparedStatement.setString(2, bookInfo.getBookAuthor());
			preparedStatement.setString(3, bookInfo.getBookCategory());
			preparedStatement.setString(4, bookInfo.getBookPublisher());
			preparedStatement.setInt(5, bookInfo.getBookId());
			listBook.add(bookInfo);
			int count = preparedStatement.executeUpdate();
			if (count != 0) {
				return true;
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Book is not available in library unable to update");
		}
		return false;
	}

	@Override
	public BooksInformation searchBook(int bookId) throws LibraryManagementSystemException {
		BooksInformation bookInfo = new BooksInformation();
		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.searchBook)) {
			preparedStatement.setInt(1, bookId);
			ResultSet result = preparedStatement.executeQuery();
			if (result.next()) {
				bookInfo.setBookId(result.getInt("bookid"));
				bookInfo.setBookName(result.getString("bookname"));
				bookInfo.setBookAuthor(result.getString("bookauthor"));
				bookInfo.setBookCategory(result.getString("bookcategory"));
				bookInfo.setBookPublisher(result.getString("bookpublisher"));
				return bookInfo;
			} else {
				throw new LibraryManagementSystemException("No such book found for id which is given");
			}

		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}

	}

	@Override
	public List<BooksInformation> showAllBooks() throws LibraryManagementSystemException {
		try (Connection connection = JdbcUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryMapper.showAllBooks);) {
			List<BooksInformation> bookInfo = new ArrayList<BooksInformation>();
			while (resultSet.next()) {
				BooksInformation book = new BooksInformation();
				book.setBookId(resultSet.getInt("bookid"));
				book.setBookName(resultSet.getString("bookname"));
				book.setBookAuthor(resultSet.getString("bookauthor"));
				book.setBookCategory(resultSet.getString("bookcategory"));
				book.setBookPublisher(resultSet.getString("bookpublisher"));
				book.setBookAvailable(resultSet.getBoolean("bookAvailable"));
				bookInfo.add(book);
			}
			if (bookInfo.isEmpty()) {
				throw new LibraryManagementSystemException("no books are present in the library");
			}
			return bookInfo;
		} catch (LibraryManagementSystemException lmse) {
			throw new LibraryManagementSystemException(lmse.getMessage());
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}

	}

	@Override
	public List<UserInformation> showAllUsers() throws LibraryManagementSystemException {
		try (Connection connection = JdbcUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryMapper.showAllUsers)) {
			List<UserInformation> userInfo = new ArrayList<UserInformation>();
			while (resultSet.next()) {
				UserInformation user = new UserInformation();

				user.setUserId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("password"));
				user.setDepartment(resultSet.getString("department"));
				user.setRole(resultSet.getString("role"));
				user.setFine(resultSet.getDouble("fine"));
				user.setNoOfBooks(resultSet.getInt("noOfBooksBorrowed"));
				userInfo.add(user);
			}
			if (userInfo.isEmpty()) {
				throw new LibraryManagementSystemException("no users are present in the library");
			}
			return userInfo;
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}

	}

	@Override
	public List<UserRequestInformation> showAllRequests() throws LibraryManagementSystemException {
		try (Connection connection = JdbcUtility.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(QueryMapper.showAllRequest)) {
			List<UserRequestInformation> userRequestInfo = new ArrayList<UserRequestInformation>();
			while (resultSet.next()) {
				UserRequestInformation userRequest = new UserRequestInformation();
				userRequest.setRequestId(resultSet.getInt("requestId"));
				userRequest.setUserId(resultSet.getInt("userId"));
				userRequest.setBookId(resultSet.getInt("bookId"));
				userRequest.setIssueDate(resultSet.getDate("issueDate"));
				userRequest.setExpectedReturnDate(resultSet.getDate("expectedReturnDate"));
				userRequest.setReturnedDate(resultSet.getDate("returnedDate"));
				userRequestInfo.add(userRequest);
			}
			if (userRequestInfo.isEmpty()) {
				throw new LibraryManagementSystemException("no users are present in the library");
			}
			return userRequestInfo;
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}

	}

}
