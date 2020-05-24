package com.capgemini.librarymanagementsystemjpahibernate.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lms_jpa_allusers")
public class UserInformation implements Serializable {
	@Id
	@Column
	private int userId;
	@Column
	private String username;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String department;
	@Column
	private String role="student";
	@Column
	private int noOfBooksBorrowed;
	@Column
	private double fine;


}
