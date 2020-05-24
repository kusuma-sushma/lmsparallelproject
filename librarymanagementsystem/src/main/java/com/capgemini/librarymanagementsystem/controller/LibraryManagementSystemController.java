package com.capgemini.librarymanagementsystem.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.capgemini.librarymanagementsystem.dto.AdminInformation;
import com.capgemini.librarymanagementsystem.dto.BooksInformation;
import com.capgemini.librarymanagementsystem.dto.UserInformation;
import com.capgemini.librarymanagementsystem.dto.UserRequestInformation;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.factory.LibraryManagementSystemFactory;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.UserService;
import com.capgemini.librarymanagementsystem.validation.LibraryManagementSystemValidation;

public class LibraryManagementSystemController {

	public static void controller() {

		BooksInformation bookInfo = LibraryManagementSystemFactory.getBookInfo();
		LibraryManagementSystemValidation validation = LibraryManagementSystemFactory.getValidation();
		UserInformation userInfo = LibraryManagementSystemFactory.getUserInfo();
		AdminService adminService = LibraryManagementSystemFactory.getAdminService();
		UserService userService = LibraryManagementSystemFactory.getUserService();
		Calendar calendar = Calendar.getInstance();
		Date date = LibraryManagementSystemFactory.getDate();
		Date actualReturnDate = LibraryManagementSystemFactory.getDate();
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

							AdminInformation adminLogin = adminService.adminLogin(adminEmail, adminPassword);
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
									System.out.println("press 7 to collect return books");
									System.out.println("press 8 to search book");
									System.out.println("press 9 to update book");
									System.out.println("press 10 to delete book");
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
										System.out.println("userId is " + userId);
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
												System.out.println("user added succesfully");

											} else {
												System.out.println("User's email or id already exists");
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
										System.out.println("BookId is " + bookId);
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
											System.out.println("Book added successfully");
										else
											System.out.println("Book is already added");
										break;

									case 3:
										try {
											System.out.println(
													"Showing all the users who has registered with the help of admin");
											System.out.println("********************");
											List<UserInformation> listUsers = adminService.showAllUsers();

											System.out.println(String.format("%-10s %-10s %-20s %-15s %s", "USERID",
													"USERNAME", "USEREMAIL", "DEPARTMENT", "BOOKSBORROWED"));

											for (UserInformation user : listUsers) {
												System.out.println(String.format("%-10s %-10s %-20s %-15s %s",
														user.getUserId(), user.getUsername(), user.getEmail(),
														user.getDepartment(), user.getNoOfBooksBorrowed()));
											}
											System.out.println("********************");
										} catch (Exception e) {
											System.err.println("No user present in library");
										}
										break;

									case 4:
										try {
											System.out.println("Showing all the books present in the library");
											System.out.println("********************");
											List<BooksInformation> listBooks = adminService.showAllBooks();

											System.out.println(String.format("%-10s %-30s %-20s %-20s  %s", "BOOKID",
													"BOOKNAME", "BOOKCATEGORY", "BOOKAUTHOR", "BOOKPUBLISHER"));

											for (BooksInformation book1 : listBooks) {
												System.out.println(String.format("%-10s %-30s %-20s %-20s %s",
														book1.getBookId(), book1.getBookName(), book1.getBookCategory(),
														book1.getBookAuthor(), book1.getBookPublisher(),
														book1.isBookAvailable()));
											}
											System.out.println("********************");
										} catch (Exception e) {
											System.err.println("No book present in library");
										}
										break;
									case 5:
										try {
											System.out.println("Showing all Requests for Book");
											System.out.println("********************");
											List<UserRequestInformation> requestInfo1 = adminService.showAllRequests();
											System.out.println(String.format("%-10s %-25s %-35s %-40s %-20s %s",
													"BOOKID", "USERId", "DATEOFISSUED", "DATEOFRETURN", "ISBOOKISSUED",
													"ISBOOKRETURNED"));

											for (UserRequestInformation request : requestInfo1) {
												System.out.println(String.format("%-10s %-25s %-35s %-40s %-20s %s",
														request.getBookId(), request.getUserId(),
														request.getDateOfIssued(), request.getDateOfReturn(),
														request.isBookIssued(), request.isBookReturned()));
											}
											System.out.println("********************");
										} catch (Exception e) {
											System.err.println("No book request found");
										}
										break;
									case 6:
										try {
											System.out.println("enter Book Id of 6 digits");
											String issueBookId = scanner.next();
											boolean isIssue = validation.validateById(issueBookId);
											while (!isIssue) {
												try {
													throw new LibraryManagementSystemException(
															"Id should contain exactly 6 digits and should not start with zero");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													issueBookId = scanner.next();
													if (validation.validateById(issueBookId)) {
														break;
													}
												}
											}
											System.out.println("enter User Id  of 6 digits");
											String issueUserId = scanner.next();
											boolean isIssueUserId = validation.validateById(issueUserId);
											while (!isIssueUserId) {
												try {
													throw new LibraryManagementSystemException(
															"Id should contain exactly 6 digits and should not start with zero");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													issueUserId = scanner.next();
													if (validation.validateById(issueUserId)) {
														break;
													}
												}
											}
											boolean isBookIssued = adminService.issueBook(Integer.parseInt(issueUserId),
													Integer.parseInt(issueBookId));
											if (isBookIssued) {
												calendar.add(Calendar.DATE, 15);
												date = calendar.getTime();
												actualReturnDate = calendar.getTime();
												System.err.println("Book has issued successfully to user");
												System.err.println(
														"Book needs to be returned by----> " + actualReturnDate);
											} else {
												System.err.println(
														"Request Id is invalid, Book cannot be issued to user");
											}

										} catch (Exception e) {
											System.err.println("Request Id is invalid book cannot be issued");
										}
										break;
									case 7:
										try {
											System.out.println("Receive Returned Book");
											System.out.println("********************");
											System.out.println("Enter User Id of 6 digits");
											String userReturn = scanner.next();
											boolean isUserReturn = validation.validateById(userReturn);
											while (!isUserReturn) {
												try {
													throw new LibraryManagementSystemException(
															"Id should contain exactly 6 digits and should not start with zero ");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													userReturn = scanner.next();
													if (validation.validateById(userReturn)) {
														break;
													}
												}
											}
											System.out.println("Enter Book Id");
											String returnBook = scanner.next();
											boolean isBookReturn = validation.validateById(returnBook);
											while (!isBookReturn) {
												try {
													throw new LibraryManagementSystemException(
															"Id should contain exactly 6 digits and should not start with zero");
												} catch (LibraryManagementSystemException lmse) {
													System.err.println(lmse.getMessage());
													userReturn = scanner.next();
													if (validation.validateById(returnBook)) {
														break;
													}
												}
											}
											boolean isReceived = adminService.isBookRecevied(
													Integer.parseInt(userReturn), Integer.parseInt(returnBook));
											if (isReceived) {
												System.err.println("Admin received returned book by user");
												System.err.println("Fine is " + userInfo.getFine());
											} else {
												System.err.println(
														"Invalid user or book details. Admin unable to receive");
											}
										} catch (Exception e) {
											System.err.println("Exception due to invalid credentials");
										}
										break;
									case 8:
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
											System.out.println("*********************");
										} else {
											System.err.println("No book found by the bookid which u r searching for");
										}
										break;
									case 9:
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

										BooksInformation bookUpdate = adminService
												.updateBook(Integer.parseInt(updateById));
										if (bookUpdate != null) {
											System.out.println("press 1 to update book name");
											System.out.println("press 2 to update author");
											System.out.println("press 3 to update category");
											System.out.println("press 4 to update publisher");

											int updateBookDetails = scanner.nextInt();
											switch (updateBookDetails) {

											case 1:
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
												break;
											case 2:
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
												break;
											case 3:
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
												break;

											case 4:
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
												break;
											}
											bookInfo.setBookId(Integer.parseInt(updateById));
											System.err.println("Book is updated successfully");
											break;
										} else {
											System.err.println(
													"bookId which was given is not in existing hence unable to update");
										}
										break;
									case 10:
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
													"Bookid which was given is not in existing hence book cannot be removed");
										}
										break;

									default:
										System.err.println("please choose the digits from 0 to 10");
										break;
									} // switch controller1
								} while (controller1 != 0); // do loop
							} else {
								System.err.println("Admin credentials which was entered is invalid");
								controller();
							}
						} catch (InputMismatchException ime) {
							System.err.println("please choose the digits from 0 to 10");
							controller();
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
											System.out.println("*****************");
										} else {
											System.err.println("No book found by the bookid which u r searching for");
										}
										break;
									case 2:
										System.out.println("Showing all the books present in the library");
										System.out.println("********************");
										List<BooksInformation> listBook = adminService.showAllBooks();
										System.out.println(String.format("%-10s %-30s %-20s %-20s %s", "BOOKID",
												"BOOKNAME", "BOOKCATEGORY", "BOOKAUTHOR", "BOOKPUBLISHER"));

										for (BooksInformation book1 : listBook) {
											System.out.println(String.format("%-10s %-30s %-20s %-20s %s",
													book1.getBookId(), book1.getBookName(), book1.getBookCategory(),
													book1.getBookAuthor(), book1.getBookPublisher(),
													book1.isBookAvailable()));
										}
										System.out.println("******************");
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
											UserRequestInformation request = userService
													.borrowBook(Integer.parseInt(userId), Integer.parseInt(bookId));
											if (request != null) {
												System.out.println("Request placed to admin");
												System.out.println("User Id----->" + request.getUserId());
												System.out.println("Book Id----->" + request.getBookId());
											} else {
												System.err.println("UserId or BookId is invalid");
											}
										} catch (LibraryManagementSystemException lmse) {

											System.err.println("UserId or BookId is invalid");
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
												System.err.println(lmse.getMessage());
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
											UserRequestInformation requestInfo = userService.returnBook(
													Integer.parseInt(returnUser), Integer.parseInt(returnBook));
											if (requestInfo != null) {
												System.out.println("Book is Returning to Admin by user");
												System.out.println("User Id ------>" + requestInfo.getUserId());
												System.out.println("Book Id ------>" + requestInfo.getBookId());
												System.out.println(
														"Is Returning ------->" + requestInfo.isBookReturned());
											} else {
												System.err.println("UserId or BookId which was entered is invalid");
											}

										} catch (LibraryManagementSystemException lmse) {
											System.out.println("UserId or BookId is invalid");
										}
										break;

									default:
										System.err.println("Please choose the digits from 0 to 4");
										break;
									}// controller2
								} while (controller2 != 0);
							} else {
								System.err.println("User credentials which was entered is invalid");
								controller();
							}
						} catch (InputMismatchException ime) {
							System.err.println("Please choose the digits from 0 to 4");
							controller();
						}
					default:
						System.err.println("please choose the digit either 1 or 2");
						break;
					} // choice

				} while (choice != 0);
			} catch (InputMismatchException ime) {

				System.err.println("please choose the digit either 1 or 2");
				controller();

			} catch (NoSuchElementException nsee) {
				System.err.println("Email or password which is mentioned is invalid. Please enter valid credentials");
				controller();
			} catch (NumberFormatException nfe) {
				System.err.println("Email or password which is mentioned is invalid. Please enter valid credentials");
				controller();
			} catch (Exception e) {
				System.err.println("Email or password which is mentioned is invalid. Please enter valid credentials");
				controller();
			}

		}

	}

}