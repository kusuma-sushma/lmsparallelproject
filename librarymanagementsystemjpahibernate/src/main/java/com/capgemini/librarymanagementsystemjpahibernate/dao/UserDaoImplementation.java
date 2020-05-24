package com.capgemini.librarymanagementsystemjpahibernate.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemjpahibernate.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public class UserDaoImplementation implements UserDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatedb");

	@Override
	public UserInformation userLogin(String email, String password) throws LibraryManagementSystemException {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select a from UserInformation a where a.email = :email and a.password =:password";
			TypedQuery<UserInformation> query = manager.createQuery(jpql, UserInformation.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserInformation info = query.getSingleResult();
			if (info != null) {
				if ((info.getEmail().equalsIgnoreCase(email) && info.getPassword().equals(password))
						&& (info.getRole().equalsIgnoreCase("student"))) {
					return info;
				} else {
					throw new LibraryManagementSystemException("Email and password which was entered is invalid");
				}
			}
			return null;
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();
		}
	}

	public boolean borrowBook(int userId, int bookId) throws LibraryManagementSystemException {
		int requestId;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		BooksInformation bookInfo = new BooksInformation();
		UserRequestInformation userRequest = new UserRequestInformation();
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select count(*) from UserRequestInformation u where u.bookId=:ubookId and u.requestId=:urequestId and u.userId=:uuserId";
			Query query = manager.createQuery(jpql);
			requestId = (int) (Math.random() * 1000000);
			if (requestId <= 100000) {
				requestId = requestId + 100000;
			}

			query.setParameter("ubookId", bookId);
			query.setParameter("urequestId", requestId);
			query.setParameter("uuserId", userId);
			int noOfReq = ((Number) query.getSingleResult()).intValue();
			System.out.println("no of req placed" + noOfReq);

			if (noOfReq < 3) {
				bookInfo = manager.find(BooksInformation.class, bookId);

				if (bookInfo != null) {
					jpql = "select r from UserRequestInformation r ";
					TypedQuery<UserRequestInformation> query2 = manager.createQuery(jpql, UserRequestInformation.class);
					List<UserRequestInformation> list = query2.getResultList();

					for (UserRequestInformation requestInfo : list) {
						if (requestInfo.getBookId() == bookId) {
							throw new LibraryManagementSystemException(
									"Book has already given to others hence unable to borrow ");
						}
					}

					if (bookInfo.isBookAvailable()) {
						transaction.begin();
						userRequest.setUserId(userId);
						userRequest.setBookId(bookId);
						userRequest.setRequestId(requestId);
						manager.persist(userRequest);
						transaction.commit();

					} else {
						throw new LibraryManagementSystemException("Book is not present in the library");
					}

				} else {
					throw new LibraryManagementSystemException("Book Id or User Id is invalid");
				}

			} else {
				throw new LibraryManagementSystemException("You have Already borrowed Maximum No Of Books");
			}

		} catch (LibraryManagementSystemException e) {
			transaction.rollback();

			throw new LibraryManagementSystemException(e.getMessage());
		}
		return true;
	}

	public boolean returnBook(int userId, int bookId) throws LibraryManagementSystemException {
		double fine = 0;
		int noOfBooks;
		Date expectedReturnDate = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		UserRequestInformation user = new UserRequestInformation();
		int requestId = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 20);
		Date returnedDate = calendar.getTime();
		UserInformation userInfo = new UserInformation();
		BooksInformation bookInfo = new BooksInformation();
		int requestBookId = 0;
		int requestUserId = 0;

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "select u from UserRequestInformation u ";
			TypedQuery<UserRequestInformation> query = manager.createQuery(jpql, UserRequestInformation.class);
			List<UserRequestInformation> userList = query.getResultList();

			for (UserRequestInformation requestInfo : userList) {
				if ((requestInfo.getBookId() == bookId) && (requestInfo.getUserId() == userId)) {
					if (requestInfo.getReturnedDate() != null) {
						throw new LibraryManagementSystemException("Book has already returned");
					} else {
						requestId = requestInfo.getRequestId();
					}
				}
			}

			if (requestId != 0) {
				transaction.begin();
				user = manager.find(UserRequestInformation.class, requestId);
				user.setReturnedDate(returnedDate);
				transaction.commit();

				transaction.begin();
				user = manager.find(UserRequestInformation.class, requestId);

				if (user != null) {
					requestBookId = user.getBookId();
					requestUserId = user.getUserId();
					returnedDate = user.getReturnedDate();
					expectedReturnDate = user.getExpectedReturnDate();
					transaction.commit();

					if ((returnedDate != null) && (expectedReturnDate != null)) {
						long expReturnDateInMilliSecs = expectedReturnDate.getTime();
						long returnedDateInMilliSecs = returnedDate.getTime();
						long diffInMilliSecs = returnedDateInMilliSecs - expReturnDateInMilliSecs;
						int NoOfDaysDelayed = (int) (diffInMilliSecs / (24 * 60 * 60 * 1000));
						transaction.begin();
						userInfo = manager.find(UserInformation.class, requestUserId);
						noOfBooks = userInfo.getNoOfBooksBorrowed();
						--noOfBooks;
						userInfo.setNoOfBooksBorrowed(noOfBooks);
						if (NoOfDaysDelayed > 0) {
							fine = userInfo.getFine();
							fine = fine + (NoOfDaysDelayed * 1.8);
							userInfo.setFine(fine);
						}
						transaction.commit();

						transaction.begin();
						bookInfo = manager.find(BooksInformation.class, requestBookId);
						bookInfo.setBookAvailable(true);
						transaction.commit();

						transaction.begin();
						user = manager.find(UserRequestInformation.class, requestId);
						manager.remove(user);
						transaction.commit();
					} else {
						throw new LibraryManagementSystemException("Unable to return book");
					}
				}
			} else {
				throw new LibraryManagementSystemException("Book Id or User Id is invalid");
			}
		} catch (LibraryManagementSystemException e) {
			transaction.rollback();
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();
		}
		return true;

	}
}