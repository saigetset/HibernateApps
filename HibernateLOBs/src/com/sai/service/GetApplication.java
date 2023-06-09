package com.sai.service;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sai.HibernateUtil.HibernateUtil;
import com.sai.model.Students;

public class GetApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Session session = null;
		Students std = null;
		int id=1;
		try {
			session = HibernateUtil.getSession();
			std = session.get(Students.class, id);// if id  not found, then null will be returned		
			if(std != null) {
				System.out.println("ID :"+std.getId());
				System.out.println("Name :"+std.getName());
				System.out.println("Age :"+std.getAge());
				System.out.println("City :"+std.getCity());
				
				try(FileOutputStream fos = new FileOutputStream("./outputs/image.jpg");FileWriter writer = new FileWriter("./outputs/resume.txt")){
					fos.write(std.getPhoto());
					writer.write(std.getResume());
					System.out.println("Photo and Resume are stored to ./outputs");
				}
				
			}else {
				System.out.println("Record Not Found..");				
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}finally {
			HibernateUtil.closeSession(session);
		}
	}
}
