package edu.mum.cs425.project.eshoppers.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
 @Table(name="Customers")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cid;
	@Column (name="First_Name")
	@NotEmpty
	private String firstName;
	@Column (name="Last_Name")
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String gender;
	@Column (name="Phone_Number")
	@NotEmpty
	private String phoneNumber;
	@NotNull
    private String street;
	@NotEmpty
	private String city;
	@NotEmpty
	private String state;
	@NotNull
	@Size(min=5, max=5)
	private int zipcode;
	@NotEmpty
	private String country;
	@NotNull
	private long cardNumber;
	@NotNull
	private int ccv;
	@NotNull()
	@Future()
	private LocalDate cardExpirationDate;
	@NotEmpty
	@Size(min=5)
	private String password;
	@NotEmpty
	@Email
	private String email;
     public Customer()
	 {}

	public Customer(String firstName,String lastName, String gender,String phoneNumber,String street, String city, String state, int zipcode, String country,long cardNumber, int ccv, LocalDate cardExpirationDate, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.cardNumber = cardNumber;
		this.ccv = ccv;
		this.cardExpirationDate = cardExpirationDate;
		this.password = password;
		this.email = email;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCcv() {
		return ccv;
	}

	public void setCcv(int ccv) {
		this.ccv = ccv;
	}

	public LocalDate getCardExpirationDate() {
		return cardExpirationDate;
	}

	public void setCardExpirationDate(LocalDate cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
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
