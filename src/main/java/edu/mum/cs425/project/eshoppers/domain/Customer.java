package edu.mum.cs425.project.eshoppers.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name="customers")
@SecondaryTable(name="User" ,pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long cid;
//	@Column (name="First_Name")
	@NotEmpty
	private String firstName;
	@Column (name="Last_Name")
	@NotEmpty
	private String lastName;
//	@NotEmpty
	private String gender;
	@Column (name="Phone_Number")
	@NotEmpty
	private String phoneNumber;
	@NotNull
    private String street;
   @NotEmpty
	private String city;
	//@NotEmpty
	private String state;
	@NotNull
	//@Size(min=5, max=5)
	private int zipcode;
   @NotEmpty
	private String country;
	@NotNull
	private long cardNumber;
    @NotNull
	private int ccv;
//	@NotNull()
	//@Future()
   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate cardExpirationDate;
	@NotEmpty
	@Size(min=5)
   @Column(table = "User")
	private String password;
//	@NotEmpty
	@Email
    @Column(table = "User")
	private String email;
	@Column(table = "User")
    private String Role;
     public Customer()
	 {}

	public Customer(String firstName, String lastName, String gender, String phoneNumber, String street, String city, String state, int zipcode, String country, long cardNumber, int ccv, LocalDate cardExpirationDate, String password, String email, String role) {
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
		this.Role = role;
	}

	public String isRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
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

	@Override
	public String toString() {
		return "Customer{" +
				"cid=" + cid +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", gender='" + gender + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zipcode=" + zipcode +
				", country='" + country + '\'' +
				", cardNumber=" + cardNumber +
				", ccv=" + ccv +
				", cardExpirationDate=" + cardExpirationDate +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
