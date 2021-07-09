package com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class BookDetails {
	@Id@GeneratedValue
	private int bookId;
	private String bookName;
	private String bookImage;
	private String bookAuthor;
	private String bookSubject;
	private int bookPublishingYear;
	private String bookStatus;
	
	@ManyToOne
	private StudentDetails studentDetails;
	
	@ManyToOne
	private FacultyDetails facultyDetails;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookSubject() {
		return bookSubject;
	}

	public void setBookSubject(String bookSubject) {
		this.bookSubject = bookSubject;
	}

	public int getBookPublishingYear() {
		return bookPublishingYear;
	}

	public void setBookPublishingYear(int bookPublishingYear) {
		this.bookPublishingYear = bookPublishingYear;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public StudentDetails getStudentDetails() {
		return studentDetails;
	}

	public void setStudentDetails(StudentDetails studentDetails) {
		this.studentDetails = studentDetails;
	}

	public FacultyDetails getFacultyDetails() {
		return facultyDetails;
	}

	public void setFacultyDetails(FacultyDetails facultyDetails) {
		this.facultyDetails = facultyDetails;
	}

	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookName=" + bookName + ", bookImage=" + bookImage + ", bookAuthor="
				+ bookAuthor + ", bookSubject=" + bookSubject + ", bookPublishingYear=" + bookPublishingYear
				+ ", bookStatus=" + bookStatus + ", studentDetails=" + studentDetails + ", facultyDetails="
				+ facultyDetails + "]";
	}
	
	

}
