package com.Models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="StudentTable")
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", fatherName=" + fatherName + ", motherName="
				+ motherName + ", lastName=" + lastName + ", dateOfBirth=" + dateOfBirth + ", fullName=" + fullName
				+ ", address=" + address + ", city=" + city + "]";
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name = "First_Name",nullable = false, length=100)
	private String firstName;
	
	@Column(name = "Father_Name", nullable = false, length=100)
	private String fatherName;
	
	@Column(name = "Mother_Name", nullable = false, length=100)
	private String motherName;
	
	@Column(name = "Last_Name", nullable = false, length=100)
	private String lastName;
	
	@Column(name = "DOBirth", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Column(name = "Full_Name", nullable = false, length=100)
	private String fullName;
	
	@Column(name = "Address", nullable = false, length=100)
	private String address;
	
	@Column(name = "City", nullable = false, length=100)
	private String city;
	
	@ManyToOne(targetEntity = Class.class)
	@JoinColumn(name = "Class")
	private Class cls;
	
	public Student() {super();}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}

	public String getFatherName() {return fatherName;}
	public void setFatherName(String fatherName) {this.fatherName = fatherName;}

	public String getMotherName() {return motherName;}
	public void setMotherName(String motherName) {this.motherName = motherName;}

	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	
	public Date getDateOfBirth() {return dateOfBirth;}
	public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}

	public String getFullName() {return fullName;}
	public void setFullName() {this.fullName = firstName+" "+fatherName+" "+lastName;}

	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String getCity() {return city;}
	public void setCity(String city) {this.city = city;}

	public Class getCls() {return cls;}
	public void setCls(Class cls) {this.cls = cls;}

	public Student(String firstName, String fatherName, String motherName, String lastName, Date dateOfBirth, String address, String city, Class cls) {
		super();
		this.firstName = firstName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.lastName = lastName;
		setFullName();
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.cls = cls;
	}
	
	
	
	

}
