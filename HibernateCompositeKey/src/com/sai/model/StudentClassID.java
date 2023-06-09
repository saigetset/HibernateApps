package com.sai.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class StudentClassID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int studentId;
	private int classId;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
