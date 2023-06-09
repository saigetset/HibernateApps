package com.sai.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Students {
	
	
	@Id
	@GenericGenerator(name="gen",strategy="com.sai.generator.CollegeIDGenerator")
	@GeneratedValue(generator="gen")
	private String id;
	private String name;
	private int age;
	private String city;
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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
		return "Students [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}
