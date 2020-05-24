package com.capgemini.librarymanagementsystemjpahibernate.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lms_jpa_lms_request")
public class UserRequestInformation implements Serializable {
	@Id
	@Column
	private int requestId;
	@Column
	private int bookId;
	@Column
	private int userId;
	@Column
	private Date issueDate;
	@Column
	private Date expectedReturnDate;
	@Column
	private Date returnedDate;

}
