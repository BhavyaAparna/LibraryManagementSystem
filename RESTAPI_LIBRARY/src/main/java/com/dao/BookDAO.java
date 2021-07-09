package com.dao;

import java.util.List;

import com.dto.BookDetails;
import com.ts.db.HibernateTemplate;

public class BookDAO {
	public int additem(BookDetails item) {
		System.out.println(item); 
		return HibernateTemplate.addObject(item);
	}
	public List<BookDetails> getAllBookDetailsByImage() {
		List<BookDetails> bookDetails=(List)HibernateTemplate.getObjectByBookImage();
		return bookDetails;	
	}
}
