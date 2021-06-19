package com.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TeacherTable")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "TeacherName", nullable = false, length = 100)
	private String teacherName;

	public Teacher() {super();}

	public Teacher(String teacherName) {
		super();
		this.teacherName = teacherName;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getTeacherName() {return teacherName;}
	public void setTeacherName(String teacherName) {this.teacherName = teacherName;}
}
