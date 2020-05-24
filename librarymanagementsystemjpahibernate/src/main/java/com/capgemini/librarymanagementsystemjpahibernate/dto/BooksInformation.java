package com.capgemini.librarymanagementsystemjpahibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lms_jpa_allbooks")

public class BooksInformation implements Serializable {
	@Id
	@Column
	private int bookId;
	@Column
	private String bookName;
	@Column
	private String bookAuthor;
	@Column
	private String bookCategory;
	@Column
	private String bookPublisher;
	@Column(columnDefinition = "TINYINT")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean bookAvailable=true;

}
