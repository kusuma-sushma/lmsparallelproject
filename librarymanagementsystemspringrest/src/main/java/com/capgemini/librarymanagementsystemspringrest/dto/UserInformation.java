package com.capgemini.librarymanagementsystemspringrest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "lms_spring_allusers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInformation {
	@Id
	@Column
	@GeneratedValue
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
	private String role = "student";
	@Column
	private int noOfBooksBorrowed;
	@Column
	private double fine;

}
