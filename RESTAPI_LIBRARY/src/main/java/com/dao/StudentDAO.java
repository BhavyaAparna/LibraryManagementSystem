package com.dao;

import com.dto.StudentDetails;
import com.ts.db.HibernateTemplate;

public class StudentDAO {
	public StudentDetails getStudentByPass(String userEmail,String userPassword) {

		return (StudentDetails)HibernateTemplate.getObjectByUserPass(userEmail,userPassword);
	}
	public StudentDetails getUserByEmail(String email) {
		return (StudentDetails)HibernateTemplate.getObjectByEmail(email);
	}
	public int register(StudentDetails user) {
		System.out.println(user); 
		return HibernateTemplate.addObject(user);
	}
	public int update(StudentDetails editUser) {
		System.out.println(editUser); 
		return HibernateTemplate.updateObject(editUser);
	}
}
