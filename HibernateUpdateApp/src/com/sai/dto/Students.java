package com.sai.dto;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Students {
	
	@Id
	private int id;	
	private String name;
	private int age;
	private String city;
	
	public Students() {
		System.out.println("Students Object created.."+this.hashCode());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
