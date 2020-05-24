package com.capgemini.librarymanagementsystemjdbc.dao;

public interface QueryMapper {

	String adminLogin = "select * from lms_allusers where email=? and password=? and role='Admin'";
	String userLogin = "select * from lms_allusers where email=? and password=? and role='student' or 'Student'";
	String addUser = "insert into lms_allusers (id,username,email,password,department) values(?,?,?,?,?)";
	String addBook = "insert into lms_books (bookid,bookname,bookauthor,bookcategory,bookpublisher) values(?,?,?,?,?)";
	String removeBook = "delete from lms_books where bookid=?";
	String updateBook = "update lms_books set bookname=?, bookauthor=?, bookcategory=?, bookpublisher=? where bookid=?";
	String update = "update lms_books set bookname=? where bookid=?";
	String searchBook = "select * from lms_books where bookid=?";
	String showAllBooks = "select * from lms_books";
	String showAllUsers = "select * from lms_allusers";
	String showAllRequest = "select * from lms_request_jdbc";
	String bookRequest = "select count(*) from lms_request_jdbc where userId = ?";
	String borrowBook = "insert into lms_request_jdbc (requestId,userId,bookId) values(?,?,?)";
	String isBookAvailable = "select * from lms_books where bookId = ?";
	String getRequestId = "select * from book_request where requestId=?";
	String getUsersBooks = "select * from  lms_allusers where id=?";
	String issueBook = "update lms_request_jdbc set issueDate=now(), expectedReturnDate=date_add(issueDate,interval 15 day)where requestId=? ";
	String bookAvailable = "update lms_books set bookAvailable=false where bookid=?";
	String setNoOfBooksBorrowed = "update lms_allusers set noOfBooksBorrowed=? and id=?";
	String updateRequest = "select * from lms_request_jdbc where (userId = ? and bookId = ?)  and (issueDate  is not null and returnedDate is null)";
	String setReturnDate = "update lms_request_jdbc set returnedDate=now() where requestId=?";
	String request = "select * from lms_request_jdbc where requestId=?";
	String getFine = "select differenceDate(?,?) from lms_request_jdbc where requestId = ?";
	String userBook = "select noOfBooksBorrowed from lms_allusers where id=?";
	String userFine = "update lms_allusers set fine=? and noOfBooksBorrowed=? where id=?";
	String setBookAvailable = "update lms_books set bookAvailable=true where bookid=?";
	String removeRequest = "delete from  lms_request_jdbc  where requestId=?";
}
