package com.Models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Class")
public class Class {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="ClassName",nullable = false,length = 100,unique = true)
	private String className;
	
	@OneToMany(targetEntity = Subject.class)
	private Set<Subject> subjects;
	
	@OneToMany(targetEntity = Student.class)
	private Set<Student> student;
	
	public Class(String className) {
		super();
		this.className = className;
	}
	public Class() {super();}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getClassName() {return className;}
	public void setClassName(String className) {this.className = className;}

	
	public Set<Subject> getSubjects() {return subjects;}
	public void setSubjects(Set<Subject> subjects) {this.subjects = subjects;}
	
	public Set<Student> getStudent() {return student;}
	public void setStudent(Set<Student> student) {this.student = student;}

}
