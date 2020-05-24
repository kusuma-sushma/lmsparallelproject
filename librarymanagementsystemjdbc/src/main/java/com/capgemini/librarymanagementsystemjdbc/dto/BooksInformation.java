package com.capgemini.librarymanagementsystemjdbc.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BooksInformation implements Serializable {

	private int bookId;
	private String bookName;
	private String bookCategory;
	private String bookAuthor;
	private String bookPublisher;
	private boolean bookAvailable;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public boolean isBookAvailable() {
		return bookAvailable;
	}

	public void setBookAvailable(boolean bookAvailable) {
		this.bookAvailable = bookAvailable;
	}

}
