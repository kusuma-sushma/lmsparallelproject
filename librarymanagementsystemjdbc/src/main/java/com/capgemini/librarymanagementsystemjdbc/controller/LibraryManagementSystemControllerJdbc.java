package com.capgemini.librarymanagementsystemjdbc.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.capgemini.librarymanagementsystemjdbc.dto.BooksInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserInformation;
import com.capgemini.librarymanagementsystemjdbc.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystemjdbc.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystemjdbc.factory.LibraryManagementSystemFactory;
import com.capgemini.librarymanagementsystemjdbc.service.AdminService;
import com.capgemini.librarymanagementsystemjdbc.service.UserService;
import com.capgemini.librarymanagementsystemjdbc.validation.LibraryManagementSystemValidation;

public class LibraryManagementSystemControllerJdbc {

	@SuppressWarnings("static-access")
	public static void jdbcController() {
		AdminService adminService = LibraryManagementSystemFactory.getAdminService();
		UserService userService = LibraryManagementSystemFactory.getUserService();
		Date date = LibraryManagementSystemFactory.getDate();
		Calendar calendar = Calendar.getInstance();
		Date actualReturnDate = LibraryManagementSystemFactory.getDate();
		LibraryManagementSystemValidation validation = LibraryManagementSystemFactory.getValidation();
		int choice;
		int controller1;
		int controller2;
		try (Scanner scanner = new Scanner(System.in)) {
			try {
				do {
					System.out.println("press 1 to AdminLogin");
					System.out.println("press 2 to UserLogin");
					System.out.println("********************");
					choice = scanner.nextInt();
					switch (choice) {
					case 1:
						try {
							System.out.println("Enter Email  for ex:sushma@gmail.com");
							String adminEmail = scanner.next();
							boolean isValidEmail = validation.validateByEmail(adminEmail);
							while (!isValidEmail) {
								try {
									throw new LibraryManagementSystemException(
											"Email Should contain @ and .com, .in, .org at last");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									adminEmail = scanner.next();
									if (validation.validateByEmail(adminEmail)) {
										break;
									}
								}
							}
							System.out.println("Enter password of 6 digits");
							String adminPassword = scanner.next();
							boolean isValidPassword = validation.validateByPassword(adminPassword);
							while (!isValidPassword) {
								try {
									throw new LibraryManagementSystemException(
											"Password should contain atleast 6 Characters");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									adminPassword = scanner.next();
									if (validation.validateByPassword(adminPassword)) {
										break;
									}
								}
							}

							UserInformation adminLogin = adminService.adminLogin(adminEmail, adminPassword);
							if (adminLogin != null) {
								System.out.println("Admin Logged in successfully");
								do {
									System.err.println("Welcome to Admin Operations");
									System.out.println("press 1 to add user");
									System.out.println("press 2 to addbook");
									System.out.println("press 3 to show all users");
									System.out.println("press 4 to show all books");
									System.out.println("press 5 to show all requests");
									System.out.println("press 6 to issue book");
									System.out.println("press 7 to search book");
									System.out.println("press 8 to update book");
									System.out.println("press 9 to delete book");
									System.out.println("press 0 to exit");
									System.out.println("**************************");
									controller1 = scanner.nextInt();

									switch (controller1) {
									case 1:
										UserInformation userInformation = LibraryManagementSystemFactory.getUserInfo();
										int userId = (int) (Math.random() * 1000000);
										if (userId <= 100000) {
											userId = userId + 100000;
										}
										userInformation.setUserId(userId);
										System.err.println("userId is " + userId);
										System.out.println("Enter user Name");
										String username = scanner.nextLine();
										boolean isValidUN = validation.validateByName(username);
										while (!isValidUN) {
											try {
												throw new LibraryManagementSystemException(
														"User Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												username = scanner.nextLine();
												if (validation.validateByName(username)) {
													break;
												}
											}
										}
										userInformation.setUsername(username);
										System.out.println("Enter Email ex:sushma@gmail.com");
										String userEmail = scanner.next();
										boolean isVaildEmail = validation.validateByEmail(userEmail);
										while (!isVaildEmail) {
											try {
												throw new LibraryManagementSystemException(
														"Email Should contain @ and .com, .in, .org at last");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												userEmail = scanner.next();
												if (validation.validateByEmail(userEmail)) {
													break;
												}
											}
										}
										userInformation.setEmail(userEmail);
										System.out.println("Enter Password of 6 digits");
										String userPassword = scanner.next();
										boolean isVaildPassword = validation.validateByPassword(userPassword);
										while (!isVaildPassword) {
											try {
												throw new LibraryManagementSystemException(
														"Password should contain exactly 6 characters");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												userPassword = scanner.next();
												if (validation.validateByPassword(userPassword)) {
													break;
												}
											}
										}
										userInformation.setPassword(userPassword);
										System.out.println("Enter Department");
										String userDepartment = scanner.nextLine();
										boolean isValidDept = validation.validateByName(userDepartment);
										while (!isValidDept) {
											try {
												throw new LibraryManagementSystemException(
														"Department should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												userDepartment = scanner.nextLine();
												if (validation.validateByName(userDepartment)) {
													break;
												}
											}
										}
										userInformation.setDepartment(userDepartment);
										try {
											boolean add = adminService.addUser(userInformation);
											if (add) {
												System.err.println("user added succesfully");

											}
										} catch (Exception e) {
											System.err.println("please enter valid data");
										}
										break;
									case 2:
										BooksInformation book = LibraryManagementSystemFactory.getBookInfo();
										int bookId = (int) (Math.random() * 1000000);
										if (bookId <= 100000) {
											bookId = bookId + 100000;
										}
										book.setBookId(bookId);
										System.err.println("BookId is " + bookId);
										System.out.println("Enter book name");
										String bookName = scanner.nextLine();
										boolean isValidName = validation.validateByName(bookName);
										while (!isValidName) {
											try {
												throw new LibraryManagementSystemException(
														"Book Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												bookName = scanner.nextLine();
												if (validation.validateByName(bookName)) {
													break;
												}
											}
										}
										book.setBookName(bookName);
										System.out.println("Enter category name");
										String categoryName = scanner.nextLine();
										boolean isValidCategory = validation.validateByName(categoryName);
										while (!isValidCategory) {
											try {
												throw new LibraryManagementSystemException(
														"Category Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												categoryName = scanner.nextLine();
												if (validation.validateByName(categoryName)) {
													break;
												}
											}
										}
										book.setBookCategory(categoryName);
										System.out.println("Enter author name");
										String authorName = scanner.nextLine();
										boolean isValidAuthor = validation.validateByName(authorName);
										while (!isValidAuthor) {
											try {
												throw new LibraryManagementSystemException(
														"Author Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												authorName = scanner.nextLine();
												if (validation.validateByName(authorName)) {
													break;
												}
											}
										}
										book.setBookAuthor(authorName);
										System.out.println("Enter publishers name");
										String bookPublisher = scanner.nextLine();
										boolean isValidPublisher = validation.validateByName(bookPublisher);
										while (!isValidPublisher) {
											try {
												throw new LibraryManagementSystemException(
														"Publisher Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												bookPublisher = scanner.nextLine();
												if (validation.validateByName(bookPublisher)) {
													break;
												}
											}
										}
										book.setBookPublisher(bookPublisher);
										boolean result = adminService.addBook(book);
										if (result)
											System.err.println("Book added successfully");
										else
											System.err.println("Book is already added");
										break;

									case 3:
										try {
											System.out.println(
													"Showing all the users who has registered with the help of admin");
											System.out.println("********************");
											List<UserInformation> listUsers = adminService.showAllUsers();
											System.out.println(
													String.format("%-10s %-15s %-30s %-15s %-25s %-15s %-10s -%s",
															"USERID", "USERNAME", "EMAIL", "PASSWORD", "DEPARTMENT",
															"ROLE", "Fine", "BOOKSBORROWED"));

											for (UserInformation user : listUsers) {
												System.out.println(
														String.format("%-10s %-15s %-30s %-15s %-25s %-15s %-10s -%s",
																user.getUserId(), user.getUsername(), user.getEmail(),
																user.getPassword(), user.getDepartment(),
																user.getRole(), user.getFine(), user.getNoOfBooks()));
											}
											System.out.println("*********************");
										} catch (Exception e) {
											System.err.println("no user are present in library");
										}
										break;

									case 4:
										try {
											System.out.println("Showing all the books present in the library");
											System.out.println("********************");
											List<BooksInformation> listBooks = adminService.showAllBooks();

											System.out.println(String.format("%-10s %-30s %-20s %-20s %-20s %s",
													"BOOKID", "BOOKNAME", "BOOKCATEGORY", "BOOKAUTHOR", "BOOKPUBLISHER",
													"BOOKAVALIABLITY"));

											for (BooksInformation book1 : listBooks) {
												System.out.println(String.format("%-10s %-30s %-20s %-20s %-20s %s",
														book1.getBookId(), book1.getBookName(), book1.getBookCategory(),
														book1.getBookAuthor(), book1.getBookPublisher(),
														book1.isBookAvailable()));
											}
											System.out.println("******************");
										} catch (Exception e) {
											System.err.println("No such book present in library");
										}
										break;
									case 5:
										try {
											System.out.println("Showing all Requests for Book");
											System.out.println("********************");
											List<UserRequestInformation> requestInfo1 = adminService.showAllRequests();
											System.out.println(String.format("%-15s %-30s %-35s %-35s %-35s %-10s",
													"REQUESTID", "USERID", "BOOKID", "DATEOFISSUED",
													"EXPECTEDRETURNDATE", "RETURNDATE"));

											for (UserRequestInformation request : requestInfo1) {
												System.out.println(String.format("%-15s %-30s %-35s %-35s %-35s %-10s",
														request.getRequestId(), request.getUserId(),
														request.getBookId(), request.getIssueDate(),
														request.getExpectedReturnDate(), request.getReturnedDate()));
											}
											System.out.println("**********************");
										} catch (Exception e) {
											System.err.println("no book request present");
										}
										break;
									case 6:
										try {
											System.out.println("enter Request Id of 6 digits");
											String requestId = scanner.next();
											boolean isIssue = validation.validateById(requestId);
											while (!isIssue) {
												try {
													throw new LibraryManagementSystemException(
															"Id should contain exactly 6 digits and should not start with zero");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													requestId = scanner.next();
													if (validation.validateById(requestId)) {
														break;
													}
												}
											}
											boolean isBookIssued = adminService.issueBook(Integer.parseInt(requestId));
											if (isBookIssued) {
												calendar.add(Calendar.DATE, 15);
												date = calendar.getTime();
												actualReturnDate = calendar.getTime();
												System.out.println("Book has issued successfully to user");
												System.out.println(
														"Book needs to be returned by----> " + actualReturnDate);
											} else {
												System.out.println(
														"Request Id is invalid, Book cannot be issued to user");
											}

										} catch (Exception e) {
											System.out.println("Request Id is invalid book cannot be issued");
										}
										break;
									case 7:
										System.out.println("Enter book id  of 6 digits to search");
										String searchById = scanner.next();
										boolean searchByBook = validation.validateById(searchById);
										while (!searchByBook) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												searchById = scanner.next();
												if (validation.validateById(searchById)) {
													searchByBook = true;
													break;
												}
											}
										}
										BooksInformation search = adminService.searchBook(Integer.parseInt(searchById));
										if (search != null) {

											System.out.println("book has founded");
											System.out.println("Book id----> " + search.getBookId());
											System.out.println("Book Name----> " + search.getBookName());
											System.out.println("Book Author----> " + search.getBookAuthor());
											System.out.println("Book Category----> " + search.getBookCategory());
											System.out.println("Book Publisher----> " + search.getBookPublisher());
											System.out.println("Is Book Available--->" + search.isBookAvailable());
											System.out.println("********************");
										} else {
											System.err.println("No book found by the bookid which u r searching for");
										}
										break;
									case 8:
										BooksInformation bookUpdate = new BooksInformation();

										System.out.println("Enter book id of 6 digits to update");
										String updateById = scanner.next();
										boolean updateBook = validation.validateById(updateById);
										while (!updateBook) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												updateById = scanner.next();
												if (validation.validateById(updateById)) {
													break;
												}
											}
										}
										bookUpdate.setBookId(Integer.parseInt(updateById));
										System.out.println("Enter book name");
										String bookName1 = scanner.nextLine();
										boolean isValidName1 = validation.validateByName(bookName1);
										while (!isValidName1) {
											try {
												throw new LibraryManagementSystemException(
														"Book Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												bookName1 = scanner.nextLine();
												if (validation.validateByName(bookName1)) {
													break;
												}
											}
										}
										bookUpdate.setBookName(bookName1);
										System.out.println("Enter author name");
										String authorName1 = scanner.nextLine();
										boolean isValidAuthor1 = validation.validateByName(authorName1);
										while (!isValidAuthor1) {
											try {
												throw new LibraryManagementSystemException(
														"Author Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												authorName1 = scanner.nextLine();
												if (validation.validateByName(authorName1)) {
													break;
												}
											}
										}
										bookUpdate.setBookAuthor(authorName1);
										System.out.println("Enter book category name");
										String categoryName1 = scanner.nextLine();
										boolean isValidCategory1 = validation.validateByName(categoryName1);
										while (!isValidCategory1) {
											try {
												throw new LibraryManagementSystemException(
														"Category Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												categoryName1 = scanner.nextLine();
												if (validation.validateByName(categoryName1)) {
													break;
												}
											}
										}
										bookUpdate.setBookCategory(categoryName1);
										System.out.println("Enter publishers name");
										String bookPublisher1 = scanner.nextLine();
										boolean isValidPublisher1 = validation.validateByName(bookPublisher1);
										while (!isValidPublisher1) {
											try {
												throw new LibraryManagementSystemException(
														"Publisher Name should be alphabets and should contain atleast 3 alphabets");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												bookPublisher1 = scanner.nextLine();
												if (validation.validateByName(bookPublisher1)) {
													break;
												}
											}
										}
										bookUpdate.setBookPublisher(bookPublisher1);
										boolean bookUpdate1 = adminService.updateBook(bookUpdate);
										if (bookUpdate1) {
											System.err.println("Book is updated successfully");

											break;
										} else {
											System.err.println(
													"bookId which was given is not in existing hence unable to update");
										}

										break;
									case 9:
										System.out.println("Enter book id of 6 digits to remove ");
										String removeBookById = scanner.next();
										boolean isRemoved = validation.validateById(removeBookById);
										while (!isRemoved) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												removeBookById = scanner.next();
												if (validation.validateById(removeBookById)) {
													break;
												}
											}
										}
										boolean bookRemoved = adminService.removeBook(Integer.parseInt(removeBookById));
										if (bookRemoved) {
											System.err.println("Book is removed successfully");
										} else {
											System.err.println(
													"Bookid which was given is not present hence book cannot be removed");
										}
										break;

									default:
										System.err.println("please choose the digits from 0 to 9");
										break;

									} // switch controller1
								} while (controller1 != 0); // do loop
							} else {
								System.err.println("Admin credentials which was entered is invalid");
								jdbcController();
							}
						} catch (InputMismatchException ime) {
							System.err.println("please choose the digits from 0 to 9");
							jdbcController();
						}
						break;

					case 2:
						try {
							System.out.println("Enter User Email id for ex:sushma@gmail.com");
							String userEmail = scanner.next();
							boolean isValidUserEmail = validation.validateByEmail(userEmail);
							while (!isValidUserEmail) {
								try {
									throw new LibraryManagementSystemException(
											"Email Should contain @ and .com, .in, .org at last");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									userEmail = scanner.next();
									if (validation.validateByEmail(userEmail)) {
										break;
									}
								}
							}
							System.out.println("Enter User password of 6 digits");
							String userPassword = scanner.next();
							boolean isValidUserPassword = validation.validateByPassword(userPassword);
							while (!isValidUserPassword) {
								try {
									throw new LibraryManagementSystemException(
											"Password should contain exactly 6 characters");
								} catch (LibraryManagementSystemException lmse) {
									System.err.println(lmse.getMessage());
									userPassword = scanner.next();
									if (validation.validateByPassword(userPassword)) {
										break;
									}
								}
							}
							UserInformation userLogin = userService.userLogin(userEmail, userPassword);
							if (userLogin != null) {
								System.out.println("User logged in successfully");
								do {
									System.err.println("Welcome to User Operations");
									System.out.println("press 1 to search books from library");
									System.out.println("press 2 to see all the books present in the library");
									System.out.println("press 3 to request book to admin");
									System.out.println("press 4 to return the issued book to admin");
									System.out.println("press 0 to exit");
									System.out.println("**************************");
									controller2 = scanner.nextInt();
									switch (controller2) {
									case 1:
										System.out.println("Enter id to search");
										String searchById = scanner.next();
										boolean searchByBook = validation.validateById(searchById);
										while (!searchByBook) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												searchById = scanner.next();
												if (validation.validateById(searchById)) {
													break;
												}
											}
										}
										BooksInformation search = adminService.searchBook(Integer.parseInt(searchById));
										if (search != null) {

											System.out.println("book has founded");
											System.out.println("Book id----> " + search.getBookId());
											System.out.println("Book Name----> " + search.getBookName());
											System.out.println("Book Author----> " + search.getBookAuthor());
											System.out.println("Book Category----> " + search.getBookCategory());
											System.out.println("Book Publisher----> " + search.getBookPublisher());
											System.out.println("Is Book Available--->" + search.isBookAvailable());
											System.out.println("********************");
										} else {
											System.err.println("No book found by the bookid which u r searching for");
										}
										break;
									case 2:
										System.out.println("Showing all the books present in the library");
										System.out.println("********************");
										List<BooksInformation> listBook = adminService.showAllBooks();
										System.out.println(String.format("%-10s %-30s %-20s %-20s %-20s %s", "BOOKID",
												"BOOKNAME", "BOOKCATEGORY", "BOOKAUTHOR", "BOOKPUBLISHER",
												"BOOKAVALIABLITY"));

										for (BooksInformation book1 : listBook) {
											System.out.println(String.format("%-10s %-30s %-20s %-20s %-20s %s",
													book1.getBookId(), book1.getBookName(), book1.getBookCategory(),
													book1.getBookAuthor(), book1.getBookPublisher(),
													book1.isBookAvailable()));
										}
										break;
									case 3:
										System.out.println("Enter book id of 6 digits");
										String bookId = scanner.next();
										boolean isValidBookId = validation.validateById(bookId);
										while (!isValidBookId) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												bookId = scanner.next();
												if (validation.validateById(bookId)) {
													break;
												}
											}
										}
										System.out.println("Enter user id of 6 digits");
										String userId = scanner.next();
										boolean isValidUserId = validation.validateById(userId);
										while (!isValidUserId) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												userId = scanner.next();
												if (validation.validateById(userId)) {
													break;
												}
											}
										}
										try {
											boolean request = userService.borrowBook(Integer.parseInt(userId),
													Integer.parseInt(bookId));
											if (request) {
												System.err.println("Request placed to admin");
											} else {
												System.err.println("Invalid userId or bookId unable to make a request");
											}
										} catch (Exception lmse) {

											System.err.println("UserId or BookId which is given is invalid");
										}
										break;
									case 4:
										System.out.println("Returning a book:");
										System.out.println("********************");
										System.out.println("Enter User Id of 6 didgits");
										String returnUser = scanner.next();
										boolean isValidReturnUserId = validation.validateById(returnUser);
										while (!isValidReturnUserId) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println();
												returnUser = scanner.next();
												if (validation.validateById(returnUser)) {
													break;
												}
											}
										}
										System.out.println("Enter Book Id");
										String returnBook = scanner.next();
										boolean isValidReturnBookId = validation.validateById(returnBook);
										while (!isValidReturnBookId) {
											try {
												throw new LibraryManagementSystemException(
														"Id should contain exactly 6 digits and should not start with zero");
											} catch (LibraryManagementSystemException lmse) {
												System.err.println(lmse.getMessage());
												returnBook = scanner.next();
												if (validation.validateById(returnBook)) {
													break;
												}
											}
										}

										try {
											boolean returnBooks = userService.returnBook(Integer.parseInt(returnUser),
													Integer.parseInt(returnBook));
											if (returnBooks) {
												System.err.println("Book is Returned to Admin by user");
											} else {
												System.err.println("Invalid userId or bookId uable to return book");
											}
										} catch (Exception lmse) {
											System.err.println("UserId or BookId is which is given invalid");
										}
										break;

									default:
										System.err.println("Please choose the digits from 0 to 4");
										break;
									}// controller2
								} while (controller2 != 0);
							} else {
								System.err.println("User credentials which was entered is invalid");
								jdbcController();
							}
						} catch (InputMismatchException ime) {
							System.err.println("Please choose the digits from 0 to 4");
							jdbcController();
						}

					default:
						System.err.println("please choose the digit either 1 or 2");
						break;

					} // choice
				} while (choice != 0);

			} catch (InputMismatchException ime) {

				System.err.println("please choose the digit either 1 or 2");
				jdbcController();
			} catch (NoSuchElementException nsee) {
				System.err.println("Email or password which is mentioned is invalid. Please enter valid credentials");
				jdbcController();
			} catch (NumberFormatException nfe) {
				System.err.println("Email or password which is mentioned is invalid. Please enter valid credentials");
				jdbcController();
			} catch (Exception e) {
				System.err.println("Email or password which is mentioned is invalid. Please enter valid credentials");
				jdbcController();
			}

		}

	}

}