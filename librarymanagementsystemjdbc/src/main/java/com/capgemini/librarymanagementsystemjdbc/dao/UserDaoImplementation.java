package com.capgemini.librarymanagementsystemjdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjdbc.utility.JdbcUtility;

public class UserDaoImplementation implements UserDao {

	@SuppressWarnings("unused")
	@Override
	public UserInformation userLogin(String email, String password) throws LibraryManagementSystemException {

		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.userLogin)) {
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			try (ResultSet result = preparedStatement.executeQuery()) {
				if (result.next()) {
					UserInformation userInfo = new UserInformation();
					userInfo.setEmail(result.getString("email"));
					userInfo.setPassword(result.getString("password"));
					if (userInfo != null) {
						return userInfo;
					} else {
						return null;
					}
				} else {
					throw new LibraryManagementSystemException("email or password which is entered is invalid");
				}
			}
		} catch (LibraryManagementSystemException lmse) {
			throw new LibraryManagementSystemException(lmse.getMessage());
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}
	}

	@Override
	public boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException {
		int requestBookId = 0;
		int noOfRequests = 0;
		int bookId1 = 0;
		boolean book = false;

		try (Connection connection = JdbcUtility.getConnection();
				Statement request = connection.createStatement();
				PreparedStatement bookRequest = connection.prepareStatement(QueryMapper.bookRequest);
				PreparedStatement bookAvailable = connection.prepareStatement(QueryMapper.isBookAvailable);
				PreparedStatement borrowBook = connection.prepareStatement(QueryMapper.borrowBook);) {

			try (ResultSet resultSet = request.executeQuery(QueryMapper.showAllRequest)) {
				while (resultSet.next()) {
					requestBookId = resultSet.getInt("bookId");
					if (requestBookId == bookId) {
						throw new LibraryManagementSystemException(
								"BookId which was given is not present in the library, unable to make request");
					}
				}

			}
			bookRequest.setInt(1, userId);

			try (ResultSet addUserId = bookRequest.executeQuery()) {
				if (addUserId.next()) {
					noOfRequests = addUserId.getInt(1);
				}

				if (noOfRequests < 3) {
					bookAvailable.setInt(1, bookId);

					try (ResultSet isAvailable = bookAvailable.executeQuery();) {
						while (isAvailable.next()) {
							bookId1 = isAvailable.getInt("bookId");
							book = isAvailable.getBoolean("bookAvailable");
						}

						if (bookId1 != 0) {
							if (book) {
								int requestId = (int) (Math.random() * 1000000);
								if (requestId <= 100000) {
									requestId = requestId + 100000;
								}
								borrowBook.setInt(1, requestId);
								borrowBook.setInt(2, userId);
								borrowBook.setInt(3, bookId);
								borrowBook.executeUpdate();

								UserRequestInformation requestInfo = new UserRequestInformation();
								requestInfo.setUserId(userId);
								requestInfo.setBookId(bookId);

								return true;
							} else {
								throw new LibraryManagementSystemException(
										"Book Id which is given is not present in the library, Unable to borrow book");
							}
						} else {
							throw new LibraryManagementSystemException("Book Id which is given is invalid");
						}
					}
				} else {
					throw new LibraryManagementSystemException("User has reached max book Limit");
				}
			}

		} catch (Exception e) {
			throw new LibraryManagementSystemException("User Id or Book Id which was given is invalid");
		}

	}

	@Override
	public boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException {
		int noOfDays = 0;
		double fine = 0;
		int requestId = 0;
		int noOfBooks = 0;
		try (Connection connection = JdbcUtility.getConnection();
				PreparedStatement updateRequest = connection.prepareStatement(QueryMapper.updateRequest);
				PreparedStatement returnBook = connection.prepareStatement(QueryMapper.setReturnDate);
				PreparedStatement getFine = connection.prepareStatement(QueryMapper.getFine);
				PreparedStatement books = connection.prepareStatement(QueryMapper.userBook);
				PreparedStatement userFine = connection.prepareStatement(QueryMapper.userFine);
				PreparedStatement bookAvailable = connection.prepareStatement(QueryMapper.setBookAvailable);
				PreparedStatement remove = connection.prepareStatement(QueryMapper.removeRequest);) {

			updateRequest.setInt(1, userId);
			updateRequest.setInt(2, bookId);

			try (ResultSet result = updateRequest.executeQuery();) {
				if (result.next()) {
					requestId = result.getInt("requestId");

					returnBook.setInt(1, requestId);
					returnBook.executeUpdate();
					Date returnDate = result.getDate("returnedDate");
					Date expectedReturnedDate = result.getDate("expectedReturnDate");
					userId = result.getInt("userId");
					bookId = result.getInt("bookId");

					if (returnDate != null) {
						getFine.setDate(1, returnDate);
						getFine.setDate(2, expectedReturnedDate);
						getFine.setInt(3, requestId);

						try (ResultSet bookFine = getFine.executeQuery();) {
							while (bookFine.next()) {
								noOfDays = bookFine.getInt(1);
							}
						}
						try (ResultSet booksBorrowed = books.executeQuery();) {
							while (booksBorrowed.next()) {
								noOfBooks = booksBorrowed.getInt(1);
							}
						}

						if (noOfDays > 0) {
							fine = noOfDays * 1.8;
						}
						userFine.setDouble(1, fine);
						userFine.setInt(2, noOfBooks);
						userFine.setInt(3, userId);
						bookAvailable.setInt(1, bookId);
						bookAvailable.executeUpdate();
						remove.setInt(1, requestId);
						remove.executeUpdate();
						return true;

					} else {

						throw new LibraryManagementSystemException(
								"User Id or Book Id which was given is invalid, unable to return book");
					}

				}
			}

		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		}
		return true;

	}

}
