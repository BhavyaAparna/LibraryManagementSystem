package com.dao;

import com.dto.FacultyDetails;
import com.dto.StudentDetails;
import com.ts.db.HibernateTemplate;

public class FacultyDAO {
	public int register(FacultyDetails user) {
		System.out.println(user); 
		return HibernateTemplate.addObject(user);
	}
	public FacultyDetails getFacultyByPass(String userEmail,String userPassword) {

		return (FacultyDetails)HibernateTemplate.getObjectByFacultyPass(userEmail,userPassword);
	}
	
	public int update(FacultyDetails editUser) {
		System.out.println(editUser); 
		return HibernateTemplate.updateObject(editUser);
	}

}
