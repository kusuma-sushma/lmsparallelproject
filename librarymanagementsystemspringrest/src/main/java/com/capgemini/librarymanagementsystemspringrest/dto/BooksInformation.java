package com.capgemini.librarymanagementsystemspringrest.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lms_spring_allbooks")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BooksInformation implements Serializable {
	@Id
	@Column
	@GeneratedValue
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
	private boolean bookAvailable = true;

}
