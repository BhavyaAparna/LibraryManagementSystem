package com.dao;

import java.util.List;

import com.dto.BookingDetails;
import com.dto.FacultyDetails;
import com.dto.StudentDetails;
import com.ts.db.HibernateTemplate;

public class BookingDAO {
	
	public List<BookingDetails> getAllBookingDetails() {
		List<BookingDetails> bookDetails=(List)HibernateTemplate.getAllBookingDetails();
		return bookDetails;	
	}
	public int register(BookingDetails user) {
		System.out.println(user); 
		return HibernateTemplate.addObject(user);
	}
	public void delete(int editUser) {
		System.out.println(editUser); 
		HibernateTemplate.delete(editUser);
	}
	
}
