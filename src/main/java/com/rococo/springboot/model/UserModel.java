package com.rococo.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "user") // This tells Hibernate to name the table as User and not UserModel
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Username should at least have 2 characters")
	@Size(max = 15, message = "Username should not exceed 15 characters")
	private String username;

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Password should at least have 2 characters")
	@Size(max = 15, message = "Password should not exceed 15 characters")
	private String pass;

	public String getPassword() {
		return this.pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "First Name should at least have 2 characters")
	@Size(max = 15, message = "FirstName should not exceed 15 characters")
	private String first_name;

	public String getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@NotNull
	@NotEmpty
	@Size(min = 2, message = "Last Name should at least have 2 characters")
	@Size(max = 15, message = "Last Name should not exceed 15 characters")
	private String last_name;

	public String getLast_name() {
		return this.last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	private String email;

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
