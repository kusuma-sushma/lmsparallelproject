package com.capgemini.librarymanagementsystemspringrest.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystemspringrest.dto.BooksInformation;
import com.capgemini.librarymanagementsystemspringrest.dto.UserInformation;
import com.capgemini.librarymanagementsystemspringrest.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemspringrest.exception.LibraryManagementSystemException;

@Repository
public class AdminDaoImplementation implements AdminDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	public UserInformation adminLogin(String email, String password) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select a from UserInformation a where a.email = :aemail and a.password =:apassword";
			TypedQuery<UserInformation> query = manager.createQuery(jpql, UserInformation.class);
			query.setParameter("aemail", email);
			query.setParameter("apassword", password);
			UserInformation info = query.getSingleResult();
			return info;
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Email and Password which was entered is invalid");
		} finally {
			manager.close();
		}
	}

	public boolean addUser(UserInformation userInfo) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select u from UserInformation u ";
			TypedQuery<UserInformation> query = manager.createQuery(jpql, UserInformation.class);
			List<UserInformation> userList = query.getResultList();

			for (UserInformation user : userList) {
				if (user.getEmail().equalsIgnoreCase(userInfo.getEmail())) {
					throw new LibraryManagementSystemException("This EmailId is already in existing ");
				}

			}
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(userInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new LibraryManagementSystemException("User Email Id already exists");
		} finally {
			manager.close();
		}
	}

	public boolean addBook(BooksInformation bookInfo) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(bookInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			manager.close();
		}

	}

	public boolean removeBook(int bookId) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			BooksInformation removeBook = manager.find(BooksInformation.class, bookId);
			manager.remove(removeBook);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			manager.close();
		}

	}

	public boolean issueBook(int requestId) {
		int noOfBooks = 0;
		Date date = new Date();
		Date expectedReturnDate = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		UserRequestInformation user = new UserRequestInformation();
		UserInformation userInfo = new UserInformation();
		BooksInformation bookInfo = new BooksInformation();
		int reqBookId = 0;
		int reqUserId = 0;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 15);
		expectedReturnDate = calendar.getTime();
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			user = manager.find(UserRequestInformation.class, requestId);

			if (user != null) {
				Date issueDate = user.getIssueDate();
				if (issueDate == null) {
					reqUserId = user.getUserId();
					reqBookId = user.getBookId();

					user.setIssueDate(date);
					user.setExpectedReturnDate(expectedReturnDate);
					transaction.commit();

					transaction.begin();
					userInfo = manager.find(UserInformation.class, reqUserId);
					noOfBooks = userInfo.getNoOfBooksBorrowed();
					++noOfBooks;
					System.out.println("No Of Books Borrowed" + noOfBooks);

					userInfo.setNoOfBooksBorrowed(noOfBooks);
					transaction.commit();

					transaction.begin();
					bookInfo = manager.find(BooksInformation.class, reqBookId);
					bookInfo.setBookAvailable(false);
					transaction.commit();
				} else {
					throw new LibraryManagementSystemException("Book is not present in the library");
				}

			} else {
				throw new LibraryManagementSystemException("Request Id which was given is invalid");
			}

		} catch (Exception e) {
			transaction.rollback();
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();

		}

		return true;
	}

	public BooksInformation searchBook(int bookId) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			BooksInformation info = manager.find(BooksInformation.class, bookId);
			return info;
		} catch (Exception e) {
			throw new LibraryManagementSystemException("No Book found for Book Id which was given");
		} finally {
			manager.close();
		}
	}

	public List<BooksInformation> showAllBooks() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from BooksInformation b";
			TypedQuery<BooksInformation> query = manager.createQuery(jpql, BooksInformation.class);
			List<BooksInformation> recordlist = query.getResultList();
			if (recordlist.isEmpty()) {
				throw new LibraryManagementSystemException("No books are present in library");
			} else {
				return recordlist;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}
		return null;
	}

	public List<UserInformation> showAllUsers() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from UserInformation b";
			TypedQuery<UserInformation> query = manager.createQuery(jpql, UserInformation.class);
			List<UserInformation> userList = query.getResultList();
			if (userList.isEmpty()) {
				throw new LibraryManagementSystemException("No users are present in Library");
			} else {
				return userList;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}
		return null;
	}

	public List<UserRequestInformation> showAllRequests() {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from UserRequestInformation b";
			TypedQuery<UserRequestInformation> query = manager.createQuery(jpql, UserRequestInformation.class);
			List<UserRequestInformation> requestlist = query.getResultList();
			if (requestlist.isEmpty()) {
				throw new LibraryManagementSystemException("No Requests are present");
			} else {
				return requestlist;
			}
		} catch (Exception e) {
			e.getMessage();
		} finally {
			manager.close();
		}
		return null;
	}

	public boolean isBookRecevied(int requestId) {
		int noOfBooks = 0;
		double fine = 0;
		Date expectedReturnDate = null;
		Date returnedDate = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		UserRequestInformation user = new UserRequestInformation();
		int requestBookId = 0;
		int requestUserId = 0;
		UserInformation userInfo = new UserInformation();
		BooksInformation bookInfo = new BooksInformation();
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
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
					throw new LibraryManagementSystemException("Book is not present in the library");
				}

			} else {
				throw new LibraryManagementSystemException("Request Id which is given is invalid");
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();

		}
		return true;
	}

	@Override
	public boolean updateBook(BooksInformation bookInfo) {
		boolean isUpdated = false;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		manager = factory.createEntityManager();
		BooksInformation update = manager.find(BooksInformation.class, bookInfo.getBookId());
		if (update != null) {
			try {
				transaction = manager.getTransaction();
				transaction.begin();

				String bookName = bookInfo.getBookName();
				if (bookName != null) {
					bookName = bookName.trim();
				}
				String bookAuthor = bookInfo.getBookAuthor();
				if (bookAuthor != null) {
					bookAuthor = bookAuthor.trim();
				}
				String bookCategory = bookInfo.getBookCategory();
				if (bookCategory != null) {
					bookCategory = bookCategory.trim();
				}
				String bookPublisher = bookInfo.getBookPublisher();
				if (bookPublisher != null) {
					bookPublisher = bookPublisher.trim();
				}

				if (bookName != null && !bookName.isEmpty() && bookName.length() > 1) {
					update.setBookName(bookName);
				}
				if (bookAuthor != null && !bookAuthor.isEmpty() && bookAuthor.length() > 1) {
					update.setBookAuthor(bookAuthor);
				}
				if (bookCategory != null && !bookCategory.isEmpty() && bookCategory.length() > 1) {
					update.setBookCategory(bookCategory);
				}
				if (bookPublisher != null && !bookPublisher.isEmpty() && bookPublisher.length() > 1) {
					update.setBookPublisher(bookPublisher);
				}
				transaction.commit();
				isUpdated = true;

			} catch (Exception e) {
				return false;
			}
			manager.close();
		}
		return false;
	}
}
