package com.sai.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Students implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private StudentClassID scid;//injection: Has-A RELATION
	private String name;
	private int age;
	private String city;
	
	public StudentClassID getScid() {
		return scid;
	}
	public void setScid(StudentClassID scid) {
		this.scid = scid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + scid + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}
