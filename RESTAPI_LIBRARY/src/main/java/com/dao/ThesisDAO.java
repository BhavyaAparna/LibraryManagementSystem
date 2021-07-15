package com.dao;

import java.util.List;


import com.dto.ThesisDetails;
import com.ts.db.HibernateTemplate;

public class ThesisDAO {
	public int additem(ThesisDetails item) {
		System.out.println(item); 
		return HibernateTemplate.addObject(item);
	}
	public List<ThesisDetails> getAllPdfs() {
		List<ThesisDetails> bookDetails=(List)HibernateTemplate.getAllPdfs();
		return bookDetails;	
	}
}
