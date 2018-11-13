package edu.mum.cs425.project.eshoppers.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column (name="First_Name")
	@NotEmpty
	private String firstName;
	@Column (name="Last_Name")
	@NotEmpty
	private String lastName;
	@Column (name="Phone_Number")
	@NotEmpty
	private String phoneNumber;
	@NotEmpty
	@Size(min=5)
	private String password;
	@NotEmpty
	@Email
	private String email;

	public Admin() {
		
	}

	public Admin(String firstName, String lastName, String phoneNumber, String password,String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.email = email;
	}

	public Long getAid() {
		return id;
	}

	public void setAid(Long aid) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
