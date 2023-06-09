package com.sai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Students {
	
	@Id
	/*
	 * @GenericGenerator(name="gen",strategy="increment")
	 * 
	 * @GeneratedValue(generator="gen")
	 */
	/*
	 * @GenericGenerator(name="gen1",strategy="sequence")
	 * 
	 * @GeneratedValue(generator="gen")
	 */
	/*
	 * @GenericGenerator(name="gen1",strategy="sequence",parameters =
	 * { @Parameter(value = "id_seq", name = "sequence_name") })
	 * 
	 * @GeneratedValue(generator="gen1")
	 */
	/*
	 * @GenericGenerator(name="gen1",strategy="identity")
	 * 
	 * @GeneratedValue(generator="gen1")
	 */
	@GenericGenerator(name="gen1",strategy="")
	@GeneratedValue(generator="gen1")
	private int id;
	private String name;
	private int age;
	private String city;
	
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
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", city=" + city + "]";
	}
}
