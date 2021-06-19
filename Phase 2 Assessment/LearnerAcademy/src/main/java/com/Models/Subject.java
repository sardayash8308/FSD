package com.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="SubjectTable")
public class Subject {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;
	
	@Column(name="Subject")
	private String subject;
	
	@OneToOne(targetEntity = Teacher.class)
	@JoinColumn(name = "Teacher")
	private Teacher teacher;
	
	@ManyToOne( targetEntity=Class.class, fetch = FetchType.LAZY)
	@JoinColumn(name="class")
	private Class assignedClass;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getSubject() {return subject;}
	public void setSubject(String subject) {this.subject = subject;}
	
	public Teacher getTeacher() {return teacher;}
	public void setTeacher(Teacher teacher) {this.teacher = teacher;}
	
	public Class getAssignedClass() {return assignedClass;}
	public void setAssignedClass(Class assignedClass) {this.assignedClass = assignedClass;}
	
	public Subject(String subject) {
		super();
		this.subject = subject;
	}
	@Override
	public String toString() {return "Subjects [id=" + id + ", subject=" + subject + "]";}
	public Subject() {super();}
	
	
	

}
