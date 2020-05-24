package com.capgemini.librarymanagementsystemjpahibernate.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.librarymanagementsystemjpahibernate.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserInformation;
import com.capgemini.librarymanagementsystemjpahibernate.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjpahibernate.exception.LibraryManagementSystemException;

public class AdminDaoImplementation implements AdminDao {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("hibernatedb");

	public UserInformation adminLogin(String email, String password) throws LibraryManagementSystemException {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select a from UserInformation a where a.email = :email and a.password = :password";
			TypedQuery<UserInformation> query = manager.createQuery(jpql, UserInformation.class);
			query.setParameter("email", email);
			query.setParameter("password", password);
			UserInformation user = query.getSingleResult();
			if (user != null) {
				if ((user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password))
						&& (user.getRole().equalsIgnoreCase("admin"))) {
					return user;
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

	public boolean addUser(UserInformation userInfo) {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select u from UserInformation u ";
			TypedQuery<UserInformation> query2 = manager.createQuery(jpql, UserInformation.class);
			List<UserInformation> list = query2.getResultList();

			for (UserInformation users : list) {
				if (users.getEmail().equalsIgnoreCase(userInfo.getEmail())) {
					throw new LibraryManagementSystemException("Email Id which was given is already present");
				}
			}
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(userInfo);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
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
		} finally {
			manager.close();
		}
		return false;
	}

	public boolean removeBook(int bookId) throws LibraryManagementSystemException {
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
			throw new LibraryManagementSystemException(
					"Book Id which was given is not available, unable to delete book");
		} finally {
			manager.close();
		}
	}

	public boolean issueBook(int requestId) throws LibraryManagementSystemException {
		Date date = new Date();
		Date expectedReturnDate = null;
		Date issueDate;
		int noOfBooks;
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
				issueDate = user.getIssueDate();
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
			return null;
		} finally {
			manager.close();
		}
	}

	public List<BooksInformation> showAllBooks() throws LibraryManagementSystemException {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from BooksInformation b";
			TypedQuery<BooksInformation> query = manager.createQuery(jpql, BooksInformation.class);
			List<BooksInformation> recordlist = query.getResultList();
			if (recordlist.isEmpty()) {
				throw new LibraryManagementSystemException("No User found");
			} else {
				return recordlist;
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();
		}
	}

	public List<UserInformation> showAllUsers() throws LibraryManagementSystemException {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from UserInformation b";
			TypedQuery<UserInformation> query = manager.createQuery(jpql, UserInformation.class);
			List<UserInformation> userList = query.getResultList();
			if (userList.isEmpty()) {
				throw new LibraryManagementSystemException("No User found");
			} else {
				return userList;
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();
		}
	}

	public List<UserRequestInformation> showAllRequests() throws LibraryManagementSystemException {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			String jpql = "select b from UserRequestInformation b";
			TypedQuery<UserRequestInformation> query = manager.createQuery(jpql, UserRequestInformation.class);
			List<UserRequestInformation> requestlist = query.getResultList();
			if (requestlist.isEmpty()) {
				throw new LibraryManagementSystemException("No User found");
			} else {
				return requestlist;
			}
		} catch (Exception e) {
			throw new LibraryManagementSystemException(e.getMessage());
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean updateBook(BooksInformation bookInfo) throws LibraryManagementSystemException {
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

				if ((bookName != null && !bookName.isEmpty()) && (bookName.length() > 1)) {
					update.setBookName(bookName);
				}
				if ((bookAuthor != null && !bookAuthor.isEmpty()) && (bookAuthor.length() > 1)) {
					update.setBookAuthor(bookAuthor);
				}
				if ((bookCategory != null && !bookCategory.isEmpty()) && (bookCategory.length() > 1)) {
					update.setBookCategory(bookCategory);
				}
				if ((bookPublisher != null && !bookPublisher.isEmpty()) && (bookPublisher.length() > 1)) {
					update.setBookPublisher(bookPublisher);
				}
				transaction.commit();
				isUpdated = true;
			} catch (Exception e) {
				throw new LibraryManagementSystemException(
						"Book Id which was given to update is not available, unable to update book");
			} finally {
				manager.close();
			}
		}
		return isUpdated;

	}
}
